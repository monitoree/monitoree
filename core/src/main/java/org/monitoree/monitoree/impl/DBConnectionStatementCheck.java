package org.monitoree.monitoree.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.monitoree.monitoree.api.DBConnection;


public class DBConnectionStatementCheck extends AbstractConnectionBean implements DBConnection {

    private final long expectedResponseTime;
    private final String datasourceDefinition;
    private final String queryString;

    private Connection connection;
    private Statement statement;
    private ResultSet result;

    public DBConnectionStatementCheck(String poolname, String queryString, long expectedResponseTime) {
        this.queryString = queryString;
        this.datasourceDefinition = poolname;
        this.expectedResponseTime = expectedResponseTime;
    }

    @Override
    public String getPoolName() {
        return datasourceDefinition;
    }

    @Override
    public long getExpectedResponseTime() {
        return expectedResponseTime;
    }

    @Override
    protected void executeConnectionTest() throws Exception {
        final DataSource ds = (javax.sql.DataSource)new InitialContext().lookup(datasourceDefinition);
        connection = ds.getConnection();
        statement = connection.createStatement();
        result = statement.executeQuery(queryString);
    }

    @Override
    public void cleanUp() {
        try {
            result.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
        }
    }

    @Override
    public org.monitoree.monitoree.api.Manageable.Type getType() {
        return Type.SYSTEM;
    }

    @Override
    public Class<DBConnection> getManageableInterface() {
        return DBConnection.class;
    }
}
