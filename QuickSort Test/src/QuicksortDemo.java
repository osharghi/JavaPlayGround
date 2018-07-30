
import java.util.Arrays; 

public class QuicksortDemo {
	
	public static void main (String [] args)
	{
	
		Quicksort QS = new Quicksort();
		QS.setRand();
		QS.initializeCounter();
		
		System.out.println("Setup 3 arrays of 10,000 elements:");
		int [] A = QS.populate(10000);
		int [] B = QS.getCopy(A);
		int [] C = QS.getCopy(A);
		System.out.println("Are arrays A and B equal prior to sort: " + QS.arraysAreEqual(A, B));
		System.out.println("Are arrays A and C equal prior to sort: " + QS.arraysAreEqual(A, C) + "\n");
		
		System.out.println("Array of 10,000 Quicksort method 1:");
		QS.setStartTime();
		A = QS.qs1(A, 0, A.length-1);
		System.out.println("Duration of QS1: " + QS.duration() + " milliseconds");
		System.out.println("Comparison count of QS1: " + QS.getPartCount() + "\n");
		
		QS.reset();
		
		System.out.println("Array of 10,000 Quicksort java default method:");
		QS.setStartTime();
		Arrays.sort(B);
		System.out.println("Duration of QS java default: " + QS.duration() + " milliseconds" + "\n");
		
		QS.reset();
		
		System.out.println("Array of 10,000 Quicksort method 2 (median):");
		QS.setStartTime();
		C = QS.qs2(C, 0, C.length-1);
		System.out.println("Duration of QS2: " + QS.duration() + " milliseconds");
		System.out.println("Comparison count of QS2: " + QS.getPartCount() + "\n");
		
		System.out.println("Are arrays A and B equal after sort: " + QS.arraysAreEqual(A, B));
		System.out.println("Are arrays A and C equal after sort: " + QS.arraysAreEqual(A, C));
		System.out.println("Is array A sorted: " + QS.isSorted(A));
		System.out.println("Is array B sorted: " + QS.isSorted(B));
		System.out.println("Is array C sorted: " + QS.isSorted(C)+ "\n\n");
		
		
		QS.reset();
		

		System.out.println("Setup 3 arrays of 100,000 elements:");
		int [] D = QS.populate(10000);
		int [] E = QS.getCopy(D);
		int [] F = QS.getCopy(D);
		System.out.println("Are arrays D and E equal prior to sort: " + QS.arraysAreEqual(D, E));
		System.out.println("Are arrays D and F equal prior to sort: " + QS.arraysAreEqual(D, F) + "\n");
		
		System.out.println("Array of 100,000 Quicksort method 1:");
		QS.setStartTime();
		D = QS.qs1(D, 0, D.length-1);
		System.out.println("Duration of QS1: " + QS.duration() + " milliseconds");
		System.out.println("Comparison count of QS1: " + QS.getPartCount() + "\n");
		
		QS.reset();
		
		System.out.println("Array of 100,000 Quicksort java default method:");
		QS.setStartTime();
		Arrays.sort(E);
		System.out.println("Duration of QS java default: " + QS.duration() + " milliseconds" + "\n");
		
		QS.reset();
		
		System.out.println("Array of 100,000 Quicksort method 2 (median):");
		QS.setStartTime();
		F = QS.qs2(F, 0, C.length-1);
		System.out.println("Duration of QS2: " + QS.duration() + " milliseconds");
		System.out.println("Comparison count of QS2: " + QS.getPartCount() + "\n");
		
		System.out.println("Are arrays D and E equal after sort: " + QS.arraysAreEqual(D, E));
		System.out.println("Are arrays D and F equal after sort: " + QS.arraysAreEqual(D, F));
		System.out.println("Is array D sorted: " + QS.isSorted(D));
		System.out.println("Is array E sorted: " + QS.isSorted(E));
		System.out.println("Is array F sorted: " + QS.isSorted(F)+ "\n\n");
		
		
		QS.reset();
		
		
		System.out.println("Setup 3 arrays of 1,000,000 elements:");
		int [] G = QS.populate(1000000);
		int [] H = QS.getCopy(G);
		int [] I = QS.getCopy(G);
		System.out.println("Are arrays G and H equal prior to sort: " + QS.arraysAreEqual(G, H));
		System.out.println("Are arrays G and I equal prior to sort: " + QS.arraysAreEqual(G, I) + "\n");
		
		System.out.println("Array of 1,000,000 Quicksort method 1:");
		QS.setStartTime();
		G = QS.qs1(G, 0, G.length-1);
		System.out.println("Duration of QS1: " + QS.duration() + " milliseconds");
		System.out.println("Comparison count of QS1: " + QS.getPartCount() + "\n");
		
		QS.reset();
		
		System.out.println("Array of 1,000,000 Quicksort java default method:");
		QS.setStartTime();
		Arrays.sort(H);
		System.out.println("Duration of QS java default: " + QS.duration() + " milliseconds" + "\n");
		
		QS.reset();
		
		System.out.println("Array of 1,000,000 Quicksort method 2 (median):");
		QS.setStartTime();
		I = QS.qs2(I, 0, I.length-1);
		System.out.println("Duration of QS2: " + QS.duration() + " milliseconds");
		System.out.println("Comparison count of QS2: " + QS.getPartCount() + "\n");
		
		System.out.println("Are arrays G and H equal after sort: " + QS.arraysAreEqual(G, H));
		System.out.println("Are arrays G and I equal after sort: " + QS.arraysAreEqual(G, I));
		System.out.println("Is array G sorted: " + QS.isSorted(G));
		System.out.println("Is array H sorted: " + QS.isSorted(H));
		System.out.println("Is array I sorted: " + QS.isSorted(I)+ "\n\n");
		
		
		QS.reset();
		
		
		System.out.println("Setup 3 arrays of 10,000,000 elements:");
		int [] J = QS.populate(10000000);
		int [] K = QS.getCopy(J);
		int [] L = QS.getCopy(J);
		System.out.println("Are arrays G and H equal prior to sort: " + QS.arraysAreEqual(J, K));
		System.out.println("Are arrays G and I equal prior to sort: " + QS.arraysAreEqual(J, L) + "\n");
		
		System.out.println("Array of 10,000,000 Quicksort method 1:");
		QS.setStartTime();
		J = QS.qs1(J, 0, J.length-1);
		System.out.println("Duration of QS1: " + QS.duration() + " milliseconds");
		System.out.println("Comparison count of QS1: " + QS.getPartCount() + "\n");
		
		QS.reset();
		
		System.out.println("Array of 10,000,000 Quicksort java default method:");
		QS.setStartTime();
		Arrays.sort(K);
		System.out.println("Duration of QS java default: " + QS.duration() + " milliseconds" + "\n");
		
		QS.reset();
		
		System.out.println("Array of 10,000,000 Quicksort method 2 (median):");
		QS.setStartTime();
		L = QS.qs2(L, 0, L.length-1);
		System.out.println("Duration of QS2: " + QS.duration() + " milliseconds");
		System.out.println("Comparison count of QS2: " + QS.getPartCount() + "\n");
		
		System.out.println("Are arrays J and K equal after sort: " + QS.arraysAreEqual(J, K));
		System.out.println("Are arrays J and L equal after sort: " + QS.arraysAreEqual(J, L));
		System.out.println("Is array G sorted: " + QS.isSorted(J));
		System.out.println("Is array H sorted: " + QS.isSorted(K));
		System.out.println("Is array I sorted: " + QS.isSorted(L)+ "\n\n");
		
		
		
		QS.initializeCounter();
		QS.reset();
		
		
		System.out.println("Setup 3 arrays of 100,000,000 elements:");
		int [] M = QS.populate(100000000);
		int [] N = QS.getCopy(M);
		int [] O = QS.getCopy(M);
		System.out.println("Are arrays G and H equal prior to sort: " + QS.arraysAreEqual(M, N));
		System.out.println("Are arrays G and I equal prior to sort: " + QS.arraysAreEqual(M, O) + "\n");
		
		System.out.println("Array of 100,000,000 Quicksort method 1:");
		QS.setStartTime();
		M = QS.qs1(M, 0, M.length-1);
		System.out.println("Duration of QS1: " + QS.duration() + " milliseconds");
		System.out.println("Comparison count of QS1: " + QS.getPartCount() + "\n");
		
		QS.reset();
		
		System.out.println("Array of 100,000,000 Quicksort java default method:");
		QS.setStartTime();
		Arrays.sort(N);
		System.out.println("Duration of QS java default: " + QS.duration() + " milliseconds" + "\n");
		
		QS.reset();
		
		System.out.println("Array of 100,000,000 Quicksort method 2 (median):");
		QS.setStartTime();
		O = QS.qs2(O, 0, O.length-1);
		System.out.println("Duration of QS2: " + QS.duration() + " milliseconds");
		System.out.println("Comparison count of QS2: " + QS.getPartCount() + "\n");
		
		System.out.println("Are arrays M and N equal after sort: " + QS.arraysAreEqual(M, N));
		System.out.println("Are arrays M and O equal after sort: " + QS.arraysAreEqual(M, O));
		System.out.println("Is array M sorted: " + QS.isSorted(M));
		System.out.println("Is array N sorted: " + QS.isSorted(N));
		System.out.println("Is array O sorted: " + QS.isSorted(O)+ "\n\n");
		
	}

}
