package src.data;

import java.lang.StringBuilder;
import src.io.*;
import src.exceptions.*;
import java.io.IOException;

public class JokeFactory{

  public JokeFactory(){
  }

  public Joke createJoke(Input input, Output output) throws JokeCreationException, IOException{
    StringBuilder content = new StringBuilder();
    Joke crntJoke = null;
    boolean isFinished = false;

    //System.out.println(JokeParams.STR_END_JOKE);
    output.showOutput("Enter Joke content. When done write in new line: " + JokeParams.STR_END_JOKE);
    output.showOutput("If you want to cancel enter on empty line: " + JokeParams.STR_CANCEL_ENTERING);

    do{
      String crntLine = "";

      crntLine = input.getInput();

      if(crntLine.equals(JokeParams.STR_CANCEL_ENTERING)){
        throw new JokeCreationException("Canceled entering Joke!");
      }else if(crntLine.equals(JokeParams.STR_END_JOKE)){
          isFinished = true;
      } else{
        content.append(crntLine + "\n");
      }

    }while(!isFinished);

    crntJoke = new Joke(content.toString());

    this.addTagsToJoke(crntJoke, input, output);

    return crntJoke;
  }

  public void addTagsToJoke(Joke joke,Input input, Output output) throws IOException{
    String crntTag = "";
    String crntLine = "";
    boolean isFinished = false;
    output.showOutput("Add tags to joke");
    output.showOutput("To leave, just press Enter on empty line");

    do{
      crntLine = input.getInput();
      crntTag = crntLine;

      if(crntLine.equals("")){
        isFinished = true;
      }else{
        joke.setTag(crntTag);
      }
    }while(!isFinished);
  }

  public Joke createJokeWithAllParams(long id, String content) throws JokeCreationException{
    //  System.out.println("In createJokeWithAllParams() - \nid: " + id + "\ncontent: " + content);
      if(id < 0 || JokeParams.usedIds.contains(id)){
          throw new JokeCreationException("ID " + id + " is already in use!");
      }

      //for debug
  //    System.out.println("In createJokeWithAllParams() - \nid: " + id + "\ncontent: " + content);

      Joke crntJoke = new Joke(id, content);
      JokeParams.usedIds.add(id);
      return crntJoke;
  }
}
