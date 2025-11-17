package ma.emsi.fetheddine.repository;

import ma.emsi.fetheddine.entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {}
