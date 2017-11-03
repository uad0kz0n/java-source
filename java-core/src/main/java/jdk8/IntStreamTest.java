package jdk8;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class IntStreamTest {

	public static void main(String[] args) {
		IntStream.of(1, 2, 3).forEach( i -> System.out.printf("%d ",i) );
		System.out.println();
		// > 1, 2, 3
		IntStream.range(1, 3).forEach( i -> System.out.printf("%d ",i) );  
		System.out.println();
		// > 1, 2
		IntStream.rangeClosed(1, 3).forEach( i -> System.out.printf("%d ",i) );
		System.out.println();
		// > 1, 2, 3
		IntStream.iterate(0, i -> i + 2).limit(3).forEach( i -> System.out.printf("%d ",i) );
		System.out.println();
		// > 0, 2, 4
		
		IntStream.generate(() -> ThreadLocalRandom.current().nextInt(10)).limit(3).forEach( i -> System.out.printf("%d ",i) );
		System.out.println();
		// > n1,n2,n3
		
		
	} 

}
