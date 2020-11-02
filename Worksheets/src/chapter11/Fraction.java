package chapter11;

/*
 * Chapter 11 of the Java Worksheets, with improvements
 */
public class Fraction implements Comparable<Fraction>
{
	private int num;
	private int den;

	public Fraction()
	{
	}
	
	// Constructor method
	public Fraction(int num, int den) throws Exception 
	{
		if( den == 0 )
			throw new Exception("Division by zero");
		
		this.num = num;
		this.den = den;
		this.simplify();
	}

	public int getNum()
	{
		return num;
	}

	public void setNum(int num)
	{
		this.num = num;
	}

	public int getDen()
	{
		return den;
	}

	public void setDen(int den)
	{
		this.den = den;
	}

	// this is redundant, but it is an exaple of encapsulation
	public void print()
	{
		System.out.println(this.num + "/" + this.den);
	}

	// 

	private static int gcd(int num1, int num2)
	{
		int gcd = 1;
		while (num1 != num2)
		{
			if (num1 > num2)
			{	num1 = num1 - num2;
				gcd = num1;
			} else
			{	num2 = num2 - num1;
				gcd = num2;
			}
		}
		return gcd;
	}
	
	public void simplify()
	{
		int gcd = gcd(this.num, this.den);
		this.num = this.num / gcd;
		this.den = this.den / gcd;
		
	}
	
	public double toDouble()
	{
		return (double)this.num/this.den;
	}
	
	//
	// Homework: implement the add method!
	
	public Fraction add(Fraction b) throws Exception
	{
		int resultNum = this.num * b.den + this .den * b.num;
		int resultDen = this.den * b.den;
		return new Fraction(resultNum, resultDen);
	}
	
	public int compareTo(Fraction b)
	{
		double comp = this.toDouble() - b.toDouble();
		if( comp == 0)
			return 0;
		else if( comp < 0 )
			return -1;
		else
			return 1;
	}
	
	// polymorphism
	public String toString()
	{
		return this.num + "/" + this.den;
	}

}
