package src.exceptions;

import java.lang.Exception;

public class JokeCreationException extends Exception{

  public JokeCreationException(String errorMessage){
    super(errorMessage);
  }

}
