package fr.formation.exercice3;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class QuelMedecin2 {

	public class Patient {
		private String nom;
		private String prenom;
		private String numeroDeTelephone;
		private char sexe;
		private long numSecu;
		private LocalDate dateNaissance;
		private String commentaires;
		private Adresse adresse;

		public Patient(String nom, String prenom, String numeroDeTelephone, char sexe, long numSecu,
				LocalDate dateNaissance, String commentaires, Adresse adresse) {
			this.nom = nom.toUpperCase();
			this.prenom = prenom;
			this.numeroDeTelephone = numeroDeTelephone;
			this.sexe = sexe;
			this.numSecu = numSecu;
			this.dateNaissance = dateNaissance;
			this.commentaires = commentaires;
			this.adresse = adresse;
		}

		public void afficher() {
			System.out.printf(
					"%s %s%nTéléphone : %s%nSexe : %s%n" + "Numéro de Sécurité sociale : %d%nDate de "
							+ "naissance : %s%nCommentaires : %s%nAdresse :%n",
					this.nom, this.prenom, this.numeroDeTelephone, this.sexe == 'F' ? "Féminin" : "Masculin",
					this.numSecu, this.dateNaissance.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)),
					this.commentaires != null ? this.commentaires : "[aucun commentaire]");
			this.adresse.afficher();
		}

	}

	public class Adresse {
		private String mentionsCompl;
		private int numero;
		private String complNumero;
		private String rue;
		private int cp;
		private String ville;

		public Adresse(String mentionsCompl, int numero, String complNumero, String rue, int cp, String ville) {
			this.mentionsCompl = mentionsCompl;
			this.numero = numero;
			this.complNumero = complNumero;
			this.rue = rue;
			this.cp = cp;
			this.ville = ville.toUpperCase();
		}

		public Adresse(int numero, String complNumero, String rue, int cp, String ville) {
			this(null, numero, complNumero, rue, cp, ville);
		}

		public void afficher() {
			if (this.mentionsCompl != null)
				System.out.println(mentionsCompl);
			System.out.printf("%d%s %s%n%05d %s%n", this.numero, this.complNumero != null ? this.complNumero : "",
					this.rue, this.cp, this.ville);
		}
	}

	public class MedecinGeneraliste {
		public static final int MAX_CRENEAUX = 15;
		private String nom;
		private String prenom;
		private String numeroDeTelephone;
		private static int tarif = 25;
		private Adresse adresse;
		private Creneau[] creneaux = new Creneau[MAX_CRENEAUX];

		public MedecinGeneraliste(String nom, String prenom, String numeroDeTelephone, Adresse adresse) {
			this.nom = nom.toUpperCase();
			this.prenom = prenom;
			this.numeroDeTelephone = numeroDeTelephone;
			this.adresse = adresse;
		}

		public void afficher() {
			System.out.printf("%s %s%nTéléphone : %s%nTarif : %d€%nAdresse :%n", this.nom, this.prenom,
					this.numeroDeTelephone, MedecinGeneraliste.tarif);
			this.adresse.afficher();
			System.out.println("Créneaux :");
			for (int i = 0; i < this.creneaux.length; i++)
				if (this.creneaux[i] != null)
					this.creneaux[i].afficher();
		}

		void ajouterCreneau(Creneau creneauAAjouter) {
			if (this != creneauAAjouter.getMedecin()) {
				System.err.println(
						"Ce créneau ne peut être associé à ce médecin " + "car il est déjà associé à un autre");
			} else {
				int pos = 0;
				while (pos < this.creneaux.length && this.creneaux[pos] != null)
					pos++;
				if (pos == this.creneaux.length)
					System.err.println("Trop de créneaux sont affectés à ce médecin");
				else
					this.creneaux[pos] = creneauAAjouter;
			}
		}

		public Object getNom() {
			return this.nom;
		}
	}

	public class Creneau {
		private LocalTime heureDebut;
		private int duree;
		private MedecinGeneraliste medecin;

		public Creneau(LocalTime heureDebut, int duree, MedecinGeneraliste medecin) {
			this.heureDebut = heureDebut;
			this.duree = duree;
			this.medecin = medecin;
			medecin.ajouterCreneau(this);
		}

		public MedecinGeneraliste getMedecin() {
			return medecin;
		}

		public void afficher() {
			System.out.printf("%s - %s (%d minutes)%n",
					this.heureDebut.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)), this.heureDebut
							.plusMinutes(this.duree).format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)),
					this.duree);
		}

	}

	public class RendezVous {
		private Creneau creneau;
		private Patient patient;
		private LocalDate date;

		public RendezVous(Creneau creneau, Patient patient, LocalDate date) {
			this.creneau = creneau;
			this.patient = patient;
			this.date = date;
		}

		public void afficher() {
			System.out.printf("Rendez-vous du %s ",
					this.date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
			this.creneau.afficher();
			System.out.printf("avec le Dr %s%npour ", this.creneau.getMedecin().getNom());
			this.patient.afficher();
		}

	}

}
