package javaVersionFeatures.java8.lambdaExp.practice;

import java.util.HashSet;
import java.util.Set;

public class Test {

	void printMajority(int a[], int n)
	{
		Set<Integer> set = new HashSet<Integer>();
		int majority = -1;
		for (int i = 0; i < n; i++){   //{ 11, 5, 3, 4, 5, 3, 6, 10};
			System.out.println(" Element to process = "+ a[i]);
			if (set.contains(a[i])) {
				majority = i;
				System.out.println(" element found again = "+ a[i] + " majority = "+ majority);
			} else {
				set.add(a[i]);
			}
		}
        System.out.println("set = "+ set);
		System.out.println(a[majority]);
	}

	// Driver program to test above functions
	public static void main(String[] args)
	{
		Test obj = new Test();
		int arr[] = { 11, 5, 3, 4, 5, 3, 6, 10};
		int n = arr.length;
		obj.printMajority(arr, n);
	}



}
