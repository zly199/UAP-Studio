/***************************************************************\
 *     The skeleton of this class is generated by an automatic *
 * code generator for NC product. It is based on Velocity.     *
\***************************************************************/
package nc.uap.ctrl.tpl.print.base;
	
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
public class CpPrintConditionVO extends SuperVO {
	private java.lang.String pk_varcondition;
	private java.lang.String pkcorp;
	private java.lang.Integer datatype;
	private nc.vo.pub.lang.UFBoolean userdefflag;
	private java.lang.String tabcode;
	private java.lang.String resid;
	private java.lang.String langdir;
	private java.lang.String pk_print_template;
	private java.lang.String varexpress;
	private java.lang.String varname;
	private java.lang.String tablename;
	private java.lang.String tabletype;
	private java.lang.String vartype;
	private java.lang.String consultcode;
	private java.lang.Integer dr = 0;
	private nc.vo.pub.lang.UFDateTime ts;
	private nc.vo.pub.lang.UFBoolean issys;
	private nc.vo.pub.lang.UFBoolean if_md_define;
	private java.lang.String metaclass;
	private java.lang.String formula;
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
	
	public static final String PK_VARCONDITION = "pk_varcondition";
	public static final String PKCORP = "pkcorp";
	public static final String DATATYPE = "datatype";
	public static final String USERDEFFLAG = "userdefflag";
	public static final String TABCODE = "tabcode";
	public static final String RESID = "resid";
	public static final String LANGDIR = "langdir";
	public static final String PK_PRINT_TEMPLATE = "pk_print_template";
	public static final String VAREXPRESS = "varexpress";
	public static final String VARNAME = "varname";
	public static final String TABLENAME = "tablename";
	public static final String TABLETYPE = "tabletype";
	public static final String VARTYPE = "vartype";
	public static final String ISSYS = "issys";
	public static final String CONSULTCONDE = "consultcode";
	public static final String IF_MD_DEFINE = "if_md_define";
	public static final String METACLASS = "metaclass";
	public static final String FORMULA = "formula";
	public static final String ITEM1 = "item1";
	public static final String ITEM2 = "item2";
	public static final String ITEM3 = "item3";
	public static final String ITEM4 = "item4";
	public static final String ITEM5 = "item5";
	public static final String ITEM6 = "item6";
	public static final String ITEM7 = "item7";
	public static final String ITEM8 = "item8";
	public static final String ITEM9 = "item9";
	
			
	/**
	 * 属性pk_varcondition的Getter方法.属性名：主键ID
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getPk_varcondition () {
		return pk_varcondition;
	}   
	/**
	 * 属性pk_varcondition的Setter方法.属性名：主键ID
	 * 创建日期:
	 * @param newPk_varcondition java.lang.String
	 */
	public void setPk_varcondition (java.lang.String newPk_varcondition ) {
	 	this.pk_varcondition = newPk_varcondition;
	} 	  
	/**
	 * 属性pkcorp的Getter方法.属性名：公司编码
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getPkcorp () {
		return pkcorp;
	}   
	/**
	 * 属性pkcorp的Setter方法.属性名：公司编码
	 * 创建日期:
	 * @param newPkcorp java.lang.String
	 */
	public void setPkcorp (java.lang.String newPkcorp ) {
	 	this.pkcorp = newPkcorp;
	} 	  
	/**
	 * 属性datatype的Getter方法.属性名：数据类型
	 * 创建日期:
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getDatatype () {
		return datatype;
	}   
	/**
	 * 属性datatype的Setter方法.属性名：数据类型
	 * 创建日期:
	 * @param newDatatype java.lang.Integer
	 */
	public void setDatatype (java.lang.Integer newDatatype ) {
	 	this.datatype = newDatatype;
	} 	  
	/**
	 * 属性userdefflag的Getter方法.属性名：自定义项标志
	 * 创建日期:
	 * @return nc.vo.pub.lang.UFBoolean
	 */
	public nc.vo.pub.lang.UFBoolean getUserdefflag () {
		return userdefflag;
	}   
	/**
	 * 属性userdefflag的Setter方法.属性名：自定义项标志
	 * 创建日期:
	 * @param newUserdefflag nc.vo.pub.lang.UFBoolean
	 */
	public void setUserdefflag (nc.vo.pub.lang.UFBoolean newUserdefflag ) {
	 	this.userdefflag = newUserdefflag;
	} 	  
	/**
	 * 属性tabcode的Getter方法.属性名：表编码
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getTabcode () {
		return tabcode;
	}   
	/**
	 * 属性tabcode的Setter方法.属性名：表编码
	 * 创建日期:
	 * @param newTabcode java.lang.String
	 */
	public void setTabcode (java.lang.String newTabcode ) {
	 	this.tabcode = newTabcode;
	} 	  
	/**
	 * 属性resid的Getter方法.属性名：资源ID
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getResid () {
		return resid;
	}   
	/**
	 * 属性resid的Setter方法.属性名：资源ID
	 * 创建日期:
	 * @param newResid java.lang.String
	 */
	public void setResid (java.lang.String newResid ) {
	 	this.resid = newResid;
	} 	  
	public java.lang.String getLangdir() {
		return langdir;
	}
	public void setLangdir(java.lang.String langdir) {
		this.langdir = langdir;
	}
	public java.lang.String getConsultcode() {
		return consultcode;
	}
	public void setConsultcode(java.lang.String consultcode) {
		this.consultcode = consultcode;
	}
	/**
	 * 属性pk_print_template的Getter方法.属性名：模板主键
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getPk_print_template () {
		return pk_print_template;
	}   
	/**
	 * 属性pk_print_template的Setter方法.属性名：模板主键
	 * 创建日期:
	 * @param newPk_print_template java.lang.String
	 */
	public void setPk_print_template (java.lang.String newPk_print_template ) {
	 	this.pk_print_template = newPk_print_template;
	} 	  
	/**
	 * 属性varexpress的Getter方法.属性名：变量表达式
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getVarexpress () {
		return varexpress;
	}   
	/**
	 * 属性varexpress的Setter方法.属性名：变量表达式
	 * 创建日期:
	 * @param newVarexpress java.lang.String
	 */
	public void setVarexpress (java.lang.String newVarexpress ) {
	 	this.varexpress = newVarexpress;
	} 	  
	/**
	 * 属性varname的Getter方法.属性名：变量名
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getVarname () {
		return varname;
	}   
	/**
	 * 属性varname的Setter方法.属性名：变量名
	 * 创建日期:
	 * @param newVarname java.lang.String
	 */
	public void setVarname (java.lang.String newVarname ) {
	 	this.varname = newVarname;
	} 	  
	/**
	 * 属性tablename的Getter方法.属性名：表名
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getTablename () {
		return tablename;
	}   
	/**
	 * 属性tablename的Setter方法.属性名：表名
	 * 创建日期:
	 * @param newTablename java.lang.String
	 */
	public void setTablename (java.lang.String newTablename ) {
	 	this.tablename = newTablename;
	} 	  
	/**
	 * 属性tabletype的Getter方法.属性名：主子表类型
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getTabletype () {
		return tabletype;
	}   
	/**
	 * 属性tabletype的Setter方法.属性名：主子表类型
	 * 创建日期:
	 * @param newTabletype java.lang.String
	 */
	public void setTabletype (java.lang.String newTabletype ) {
	 	this.tabletype = newTabletype;
	} 	  
	/**
	 * 属性vartype的Getter方法.属性名：变量类型
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getVartype () {
		return vartype;
	}   
	/**
	 * 属性vartype的Setter方法.属性名：变量类型
	 * 创建日期:
	 * @param newVartype java.lang.String
	 */
	public void setVartype (java.lang.String newVartype ) {
	 	this.vartype = newVartype;
	} 	  
	/**
	 * 属性dr的Getter方法.属性名：dr
	 * 创建日期:
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getDr () {
		return dr;
	}   
	/**
	 * 属性dr的Setter方法.属性名：dr
	 * 创建日期:
	 * @param newDr java.lang.Integer
	 */
	public void setDr (java.lang.Integer newDr ) {
	 	this.dr = newDr;
	} 	  
	/**
	 * 属性ts的Getter方法.属性名：ts
	 * 创建日期:
	 * @return nc.vo.pub.lang.UFDateTime
	 */
	public nc.vo.pub.lang.UFDateTime getTs () {
		return ts;
	}   
	/**
	 * 属性ts的Setter方法.属性名：ts
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
	  return "pk_varcondition";
	}
    
	/**
	 * <p>返回表名称.
	 * <p>
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getTableName() {
		return "cp_print_condition";
	}    
	
	/**
	 * <p>返回表名称.
	 * <p>
	 * 创建日期:
	 * @return java.lang.String
	 */
	public static java.lang.String getDefaultTableName() {
		return "cp_print_condition";
	}    
    
    /**
	  * 按照默认方式创建构造子.
	  *
	  * 创建日期:
	  */
     public CpPrintConditionVO() {
		super();	
	}
	public void setIssys(nc.vo.pub.lang.UFBoolean issys) {
		this.issys = issys;
	}
	public nc.vo.pub.lang.UFBoolean getIssys() {
		return issys;
	}   
	public nc.vo.pub.lang.UFBoolean getIf_md_define() {
		return if_md_define;
	}
	public void setIf_md_define(nc.vo.pub.lang.UFBoolean if_md_define) {
		this.if_md_define = if_md_define;
	}
	public java.lang.String getMetaclass() {
		return metaclass;
	}
	public void setMetaclass(java.lang.String metaclass) {
		this.metaclass = metaclass;
	}
	public java.lang.String getFormula() {
		return formula;
	}
	public void setFormula(java.lang.String formula) {
		this.formula = formula;
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
} 



