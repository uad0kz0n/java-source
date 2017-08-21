package algorithm.math;

import java.util.Stack;

public class ArithmeticExpression {

	public boolean isParenthesisValid(String value) {

		Stack<Character> stack = new Stack<>();
		
		int expSize = value.length();
		
		for (int i = 0; i < expSize; i++) {
			char part = value.charAt(i);

			switch (part) {
			case '(':
			case '[':
			case '{':
				stack.push(part);
				break;
			case ')':
			case ']':
			case '}':
				if (stack.isEmpty()) {
					return false;
				} else {
					char openPair = stack.pop();
					//System.out.println(openPair);
					if ((openPair == '(') && (part != ')') || (openPair == '[') && (part != ']') || (openPair == '{') && (part != '}')) {
						return false;

					} else {
						break;
					}
				}
			default:
			}
		}

		if (stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

}
