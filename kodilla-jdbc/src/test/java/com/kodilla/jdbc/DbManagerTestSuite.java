package com.kodilla.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DbManagerTestSuite {

    @Test
    void testConnection() throws SQLException {
        //Given

        //When
        DbManager dbManager = DbManager.getInstance();
        //Then
        assertNotNull(dbManager.getConnection());
    }

    @Test
    void testSelectUsers() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQuery = "SELECT * FROM USERS";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while (rs.next()) {
            System.out.println(rs.getInt("ID") + ", " +
                    rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME"));
            counter++;
        }
        rs.close();
        statement.close();
        assertEquals(5, counter);
    }
/*
    @Test
    void testSelectUsersAndTasks() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQuery = """
                SELECT U.FIRSTNAME, U.LASTNAME, I.SUMMARY
                FROM USERS U
                JOIN ISSUES I ON U.ID = I.USER_ID_ASSIGNEDTO
                """;
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while (rs.next()) {
            System.out.println(rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME") + ", " +
                    rs.getString("SUMMARY"));
            counter++;
        }
        rs.close();
        statement.close();
        assertEquals(15, counter);
    }*/

    @Test
    void testSelectUsersAndPosts() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQuery = """
                SELECT U.FIRSTNAME, U.LASTNAME, COUNT(*) AS POSTS_COUNT
                FROM USERS U
                JOIN POSTS P ON U.ID = P.USER_ID
                GROUP BY P.USER_ID
                HAVING COUNT(*) >= 2
                """;
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while (rs.next()) {
            System.out.println(rs.getString("FIRSTNAME") + ", " +
                rs.getString("LASTNAME") + ", " +
                rs.getInt("POSTS_COUNT"));
            counter++;
        }
        rs.close();
        statement.close();
        assertEquals(4, counter);
    }

    @Test
    void testSelectUsersAndPostThenSort() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQuery = """
                SELECT U.FIRSTNAME, U.LASTNAME, COUNT(*)
                FROM USERS U
                JOIN POSTS P ON U.ID = P.USER_ID
                GROUP BY P.USER_ID
                ORDER BY COUNT(*) DESC
                """;
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //Then
        while (rs.next()) {
            System.out.println(rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME") + ", " +
                    rs.getInt("COUNT(*)"));
        }
        rs.close();
        statement.close();
    }

    @Test
    void testInsertIntoPosts() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQueryInsert1 = """
                INSERT INTO POSTS(USER_ID, BODY) VALUES (2, 'I like oranges.');
                """;
        String sqlQueryInsert2 = """
                INSERT INTO POSTS(USER_ID, BODY) VALUES (1, 'I like running.');
                """;
        String sqlQueryInsert3 = """
                INSERT INTO POSTS(USER_ID, BODY) VALUES (4, 'I love hiking.');
                """;
        String sqlQueryInsert4 = """                                
                INSERT INTO POSTS(USER_ID, BODY) VALUES (3, 'I hate grapefruits.');
                """;

        String sqlQueryResult = """
                SELECT P.USER_ID, P.BODY FROM POSTS P
                """;
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlQueryInsert1);
        statement.executeUpdate(sqlQueryInsert2);
        statement.executeUpdate(sqlQueryInsert3);
        statement.executeUpdate(sqlQueryInsert4);
        ResultSet rs = statement.executeQuery(sqlQueryResult);

        //Then
        HashMap<Integer, String> posts = new HashMap<>();

        while (rs.next()) {
            posts.put(rs.getInt("USER_ID"), rs.getString("BODY"));
        }
        rs.close();
        statement.close();

        assertEquals(4, posts.size());
        assertEquals("I like oranges.", posts.get(2));
        assertEquals("I like running.", posts.get(1));
        assertEquals("I love hiking.", posts.get(4));
        assertEquals("I hate grapefruits.", posts.get(3));

    }
/*
    @Test
    void testCreateEntityAndInsertRecords() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlCreateEntity = """
                CREATE TABLE RESULTS
                (
                    ID SERIAL PRIMARY KEY,
                    FIRSTNAME VARCHAR(50),
                    LASTNAME VARCHAR(50),
                    NATIONALITY VARCHAR(50),
                    TIME TIME
                );
                """;
        String sqlCreateRecord1 = """
                INSERT INTO RESULTS(FIRSTNAME, LASTNAME, NATIONALITY, TIME)
                VALUES('JOSEPH', 'MUNYWOKI', 'KENYA', '02:10:07')
                """;
        String sqlCreateRecord2 = """
                INSERT INTO RESULTS(FIRSTNAME, LASTNAME, NATIONALITY, TIME)
                VALUES('DANEL', 'DERESE', 'ETIOPIA', '02:12:18')
                """;
        String sqlCreateRecord3 = """
                INSERT INTO RESULTS(FIRSTNAME, LASTNAME, NATIONALITY, TIME)
                VALUES('DICKSON', 'KIPTOO', 'KENYA', '02:12:47')
                """;
        String sqlSelect = """
                SELECT * FROM RESULTS
                """;

        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlCreateEntity);
        statement.executeUpdate(sqlCreateRecord1);
        statement.executeUpdate(sqlCreateRecord2);
        statement.executeUpdate(sqlCreateRecord3);
        statement.execute(sqlSelect);
        ResultSet rs = statement.getResultSet();

        //Then
        int counter = 0;
        while (rs.next()) {
            counter++;
        }

        rs.close();
        statement.close();

        assertEquals(3, counter);

    }*/
}
