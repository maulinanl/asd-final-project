/**
 * ES234317-Algorithm and Data Structures
 * Semester Ganjil, 2023/2024
 * Group Capstone Project
 * Group #9
 * 1 - 5026221131 - Maulina Nur Laila
 * 2 - 5026221172 - Arya Putra Tsabitah Firjatulloh
 * 3 - 5026221179 - Kadek Mawar Kumala Dewi
 */

public class Puzzle {

    // All variables private
    int[][] numbers = new int[SudokuConstants.GRID_SIZE][SudokuConstants.GRID_SIZE];
    boolean[][] isGiven = new boolean[SudokuConstants.GRID_SIZE][SudokuConstants.GRID_SIZE];

    // Constructor
    public Puzzle(int cellsToGuess) {
        super();
        newPuzzle(cellsToGuess);
    }

    // Generate a new puzzle with adjustable difficulty
    public void newPuzzle(int cellsToGuess) {
        // Randomly choose cells to hide based on difficulty
        int cellsHidden = 0;
        while (cellsHidden < cellsToGuess) {
            int row = getRandomNumber(0, SudokuConstants.GRID_SIZE);
            int col = getRandomNumber(0, SudokuConstants.GRID_SIZE);
            if (!isGiven[row][col]) {
                continue;
            }
            isGiven[row][col] = false;
            cellsHidden++;
        }

        // Generate random numbers
        for (int row = 0; row < SudokuConstants.GRID_SIZE; ++row) {
            for (int col = 0; col < SudokuConstants.GRID_SIZE; ++col) {
                numbers[row][col] = generateRandomNumber();
            }
        }
    }

    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private int generateRandomNumber() {
        return (int) (Math.random() * SudokuConstants.MAX_NUMBER) + 1;
    }
}