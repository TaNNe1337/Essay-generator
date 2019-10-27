package com.qualitype.Essay;

import java.nio.file.Paths;

import org.junit.Test;

public class EssayTest {
	Essay classUnderTest = new Essay();

	@Test
	public void testGenerateEssay() {
		classUnderTest.readText(Paths.get("src/test/resources/Test.txt"));
		final String text = classUnderTest.generateEssay();
		System.out.println(text);
	}
}
