package fr.formation.module5.monopoly;

public class Case {
	protected String nom;

	public Case(String nom) {
		this.nom = nom;
	}

	public boolean joueurPart(Joueur j) {
		System.out.printf("%s est sur la case %s%n", j, this.nom);
		return true;
	}

	public void joueurPasse(Joueur j) {
	}

	public void joueurArrive(Joueur j) {
		System.out.printf("%s arrive sur la case %s%n", j, this.nom);
	}

	@Override
	public String toString() {
		return this.nom;
	}
}
