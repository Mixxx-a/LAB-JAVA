public class LAB1 {
    public static void main(String[] args) {

        Rational first = new Rational(1, 2);
        Rational second = new Rational(1, 3);
        Rational third = new Rational();
        Rational fourth = new Rational(30, 10);
        Rational fifth = new Rational(-15, 4);
        Rational sixth = new Rational(128, 128);
        Rational seventh = new Rational(-4, 14);
        Rational eigth = new Rational(-36, -12);
        Rational nineth = new Rational(2, 1);

        System.out.println("-36 / -12 is " + eigth);

        SetOfRational mySet1 = new SetOfRational();
        mySet1.addFraction(first);
        mySet1.addFraction(second);
        mySet1.addFraction(third);
        SetOfRational mySet2 = new SetOfRational();
        mySet2.addFraction(fourth);
        mySet2.addFraction(fifth);
        SetOfRational mySet3 = new SetOfRational(sixth);
        mySet3.addFraction(sixth);
        mySet3.addFraction(sixth);
        mySet3.addFraction(seventh);
        mySet3.addFraction(eigth);
        mySet3.addFraction(eigth);

        System.out.println("From mySet1 : " + mySet1 + " the highest friction is " + mySet1.maxFrictionInSet());
        System.out.println("From mySet2 : " + mySet2 + " the lowest friction is " + mySet2.minFrictionInSet());
        System.out.println("mySet3 : " + mySet3 + "The highest is " + mySet3.maxFrictionInSet() + " and the lowest is " + mySet3.minFrictionInSet());
        System.out.println("From mySet3 number of frictions higher than " + nineth + " is " + mySet3.higherThanFriction(nineth) + " and lower than that is " + mySet3.lowerThanFriction(nineth));

        Polinom myPolinom1 = new Polinom(mySet1);
        Polinom myPolinom2 = new Polinom(mySet2);
        myPolinom1.addPolinom(myPolinom2);
    }
}