
public class SudokuModel {
	/*
	 * SudokuModel.java		Richard Addicott (ria4@aber.ac.uk)
	 * - This class provides the rest of the classes with two get and
	 * set methods that are heavily used to store the values of the 
	 * Sudoku cells throughout the program. No real algorithms are 
	 * present in this class, it is just a reference point for the 
	 * rest of the code to call when needed.
	 */
	public char grid[][]; // forms the basis of the grid array
	public int ROWS = 9; // constant variable of 9x9 grid
	public int COLUMNS = 9; 

	public SudokuModel(int row, int col) {
		grid = new char[ROWS + 1][COLUMNS + 1];
	} // ends SudokuModel method

	public void setValue(int row, int col, char r) {
		grid[row][col] = r;
	} // ends setValue method

	public char returnValue(int row, int col) {
		char x;
		x = grid[row][col];
		return x;
	} // ends returnValue method

} // ends SudokuModel class

