import java.lang.StringBuilder;

public class Pal {
    public static void main(String[] args) {
        String text = "Madam I'm Adam";
        text = text.toUpperCase();
        StringBuilder lasttext = new StringBuilder();
        lasttext.append(text);
        for (int i = 0; i < lasttext.length(); i++) {
            char buk = lasttext.charAt(i);
            if ((buk >= '0') && (buk <= '9') || (buk >= 'A') && (buk <= 'Z')) {

            }
            else {
                lasttext.deleteCharAt(i);
                i--;
            }
        }
        StringBuilder reverselasttext = new StringBuilder();
        reverselasttext.append(lasttext);
        reverselasttext.reverse();
        System.out.println(lasttext);
        System.out.println(reverselasttext);
        boolean ans = lasttext.toString().equals(reverselasttext.toString());
        System.out.println(ans);
    }
}
