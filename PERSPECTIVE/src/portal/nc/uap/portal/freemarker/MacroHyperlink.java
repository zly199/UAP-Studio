package nc.uap.portal.freemarker;

import nc.uap.portal.freemarker.configuration.MacroLibrary;
import nc.uap.portal.freemarker.model.LibraryMacroDirective;
import nc.uap.portal.freemarker.model.MacroDirective;
import nc.uap.portal.freemarker.model.MacroInstance;
import nc.uap.portal.perspective.PortalPlugin;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.jface.text.hyperlink.URLHyperlink;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.browser.IWebBrowser;
import org.eclipse.ui.browser.IWorkbenchBrowserSupport;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.ITextEditor;

public class MacroHyperlink  implements IHyperlink {
	
	private MacroInstance macroInstance;
	private IFile file;
	private int offset;
	private int length;

	public MacroHyperlink(MacroInstance macroInstance, IFile file, int offset, int length) {
		this.macroInstance = macroInstance;
		this.file = file;
		this.offset = offset;
		this.length = length;
	}

	public void open() {
		String editorId = "hudson.freemarker_ide.editor.FreemarkerEditor";
		try {
			IEditorPart editorPart = PortalPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.openEditor(new FileEditorInput(file), "hudson.freemarker_ide.editor.FreemarkerEditor");
			if (offset >= 0 && length > 0 && editorPart instanceof FreemarkerMultiPageEditor) {
				((FreemarkerMultiPageEditor) editorPart).selectAndReveal(offset, length);
			}
		}
		catch (PartInitException e) {
			PortalPlugin.getDefault().logError(e.getMessage(), e);
		}
	}

	public IRegion getHyperlinkRegion() {
		return macroInstance.getRegion();
	}

	public String getHyperlinkText() {
		return macroInstance.getName();
	}

	public String getTypeLabel() {
		return "Macro Definition";
	}
}