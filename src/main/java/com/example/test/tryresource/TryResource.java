package com.example.test.tryresource;

import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;

public class TryResource {

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\02.STSWork\\99.TEST\\test\\src\\main\\resources\\application.properties");
        InputStream is = null;
        try {

            is = new FileInputStream(file);

            byte[] bytes = new byte[1024];
            while(is.available() > 0) {
                is.read(bytes);
                System.out.println(new String(bytes));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            is.close();
        }

        DataSource da = new HikariDataSource();
        try {
            Connection conn = da.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try (
            InputStream is2 = new FileInputStream(file);
            TestClose te = new TestClose();
        ) {
            byte[] bytes = new byte[1024];
            while(is2.available() > 0) {
                is2.read(bytes);
                System.out.println(new String(bytes));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}
