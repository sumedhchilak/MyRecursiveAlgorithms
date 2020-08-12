import java.util.ArrayList;
import java.util.Collections;

/**
 * Tester class for the methods in Recursive.java
 * 
 * @author scottm
 *
 */
public class RecursiveTester {

	// run the tests
	public static void main(String[] args) {
		studentTests();
	}

	// pre: r != null
	// post: run student test
	private static void studentTests() {
		// CS314 students put your tests here
		String actual = "";
		String expected = "";

		// Test 1 Binary Conversion
		actual = Recursive.getBinary(0);
		expected = "0";
		if (actual.equals(expected))
			System.out.println("Test 1 PASSED Binary.");
		else
			System.out.println("Test 1 **FAILED** Binary.");

		// Test 2 Binary Conversion
		actual = Recursive.getBinary(-513);
		expected = "-1000000001";
		if (actual.equals(expected))
			System.out.println("Test 2 PASSED Binary.");
		else
			System.out.println("Test 2 **FAILED** Binary.");

		// Test 3 Reverse String
		actual = Recursive.revString("");
		expected = "";
		if (actual.equals(expected))
			System.out.println("Test 3 PASSED Reverse String.");
		else
			System.out.println("Test 3 **FAILED** Reverse String");

		// Test 4 Reverse String
		actual = Recursive.revString("Magic Mike");
		expected = "ekiM cigaM";
		if (actual.equals(expected))
			System.out.println("Test 4 PASSED Reverse String.");
		else
			System.out.println("Test 4 **FAILED** Reverse String");

		// Test 5 Next is Double
		int[] numsForDouble = new int[] { 36, 72, 144, 72, 36 };
		int act = Recursive.nextIsDouble(numsForDouble);
		int exp = 2;
		if (act == exp)
			System.out.println("Test 5 PASSED Next Is Double.");
		else
			System.out.println("Test 5 **FAILED** Next Is Double.");

		// Test 6 Next is Double
		numsForDouble = new int[] { 1, 2, 8, 16, 48, 96 };
		act = Recursive.nextIsDouble(numsForDouble);
		exp = 3;
		if (act == exp)
			System.out.println("Test 6 PASSED Next Is Double.");
		else
			System.out.println("Test 6 **FAILED** Next Is Double.");

		// Test 7 Phone Mnemonics
		ArrayList<String> a = Recursive.listMnemonics("5");
		ArrayList<String> e = new ArrayList<>();
		Collections.sort(a);
		e.add("J");
		e.add("K");
		e.add("L");
		if (a.equals(e))
			System.out.println("Test 7 PASSED Phone Mnemonics.");
		else
			System.out.println("Test 7 **FAILED** Phone Mnemonics.");

		// Test 8 Phone Mnemonics
		a = Recursive.listMnemonics("38");
		e = new ArrayList<>();
		Collections.sort(a);
		e.add("DT");
		e.add("DU");
		e.add("DV");
		e.add("ET");
		e.add("EU");
		e.add("EV");
		e.add("FT");
		e.add("FU");
		e.add("FV");
		if (a.equals(e))
			System.out.println("Test 8 PASSED Phone mnemonics.");
		else
			System.out.println("Test 8 **FAILED** Phone mnemonics.");

		// Test 9 Can Flow Off Map
		int[][] world = { { 10, 10, 10, 10 }, { 10, 1, 10, 10 }, { 10, 10, 10, 10 }, { 10, 9, 3, 1 }, { 10, 8, 5, 10 },
				{ 10, 10, 10, 10 }, };

		boolean result = Recursive.canFlowOffMap(world, 2, 1);
		boolean expectation = true;
		if (result == expectation)
			System.out.println("Test 9 PASSED Can Flow Off Map.");
		else
			System.out.println("Test 9 **FAILED** Can Flow Off Map.");

		// Test 10 Can Flow Off Map
		world = new int[][] { { 28, 28, 28 }, { 28, 19, 28 }, { 28, 28, 28 }, { 28, 17, 28 }, { 28, 16, 28 },
				{ 28, 12, 28 }, { 28, 9, 28 }, { 28, 1, 28 }, { 28, 28, 28 } };

		result = Recursive.canFlowOffMap(world, 2, 1);
		expectation = false;
		if (result == expectation)
			System.out.println("Test 10 PASSED Can Flow Off Map.");
		else
			System.out.println("Test 10 **FAILED** Can Flow Off Map.");

		// Test 11 Min Difference

		int[] abs = { 10, 11, 12 };
		if (Recursive.minDifference(2, abs) == 9)
			System.out.println("Test 11 PASSED Min Difference.");
		else
			System.out.println("Test 11 **FAILED** Min difference.");

		// Test 12 Min Difference

		abs = new int[] { 13, 3, 9, 6, 8, 1 };
		if (Recursive.minDifference(2, abs) == 0)
			System.out.println("Test 12 PASSED Min Difference.");
		else
			System.out.println("Test 12 **FAILED** Min Difference.");

		// Test 13 Maze

		char[][] maze = { { '$', '$', 'Y', 'G', 'S', 'Y', 'E' } };
		if (Recursive.canEscapeMaze(maze) == 1)
			System.out.println("Test 13 PASSED Can Escape Maze.");
		else
			System.out.println("Test 13 **FAILED** Can Escape Maze.");

		// Test 14 Maze

		maze = new char[][] { { '$', '$', 'Y', 'G' }, { '$', 'S', 'Y', 'E' }, { '$', '$', 'Y', 'G' },
				{ '$', '$', 'Y', 'G' } };
		if (Recursive.canEscapeMaze(maze) == 2)
			System.out.println("Test 14 PASSED Can Escape Maze.");
		else
			System.out.println("Test 14 **FAILED** Can Escape Maze.");

	}

}
