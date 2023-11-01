package Path;

import java.util.List;
import java.util.concurrent.*;
import java.util.ArrayList;
public class Field extends Thread {
	@Override
    public void run() {
    	
        int threadCount = 4; 
        long startTime = System.nanoTime();
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        List<Callable<Long>> tasks = new ArrayList<>();
        for (int i = 0; i < threadCount; i++) {
            int start = i;
           	tasks.add(new Calculator1());
        }
        try {
            // Submit tasks and get their Future objects
            List<Future<Long>> futures = executor.invokeAll(tasks);
              // invoke all - 
            long result = 0;
            for (Future<Long> future : futures) {
                result += future.get();
            }

            System.out.println("Count :" + result);
           
            long endTime = System.nanoTime();
            long execution = endTime - startTime;
            
            System.out.println("Execution time: " + execution + " nanoseconds");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
        	
            executor.shutdown();
    }
}

class Calculator1 implements Callable<Long> {
    @Override
    public Long call() {
        
        long result = 0;
        long number=2000000000;
        for (int i = 0; i <number/4; i++) {
           result++;
        }
        return result;
    }
}
}

	
	    

