
public class Rational implements Comparable<Rational>{
    private int numerator;
    private int denominator;

    public Rational() {
        this.numerator = 0;
        this.denominator = 1;
    }

    public Rational(int numerator, int denominator) {
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        int gcd = Util.gcd(Math.abs(numerator), Math.abs(denominator));
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
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
        return this.denominator;
    }

    double getValue() {
        return (double)this.numerator / (double)this.denominator;
    }

    void plusRational(Rational another) {
        this.numerator = this.numerator * another.getDenomirator() + another.getNumerator() * this.getDenomirator();
        this.denominator *= another.getDenomirator();
        if (this.denominator < 0) {
            this.numerator *= -1;
            this.denominator *= -1;
        }
        int gcd = Util.gcd(Math.abs(this.numerator), Math.abs(this.denominator));
        this.numerator /= gcd;
        this.denominator /= gcd;
    }

    @Override
    public int compareTo(Rational other) {
        if ((this.getNumerator() * other.getDenomirator()) > (other.getNumerator() * this.getDenomirator()))
            return 1;
        else
            return -1;
    }

    @Override
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }
}
