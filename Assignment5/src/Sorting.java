// Sorting.java will continually test Merge sort and Bubble sort until either a Memory error
// occurs or they both exceed the 20 second run time limit.
import java.util.*;

public class Sorting {
	protected static double[] merge, bubble, mergeSortedArray;
	protected static int length;
	protected static boolean bubbleFlag = true, mergeFlag = true;
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("length will be multiplied by 10 and program will re-sort until run-time exceeds 20 seconds in both sorts.");
		System.out.println("Enter desired length of array: ");
		length = in.nextInt();
		while(bubbleFlag || mergeFlag){
			System.out.println("Length: " + length);
			if(bubbleFlag == false){
				System.out.println("Bubble sort exceeded run time.. no longer running bubble sort.");
				MakeArrays(length);
				mergeSortedArray = MergeSort(merge);
				length *= 10;
			}else{
				MakeArrays(length);
				bubbleSort(bubble);
				mergeSortedArray = MergeSort(merge);
				length *= 10;
			}
		}
	}
	// fills two arrays with identical random doubles between 0 and 1.
	public static void MakeArrays(int l){
		merge = new double[l];
		bubble = new double[l];
		for(int a = 0; a < l; a++){
			double temp = Math.random();
			merge[a] = temp;
			bubble[a] = temp;
		}
	}
	// sorts using bubble sort
	public static void bubbleSort( double a[]){
		double temp;
		long start = System.currentTimeMillis();
		for(int i = 0; i < a.length; i++){
			for(int j = 1; j < (a.length - i); j++){
				// resorts
				if(a[j-1] > a[j]){
					temp = a[j-1];
					a[j-1] = a[j];
					a[j] = temp;
				}
			}
			long checkTime = System.currentTimeMillis();
			if(((checkTime - start)/1000) > 20){
				System.out.println("Over 20 seconds! Stopping sort.");
				bubbleFlag = false;
				break;
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("Bubble Sort Run Time: " + ((end-start)/1000) + " Seconds.");
	}
	// Begins the merge-sort process
	public static double[] MergeSort(double a[]){
		long start = System.currentTimeMillis();
		double[] temp = new double[a.length];
		System.arraycopy(a, 0, temp, 0, temp.length);
		int size = 1;
		while(size < temp.length){
			int resize = 0;
			while(resize < temp.length){
				// create two arrays to be merged
				int firstArrayLength = Math.min(size, (temp.length - resize));
				int secondArrayLength = Math.min(size, (temp.length - resize - firstArrayLength));
				double[] first = new double[firstArrayLength];
				double[] second = new double[secondArrayLength < 0 ? 0 : secondArrayLength];
				// fill arrays
				System.arraycopy(temp, resize, first, 0, firstArrayLength);
				System.arraycopy(temp, (resize + firstArrayLength), second, 0, secondArrayLength);
				// merge arrays
				double[] merged = merge(first, second);
                System.arraycopy(merged, 0, temp, resize, merged.length);
                // begin next merge
                resize = resize + (2 * size);
                long check = System.currentTimeMillis();
                if((check - start)/1000 > 20){
                	System.out.println("Over 20 seconds! Stopping sort.");
                	mergeFlag = false;
                	break;
                }
            }
            // Increase the scope size.
            size *= 2;
            
		}
		long end = System.currentTimeMillis();
		System.out.println("Merge Sort Run Time: " + ((end - start)/1000) + " Seconds.");
        return temp;
	}
	// does the actual merging and sorting of two arrays
	public static double[] merge(double[] firstArray, double[] secondArray){
        double[] mergedArray = new double[firstArray.length + secondArray.length];
        int a = 0; //for first Array
        int b = 0; //for second Array
        int c = 0; //for final merged Array
        //this loop will merge the two arrays and place them in the merged Array
        while( a < firstArray.length && b < secondArray.length ) {
            if(firstArray[a] > secondArray[b]){
                mergedArray[c] = secondArray[b];
                b++; 
            }else{
                mergedArray[c] = firstArray[a];
                a++;
            }
            c++;
        } 
        //adds leftover elements from firstArray to merged[]
        while(a < firstArray.length) {
            mergedArray[c] = firstArray[a];
            a++;
            c++;
        }
        //adds leftover elements from secondArray to merged[]
        while(b < secondArray.length) {
            mergedArray[c] = secondArray[b];
            b++;
            c++;
        }
        return mergedArray;
	}
	public static void displayArrays(){
		for(int a = 0; a < length; a++){
			System.out.print("Merge: " + mergeSortedArray[a]);
			System.out.println(", Bubble: " + bubble[a]);
		}
	}
}

