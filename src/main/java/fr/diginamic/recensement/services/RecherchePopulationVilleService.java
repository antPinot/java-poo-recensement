package fr.diginamic.recensement.services;

import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.math.NumberUtils;

import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;
import fr.diginamic.recensement.exceptions.RecensementException;

/**
 * Recherche et affichage de la population d'une ville
 * 
 * @author DIGINAMIC
 *
 */
public class RecherchePopulationVilleService extends MenuService {

	@Override
	public void traiter(Recensement rec, Scanner scanner) throws RecensementException{

		System.out.println("Quel est le nom de la ville recherchée ? ");
		String choix = scanner.nextLine();
		if (NumberUtils.isDigits(choix)) {
			throw new RecensementException("Votre saisie n'est pas au bon format et contient des chiffres");
		}

		boolean isFind = false;
		List<Ville> villes = rec.getVilles();
		for (Ville ville : villes) {
			if (ville.getNom().equalsIgnoreCase(choix)
					|| ville.getNom().toLowerCase().startsWith(choix.toLowerCase())) {
				System.out.println(ville);
			}
		}
		
		if (!isFind) {
			throw new RecensementException(
					"Nous n'avons pas trouvé votre ville. Veuillez SVP saisir une ville ou un format valide.");
		}
	}

}
