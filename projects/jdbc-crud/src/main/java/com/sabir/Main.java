package com.sabir;

import java.sql.Connection;

import com.sabir.util.DbUtil;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = DbUtil.getConnection()){
            System.out.println("got connection object");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}