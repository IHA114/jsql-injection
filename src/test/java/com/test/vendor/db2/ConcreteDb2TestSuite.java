package com.test.vendor.db2;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import com.test.AbstractTestSuite;

@TestInstance(Lifecycle.PER_CLASS)
@Execution(ExecutionMode.CONCURRENT)
public abstract class ConcreteDb2TestSuite extends AbstractTestSuite {

    public ConcreteDb2TestSuite() {
        this.config();
    }
    
    public void config() {
      
        this.jdbcURL = "jdbc:db2://localhost:50000/testdb";
        this.jdbcUser = "db2inst1";
        this.jdbcPass = "test";
        this.jsqlDatabaseName = "DB2INST1";
        this.jsqlTableName = "STUDENT";
        this.jsqlColumnName = "STUDENT_ID";
        
        this.jdbcColumnForDatabaseName = "schemaname";
        this.jdbcColumnForTableName = "name";
        this.jdbcColumnForColumnName = "name";
        
        this.jdbcQueryForDatabaseNames = "select trim("+ this.jdbcColumnForDatabaseName +") "+ this.jdbcColumnForDatabaseName +" from syscat.schemata";
        this.jdbcQueryForTableNames = "select "+ this.jdbcColumnForTableName +" from sysibm.systables where creator = '"+ this.jsqlDatabaseName +"'";
        this.jdbcQueryForColumnNames = "select "+ this.jdbcColumnForColumnName + " from sysibm.syscolumns where coltype != 'BLOB' and tbcreator = '"+ this.jsqlDatabaseName +"' and tbname = '"+ this.jsqlTableName +"'";
        this.jdbcQueryForValues = "SELECT "+ this.jsqlColumnName +" FROM "+ this.jsqlDatabaseName +"."+ this.jsqlTableName;
    }
}
