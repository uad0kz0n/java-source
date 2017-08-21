/**
 * 
 */
package algorithm.sort;

/**
 * @author uad0kz0n
 * 시간복잡도 : 최악 O(n^2), 평균 O(nlogn)
 * 출처: http://hahahoho5915.tistory.com/9 [넌 잘하고 있어]
 */
public class QuickSort {
	
	public static void sort(int[] data,final int l, final int r) {
		int left = l;
		int right = r;
		int pivot = data[(l + r) / 2];

		do {
			while (data[left] < pivot)
				left++;
			while (data[right] > pivot)
				right--;
			if (left <= right) {
				int temp = data[left];
				data[left] = data[right];
				data[right] = temp;
				left++;
				right--;
			}
		} while (left <= right);

		if (l < right) {
			sort(data, l, right);
		}
		if (r > left) {
			sort(data, left, r);
		}
	}

	public static void main(String[] args) {
	        
	        int data[] = {66, 10, 1, 34, 5, -10};
	        
	       sort(data, 0, data.length - 1);
	        for(int i=0; i<data.length; i++){
	            System.out.println("data["+i+"] : "+data[i]);
	        }
	    }

}
