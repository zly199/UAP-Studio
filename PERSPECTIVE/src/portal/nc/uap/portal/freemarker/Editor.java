package nc.uap.portal.freemarker;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.Template;
import nc.uap.portal.freemarker.configuration.ConfigurationManager;
import nc.uap.portal.freemarker.model.Item;
import nc.uap.portal.freemarker.model.ItemSet;
import nc.uap.portal.freemarker.outline.OutlinePage;
import nc.uap.portal.freemarker.preferences.IPreferenceConstants;
import nc.uap.portal.perspective.PortalPlugin;

import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.jdt.internal.ui.javaeditor.JarEntryEditorInput;
import org.eclipse.jdt.internal.ui.text.JavaPairMatcher;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextListener;
import org.eclipse.jface.text.ITextViewerExtension2;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.TextEvent;
import org.eclipse.jface.text.TextPresentation;
import org.eclipse.jface.text.presentation.IPresentationRepairer;
import org.eclipse.jface.text.source.ICharacterPairMatcher;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.MatchingCharacterPainter;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.commands.KeyConfigurationEvent;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.texteditor.ContentAssistAction;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.eclipse.ui.texteditor.MarkerUtilities;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;


public class Editor extends TextEditor implements KeyListener, MouseListener {

	private OutlinePage fOutlinePage;
	private nc.uap.portal.freemarker.Configuration configuration;
	private ColorManager colorManager = new ColorManager();

	private ItemSet itemSet;
	private Item selectedItem;
	private Item[] relatedItems;
	private static final char[] VALIDATION_TOKENS = new char[]{'\"', '[', ']', ',', '.', '\n', '4'};
	private boolean readOnly = false;

	private boolean mouseDown = false;
	private boolean ctrlDown = false;
	private boolean shiftDown = false;

	public Editor() {
		super();
		configuration = new  nc.uap.portal.freemarker.Configuration(getPreferenceStore(), colorManager, this);
		setSourceViewerConfiguration(configuration);
		setDocumentProvider(new DocumentProvider());
	}
	public void dispose() {
		ConfigurationManager.getInstance(getProject()).reload();
		super.dispose();
		matchingCharacterPainter.dispose();
	}

	public Object getAdapter(Class aClass) {
	    Object adapter;
		if (aClass.equals(IContentOutlinePage.class)) {
			if (fOutlinePage == null) {
			    fOutlinePage = new OutlinePage(this);
				if (getEditorInput() != null) {
					fOutlinePage.setInput(getEditorInput());
				}
			}
			adapter = fOutlinePage;
		} else {
		    adapter = super.getAdapter(aClass);
		}
		return adapter;
	}

