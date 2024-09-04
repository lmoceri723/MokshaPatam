/**
 * Moksha Patam
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: [YOUR NAME HERE]
 *
 */

public class MokshaPatam {

    /**
     * TODO: Complete this function, fewestMoves(), to return the minimum number of moves
     *  to reach the final square on a board with the given size, ladders, and snakes.
     */

    public static int[] formatRealPaths(int boardsize, int[][] ladders, int[][] snakes) {
        int[] realPaths = new int[boardsize];

        // Add all snakes to realPaths
        for (int i = 0; i < ladders.length; i++) {
            realPaths[ladders[i][0]] = ladders[i][1];
        }

        // Add all ladders to realPaths
        for (int i = 0; i < snakes.length; i++) {
            realPaths[snakes[i][0]] = snakes[i][1];
        }

        // Add all normal squares to realPaths
        for (int i = 0; i < boardsize; i++) {
            if (realPaths[i] == 0) {
                realPaths[i] = i;
            }
        }

        return realPaths;
    }

    public static int fewestMoves(int boardsize, int[][] ladders, int[][] snakes) {

        // Format snakes and ladders into a single array to reduce the search time to O(1)
        int[] realPaths = formatRealPaths(boardsize, ladders, snakes);

        int moves = 0;
        int currentSquare = 0;

        /*        PLAN         */
        // Do BFS to find the shortest path
        // Each turn the computer can choose any number betwwen 1 and 6
        // The computer then moves to the square that is the sum of the current square and the number chosen
        // And then the computer checks if the square it landed on is a snake or a ladder using the realPaths array



    }
}
