package Fraction;

import java.util.Scanner;

/*
 * Chapter 11 of the Java Worksheets
 */
public class Fraction
{
	private int num;
	private int den;

	// Constructor methods
	public Fraction()
	{
	}

	public Fraction(int num, int den)
	{
		this.num = num;
		this.den = den;
		this.cancel();
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

	// input a numerator and a denominator to make a fraction 
	public static Fraction enter()
	{
		// note: no format check, though!!!
		String strFraction = IBIO.input("Enter fraction (a/b format)");
		strFraction = strFraction.replace("/", " "); // Changes slash to space
		Scanner parse = new Scanner(strFraction); // to parse the fraction
		int a = parse.nextInt(); // so we can extract the numerator
		int b = parse.nextInt(); // denominator
		parse.close();
		Fraction f = new Fraction(a, b);
		return f;
	}

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
	
	public void cancel()
	{
		int gcd = gcd(this.num, this.den);
		this.num = this.num / gcd;
		this.den = this.den / gcd;
		
	}

	// polymorphism
	public String toString()
	{
		return this.num + "/" + this.den;
	}

}
