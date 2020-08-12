/*  Student information for assignment:
 *
 *  On OUR honor, Kaustub Navalady and Sumedh Chilakamarri, this programming assignment is OUR own work
 *  and WE have not provided this code to any other student.
 *
 *  Number of slip days used: 0
 *
 *  Student 1: Kaustub Navalady
 *  UTEID: kan2235
 *  email address: kaustub.nvd@gmail.com
 *  Grader name: Amir
 *  Section number: 50315
 *
 *  Student 2: Sumedh Chilakamarri
 *  UTEID: ssc2536
 *  email address: sumedh.chilak@utexas.edu
 *
 */

//imports

import java.util.ArrayList;
import java.util.Arrays;
import java.awt.Graphics;
import java.awt.Color;

/**
 * Various recursive methods to be implemented. Given shell file for CS314
 * assignment.
 */
public class Recursive {

	/**
	 * Problem 1: convert a base 10 int to binary recursively. <br>
	 * pre: n != Integer.MIN_VALUE<br>
	 * <br>
	 * post: Returns a String that represents N in binary. All chars in returned
	 * String are '1's or '0's. Most significant digit is at position 0
	 * 
	 * @param n the base 10 int to convert to base 2
	 * @return a String that is a binary representation of the parameter n
	 */
	public static String getBinary(int n) {
		final String ZERO_BASE_CASE = "0";
		if (n == Integer.MIN_VALUE) {
			throw new IllegalArgumentException(
					"Failed precondition: getBinary. " + "n cannot equal Integer.MIN_VALUE. n: " + n);
		}
		// Edge case for zero
		if (n == 0) {
			return ZERO_BASE_CASE;
		}
		// Regular base case
		if (n == 1 || n == -1) {
			return n + "";
		}
		// Recursive step
		return getBinary(n / 2) + ((Math.abs(n) % 2) + "");
	}

	/**
	 * Problem 2: reverse a String recursively.<br>
	 * pre: stringToRev != null<br>
	 * post: returns a String that is the reverse of stringToRev
	 * 
	 * @param stringToRev the String to reverse.
	 * @return a String with the characters in stringToRev in reverse order.
	 */
	public static String revString(String stringToRev) {
		final String EMPTY_STRING = "";
		if (stringToRev == null) {
			throw new IllegalArgumentException("Failed precondition: revString. parameter may not be null.");
		}
		// Edge case for empty string
		if (stringToRev.length() == 0) {
			return EMPTY_STRING;
		}
		// Base case
		if (stringToRev.length() == 1) {
			return stringToRev;
		}
		int lastIndex = stringToRev.length() - 1;
		String lastChar = stringToRev.charAt(lastIndex) + ""; // Gets new string without the last char
		return lastChar + revString(stringToRev.substring(0, lastIndex)); // Recursive step with new string
	}

	/**
	 * Problem 3: Returns the number of elements in data that are followed directly
	 * by value that is double that element. pre: data != null post: return the
	 * number of elements in data that are followed immediately by double the value
	 * 
	 * @param data The array to search.
	 * @return The number of elements in data that are followed immediately by a
	 *         value that is double the element.
	 */
	public static int nextIsDouble(int[] data) {
		if (data == null) {
			throw new IllegalArgumentException("Failed precondition: revString. parameter may not be null.");
		}
		return helperDouble(0, data); // Start at beginning of the array
	}

	// Helper method for the nextIsDouble method
	private static int helperDouble(int pos, int[] data) {
		// Base case (If we are at the last element in the array)
		if (pos == data.length - 1 || data.length == 0) {
			return 0;
		}
		if (data[pos + 1] == data[pos] * 2) {
			// Recursive step if the adjacent element IS double
			return helperDouble(pos + 1, data) + 1;
		}
		// Recursive step if the adjacent element isn't double
		return helperDouble(pos + 1, data);
	}

	/**
	 * Problem 4: Find all combinations of mnemonics for the given number.<br>
	 * pre: number != null, number.length() > 0, all characters in number are
	 * digits<br>
	 * post: see tips section of assignment handout
	 * 
	 * @param number The number to find mnemonics for
	 * @return An ArrayList<String> with all possible mnemonics for the given number
	 */
	public static ArrayList<String> listMnemonics(String number) {
		if (number == null || number.length() == 0 || !allDigits(number)) {
			throw new IllegalArgumentException("Failed precondition: listMnemonics");
		}

		ArrayList<String> result = new ArrayList<>();
		recursiveMnemonics(result, "", number);
		return result;
	}

