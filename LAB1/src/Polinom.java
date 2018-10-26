import java.util.ArrayList;

public class Polinom {
    private ArrayList<Rational> polinom;

    public Polinom(SetOfRational frictions) {
        polinom = new ArrayList<Rational>();
        for (int i = 0; i < frictions.size(); i++) {
            polinom.add(frictions.getFrictionI(i));
        }
    }

    int size () {
        return polinom.size();
    }

    Rational getFrictionI(int i) {
        return polinom.get(i);
    }

    @Override
    public String toString() {
        String ans = "";
        for (int i = 0; i < this.size() - 1; i++)
            ans = ans + this.getFrictionI(i).toString() + " * x^" + i + " + ";
        ans = ans + this.getFrictionI(this.size() - 1).toString() + " * x^" + (this.size() - 1);
        return ans;
    }

    void addPolinom (Polinom anotherPol) {
        int length1 = this.size(), length2 = anotherPol.size();
        int minlength = length1 > length2 ? length2 : length1;
        for (int i = 0; i < minlength; i++) {
            this.getFrictionI(i).plusFriction(anotherPol.getFrictionI(i));
        }
        if (minlength == length1) {
            for (int i = length1; i < anotherPol.size(); i++)
            {
                polinom.add(anotherPol.getFrictionI(i));
            }
        }

    }
}
