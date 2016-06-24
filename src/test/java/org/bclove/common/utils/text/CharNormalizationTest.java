package org.bclove.common.utils.text;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CharNormalizationTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCompositeTextConvert() {
		String result = CharNormalization.compositeTextConvert("焱暒妏 趕緊把菊花洗乾净  獓獓獓獓獓獓獓獓獓 網頁の吙煋呅啭換噐 吥螚過藘炏猩炆の過藘喺綂莈囿噫锶 筷菈倒紦，朕の溱嘟亡ㄋ，說這些冇什庅甪", true,
				true, false, false,
				false, false,
				false, false);
		System.out.println(result);
		 
	}

	@Test
	public void testIsSeperatorSymbol() {
		fail("Not yet implemented");
	}

	@Test
	public void testCompositeCharConvert() {
		fail("Not yet implemented");
	}

	@Test
	public void testConvertCharT2S() {
		fail("Not yet implemented");
	}

	@Test
	public void testConvertCharM2S() {
		fail("Not yet implemented");
	}

	@Test
	public void testConvertChar2Lower() {
		fail("Not yet implemented");
	}

	@Test
	public void testConvertCharDBC() {
		fail("Not yet implemented");
	}

	@Test
	public void testConvertCharSynonymy() {
		fail("Not yet implemented");
	}

	@Test
	public void testFilterNonJapanese() {
		fail("Not yet implemented");
	}

	@Test
	public void testFilterSymbol() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCharFromTable() {
		fail("Not yet implemented");
	}

	@Test
	public void testStringReverse() {
		fail("Not yet implemented");
	}

	@Test
	public void testCharArray() {
		fail("Not yet implemented");
	}

}
