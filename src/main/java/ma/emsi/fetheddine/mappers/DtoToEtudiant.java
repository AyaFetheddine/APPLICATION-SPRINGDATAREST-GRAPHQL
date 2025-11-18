package ma.emsi.fetheddine.mappers;

import ma.emsi.fetheddine.dto.EtudiantDTO;
import ma.emsi.fetheddine.entity.Centre;
import ma.emsi.fetheddine.entity.Etudiant;
import ma.emsi.fetheddine.repository.CentreRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DtoToEtudiant {
    @Autowired
    CentreRepository centreRepository;

    public void toEtudiant(Etudiant et, EtudiantDTO dto) {
        Centre centre = centreRepository.findById(dto.centreId()).orElse(null);
        if (dto != null) {
            BeanUtils.copyProperties(dto, et);
            et.setCentre(centre);
        }
    }
}