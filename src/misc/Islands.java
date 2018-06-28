package misc;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by manasapte on 2/28/18.
 */
public class Islands {
    public int numIslands(char[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int islands = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    queue.add(new int[] {i, j});
                    grid[i][j] = 0;
                    while (!queue.isEmpty()) {
                        int[] cur = queue.remove();
                        System.out.println("row " + cur[0] + " col " + cur[1]);
                        int r = cur[0];
                        int c = cur[1];
                        if (r+1<grid.length && grid[r+1][c] == 1) {
                            queue.add(new int[] {r+1, c});
                            grid[r+1][c] = 0;
                        }
                        if (r-1>=0 && grid[r-1][c] == 1) {
                            queue.add(new int[] {r-1, c});
                            grid[r-1][c] = 0;
                        }
                        if (c+1<grid[0].length && grid[r][c+1] == 1) {
                            queue.add(new int[] {r, c+1});
                            grid[r][c+1] = 0;
                        }
                        if (c-1>=0 && grid[r][c-1] == 1) {
                            queue.add(new int[] {r, c-1});
                            grid[r][c-1] = 0;
                        }
                    }
                }
            }
        }
        return islands;
    }

    public static void main(String[] args) {
        Islands s = new Islands();
        char[][] graph = new char[][] {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        s.numIslands(graph);
    }
}
