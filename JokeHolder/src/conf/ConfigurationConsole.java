package src.conf;

import src.io.*;
import src.storage.*;

public class ConfigurationConsole implements Configuration{
  private Output crntOutput;

  private Input crntInput;

  private Storage crntStorage;

  public ConfigurationConsole(String dbName){
    this.setCrntInput(new ConsoleInput());
    this.setCrntOutput(new ConsoleOutput());
    this.setCrntStorage(new StorageInDb(dbName));
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

  private void setCrntStorage(Storage storage){
    this.crntStorage = storage;
  }

  public Storage getCrntStorage(){
    return this.crntStorage;
  }
}
