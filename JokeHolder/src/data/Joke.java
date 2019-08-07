package data;

import java.util.HashSet;

public class Joke{

  private long id;

  private String content;

  private HashSet<String> tags;

  public Joke(String content){
      this.tags = new HashSet<String>();
      this.setId(getnextFreeId());
      this.setContent(content);
  }

  private void setContent(String content){
    this.content = content;
  }

  private void setId(long id){
    this.id = id;
  }

  public long getId(){
    return this.id;
  }

  public String getContent(){
    return this.content;
  }

  public static long getnextFreeId(){
    long crntId = JokeParams.nextFreeID;
    JokeParams.nextFreeID++;
    return crntId;
  }

  private void setTag(String tag){
    this.tags.add(tag);
  }

  public void removeTag(String tag){
    this.tags.remove(tag);
  }

  public HashSet<String> getTags(){
    return this.tags;
  }

  @Override
  public String toString(){
    int indTag = 0;
    int tagsCount = this.getTags().size();
    String[] tags = new String[tagsCount];

    for(String crntTag : this.getTags()){
      tags[indTag] = crntTag;
      indTag++;
    }
    String result = "";
    result = "Joke ID: " + this.getId() + "\n\t" + this.getContent();
    if(tagsCount == 0){
      result += "\n\tno tags";
    } else{
      result += "\n\t" + tagsCount + " tags:";
      for(int i = 0; i < tags.length; i++){
        result+="\t" + tags[i];
      }
    }

    return result;
  }
}
