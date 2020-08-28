/* sort arbitary large array sequentially in a synchronousy manner*/

package sortSyncVsAsync;

import java.util.Arrays;

public class sortSync {
	static Double[] array1=new Double[12500000];
	static Double[] array2=new Double[7500000];
		
	public static void main(String[] args)
	{
		
		initArray1();
	    initArray2();
	    
		long start=System.currentTimeMillis();
		System.out.println("Array1 sort started");
		Arrays.sort(array1);	
		long end1=System.currentTimeMillis();
		System.out.println("Array1 sort finished : "+(end1-start)/1000.0+"S");
		

		System.out.println("Array2 sort started");
		Arrays.sort(array2);
		long end2=System.currentTimeMillis();
		System.out.println("Array2 sort over : "+(end2-end1)/1000.0+"S");
		System.out.println("Total execution time : " +  (end2-start)/1000.0 +"S");
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
