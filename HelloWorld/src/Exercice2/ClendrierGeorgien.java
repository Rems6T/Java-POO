package Exercice2;

import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

public class ClendrierGeorgien {

	private static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		GregorianCalendar date = new GregorianCalendar();
		String saisie;
		do {
			afficherMois(date.get(GregorianCalendar.YEAR), date.get(GregorianCalendar.MONTH));

			System.out.println("(q) quitter (-) mois précédent " + "(+) mois suivant (d) date personnalisée");
			saisie = s.nextLine();
			switch (saisie) {
			case "-":
				date.add(GregorianCalendar.MONTH, -1);
				break;
			case "+":
				date.add(GregorianCalendar.MONTH, 1);
				break;
			case "d":
				System.out.println("année ?");
				int annee = s.nextInt();
				s.nextLine();
				System.out.println("mois ?");
				int mois = s.nextInt();
				s.nextLine();
				date.set(annee, mois - 1, 1);
				break;
			case "q": // rien du tout
				break;
			default:
				System.err.println("Saisie incorrecte");
				break;
			}
		} while (!saisie.equals("q"));
	}

	public static void afficherMois(int annee, int mois) {
		GregorianCalendar jour = new GregorianCalendar(annee, mois, 1);
		System.out.format(" * %s %d *%n",
				jour.getDisplayName(GregorianCalendar.MONTH, GregorianCalendar.LONG_FORMAT, Locale.FRANCE),
				jour.get(GregorianCalendar.YEAR));
		System.out.println("L  Ma Me J  V  S  D");

		int indice = 0;

		switch (jour.get(GregorianCalendar.DAY_OF_WEEK)) {
		case GregorianCalendar.TUESDAY:
			indice = 1;
			break;
		case GregorianCalendar.WEDNESDAY:
			indice = 2;
			break;
		case GregorianCalendar.THURSDAY:
			indice = 3;
			break;
		case GregorianCalendar.FRIDAY:
			indice = 4;
			break;
		case GregorianCalendar.SATURDAY:
			indice = 5;
			break;
		case GregorianCalendar.SUNDAY:
			indice = 6;
			break;
		}
		for (int i = 0; i < indice; i++) {
			System.out.print("   ");
		}
		int nbJoursDansLeMois = jour.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		for (int i = 1; i <= nbJoursDansLeMois; i++) {
			System.out.format("%02d ", jour.get(GregorianCalendar.DAY_OF_MONTH));
			jour.add(GregorianCalendar.DAY_OF_MONTH, 1);
			if (jour.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.MONDAY)
				System.out.println();
		}
		System.out.println();
	}

}
