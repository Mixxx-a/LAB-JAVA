
public class Rational implements Comparable<Rational>{
    private int numerator;
    private int denomirator;

    public Rational() {
        this.numerator = 0;
        this.denomirator = 1;
    }

    public Rational(int num, int den) {
        if (den < 0) {
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

    int getNumerator() {
        return this.numerator;
    }

    int getDenomirator() {
        return this.denomirator;
    }

    @Override
    public String toString() {
        return this.numerator + "/" + this.denomirator;
    }

    double getValue() {
        return (double)this.numerator / (double)this.denomirator;
    }

    void plusRational(Rational another) {
        this.numerator = this.numerator * another.getDenomirator() + another.getNumerator() * this.getDenomirator();
        this.denomirator *= another.getDenomirator();
        if (this.denomirator < 0) {
            this.numerator *= -1;
            this.denomirator *= -1;
        }
        int gcd = Util.gcd(Math.abs(this.numerator), Math.abs(this.denomirator));
        this.numerator /= gcd;
        this.denomirator /= gcd;
    }

    @Override
    public int compareTo(Rational other) {
        if ((this.getNumerator() * other.getDenomirator()) > (other.getNumerator() * this.getDenomirator()))
            return 1;
        else
            return -1;
    }
}
