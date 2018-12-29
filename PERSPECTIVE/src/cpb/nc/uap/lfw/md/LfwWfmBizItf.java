package nc.uap.lfw.md;

import nc.vo.pub.lang.UFDateTime;

public interface LfwWfmBizItf {
	static final String ATTRIBUTE_BILLMAKEDATE = "billmakedate";
	
	static final String ATTRIBUTE_BILLMAKER = "billmaker";

	static final String ATTRIBUTE_BILLNO = "billno";

	static final String ATTRIBUTE_ORG = "billorg";
	
	static final String ATTRIBUTE_APPROVER = "approver";
	
	static final String ATTRIBUTE_APPROVEDATE = "approvedate";

	static final String ATTRIBUTE_FORMSTATE = "formstate";
	
	static final String ATTRIBUTE_FORMTITLE = "formtitle";
	
	static final String ATTRIBUTE_FORMINSPK = "forminspk";
	

	/**
	 * ����form���ݵ�״̬
	 * @return
	 */
	String getFormState();
	
	void setFormState(String formstate);
	
	
	/**
	 * ���ݱ���
	 * @return
	 */
	String getFormTitle();
	
	void setFormTitle(String formtitle);
	
	
	/**
	 * ��������
	 * @return
	 */
	String getFormInspk();
	
	void setFormInspk(String forminspk);
		
	
	/**
	 * �����Ƶ�����
	 * @return
	 */
	UFDateTime getBillMakeDate();
	
	/**
	 * ��д��������
	 * @return
	 */
	void setBillMakeDate(UFDateTime billmakedate);
	

	/**
	 * �����Ƶ���PK
	 * @return
	 */
	String getBillMaker();

	/**
	 * ����������PK
	 * @return
	 */
	String getApprover();

	/**
	 * ���ص��ݺ�
	 * @return
	 */
	String getBillNo();

	/**
	 * ���ز���PK
	 * @return
	 */
	String getBillOrg();

	/**
	 * ���ص��ݵ�����ʱ��
	 * @return
	 */
	UFDateTime getApproveDate();
//
	/**
	 * ��д���ݵ�����ʱ��
	 * @return
	 */
	void setApproveDate(UFDateTime approveDate);

	/**
	 * ��д����PK
	 * @return
	 */
	void setBillOrg(String billorg);

	/**
	 * ��д���ݵ�������
	 * @return
	 */
	void setApprover(String approver);

	/**
	 * ��д���ݺ�
	 * @return
	 */
	void setBillNo(String billNo);

	/**
	 * ��д���ݵ��Ƶ���
	 * @return
	 */
	void setBillMaker(String maker);

}