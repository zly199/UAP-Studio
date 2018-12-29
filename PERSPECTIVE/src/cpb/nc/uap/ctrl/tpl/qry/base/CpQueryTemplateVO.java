/***************************************************************\
 *     The skeleton of this class is generated by an automatic *
 * code generator for NC product. It is based on Velocity.     *
\***************************************************************/
package nc.uap.ctrl.tpl.qry.base;
	
import nc.uap.ctrl.tpl.qry.meta.ConditionVO;
import nc.vo.pub.SuperVO;

/**
 * <b> 在此处简要描述此类的功能 </b>
 * <p>
 *     在此处添加此类的描述信息
 * </p>
 * 创建日期:
 * @author 
 * @version NCPrj ??
 */
@SuppressWarnings("serial")
public class CpQueryTemplateVO extends SuperVO {
	private java.lang.String pk_query_template;
	private java.lang.String pkcorp;
	private java.lang.String modelcode;
	private java.lang.String modelname;
	private java.lang.String nodecode;
	private java.lang.String description;
	private java.lang.String fixcondition;
	private java.lang.String resid;
	private java.lang.String metaclass;
	private java.lang.String parentid;
	private java.lang.String fixquerytree;
	private java.lang.Integer dr = 0;
	private nc.vo.pub.lang.UFDateTime ts;
	private java.lang.String  nodekey;
	private ConditionVO[] fixConditionVOs;
	private java.lang.String modelname2;
	private java.lang.String modelname3;
	private java.lang.String modelname4;
	private java.lang.String modelname5;
	private java.lang.String modelname6;
	private nc.vo.pub.lang.UFBoolean ifdisplay;
	private nc.vo.pub.lang.UFBoolean issys;
	private java.lang.String pk_org;
	private java.lang.String pk_group;
	//扩展字段
	private java.lang.String item1;
	private java.lang.String item2;
	private java.lang.String item3;
	private java.lang.String item4;
	private java.lang.String item5;
	private java.lang.String item6;
	private java.lang.String item7;
	private java.lang.String item8;
	private java.lang.String item9;	
	
	public static final String PK_QUERY_TEMPLATE = "pk_query_template";
	public static final String PKCORP = "pkcorp";
	public static final String MODELCODE = "modelcode";
	public static final String MODELNAME = "modelname";
	public static final String MODELNAME2 = "modelname2";
	public static final String MODELNAME3 = "modelname3";
	public static final String MODELNAME4 = "modelname4";
	public static final String MODELNAME5 = "modelname5";
	public static final String MODELNAME6 = "modelname6";
	public static final String IFDISPLAY = "ifdisplay";
	public static final String NODECODE = "nodecode";
	public static final String NODEKEY = "nodekey";
	public static final String DESCRIPTION = "description";
	public static final String FIXCONDITION = "fixcondition";
	public static final String RESID = "resid";
	public static final String METACLASS = "metaclass";
	public static final String PARENTID = "parentid";
	public static final String FIXQUERYTREE = "fixquerytree";
	public static final String ISSYS = "issys";
	public static final String PK_ORG = "pk_org";
	public static final String PK_GROUP = "pk_group";
	public static final String ITEM1 = "item1";
	public static final String ITEM2 = "item2";
	public static final String ITEM3 = "item3";
	public static final String ITEM4 = "item4";
	public static final String ITEM5 = "item5";
	public static final String ITEM6 = "item6";
	public static final String ITEM7 = "item7";
	public static final String ITEM8 = "item8";
	public static final String ITEM9 = "item9";
	
	public java.lang.String getNodekey() {
		return nodekey;
	}
	public void setNodekey(java.lang.String nodekey) {
		this.nodekey = nodekey;
	}
	public java.lang.String getModelname2() {
		return modelname2;
	}
	public void setModelname2(java.lang.String modelname2) {
		this.modelname2 = modelname2;
	}
	public java.lang.String getModelname3() {
		return modelname3;
	}
	public void setModelname3(java.lang.String modelname3) {
		this.modelname3 = modelname3;
	}
	public java.lang.String getModelname4() {
		return modelname4;
	}
	public void setModelname4(java.lang.String modelname4) {
		this.modelname4 = modelname4;
	}
	public java.lang.String getModelname5() {
		return modelname5;
	}
	public void setModelname5(java.lang.String modelname5) {
		this.modelname5 = modelname5;
	}
	public java.lang.String getModelname6() {
		return modelname6;
	}
	public void setModelname6(java.lang.String modelname6) {
		this.modelname6 = modelname6;
	}
	public nc.vo.pub.lang.UFBoolean getIfdisplay() {
		return ifdisplay;
	}
	public void setIfdisplay(nc.vo.pub.lang.UFBoolean ifdisplay) {
		this.ifdisplay = ifdisplay;
	}
	
