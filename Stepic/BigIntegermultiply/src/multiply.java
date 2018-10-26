import java.math.BigInteger;

public class multiply {
    public static void main(String[] args) {
        int value = 1;
        BigInteger ans = new BigInteger("1");
        BigInteger k;
        for (int i = 1; i <= value; i++) {
            k = BigInteger.valueOf(i);
            ans = ans.multiply(k);
        }
        System.out.println(ans);
        /* BigInteger m = new BigInteger("2");
        BigInteger n = new BigInteger("3");
        BigInteger ans = m.multiply(n);
        System.out.println(ans); */
    }
}
