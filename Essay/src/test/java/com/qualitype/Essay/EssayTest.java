package com.qualitype.Essay;

import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;;

public class EssayTest {
	Essay classUnderTest = new Essay();

	@Test
	public void testReadText() {
		classUnderTest.readText(Paths.get("src/test/resources/shortTest.txt"));
		Assert.assertEquals(
				"([This, is, a, Test., A, test, good, to, things.], [(This,is), (is,a), (a,Test.), (Test.,A), (A,test), (test,is), (is,good), (good,to), (to,test), (test,things.)])",
				classUnderTest.getG().toString());
	}

	@Test
	public void testReadText_Empty() {
		classUnderTest.readText(Paths.get("src/test/resources/emptyFile.txt"));
		Assert.assertEquals("([], [])", classUnderTest.getG().toString());
	}

	@Test
	public void testGenerateEssay_Empty() {
		classUnderTest.readText(Paths.get("src/test/resources/emptyFile.txt"));
		final String text = classUnderTest.generateEssay();
		Assert.assertEquals(null, text);
	}
}
