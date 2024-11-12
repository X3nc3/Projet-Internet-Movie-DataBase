package fr.diginamic.Utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.diginamic.bo.*;
import fr.diginamic.dto.*;


import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TraducteurJson {

    public static void TraductionJson() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        File filmsJsonfile = new File("src/main/resources/films.json");
        List<Film_dto> filmsExtreJson = objectMapper.readValue(filmsJsonfile, new TypeReference<List<Film_dto>>() {}); // Récupération des données du json

        List<Pays> ListPaysJson = new ArrayList<>();                        // création d'une liste pour stocker tous les pays renseignée dans le json
        for (Film_dto filmDto : filmsExtreJson) {                           // boucle pour récupérer tous les paysDTO du json
            Pays_dto paysDTOExtreJson = filmDto.pays();                     // création d'un paysDTO temporaire pour stocker l'info
            if (paysDTOExtreJson != null) {                                 // vérification si présence de paysDTO
                Pays paysExtreJson = new Pays();                            // création d'un pays pour ajouter des valeurs
                paysExtreJson.setNom(paysDTOExtreJson.nom());               // insertion de la valeur dans le pays
                paysExtreJson.setUrl(paysDTOExtreJson.url());

                boolean paysExiste = false;                                 // code pour verification si présence dans la liste des pays total
                for (Pays pays : ListPaysJson) {
                    if (pays.getNom() != null && pays.getNom().equals(paysExtreJson.getNom())) {
                        paysExiste = true;
                        break;
                    }
                }

                if (!paysExiste) {                                          // s'il n'existe PAS dans la liste
                    ListPaysJson.add(paysExtreJson);                        // ajout dans la liste total si le pays n'y est pas
                }
            }
        }

        List<Genre> ListGenreJson = new ArrayList<>();                      // creation d'une liste pour stocker tous les genres renseignée dans le json
        for (Film_dto filmDto : filmsExtreJson) {                           // boucle pour récupérer tous genres dans les FilmDTO du json // Obtenir la liste des genres pour chaque film

            String[] genresFilm = filmDto.genres();                         // création d'une liste pour stocker les genres du film sélectionné

            for (String nomGenre : genresFilm) {                            // boucle pour récupérer 1 genre par 1 genre
                Genre genreExtreJson = new Genre(nomGenre);                 // Crée un nouvel objet Genre avec le nom du genre

                boolean genreExiste = false;
                int k = 0;
                while (k < ListGenreJson.size()) {                          // code pour vérification si présence dans la liste des genres total
                    Genre genre = ListGenreJson.get(k);

                    if (genre.getNom() != null && genre.getNom().equals(nomGenre)) {
                        genreExiste = true;
                        break;
                    }
                    k++;
                }

                if (!genreExiste) {
                    ListGenreJson.add(genreExtreJson);
                }
            }
        }





    // ** Extraction des lieux **
        List<Lieu> ListLieuxJson = new ArrayList<>();
        for (Film_dto filmDto : filmsExtreJson) {
            Lieu_dto lieuDto = filmDto.lieuTournage();
            if (lieuDto != null) {
                Lieu lieu = new Lieu();
                lieu.setVille(lieuDto.ville());
                lieu.setEtatDept(lieuDto.etatDept());
                // Associer le pays si défini
                if (lieuDto.pays() != null) {
                    Pays pays = ListPaysJson.stream()
                            .filter(p -> p.getNom().equals(lieuDto.pays()))
                            .findFirst()
                            .orElse(null);
                    // Créer le pays s'il n'existe pas
                    if (pays == null) {
                        pays = new Pays();
                        pays.setNom(lieuDto.pays());
                        ListPaysJson.add(pays);
                    }
                    lieu.setPays(pays);
                }
                // Éviter les doublons pour les lieux
                boolean lieuExiste = ListLieuxJson.stream()
                        .anyMatch(l -> l.getVille().equals(lieu.getVille()) && l.getEtatDept().equals(lieu.getEtatDept()));

                if (!lieuExiste) {
                    ListLieuxJson.add(lieu);
                }
            }
        }

        List<Realisateur> ListeRealisteurJson = new ArrayList<>();          // creation d'une liste pour stocker tous les réalisateurs renseignée dans le json
        for(Film_dto filmDto : filmsExtreJson){                             // boucle pour récupérer tous les réalisateurs dans FilmDTO du json

            Realisateur_dto[] RealisateurFilm = filmDto.realisateurs();     // création d'une liste pour stocker les réalisateurs du film sélectionné

            for (Realisateur_dto realisateurDto : RealisateurFilm) {        // boucle pour récupérer 1 par 1 les réalisateurs
                Realisateur RealisateurExtreJson = new Realisateur();       // creation d'un objet réalisateur
                RealisateurExtreJson.setUrl(realisateurDto.url());          // ajout des différents paramètres
                RealisateurExtreJson.setIdentite(realisateurDto.identite());
                boolean realisateurExiste = false;
                for (Realisateur realisateur : ListeRealisteurJson) {       // vérification de la présence des réalisateurs dans la liste totaux
                    if (realisateur.getIdentite().equals(realisateurDto.identite())) {
                        realisateurExiste = true;
                        break;
                    }
                }
                if (!realisateurExiste) {
                    ListeRealisteurJson.add(RealisateurExtreJson);          // ajout s'il n'est pas déjà présent dans la liste
                }
            }

        }









        List<Acteur> ListeActeurJson = new ArrayList<>();                   // creation d'une liste pour stocker tous les acteurs renseignée dans le json
        for (Film_dto filmDto : filmsExtreJson){                            // boucle pour récupérer tous les acteurs dans FilmDTO du json
            Acteur_dto[] CastingFilm = filmDto.castingPrincipal();          // création d'une liste pour stoker tous les acteurs du film sélectionné par le casting

            if (CastingFilm != null) {                                      // vérifie si le casting est vide
                for (Acteur_dto acteurDto : CastingFilm) {                  // on parcourt le casting pour trouver des acteurs
                    Acteur ActeurExtreJson = new Acteur();                  // ajout d'un nouvel acteur
                    ActeurExtreJson.setUrl(acteurDto.url());                // ajout des différents paramètres
                    if(acteurDto.height() == null){                         // vérifie si une taille est rentré
                        ActeurExtreJson.setTaille(0);                       // met à 0 si ce n'est pas le cas
                    }else{
                        ActeurExtreJson.setTaille(Double.parseDouble(acteurDto.height()));
                    }
                    ActeurExtreJson.setIdentite(acteurDto.identite());
                    ActeurExtreJson.setDateNaissance(acteurDto.naissance().dateNaissance());

                    if (acteurDto.naissance().dateNaissance() != null) {    // vérifie si une date de naissance est rentré
                        ActeurExtreJson.setDateNaissance(null);
                    }else{
                        ActeurExtreJson.setDateNaissance(acteurDto.naissance().dateNaissance());
                    }

                    Lieu lieuNaissanceActeur = new Lieu(acteurDto.naissance().lieuNaissance(), null);

                    ActeurExtreJson.setLieuNaissance(lieuNaissanceActeur);

                    boolean acteurExiste = false;
                    for (Acteur acteur : ListeActeurJson) {                 // vérifie si l'acteur n'est pas déjà rentré dans la liste
                        if (acteur.getIdentite().equals(acteurDto.identite())) {
                            acteurExiste = true;
                            break;
                        }
                    }
                    if (!acteurExiste) {
                        ListeActeurJson.add(ActeurExtreJson);               // l'ajout à la liste et l'ajout aussi a la liste des acteurs qui sont née au même endroit que lui
                        lieuNaissanceActeur.getActeurs().add(ActeurExtreJson);
                    }
                }
            }

            Role_dto[] RolesFilm = filmDto.roles();                         // la même chose que pour acteur dans le casting principal, mais pour role
            if (RolesFilm != null) {
                for (Role_dto roleDto : RolesFilm) {
                    Acteur ActeurExtreJson = new Acteur();
                    ActeurExtreJson.setUrl(roleDto.acteur().url());

                    if(roleDto.acteur().height() == null){
                        ActeurExtreJson.setTaille(0);
                    }else{
                        ActeurExtreJson.setTaille(Double.parseDouble(roleDto.acteur().height()));
                    }
                    ActeurExtreJson.setIdentite(roleDto.acteur().identite());

                    Lieu lieuNaissanceActeur = new Lieu();
                    // Vérifie d'abord que naissance() n'est pas null avant de récupérer dateNaissance() et lieuNaissance()
                    if (roleDto.acteur().naissance() != null) {
                        ActeurExtreJson.setDateNaissance(roleDto.acteur().naissance().dateNaissance());
                        lieuNaissanceActeur = new Lieu(roleDto.acteur().naissance().lieuNaissance(), null);
                        ActeurExtreJson.setLieuNaissance(lieuNaissanceActeur);
                    } else {
                        ActeurExtreJson.setDateNaissance(null); // Définit dateNaissance à null si l'information n'est pas disponible
                        ActeurExtreJson.setLieuNaissance(null); // Définit lieuNaissance à null si l'information n'est pas disponible
                    }


                    boolean acteurExiste = false;
                    for (Acteur acteur : ListeActeurJson){
                        if (acteur.getIdentite().equals(roleDto.acteur().identite())){
                            acteurExiste = true;
                            break;
                        }
                    }

                    if(!acteurExiste){
                        ListeActeurJson.add(ActeurExtreJson);
                        if (roleDto.acteur().naissance() != null) {
                            lieuNaissanceActeur.getActeurs().add(ActeurExtreJson);
                        }
                    }


                }
            }
        }









//        System.out.println(Arrays.toString(ListPaysJson.toArray()));      // affichage de tous les pays
//        System.out.println(Arrays.toString(ListGenreJson.toArray()));     // affichage de tous les genres


//        Film[] ListFilms = null;
//
//        for (int i =0;i < ( films.size() -1); i++){
//            Film filmTemp = new Film();
//            filmTemp.setId(films.get(i).id());
//            filmTemp.set
//        }
    }
}
