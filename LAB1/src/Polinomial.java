import java.util.ArrayList;

public class Polinomial {
    private ArrayList<Rational> polinom;

    public Polinomial(RationalList fractions) {
        polinom = new ArrayList<Rational>();
        for (int i = 0; i < fractions.size(); i++) {
            polinom.add(fractions.getFractionI(i));
        }
    }

    int size () {
        return polinom.size();
    }

    Rational getFractionI(int i) {
        return polinom.get(i);
    }

    @Override
    public String toString() {
        String ans = "";
        if (this.size() > 0) {
            ans += zeroDegreeFraction(this.getFractionI(0));
            for (int i = 1; i < this.size(); i++)
                ans += fractionInPolinom(this.getFractionI(i), i);
        }
       return ans;
    }

    private String zeroDegreeFraction (Rational fraction, Rational nextfraction) {
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

    private String fractionInPolinom (Rational fraction, int degree) {
        String stringfraction = "";
        if (fraction.getNumerator() == 0)
            return "";

        if (fraction.getNumerator() > 0)
            stringfraction += " + ";
        else
            stringfraction += " - ";

        if (fraction.getDenomirator() == 1)
            stringfraction += Math.abs(fraction.getNumerator());
        else {
            stringfraction = stringfraction + Math.abs(fraction.getNumerator()) + "/" + fraction.getDenomirator();
        }

        switch (degree) {
            case 1: {
                stringfraction += " * x";
            }
            default:
                stringfraction = stringfraction + "* x^" + degree;
            }

        return stringfraction;
    }

    void addPolinom (Polinomial anotherPol) {
        int length1 = this.size(), length2 = anotherPol.size();
        int minlength = length1 > length2 ? length2 : length1;
        for (int i = 0; i < minlength; i++) {
            this.getFractionI(i).plusRational(anotherPol.getFractionI(i));
        }
        if (minlength == length1) {
            for (int i = length1; i < anotherPol.size(); i++)
            {
                polinom.add(anotherPol.getFractionI(i));
            }
        }

    }
}
