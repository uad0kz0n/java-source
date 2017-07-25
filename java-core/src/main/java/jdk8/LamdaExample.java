package jdk8;

public class LamdaExample {

	public static void main(String[] args) {
		String input="The <em>quick</em> fox and the <b>lazy</b> dog.";
		
		String revised = input.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
		System.out.println(revised);
		// Thread - traditional
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello World.");
			}
		}).start();
		
		// Thread - Lambda Expression
		new Thread(()->{
			System.out.println("Hello World. -  Lambda Expression");
		}).start();
		
		Func add = (int a, int b) -> a + b;
		
		Func sub = (int a, int b) -> a - b;
		
		Func add2 = (int a, int b) -> { return a + b; };
		
		int result = add.calc(1,2) + add2.calc(3, 4); // 10
	
		Runnable r=() -> System.out.println();
		
	}

}
