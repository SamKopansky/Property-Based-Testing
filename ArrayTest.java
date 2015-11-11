import java.util.Arrays;
import java.util.Random;

public class ArrayTest
{
	public static void main(String[] args)
	{
		int test1 = minTest();
		int test2 = maxTest();
		int test3 = sortedTest();
		int test4 = sortedTwiceTest();
		int testSuccess = test1 + test2 + test4 + test4;
		int testFailure = 4 - testSuccess;
		
		System.out.println("Total Tests >> 4");
		System.out.println("Successes   >> " + testSuccess);
		System.out.println("Failures    >> " + testFailure);
		if (testSuccess == 4)
			System.out.println("GREEN!");
		else
			System.out.println("Red :(");
		
	}
	
	
	public static int minTest()
	{
		Random r = new Random();
		boolean minIsFirst = true;
		for (int i = 0; i < 100; i++)
		{
			int size = r.nextInt(99) + 2;
			int[] numbers = new int[size];
			int min = 100;
			for (int j = 0; j < size; j++)
			{
				numbers[j] = r.nextInt(100);
				if (numbers[j] < min)
					min = numbers[j];
			}
			
			Arrays.sort(numbers);
			
			if (numbers[0] != min)
			{
				minIsFirst = false;
				break;
			}
		}
		
		if (minIsFirst)
			return 1;
		return 0;
	}
	
	// Tests that max number in the array is the last number in the sorted array
	
	public static int maxTest()
	{
		Random r = new Random();
		boolean maxIsLast = true;
		for (int i = 0; i < 100; i++)
		{
			int size = r.nextInt(99) + 2;
			int[] numbers = new int[size];
			int max = 0;
			for (int j = 0; j < size; j++)
			{
				numbers[j] = r.nextInt(100);
				if (numbers[j] > max)
					max = numbers[j];
			}
			
			Arrays.sort(numbers);
			
			if (numbers[size - 1] != max)
			{
				maxIsLast = false;
				break;
			}
		}
		if (maxIsLast)
			return 1;
		return 0;
	}
	
	
	// Tests that every number in the array is less than the one after it
	
	public static int sortedTest()
	{
		Random r = new Random();
		boolean sorted = true;
		for (int i = 0; i < 100; i++)
		{
			int size = r.nextInt(99) + 2;
			int[] numbers = new int[size];
			int max = 0;
			for (int j = 0; j < size; j++)
			{
				numbers[j] = r.nextInt(100);
				if (numbers[j] > max)
					max = numbers[j];
			}
			
			Arrays.sort(numbers);
			
			for (int k = 0; k < size - 1; k++)
			{
				if (numbers[k] > numbers[k + 1])
				{
					sorted = false;
					break;
				}
			}
		}
		if (sorted)
			return 1;
		return 0;
	}
	
	// Tests that a sorting an array the twice returns the same array as sorting it once
	
	public static int sortedTwiceTest()
	{
		Random r = new Random();
		boolean sorted = true;
		for (int i = 0; i < 100; i++)
		{
			int size = r.nextInt(99) + 2;
			int[] numbers = new int[size];
			int max = 0;
			for (int j = 0; j < size; j++)
			{
				numbers[j] = r.nextInt(100);
			}
			
			Arrays.sort(numbers);
			
			int[] numbersSortedTwice = numbers;
			Arrays.sort(numbersSortedTwice);
			
			for (int k = 0; k < size - 1; k++)
			{
				if (numbers[k] != numbersSortedTwice[k])
				{
					sorted = false;
					break;
				}
			}
		}
		if (sorted)
			return 1;
		return 0;
	}

}
