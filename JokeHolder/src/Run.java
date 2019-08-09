package src;

import java.util.HashSet;
import java.io.*;

import src.conf.*;
import src.io.*;
import src.data.*;
import src.exceptions.*;

public class Run{
  private static Input input;

  private static Output output;

  public static void main(String[] args)  throws IOException{
    Configuration config = new ConfigurationConsole();

    HashSet<Joke> jokes = new HashSet<Joke>();

    input = config.getCrntInput();
    output = config.getCrntOutput();

    JokeFactory jokeFactory = new JokeFactory();

    boolean stopLoop = true;
    boolean tryAgain = false;

    String inputText = "";

    output.showOutput("Wellcome to Joke Holder");

    do{
      output.showOutput("For new joke press 1, for exit press 2");

      inputText = input.getInput();

      switch(inputText){
        case "1":
          stopLoop = false;
          break;
        case "2":
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
      } else{
        try{
          Joke crntJoke = jokeFactory.createJoke(input, output);
          jokes.add(crntJoke);
        }catch(JokeCreationException ex){
          output.showOutput(ex.toString());
        }
        continue;
      }
    }while(true);

    output.showOutput("Thank you for entering jokes!");

    output.showOutput("All Jokes Entered:");

    for (Joke crntJoke : jokes ){
      output.showOutput(crntJoke.toString());
    }

  }

  public static void main_test(String[] args){
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
  }
}
