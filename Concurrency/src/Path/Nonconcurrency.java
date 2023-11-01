//package loops;
package Path;



public class Nonconcurrency{  
	
 public void start(){  
	 long start = System.nanoTime();
	
   
 long number=2000000000;//It is the number to calculate factorial    
  long result = 0;
  for(int i=1;i<=number;i++){    
      result++;  
  }    
  long end = System.nanoTime();
  long execution = end - start;
  String.valueOf(execution);
  System.out.println("Execution time: " + execution + " nanoseconds");
 }  
}  