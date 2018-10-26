public class Main {
    public static void main(String[] args) {
        int[] a1 = {0, 2, 2, 10, 10, 20};
        int[] a2 = {};
        int ans[] = new int [a1.length + a2.length];
        int i = 0, j = 0, k = 0;
        while ((i < a1.length) || (j < a2.length)) {
            if (i == a1.length){
                ans[k] = a2[j];
                j++;
            }
            else if (j == a2.length) {
                ans[k] = a1[i];
                i++;
            }
            else if (a1[i] < a2[j]){
                ans[k] = a1[i];
                i++;
            }
            else {
                ans[k] = a2[j];
                j++;
            }
            k++;
        }
        for (int c = 0; c < ans.length; c++)
        {
            System.out.print(ans[c] + ", ");
        }
    }
}
