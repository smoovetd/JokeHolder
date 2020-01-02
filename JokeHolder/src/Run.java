package src;

import java.util.HashSet;
import java.io.*;

import src.conf.*;
import src.io.*;
import src.data.*;
import src.exceptions.*;
import src.storage.*;

public class Run{
  private static Input input;

  private static Output output;

  private static Storage storage;

  private static String dbName = "joke_db";


  public static void main(String[] args)  throws IOException{
    Configuration config = new ConfigurationConsole(dbName);
    String action = "";

    HashSet<Joke> jokes = new HashSet<Joke>();
    HashSet<Joke> newJokes = new HashSet<Joke>();

    input = config.getCrntInput();
    output = config.getCrntOutput();
    storage = config.getCrntStorage();

    JokeFactory jokeFactory = new JokeFactory();

    boolean stopLoop = true;
    boolean tryAgain = false;

    String inputText = "";

    output.showOutput("Wellcome to Joke Holder");

    jokes = initJokes(jokeFactory, storage);

    printAllJokes(jokes);

    do{
      output.showOutput("Type menu option and press Enter");
      output.showOutput("For new joke type 1");
      output.showOutput("For search joke by tag type 2");
      output.showOutput("For search joke by content type 3");
      output.showOutput("To print all jokes type 4");
      output.showOutput("For exit press 5");

      inputText = input.getInput();

      switch(inputText){
        case "1":
          stopLoop = false;
          action = "add";
          break;
        case "2":
          stopLoop = false;
          action = "search_tag";
          break;
        case "3":
            stopLoop = false;
            action = "search_content";
            break;
        case "4":
          stopLoop = false;
          action = "get_all";
          break;
        case "5":
          stopLoop = true;
          break;
        default:
            output.showOutput("Incorrectly entered: " + inputText);
            tryAgain = true;
            stopLoop = false;
            break;
      }

      if(stopLoop){
        break;
      } else if(tryAgain){
        tryAgain = false;
        continue;
      } else {
        switch(action){
          case "add":
            try{
              Joke crntJoke = jokeFactory.createJoke(input, output);
              jokes.add(crntJoke);
              newJokes.add(crntJoke);
            }catch(JokeCreationException ex){
              output.showOutput(ex.toString());
            }
            break;
          case "search_tag":
            break;
          case "search_content":
            break;
          case "get_all":
            break;
          default:
            output.showOutput("Incorrectd action: " + action);
            break;
        }
        continue;
      }
    }while(true);

    output.showOutput("Thank you for entering jokes!");

    output.showOutput("All Jokes Entered:");

    if(storage.createStorageTable()){
       output.showOutput("DB connection is successful");
    } else{
       output.showOutput("ERROR DB connection is NOT successful");
    }

    //for debug
    output.showOutput("All Jokes:");
    printAllJokes(jokes);
    output.showOutput("New Jokes:");
    printAllJokes(newJokes);

    storeNewJokes(newJokes);
  }

 private static void printAllJokes(HashSet<Joke> jokes){
   for (Joke crntJoke : jokes ){
     output.showOutput(crntJoke.toString());
   }
 }

 private static void storeNewJokes(HashSet<Joke> jokes){
   for (Joke crntJoke : jokes ){
      storage.storeJoke(crntJoke);
   }
 }

 private static HashSet<Joke> initJokes(JokeFactory jokeFactory, Storage dbStorage){
   HashSet<Joke> storedJokes = new HashSet();

   //for debug

   //System.out.println("In init Jokes");
   storedJokes = dbStorage.getAllJokesFromDB(jokeFactory);
   //for debug
   //System.out.println("Out of init Jokes");

   return storedJokes;
 }

/*  public static void main_test(String[] args){
    Configuration config = new ConfigurationConsole();

    input = config.getCrntInput();
    output = config.getCrntOutput();

    String result = "";

    output.showOutput("Enter something: ");

    try{
      result = input.getInput();
    } catch(IOException ex){
      output.showOutput("Error - incorrect input: " + ex.toString());
    }

    output.showOutput("You have entered: " + result);
  } */
}
