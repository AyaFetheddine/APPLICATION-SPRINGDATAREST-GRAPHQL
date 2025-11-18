package ma.emsi.fetheddine.web;

import ma.emsi.fetheddine.dto.EtudiantDTO;
import ma.emsi.fetheddine.entity.Centre;
import ma.emsi.fetheddine.entity.Etudiant;
import ma.emsi.fetheddine.service.CentreService;
import ma.emsi.fetheddine.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.util.List;

@Controller
public class EtudiantGraphQLController {

    @Autowired
    EtudiantService etudiantService;
    @Autowired
    CentreService centreService;

    // --- Queries ---

    @QueryMapping
    public List<Centre> getAllCentres() { // Renommé de 'centres'
        return centreService.getCentres();
    }

    @QueryMapping
    public List<Etudiant> getAllEtudiants() { // Renommé de 'listEtudiants'
        return etudiantService.getStudents();
    }

    @QueryMapping
    public Centre getCentreById(@Argument Long id) { // Nouveau
        return centreService.getCentre(id);
    }

    @QueryMapping
    public Etudiant getEtudiantById(@Argument Long id) { // Nouveau
        return etudiantService.getEtudiant(id);
    }

    // --- Mutations ---

    @MutationMapping
    public Etudiant addEtudiant(@Argument EtudiantDTO etudiantDTO) { // Argument renommé
        return etudiantService.addEtudiant(etudiantDTO);
    }

    @MutationMapping
    public String deleteEtudiant(@Argument Long id) { // Nouveau
        return etudiantService.deleteEtudiant(id);
    }

    @MutationMapping
    public Etudiant updateEtudiant(@Argument Long id, @Argument EtudiantDTO etudiantDTO) { // Nouveau
        return etudiantService.updateEtudiant(id, etudiantDTO);
    }

    // --- Subscriptions ---

    @SubscriptionMapping
    public Flux<Etudiant> etudiantAdded() { // Nouveau
        return etudiantService.getEtudiantAdded();
    }

    @SubscriptionMapping
    public Flux<String> etudiantRemoved() { // Nouveau
        return etudiantService.etudiantMoved();
    }
}