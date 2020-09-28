package chapter11;

import java.util.Scanner;

/*
 * Chapter 11 of the Java Worksheets, with improvements
 */
public class Fraction implements Comparable<Fraction>
{
	private int num;
	private int den;

	/* empty constructor is not good to include
	 * because an empty instantiated fraction would be 0/0 !
	public Fraction()
	{
	}
	*/

	// Constructor method
	public Fraction(int num, int den)
	{
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
	
	public Fraction add(Fraction b)
	{
		int resultNum = this.num * b.den + this .den * b.num;
		int resultDen = this.den * b.den;
		return new Fraction(resultNum, resultDen);
	}
	
	public int compareTo(Fraction b)
	{
		if( this.toDouble() == b.toDouble() )
			return 0;
		else
			return (int)(this.toDouble() - b.toDouble());
	}
	
	// polymorphism
	public String toString()
	{
		return this.num + "/" + this.den;
	}

}
