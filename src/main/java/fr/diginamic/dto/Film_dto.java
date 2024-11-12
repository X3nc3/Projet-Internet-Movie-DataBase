package fr.diginamic.dto;

import org.w3c.dom.Text;

import java.time.LocalDate;

public record Film_dto(

    String id,
    Pays_dto pays,

    String nom,
    String url,
    String plot,
    String langue,
    Lieu_dto lieuTournage,
    Realisateur_dto[] realisateurs,
    Acteur_dto[] castingPrincipal,
    String anneeSortie,
    Role_dto[] roles,
    String[] genres

){}