package linear;

import linear.algebra.GaussianElimination;

public class EquationSolver {

    public static void main(String[] args) {
        double[][] matrix = stringsToDoubles(args);
        GaussianElimination ge = new GaussianElimination(matrix.length, matrix[0].length, matrix);
        System.out.println("Original matrix: ");
        ge.print();
        ge.rowEchelonForm();
        System.out.println("Back substitution matrix:");
        ge.print();
        ge.backSubstitution();
        System.out.println("Row echelon form matrix:");
        ge.print();
    }

    private static double[][] stringsToDoubles(String[] args) {
        int rows = args.length;
        int cols = args[0].split(",").length;
        double[][] matrix = new double[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            String[] vals = args[i].split(",");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Double.parseDouble(vals[j]);
            }
        }
        return matrix;
    }
}
