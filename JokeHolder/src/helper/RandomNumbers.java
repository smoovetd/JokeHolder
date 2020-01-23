package helper;

import java.util.Random;

public class RandomNumbers{
    public static void main(String[] args){
        
        int minNum = 0;
        int maxNum = 20;
        
        
        for(int i=0; i < 30; i++){
            System.out.println(i + ". " + getRandomNum(minNum, maxNum));
        }
    }
    
    private static int getRandomNum(int min, int max){
      if(min >=max){
          System.out.println("getRandomNum() - ERROR - min (" + min + ")  should be smaller than max (" + max + ")");
      }
      
      Random rand = new Random();
      int crntInt = 0;
      
      crntInt = rand.nextInt((max - min) + 1) + min;
      
      return crntInt;
    }
}