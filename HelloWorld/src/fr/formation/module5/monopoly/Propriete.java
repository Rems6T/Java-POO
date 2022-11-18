package fr.formation.module5.monopoly;

public class Propriete extends Case {

	@SuppressWarnings("unused")
	private int prixAchat;
	@SuppressWarnings("unused")
	private Joueur proprio;
	private Groupe groupe;
	protected int txComplGroupe;
	public int getTxComplGroupe() {
		return txComplGroupe;
	}

	public void setTxComplGroupe(int txComplGroupe) {
		this.txComplGroupe = txComplGroupe;
	}

	@SuppressWarnings("unused")
	private boolean hypothequee;

	public Propriete(String nom, int prixAchat, Groupe groupe) {
		super(nom);
		this.prixAchat = prixAchat;
		this.groupe = groupe;
	}

	public void joueurArrive(Joueur j) {

	}

	@SuppressWarnings("unused")
	private void calculerCompletionGroupe(Joueur j) {

	}

	public Groupe getGroupe() {

		return null;
	}

	public int getCompletionGroupe() {
		return 0;
	}

	public Joueur getProprio() {
		return null;
	}

	public void setProprio(Joueur j) {
		this.proprio = j;
	}

	public boolean isHypothequee() {

		return false;
	}

	@Override
	public String toString() {
		return String.format("%s (%s)", super.toString(), this.groupe);
	}

	public int getValeur() {
		return 0;
	}
}