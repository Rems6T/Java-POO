package fr.formation.associationsBidirectionnelles;

public class AssociationsBidirectionnelles {

	public static void main(String[] args) {

	}

	public class Propriete {
		private int prixAchat;
		private Joueur proprio;
		private Groupe groupe;
		private int txComplGroupe;
		private boolean hypothequee;

		public Propriete(int prixAchat, Groupe groupe) {
			this.groupe = groupe;
			groupe.ajouterPropriete(this);
			this.prixAchat = prixAchat;
			this.txComplGroupe = 0;
			this.hypothequee = false;
		}

		public Groupe getGroupe() {
			return groupe;
		}
	}

	public class Joueur {
		private int argent;
		private String nom;
	}

	public class Groupe {
		private Propriete[] proprietes = new Propriete[4];
		private int nbProp = 0;


		public Propriete[] getProprietes() {
			return this.proprietes.clone();
		}

		public void ajouterPropriete(Propriete propriete) {
			// TODO Auto-generated method stub
			
		}

		public int getNbProprietes() {
			return this.proprietes.length;
		}

	}
}
