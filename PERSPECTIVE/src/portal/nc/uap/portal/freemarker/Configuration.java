package nc.uap.portal.freemarker;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.hyperlink.IHyperlinkDetector;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.source.IAnnotationHover;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.ui.editors.text.TextSourceViewerConfiguration;


public class Configuration extends TextSourceViewerConfiguration {
	private ColorManager colorManager;
	private XMLTagScanner xmlTagScanner;
	private DirectiveScanner directiveScanner;
	private Editor editor;

	public Configuration(IPreferenceStore preferenceStore, ColorManager colorManager, Editor editor) {
		super(preferenceStore);
		this.editor = editor;
		this.colorManager = colorManager;
	}
	public String[] getConfiguredContentTypes(ISourceViewer sourceViewer) {
		return PartitionScanner.PARTITIONS;
	}


	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
		PresentationReconciler reconciler = new PresentationReconciler();

		IToken defaultToken = null;
		DefaultDamagerRepairer dr = null;
		NonRuleBasedDamagerRepairer ndr = null;

		defaultToken = new Token(
				new TextAttribute(
					colorManager.getColorFromPreference(ColorManager.COLOR_DIRECTIVE)));
		ContentScanner contentScanner = new ContentScanner(defaultToken, colorManager);
				
		for (int i=0; i<PartitionScanner.DIRECTIVES.length; i++) {
			dr = new DefaultDamagerRepairer(contentScanner);
			reconciler.setDamager(dr, PartitionScanner.DIRECTIVES[i]);
			reconciler.setRepairer(dr, PartitionScanner.DIRECTIVES[i]);
		}
		dr = new DefaultDamagerRepairer(contentScanner);
		reconciler.setDamager(dr, PartitionScanner.FTL_DIRECTIVE);
		reconciler.setRepairer(dr, PartitionScanner.FTL_DIRECTIVE);
		dr = new DefaultDamagerRepairer(contentScanner);
		reconciler.setDamager(dr, PartitionScanner.FTL_DIRECTIVE_END);
		reconciler.setRepairer(dr, PartitionScanner.FTL_DIRECTIVE_END);

		ndr =
			new NonRuleBasedDamagerRepairer(
				new TextAttribute(
					colorManager.getColorFromPreference(ColorManager.COLOR_XML_COMMENT)));
		reconciler.setDamager(ndr, PartitionScanner.XML_COMMENT);
		reconciler.setRepairer(ndr, PartitionScanner.XML_COMMENT);

		ndr =
			new NonRuleBasedDamagerRepairer(
				new TextAttribute(
					colorManager.getColorFromPreference(ColorManager.COLOR_STRING)));
		reconciler.setDamager(ndr, PartitionScanner.STRING);
		reconciler.setRepairer(ndr, PartitionScanner.STRING);

		ndr =
			new NonRuleBasedDamagerRepairer(
				new TextAttribute(
					colorManager.getColorFromPreference(ColorManager.COLOR_COMMENT)));
		reconciler.setDamager(ndr, PartitionScanner.FTL_COMMENT);
		reconciler.setRepairer(ndr, PartitionScanner.FTL_COMMENT);

		defaultToken = new Token(
				new TextAttribute(
					colorManager.getColorFromPreference(ColorManager.COLOR_INTERPOLATION)));
		dr = new DefaultDamagerRepairer(new ContentScanner(defaultToken, colorManager));
		reconciler.setDamager(dr, PartitionScanner.FTL_INTERPOLATION);
		reconciler.setRepairer(dr, PartitionScanner.FTL_INTERPOLATION);
		
		defaultToken = new Token(
				new TextAttribute(
					colorManager.getColorFromPreference(ColorManager.COLOR_XML_TAG)));
		dr = new DefaultDamagerRepairer(new ContentScanner(defaultToken, colorManager));
		reconciler.setDamager(dr, PartitionScanner.XML_TAG);
		reconciler.setRepairer(dr, PartitionScanner.XML_TAG);

		return reconciler;
	}

    public IContentAssistant getContentAssistant(ISourceViewer aSourceViewer)
    {
        ContentAssistant assistant = new ContentAssistant();
        CompletionProcessor completionProcessor = new CompletionProcessor(editor);
        assistant.setContentAssistProcessor(completionProcessor, IDocument.DEFAULT_CONTENT_TYPE);
        for (int i=0; i<PartitionScanner.DIRECTIVES.length; i++) {
        	assistant.setContentAssistProcessor(completionProcessor, PartitionScanner.DIRECTIVES[i]);
        }
        assistant.setContentAssistProcessor(completionProcessor, PartitionScanner.FTL_DIRECTIVE);
        assistant.setContentAssistProcessor(completionProcessor, PartitionScanner.FTL_DIRECTIVE_END);
        assistant.setContentAssistProcessor(completionProcessor, PartitionScanner.FTL_COMMENT);
        assistant.setContentAssistProcessor(completionProcessor, PartitionScanner.FTL_INTERPOLATION);
        assistant.setContentAssistProcessor(completionProcessor, PartitionScanner.XML_COMMENT);
        assistant.setContentAssistProcessor(completionProcessor, PartitionScanner.XML_TAG);
        assistant.enableAutoInsert(true);
        assistant.enableAutoActivation(true);
        return assistant;
    }
    
	public IAnnotationHover getAnnotationHover(ISourceViewer sourceViewer) {
		return new AnnotationHover();
	}

	public IHyperlinkDetector[] getHyperlinkDetectors(ISourceViewer sourceViewer) {
		IHyperlinkDetector[] detectors = super.getHyperlinkDetectors(sourceViewer);
		if (null == detectors) detectors = new IHyperlinkDetector[0];
		IHyperlinkDetector[] detectorsNew = new IHyperlinkDetector[detectors.length+1];
		System.arraycopy(detectors, 0, detectorsNew, 0, detectors.length);
		detectorsNew[detectorsNew.length-1] = new MacroHyperlinkDetector(sourceViewer, editor);
		return detectorsNew;
	}
}