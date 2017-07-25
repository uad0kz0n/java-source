package tesco;

public class Solution1 {

	public static void main(String[] args) {
		int revised=Integer.parseInt("011100", 2);
		int step=0;
		
		 
		while(revised>0){
			step++;
			System.out.println(Integer.toBinaryString(revised));
			if(revised%2==0){
				revised/=2;
			}else{
				revised--;
			}
		}
		System.out.println(step);
	//	System.out.println(revised);
	//	System.out.println(revised>>1);
		System.out.println(0b011100 >> 1 >>1 >>1 >>1 >>1);
	}

}
