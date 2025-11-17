package ma.emsi.fetheddine;

import ma.emsi.fetheddine.entity.Centre;
import ma.emsi.fetheddine.entity.Etudiant;
import ma.emsi.fetheddine.enumtype.Genre;
import ma.emsi.fetheddine.repository.CentreRepository;
import ma.emsi.fetheddine.repository.EtudiantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Tp5GraphqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(Tp5GraphqlApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(EtudiantRepository etudiantRepository, CentreRepository centreRepository){
        return args -> {

            // Création de centres
            Centre c1 = centreRepository.save(
                    Centre.builder().nom("Maarif").adresse("Biranzarane").build()
            );
            Centre c2 = centreRepository.save(
                    Centre.builder().nom("Les Orangers").adresse("Hay Hassani").build()
            );

            // Création d'étudiants liés à des centres
            etudiantRepository.save(
                    Etudiant.builder().nom("Fetheddine").prenom("Aya").genre(Genre.Femme).centre(c1).build()
            );
            etudiantRepository.save(
                    Etudiant.builder().nom("Adnani").prenom("Sahar").genre(Genre.Femme).centre(c2).build()
            );
        };
    }
}
