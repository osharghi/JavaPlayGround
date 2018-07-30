import static org.junit.Assert.*;
import org.junit.*; 

import org.junit.Test;

public class MatrixTest {
	
	private Matrix A, B; //input matrices
	private Matrix productRegularResult, productStrassenResult; // Matrices for storing the results
	private int N; // size of the NXN matrix
	
	@Before
	public void setUp() throws Exception
	{
	   N = 4; // size of the matrix
	   double[][] array1 = new double[N][N];
	   double[][] array2 = new double[N][N];
	   A = new Matrix(array1);
	   B = new Matrix(array2);
	   productRegularResult = new Matrix(N);
	   productStrassenResult = new Matrix(N);
	   
	} // setUp()

	
	/* compare result matrices of regular multiplication method and Strassen multiplication method:
	 */
	@Test
	public void testProductCompare() {
	    
	     
	     //run user defined random() method to generate the matrices
	     A = A.random();
	     B = B.random();
	     
	      
	     // run productRegular()
	     productRegularResult = A.productRegular(B);
	     
	     // run productStrassen()
		 productStrassenResult = A.productStrassen(B);
		 
	     for (int i = 0; i < N; i++) {
	    	assertArrayEquals(productRegularResult.matrix[i], productStrassenResult.matrix[i], 0.0001 ); 
	    	// data[][] is a data member for storing matrix values in class Matrix.
		}
	}
	
	/* multiplying a 2D array using the regular method:
	 */
	@Test
	public void testProductRegular() {
	    
	    //expected output
		double[][] expected = {{96.0,94.0,81.0,128.0},{144.0,117.0,112.0,162.0},{132.0,112.0,101.0,152.0},{112.0,86.0,87.0,130.0}};
	    
		// input 2D array
		double[][] array1 = {{2.0,4.0,5.0,7.0},{6.0,7.0,2.0,8.0},{4.0,6.0,3.0,9.0},{8.0,4.0,1.0,5.0}};
		double[][] array2 = {{6.0,4.0,5.0,8.0},{8.0,7.0,8.0,8.0},{2.0,6.0,5.0,9.0},{6.0,4.0,2.0,5.0}}; 		
	    
		Matrix m1 = new Matrix(array1);
		Matrix m2 = new Matrix(array2);
	      
	    // run productRegular()
		productRegularResult = m1.productRegular(m2);
	     
	    for (int i = 0; i < N; i++) {
			assertArrayEquals(expected[i],productRegularResult.matrix[i], 0.0); // data[][] is a data member for storing matrix values in class Matrix.
		}
	    
	}
	
	/* multiplying a 2D array using the Strassen method:
	 */
	@Test
	public void testProductStrassen() {
	    
	    //expected output
		double[][] expected = {{96.0,94.0,81.0,128.0},{144.0,117.0,112.0,162.0},{132.0,112.0,101.0,152.0},{112.0,86.0,87.0,130.0}};
	    
		// input 2D array
		double[][] array1 = {{2.0,4.0,5.0,7.0},{6.0,7.0,2.0,8.0},{4.0,6.0,3.0,9.0},{8.0,4.0,1.0,5.0}};
		double[][] array2 = {{6.0,4.0,5.0,8.0},{8.0,7.0,8.0,8.0},{2.0,6.0,5.0,9.0},{6.0,4.0,2.0,5.0}}; 		
	    
		Matrix m1 = new Matrix(array1);
		Matrix m2 = new Matrix(array2);
	      
	    // run productRegular()
		productStrassenResult= m1.productStrassen(m2);
	     
	    for (int i = 0; i < N; i++) {
			assertArrayEquals(expected[i],productStrassenResult.matrix[i], 0.0); // data[][] is a data member for storing matrix values in class Matrix.
		}
	}

	@Test
	public void testCreateSubMatrix() {
		
		double [][] expected = {{2, 2}, {2, 2}};
		double [][] array1 = {{2, 2, 4, 4}, {2, 2, 4, 4}, {4, 4, 4, 4}, {4, 4, 4, 4}};
		Matrix main = new Matrix(array1);
		N = main.matrix.length;
		Matrix sub = main.createSubMatrix(main, N/2, 0, N/2, 0, N/2);
		
		for (int i = 0; i < N/2; i++) {
			assertArrayEquals(expected[i],sub.matrix[i], 0.0); // data[][] is a data member for storing matrix values in class Matrix.
		}
				
	}
	
	@Test
	public void testCombineSubMatrices() {

		double[][] expected = {{2, 2, 4, 4}, {2, 2, 4, 4}, {4, 4, 4, 4}, {4, 4, 4, 4}};
		double [][] array1 = {{2, 2}, {2, 2}};
		double[][] array2 = {{4, 4, 4, 4}, {4, 4, 4, 4}, {4, 4, 4, 4}, {4, 4, 4, 4}};
		Matrix sub = new Matrix(array1);
		Matrix main = new Matrix(array2);
		N = main.matrix.length;
		main.combineSubMatrices(sub, main.matrix, 0, 2, 0, 2);

		
		for (int i = 0; i < N; i++) {
			assertArrayEquals(expected[i],main.matrix[i], 0.0); // data[][] is a data member for storing matrix values in class Matrix.
		}
		
	}

	@Test
	public void testAdd() {
		double[][] array1 = {{2.0,2.0,2.0,2.0},{2.0,2.0,2.0,2.0},{2.0,2.0,2.0,2.0},{2.0,2.0,2.0,2.0}};
		double[][] array2 = {{2.0,2.0,2.0,2.0},{2.0,2.0,2.0,2.0},{2.0,2.0,2.0,2.0},{2.0,2.0,2.0,2.0}};
		double[][] array3 = {{4.0,4.0,4.0,4.0},{4.0,4.0,4.0,4.0},{4.0,4.0,4.0,4.0},{4.0,4.0,4.0,4.0}};
		Matrix A = new Matrix(array1);
		Matrix B = new Matrix(array2);
		Matrix C = new Matrix(array3);
		Matrix R = A.add(A,B);
		for (int i = 0; i < N; i++) {
			assertArrayEquals(R.matrix[i],C.matrix[i], 0.0); 
		}
	}
	
	@Test
	public void testSubtract() {
		double[][] array1 = {{4.0,4.0,4.0,4.0},{4.0,4.0,4.0,4.0},{4.0,4.0,4.0,4.0},{4.0,4.0,4.0,4.0}};
		double[][] array2 = {{2.0,2.0,2.0,2.0},{2.0,2.0,2.0,2.0},{2.0,2.0,2.0,2.0},{2.0,2.0,2.0,2.0}};
		double[][] array3 = {{2.0,2.0,2.0,2.0},{2.0,2.0,2.0,2.0},{2.0,2.0,2.0,2.0},{2.0,2.0,2.0,2.0}};
		Matrix A = new Matrix(array1);
		Matrix B = new Matrix(array2);
		Matrix C = new Matrix(array3);
		Matrix R = A.subtract(A,B);
		for (int i = 0; i < N; i++) {
			assertArrayEquals(R.matrix[i],C.matrix[i], 0.0); 
		}
	}

}
