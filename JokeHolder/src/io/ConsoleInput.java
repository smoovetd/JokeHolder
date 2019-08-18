package src.io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleInput implements Input{
  //Commented due to issue with multi-lines pasting - only first line is saved!
 /*  @Override
 public String getInput() throws IOException{
    DataInputStream dis = new DataInputStream(System.in);
    StringBuilder sb = new StringBuilder();
    String crntString = "";

    while ((crntString = dis.readLine().trim()) != null){
      ByteBuffer byteBuff = StandardCharsets.UTF_8.encode(crntString);

      String newString = new String(byteBuff.array(), StandardCharsets.UTF_8);
      sb.append(newString);
      if(crntString.split("\\n").length == 1){
        break;
      }
    }

    String result = sb.toString();

    return result;
  }
*/
  @Override
  public String getInput() throws IOException {
    ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    InputStream inputStream = new DataInputStream(System.in);
    while (true) {
      int crntByte = inputStream.read();
      if (crntByte < 0) {
        throw new IOException("Data truncated");
      }
      if (crntByte == 0x0A) {
        break;
      }
      buffer.write(crntByte);
    }

    String result = new String(buffer.toByteArray(), "UTF-8");
    return result;
  }


 /* @Override
  public String getInput() throws IOException{
    Scanner scanner = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    String result = null;

    while(scanner.hasNextLine()){
      String crntLine = scanner.nextLine();
      if(crntLine.isEmpty()){
        break;
      }
      sb.append(crntLine);
      if(crntLine.split("\n").length == 1){
        break;
      }
    }

    result = sb.toString();

    return result;
  }
*/

  @Override
  public String getUserInterraction(){
    return "Error";
  }

}
