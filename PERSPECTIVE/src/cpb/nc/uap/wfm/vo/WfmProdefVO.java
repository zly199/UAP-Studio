/***************************************************************\
 *     The skeleton of this class is generated by an automatic *
 * code generator for NC product. It is based on Velocity.     *
\***************************************************************/
package nc.uap.wfm.vo;
import nc.vo.pub.SuperVO;
import nc.vo.pub.lang.UFBoolean;
/**
 * <b> 在此处简要描述此类的功能 </b>
 * <p>
 * 在此处添加此类的描述信息
 * </p>
 * 创建日期:
 * 
 * @author
 * @version NCPrj ??
 */
@SuppressWarnings("serial") public class WfmProdefVO extends SuperVO {
	private java.lang.String flwtype;
	private java.lang.String pk_original;
	private java.lang.String id;
	private java.lang.String memo;
	private java.lang.String name;
	private java.lang.String name2;
	private java.lang.String name3;
	private java.lang.String name4;
	private java.lang.String name5;
	private java.lang.String name6;
	private java.lang.String pk_group;
	private java.lang.String pk_prodef;
	private java.lang.String pk_startfrm;
	private byte[] processxml;
	private java.lang.String serverclass;
	private java.lang.String version;
	private java.lang.String watchrolepks;
	private java.lang.Integer dr;
	private nc.vo.pub.lang.UFDateTime ts;
	private java.lang.String individual;
	/**
	 * 流程监控角色组名称
	 */
	private String watchrolenames;
	private UFBoolean isnotstartup;
	
	private java.lang.String enginename;
	private java.lang.String pk_refprodef;
	
	private java.lang.String pk_org;
	
	public static final String FLWTYPE = "flwtype";
	public static final String PK_ORIGINAL = "pk_original";
	public static final String ID = "id";
	public static final String MEMO = "memo";
	public static final String NAME2 = "name2";
	public static final String NAME3 = "name3";
	public static final String NAME4 = "name4";
	public static final String NAME5 = "name5";
	public static final String NAME6 = "name6";
	
	public static final String PK_GROUP = "pk_group";
	public static final String PK_PRODEF = "pk_prodef";
	public static final String PK_STARTFRM = "pk_startfrm";
	public static final String PROCESSXML = "processxml";
	public static final String SERVERCLASS = "serverclass";
	public static final String VERSION = "version";
	public static final String WATCHROLEPKS = "watchrolepks";
	
	
	public static final String ENGINENAME = "enginename";
	public static final String PK_REFPRODEF = "pk_refprodef";
	
	public static final String PK_ORG = "pk_org";
	
	
	private java.lang.String creator;
	private nc.vo.pub.lang.UFDateTime creationtime;
	private java.lang.String modifier;
	private nc.vo.pub.lang.UFDateTime modifiedtime;
	
	public static final String CREATOR = "creator";
	public static final String CREATIONTIME = "creationtime";
	public static final String MODIFIER = "modifier";
	public static final String MODIFIEDTIME = "modifiedtime";
	
	
	public java.lang.String getPk_org() {
		return pk_org;
	}
	public void setPk_org(java.lang.String pk_org) {
		this.pk_org = pk_org;
	}
	/**
	 * 属性creator的Getter方法. 创建日期:
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getCreator() {
		return creator;
	}
	/**
	 * 属性creator的Setter方法. 创建日期:
	 * 
	 * @param newCreator
	 *            java.lang.String
	 */
	public void setCreator(java.lang.String newCreator) {
		this.creator = newCreator;
	}
	/**
	 * 属性creationtime的Getter方法. 创建日期:
	 * 
	 * @return nc.vo.pub.lang.UFDateTime
	 */
	public nc.vo.pub.lang.UFDateTime getCreationtime() {
		return creationtime;
	}
	/**
	 * 属性creationtime的Setter方法. 创建日期:
	 * 
	 * @param newCreationtime
	 *            nc.vo.pub.lang.UFDateTime
	 */
	public void setCreationtime(nc.vo.pub.lang.UFDateTime newCreationtime) {
		this.creationtime = newCreationtime;
	}
	/**
	 * 属性modifier的Getter方法. 创建日期:
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getModifier() {
		return modifier;
	}
	/**
	 * 属性modifier的Setter方法. 创建日期:
	 * 
	 * @param newModifier
	 *            java.lang.String
	 */
	public void setModifier(java.lang.String newModifier) {
		this.modifier = newModifier;
	}
	/**
	 * 属性modifiedtime的Getter方法. 创建日期:
	 * 
	 * @return nc.vo.pub.lang.UFDateTime
	 */
	public nc.vo.pub.lang.UFDateTime getModifiedtime() {
		return modifiedtime;
	}
	/**
	 * 属性modifiedtime的Setter方法. 创建日期:
	 * 
	 * @param newModifiedtime
	 *            nc.vo.pub.lang.UFDateTime
	 */
	public void setModifiedtime(nc.vo.pub.lang.UFDateTime newModifiedtime) {
		this.modifiedtime = newModifiedtime;
	}
	
	
	
	
	
	
	
