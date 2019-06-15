
import java.io.*;

public class InputTester{

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String result = "";

    System.out.println("Enter something: ");

    result = br.readLine();

    System.out.println("You have entered: " + result);

  }
}
