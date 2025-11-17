package ma.emsi.fetheddine.dto;

import ma.emsi.fetheddine.enumtype.Genre;

public record EtudiantDTO(
        String nom,
        String prenom,
        Genre genre,
        Long centreId
) {}
