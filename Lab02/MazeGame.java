
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * A maze game.
 * 
 * @author Dylan Lancaster
 *
 */
public class MazeGame
{
    /**
     * The size of each side of the game map.
     */
    private final static int HEIGHT = 19;
    private final static int WIDTH = 39;

    /**
     * The game map, as a 2D array of ints.
     */
    private boolean[][] blocked;
    private boolean[][] breadcrumbs;

    /**
     * The current location of the player vertically.
     */
    private int userCol;

    /**
     * The current location of the player horizontally.
     */
    private int userRow;

    /**
     * The scanner from which each move is read.
     */
    private Scanner moveScanner;

    /**
     * The row and column of the goal.
     */
    private int goalRow;
    private int goalCol;

    /**
     * The row and column of the start.
     */
    private int startRow;
    private int startCol;

    /**
     * Constructor initializes the maze with the data in 'mazeFile'.
     * 
     * @param mazeFile
     *            the input file for the maze
     */
    public MazeGame(String mazeFile)
    {
        loadMaze(mazeFile);
        setMoveScanner(new Scanner(System.in));
    }

    /**
     * Constructor initializes the maze with the 'mazeFile' and the move scanner
     * with 'moveScanner'.
     * 
     * @param mazeFile
     *            the input file for the maze
     * @param moveScanner
     *            the scanner object from which to read user moves
     */
    public MazeGame(String mazeFile, Scanner moveScanner)
    {
        loadMaze(mazeFile);
        // TODO: The Scanner object must already have been created (not null)
        // and be ready to read from a string, file, or keyboard input
        setMoveScanner(moveScanner);
    }

    /**
     * getMaze returns a copy of the current maze for testing purposes.
     * 
     * @return the grid
     */
    public boolean[][] getMaze()
    {
        if (blocked == null)
        {
            return null;
        }
        boolean[][] copy = new boolean[HEIGHT][WIDTH];
        for (int i = 0; i < HEIGHT; i++)
        {
            for (int j = 0; j < WIDTH; j++)
            {
                copy[i][j] = blocked[i][j];
            }
        }
        return copy;
    }

    /**
     * setMaze sets the current map for testing purposes.
     * 
     * @param maze
     *            another maze.
     */
    public void setMaze(boolean[][] maze)
    {
        this.blocked = maze;
    }

    /**
     * Set cell value in maze.
     * 
     * @param row
     *            row
     * @param col
     *            col
     * @param val
     *            val
     */
    public void setCell(int row, int col, boolean val)
    {
        this.blocked[row][col] = val;
    }

    /**
     * Check if cell is blocked.
     * 
     * @param row
     *            row
     * @param col
     *            col
     * @return boolean cell is blocked
     */
    public boolean getCell(int row, int col)
    {
        return this.blocked[row][col];
    }

    /**
     * Function loads the data from the maze file and creates the 'blocked' 2D
     * array.
     * 
     * @param mazeFile
     *            the input maze file.
     */
    private void loadMaze(String mazeFile)
    {
        setMaze(new boolean[HEIGHT][WIDTH]);
        this.breadcrumbs = new boolean[HEIGHT][WIDTH];

        Scanner scanner = null;
        File file = new File(mazeFile);

        try
        {
            scanner = new Scanner(file);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
            System.exit(0);
        }

        for (int i = 0; i < HEIGHT; i++)
        {
            for (int j = 0; j < WIDTH; j++)
            {
                char cell = scanner.next().charAt(0);

                switch (cell)
                {
                    case '1':
                        setCell(i, j, true);
                        break;
                    case '0':
                        setCell(i, j, false);
                        break;
                    case 'S':
                        setCell(i, j, false);
                        setStart(i, j);
                        break;
                    case 'G':
                        setCell(i, j, false);
                        setGoal(i, j);
                        break;
                    default:
                        break;
                }

                breadcrumbs[i][j] = false;
            }
        }

        scanner.close();
    }

    /**
     * Getter for userCol field.
     * 
     * @return userCol
     */
    public int getUserCol()
    {
        return this.userCol;
    }

    /**
     * Setter for userCol field.
     * 
     * @param userCol
     *            userCol
     */
    public void setUserCol(int userCol)
    {
        this.userCol = userCol;
    }

    /**
     * Getter for userRow field.
     * 
     * @return userRow
     */
    public int getUserRow()
    {
        return this.userRow;
    }

    /**
     * Setter for userRow field.
     * 
     * @param userRow
     *            userRow
     */
    public void setUserRow(int userRow)
    {
        this.userRow = userRow;
    }

    /**
     * Getter for moveScanner field.
     * 
     * @return moveScanner
     */
    public Scanner getMoveScanner()
    {
        return this.moveScanner;
    }

