package ru.itpark;

import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        try {
            Connection connection = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/GUBAYDULLIN_DB",
                            "postgres",
                            "Zaq12wsx");

            Statement selectStatement
                    = connection.createStatement();

            ResultSet resultSet =
                    selectStatement.executeQuery("SELECT COUNT(*) \n" +
                            "FROM auto a WHERE a.owner_id = \n" +
                            "(SELECT (id) FROM it_park_user u \n" +
                            "WHERE u.name = " + "'" + name + "'" + ");");

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("count"));
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
