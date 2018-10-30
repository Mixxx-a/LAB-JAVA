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
        if (this.size() > 0)
            ans += this.getFractionI(0).toString();
        if ((this.size() > 1) && (this.getFractionI(0).getNumerator() != 0))
            ans = ans + " + " + this.getFractionI(1).toString() + " * x ";
        for (int i = 1; i < this.size() - 1; i++)
            ans = ans + this.getFractionI(i).toString() + " * x^" + i + " + ";
        ans = ans + this.getFractionI(this.size() - 1).toString() + " * x^" + (this.size() - 1);
        return ans;
    }

    private String printFraction (Rational fraction, int degree) {
        if (fraction.getNumerator() == 0)
            return "";
        else {
            switch (degree) {
                case 0:
                    return fraction.toString();
            }

        }

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