	/*
	 * Helper method for listMnemonics mnemonics stores completed mnemonics
	 * mneominicSoFar is a partial (possibly complete) mnemonic digitsLeft are the
	 * digits that have not been used from the original number
	 */
	private static void recursiveMnemonics(ArrayList<String> mnemonics, String mnemonicSoFar, String digitsLeft) {
		String keypadCombos = digitLetters(digitsLeft.charAt(0));
		digitsLeft = digitsLeft.substring(1);
		// Base Case
		if (digitsLeft.length() == 0) {
			for (int i = 0; i < keypadCombos.length(); i++) {
				mnemonics.add(mnemonicSoFar + keypadCombos.charAt(i));
			}
		} else {
			for (int i = 0; i < keypadCombos.length(); i++) {
				// Recursive Step
				recursiveMnemonics(mnemonics, mnemonicSoFar + keypadCombos.charAt(i), digitsLeft);
			}
		}
	}

	private static final String[] letters = { "0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ" };

	/*
	 * helper method for recursiveMnemonics pre: ch is a digit '0' through '9' post:
	 * return the characters associated with this digit on a phone keypad
	 */
	private static String digitLetters(char ch) {
		if (ch < '0' || ch > '9') {
			throw new IllegalArgumentException("parameter ch must be a digit, 0 to 9. Given value = " + ch);
		}
		int index = ch - '0';
		return letters[index];
	}

	/*
	 * helper method for listMnemonics pre: s != null post: return true if every
	 * character in s is a digit ('0' through '9')
	 */
	private static boolean allDigits(String s) {
		if (s == null) {
			throw new IllegalArgumentException("Failed precondition: allDigits. String s cannot be null.");
		}
		boolean allDigits = true;
		int i = 0;
		while (i < s.length() && allDigits) {
			allDigits = s.charAt(i) >= '0' && s.charAt(i) <= '9';
			i++;
		}
		return allDigits;
	}

