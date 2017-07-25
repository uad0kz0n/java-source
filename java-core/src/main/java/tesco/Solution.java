package tesco;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

	public static void main(String[] args) {

		String inputVal = "A12LE10";
		String modified=changeFormat2(inputVal);

		System.out.println(modified);

	}

	static String changeFormat(String original) {
		String revised = "";
		String sub = "";

		for (int i = 0; i < original.length(); i++) {
			sub = original.substring(i, i + 1);
			if (sub.matches("\\d")) {
				for (int j = 0; j < Integer.parseInt(sub); j++) {
					revised = revised.concat("?");
				}
			} else {
				revised = revised.concat(sub);
			}
		}
		return revised;

	}

	public boolean solution(String S, String T) {
		boolean flag = true;

		S = changeFormat(S);
		T = changeFormat(T);

		if (S.length() != T.length()) {
			flag = false;
		} else {
			for (int i = 0; i < S.length(); i++) {
				if (!(S.substring(i, i + 1).equals(T.substring(i, i + 1))) && !(S.substring(i, i + 1).equals("?"))
						&& !(T.substring(i, i + 1).equals("?"))) {
					flag = false;
					break;
				}
			}
		}
		return flag;
	}

	static String changeFormat2(String original) {
		Pattern pattern = Pattern.compile("[\\d]+");
		Matcher matcher = pattern.matcher(original);
		  
		StringBuffer replacedString = new StringBuffer();
		
		while (matcher.find()) {
			String revised="";
			for (int j = 0; j < Integer.parseInt(matcher.group()); j++) {
				revised = revised.concat("?");
			}
			
			 
			matcher.appendReplacement(replacedString, revised);
		}
		matcher.appendTail(replacedString);
		return replacedString.toString();

	
	
	}

}
