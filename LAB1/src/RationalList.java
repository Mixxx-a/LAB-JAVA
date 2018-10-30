import java.util.ArrayList;

public class RationalList {
    private ArrayList<Rational> rationallist;

    public RationalList(Rational fraction) {
        rationallist = new ArrayList<>(); //Explicit type argument <Rational>
        rationallist.add(fraction);
    }

    public RationalList() {
        rationallist = new ArrayList<>();
    }

    int size() {
        return rationallist.size();
    }

    Rational getFractionI(int i) {
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
            if (rationallist.get(i).getValue() > Maximum.getValue()) {
                Maximum = rationallist.get(i);
            }
        }
        return Maximum;
    }

    Rational minFractionInSet() {
        Rational Minimum = rationallist.get(0);
        for (int i = 1; i < rationallist.size(); i++) {
            if (rationallist.get(i).getValue() < Minimum.getValue()) {
                Minimum = rationallist.get(i);
            }
        }
        return Minimum;
    }

    int higherThanFraction(Rational fraction) {
        int counter = 0;
        double value = fraction.getValue();
        for (Rational item : rationallist) {  // using foreach
            if (item.getValue() > value)
                counter++;
        }
        return counter;
    }

    int lowerThanFraction(Rational fraction) {
        int counter = 0;
        double value = fraction.getValue();
        for (int i = 0; i < rationallist.size(); i++) {  // using 'for'
            if (rationallist.get(i).getValue() < value)
                counter++;
        }
        return counter;
    }
}