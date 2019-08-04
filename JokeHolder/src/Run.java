import conf.*;
import io.*;
import java.io.*;

public class Run{
  private static Input input;

  private static Output output;

  public static void main(String[] args){
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
