package Exercice1;

public class LesLecons {

//	Déclaration d'une constante
	public static final double TVA = 20.0/100;
	
	public static void main(String[] args) {
//		Déclaration d'une variable
		double prixHT = 17.85;
		
//		Déclaration d'un tableau de taille 100
		float[] valeurs = new float[100];
//		Ecriture dans la 7eme case du tableau
		valeurs[7] = 1792;
//		Lecture d'une valeur du tableau
		System.out.println(valeurs[7]);
		
		System.out.printf("Prix TTC de l'article : %.2f€%n", prixHT*(1+TVA));
		
		
	}

}
