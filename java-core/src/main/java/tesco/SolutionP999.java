package tesco;

public class SolutionP999 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solution(int[] A) {
		int index = -1;
		double partialSumBeforePoint = 0;
		for (int i = 0; i < A.length; i++) {
			double partialSumAfterPoint = 0;
			for (int j = i+1; j < A.length; j++) {

				partialSumAfterPoint += A[j];

			}
			if ((partialSumBeforePoint - partialSumAfterPoint) == 0) {
				index = i;
				break;
			}
			partialSumBeforePoint += A[i];
		}
		return index;

	}
}
