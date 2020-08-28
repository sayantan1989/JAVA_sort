package sortSyncVsAsync;

import java.util.Arrays;

public class sortAsync {
	static Double[] array1=new Double[12500000];
	static Double[] array2=new Double[7500000];
		
	public static void main(String[] args)
	{
		
		initArray1();
	    initArray2();
	    
		long start=System.currentTimeMillis();
		//Arrays.sort(array1);	
		System.out.println("Array1 sort started");
		sortThread t1=new sortThread(array1,"thread1");
		
		//Arrays.sort(array2);
		System.out.println("Array2 sort started");
		sortThread t2=new sortThread(array2,"thread2");
		
		//loop infinitely till both the thread execution is complete
		while(t2.p.isAlive() ||  t2.p.isAlive() )
		{			
			try {
				Thread.sleep(1); //for optimal time
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		System.out.println("Sort of Array1 and Array2 asynchornously done");
		long end=System.currentTimeMillis();
		System.out.println("Total execution time : " +  (end-start)/1000.0 );
	}
	
	private static void initArray1() 
	{
		for (int i = 0; i < 12500000; i++) { //12.5 million
		    array1[i]=(Double)(Math.random()*10000000);
		}
	}
	private static void initArray2() 
	{
		for (int i = 0; i < 7500000; i++) { //7.5 million
		    array2[i]=(Double)(Math.random()*10000000);
		}
	}
}

class sortThread implements Runnable
{
	Thread p;	
	Double[] array;

	sortThread(Double[] arr,String name)
	{
		array = arr;
		p=new Thread(this,name);
		p.start();		
	}

	public void run()
	{
	 		Arrays.sort(array);			
	}
}
