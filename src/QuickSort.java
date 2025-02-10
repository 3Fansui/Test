public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {9,8,7,6,5,4,3,2,1};
        quick(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    static void quick(int[] arr, int left, int right){
        if (left >= right){
            return;
        }

        int p = partition(arr,left,right);
        quick(arr,left,p - 1);
        quick(arr,p + 1,right);
    }

    private static int partition(int[] arr, int left, int right) {
        int p = left;
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && arr[j] > arr[p]) {
                j--;
            }
            while (i < j && arr[i] <= arr[p]) {
                i++;
            }
            huan(arr,i,j);
        }
        huan(arr,p,i);
        return i;
    }

    static void huan(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
