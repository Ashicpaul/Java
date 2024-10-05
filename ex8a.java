package ex8a;
import java.util.Arrays;
public class ex8a {
private static void bubbleSort(int[] array) {
for (int i = 0; i < array.length - 1; i++) {
for (int j = 0; j < array.length - i - 1; j++) {
if (array[j] > array[j + 1]) {
int temp = array[j];
array[j] = array[j + 1];
array[j + 1] = temp;
}
}
}
}
private static int[] merge(int[] left, int[] right) {
int[] result = new int[left.length + right.length];
int i = 0, j = 0, k = 0;
while (i < left.length && j < right.length) {
result[k++] = (left[i] <= right[j]) ? left[i++] : right[j++];
}
while (i < left.length) {

result[k++] = left[i++];
}
while (j < right.length) {
result[k++] = right[j++];
}
return result;
}
public static void main(String[] args) {
System.out.println("Ashic Paul  URK23CS1021");
int n = 4; // Number of threads
int[] array = {64, 34, 25, 12, 22, 11, 90, 88, 76, 45, 32, 100, 54, 29};
int[][] subArrays = new int[n][];
Thread[] threads = new Thread[n];
for (int i = 0; i < n; i++) {
int start = i * array.length / n;
int end = (i == n - 1) ? array.length : (i + 1) * array.length / n;
subArrays[i] = Arrays.copyOfRange(array, start, end);
final int idx = i;
threads[i] = new Thread(() -> bubbleSort(subArrays[idx]));
threads[i].start();
}
for (Thread t : threads) {
try {
t.join();
} catch (InterruptedException e) {
e.printStackTrace();
}
}
int[] sortedArray = subArrays[0];
for (int i = 1; i < n; i++) {
sortedArray = merge(sortedArray, subArrays[i]);
}
System.out.println("Sorted array: " + Arrays.toString(sortedArray));
}
}