    /**
     * Setter for moveScanner field.
     * 
     * @param moveScanner
     *            moveScanner
     */
    public void setMoveScanner(Scanner moveScanner)
    {
        this.moveScanner = moveScanner;
    }

    /**
     * Get start row.
     * 
     * @return startRow
     */
    public int getStartRow()
    {
        return this.startRow;
    }

    /**
     * Get start col.
     * 
     * @return startCol
     */
    public int getStartCol()
    {
        return this.startCol;
    }

    /**
     * Set start cell position.
     * 
     * @param row
     *            row
     * @param col
     *            col
     */
    public void setStart(int row, int col)
    {
        this.startRow = row;
        this.startCol = col;
    }

    /**
     * Get goal row.
     * 
     * @return goalRow
     */
    public int getGoalRow()
    {
        return this.goalRow;
    }

    /**
     * Get goal col.
     * 
     * @return goalCol
     */
    public int getGoalCol()
    {
        return this.goalCol;
    }

    /**
     * Set goal cell position.
     * 
     * @param row
     *            row
     * @param col
     *            col
     */
    public void setGoal(int row, int col)
    {
        this.goalRow = row;
        this.goalCol = col;
    }

    /**
     * Actually plays the game.
     */
    public void playGame()
    {
        setUserRow(getStartRow());
        setUserCol(getStartCol());

        String input = "";
        Scanner moveScanner = getMoveScanner();

        while (!input.contentEquals("quit"))
        {
            printMaze();
            System.out.print("Enter move: ");
            input = moveScanner.next();

            System.out.println();
            makeMove(input);

            if (playerAtGoal())
            {
                System.out.println("You won");
                input = "quit";
            }
        }
    }

    /**
     * Checks to see if the player has won the game.
     * 
     * @return true if the player has won.
     */
    public boolean playerAtGoal()
    {
        return getUserCol() == getGoalCol() && getUserRow() == getGoalRow();
    }

    /**
     * Makes a move based on the String.
     * 
     * @param input input
     * @return whether the move was valid.
     */
    public boolean makeMove(String input)
    {
        char move = input.toLowerCase().charAt(0);

        int userRow = getUserRow();
        int userCol = getUserCol();

        switch (move)
        {
            case 'u':
                int intendedRow = userRow - 1;

                if (userRow > 0 && !getCell(intendedRow, userCol))
                {
                    setUserRow(intendedRow);
                    breadcrumbs[intendedRow][userCol] = true;
                    return true;
                }
                return false;
            case 'd':
                int intendedRow2 = userRow + 1;

                if (userRow < HEIGHT - 1 && !getCell(intendedRow2, userCol))
                {
                    setUserRow(intendedRow2);
                    breadcrumbs[intendedRow2][userCol] = true;
                    return true;
                }
                return false;
            case 'l':
                int intendedCol = userCol - 1;

                if (userCol > 0 && !getCell(userRow, intendedCol))
                {
                    setUserCol(userCol - 1);
                    breadcrumbs[userRow][intendedCol] = true;
                    return true;
                }
                return false;
            case 'r':
                int intendedCol2 = userCol + 1;

                if (userCol < WIDTH - 1 && !getCell(userRow, intendedCol2))
                {
                    setUserCol(userCol + 1);
                    breadcrumbs[userRow][intendedCol2] = true;
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    /**
     * Prints the map of the maze.
     */
    public void printMaze()
    {
        boolean[][] maze = getMaze();

        System.out.print("*");
        for (int i = 0; i < maze[0].length; i++)
        {
            System.out.print("-");
        }
        System.out.print("*\n");

        for (int i = 0; i < maze.length; i++)
        {
            System.out.print("|");

            for (int j = 0; j < maze[i].length; j++)
            {
                if (i == getUserRow() && j == getUserCol())
                {
                    System.out.print("@");
                }
                else if (i == getStartRow() && j == getStartCol())
                {
                    System.out.print("S");
                }
                else if (i == getGoalRow() && j == getGoalCol())
                {
                    System.out.print("G");
                }
                else if (getCell(i, j))
                {
                    System.out.print("X");
                }
                else if (breadcrumbs[i][j])
                {
                    System.out.print(".");
                }
                else
                {
                    System.out.print(" ");
                }
            }

            System.out.print("|\n");
        }

        System.out.print("*");
        for (int i = 0; i < maze[0].length; i++)
        {
            System.out.print("-");
        }
        System.out.print("*\n");
    }

    /**
     * Creates a new game, using a command line argument file name, if one is
     * provided.
     * 
     * @param args
     *            the command line arguments
     */

    public static void main(String[] args)
    {
        String mapFile = "data/easy.txt";
        Scanner scan = new Scanner(System.in);
        MazeGame game = new MazeGame(mapFile, scan);
        game.playGame();
    }
}

