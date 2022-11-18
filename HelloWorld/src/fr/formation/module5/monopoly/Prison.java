package fr.formation.module5.monopoly;

import java.util.Map;

public class Prison extends Case {
	Map<Joueur, Integer> nbTentatives;

	public Prison(String nom) {
		super(nom);
	}

//	Déjà existant dans "Case"
	
//	public boolean joueurPart(Joueur j) {
//		return false;
//	}
}
