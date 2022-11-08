package Exercice1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class exercice1 {

	public static final String FICHIER_MOTS = "./dictionnaire.txt";
	public static final int NB_MOTS = 22506;
	public static Random r = new Random();

	public static final char VIDE = ' ';

	public static void main(String[] args) {
		try {
			char[] mot = tirerMotAleatoirement();
			char[] tirage = melanger(mot);
			System.out.println("Voici le tirage :");
			afficher(tirage);
			Scanner s = new Scanner(System.in);
			System.out.println("Quel est le mot caché dans ce tirage ?");
			char[] r = s.nextLine().toUpperCase().toCharArray();
			if (!bonnesLettres(r, tirage)) {
				System.out.println("Lettre incorrecte !");
			} else {
				if (!dansLeDico(r)) {
					System.out.println("Mot non présent dans le dico");
				} else {
					System.out.println("Bravo, vous marquez " + r.length + " points");
				}
			}
			afficher(mot);
			s.close();
		} catch (IOException e) {
			System.err.println("Problème de lecture du dictionnaire");
		}
	}

//	Retourne: char | Paramètre: X
	public static char[] tirerMotAleatoirement() throws IOException {
		int numMot = r.nextInt(NB_MOTS);
		try (FileInputStream fichier = new FileInputStream(FICHIER_MOTS); Scanner s = new Scanner(fichier)) {
			for (int i = 1; i <= numMot; i++)
				s.nextLine();
			return s.nextLine().toUpperCase().toCharArray();
		}

	}

//	Retourne: char | Paramètre: char
	private static char[] melanger(char[] motTirer) {
		// copie du tableau de caractères
		char[] randomized = new char[motTirer.length];
		for (int i = 0; i < randomized.length; i++) {
			randomized[i] = motTirer[i];
		}

		// Mélange des caractères
		for (int i = 0; i < randomized.length * 4; i++) {
			int position1 = r.nextInt(randomized.length);
			int position2 = r.nextInt(randomized.length);
			char saving = randomized[position1];
			randomized[position1] = randomized[position2];
			randomized[position2] = saving;
		}
		return randomized;
	}

//	Retourne: X | Paramètre: char
	private static void afficher(char[] mot) {
		for (int i = 0; i < mot.length; i++) {
			System.out.print(mot[i]);
		}
		System.out.println();
	}

//	Retourne: char | Paramètre: char
	private static boolean bonnesLettres(char[] r, char[] tirage) {
		// clonage du tableau des lettres à utiliser
		char[] copie = new char[tirage.length];
		for (int i = 0; i < copie.length; i++) {
			copie[i] = tirage[i];
		}
		// vérification de chaque lettre de la proposition
		int j = 0;
		boolean ok = true;
		while (ok && j < r.length) {
			int k = 0;
			while (k < copie.length && r[j] != copie[k]) {
				k++;
			}
			if (k == copie.length)
				ok = false;
			else {
				copie[k] = VIDE;
				j++;
			}
		}
		return ok;
	}

//	Retourne: char | Paramètre: char
	private static boolean dansLeDico(char[] r) throws IOException {
		boolean trouve = false;
		try (FileInputStream fichier = new FileInputStream(FICHIER_MOTS); Scanner s = new Scanner(fichier)) {
			char[] motDico;
			while (s.hasNext() && !trouve) {
				motDico = s.nextLine().toUpperCase().toCharArray();
				trouve = exercice1.sontIdentiques(r, motDico);
			}
		}
		return trouve;
	}

	private static boolean sontIdentiques(char[] mot1, char[] mot2) {
		boolean ok = mot1.length == mot2.length;
		if (ok) {
			int i = 0;
			while (ok && i < mot1.length) {
				ok = mot1[i] == mot2[i];
				i++;
			}
		}
		return ok;
	}
}
