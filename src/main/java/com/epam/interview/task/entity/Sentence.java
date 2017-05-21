package com.epam.interview.task.entity;

import java.util.ArrayList;
import java.util.List;

import com.epam.interview.task.exception.BusinessException;

public class Sentence {
	private List<Word> words;
	// This is subString after which wordToInsert will be inserted
	private String subString;
	private String wordToInsert;

	private static final String PUNCTUATIONS = ".,:;?!";
	private static final String EXCEPTION_MESSAGE_WRONG_PUNCTUATION_MARK = "Error: You have to use punctuation marks or spaces only! Incorrect symbol: %1$c";

	public Sentence(String subString, String wordToInsert) {
		this.words = new ArrayList<>();
		this.subString = subString;
		this.wordToInsert = wordToInsert;
	}

	/**
	 * This method checks if newWord ends with subString: if true - adds
	 * wordToInsert to newWord; otherwise - do nothing then adds the result to
	 * the words list of this sentence
	 */
	public void addWord(String newWord) {
		if (newWord.endsWith(subString)) {
			newWord = newWord + wordToInsert;
		}
		words.add(new Word(newWord));
	}

	/**
	 * If this method receives and returns: 1) punctuation mark - punctuation
	 * mark and a space; 2) space - space only; 3) otherwise - throws a
	 * BusinesException
	 */
	public void addPunctuationAndSpaceOrSpaceOnly(char newSign) throws BusinessException {
		String stringToAdd = " ";
		if (newSign != ' ') {
			if (PUNCTUATIONS.contains(String.valueOf(newSign))) {
				stringToAdd = newSign + " ";
			} else {
				throw new BusinessException(EXCEPTION_MESSAGE_WRONG_PUNCTUATION_MARK, newSign);
			}
		}
		words.add(new Word(stringToAdd));
	}

	public List<Word> getWords() {
		return words;
	}

	public void setWords(List<Word> words) {
		this.words = words;
	}

	public String getSubString() {
		return subString;
	}

	public void setSubString(String subString) {
		this.subString = subString;
	}

	public String getWordToInsert() {
		return wordToInsert;
	}

	public void setWordToInsert(String wordToInsert) {
		this.wordToInsert = wordToInsert;
	}

	@Override
	public String toString() {
		StringBuilder content = new StringBuilder();
		for (Word word : words) {
			content.append(word.getContent());
		}
		return content.toString();
	}

}
