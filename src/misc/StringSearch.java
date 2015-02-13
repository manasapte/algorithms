package misc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StringSearch {
	
	String smallestWindow(String haystack, String needle) {
	/*	int nIndex = 0;
		Queue<Character> window = new LinkedList<Character>();
		for(int i=0; i< haystack.length(); i++) {
			char currentChar = haystack.charAt(i);
			if(needle.indexOf(haystack.charAt(i)) != -1) {
				if(window.size() < needle.length()) {
					window.add(currentChar);
				} else {
					if(window.peek() == currentChar) {
						
					}
				}
			}
		}*/
		return "";
	}
	
	public static void main(String[] args) {
		String haystack = "FKIYTCVFBNKUYTF";
		String needle = "KYTF";
		StringSearch s = new StringSearch();
		System.out.println("smallest window is: "+ s.smallestWindow(haystack, needle));
	}

}
