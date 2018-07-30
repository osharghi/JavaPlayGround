import java.util.Random;

public class Matrix	{
	
	public	double[][]	matrix;

	public Matrix(double[][]	matrix)	{
				
		this.matrix	= matrix;
	}
	
	public Matrix(int N)
	{
		matrix = new double [N][N];
	}
	
	public Matrix productRegular(Matrix matrixB){
	
		int size = matrix.length;
		double [][] result = new double[size][size];

        for(int i = 0; i<size; i++)
        {
           for(int j = 0; j<size; j++)
           {
              result[i][j] = 0;
              
              for(int k = 0; k<size; k++)
              {
                 result[i][j] = result[i][j] + (matrix[i][k] * matrixB.matrix[k][j]);
              }
           }
        }  
        
        Matrix resultMatrix = new Matrix(result);
        return resultMatrix;
	}
	
	public	Matrix	productStrassen(Matrix	matrixB)	{
		  int size = matrix.length;
		  
	      double [][] result = new double[size][size];

	      if (matrixB.matrix.length == 2)
	      {         
		    	  for(int i = 0; i<matrixB.matrix.length; i++)
		      {
		         for(int j = 0; j<matrixB.matrix.length; j++)
		         {
		            result[i][j] = 0;
		            
		            for(int k = 0; k<matrixB.matrix.length; k++)
		            {
		               result[i][j] = result[i][j] + (matrix[i][k] * matrixB.matrix[k][j]);
		            }
		         }
		      }
		    	  Matrix resultMatrix = new Matrix(result);
		    	  return resultMatrix;
	      }
	      else 
	      {
	         
	         Matrix a11 = createSubMatrix(this, size/2, 0, size/2, 0, size/2);
	         Matrix a12 = createSubMatrix(this, size/2, 0, size/2, size/2, size);
	         Matrix a21 = createSubMatrix(this, size/2, size/2, size, 0, size/2);
	         Matrix a22 = createSubMatrix(this, size/2, size/2, size, size/2, size);
	         
	         Matrix b11 = createSubMatrix(matrixB, size/2, 0, size/2, 0, size/2);
	         Matrix b12 = createSubMatrix(matrixB, size/2, 0, size/2, size/2, size);  
	         Matrix b21 = createSubMatrix(matrixB, size/2, size/2, size, 0, size/2);
	         Matrix b22 = createSubMatrix(matrixB, size/2, size/2, size, size/2, size);
	    	  
	         
	         Matrix p1 = a11.productStrassen(subtract(b12, b22));

	         Matrix p2 = add(a11, a12).productStrassen(b22);
	         Matrix p3 = add(a21, a22).productStrassen(b11);
	         Matrix p4 = a22.productStrassen(subtract(b21, b11));
	         Matrix p5 = add(a11, a22).productStrassen(add(b11, b22));
	         Matrix p6 = subtract(a12, a22).productStrassen(add(b21, b22));
	         Matrix p7 = subtract(a11, a21).productStrassen(add(b11, b12));
	      
	         Matrix c11 = add(subtract(add(p5, p4), p2), p6);
	         Matrix c12 = add(p1, p2);
	         Matrix c21 = add(p3, p4);
	         Matrix c22 = subtract(subtract(add(p5, p1), p3), p7);
	         
	         combineSubMatrices(c11, result, 0, size/2, 0, size/2);
	         combineSubMatrices(c12, result, 0, size/2, size/2, size);
	         combineSubMatrices(c21, result, size/2, size, 0, size/2);
	         combineSubMatrices(c22, result, size/2, size, size/2, size);
	      }
	      
	      Matrix resultMatrix = new Matrix(result);
	      return resultMatrix;
	}
	
	public Matrix random()
	{
		Random rand = new Random();
		
		for(int i = 0; i<matrix.length; i++)
		{
			for (int j = 0; j<matrix.length; j++)
			{
				matrix[i][j] = rand.nextInt(50) + 1;
			}
		}
		return this;
	}

	public Matrix createSubMatrix(Matrix main, int size, int rowStart, int rowEnd, int columnStart, int columnEnd)
	{
	
	   double [][] result = new double[size][size];
	
	   for(int i=0, r=rowStart; i<size; i++, r++)
	   {
	      for(int j=0, c=columnStart; j<size; j++, c++)
	      {
	         result[i][j] = main.matrix[r][c]; 
	      }
	   }
	   Matrix resultMatrix = new Matrix(result);
	   return resultMatrix;
	}
	   
	public void combineSubMatrices(Matrix subMatrix, double[][] result, int rowStartingPoint, int rowLimit, int columnStartingPoint, int columnLimit)
	{
	  for(int r =rowStartingPoint, i = 0; r<rowLimit; r++, i++ )
	  {
	 	 	for(int c = columnStartingPoint, j = 0; c<columnLimit; c++, j++)
	 	 	{
	 	 		result[r][c] = subMatrix.matrix[i][j];
	 	 	}
	  }
	}
	   
	public Matrix add(Matrix a, Matrix b)
	{
	   int size = a.matrix.length;
	   double [][] result = new double[size][size];
	   for(int i = 0; i<size; i++)
	   {
	      for(int j = 0; j<size; j++)
	      {
	         result[i][ j] = a.matrix[i][j] + b.matrix[i][j];
	      }
	   }
	   Matrix resultMatrix = new Matrix(result);
	   return resultMatrix;
	}
	
	public Matrix subtract( Matrix a, Matrix b)
	{
	   int size = a.matrix.length;
	   double [][] result = new double[size][size];
	   for(int i = 0; i<size; i++)
	   {
	      for(int j = 0; j<size; j++)
	      {
	         result[i][ j] = a.matrix[i][j] - b.matrix[i][j];
	      }
	   }
	   Matrix resultMatrix = new Matrix(result);
	   return resultMatrix;
	}
	
	public void printMatrix()
	{
		int size = matrix.length;
		
		for(int i = 0; i<size; i++)
		{
			for(int j = 0; j<size; j++)
			{
				System.out.print(matrix[i][j] + " ");;
			}
			System.out.println("");
		}
		
	}
}