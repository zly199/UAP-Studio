package nc.uap.portal.freemarker.model;

import nc.uap.portal.freemarker.PartitionScanner;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.source.ISourceViewer;


public class ItemFactory {

	public static Item getItem (ITypedRegion region, ISourceViewer viewer, IResource resource) {
		if (null == region) return null;
		else {
			Item directive = null;
			if (region.getType().equals(PartitionScanner.FTL_IF_DIRECTIVE_START))
				directive = new IfDirective();
			else if (region.getType().equals(PartitionScanner.FTL_IF_DIRECTIVE_END))
				directive = new IfEndDirective();
			else if (region.getType().equals(PartitionScanner.FTL_IF_ELSE_DIRECTIVE))
				directive = new IfElseDirective();
			else if (region.getType().equals(PartitionScanner.FTL_ELSE_IF_DIRECTIVE))
				directive = new ElseIfDirective();
			else if (region.getType().equals(PartitionScanner.FTL_LIST_DIRECTIVE_START))
				directive = new ListDirective();
			else if (region.getType().equals(PartitionScanner.FTL_LIST_DIRECTIVE_END))
				directive = new ListEndDirective();
			else if (region.getType().equals(PartitionScanner.FTL_FUNCTION_DIRECTIVE_START))
				directive = new FunctionDirective();
			else if (region.getType().equals(PartitionScanner.FTL_FUNCTION_DIRECTIVE_END))
				directive = new FunctionEndDirective();
			else if (region.getType().equals(PartitionScanner.FTL_MACRO_DIRECTIVE_START))
				directive = new MacroDirective();
			else if (region.getType().equals(PartitionScanner.FTL_MACRO_DIRECTIVE_END))
				directive = new MacroEndDirective();
			else if (region.getType().equals(PartitionScanner.FTL_MACRO_INSTANCE_START))
				directive = new MacroInstance();
			else if (region.getType().equals(PartitionScanner.FTL_MACRO_INSTANCE_END))
				directive = new MacroEndInstance();
			else if (region.getType().equals(PartitionScanner.FTL_INCLUDE))
				directive = new GenericDirective("include.png");
			else if (region.getType().equals(PartitionScanner.FTL_IMPORT))
				directive = new GenericDirective("import.png");
			else if (region.getType().equals(PartitionScanner.FTL_ASSIGN)
					|| region.getType().equals(PartitionScanner.FTL_LOCAL)
					|| region.getType().equals(PartitionScanner.FTL_GLOBAL))
				directive = new AssignmentDirective(region.getType());
			else if (region.getType().equals(PartitionScanner.FTL_ASSIGN_END)
					|| region.getType().equals(PartitionScanner.FTL_LOCAL_END)
					|| region.getType().equals(PartitionScanner.FTL_GLOBAL_END))
				directive = new AssignmentEndDirective(region.getType());
			else if (region.getType().equals(PartitionScanner.FTL_BREAK))
				directive = new GenericDirective("break.png");
			else if (region.getType().equals(PartitionScanner.FTL_STOP))
				directive = new GenericDirective("stop.png");
			else if (region.getType().equals(PartitionScanner.FTL_RETURN))
				directive = new GenericDirective("return.png");
			else if (region.getType().equals(PartitionScanner.FTL_SWITCH_DIRECTIVE_START))
				directive = new GenericNestableDirective("switch", "switch.png");
			else if (region.getType().equals(PartitionScanner.FTL_SWITCH_DIRECTIVE_END))
				directive = new GenericNestableEndDirective("switch");
			else if (region.getType().equals(PartitionScanner.FTL_CASE_DIRECTIVE_START))
				directive = new CaseDirective();
			else if (region.getType().equals(PartitionScanner.FTL_CASE_DEFAULT_START))
				directive = new CaseDefaultDirective();
			else if (region.getType().equals(PartitionScanner.FTL_INTERPOLATION))
				directive = new Interpolation();
			else if (region.getType().equals(PartitionScanner.FTL_FTL_DIRECTIVE))
				directive = new FtlDirective();
			else if (region.getType().equals(PartitionScanner.FTL_DIRECTIVE)) {
				String name = getDirectiveName(region, viewer);
				directive = new GenericNestableDirective(name, "element.png");
			}
			else if (region.getType().equals(PartitionScanner.FTL_DIRECTIVE_END)) {
				String name = getDirectiveName(region, viewer);
				directive = new GenericNestableEndDirective(name);
			}

			if (null != directive) directive.load(region, viewer, resource);
			return directive;
		}
	}

	private static String getDirectiveName (ITypedRegion region, ISourceViewer viewer) {
		StringBuffer sb = new StringBuffer();
		try {
			int offset = region.getOffset();
			int stopIndex = offset + region.getLength();
			char c = viewer.getDocument().getChar(offset);
			while (c != ' ' && c != '>' && offset <= stopIndex) {
				if (c != '<' && c != '#' && c != '/')
					sb.append(c);
				c = viewer.getDocument().getChar(++offset);
			}
			return sb.toString();
		}
		catch (BadLocationException e) {}
		return sb.toString();
	}
}