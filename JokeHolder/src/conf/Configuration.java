package src.conf;

import src.io.*;
import src.storage.*;

public interface Configuration{

  public Input getCrntInput();

  public Output getCrntOutput();

  public Storage getCrntStorage();

}