	public UFBoolean getIsnotstartup() {
		return isnotstartup;
	}
	public void setIsnotstartup(UFBoolean isnotstartup) {
		this.isnotstartup = isnotstartup;
	}
	/**
	 * 属性flwtype的Getter方法. 创建日期:
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getFlwtype() {
		return flwtype;
	}
	
	public java.lang.String getPk_original() {
		return pk_original;
	}
	public void setPk_original(java.lang.String pk_original) {
		this.pk_original = pk_original;
	}
	/**
	 * 属性flwtype的Setter方法. 创建日期:
	 * 
	 * @param newFlwtype
	 *            java.lang.String
	 */
	public void setFlwtype(java.lang.String newFlwtype) {
		this.flwtype = newFlwtype;
	}
	/**
	 * 属性id的Getter方法. 创建日期:
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getId() {
		return id;
	}
	/**
	 * 属性id的Setter方法. 创建日期:
	 * 
	 * @param newId
	 *            java.lang.String
	 */
	public void setId(java.lang.String newId) {
		this.id = newId;
	}
	/**
	 * 属性memo的Getter方法. 创建日期:
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getMemo() {
		return memo;
	}
	/**
	 * 属性memo的Setter方法. 创建日期:
	 * 
	 * @param newMemo
	 *            java.lang.String
	 */
	public void setMemo(java.lang.String newMemo) {
		this.memo = newMemo;
	}
	/**
	 * 属性name的Getter方法. 创建日期:
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getName() {
		return name;
	}
	/**
	 * 属性name的Setter方法. 创建日期:
	 * 
	 * @param newName
	 *            java.lang.String
	 */
	public void setName(java.lang.String newName) {
		this.name = newName;
	}
	/**
	 * 属性name的Getter方法. 创建日期:
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getName2() {
		return name2;
	}
	/**
	 * 属性name的Setter方法. 创建日期:
	 * 
	 * @param newName
	 *            java.lang.String
	 */
	public void setName2(java.lang.String newName) {
		this.name2 = newName;
	}
	/**
	 * 属性name的Getter方法. 创建日期:
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getName3() {
		return name3;
	}
	/**
	 * 属性name的Setter方法. 创建日期:
	 * 
	 * @param newName
	 *            java.lang.String
	 */
	public void setName3(java.lang.String newName) {
		this.name3 = newName;
	}
	/**
	 * 属性name的Getter方法. 创建日期:
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getName4() {
		return name4;
	}
	/**
	 * 属性name的Setter方法. 创建日期:
	 * 
	 * @param newName
	 *            java.lang.String
	 */
	public void setName4(java.lang.String newName) {
		this.name4 = newName;
	}
	/**
	 * 属性name的Getter方法. 创建日期:
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getName5() {
		return name5;
	}
	/**
	 * 属性name的Setter方法. 创建日期:
	 * 
	 * @param newName
	 *            java.lang.String
	 */
	public void setName5(java.lang.String newName) {
		this.name5 = newName;
	}
	/**
	 * 属性name的Getter方法. 创建日期:
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getName6() {
		return name6;
	}
	/**
	 * 属性name的Setter方法. 创建日期:
	 * 
	 * @param newName
	 *            java.lang.String
	 */
	public void setName6(java.lang.String newName) {
		this.name6 = newName;
	}
	/**
	 * 属性pk_group的Getter方法. 创建日期:
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getPk_group() {
		return pk_group;
	}
	/**
	 * 属性pk_group的Setter方法. 创建日期:
	 * 
	 * @param newPk_group
	 *            java.lang.String
	 */
	public void setPk_group(java.lang.String newPk_group) {
		this.pk_group = newPk_group;
	}
	/**
	 * 属性pk_prodef的Getter方法. 创建日期:
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getPk_prodef() {
		return pk_prodef;
	}
	/**
	 * 属性pk_prodef的Setter方法. 创建日期:
	 * 
	 * @param newPk_prodef
	 *            java.lang.String
	 */
	public void setPk_prodef(java.lang.String newPk_prodef) {
		this.pk_prodef = newPk_prodef;
	}
	/**
	 * 属性pk_startfrm的Getter方法. 创建日期:
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getPk_startfrm() {
		return pk_startfrm;
	}
	/**
	 * 属性pk_startfrm的Setter方法. 创建日期:
	 * 
	 * @param newPk_startfrm
	 *            java.lang.String
	 */
	public void setPk_startfrm(java.lang.String newPk_startfrm) {
		this.pk_startfrm = newPk_startfrm;
	}
	/**
	 * 属性processxml的Getter方法. 创建日期:
	 * 
	 * @return java.lang.Object
	 */
	public byte[] getProcessxml() {
		return processxml;
	}
	/**
	 * 属性processxml的Setter方法. 创建日期:
	 * 
	 * @param newProcessxml
	 *            java.lang.Object
	 */
	public void setProcessxml(byte[] newProcessxml) {
		this.processxml = newProcessxml;
	}
	/**
	 * 属性serverclass的Getter方法. 创建日期:
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getServerclass() {
		return serverclass;
	}
	/**
	 * 属性serverclass的Setter方法. 创建日期:
	 * 
	 * @param newServerclass
	 *            java.lang.String
	 */
	public void setServerclass(java.lang.String newServerclass) {
		this.serverclass = newServerclass;
	}
	/**
	 * 属性version的Getter方法. 创建日期:
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getVersion() {
		return version;
	}
	/**
	 * 属性version的Setter方法. 创建日期:
	 * 
	 * @param newVersion
	 *            java.lang.String
	 */
	public void setVersion(java.lang.String newVersion) {
		this.version = newVersion;
	}
	/**
	 * 属性watchrolepks的Getter方法. 创建日期:
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getWatchrolepks() {
		return watchrolepks;
	}
	/**
	 * 属性watchrolepks的Setter方法. 创建日期:
	 * 
	 * @param newWatchrolepks
	 *            java.lang.String
	 */
	public void setWatchrolepks(java.lang.String newWatchrolepks) {
		this.watchrolepks = newWatchrolepks;
	}
	public java.lang.String getIndividual() {
		return individual;
	}
	public void setIndividual(java.lang.String individual) {
		this.individual = individual;
	}
	/**
	 * 属性dr的Getter方法. 创建日期:
	 * 
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getDr() {
		return dr;
	}
	/**
	 * 属性dr的Setter方法. 创建日期:
	 * 
	 * @param newDr
	 *            java.lang.Integer
	 */
	public void setDr(java.lang.Integer newDr) {
		this.dr = newDr;
	}
	/**
	 * 属性ts的Getter方法. 创建日期:
	 * 
	 * @return nc.vo.pub.lang.UFDateTime
	 */
	public nc.vo.pub.lang.UFDateTime getTs() {
		return ts;
	}
	/**
	 * 属性ts的Setter方法. 创建日期:
	 * 
	 * @param newTs
	 *            nc.vo.pub.lang.UFDateTime
	 */
	public void setTs(nc.vo.pub.lang.UFDateTime newTs) {
		this.ts = newTs;
	}
	/**
	 * <p>
	 * 取得父VO主键字段.
	 * <p>
	 * 创建日期:
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getParentPKFieldName() {
		return null;
	}
	/**
	 * <p>
	 * 取得表主键.
	 * <p>
	 * 创建日期:
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getPKFieldName() {
		return "pk_prodef";
	}
	/**
	 * <p>
	 * 返回表名称.
	 * <p>
	 * 创建日期:
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getTableName() {
		return "wfm_prodef";
	}
	/**
	 * <p>
	 * 返回表名称.
	 * <p>
	 * 创建日期:
	 * 
	 * @return java.lang.String
	 */
	public static java.lang.String getDefaultTableName() {
		return "wfm_prodef";
	}
	public String getWatchrolenames() {
		return watchrolenames;
	}
	public void setWatchrolenames(String watchrolenames) {
		this.watchrolenames = watchrolenames;
	}
	public String getProcessstr() {
		byte[] btyes = this.getProcessxml();
		if (btyes == null || btyes.length == 0) {
			return null;
		}
		return new String(getProcessxml());
	}
	public void setProcessstr(String processxml) {
		if(processxml!=null)
		setProcessxml(processxml.getBytes());
	}
	/**
	 * 按照默认方式创建构造子.
	 * 
	 * 创建日期:
	 */
	public WfmProdefVO() {
		super();
	}
	/**
	 * @param enginename the enginename to set
	 */
	public void setEnginename(java.lang.String enginename) {
		this.enginename = enginename;
	}
	/**
	 * @return the enginename
	 */
	public java.lang.String getEnginename() {
		return enginename;
	}
	/**
	 * @param pk_refprodef the pk_refprodef to set
	 */
	public void setPk_refprodef(java.lang.String pk_refprodef) {
		this.pk_refprodef = pk_refprodef;
	}
	/**
	 * @return the pk_refprodef
	 */
	public java.lang.String getPk_refprodef() {
		return pk_refprodef;
	}
}
