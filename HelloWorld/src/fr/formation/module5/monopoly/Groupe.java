package fr.formation.module5.monopoly;

public class Groupe {
	private Propriete[] proprietes = new Propriete[4];
	private int nbProp = 0;

	void ajouterPropriete(Propriete p) {
		if (this.equals(p.getGroupe())) {
			this.proprietes[this.nbProp] = p;
			this.nbProp++;
		}
	}

	public Propriete[] getProprietes() {
		return this.proprietes.clone();
	}

	public int getNbProprietes() {
		return this.proprietes.length;
	}
}