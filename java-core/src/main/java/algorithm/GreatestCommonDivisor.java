package algorithm;

public class GreatestCommonDivisor {
	
	static int euclidean(int number1, int number2){
		return (number1%number2)!=0 ? euclidean(number2, number1%number2) : number2;
	}
}
