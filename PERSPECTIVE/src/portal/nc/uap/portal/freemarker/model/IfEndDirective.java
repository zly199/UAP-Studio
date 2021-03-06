package nc.uap.portal.freemarker.model;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.source.ISourceViewer;

public class IfEndDirective extends AbstractDirective {

	private IfDirective ifDirective;

	protected void init(ITypedRegion region, ISourceViewer viewer, IResource resource) throws Exception {
	}

	public boolean isEndItem() {
		return true;
	}

	public void relateItem(Item directive) {
		if (directive instanceof IfDirective)
			ifDirective = (IfDirective) directive;
		else if (null == ifDirective) {
			if (directive instanceof ElseIfDirective) ifDirective = ((ElseIfDirective) directive).getIfDirective();
			if (directive instanceof IfElseDirective) ifDirective = ((IfElseDirective) directive).getIfDirective();
			if (directive instanceof IfEndDirective) ifDirective = ((IfEndDirective) directive).getIfDirective();
		}
	}

	public boolean relatesToItem(Item directive) {
		return (directive instanceof IfDirective
				|| directive instanceof IfElseDirective
				|| directive instanceof ElseIfDirective
				|| directive instanceof IfEndDirective);
	}

	public IfDirective getIfDirective() {
		return ifDirective;
	}

	public Item[] getRelatedItems() {
		return (null == getIfDirective()) ?
				null : getIfDirective().getRelatedItems();
	}

	public Item getStartItem () {
		return getIfDirective();
	}
}