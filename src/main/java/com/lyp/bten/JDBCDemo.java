package com.lyp.bten;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class JDBCDemo{

  public static void main(String[] args) throws Exception{
    //加载MySql驱动
    Class.forName("com.mysql.jdbc.Driver");
    String connectStr = "jdbc:mysql://127.0.0.1:3306/test02?serverTimeZone=UTC&characterEncoding=utf8";
    Connection connection = DriverManager.getConnection(connectStr, "root", "aaaaaa");
    PreparedStatement preparedStatement = connection.prepareStatement("select * from payment");
    ResultSet resultSet = preparedStatement.executeQuery();
    while(resultSet.next()){
      System.out.println(resultSet.getRow());
    }
  }

  public static void test(){
    Map<String, Integer> map = new HashMap<String, Integer>();
    String key = "xxx";
    Integer val = 123;
    map.merge(key, val, Integer::sum);



  }
}