
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * MazeGame2 is a backtracking version of MazeGame.
 * 
 * @author Mitch Parry
 * @version 2015-06-02
 */
public class MazeGame2
{
    /**
     * The size of each side of the game map.
     */
    private final static int HEIGHT = 99;
    private final static int WIDTH = 99;

    /**
     * Constants for maze elements.
     */
    private enum Element
    {
        PATH, VISITED, WALL, START, GOAL
    }

    /**
     * The game map, as a 2D array of Elements.
     */
    private Element[][] map;

    /**
     * Constructor sets up the maps and the path list.
     * 
     * @param mazeFile
     *            - name of the file containing the map
     */
    public MazeGame2(String mazeFile)
    {
        loadMaze(mazeFile);
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
        map = new Element[HEIGHT][WIDTH];
        Scanner mazeScanner;
        try
        {
            mazeScanner = new Scanner(new FileReader(mazeFile));
            for (int i = 0; i < HEIGHT; i++)
            {
                for (int j = 0; j < WIDTH; j++)
                {
                    String next = mazeScanner.next();

                    if (next.equals("1"))
                    {
                        // Wall
                        map[j][i] = Element.WALL;
                    }
                    else if (next.equals("0"))
                    {
                        // Path
                        map[j][i] = Element.PATH;
                    }
                    else if (next.equals("S") || next.contentEquals("s"))
                    {
                        // Start
                        map[j][i] = Element.START;
                    }
                    else if (next.equals("G") || next.contentEquals("g"))
                    {
                        // Goal
                        map[j][i] = Element.GOAL;
                    }
                }
            }
            mazeScanner.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found: " + mazeFile);
        }
    }

    /**
     * Non-recursive starter method for finding the path.
     * 
     * @return The path (no solution if null.)
     */
    public String findSolution()
    {
        // Call recursive method from here and return the string
        // representing the path.
        return backtrack(0, 0, "");
    }

    /**
     * Recursive backtracking method for finding a path from a starting point.
     * 
     * @param row
     *            - row of starting point
     * @param col
     *            - column of starting point
     * @param pathSoFar
     *            - the current path so far.
     * @return whether a path was found
     */
    public String backtrack(int row, int col, String pathSoFar)
    {

        System.out
            .println("POSITION: " + map[row][col] + " " + row + " " + col);

        if (map[row][col] == Element.GOAL)
        {
            System.out.println("Found goal");
            return pathSoFar;
        }

        else
        {
            // Flag as visited
            map[row][col] = Element.VISITED;

            int up = col - 1;
            int down = col + 1;
            int left = row - 1;
            int right = row + 1;

            try
            {
                // Test down
                Element elDown = map[row][down];

                System.out.println("Trying down");
                System.out.println(elDown);

                if (elDown != Element.VISITED && elDown != Element.WALL)
                {
                    String result = backtrack(row, down, pathSoFar + " down");
                    if (result != null)
                    {
                        return result;
                    }
                }
            }
            catch (ArrayIndexOutOfBoundsException err)
            {
                System.out.println("Down failed");
            }

            try
            {
                // Test right
                Element elRight = map[right][col];

                System.out.println(row + " " + right);
                System.out.println("Trying right");
                System.out.println(elRight);

                if (elRight != Element.VISITED && elRight != Element.WALL)
                {
                    String result = backtrack(right, col, pathSoFar + " right");
                    if (result != null)
                    {
                        return result;
                    }
                }
            }
            catch (ArrayIndexOutOfBoundsException err)
            {
                System.out.println("Right failed");
            }

            try
            {
                // Test left
                Element elLeft = map[left][col];

                System.out.println("Trying left");
                System.out.println(elLeft);

                if (elLeft != Element.VISITED && elLeft != Element.WALL)
                {
                    String result = backtrack(left, col, pathSoFar + " left");
                    if (result != null)
                    {
                        return result;
                    }
                }
            }
            catch (ArrayIndexOutOfBoundsException err)
            {
                System.out.println("Left failed");
            }

            try
            {
                // Test up
                Element elUp = map[row][up];

                System.out.println("Trying up");
                System.out.println(elUp);

                if (elUp != Element.VISITED && elUp != Element.WALL)
                {
                    String result = backtrack(row, up, pathSoFar + " up");
                    if (result != null)
                    {
                        return result;
                    }
                }
            }
            catch (ArrayIndexOutOfBoundsException err)
            {
                System.out.println("Up failed");
            }

            System.out.println("Wall or visited");
            return null;
        }
    }

    /**
     * Prints the map.
     */
    public void printMap()
    {
        for (int i = 0; i < HEIGHT; i++)
        {
            for (int j = 0; j < WIDTH; j++)
            {
                switch (map[j][i])
                {
                    case START:
                        System.out.print("S");
                        break;
                    case GOAL:
                        System.out.print("G");
                        break;
                    case WALL:
                        System.out.print("X");
                        break;
                    case VISITED:
                        System.out.print("@");
                        break;
                    case PATH:
                        System.out.print(" ");
                        break;
                    default:
                        break;
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Creates a new TreasureHunt2 object and tries to find a solution.
     * 
     * @param args
     *            - command line arguments
     */
    public static void main(String[] args)
    {
        MazeGame2 t = new MazeGame2("data/maze0.txt");
        t.printMap();
        String solution = t.findSolution();
        t.printMap();
        if (solution != null)
        {
            System.out.println(solution);
        }
        else
        {
            System.out.println("There is no solution.");
        }
    }
}
