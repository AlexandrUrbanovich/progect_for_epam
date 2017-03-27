package ru.mail.urbanovichalexandr.dao.impl.db.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp.BasicDataSource;

public class SchemaNameAwareBasicDataSource extends BasicDataSource {
	private String schema;
	
    public String getSchema() {
        return schema;
    }

    public void setSchema(final String schema) {
        if (schema == null) {
            throw new IllegalArgumentException("Illegal schema name");
        }

        this.schema = schema;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return switchSchema(super.getConnection());
    }

    @Override
    public Connection getConnection(final String username, final String password) throws SQLException {
        return switchSchema(super.getConnection(username, password));
    }

    private Connection switchSchema(final Connection connection) throws SQLException {
        final Statement stmt = connection.createStatement();
        try {
            stmt.execute("SET search_path TO " + schema);
        } finally {
            stmt.close();
        }

        return connection;
    }

}
