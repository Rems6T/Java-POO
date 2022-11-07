package Exercice1;

// On importe une classe de Java qui permet de lire les saisies de l'utilisateur
import java.util.Scanner;

public class LesLecons {

//	Déclaration d'une constante
	public static final double TVA = 20.0/100;
	
	public static void main(String[] args) {
//		Déclaration d'une variable
		double prixHT = 17.85;
		System.out.printf("Prix TTC de l'article : %.2f€%n", prixHT*(1+TVA));
		
		
		
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
		
//		if (simple)
		if(prenom.length() == 0) System.err.println("Le prénom est obligatoire !");
		
//		if (double)
		if(prenom.length() == 0) System.err.println("Le prénom est obligatoire !");
		else System.out.printf("Bonjour %s ! %n", prenom);
		
//		Si on veut rester sur un simple mais ne pas afficher d'erreur, on peut faire ceci
		if(!(prenom.length() == 0)) System.out.printf("Bonjour %s ! %n", prenom);
//		OU
		if(prenom.length() != 0) System.out.printf("Bonjour %s ! %n", prenom);
		
//		If avec plusieurs conditions, on doit mettre des accolades
		if(prenom.length() == 0) {
			System.err.println("Le prénom est obligatoire !");
			System.exit(1);
		}
		
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
		default:
			System.out.println("Poubelle");
			break;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
