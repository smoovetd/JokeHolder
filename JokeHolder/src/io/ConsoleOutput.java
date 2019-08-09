package src.io;

import java.io.*;

public class ConsoleOutput implements Output{

  @Override
  public void wellcome(){
    System.out.println("Hi there");
  }

  @Override
  public String getUserInterraction(){
    return "Error";
  }

  @Override
  public String showJoke(){
    return "Error";
  }

  @Override
  public void showOutput(String output){
    System.out.println(output);
  }
}
