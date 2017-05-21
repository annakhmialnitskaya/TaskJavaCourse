package com.epam.interview.task.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.epam.interview.task.exception.BusinessException;

public class SentenceTest {

	private static final String SUBSTRING = "subString";
	private static final String WORD_TO_INSERT = "wordToInsert";
	private Sentence testObject;

	@Before
	public void setUp() {
		testObject = new Sentence(SUBSTRING, WORD_TO_INSERT);
	}

	@Test
	public void constructorTest() {
		assertEquals(SUBSTRING, testObject.getSubString());
		assertEquals(WORD_TO_INSERT, testObject.getWordToInsert());
		assertNotNull(testObject.getWords());
		assertTrue(testObject.getWords().isEmpty());
	}

	@Test
	public void addWordAddNewWordCaseTest() {
		// new word ends with SUBSTRING
		testObject.addWord("testWordWithsubString");
		assertEquals(1, testObject.getWords().size());
		assertNotNull(testObject.getWords().get(0));
		assertEquals("testWordWithsubStringwordToInsert", testObject.getWords().get(0).getContent());
	}

	@Test
	public void addWordNotToReplaceCaseTest() {
		// new word does not end with SUBSTRING
		testObject.addWord("testWordWithSub");
		assertEquals(1, testObject.getWords().size());
		assertNotNull(testObject.getWords().get(0));
		assertEquals("testWordWithSub", testObject.getWords().get(0).getContent());
	}

	@Test
	public void addPunctuationAndSpaceCasesTest() throws BusinessException {
		char punctuationMark_period = '.';
		testObject.addPunctuationAndSpaceOrSpaceOnly(punctuationMark_period);
		assertEquals(1, testObject.getWords().size());
		assertEquals(". ", testObject.getWords().get(0).getContent());
		testObject = new Sentence(SUBSTRING, WORD_TO_INSERT);

		char punctuationMark_comma = ',';
		testObject.addPunctuationAndSpaceOrSpaceOnly(punctuationMark_comma);
		assertEquals(1, testObject.getWords().size());
		assertEquals(", ", testObject.getWords().get(0).getContent());
		testObject = new Sentence(SUBSTRING, WORD_TO_INSERT);

		char punctuationMark_semi_colon = ';';
		testObject.addPunctuationAndSpaceOrSpaceOnly(punctuationMark_semi_colon);
		assertEquals(1, testObject.getWords().size());
		assertEquals("; ", testObject.getWords().get(0).getContent());
		testObject = new Sentence(SUBSTRING, WORD_TO_INSERT);

		char punctuationMark_colon = ':';
		testObject.addPunctuationAndSpaceOrSpaceOnly(punctuationMark_colon);
		assertEquals(1, testObject.getWords().size());
		assertEquals(": ", testObject.getWords().get(0).getContent());
		testObject = new Sentence(SUBSTRING, WORD_TO_INSERT);

		char punctuationMark_question = '?';
		testObject.addPunctuationAndSpaceOrSpaceOnly(punctuationMark_question);
		assertEquals(1, testObject.getWords().size());
		assertEquals("? ", testObject.getWords().get(0).getContent());
		testObject = new Sentence(SUBSTRING, WORD_TO_INSERT);

		char punctuationMark_exclamation = '!';
		testObject.addPunctuationAndSpaceOrSpaceOnly(punctuationMark_exclamation);
		assertEquals(1, testObject.getWords().size());
		assertEquals("! ", testObject.getWords().get(0).getContent());
	}

	@Test
	public void addSpaceOnlyCaseTest() throws BusinessException {
		char space = ' ';
		testObject.addPunctuationAndSpaceOrSpaceOnly(space);
		assertEquals(1, testObject.getWords().size());
		assertEquals(" ", testObject.getWords().get(0).getContent());
	}

	@Test(expected = BusinessException.class)
	public void addIncorrectValuesLetterTest() throws BusinessException {
		char incorrectSymbol_Letter = 'q';
		testObject.addPunctuationAndSpaceOrSpaceOnly(incorrectSymbol_Letter);
	}

	@Test(expected = BusinessException.class)
	public void addIncorrectValuesSpecialSymbolTest() throws BusinessException {
		char incorrectSymbol_SpecialSymbol = '+';
		testObject.addPunctuationAndSpaceOrSpaceOnly(incorrectSymbol_SpecialSymbol);
	}

	@Test(expected = BusinessException.class)
	public void addIncorrectValuesDigitTest() throws BusinessException {
		char incorrectSymbol_Digit = '9';
		testObject.addPunctuationAndSpaceOrSpaceOnly(incorrectSymbol_Digit);
	}

}
