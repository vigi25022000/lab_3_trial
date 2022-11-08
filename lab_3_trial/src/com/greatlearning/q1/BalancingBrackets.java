package com.greatlearning.q1;

import java.util.Stack;

public class BalancingBrackets {
	
	
	// Main method to pass inputs and print result
	public static void main(String[] args) {
		String input = "([[{}]]()";
		boolean result = isBalancedStringExp(input);
		if(result) {
			System.out.println("The entered String has Balanced Brackets");
		}else {
			System.out.println("The entered Strings do not contain Balanced Brackets");
		}
	}
	
	// Using Stack we will iterate over each character and find the 
	// string has balanced brackets
	// If the char is Open brace, Push into Stack
	// Else pop up the last char from stack, verify it is corresponding open braces for input close braces
	// if So we will continue with next character, else return false come out of iteration
	// Finally, We will return true stack is empty else return false 
	private static boolean isBalancedStringExp(String input) {
		Stack<Character> data = new Stack<Character>();
		//for(char ch : input.toCharArray())
		for(int i=0;i<input.length();i++) {
			char ch = input.charAt(i);
			if(ch == '(' || ch == '[' || ch == '{') {
				data.push(ch);
				continue;
			}
			// We are encountering close braces and stack is empty(no corresponding open braces)
			if(data.isEmpty()) {
				return false;
			}
			char matchCh = data.pop();
			switch(ch) {
				case ')':
					if(matchCh != '(') {
						return false;
					}
					break;
				case ']':
					if(matchCh != '[') {
						return false;
					}
					break;
				case '}':
					if(matchCh != '{') {
						return false;
					}
					break;
			}
		}
		return data.isEmpty();
	}
}