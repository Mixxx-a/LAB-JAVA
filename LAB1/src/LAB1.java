public class LAB1 {
    public static void main(String[] args) {

        Rational zero = new Rational();
        Rational one = new Rational(1, 1);
        Rational minusone = new Rational(-1, 1);

        Rational first = new Rational(1, 2);
        Rational second = new Rational(1, 3);
        Rational third = new Rational(0, -5);
        Rational fourth = new Rational(30, 10);
        Rational fifth = new Rational(15, -4);
        Rational sixth = new Rational(128, 128);
        Rational seventh = new Rational(-4, 14);
        Rational eighth = new Rational(-36, -12);
        Rational ninth = new Rational(2, 1);

        System.out.println("15 / -4 is " + fifth);
        /*
        // Testing output of Polinomial
        RationalList mySet1 = new RationalList(first);
        RationalList mySet2 = new RationalList(zero);
        RationalList mySet3 = new RationalList(zero);
        mySet3.addFraction(one);
        mySet3.addFraction(minusone);
        RationalList mySet4 = new RationalList();
        mySet4.addFraction(fourth);
        mySet4.addFraction(fifth);
        mySet4.addFraction(sixth);
        mySet4.addFraction(seventh);
        mySet4.addFraction(fifth);

        Polinomial myPolinom1 = new Polinomial(mySet1);
        Polinomial myPolinom2 = new Polinomial(mySet2);
        Polinomial myPolinom3 = new Polinomial(mySet3);
        Polinomial myPolinom4 = new Polinomial(mySet4);

        System.out.println(myPolinom1);
        System.out.println(myPolinom2);
        System.out.println(myPolinom3);
        System.out.println(myPolinom4); */


//        /*
        RationalList mySet1 = new RationalList();
        mySet1.addFraction(first);
        mySet1.addFraction(second);
        mySet1.addFraction(third);
        RationalList mySet2 = new RationalList();
        mySet2.addFraction(fourth);
        mySet2.addFraction(fifth);
        RationalList mySet3 = new RationalList(sixth);
        mySet3.addFraction(sixth);
        mySet3.addFraction(sixth);
        mySet3.addFraction(seventh);
        mySet3.addFraction(eighth);
        mySet3.addFraction(eighth);

        System.out.println("From mySet1 : " + mySet1 + " the highest fraction is " + mySet1.maxFractionInSet());
        System.out.println("From mySet2 : " + mySet2 + " the lowest fraction is " + mySet2.minFractionInSet());
        System.out.println("mySet3 : " + mySet3 + "The highest is " + mySet3.maxFractionInSet() + " and the lowest is " + mySet3.minFractionInSet());
        System.out.println("From mySet3 number of fractions higher than " + ninth + " is " + mySet3.higherThanFraction(ninth) + " and lower than that is " + mySet3.lowerThanFraction(ninth));

        Polinomial myPolinom1 = new Polinomial(mySet1);
        Polinomial myPolinom2 = new Polinomial(mySet2);
        Polinomial myPolinom3 = new Polinomial(mySet3);

        System.out.println("1st polinom: " + myPolinom1);
        System.out.println("2nd polinom: " + myPolinom2);
        myPolinom1.addPolinom(myPolinom2);
        System.out.println("Their summ: " +  myPolinom1);
        System.out.println("and then + 3rd polinom: " + myPolinom3);
        myPolinom1.addPolinom(myPolinom3);
        System.out.println("Answer : " + myPolinom1 );

        System.out.println(new Polinomial(new RationalList()));
    }
}