package Exercice1;

import java.util.InputMismatchException;
// On importe une classe de Java qui permet de lire les saisies de l'utilisateur
import java.util.Scanner;

public class LesLecons {

//	Déclaration d'une constante
	public static final double TVA = 20.0 / 100;

	public static void main(String[] args) {
//		Déclaration d'une variable
		double prixHT = 17.85;
		System.out.printf("Prix TTC de l'article : %.2f€%n", prixHT * (1 + TVA));

//		Déclaration d'un tableau de taille 100
		float[] valeurs = new float[100];
//		Ecriture dans la 8eme case du tableau
		valeurs[7] = 1792;
//		Lecture d'une valeur du tableau
		System.out.println(valeurs[7]);

//		Création de la variable qui va lire les saisies de l'utilisateur
		Scanner s = new Scanner(System.in);
		System.out.println("Quel est votre prénom ? ");
//		On récupère une saisie en String (nextInt pour les nombres, nextFloat pour les nombres à virgule, etc...)
		String prenom = s.nextLine();
		s.close();

//		Les conditionnelles

//		La condition if
//		Simple
		if (prenom.length() == 0)
			System.err.println("Le prénom est obligatoire !");

//		Double
		if (prenom.length() == 0)
			System.err.println("Le prénom est obligatoire !");
		else
			System.out.printf("Bonjour %s ! %n", prenom);

//		Si on ne veut pas afficher de message d'erreur, on peut demander le contraire du résultat
		if (!(prenom.length() == 0))
			System.out.printf("Bonjour %s ! %n", prenom);
//		OU
		if (prenom.length() != 0)
			System.out.printf("Bonjour %s ! %n", prenom);

//		If avec plusieurs conditions, on doit mettre des accolades
		if (prenom.length() == 0) {
			System.err.println("Le prénom est obligatoire !");
			System.exit(1);
		}

//		La condition "switch"
		String aJeter = "carton";
		switch (aJeter) {
		case "papier":
		case "carton":
		case "boite de conserve":
			System.out.println("Recyclage");
			break;
		case "végétaux":
		case "épluchures":
			System.out.println("Composte");
			break;
		default:
			System.out.println("Poubelle");
			break;
		}

//		Les boucles

//		For
		float[] valeurs2 = { 10.5f, 14.2f, 15.78f, 20, 19.2f };
		for (int i = 0; i < valeurs2.length; i++) {
			System.out.printf("%.2f%n", valeurs2[i]);
		}

//		Foreach
//		Traduction : f prend la valeur de chaque valeur du tableau "valeurs2" un après l'autre jusqu'à la fin du tableau
		for (float f : valeurs2) {
			System.out.printf("%.2f%n", f);
		}

//		While
		float total = 0;
		System.out.println("Saisissez une valeur ou rien pour terminer la saisie");
		String saisie = s.nextLine();
		while (!saisie.isEmpty()) {
			float valeur = Float.parseFloat(saisie);
			total += valeur;
			System.out.println("Saisissez une note ou rien pour terminer la saisie");
			saisie = s.nextLine();
		}
		System.out.printf("Total des valeurs saisies : %f%n", total);

//		Do while
		int min = 1;
		int max = 10;
		String message = "";
		System.out.printf("Entrez un nombre", message);
		int val = 0;
		boolean ok;
		do {
			val = s.nextInt();
			s.nextLine();
			ok = val >= min && val <= max;
			if (!ok)
				System.err.printf("La valeur doit être un entier compris entre %d et %d%nResaisissez...", min, max);
		} while (!ok);

//		Procédures et fonctions (voir les lignes 126 à 142)
		salutations();

//		
	}

	private static void salutations() {
		String prenom = saisirPrenom();
		afficherSalutation(prenom);
	}

	private static String saisirPrenom() {
		Scanner s = new Scanner(System.in);
		System.out.println("Saisissez votre prénom : ");
		String prenom = s.nextLine();
		s.close();
		return prenom;
	}

	private static void afficherSalutation(String prenom) {
		System.out.print("Bonjour " + prenom + " !");
	}

	public static int saisie(String message, int min, int max) {
		Scanner s = new Scanner(System.in);
		System.out.printf("%s ", message);
		int val = 0;
		boolean ok;
		do {
			try {
				val = s.nextInt();
				ok = val >= min && val <= max;
			} catch (InputMismatchException e) {
				ok = false;
			} finally {
				s.nextLine();
			}
			if (!ok)
				System.err.printf("Saisissez un entier compris entre %d et %d%n", min, max);
		} while (!ok);
		s.close();
		return val;
	}
}
