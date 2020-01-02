package com.kodilla.jdbc;

import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;

public class StoredProcTestSuite {

    private static final String DB = "functions";

    @Test
    public void testUpdateVipLevel() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance(DB);
        String sqlUpdate = "UPDATE READERS SET VIP_LEVEL=\"Not set\"";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);

        //When
        String sqlProcedureCall = "CALL UpdateVipLevels()";
        statement.execute(sqlProcedureCall);

        //Then
        String sqlCheckTable = "SELECT COUNT(*) AS HOW_MANY FROM READERS WHERE VIP_LEVEL=\"Not set\"";
        ResultSet rs = statement.executeQuery(sqlCheckTable);
        int howMany = -1;
        if (rs.next()) {
            howMany = rs.getInt("HOW_MANY");
        }
        assertEquals(0, howMany);
    }

    @Test
    public void testUpdateBestsellers() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance(DB);
        String sqlUpdate = "UPDATE BOOKS SET BESTSELLER=NULL";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);

        //When
        String sqlProcedureCall = "CALL UpdateBestsellers()";
        statement.execute(sqlProcedureCall);

        //Then
        String sqlCheckTable = "SELECT COUNT(*) AS HOW_MANY_ALL, COUNT(BESTSELLER) AS HOW_MANY_NOT_NULL  FROM BOOKS;";
        ResultSet rs = statement.executeQuery(sqlCheckTable);
        int howManyAll = -1;
        int howManyNotNull = -2;
        if (rs.next()) {
            howManyAll = rs.getInt("HOW_MANY_ALL");
            howManyNotNull = rs.getInt("HOW_MANY_NOT_NULL");
        }
        assertEquals(howManyAll, howManyNotNull);
    }
}
