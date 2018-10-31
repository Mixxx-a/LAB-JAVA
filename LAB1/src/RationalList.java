import java.util.ArrayList;
import java.util.List;

public class RationalList {
    private List<Rational> rationallist;

    public RationalList(Rational fraction) {
        rationallist = new ArrayList<Rational>(); //Explicit type argument <Rational>
        rationallist.add(fraction);
    }

    public RationalList() {
        rationallist = new ArrayList<>();
    }

    int size() {
        return rationallist.size();
    }

    Rational get(int i) {
        return rationallist.get(i);
    }

    void addFraction (Rational fraction) {
        rationallist.add(fraction);
    }

    @Override
    public String toString(){
        String ans = "";
        for (Rational aRationallist : rationallist)
            ans = ans + aRationallist.toString() + "; ";  //Automatically replaced with foreach, need to use StringBuilder?
        return ans;
    }

    Rational maxFractionInSet() {
        Rational Maximum = rationallist.get(0);
        for (int i = 1; i < rationallist.size(); i++) {
            if ((rationallist.get(i).compareTo(Maximum)) > 0) {
                Maximum = rationallist.get(i);
            }
        }
        return Maximum;
    }

    Rational minFractionInSet() {
        Rational Minimum = rationallist.get(0);
        for (int i = 1; i < rationallist.size(); i++) {
            if ((rationallist.get(i).compareTo(Minimum)) < 0) {
                Minimum = rationallist.get(i);
            }
        }
        return Minimum;
    }

    int higherThanFraction(Rational fraction) {
        int counter = 0;
        for (Rational item : rationallist) {  // using foreach
            if ((item.compareTo(fraction)) > 0)
                counter++;
        }
        return counter;
    }

    int lowerThanFraction(Rational fraction) {
        int counter = 0;
        for (int i = 0; i < rationallist.size(); i++) {  // using 'for'
            if((rationallist.get(i).compareTo(fraction)) < 0)
                counter++;
        }
        return counter;
    }
}
