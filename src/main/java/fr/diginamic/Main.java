package fr.diginamic;

import fr.diginamic.Utils.*;
import fr.diginamic.dal.PersistenceManager;

import java.io.IOException;
import java.util.Scanner;

import static fr.diginamic.Utils.TraducteurJson.TraductionJson;


public class Main {
    public static void main(String[] args) throws IOException {

        TraductionJson();

        //Scanner pour demander à l'utilisateur de choisir une option
        Scanner scanner = new Scanner(System.in);
        boolean continuer = true;

        //Boucle While pour afficher les options du menu
        while (continuer) {
            menu();
            int choix = scanner.nextInt();
            switch (choix) {
                case 1 :
                    RechercheFilmActeur rechercheFilms = new RechercheFilmActeur();
                    rechercheFilms.rechercheFilmActeur(scanner);
                    break;
                case 2 :
                    RechercheCastingFilm rechercheCasting = new RechercheCastingFilm();
                    rechercheCasting.rechercheCastingFilm(scanner);
                    break;
                case 3 :
                    RechercheFilmAnnees rechercheFilmsAnnees = new RechercheFilmAnnees();
                    rechercheFilmsAnnees.rechercheFilmAnnees(scanner);
                    break;
                case 4 :
                    RechercheFilmActeurs rechercheFilmActeurs = new RechercheFilmActeurs();
                    rechercheFilmActeurs.rechercheFilmActeurs(scanner);
                    break;
                case 5 :
                    RechercheActeurFilms rechercheActeurFilms = new RechercheActeurFilms();
                    rechercheActeurFilms.rechercheActeurFilms(scanner);
                    break;
                case 6 :
                    RechercheFilmAnneeActeur rechercheFilmAnnee = new RechercheFilmAnneeActeur();
                    rechercheFilmAnnee.rechercheFilmAnneeActeur(scanner);
                    break;
                case 7 :
                    continuer = false;
                    System.out.println("Fin du programme !");
                    break;
                default :
                    //Affichage dans la console d'un message si mauvais choix
                    System.out.println("Vous n'avez pas choisis une des options possible !");
                    break;
            }
        }
    }

    /**
     * Affichage du menu
     */
    public static void menu() {
        System.out.println("Menu :\n1. Affichage de la filmographie d'un acteur donné.\n2. Affichage du casting d'un film donné.\n3. Affichage des films sortis entre 2 années données.\n4. Affichage des films communs à 2 acteur/actrices donnés.\n5. Affichage des acteurs communs à 2 films donnés.\n6. Affichage des films sortis entre 2 années données et qui ont un acteur/actrice donné au casting.\n7. Fin de l'application");
    }
}