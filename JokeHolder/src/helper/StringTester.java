package src.data;

import java.util.HashSet;

public class StringTester{

  public static void main(String[] args){
    HashSet<String> testTags = new HashSet<String>();

    JokeParams jokeParam = new JokeParams();

    testTags.add("tag1");
    testTags.add("tag2");
    testTags.add("tag3");
    testTags.add("tag4");

    String[] tagsString = new String[testTags.size()];

    int tagIndex = 0;
    for (String crntTag : testTags){
      tagsString[tagIndex++] = crntTag;
    }

    System.out.println("Array size: " + tagsString.length);
    for (int i = 0; i < tagsString.length; i++){
      System.out.println("Element: " + i + " -> " + tagsString[i]);
    }

    System.out.println(jokeParam.STR_END_JOKE);
    System.out.println(JokeParams.STR_CANCEL_ENTERING);
  }
}
