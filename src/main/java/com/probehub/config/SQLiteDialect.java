package com.probehub.config;

import org.hibernate.dialect.Dialect;

public class SQLiteDialect extends Dialect {

    public SQLiteDialect() {
        super();
    }

    
    public boolean supportsIdentityColumns() {
        return true;
    }

    
    public String getIdentitySelectString(String table, String column, int type) {
        return "select last_insert_rowid()";
    }

    
    public String getIdentityColumnString(int type) {
        return "integer";
    }

    
    public boolean hasAlterTable() {
        return false;
    }

   
    public boolean dropConstraints() {
        return false;
    }

    
    public String getLimitString(String query, int offset, int limit) {
        return query + (offset > 0 ? " limit " + limit + " offset " + offset : " limit " + limit);
    }
}
