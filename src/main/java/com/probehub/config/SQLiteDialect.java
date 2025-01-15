package com.probehub.config;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.dialect.function.NoArgSQLFunction;
import org.hibernate.type.StringType;

public class SQLiteDialect extends Dialect {

    public SQLiteDialect() {
        registerColumnType(java.sql.Types.BIT, "boolean");
        registerColumnType(java.sql.Types.TINYINT, "tinyint");
        registerColumnType(java.sql.Types.SMALLINT, "smallint");
        registerColumnType(java.sql.Types.INTEGER, "integer");
        registerColumnType(java.sql.Types.BIGINT, "bigint");
        registerColumnType(java.sql.Types.FLOAT, "float");
        registerColumnType(java.sql.Types.DOUBLE, "double");
        registerColumnType(java.sql.Types.VARCHAR, "varchar");
        registerColumnType(java.sql.Types.BLOB, "blob");
        registerColumnType(java.sql.Types.CLOB, "clob");
        registerColumnType(java.sql.Types.DATE, "date");
        registerColumnType(java.sql.Types.TIMESTAMP, "timestamp");

        registerFunction("concat", new StandardSQLFunction("concat", StringType.INSTANCE));
        registerFunction("mod", new StandardSQLFunction("mod"));
        registerFunction("substr", new StandardSQLFunction("substr", StringType.INSTANCE));
        registerFunction("substring", new StandardSQLFunction("substring", StringType.INSTANCE));
    }

    @Override
    public boolean supportsIdentityColumns() {
        return true;
    }

    @Override
    public String getIdentitySelectString(String table, String column, int type) {
        return "select last_insert_rowid()";
    }

    @Override
    public String getIdentityColumnString(int type) {
        return "integer";
    }

    @Override
    public boolean hasAlterTable() {
        return false;
    }
}
