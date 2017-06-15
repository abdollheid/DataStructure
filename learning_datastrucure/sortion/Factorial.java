/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learning_datastrucure.sortion;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author abdullah
 */
public class Factorial {
      public static void fact(String[] args) throws Exception {
     BigInteger b =new BigInteger("1");
     Scanner in =new Scanner(System.in);
    long limit = in.nextLong();
    
     
     for(int i =1;i<=limit;++i){
         BigInteger iValue = new BigInteger(i+"");
        b = b.multiply(iValue);
     }
     String value = b.toString();
     System.out.println(value);
     char valueInChar[]=value.toCharArray();
     char formattedOutput[]=new char[10000];
     int thisIndex=0;
     int exp=0;
     for(int i =value.length()-1;i>=0;--i){ // 0000    1_000   
         if(((value.length()-1)-i)%3==0 &&i!=value.length()-1){
                 formattedOutput[thisIndex++]='_';
              formattedOutput[thisIndex++]=valueInChar[i];
              ++exp;
          
              
         }else {
             formattedOutput[thisIndex++]=valueInChar[i];
           
         }
         
         
     }
     String lastThousand="";
     boolean done=false ;
     for(int i=thisIndex-1;i>=0;--i){
         System.out.print(formattedOutput[i]);
         if(!done){
             if(formattedOutput[i]!='_'){
                 lastThousand+=formattedOutput[i]+"";
             }
             else {
                 done =true ;
             }
         }
     }
         
     
        System.out.println("\n"+lastThousand+"*1000^"+exp);
         
   
        
    }
    
}
