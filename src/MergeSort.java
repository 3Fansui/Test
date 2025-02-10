public class MergeSort {

    public static void main(String[] args) {
        int[] nums = {9,8,7,6,5,4,3,2,1};
        spilt(nums, 0, nums.length - 1,new int[nums.length]);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    static void spilt(int[] a, int left, int right, int[] a2) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) >>> 1;
        spilt(a, left, mid, a2);
        spilt(a, mid + 1, right, a2);
        merge(a, left, mid, mid + 1, right, a2);
        System.arraycopy(a2,left,a,left,right - left + 1);
    }

    static void merge(int[] a, int i, int ie, int j, int je, int[] a2) {
        int p = i;
        while (i <= ie && j <= je) {
            if (a[i] < a[j]) {
                a2[p] = a[i++];
            }else {
                a2[p] = a[j++];
            }
            p++;
        }
        if (i <= ie) {
            System.arraycopy(a, i, a2, p, ie - i + 1);
        }
        if (j <= je) {
            System.arraycopy(a, j, a2, p, je - j + 1);
        }
    }
}
