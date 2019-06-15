package io;

import java.io.*;

public class ConsoleInput implements Input{

  @Override
  public String getInput() throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String result = "";

    result = br.readLine();

    return result;
  }

  @Override
  public String getUserInterraction(){
    return "Error";
  }

}
