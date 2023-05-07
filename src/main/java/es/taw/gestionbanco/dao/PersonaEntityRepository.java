package es.taw.gestionbanco.dao;

import es.taw.gestionbanco.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PersonaEntityRepository extends JpaRepository<PersonaEntity, Integer> {
    PersonaEntity findByDni(String dni);
}