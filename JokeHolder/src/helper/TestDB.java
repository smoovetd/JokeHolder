package helper;

import java.sql.*;

public class TestDB{
    public static void main(String args[])throws ClassNotFoundException, InstantiationException, IllegalAccessException{
      String tableName = "AppTestTable";
      String tableColumns = "(id number primary key not null, content varchar(200) not null, tags array )";
      String createTableQuery = "CREATE TABLE IF NOT EXISTS " + tableName + tableColumns;
      String insertQuery = "INSERT INTO " + tableName + " VALUES (3, 'Not Very funny joke', ('funny','boring'));";
      String selectQuery = "SELECT * FROM " + tableName;
     try{
        Class.forName("org.h2.Driver").newInstance();
        Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
      //  conn.createStatement().execute(createTableQuery);
    //    conn.createStatement().execute(insertQuery);
        ResultSet resSet = conn.createStatement().executeQuery(selectQuery);

        while (resSet.next()){
          System.out.println("=================================");
          System.out.println("ID : " + resSet.getString("id"));
          System.out.println("JOKE : " + resSet.getString("content"));
          System.out.println("TAGS : " + resSet.getArray("tags").toString());
          System.out.println("=================================");
        }


        conn.close();
      } catch (SQLException ex){
        System.out.println("ERROR - " + ex.toString());
      }
    }
}
