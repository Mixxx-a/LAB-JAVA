import java.util.ArrayList;
import java.util.List;

public class Polinomial {
    private List<Rational> polinom;
    // Indirection (GRASP patterns)

    public Polinomial(RationalList fractions) {
        polinom = new ArrayList<>();
        for (int i = 0; i < fractions.size(); i++) {
            polinom.add(fractions.get(i));
        }
    }

    int size () {
        return polinom.size();
    }

    Rational get(int i) {
        return polinom.get(i);
    }

    @Override
    public String toString() {
        String ans = "";
        boolean emptystringflag = true;
        if (this.size() > 0) {
            ans += zeroDegreeFraction(this.get(0));
            for (int i = 1; i < this.size(); i++) {
                if (!(ans.equals("")))
                    emptystringflag = false;
                ans += fractionInPolinom(this.get(i), i, emptystringflag);
            }
        }
       return "Pol{" + ans + "}";
    }

    private String zeroDegreeFraction (Rational fraction) {
        String stringfraction = "";
        if (fraction.getNumerator() == 0)
            return "";

        if (fraction.getNumerator() < 0)
            stringfraction += " - ";

        if (fraction.getDenomirator() == 1)
            stringfraction += Math.abs(fraction.getNumerator());
        else {
            stringfraction = stringfraction + Math.abs(fraction.getNumerator()) + "/" + fraction.getDenomirator();
        }

        return stringfraction;
    }

    private String fractionInPolinom (Rational fraction, int degree, boolean flag) {
        String stringfraction = "";
        if (fraction.getNumerator() == 0)
            return "";

        if (flag) {
            if (fraction.getNumerator() < 0)
                stringfraction += " - ";
        }
        else {
            if (fraction.getNumerator() > 0)
                stringfraction += " + ";
            else
                stringfraction += " - ";
        }

        if (fraction.getDenomirator() == 1) {
            if (Math.abs(fraction.getNumerator()) != 1)
                stringfraction = stringfraction + Math.abs(fraction.getNumerator()) + " * ";
        }
        else {
            stringfraction = stringfraction + Math.abs(fraction.getNumerator()) + "/" + fraction.getDenomirator() + " * ";
        }

        switch (degree) {
            case 1: {
                stringfraction += "x";
                break;
            }
            default:
                stringfraction = stringfraction + "x^" + degree;
            }

        return stringfraction;
    }

    void addPolinom (Polinomial anotherPol) {
        int length1 = this.size(), length2 = anotherPol.size();
        int minlength = length1 > length2 ? length2 : length1;
        for (int i = 0; i < minlength; i++) {
            this.get(i).plusRational(anotherPol.get(i));
        }
        if (minlength == length1) {
            for (int i = length1; i < anotherPol.size(); i++)
            {
                polinom.add(anotherPol.get(i));
            }
        }

    }
}
