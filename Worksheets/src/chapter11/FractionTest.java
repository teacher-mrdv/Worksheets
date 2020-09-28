package chapter11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FractionTest
{

	// We moved the enter (Fraction) method to this class, to keep...
	// the Fraction class I/O-free
	// input a numerator and a denominator to make a fraction
	public static Fraction enterFraction()
	{
		// note: no format check, though!!!
		String strFraction = IBIO.input("Enter fraction (a/b format) ");
		strFraction = strFraction.replace("/", " "); // Changes slash to space
		Scanner parse = new Scanner(strFraction); // to parse the fraction
		int a = parse.nextInt(); // so we can extract the numerator
		int b = parse.nextInt(); // denominator
		parse.close();
		Fraction f = new Fraction(a, b);
		return f;
	}
	
	public static void listAsDouble(ArrayList<Fraction> fal)
	{
		for(Fraction f : fal)
		{
			System.out.printf("%.2f  ", f.toDouble());
		}
		System.out.println();
	}

	public static void main(String[] args)
	{
		Fraction f = new Fraction(2, 10);
		f.print();
		// Making the enter method static allows us to call it
		// before/in order to create a Fraction object
		Fraction g = enterFraction();
		System.out.println(g);
		System.out.println(g.toDouble());
		Fraction h = f.add(g);
		Fraction i = h.add(g);
		ArrayList<Fraction> fractionList = new ArrayList<>();
		fractionList.add(f);
		fractionList.add(i);
		fractionList.add(h);
		fractionList.add(g);
		System.out.println(fractionList);
		listAsDouble(fractionList);
		Collections.sort(fractionList);
		System.out.println(fractionList);
		listAsDouble(fractionList);

	}

}
