import java.util.ArrayList;
public class SetOfRational {
    private ArrayList<Rational> rationallist;

    SetOfRational (Rational fraction) {
        rationallist = new ArrayList<>(); //Explicit type argument <Rational>
        rationallist.add(fraction);
    }

    SetOfRational() {
        rationallist = new ArrayList<>();
    }

    int size() {
        return rationallist.size();
    }

    Rational getFrictionI(int i) {
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

    Rational maxFrictionInSet() {
        Rational Maximum = rationallist.get(0);
        for (int i = 1; i < rationallist.size(); i++) {
            if (rationallist.get(i).getValue() > Maximum.getValue()) {
                Maximum = rationallist.get(i);
            }
        }
        return Maximum;
    }

    Rational minFrictionInSet() {
        Rational Minimum = rationallist.get(0);
        for (int i = 1; i < rationallist.size(); i++) {
            if (rationallist.get(i).getValue() < Minimum.getValue()) {
                Minimum = rationallist.get(i);
            }
        }
        return Minimum;
    }

    int higherThanFriction(Rational friction) {
        int counter = 0;
        double value = friction.getValue();
        for (int i = 0; i < rationallist.size(); i++) {
            if (rationallist.get(i).getValue() > value)
                counter++;
        }
        return counter;
    }

    int lowerThanFriction(Rational friction) {
        int counter = 0;
        double value = friction.getValue();
        for (int i = 0; i < rationallist.size(); i++) {
            if (rationallist.get(i).getValue() < value)
                counter++;
        }
        return counter;
    }
}
