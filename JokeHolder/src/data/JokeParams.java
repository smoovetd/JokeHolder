package src.data;

import java.util.HashSet;

public class JokeParams{
  public static long nextFreeID = 0;

  public static final String STR_END_JOKE = "#DONE#";

  public static final String STR_CANCEL_ENTERING = "#CANCEL#";

  public static HashSet<Long> usedIds = new HashSet();
}
