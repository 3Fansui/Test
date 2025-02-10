public class Kmp {


    public static void main(String[] args) {
        System.out.println(kmp("aaaleetocode","leeto" ));
    }

    static int kmp(String origin, String pattern) {
        int[] c = lps(origin);
        char[] c1 = origin.toCharArray();
        char[] c2 = pattern.toCharArray();
        int i = 0;
        int j = 0;
        while (c1.length - i >= c2.length - j) {
            if (c1[i] == c2[j]) {
                i++;
                j++;
            } else if (j == 0) {
                i++;
            }else {
                j = c[j-1];
            }
            if (j == c2.length) {
                return i - j;
            }
        }
        return -1;
    }

    private static int[] lps(String pattern) {
        int i = 1;
        int j = 0;
        int[] result = new int[pattern.length()];
        char[] c = pattern.toCharArray();
        while (i < pattern.length()) {
            if (c[i] == c[j]) {
                result[i] = j + 1;
                i++;
                j++;
            } else if (j == 0) {
                i++;
            } else {
                j = result[j - 1];
            }
        }
        return result;
    }

}
