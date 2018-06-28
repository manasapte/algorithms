package misc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by manasapte on 3/19/18.
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> sol = new ArrayList<Integer>();
        spiralOrderHelper(0, 0, matrix, sol);
        return sol;
    }

    private void spiralOrderHelper(int r, int c, int[][] matrix, List<Integer> solution) {
        System.out.println("r: " + r + " c: "+ c + " matrix length: " + matrix.length + " matrix row length " + matrix[0].length);
        if (matrix.length>2*r && matrix[0].length>2*c) {
            int i=r,j=c;
            if ()
            for (; j<matrix[0].length-c-1; j++) {
                System.out.println("first adding i: " + i + " j: " + j);
                solution.add(matrix[i][j]);
            }
            for (; i<matrix.length-r-1; i++) {
                System.out.println("second adding i: " + i + " j: " + j);
                solution.add(matrix[i][j]);
            }
            for (; j>c; j--) {
                System.out.println("third adding i: " + i + " j: " + j);
                solution.add(matrix[i][j]);
            }
            for (; i>r; i--) {
                System.out.println("fourth adding i: " + i + " j: " + j);
                solution.add(matrix[i][j]);
            }
            spiralOrderHelper(r+1, c+1, matrix, solution);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        SpiralMatrix s = new SpiralMatrix();
        List<String> sol = s.spiralOrder(matrix).stream().map(x -> x.toString()).collect(Collectors.toList());
        System.out.println("sol: " + String.join(",", sol));
    }
}
