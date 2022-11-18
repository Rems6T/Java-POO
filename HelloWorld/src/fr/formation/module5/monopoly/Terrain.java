package fr.formation.module5.monopoly;

public class Terrain extends Propriete {

	public Terrain(String nom, int prixAchat, Groupe groupe, int coutConstruction) {
		super(nom, prixAchat, groupe);
		this.coutConstruction = coutConstruction;

		Propriete[] proprietes = groupe.getProprietes();
		Propriete pr = proprietes[0];

		if (pr instanceof Terrain && this.equals(pr.getProprio()) && pr.getTxComplGroupe() == 100) {
			int nbConstructions = 0;
			for (Propriete p : proprietes) {
				Terrain t = (Terrain) p;
				nbConstructions += t.getNiveauConstruction();
			}
		}
	}

	private int loyer;
	private int coutConstruction;
	private int niveauConstruction;
	private int nbMaisonsDispo;
	private int nbHotelsDispo;

	protected void payerLoyer(Joueur j, Joueur proprio) {
		j.debiter(loyer);
		proprio.crediter(loyer);
		System.out.printf("%s s'est arrêté sur la propriété de %s et lui paye %s€%n", j, proprio, loyer);
	}

	public int getCoutConstruction() {

		return this.coutConstruction;
	}

	public int getNiveauConstruction() {

		return this.niveauConstruction;
	}

	public int getNbMaisonsDispo() {

		return this.nbMaisonsDispo;
	}

	public int getNbHotelsDispo() {

		return this.nbHotelsDispo;
	}

	public void construire() {

	}
}
