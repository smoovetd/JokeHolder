package src.conf;

import src.io.*;

public class ConfigurationConsole implements Configuration{
  private Output crntOutput;

  private Input crntInput;

  public ConfigurationConsole(){
    this.setCrntInput(new ConsoleInput());
    this.setCrntOutput(new ConsoleOutput());
  }

  private void setCrntInput(Input input){
    this.crntInput= input;
  }

  public Input getCrntInput(){
    return this.crntInput;
  }

  private void setCrntOutput(Output output){
    this.crntOutput = output;
  }

  public Output getCrntOutput(){
    return this.crntOutput;
  }

}
