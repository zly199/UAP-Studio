package nc.uap.lfw.build.dbcreate.impl;

import nc.uap.lfw.build.dbcreate.pdm.Pdm.ViewInfo;
import nc.uap.lfw.build.orm.mapping.Column;
import nc.uap.lfw.build.orm.mapping.IColumn;
import nc.uap.lfw.build.orm.mapping.ITable;
import nc.uap.lfw.build.orm.mapping.Table;

import org.apache.commons.lang.StringUtils;

/**
 * SQLSERVER同其它数据库的脚本转换器。
 * 
 * @author PH
 */
class SqlConvertor {
	
	static ITable cvtSqlServer2Oracle(ITable table){
		Table newTable = cloneTable(table);
		for(IColumn col : newTable.getAllColumns()){
			((Column)col).setTypeName(cvtDatatypeFromSqlServer2Oracle(col.getTypeName()));
		}
		return newTable;
	}
	
	static ITable cvtSqlServer2Db2(ITable table){
		Table newTable = cloneTable(table);
		for(IColumn col : newTable.getAllColumns()){
			((Column)col).setTypeName(cvtDatatypeFromSqlServer2Db2(col.getTypeName()));
		}
		return newTable;
	}
	
	static ViewInfo cvtViewFromSqlServer2Db2(ViewInfo view){
		ViewInfo cvtedView = new ViewInfo();
		cvtedView.setName(view.getName());
		cvtedView.setDesc(view.getDesc());
		cvtedView.setSql(StringUtils.replace(view.getSql(), "isnull", "coalesce"));
		return cvtedView;
	}
	
	static ViewInfo cvtViewFromSqlServer2Oracle(ViewInfo view){
		ViewInfo cvtedView = new ViewInfo();
		cvtedView.setName(view.getName());
		cvtedView.setDesc(view.getDesc());
		cvtedView.setSql(StringUtils.replace(view.getSql(), "isnull", "nvl"));
		return cvtedView;
	}
	
	private static String cvtDatatypeFromSqlServer2Oracle(String dataType){
		if(StringUtils.isBlank(dataType)){
			return "";
		}
		dataType = dataType.toLowerCase();
		String cvtedDataType = dataType;
		if(dataType.contains("decimal")){
			cvtedDataType = dataType.replace("decimal", "number");
		}else if(dataType.contains("numeric")){
			cvtedDataType = dataType.replace("numeric", "number");
		}else if(dataType.contains("varchar")){
			cvtedDataType = dataType.replace("varchar", "varchar2");
		}else if(dataType.equalsIgnoreCase("int")){
			cvtedDataType = "integer";
		}else if(dataType.equalsIgnoreCase("image")){
			cvtedDataType = "blob";
		}else if(dataType.equalsIgnoreCase("text")){
			cvtedDataType = "clob";
		}else if(dataType.equalsIgnoreCase("datetime")){
			cvtedDataType = "date";
		}
		return cvtedDataType;
	}
	
	private static String cvtDatatypeFromSqlServer2Db2(String dataType){
		if(StringUtils.isBlank(dataType)){
			return "";
		}
		dataType = dataType.toLowerCase();
		String cvtedDataType = dataType;
		if(dataType.equalsIgnoreCase("int")){
			cvtedDataType = "integer";
		}else if(dataType.equalsIgnoreCase("image")){
			cvtedDataType = "blob(128m)";
		}else if(dataType.equalsIgnoreCase("text")){
			cvtedDataType = "clob(2m)";
		}
		return cvtedDataType;
	}
	
	public static Table cloneTable(ITable table){
		Table newTable = new Table();
		newTable.setName(table.getName());
		newTable.setDesc(table.getDesc());
		newTable.setPkConstraint(table.getPkConstraint());
		newTable.getFkConstraints().addAll(table.getFkConstraints());
		for(IColumn col : table.getAllColumns()){
			Column newCol = new Column();
			newCol.setName(col.getName());
			newCol.setDesc(col.getDesc());
			newCol.setTypeName(col.getTypeName());
			newCol.setLength(col.getLength());
			newCol.setPrecise(col.getPrecise());
			newCol.setNullable(col.isNullable());
			newCol.setDefaultValue(col.getDefaultValue());
			newCol.setStereotype(col.getStereotype());
			newTable.getAllColumns().add(newCol);
		}
		
		return newTable;
	}

}
