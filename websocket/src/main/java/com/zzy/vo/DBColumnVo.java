package com.zzy.vo;

/**
 * Created by zhaoziyun on 2019/4/15.
 */

public class DBColumnVo {
    String tableName;
    String columnName;
    String columnDesc;
    int columnType;
    String  columnTypeName;
    long size;

    public int getColumnType() {
        return columnType;
    }

    public void setColumnType(int columnType) {
        this.columnType = columnType;
    }

    public String getColumnTypeName() {
        return columnTypeName;
    }

    public void setColumnTypeName(String columnTypeName) {
        this.columnTypeName = columnTypeName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnDesc() {
        return columnDesc;
    }

    public void setColumnDesc(String columnDesc) {
        this.columnDesc = columnDesc;
    }



    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
