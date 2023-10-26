import java.util.Arrays;
import java.util.Random;

public class mergeSort
{
    public static Random random = new Random();
    public static void main(String[] args)
    {
        int[] myArray = new int[10000];
        Random random = new Random();
        
        fillRandomArray(myArray);
         
        long start = System.nanoTime();
        mergeSort(myArray, 0, myArray.length-1);
        long finish = System.nanoTime();
        long timeElapsed = finish - start;  
        System.out.println("Sorted Array: " + Arrays.toString(myArray));
        System.out.println("Sorting a random array took merge sort " + timeElapsed + " ns to complete");
    }
    
    public static int[] fillRandomArray(int[] theArray)
    {
        for (int i = 0; i < theArray.length -1; i++)
        {
            theArray[i] = random.nextInt(10000);
        }
        return theArray;
    }
    
    static void merge(int arr[], int start, int mid, int end)
    {
        int start2 = mid + 1;

        while(start <= mid && start2 <= end) 
        {
            //continue to move through the array until index in first array is greater than index in second array
            if (arr[start] <= arr[start2]) 
            {
                start++;
            }
            else 
            {
                int value = arr[start2];
                int index = start2;
    
                // Shift all the elements between index 1 and index 2 to the right
                while (index != start) 
                {
                    arr[index] = arr[index - 1];
                    index--;
                }
                //insert value into correct spot
                arr[start] = value;
     
                //update all the variables
                start++;
                mid++;
                start2++;
            }
        }
    }
    
    public static void mergeSort(int arr[], int l, int r)
    {
        //continue to break down the array into small subarrays
        if (l < r) 
        {
            int m = l + (r - l) / 2;
     
            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
     
            merge(arr, l, m, r);
        }
    }
}