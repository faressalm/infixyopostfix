package eg.edu.alexu.csd.datastructure.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UApplication {

	@Test
	void test() {
		Application obj=new Application();
		String x=obj.infixToPostfix("( 52 - -32 * 3 ) + -8 * 7 / 8 - 11 * ( 32 / 4 - 13 ) + 25 ^ 2");
		assertEquals("52 0 32 - 3 * - 0 8 - 7 * 8 / + 11 32 4 / 13 - * - 25 2 ^ +",x);
		int ans=obj.evaluate(x);
		assertEquals(821,ans);
	}

	@Test
	void test1() {
		Application obj=new Application();
		String x=obj.infixToPostfix("180 - ( ( 26 - 6 ) / 6 + 5 * 2 ) * 7 ^ -2");
		assertEquals("180 26 6 - 6 / 5 2 * + 7 0 2 - ^ * -",x);
		int ans=obj.evaluate(x);
		assertEquals(179,ans);
	}
	@Test
	void test2() {
		Application obj=new Application();
		String x=obj.infixToPostfix("(a / (b - c + d)) * (e - a) * c");
		assertEquals("a b c - d + / e a - * c *",x);
		
	}
	@Test
	void test3() {
		Application obj=new Application();
		assertThrows (RuntimeException.class,() -> obj.infixToPostfix("( 2 - 1") );
	}
	@Test
	void test4() {
		Application obj=new Application();
	assertThrows (RuntimeException.class,() -> obj.infixToPostfix("3 * 5 -2 )") );
	}
	@Test
	void test5() {
		Application obj=new Application();
	assertThrows (RuntimeException.class,() ->obj.evaluate(obj.infixToPostfix("4 * * 3") ));
	}
	@Test
	void test6() {
		Application obj=new Application();
	assertThrows (RuntimeException.class,() -> obj.infixToPostfix("a + bc -5 +d") );
	}
 	@Test
	void test7() {
		Application obj=new Application();
		assertThrows (RuntimeException.class,() -> obj.infixToPostfix("5 + () - 2") );
	}
	@Test
	void test8() {
		Application obj=new Application();
		assertThrows (RuntimeException.class,() -> obj.evaluate("5 2 + {") );
	}
	@Test
	void test9() {
		Application obj=new Application();
		assertThrows (RuntimeException.class,() -> obj.evaluate(obj.infixToPostfix("5 / 0 + 2 * 3")) );
	}
	@Test
	void test10() {
		Application obj=new Application();
		assertThrows (RuntimeException.class,() -> obj.infixToPostfix("5 + { - 2") );
	}
	@Test
	void test11() {
		Application obj=new Application();
		assertThrows (RuntimeException.class,() -> obj.infixToPostfix("27 * 2 - ( 3*) ") );
	}
	@Test
	void test12() {
		Application obj=new Application();
		String x=obj.infixToPostfix("2 * 1 + 23 *4 - 236");
		assertEquals("2 1 * 23 4 * + 236 -",x);
		int ans=obj.evaluate(x);
		assertEquals(-142,ans);
	}
	@Test
	void test13() {
		Application obj=new Application();
		String x=obj.infixToPostfix("(1 + 2) * 7");
		assertEquals("1 2 + 7 *",x);
		int ans=obj.evaluate(x);
		assertEquals(21,ans);
	}
	@Test
	void test14() {
		Application obj=new Application();
		String x=obj.infixToPostfix("a / b - c + d * e - a * c");
		assertEquals("a b / c - d e * + a c * -",x);
		assertThrows (RuntimeException.class,() -> obj.evaluate(x) );
	}
	@Test
	void test15() {
		Application obj=new Application();
		assertThrows (RuntimeException.class,() -> obj.evaluate("5 4 3 -") );
	}
	/*@Test
	void test16() {
		Application obj=new Application();
		String x=obj.infixToPostfix("");
		assertEquals("",x);
		int ans=obj.evaluate(x);
		assertEquals(,ans);
	}
*/
}
