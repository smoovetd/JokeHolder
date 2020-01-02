package helper;

public class StringArraySplit{
    public static void main(String[] args){
        String arrWithVals = "(test1, test2)";
        String arrWithNoVals = "()";
        
        System.out.println(arrWithVals);
        
        String resultVals = arrWithVals.split("\\(")[1];
        resultVals = resultVals.split("\\)")[0];
      
        System.out.println("result Vals: " + resultVals);
        
      /*  for (int i = 0; i < resultVals.length; i++){
          System.out.println(i + ". " + resultVals[i]);
        }
      */  
    }
}