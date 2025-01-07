

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.*;

public class Tester {

   @Test
   public void partA () {
      LightBoard test = new LightBoard(500,650);
      int rows = test.getLights().length;
      int cols = test.getLights()[0].length;
      assertEquals(500,rows);
      assertEquals(650,cols);
      // double count = 0;
      // for(int r = 0; r < rows;r++)
      //   for(int c = 0; c < cols; c++)
      //     if(test.getLights()[r][c])
      //       count++;
      // assertEquals(0.4,count/(rows*cols),0.2);
      // Don't think you can test this since it's random
   }

   @Test
   public void partB(){
      LightBoard test = new LightBoard(7,5);
      String[] stars = {"**.**", "*..*.", "*..**", "*...*", "*...*", "**.**", "....."};
      boolean[][] newLights = test.getLights();
      for (int r = 0; r < stars.length; r++)
         for (int c = 0; c < stars[0].length(); c++)
           newLights[r][c] = stars[r].charAt(c) == '*';
      assertEquals(false,test.evaluateLight(0, 3),partBFail(false,0,3));
      assertEquals(true,test.evaluateLight(6, 0),partBFail(true,6,0));
      assertEquals(false,test.evaluateLight(4, 1),partBFail(false,4,1));
      assertEquals(true,test.evaluateLight(5, 4),partBFail(true,5,4));
   }

   private String partBFail(boolean expected, int num1, int num2){
      return "Expected " + expected + " with evaluateLight(" + num1 + "," + num2 + "), but output was " + !expected;
   }


}
