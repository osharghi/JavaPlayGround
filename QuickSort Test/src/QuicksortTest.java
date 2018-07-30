import static org.junit.Assert.*;


import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

/**
 * The main JUnit Test class to test each method in Quicksort
 * 
 *
 */
public class QuicksortTest
{

   private Quicksort QS;

   @Before
   public void setUp() throws Exception
   {
      QS = new Quicksort();
      QS.reset();
      QS.setRand();
      QS.initializeCounter();
   } // setUp()



   /* Method to test the Sorting of an empty List
    */
   @Test
   public void testEmpty() {
	   
         int[] array1 = new int[0];
         int[] array2 = new int[0]; //correct sorted array
         
         array1 = QS.qs1(array1, 0, array1.length - 1);
         assertArrayEquals(array1,array2);
         array1 = QS.qs2(array1, 0, array1.length - 1);
         assertArrayEquals(array1,array2);
   }   

  
   /* Method to test the Sorting of an already sorted list:
    */
   @Test
   public void testSorted() {
	   
        int[] array1 = new int[20];
        int[] array2 = new int[20];
        int[] array3 = new int[20];
              
	 for (int i = 0; i < 10; i++) {
             array1[i] = i*2;
             array2[i] = i*2;
             array3[i] = i*2;

        }
	 
	// sort using Java's inbuilt sorting method
        Arrays.sort(array3);
         
        // run QS1()
        array1 = QS.qs1(array1, 0, array1.length - 1);
        assertArrayEquals(array1,array3);
        
        // run QS2()
        array2 = QS.qs2(array2, 0, array2.length - 1);
        assertArrayEquals(array2,array3);
        
   }
 
  
   /* Method to test the Sorting of a reverse sorted list:
    */
   @Test
   public void testReverseSorted() {
	   
        int[] array1 = new int[10];
        int[] array2 = new int[10];
        int[] array3 = new int[10];
        
        for (int i = 0; i < 10; i++) {
             array1[i] = (100-i);
             array2[i] = (100-i);
             array3[i] = (100-i);
        }
        
        //sort array3 
        Arrays.sort(array3); 
   
        // run QS1()
        array1 = QS.qs1(array1, 0, array1.length - 1);
        assertArrayEquals(array1,array3);
        
        // run QS2()
        array2 = QS.qs2(array2, 0, array2.length - 1);
        assertArrayEquals(array2,array3);
        
   }
   
   /*
    * Method to test the select method 
    */
    @Test
    public void testSelect() {
    	
      int[] array1 = new int[100];
       
      for (int i = 0; i < 100; i++) {
            array1[i] = i;
      }
      
      // median is 49
      int median=QS.select(array1,0, array1.length-1, array1.length/2);
      System.out.println("median:"+ QS.select(array1,0, array1.length-1, array1.length/2));
      assertEquals(median, 49);
       
    }
 
 
   /*
    * Method to test the randomness to the tests:
    */
    @Test
     public void testRandom() {
       int[] array1 = new int[10];
       
       for (int i = 0; i < 10; i++) {
            array1[i] = (int) Math.random()*10;
       } 
 
       //copy arrays
       int[] array2 = Arrays.copyOf(array1, array1.length);  
       int[] array3 = Arrays.copyOf(array1, array1.length); // correct sorted array 
       Arrays.sort(array3);
 
       // run QS1()
       array1 = QS.qs1(array1, 0, array1.length - 1);
       assertArrayEquals(array1,array3);
       
       // run QS2()
       array1 = QS.qs2(array2, 0, array2.length - 1);
       assertArrayEquals(array1,array3);
       
     }

   /* Method to test the timing of QS1
    *
    */
   @Test
   public void testQS1Timing()
   {
      // create an array and a sorted backup
      int[] array1 = QS.populate(10000);
      int[] array2 = QS.populate(1000000);
      int[] array3 = QS.populate(10000000);
      
      
      long start = System.currentTimeMillis();
      array1 = QS.qs1(array1, 0, array1.length - 1);
      long end = System.currentTimeMillis();
      long elapsed = end - start;
      System.out.println("QS1 time to sort 10000 elements in ms:"+ elapsed);

      start = System.currentTimeMillis();
      array2 = QS.qs1(array2, 0, array2.length - 1);
      end = System.currentTimeMillis();
      elapsed = end - start;
      System.out.println("QS1 time to sort 1000000 elements in ms:"+ elapsed);
      
      start = System.currentTimeMillis();
      array3 = QS.qs1(array3, 0, array3.length - 1);
      end = System.currentTimeMillis();
      elapsed = end - start;
      System.out.println("QS1 time to sort 100000000 elements in ms:"+ elapsed);
   }



