package com.ankur.java.core.problems.algorithms;

import java.util.ArrayList;
import java.util.List;

public class TextFinder {
	
	/**
	 * Alternate way of implementation
	 * Loop through the phrase as array of characters,
	 * Compare each letter to the first letter of your name, and if it sees that letter:
	 * It will push that letter and all the letters that follow it to an array, 
	 * stopping when the number of letters it pushes are equal to the number of letters in your name.
	 * 
	 * @param pattern
	 * @param phrase
	 * @return
	 */
	public String[] findMatchingPattern(String pattern, String phrase) {
		List<String> hits = new ArrayList<String>(0);
		int patternLength = pattern.length();
		int phraseLength = phrase.length();
		
		for(int i=0, l=phraseLength-patternLength; i<=l; i++) {
		    if(pattern==phrase.substring(i, i+patternLength)){
		    	hits.add(phrase.substring(i, i+patternLength));
		    }
		}
		return hits.toArray(new String[hits.size()]);
	}
}
