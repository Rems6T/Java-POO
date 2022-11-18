package fr.formation.module5.monopoly;

public class Joueur {

	private int solde;

	public Joueur(int solde) {
		this.solde = solde;
	}

	public void debiter(int prix) {
		this.solde = this.solde - prix;
	}

	public void crediter(int salaire) {
		// TODO Auto-generated method stub

	}

}
