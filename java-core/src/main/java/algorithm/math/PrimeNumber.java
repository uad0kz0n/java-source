package algorithm.math;

import java.util.stream.IntStream;

public class PrimeNumber {
 

	public static boolean isPrimeNumber(int num) {

		boolean isPrime = true;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}

	public static int[] primeNumbers(int num) {
		int[] arr = IntStream.range(0, num + 1).toArray();
		arr[1]=0;	//1 is not prime number
		
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (arr[i] == 0)
				continue;

			for (int j = i + i; j <= num; j += i) { // Multiples of i ,except i ,are checked to 0
				arr[j] = 0;
			}

		}
		return arr;
	}

}