   /* Method to test the timing of QS2
    *
    */
   @Test
   public void testQS2Timing()
   {
      // create an array and a sorted backup
      int[] array1 = QS.populate(10000);
      int[] array2 = QS.populate(1000000);
      int[] array3 = QS.populate(10000000);
      
      
      long start = System.currentTimeMillis();
      array1 = QS.qs2(array1, 0, array1.length - 1);
      long end = System.currentTimeMillis();
      long elapsed = end - start;
      System.out.println("QS2 time to sort 10000 elements in ms:"+ elapsed);

      start = System.currentTimeMillis();
      array2 = QS.qs2(array2, 0, array2.length - 1);
      end = System.currentTimeMillis();
      elapsed = end - start;
      System.out.println("QS2 time to sort 1000000 elements in ms:"+ elapsed);
      
      start = System.currentTimeMillis();
      array3 = QS.qs2(array3, 0, array3.length - 1);
      end = System.currentTimeMillis();
      elapsed = end - start;
      System.out.println("QS2 time to sort 100000000 elements in ms:"+ elapsed);
   } 


   /*
    * Method to test the number of comparisons in sorting an already sorted array of 10 numbers.
    * Number of comparisons should be 45
    */
   @Test
   public void testgetPartCount()
   {
      int[] array1 = new int[10];
            
      for (int i = 0; i < 10; i++) {
           array1[i] = i*20;
      }
      
      array1 = QS.qs1NotOptimized(array1, 0, array1.length - 1);
      System.out.println("comparisons in already sorted:"+ QS.getPartCount());
      long compare=QS.getPartCount();
      assertEquals(compare, 45);
   }
  

   /*
    * Method to test the number of comparisons in reverse sorted array of 10 numbers.
    * Number of comparisons should be 45.
    */	
   @Test
   public void testgetPartCountA()
   {
	  QS.reset();
      int[] array1 = new int[10];
      
      for (int i = 0; i < 10; i++) {
           array1[i] = (100-i);
      }
      
      array1 = QS.qs1NotOptimized(array1, 0, array1.length - 1);
      System.out.println("comparisons in reverse sorted:"+ QS.getPartCount());
      long compare=QS.getPartCount();
      assertEquals(compare, 45);
         
   } // getPartCount()

   @Test
   public void testSortCheck()
   {
	   int [] array1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	   int [] array2 = {10, 4, 2, 6, 4, 2, 8, 9, 1};
	   
	   boolean isSorted1 = QS.isSorted(array1);
	   assertTrue(isSorted1);
	   
	   boolean isSorted2 = QS.isSorted(array2);
	   assertFalse(isSorted2);
   }
   
   @Test
   public void testArraysAreEqualVerifier()
   {
	   int [] array1 = {10, 4, 2, 6, 4, 2, 8, 9, 1, 17};
	   int [] array2 = {10, 4, 2, 6, 4, 2, 8, 9, 1, 17};
	   
	   boolean areEqual = QS.arraysAreEqual(array1, array2);
	   assertTrue(areEqual);   
   }
   
   @Test
   public void testPopulate()
   {
	   int [] array1 = new int[10];
	   array1 = QS.populate(10);
	   assertEquals(array1.length, 10);
   }
   
   @Test
   public void testInsertionSort()
   {
	   int [] array1 = {10, 4, 2, 6, 4, 2, 8, 9, 1, 17};
	   int [] array2 = {10, 4, 2, 6, 4, 2, 8, 9, 1, 17};
	   
	   array1 = QS.insertionSort(array1, 0, array1.length-1);
	   Arrays.sort(array2);
	   assertArrayEquals(array1,array2);
   }
   
   @Test
   public void testRandomizedSelectMedian()
   {
	   int [] array1 = {2, 3, 1, 5, 4, 7};
	   int x = QS.select(array1, 0, array1.length-1, array1.length/2);
	   assertEquals(x, 2);
   }

   
} // class QuicksortTest