	/**
	 * Problem 5: Draw a Sierpinski Carpet.
	 * 
	 * @param size  the size in pixels of the window
	 * @param limit the smallest size of a square in the carpet.
	 */
	public static void drawCarpet(int size, int limit) {
		DrawingPanel p = new DrawingPanel(size, size);
		Graphics g = p.getGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, size, size);
		g.setColor(Color.WHITE);
		drawSquares(g, size, limit, 0, 0);
	}

	/*
	 * Helper method for drawCarpet Draw the individual squares of the carpet.
	 * 
	 * @param g The Graphics object to use to fill rectangles
	 * 
	 * @param size the size of the current square
	 * 
	 * @param limit the smallest allowable size of squares
	 * 
	 * @param x the x coordinate of the upper left corner of the current square
	 * 
	 * @param y the y coordinate of the upper left corner of the current square
	 */
	private static void drawSquares(Graphics g, int size, int limit, double x, double y) {
		final int DIVIDING_FACTOR = 3;
		// Base case: size <= limit
		if (size > limit) {
			final int NEW_SIZE = size / DIVIDING_FACTOR;
			final int ONE_SPACE = size / DIVIDING_FACTOR;
			final int TWO_SPACES = ONE_SPACE * 2;
			int xCord = (int) (x + ONE_SPACE);
			int yCord = (int) (y + ONE_SPACE);
			int cutoutSize = (int) ONE_SPACE;
			g.fillRect(xCord, yCord, cutoutSize, cutoutSize); // Cut-out Rectangle
			int[] xOffSet = { 0, ONE_SPACE, TWO_SPACES, 0, 0, ONE_SPACE, TWO_SPACES, TWO_SPACES };
			int[] yOffSet = { 0, 0, 0, ONE_SPACE, TWO_SPACES, TWO_SPACES, ONE_SPACE, TWO_SPACES };
			for (int i = 0; i < xOffSet.length; i++) {
				// Recursive with different offsets each iteration
				drawSquares(g, NEW_SIZE, limit, x + xOffSet[i], y + yOffSet[i]);
			}
		}
	}

	/**
	 * Problem 6: Determine if water at a given point on a map can flow off the map.
	 * <br>
	 * pre: map != null, map.length > 0, map is a rectangular matrix, 0 <= row <
	 * map.length, 0 <= col < map[0].length <br>
	 * post: return true if a drop of water starting at the location specified by
	 * row, column can reach the edge of the map, false otherwise.
	 * 
	 * @param map The elevations of a section of a map.
	 * @param row The starting row of a drop of water.
	 * @param col The starting column of a drop of water.
	 * @return return true if a drop of water starting at the location specified by
	 *         row, column can reach the edge of the map, false otherwise.
	 */
	public static boolean canFlowOffMap(int[][] map, int row, int col) {
		if (map == null || map.length == 0 || !isRectangular(map) || !inbounds(row, col, map)) {
			throw new IllegalArgumentException("Failed precondition: canFlowOffMap");
		}
		// Used to check 4 directions
		int[] dir1 = { -1, 1, 0, 0 };
		int[] dir2 = { 0, 0, -1, 1 };
		// Base Case: (On one of the four edges)
		if (row == 0 || row == map.length - 1 || col == 0 || col == map[0].length - 1) {
			return true;
		}
		for (int i = 0; i < dir1.length; i++) {
			// If the next spot's elevation is lower
			if (map[row + dir1[i]][col + dir2[i]] < map[row][col]) {
				// Recursive Step
				if (canFlowOffMap(map, row + dir1[i], col + dir2[i])) {
					return true;
				}
			}
		}
		return false;
	}

	/*
	 * helper method for canFlowOfMap - CS314 students you should not have to call
	 * this method, pre: mat != null,
	 */
	private static boolean inbounds(int r, int c, int[][] mat) {
		if (mat == null) {
			throw new IllegalArgumentException("Failed precondition: inbounds. The 2d array mat may not be null.");
		}
		return r >= 0 && r < mat.length && mat[r] != null && c >= 0 && c < mat[r].length;
	}

	/*
	 * helper method for canFlowOfMap - CS314 students you should not have to call
	 * this method, pre: mat != null, mat.length > 0 post: return true if mat is
	 * rectangular
	 */
	private static boolean isRectangular(int[][] mat) {
		if ((mat == null) || (mat.length == 0)) {
			throw new IllegalArgumentException("Failed precondition: isRectangular. "
					+ "The argument mat may not be null and must have at least one row.");
		}

		boolean correct = true;
		final int NUM_COLS = mat[0].length;
		int row = 0;
		while (correct && row < mat.length) {
			correct = (mat[row] != null) && (mat[row].length == NUM_COLS);
			row++;
		}
		return correct;
	}

	private static boolean isRectangular(char[][] mat) {
		if ((mat == null) || (mat.length == 0)) {
			throw new IllegalArgumentException("Failed precondition: isRectangular. "
					+ "The argument mat may not be null and must have at least one row.");
		}
		boolean correct = true;
		final int NUM_COLS = mat[0].length;
		int row = 0;
		while (correct && row < mat.length) {
			correct = (mat[row] != null) && (mat[row].length == NUM_COLS);
			row++;
		}
		return correct;
	}

	/**
	 * Problem 7: Find the minimum difference possible between teams based on
	 * ability scores. The number of teams may be greater than 2. The goal is to
	 * minimize the difference between the team with the maximum total ability and
	 * the team with the minimum total ability. <br>
	 * pre: numTeams >= 2, abilities != null, abilities.length >= numTeams <br>
	 * post: return the minimum possible difference between the team with the
	 * maximum total ability and the team with the minimum total ability.
	 * 
	 * @param numTeams  the number of teams to form. Every team must have at least
	 *                  one member
	 * @param abilities the ability scores of the people to distribute
	 * @return return the minimum possible difference between the team with the
	 *         maximum total ability and the team with the minimum total ability.
	 *         The return value will be greater than or equal to 0.
	 */
	public static int minDifference(int numTeams, int[] abilities) {
		if (numTeams < 2 || abilities == null || abilities.length < numTeams) {
			throw new IllegalArgumentException(
					"numTeams must be greater than or equal to two and abilities cannot be null. Abilities.length must be greater than or equal to numTeams.");
		}
		return minDiffHelper(numTeams, abilities, new int[numTeams], new boolean[numTeams], 0);
	}

	// TODO: Refactor code, create helper methods, improve efficiency by removing
	// redundant team assignments
	public static int minDiffHelper(int numTeams, int[] abilities, int[] teams, boolean[] added, int index) {
		// Base Case:
		if (index == abilities.length) {
			return findDifference(teams, added);
		}
		int minDiff = Integer.MAX_VALUE;
		int limit = Math.min(index + 1, numTeams); // Optimization in team assignments
		for (int i = 0; i < limit; i++) {
			// Add person to a team
			teams[i] += abilities[index];
			boolean prev = added[i];
			added[i] = true;
			// Recursive Step: Pass in new index to iterate from
			// Returns calculated difference for that call
			int returnValue = minDiffHelper(numTeams, abilities, teams, added, index + 1);
			if (returnValue != Integer.MAX_VALUE) {
				// Early return
				if (returnValue == 0) {
					return 0;
				}
				// If min returned is smaller than current min
				if (returnValue < minDiff) {
					minDiff = returnValue;
				}
			}
			// Undo changes
			teams[i] -= abilities[index]; // Subtract IQ from team
			if (prev == false) {
				added[i] = false; // Reset value if previously empty team
			}
		}
		return minDiff;
	}

	// Find the difference between the max team and min team
	private static int findDifference(int[] teams, boolean[] added) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < teams.length; i++) {
			int element = teams[i];
			if (element == 0 && added[i] == false) {
				// Check if the team has at least one person
//				if (added[i] == false) {
					return Integer.MAX_VALUE;
				//}
			}
			if (element < min) {
				min = element;
			}
			if (element > max) {
				max = element;
			}
		}
		return max - min;
	}

	/**
	 * Problem 8: Maze solver. Return 2 if it is possible to escape the maze after
	 * collecting all the coins. Return 1 if it is possible to escape the maze but
	 * without collecting all the coins. Return 0 if it is not possible to escape
	 * the maze. More details in the assignment handout. <br>
	 * pre: board != null <br>
	 * pre: board is a rectangular matrix <br>
	 * pre: board only contains characters 'S', 'E', '$', 'G', 'Y', and '*' <br>
	 * pre: there is a single 'S' character present <br>
	 * post: rawMaze is not altered as a result of this method. Return 2 if it is
	 * possible to escape the maze after collecting all the coins. Return 1 if it is
	 * possible to escape the maze but without collecting all the coins. Return 0 if
	 * it is not possible to escape the maze. More details in the assignment
	 * handout.
	 * 
	 * @param rawMaze represents the maze we want to escape. rawMaze is not altered
	 *                as a result of this method.
	 * @return per the post condition
	 */
	public static int canEscapeMaze(char[][] rawMaze) {
		if (rawMaze == null || !isRectangular(rawMaze) || !mazePreconditions(rawMaze)) {
			throw new IllegalArgumentException(
					"Violation of Precondition: Board cannot be null, the board must be rectangular, and the board can only contain specific characters");
		}
		final int ROW = 0;
		final int COL = 1;
		Maze startMaze = new Maze(rawMaze);
		// Optimization to exit early if no exit present in entire maze
		if (!startMaze.exitPresent()) {
			return 0;
		}
		int[] startCoordinates = startMaze.getStart();
		int row = startCoordinates[ROW];
		int col = startCoordinates[COL];
		return canEscapeMazeHelper(rawMaze, row, col);
	}

	// Checks if the board contains valid characters and exactly one start location
	private static boolean mazePreconditions(char[][] rawMaze) {
		final char START = 'S';
		final int NOT_FOUND = -1;
		int start = 0;
		String allowed = "GEY$S*";
		for (int r = 0; r < rawMaze.length; r++) {
			for (int c = 0; c < rawMaze[0].length; c++) {
				if (rawMaze[r][c] == START) {
					start++;
				}
				if (allowed.indexOf(rawMaze[r][c]) == NOT_FOUND) {
					return false;
				}
			}
		}
		return start == 1;
	}

	private static int canEscapeMazeHelper(char[][] rawMaze, int row, int col) {
		final char EXIT = 'E';
		final int ALL_COINS_EXIT = 2;
		final int NOT_ALL_COINS_EXIT = 1;
		final int NO_EXIT = 0;
		Maze maze = new Maze(rawMaze);
		// Base Case
		if (maze.get(row, col) == EXIT) {
			return maze.coinsLeft() ? NOT_ALL_COINS_EXIT : ALL_COINS_EXIT;
		}
		// Used to check 4 directions
		int[] dir1 = { -1, 1, 0, 0 };
		int[] dir2 = { 0, 0, -1, 1 };
		boolean canExit = false;
		for (int i = 0; i < dir1.length; i++) {
			// Calculate next move
			int newRow = row + dir1[i];
			int newCol = col + dir2[i];
			if (inMaze(newRow, newCol, rawMaze)) {
				char nextCell = maze.get(newRow, newCol); // Used to keep track of the previous value
				int result = updateResults(newRow, newCol, maze, nextCell);
				// If we find an exit and all coins, done! POP POP POP
				if (result == ALL_COINS_EXIT) {
					return result;
				}
				// If we find an exit but not get all the coins, keep going but REMEMBER there's
				// an exit
				if (result == NOT_ALL_COINS_EXIT) {
					canExit = true;
				}
				maze.revertMaze(newRow, newCol, nextCell); // Undo changes
			}
		}
		// We remember!
		if (canExit) {
			return NOT_ALL_COINS_EXIT;
		}
		return NO_EXIT;
	}

	// Returns the result after updating the maze
	private static int updateResults(int newRow, int newCol, Maze maze, char nextCell) {
		final char IMPASSABLE = '*';
		int returnValue = 0;
		if (nextCell != IMPASSABLE) {
			maze.updateMaze(newRow, newCol);
			returnValue = canEscapeMazeHelper(maze.getMaze(), newRow, newCol);
		}
		return returnValue;
	}

	// Checks if the given row and column are in bounds of the maze
	private static boolean inMaze(int r, int c, char[][] maze) {
		if (maze == null) {
			throw new IllegalArgumentException("Failed precondition: inbounds. The 2d array mat may not be null.");
		}
		return r >= 0 && r < maze.length && maze[r] != null && c >= 0 && c < maze[r].length;
	}

	// Nested classed to handle the low-level details of the maze
	private static class Maze {
		final char START = 'S';
		final char GREEN = 'G';
		final char YELLOW = 'Y';
		final char COIN = '$';
		final char IMPASSABLE = '*';
		final char EXIT = 'E';
		private char[][] rawMaze;

		// Constructor
		public Maze(char[][] rawMaze) {
			this.rawMaze = rawMaze;
		}

		// Changes the maze position based on the row and column that we moved to
		private void updateMaze(int row, int col) {
			if (rawMaze[row][col] == GREEN || rawMaze[row][col] == COIN) {
				rawMaze[row][col] = YELLOW;
			} else if (rawMaze[row][col] == YELLOW) {
				rawMaze[row][col] = IMPASSABLE;
			}
		}

		// Reverts maze back to original setup before moving to the given row and column
		private void revertMaze(int row, int col, char prevCell) {
			rawMaze[row][col] = prevCell;
		}

		// Checks whether any coins are left in the maze
		private boolean coinsLeft() {
			for (char[] row : rawMaze) {
				for (char c : row) {
					if (c == COIN) {
						return true;
					}
				}
			}
			return false;
		}

		// Returns the indices of the starting location
		private int[] getStart() {
			for (int r = 0; r < rawMaze.length; r++) {
				for (int c = 0; c < rawMaze[0].length; c++) {
					if (rawMaze[r][c] == START) {
						return new int[] { r, c };
					}
				}
			}
			return null;
		}

		// Checks if there are any exits in the maze
		private boolean exitPresent() {
			for (int r = 0; r < rawMaze.length; r++) {
				for (int c = 0; c < rawMaze[0].length; c++) {
					if (rawMaze[r][c] == EXIT) {
						return true;
					}
				}
			}
			return false;
		}

		// Returns this maze
		private char[][] getMaze() {
			return this.rawMaze;
		}

		// Gets the character at this row and column
		private char get(int row, int col) {
			return this.rawMaze[row][col];
		}

	}

}
