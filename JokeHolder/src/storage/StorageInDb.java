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
    String verifyTableQuery = "SELECT * FROM INFORMATION_SCHEMA.TABLES";
    boolean result = false;
    boolean isFound = false;

    try{
       Class.forName(dbDriver).newInstance();
       Connection conn = DriverManager.getConnection(dbConnectionSettings, dbUserName, dbPass);
       conn.createStatement().execute(createTableQuery);

       ResultSet resSet = conn.createStatement().executeQuery(verifyTableQuery);

       while (resSet.next()){
      /*   System.out.println("=================================");
         System.out.println("ID : " + resSet.getString("id"));
         System.out.println("JOKE : " + resSet.getString("TABLE_NAME"));
         System.out.println("=================================");
      */ String tbName = resSet.getString("TABLE_NAME").toUpperCase();
         String origTableName = this.getDbName().toUpperCase();
         //System.out.println("Orig Table: " + origTableName + "; new table: " + tbName + ". Result: " + (tbName.equals(origTableName)));
         if (tbName.equals(origTableName)){
           isFound = true;
           break;
         }
       }

       if(isFound == true){
         result = true;
       } else {
         System.out.println("ERROR - no table with name: " +  this.getDbName() + " exist");
         result = false;
       }
       conn.close();
     } catch (SQLException ex){
       System.out.println("ERROR - " + ex.toString());
       result = false;
     } catch (ClassNotFoundException classEx){
       System.out.println("ERROR - " + classEx.toString());
       result = false;
     } catch (InstantiationException instantEx){
       System.out.println("ERROR - " + instantEx.toString());
       result = false;
     } catch (IllegalAccessException accessEx){
       System.out.println("ERROR - " + accessEx.toString());
       result = false;
     }

     return result;
  }

  @Override
  public boolean storeJoke(Joke crntJoke){
    boolean result = false;
    String addJokeQuery = "";
    String tags = "";
    String jokeContent = "";

    jokeContent = crntJoke.getContent();
    //escaping single quote character (')
    if(jokeContent.contains("'")){
      jokeContent = jokeContent.replace("'", "''");
    }

    for (String tag : crntJoke.getTags()){
      if (!tags.equals("")){
          tags = tags + ",'" + tag + "'";
      }else{
        tags = "'" + tag + "'";
      }
    }
    addJokeQuery = "INSERT INTO " + this.getDbName() + " VALUES (" + crntJoke.getId() + ",'" + jokeContent + "',(" + tags + "))";
    //for debug:
    //System.out.println("Tags: " + tags);
    //System.out.println("Query: " + addJokeQuery);

    try{
       Class.forName(dbDriver).newInstance();
       Connection conn = DriverManager.getConnection(dbConnectionSettings, dbUserName, dbPass);
       result = conn.createStatement().execute(addJokeQuery);

       conn.close();
     } catch (SQLException ex){
       System.out.println("ERROR - " + ex.toString());
       result = false;
     } catch (ClassNotFoundException classEx){
       System.out.println("ERROR - " + classEx.toString());
       result = false;
     } catch (InstantiationException instantEx){
       System.out.println("ERROR - " + instantEx.toString());
       result = false;
     } catch (IllegalAccessException accessEx){
       System.out.println("ERROR - " + accessEx.toString());
       result = false;
     }

    return result;
  }

  @Override
  public HashSet<Joke> getAllJokesFromDB(JokeFactory jokeFactory){
    HashSet<Joke> storedJokes = new HashSet<>();

    String selectAllJokesQuery = "SELECT * FROM " + this.getDbName();

    //for debug
    //System.out.println("In getAllJokesFromDB() - Query to Execute: '" + selectAllJokesQuery + "'");
    try{
       Class.forName(dbDriver).newInstance();
       Connection conn = DriverManager.getConnection(dbConnectionSettings, dbUserName, dbPass);
       ResultSet result = conn.createStatement().executeQuery(selectAllJokesQuery);

       while(result.next()){
          Long crntId     = Long.valueOf(result.getString("id"));
          String content  = result.getString("content");
          String arrTags = result.getString("tags").toString();
          //System.out.println("getAllJokesFromDB() - id: " + crntId + ",\ncontent: " + content + ". End");

          arrTags = arrTags.split("\\(")[1];
          arrTags = arrTags.split("\\)")[arrTags.split("\\)").length -1];

          String[] crntTags = arrTags.split(",");
          Joke crntJoke = jokeFactory.createJokeWithAllParams(crntId, content);

          for(int i = 0; i < crntTags.length; i++){
            if(!crntTags[i].trim().equals("")){
              crntJoke.setTag(crntTags[i]);
            }
          }
          storedJokes.add(crntJoke);
       }

       conn.close();
     } catch (JokeCreationException ex){
       System.out.println("getAllJokesFromDB() ERROR - " + ex.toString());
       storedJokes = null;
     } catch (SQLException ex){
       System.out.println("getAllJokesFromDB() ERROR - " + ex.toString());
       storedJokes = null;
     } catch (ClassNotFoundException classEx){
       System.out.println("getAllJokesFromDB() ERROR - " + classEx.toString());
       storedJokes = null;
     } catch (InstantiationException instantEx){
       System.out.println("getAllJokesFromDB() ERROR - " + instantEx.toString());
       storedJokes = null;
     } catch (IllegalAccessException accessEx){
       System.out.println("getAllJokesFromDB() ERROR - " + accessEx.toString());
       storedJokes = null;
     }

    return storedJokes;
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
