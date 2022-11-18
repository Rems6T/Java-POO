package fr.formation.module5.monopoly;

public class Depart extends Case {
	private static final int SALAIRE = 200;

	public Depart(String nom) {
		super("Départ");
	}

	@Override
	public void joueurPasse(Joueur j) {
		payerSalaire(j);
	}

	public void JoueurArrive(Joueur j) {
		super.joueurArrive(j);
		payerSalaire(j);
	}

	public void payerSalaire(Joueur j) {
		System.out.printf("%s touche %d€%n", j, SALAIRE);
		j.crediter(SALAIRE);
	}
}
