package Task1;

import java.util.Arrays;

public class MyArray {
	private int[] array;

	public MyArray(int[] array) {

		this.array = array;
	}

	public int[] mirror() {
		int n = array.length;
		int[] result = new int[n * 2];
		for (int i = 0; i < n; i++) {
			result[i] = array[i];
			result[n * 2 - 1 - i] = array[i];
		}
		return result;
	}

	public int[] removeDuplicates() {
		 int[] result = new int[array.length];
		  int index = 0;
		  
		  for (int i = 0; i < array.length; i++) {
		    boolean isDuplicate = false;
		    
		    for (int j = 0; j < i; j++) {
		      if (array[i] == array[j]) {
		        isDuplicate = true;
		        break;
		      }
		    }
		    
		    if (!isDuplicate) {
		      result[index++] = array[i];
		    }
		  }
		  
		  return Arrays.copyOf(result, index);
	}

	public int[] getMissingValue() {
		int count = 0;
		int index = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i] > array[i - 1]) {
				count += array[i] - array[i - 1] - 1;
			}
		}
		int result[] = new int[count];
		for (int i = 1; i < array.length; i++) {
			if (array[i] - 1 > array[i - 1]) {
				for (int j = array[i - 1] + 1; j < array[i]; j++) {
					result[index] = j;
					index++;
				}
			}
		}
		return result;
	}

	public int[] fillMissingValues(int k) {
		int result[] = new int[array.length];
		int bf = k / 2;
		int at = k - bf;
		for (int i = 0; i < array.length; i++) {
			if (this.array[i] == -1) {
				int sum = 0;
				if (i - bf < 0) {
					for (int j = 0; j <= k; j++) {
						sum += array[j];
					}
				} else {
					for (int j = i - bf; j <= i + at; j++) {
						sum += array[j];
					}
				}
				result[i] = Math.round((sum + 1) / k);
			} else {
				result[i] = array[i];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] a1 = { 1, 2, 3 };
		MyArray a2 = new MyArray(a1);
		int[] a3 = a2.mirror();
		System.out.println("Mirror");
		System.out.println(Arrays.toString(a3));

		int[] a4 = { 1, 3, 5, 1, 3, 7, 9, 8 };
		MyArray a5 = new MyArray(a4);
		int[] a6 = a5.removeDuplicates();
		System.out.println("Remove duplicates");
		System.out.println(Arrays.toString(a6));

		int[] a7 = { 10, 11, 12, 13, 14, 16, 17, 19, 20 };
		MyArray a8 = new MyArray(a7);
		int[] a9 = a8.getMissingValue();
		System.out.println("Get missing value");
		System.out.println(Arrays.toString(a9));

		int[] a10 = { 10, 11, 12, -1, 14, 10, 17, 19, 20 };
		MyArray a11 = new MyArray(a10);
		int[] a12 = a11.fillMissingValues(3);
		System.out.println("Fill missing values");
		System.out.println(Arrays.toString(a12));

	}
}


