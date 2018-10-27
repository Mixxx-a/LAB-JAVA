
public class Rational {
    private int numerator;
    private int denomirator;

    public Rational() {
        this.numerator = 0;
        this.denomirator = 1;
    }

    public Rational(int num, int den) {
        if ((num < 0) && (den < 0))
        {
            num = -num;
            den = -den;
        }
        int gcd = Util.gcd(Math.abs(num), Math.abs(den));
        this.numerator = num / gcd;
        this.denomirator = den / gcd;
    }

    /* private void setNumerator(int Num) {
        this.numerator = Num;
    }

    private void setDenomirator(int Num) {
        this.denomirator= Num;
    } */

    private int getNumerator() {
        return this.numerator;
    }

    private int getDenomirator() {
        return this.denomirator;
    }

    @Override
    public String toString() {
        return this.numerator + "/" + this.denomirator;
    }

    double getValue() {
        return (double)this.numerator / (double)this.denomirator;
    }

    void plusFriction (Rational another) {
        this.numerator = this.numerator * another.getDenomirator() + another.getNumerator() * this.getDenomirator();
        this.denomirator *= another.getDenomirator();
        int gcd = Util.gcd(Math.abs(this.numerator), Math.abs(this.denomirator));
        this.numerator /= gcd;
        this.denomirator /= gcd;
    }
}
