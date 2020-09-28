package chapter11;

public class FractionTest
{

	// We could move the enter (Fraction) method to this class, to keep...
	// the Fraction class I/O-free
	
	public static void main(String[] args)
	{
		Fraction f = new Fraction(2, 3);
		f.print(); // Making the enter method static allows us to call it
				  //  before/in order to create a Fraction object
		Fraction g = Fraction.enter();
		System.out.println(g);
		System.out.println(g.toDouble());
		System.out.println(f.add(g));

	}

}
