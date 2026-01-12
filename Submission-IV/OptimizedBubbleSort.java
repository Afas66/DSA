public class OptimizedBubbleSort {

    static void optimizedBubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for(int i = 0; i < n - 1; i++) {
            swapped = false;

            for(int j = 0; j < n - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if(!swapped)
                break;
        }
    }

    static void printArray(int[] arr) {
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 0, 1, 8, 7, 2};

        optimizedBubbleSort(arr);
        System.out.println("Sorted Array using Optimized Bubble Sort:");
        printArray(arr);
    }
}
