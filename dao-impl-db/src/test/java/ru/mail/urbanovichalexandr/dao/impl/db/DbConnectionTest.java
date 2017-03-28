package ru.mail.urbanovichalexandr.dao.impl.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnectionTest {

    public static void main(String[] args) {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/progect_for_epam", "postgres", "root");
            System.out.println("Соединение установлено.");

            Statement createStatement = con.createStatement();
            createStatement.execute("select * from students order by student_id");

            ResultSet resultSet = createStatement.getResultSet();
            resultSet.next();
            int id = resultSet.getInt("student_id");
            con.close();
            boolean next = resultSet.next();
            int id2 = resultSet.getInt("student_id");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
            }
        }
    }
}