	public java.lang.String getPk_org() {
		return pk_org;
	}
	public void setPk_org(java.lang.String pk_org) {
		this.pk_org = pk_org;
	}
	public java.lang.String getPk_group() {
		return pk_group;
	}
	public void setPk_group(java.lang.String pk_group) {
		this.pk_group = pk_group;
	}
	public java.lang.String getItem1() {
		return item1;
	}
	public void setItem1(java.lang.String item1) {
		this.item1 = item1;
	}
	public java.lang.String getItem2() {
		return item2;
	}
	public void setItem2(java.lang.String item2) {
		this.item2 = item2;
	}
	public java.lang.String getItem3() {
		return item3;
	}
	public void setItem3(java.lang.String item3) {
		this.item3 = item3;
	}
	public java.lang.String getItem4() {
		return item4;
	}
	public void setItem4(java.lang.String item4) {
		this.item4 = item4;
	}
	public java.lang.String getItem5() {
		return item5;
	}
	public void setItem5(java.lang.String item5) {
		this.item5 = item5;
	}
	public java.lang.String getItem6() {
		return item6;
	}
	public void setItem6(java.lang.String item6) {
		this.item6 = item6;
	}
	public java.lang.String getItem7() {
		return item7;
	}
	public void setItem7(java.lang.String item7) {
		this.item7 = item7;
	}
	public java.lang.String getItem8() {
		return item8;
	}
	public void setItem8(java.lang.String item8) {
		this.item8 = item8;
	}
	public java.lang.String getItem9() {
		return item9;
	}
	public void setItem9(java.lang.String item9) {
		this.item9 = item9;
	}
	/**
	 * 属性pk_query_template的Getter方法.
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getPk_query_template () {
		return pk_query_template;
	}   
	/**
	 * 属性pk_query_template的Setter方法.
	 * 创建日期:
	 * @param newPk_query_template java.lang.String
	 */
	public void setPk_query_template (java.lang.String newPk_query_template ) {
	 	this.pk_query_template = newPk_query_template;
	} 	  
	/**
	 * 属性pkcorp的Getter方法.
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getPkcorp () {
		return pkcorp;
	}   
	/**
	 * 属性pkcorp的Setter方法.
	 * 创建日期:
	 * @param newPkcorp java.lang.String
	 */
	public void setPkcorp (java.lang.String newPkcorp ) {
	 	this.pkcorp = newPkcorp;
	} 	  
	/**
	 * 属性modelcode的Getter方法.
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getModelcode () {
		return modelcode;
	}   
	/**
	 * 属性modelcode的Setter方法.
	 * 创建日期:
	 * @param newModelcode java.lang.String
	 */
	public void setModelcode (java.lang.String newModelcode ) {
	 	this.modelcode = newModelcode;
	} 	  
	/**
	 * 属性modelname的Getter方法.
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getModelname () {
		return modelname;
	}   
	/**
	 * 属性modelname的Setter方法.
	 * 创建日期:
	 * @param newModelname java.lang.String
	 */
	public void setModelname (java.lang.String newModelname ) {
	 	this.modelname = newModelname;
	} 	  
	/**
	 * 属性nodecode的Getter方法.
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getNodecode () {
		return nodecode;
	}   
	/**
	 * 属性nodecode的Setter方法.
	 * 创建日期:
	 * @param newNodecode java.lang.String
	 */
	public void setNodecode (java.lang.String newNodecode ) {
	 	this.nodecode = newNodecode;
	} 	  
	/**
	 * 属性description的Getter方法.
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getDescription () {
		return description;
	}   
	/**
	 * 属性description的Setter方法.
	 * 创建日期:
	 * @param newDescription java.lang.String
	 */
	public void setDescription (java.lang.String newDescription ) {
	 	this.description = newDescription;
	} 	  
	/**
	 * 属性fixcondition的Getter方法.
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getFixcondition () {
		return fixcondition;
	}   
	
	/**
	 * 此处插入方法说明. 创建日期:(2003-10-27 13:17:50)
	 * 
	 * @return java.lang.String
	 */
	public ConditionVO[] getFixConditions() {
		if (fixConditionVOs == null && fixcondition != null)
			fixConditionVOs = ConditionVO.parseString(fixcondition);
		return fixConditionVOs;
	}
	
