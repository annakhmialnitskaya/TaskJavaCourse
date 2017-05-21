package com.epam.interview.task;

import com.epam.interview.task.entity.Sentence;
import com.epam.interview.task.exception.BusinessException;

public class Main {

	public static void main(String[] args) {
		Sentence sentence = new Sentence("es", "#added#");
		try {
			sentence.addWord("Replaces");
			sentence.addPunctuationAndSpaceOrSpaceOnly(' ');
			sentence.addWord("eaces");
			sentence.addPunctuationAndSpaceOrSpaceOnly('!');
			sentence.addWord("substring");
			sentence.addPunctuationAndSpaceOrSpaceOnly('?');
			sentence.addWord("ofes");
			sentence.addPunctuationAndSpaceOrSpaceOnly(',');
			sentence.addWord("thes");
			sentence.addPunctuationAndSpaceOrSpaceOnly(' ');
			sentence.addWord("string");
			sentence.addPunctuationAndSpaceOrSpaceOnly(' ');
			sentence.addWord("thates");
			sentence.addPunctuationAndSpaceOrSpaceOnly(':');
			sentence.addWord("matches");
			sentence.addPunctuationAndSpaceOrSpaceOnly('.');
			System.out.println(sentence);
		} catch (BusinessException exception) {
			System.out.println(exception.getMessage());
		}
	}

}
