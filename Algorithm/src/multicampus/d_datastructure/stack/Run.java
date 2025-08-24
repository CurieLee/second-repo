package multicampus.d_datastructure.stack;

import multicampus.d_datastructure.map._HashMap;

public class Run {

	public static void main(String[] args) {
		System.out.println(isPair("(){[]{}}"));
		System.out.println(isPair("((){[]{}}"));
		
		System.out.println('(' + ')');
		System.out.println('{' + '}');
		System.out.println('[' + ']');
	}
	
	private static boolean isPair(String text) {
		
		_Stack<Character> stack = new _Stack<Character>();
		
		for (char ch : text.toCharArray()) {
			
			if ("({[".contains(String.valueOf(ch))) {
				stack.push(ch);
				continue;
			};
			
			if (!")}]".contains(String.valueOf(ch)))	continue;
			if (stack.isEmpty())	return false;
			
			int k = stack.pop();
			if (ch + k != 81 && ch + k != 184 && ch + k != 248) return false;
		}
		
		return stack.isEmpty();
	}
	

}
