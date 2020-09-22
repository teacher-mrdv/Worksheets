package Fraction;

public class FractionTest
{

	public static void main(String[] args)
	{
		Fraction f = new Fraction(2, 3);
		f.print();
		Fraction g = Fraction.enter();
		System.out.println(g);
		System.out.println(g.toDouble());
		

	}

}