	/**
	 * 属性fixcondition的Setter方法.
	 * 创建日期:
	 * @param newFixcondition java.lang.String
	 */
	public void setFixcondition (java.lang.String newFixcondition ) {
	 	this.fixcondition = newFixcondition;
	} 	  
	/**
	 * 属性resid的Getter方法.
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getResid () {
		return resid;
	}   
	/**
	 * 属性resid的Setter方法.
	 * 创建日期:
	 * @param newResid java.lang.String
	 */
	public void setResid (java.lang.String newResid ) {
	 	this.resid = newResid;
	} 	  
	/**
	 * 属性metaclass的Getter方法.
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getMetaclass () {
		return metaclass;
	}   
	/**
	 * 属性metaclass的Setter方法.
	 * 创建日期:
	 * @param newMetaclass java.lang.String
	 */
	public void setMetaclass (java.lang.String newMetaclass ) {
	 	this.metaclass = newMetaclass;
	} 	  
	/**
	 * 属性parentid的Getter方法.
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getParentid () {
		return parentid;
	}   
	/**
	 * 属性parentid的Setter方法.
	 * 创建日期:
	 * @param newParentid java.lang.String
	 */
	public void setParentid (java.lang.String newParentid ) {
	 	this.parentid = newParentid;
	} 	  
	/**
	 * 属性fixquerytree的Getter方法.
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getFixquerytree () {
		return fixquerytree;
	}   
	/**
	 * 属性fixquerytree的Setter方法.
	 * 创建日期:
	 * @param newFixquerytree java.lang.String
	 */
	public void setFixquerytree (java.lang.String newFixquerytree ) {
	 	this.fixquerytree = newFixquerytree;
	} 	  
	/**
	 * 属性dr的Getter方法.
	 * 创建日期:
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getDr () {
		return dr;
	}   
	/**
	 * 属性dr的Setter方法.
	 * 创建日期:
	 * @param newDr java.lang.Integer
	 */
	public void setDr (java.lang.Integer newDr ) {
	 	this.dr = newDr;
	} 	  
	/**
	 * 属性ts的Getter方法.
	 * 创建日期:
	 * @return nc.vo.pub.lang.UFDateTime
	 */
	public nc.vo.pub.lang.UFDateTime getTs () {
		return ts;
	}   
	/**
	 * 属性ts的Setter方法.
	 * 创建日期:
	 * @param newTs nc.vo.pub.lang.UFDateTime
	 */
	public void setTs (nc.vo.pub.lang.UFDateTime newTs ) {
	 	this.ts = newTs;
	} 	  
 
	/**
	  * <p>取得父VO主键字段.
	  * <p>
	  * 创建日期:
	  * @return java.lang.String
	  */
	public java.lang.String getParentPKFieldName() {
	    return null;
	}   
    
	/**
	  * <p>取得表主键.
	  * <p>
	  * 创建日期:
	  * @return java.lang.String
	  */
	public java.lang.String getPKFieldName() {
	  return "pk_query_template";
	}
    
	/**
	 * <p>返回表名称.
	 * <p>
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getTableName() {
		return "cp_query_template";
	}    
	
	/**
	 * <p>返回表名称.
	 * <p>
	 * 创建日期:
	 * @return java.lang.String
	 */
	public static java.lang.String getDefaultTableName() {
		return "cp_query_template";
	}    
    
    /**
	  * 按照默认方式创建构造子.
	  *
	  * 创建日期:
	  */
     public CpQueryTemplateVO() {
		super();	
	}
     
     /**
 	 * 是否是元数据生成的
 	 */
 	public boolean isMetadata() {
 		return getMetaclass() != null && getMetaclass().trim().length() != 0;
 	}
	public void setIssys(nc.vo.pub.lang.UFBoolean issys) {
		this.issys = issys;
	}
	public nc.vo.pub.lang.UFBoolean getIssys() {
		return issys;
	}
} 


