import java.util.Arrays;

public class mergeSort
{
    public static void main(String[] args)
    {
        int[] myArray = { 12, 11, 13, 5, 6, 7 };
 
        mergeSort(myArray, 0, myArray.length-1);
        System.out.println(Arrays.toString(myArray));
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