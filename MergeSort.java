//Carrik McNerlin and Khoa Nguyen
//Writing Assignment 2
//O(nlgn)
//Standard MergeSort

import java.util.Random;
import java.lang.Math;
public class MergeSort
{
  
  public static int n = 2500000; //arbitrarily large, can be changed
  public static int A[] = new int[n];
  //testing these for speed of dynamic vs static
  public static int T1[] = new int[n/2+10];
  public static int T2[] = new int[n/2+10];
  
  /*
   * Input: none
   * Output: sorted integer array
   * Calls: sort
   * Called by: NONE
   */
  public static void main(String[] args)
  {
    Random rand = new Random();
   
    for (int i = 0; i<n; i++)
      A[i] = rand.nextInt(100); //generate number from 0 to 99
    
    
//    System.out.println("Array: ");
//    for (int i = 0; i<n; i++)
//      System.out.print(A[i] + " ");
    
    MergeSort ms = new MergeSort();
    
    long StartTime, EndTime;
    StartTime = System.currentTimeMillis();
    ms.sort(A, 0, n-1);//let the work begin!!
    EndTime = System.currentTimeMillis();
    
//    System.out.println("\nSorted array: ");
//    for (int i = 0; i < n; i++)
//      System.out.print(A[i] + " ");
    
    
    System.out.println("\nThis took " + (EndTime-StartTime) + " milliseconds to complete");
  }//end main
  
  
  
  //merge function
  //called by sort()
  //calls NONE
  void merge(int A[], int p, int q, int r)
  {
    int leftN = q - p + 1;
    int rightN = r - q;
//
//    int T1[] = new int [leftN];    //test with huge numbers, test with these hard allocated with A[]
//    int T2[] = new int [rightN];   //probably 
    
    //populate temp arrays
    for (int i=0; i < leftN; i++)
      T1[i] = A[(p+i)];
    
    for (int i=0; i < rightN; i++)
      T2[i] = A[(q+i+1)];
    
    
    //i, j, and k are indexes for T1, T2, and A respectively
    int i = 0;
    int j = 0;
    int k = p;
    
    while (i < leftN && j < rightN)
    {
      //puts in place smaller element, increments to move through that temp array
      if (T1[i] <= T2[j])
      {
        A[k] = T1[i];
        i++;
      }else{
       A[k] = T2[j];
       j++;
      }
      k++; //always increment the permanent array's index
    }//end while
    
    //copy remaining elements (if any)
    while (i < leftN)
    {
      A[k] = T1[i];
      i++;
      k++;
    }
    
    while (j < rightN)
    {
      A[k] = T2[j];
      j++;
      k++;
    }
    
  }//end merge
  
  //sort function
  //called by main
  //calls [self], merge
  void sort(int A[], int p, int r)
  {
    if (r > p)
    {
      int q = (int)Math.floor((p+r)/2);
      
      sort(A, p, q);
      sort(A, q+1, r);
      merge(A, p, q, r);
    }
  }//end sort()
}//end MergeSort