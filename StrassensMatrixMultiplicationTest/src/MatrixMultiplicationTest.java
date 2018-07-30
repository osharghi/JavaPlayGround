
public class MatrixMultiplicationTest {
	
	public static long startTime;
	public static long endTime;
	
	public static void main(String[]	args){
		
		
		//4x4 Double Matrices
		double[][] aDouble = {{1.4, 5.2, 3.2, 4.6}, {2.4, 6.1, 7.3, 9.2}, {5.5, 4.3, 1.1, 2.5}, {6.1, 8.2, 4.2, 4.7}};
		double[][] bDouble = {{5.1, 2.2, 5.4, 3.7}, {6.7, 9.1, 4.1, 3.2}, {5.5, 6.3, 2.2, 1.1}, {1.1, 7.1, 5.3, 2.2}};
		Matrix	md1	=	new Matrix(aDouble);
		Matrix	md2	=	new Matrix(bDouble);
		
		//4x4 Regular Multiplication Doubles
		startTime = System.currentTimeMillis();
		Matrix resultRegDouble = md1.productRegular(md2);
		endTime = System.currentTimeMillis();
		System.out.println("Double Regular 4x4 Multiplication result: ");
		resultRegDouble.printMatrix();
		System.out.println("Double Regular 4x4 Multiplication Time: " + (endTime-startTime) + "\n");
		
		//4x4 Strassens Multiplication Doubles
		startTime = System.currentTimeMillis();
		Matrix resultStrassDouble = md1.productStrassen(md2);
		endTime = System.currentTimeMillis();
		System.out.println("Double Strassens 4x4 Multiplication result: ");
		resultStrassDouble.printMatrix();
		System.out.println("Double Strassens 4x4 Multiplication Time: " + (endTime-startTime) + "\n");
		
		
		
		//8x8 Matrices
		double[][] a = {{1, 3, 2, 4, 5, 6, 7, 8}, {1, 3, 2, 4, 5, 6, 7, 8}, {1, 3, 2, 4, 5, 6, 7, 8}, {1, 3, 2, 4, 5, 6, 7, 8}, {1, 3, 2, 4, 5, 6, 7, 8}, {1, 3, 2, 4, 5, 6, 7, 8}, {1, 3, 2, 4, 5, 6, 7, 8}, {1, 3, 2, 4, 5, 6, 7, 8}};
		double[][] b = {{4, 3, 1, 2, 6, 2, 1, 4}, {4, 3, 1, 2, 6, 2, 1, 4}, {4, 3, 1, 2, 6, 2, 1, 4}, {4, 3, 1, 2, 6, 2, 1, 4}, {4, 3, 1, 2, 6, 2, 1, 4}, {4, 3, 1, 2, 6, 2, 1, 4}, {4, 3, 1, 2, 6, 2, 1, 4}, {4, 3, 1, 2, 6, 2, 1, 4}};
		Matrix	m1	=	new Matrix(a);
		Matrix	m2	=	new Matrix(b);
		
		//8x8 Regular Multiplication
		startTime = System.currentTimeMillis();
		Matrix resultReg = m1.productRegular(m2);
		endTime = System.currentTimeMillis();
		System.out.println("Regular 8x8 Multiplication result: ");
		resultReg.printMatrix();
		System.out.println("Regular 8x8 Multiplication Time: " + (endTime-startTime) + "\n");
		
		//8x8 Strassens Multiplication
		startTime = System.currentTimeMillis();
		Matrix resultStrass = m1.productStrassen(m2);
		endTime = System.currentTimeMillis();
		System.out.println("Strassens 8x8 Multiplication result: ");
		resultStrass.printMatrix();
		System.out.println("Strassens 8x8 Multiplication Time: " + (endTime-startTime) + "\n");
		
		
		
		//16x16 Matrices
		Matrix m3 = new Matrix(16);
		Matrix m4 = new Matrix(16);
		m3.random();
		m4.random();
		
		//16x16 Regular Multiplication
		startTime = System.currentTimeMillis();
		Matrix resultReg2 = m3.productRegular(m4);
		endTime = System.currentTimeMillis();
		System.out.println("Regular 16x16 Multiplication result: ");
//		resultReg2.printMatrix();
		System.out.println("Regular 16x16 Multiplication Time: " + (endTime-startTime) + "\n");
		
		//16x16 Strassens Multiplication
		startTime = System.currentTimeMillis();
		Matrix resultStrass2 = m3.productStrassen(m4);
		endTime = System.currentTimeMillis();
		System.out.println("Strassens 16x16 Multiplication result: ");
//		resultStrass2.printMatrix();
		System.out.println("Strassens 16x16 Multiplication Time: " + (endTime-startTime) + "\n");
		
		
		
		//512x512 Matrices
		Matrix m5 = new Matrix(512);
		Matrix m6 = new Matrix(512);
		m5.random();
		m6.random();
		
		//512x512 Regular Multiplication
		startTime = System.currentTimeMillis();
		Matrix resultReg3 = m5.productRegular(m6);
		endTime = System.currentTimeMillis();
		System.out.println("Regular 512x512 Multiplication result: ");
//		resultReg3.printMatrix();
		System.out.println("Regular 512x512 Multiplication Time: " + (endTime-startTime) + "\n");
		
		//512x512 Strassens Multiplication
		startTime = System.currentTimeMillis();
		Matrix resultStrass3 = m5.productStrassen(m6);
		endTime = System.currentTimeMillis();
		System.out.println("Strassens 512x512 Multiplication result: ");
//		resultStrass3.printMatrix();
		System.out.println("Strassens 512x512 Multiplication Time: " + (endTime-startTime) + "\n");
		
		
		
		//1024x1024 Matrices
		Matrix m7 = new Matrix(1024);
		Matrix m8 = new Matrix(1024);
		m7.random();
		m8.random();
		
		//1024x1024 Regular Multiplication
		startTime = System.currentTimeMillis();
		Matrix resultReg4 = m7.productRegular(m8);
		endTime = System.currentTimeMillis();
		System.out.println("Regular 1024x1024 Multiplication result: ");
//				resultReg4.printMatrix();
		System.out.println("Regular 1024x1024 Multiplication Time: " + (endTime-startTime) + "\n");
		
		//1024x1024 Strassens Multiplication
		startTime = System.currentTimeMillis();
		Matrix resultStrass4 = m7.productStrassen(m8);
		endTime = System.currentTimeMillis();
		System.out.println("Strassens 1024x1024 Multiplication result: ");
//				resultStrass4.printMatrix();
		System.out.println("Strassens 1024x1024 Multiplication Time: " + (endTime-startTime) + "\n");

	}
}

