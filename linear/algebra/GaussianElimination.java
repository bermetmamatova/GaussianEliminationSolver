package linear.algebra;
import java.util.Arrays;

public class GaussianElimination
{
    private int rows;
    private int cols;
    private double[][] matrix;
    
    public double[][] getMatrix()
    {
        return matrix;
    }
    
    public int getRows()
    {
        return rows;
    }
    
    public int getCols()
    {
        return cols;
    }
    
    public void setMatrix(double[][] matrix)
    {
        if(matrix[0].length!=this.cols || matrix.length!= this.rows)
        {
            throw new IllegalArgumentException("Columns and rows have to match.");
        }

        for(int i = 0; i < this.rows; i++)
        {
            if(matrix[i].length != cols)
            {
                throw new IllegalArgumentException("Columns and rows have to match.");
            }
            
            this.matrix[i] = Arrays.copyOf(matrix[i], this.cols);
        }
    }
    private void checkMatrixDimensions(double[][] matrix){}

    public GaussianElimination(int rows, int cols, double[][] matrix)
    {
        this.cols = cols;
        this.rows = rows;
        this.matrix = new double[rows][cols];

        for(int i = 0; i < rows; i++)
        {
            if(matrix[i].length != cols)
            {
                throw new IllegalArgumentException("Columns and rows have to match.");
            }
            
            this.matrix[i] = Arrays.copyOf(matrix[i], cols);
        }
    }

    public void rowEchelonForm()
    {
        int h = 0;
        int k = 0;

        while(h < this.rows && k < this.cols)
        {
            int i_max = argMax(h, k);
            if(this.matrix[i_max][k] == 0)
            {
                k = k + 1;
            }
            else
            {
                swapRows(h, i_max);
                for(int i = h + 1; i < this.rows; i++)
                {
                    double aux = this.matrix[i][k] / this.matrix[h][k];
                    this.matrix[i][k] = 0;
                    
                    
                    for(int j = k + 1; j < this.cols; j++)
                    {
                        this.matrix[i][j] -= this.matrix[h][j] * aux;
                    }
                }
                
                k = k + 1;
                h = h + 1;                
            }
        }
        for (int i = 0; i < this.rows; i++)
        {
            for (int j = 0; j < this.cols; j++)
            {
                if (i == j && this.matrix[i][j] != 0)
                {
                    double temp = this.matrix[i][j];
                    for (int m = j; m < this.cols; m++) {
                        this.matrix[i][m] = this.matrix[i][m] / temp;
                    }
                }
            }
        }

        if (this.cols >= 2 && this.matrix[1][1] != 0)
        {
            for (int i = 1; i < this.cols; i++)
            {
                this.matrix[1][i] = this.matrix[1][i] / this.matrix[1][1];
            }
        }
    }

    private int argMax(int m, int n)
    {
        int aux = m;
        for(int i = m + 1; i < this.rows; i++)
        {
            if(Math.abs(this.matrix[i][n]) > Math.abs(this.matrix[aux][n])) { aux = i; }
        }
        return aux; 
    }

    private void swapRows(int k, int l)
    {
        double[] aux = this.matrix[k];
        this.matrix[k] = this.matrix[l];
        this.matrix[l] = aux;
    }

    private void multiplyAndAddRow(int r, int s, int t)
    {
        double aux = this.matrix[r][t] / this.matrix[s][t];
        for(int i = t; i<this.cols; i++)
        {
            this.matrix[r][i] -= this.matrix[s][i] * aux;
        }
    }
    
    private void multiplyRow(int r, int c)
    {
        double aux = matrix[r][c];
        for(int i = c; i < this.cols; i++)
        {
            matrix[r][i] = matrix[r][i] / aux;
        }
    }

    public void backSubstitution()
    {
        int aux = this.rows;
        
        
        for(int i = aux - 1; i >= 0; i--)
        {
            if(matrix[i][i] == 0)
            {
                throw new IllegalArgumentException("Columns and rows have to match.");
            }
            int j = 0;
            while(j < this.cols && this.matrix[i][j] == 0)
            {
                j++;
            }
            if(j < this.cols)
            {
                double aux2 = this.matrix[i][j];
                for(int k = j; k < this.cols; k++)
                {
                    this.matrix[i][k] = this.matrix[i][k] / aux2;
                }

                for(int k = i - 1; k >= 0; k--)
                {
                    double aux3 = this.matrix[k][j];
                    for(int n = j; n < this.cols; n++)
                    {
                        this.matrix[k][n] -= (aux3* this.matrix[i][n]);
                    }
                }
            }
        }
    }

    public void print()
    {
        for(int i = 0; i < this.rows; i++)
        {
            for (int j = 0; j < this.cols; j++)
            {
                String temp = "";
                if (j == 0) { temp = "x"; }
                else if (j == 1) { temp = "y"; }
                else if (j == 2) { temp = "z"; }
                
                if (this.matrix[i][j] >= 0)
                {
                    System.out.print("+" + this.matrix[i][j] + temp); 
                }
                else
                {
                    System.out.print(this.matrix[i][j] + temp);
                } 
            }

        System.out.println("=" + this.matrix[i][this.cols - 1]);
        System.out.println();
        }
    }
}