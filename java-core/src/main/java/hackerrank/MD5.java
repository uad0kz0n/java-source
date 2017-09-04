package hackerrank;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class MD5 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			String str = sc.next();
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte[] digest = md.digest();
			for (byte b : digest) {
				//'x', 'X'  integral  The result is formatted as a hexadecimal integer  
				System.out.printf("%02x", b);
				
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

	 
	}

}