	protected static final char[] BRACKETS= {'{', '}', '(', ')', '[', ']', '<', '>' };
	private MatchingCharacterPainter matchingCharacterPainter;
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		 getSourceViewer().getTextWidget().addKeyListener(this);
		 getSourceViewer().getTextWidget().addMouseListener(this);
//		 matchingCharacterPainter = new MatchingCharacterPainter(
//				 getSourceViewer(),
//				 new JavaPairMatcher(BRACKETS));
//		((SourceViewer) getSourceViewer()).addPainter(matchingCharacterPainter);
	}

	protected void createActions() {
		super.createActions();
		// Add content assist propsal action
		ContentAssistAction action = new ContentAssistAction(
				PortalPlugin.getDefault().getResourceBundle(),
				"SkinEditor.ContentAssist", this);
		action.setActionDefinitionId(ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS);
		setAction("SkinEditor.ContentAssist", action);
		action.setEnabled(true);
	}

	protected void handleCursorPositionChanged() {
		super.handleCursorPositionChanged();
		if (!mouseDown) {
			int offset = getCaretOffset();
			Item item = getItemSet().getSelectedItem(offset);
			if (null == item && offset > 0) item = getItemSet().getSelectedItem(offset-1);
			if (PortalPlugin.getDefault().getPreferenceStore().getBoolean(
					IPreferenceConstants.HIGHLIGHT_RELATED_ITEMS)) {
				if (null != item && null != item.getRelatedItems() && item.getRelatedItems().length > 0) {
					highlightRelatedRegions(item.getRelatedItems(), item);
				}
				else {
					highlightRelatedRegions(null, item);
				}
			}
			if (null == item) {
				item = getItemSet().getContextItem(getCaretOffset());
			}
			if (null != fOutlinePage)
				fOutlinePage.update(item);
		}
	}
	public void mouseDoubleClick(MouseEvent e) {
	}
	public void mouseDown(MouseEvent e) {
		mouseDown = true;
	}
	public void mouseUp(MouseEvent e) {
		mouseDown = false;
		handleCursorPositionChanged();
	}

	public void select (Item item) {
		selectAndReveal(item.getRegion().getOffset(), item.getRegion().getLength());
	}

	public IDocument getDocument() {
		ISourceViewer viewer = getSourceViewer();
		if (viewer != null) {
			return viewer.getDocument();
		}
		return null;
	}

	public void addProblemMarker(String aMessage, int aLine) {
		IFile file = ((IFileEditorInput)getEditorInput()).getFile(); 
		try {
			Map attributes = new HashMap(5);
			attributes.put(IMarker.SEVERITY, Integer.valueOf(IMarker.SEVERITY_ERROR));
			attributes.put(IMarker.LINE_NUMBER, Integer.valueOf(aLine));
			attributes.put(IMarker.MESSAGE, aMessage);
			attributes.put(IMarker.TEXT, aMessage);
			MarkerUtilities.createMarker(file, attributes, IMarker.PROBLEM);
		} catch (Exception e) {
			
		}
	}

	private synchronized void highlightRelatedRegions (Item[] items, Item selectedItem) {
		if (null == items || items.length == 0) {
			if (null != relatedItems && relatedItems.length > 0) {
				for (int i=0; i<relatedItems.length; i++) {
					if (getDocument().getLength() >= relatedItems[i].getRegion().getOffset() + relatedItems[i].getRegion().getLength()) {
						if (null == this.selectedItem || !relatedItems[i].equals(this.selectedItem))
							resetRange(relatedItems[i].getRegion());
					}
				}
			}
			relatedItems = null;
		}
		if (null != relatedItems) {
			for (int i=0; i<relatedItems.length; i++) {
				if (getDocument().getLength() >= relatedItems[i].getRegion().getOffset() + relatedItems[i].getRegion().getLength()) {
					if (null == this.selectedItem || !relatedItems[i].equals(this.selectedItem))
						resetRange(relatedItems[i].getRegion());
				}
			}
		}
		if (null != items && items.length > 0) {
			for (int i=0; i<items.length; i++) {
				if (getDocument().getLength() >= items[i].getRegion().getOffset() + items[i].getRegion().getLength()
						&& !items[i].equals(selectedItem)) {
					ITypedRegion region = items[i].getRegion();
					getSourceViewer().getTextWidget().setStyleRange(
							new StyleRange(region.getOffset(),
									region.getLength(), null, 
									colorManager.getColorFromPreference(
											IPreferenceConstants.COLOR_RELATED_ITEM)));
				}
			}
		}
		relatedItems = items;
		this.selectedItem = selectedItem;
	}

	private void resetRange (ITypedRegion region) {
		if (getSourceViewer() instanceof ITextViewerExtension2)
			((ITextViewerExtension2) getSourceViewer()).invalidateTextPresentation(region.getOffset(), region.getLength());
		else
			getSourceViewer().invalidateTextPresentation();
	}

	public Item getSelectedItem (boolean allowFudge) {
		int caretOffset = getCaretOffset();
		Item item = getItemSet().getSelectedItem(getCaretOffset());
		if (null == item && caretOffset > 0) item = getItemSet().getSelectedItem(caretOffset - 1);
		return item;
	}

	public Item getSelectedItem () {
		return getItemSet().getSelectedItem(getCaretOffset());
	}

	public int getCaretOffset () {
		return getSourceViewer().getTextWidget().getCaretOffset();
	}

	private void clearCache () {
		this.itemSet = null;
	}

	public ItemSet getItemSet () {
		if (null == this.itemSet) {
			IResource resource = null;
			if (getEditorInput() instanceof IFileEditorInput) {
				resource = ((IFileEditorInput) getEditorInput()).getFile();
			}
			else if (getEditorInput() instanceof JarEntryEditorInput) {
				resource = null;
			}
			
			this.itemSet = new ItemSet(
					getSourceViewer(), resource);
		}
		return this.itemSet;
			
	}
	public OutlinePage getOutlinePage() {
		return fOutlinePage;
	}

	public void keyPressed(KeyEvent e) {
		if (e.keyCode == SWT.CTRL) {
			ctrlDown = true;
		}
		if (e.keyCode == SWT.SHIFT) {
			shiftDown = true;
		}
		if (e.keyCode == ']') {
			try {
				char c = getDocument().getChar(getCaretOffset());
				if (c == ']') {
					// remove this
					getDocument().replace(getCaretOffset(), 1, "");
				}
			}
			catch (BadLocationException e1) {}
		}
		else if (e.keyCode == '}') {
			try {
				char c = getDocument().getChar(getCaretOffset());
				if (c == '}') {
					// remove this
					getDocument().replace(getCaretOffset(), 1, "}");
				}
			}
			catch (BadLocationException e1) {}
		}
	}

	public void keyReleased(KeyEvent e) {
		if (e.keyCode == SWT.CTRL) {
			ctrlDown = false;
		}
		else if (e.keyCode == SWT.SHIFT) {
			shiftDown = false;
		}
		try {
			if (shiftDown && (e.keyCode == '3' || e.keyCode == '2')) {
				int offset = getCaretOffset();
				char c = getSourceViewer().getDocument().getChar(offset-2);
				if (c == '[' || c == '<') {
					// directive
					char endChar = Character.MIN_VALUE;
					if (c == '[') endChar = ']'; else endChar = '>';
					if (getSourceViewer().getDocument().getLength() > offset) {
						if (offset > 0) {
							for (int i=offset+1; i<getSourceViewer().getDocument().getLength(); i++) {
								char c2 = getSourceViewer().getDocument().getChar(i);
								if (i == endChar) return;
								else if (i == '\n') break;
							}
							getSourceViewer().getDocument().replace(offset, 0, new String(new char[]{endChar}));
						}
					}
					else {
						getSourceViewer().getDocument().replace(offset, 0, new String(new char[]{endChar}));
					}
				}
			}
			else if (shiftDown && e.keyCode == '[') {
				int offset = getCaretOffset();
				char c = getSourceViewer().getDocument().getChar(offset-2);
				if (c == '$') {
					// interpolation
					if (getSourceViewer().getDocument().getLength() > offset) {
						if (offset > 0) {
							for (int i=offset+1; i<getSourceViewer().getDocument().getLength(); i++) {
								char c2 = getSourceViewer().getDocument().getChar(i);
								if (i == '}') return;
								else if (i == '\n') break;
							}
							getSourceViewer().getDocument().replace(offset, 0, "}");
						}
					}
					else {
						getSourceViewer().getDocument().replace(offset, 0, "}");
					}
				}
			}
		}
		catch (BadLocationException exc) {
			// do nothing
		}

		boolean stale = false;
		if (e.keyCode == SWT.DEL || e.keyCode == SWT.BS) {
			stale = true;
		}
		else if (null != getSelectedItem(true)) {
			stale = true;
		}
		else {
			char c = (char) e.keyCode;
			for (int j=0; j<VALIDATION_TOKENS.length; j++) {
				if (c == VALIDATION_TOKENS[j]) {
					stale = true;
					break;
				}
			}
			if (ctrlDown && (e.keyCode == 'v' || e.keyCode == 'x')) {
				stale = true;
			}
		}
		if (stale) {
			int offset = getCaretOffset();
			Item item = getItemSet().getSelectedItem(offset);
			if (null == item && offset > 0) item = getItemSet().getSelectedItem(offset-1);
			if (PortalPlugin.getDefault().getPreferenceStore().getBoolean(
					IPreferenceConstants.HIGHLIGHT_RELATED_ITEMS)) {
				if (null != item && null != item.getRelatedItems() && item.getRelatedItems().length > 0) {
					highlightRelatedRegions(item.getRelatedItems(), item);
				}
				else {
					highlightRelatedRegions(null, item);
				}
			}
			clearCache();
			validateContents();
			if (null != fOutlinePage)
				fOutlinePage.update(getSelectedItem());
		}
	}

	private void showMessage (String text) {
		MessageDialog.openError(
				getSourceViewer().getTextWidget().getShell(),
				"message",
				text);
	}

	public static Validator VALIDATOR;
	public synchronized void validateContents () {
		if (null == VALIDATOR) {
			VALIDATOR = new Validator(this);
			VALIDATOR.start();
		}
	}

	public IProject getProject () {
		return ((IFileEditorInput) getEditorInput()).getFile().getProject();
	}

	public IFile getFile () {
		return (null != getEditorInput()) ? 
				((IFileEditorInput) getEditorInput()).getFile() : null;
	}

	private Configuration fmConfiguration;
	public class Validator extends Thread {
		Editor editor;
		public Validator (Editor editor) {
			this.editor = editor;
		}
		public void run () {
			try {
				if (null != getFile()) {
					if (null == fmConfiguration) {
						fmConfiguration = new Configuration();
						fmConfiguration.setTagSyntax(Configuration.AUTO_DETECT_TAG_SYNTAX); 
					}
					getFile().deleteMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
					String pageContents = getDocument().get();
					Reader reader = new StringReader(pageContents);
					new Template(getFile().getName(), reader, fmConfiguration);
					reader.close();
				}
			}
			catch (ParseException e) {
				if (e.getMessage() != null) {
					String errorStr = e.getMessage();
					int errorLine = 0;
					try {
						errorLine = e.getLineNumber();
						if (errorLine == 0) {
							// sometimes they forget to put it in
							int index = e.getMessage().indexOf("line: ");
							if (index > 0) {
								int index2 = e.getMessage().indexOf(" ", index+6);
								int index3 = e.getMessage().indexOf(",", index+6);
								if (index3 < index2 && index3 > 0) index2 = index3;
								String s = e.getMessage().substring(index+6, index2);
								try {
									errorLine = Integer.parseInt(s);
								}
								catch (Exception e2) {}
							}
						}
					} catch (NullPointerException npe) {
						errorLine = 0;
					}
					editor.addProblemMarker(errorStr, errorLine);
				}
			}
			catch (Exception e) {
				PortalPlugin.getDefault().logError(e.getMessage(), e);
			}
			finally {
				editor.VALIDATOR = null;
			}
		}
	}

	protected void editorSaved() {
		super.editorSaved();
		validateContents();
	}

	public boolean isEditorInputReadOnly() {
		return readOnly;
	}
	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}
}