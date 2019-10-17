package src.storage;

import src.data.*;
import src.exceptions.*;

import java.sql.*;
import java.util.*;

public class StorageInDb implements Storage{

  private static final String tableColumns = "(id number primary key not null, content varchar(5000) not null, tags array );";
  private static final String dbDriver = "org.h2.Driver";
  private static final String dbConnectionSettings = "jdbc:h2:~/test";
  private static final String dbUserName = "sa";
  private static final String dbPass = "";

  private String name;

  public StorageInDb(String dbName){
    this.setDbName(dbName);
  }

  private void setDbName(String dbName){
      this.name = dbName;
  }

  public String getDbName(){
      return this.name;
  }

  @Override
  public boolean createStorageTable(){
    String createTableQuery = "CREATE TABLE IF NOT EXISTS " + this.getDbName() + " " + tableColumns;
    String verifyTableQuery = "IF EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = N'" + this.getDbName() + "') BEGIN RETURN 'Exists' END";
    try{
       Class.forName(dbDriver).newInstance();
       Connection conn = DriverManager.getConnection(dbConnectionSettings, dbUserName, dbPass);
       conn.createStatement().execute(createTableQuery);
       ResultSet resSet = conn.createStatement().executeQuery(verifyTableQuery);
       conn.close();
     } catch (SQLException ex){
       System.out.println("ERROR - " + ex.toString());
       return false;
     } catch (ClassNotFoundException classEx){
       System.out.println("ERROR - " + classEx.toString());
       return false;
     } catch (InstantiationException instantEx){
       System.out.println("ERROR - " + instantEx.toString());
       return false;
     } catch (IllegalAccessException accessEx){
       System.out.println("ERROR - " + accessEx.toString());
       return false;
     }

     return true;
  }

  @Override
  public boolean storeJoke(Joke crntJoke) throws JokeCreationException{
      throw new JokeCreationException("ERROR - function storeJoke() is not implemented");
  }

  @Override
  public List<Joke> getAllJokesFromDB() throws JokeCreationException{
     throw new JokeCreationException("ERROR - function getAllJokesFromDB() is not implemented");
  }

  @Override
  public Joke getJokeById(long id) throws JokeCreationException{
      throw new JokeCreationException("ERROR - function getJokeById() is not implemented");
  }

  @Override
  public Joke getJokeByTag(String tag) throws JokeCreationException{
     throw new JokeCreationException("function getJokeByTag() is not implemented!");
  }

}
