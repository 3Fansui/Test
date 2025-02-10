public class HeapSort {

    public static void main(String[] args) {
        int[] nums = {9,8,7,6,5,4,3,2,1};
        heapSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    static void heapSort(int[] arr) {
        heapify(arr);
        for (int i = arr.length - 1; i > 0 ; i--) {
            huan(arr,0,i);
            down(arr,0,i);
        }
    }


    static void heapify(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            down(arr,i,arr.length);
        }
    }

    static void down(int[] arr, int parent, int size) {
        while (true){

            int max = parent;
            int left = parent * 2 + 1;
            int right = left + 1;

            if (left < size && arr[left] > arr[max]) {
                max = left;
            }

            if (right < size && arr[right] > arr[max]) {
                max = right;
            }

            if (max == parent) {
                return;
            }

            huan(arr,parent,max);
            parent = max;
        }
    }

   static void huan(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
