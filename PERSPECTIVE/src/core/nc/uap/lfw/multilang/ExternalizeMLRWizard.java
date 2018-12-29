package nc.uap.lfw.multilang;

import java.util.List;

import nc.lfw.editor.common.tools.LFWPersTool;
import nc.uap.lfw.lang.M_multilang;
import nc.uap.lfw.wizard.ExternalizeMLRWizardPage2;

import org.eclipse.ltk.core.refactoring.Refactoring;
import org.eclipse.ltk.ui.refactoring.RefactoringWizard;
import org.eclipse.ltk.ui.refactoring.RefactoringWizardPage;

public class ExternalizeMLRWizard extends RefactoringWizard{
	
	private ExternalizeMLRWizardPage page1;

	public ExternalizeMLRWizard(Refactoring refactoring) {
		super(refactoring, 3);
//		page1 = null;
		page1 = null;
	}

	@Override
	protected void addUserInputPages() {
		MLRRefactoring refactoring = (MLRRefactoring)getRefactoring();
		page1 = new ExternalizeMLRWizardPage(refactoring);
		page1.setMessage(M_multilang.ExternalizeMLRWizard_0);
//		addPage(page1);
		addPage(page1);
	}
	@Override
	public boolean canFinish(){
//		if (page1.equals(getContainer().getCurrentPage())){
//			page1.updateTableViewer();
//		}
		return super.canFinish();
	}

	@Override
	public boolean performFinish(){
		List<String> modifyFilePath = page1.getMlrRefactoring().getModifyFilePath();
		if(modifyFilePath!=null&&modifyFilePath.size()>0){
			for(String path:modifyFilePath){
				LFWPersTool.checkOutFile(path);
			}
		}
	    return super.performFinish();
	}

}
