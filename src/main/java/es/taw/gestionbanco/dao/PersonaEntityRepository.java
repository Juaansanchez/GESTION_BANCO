package es.taw.gestionbanco.dao;

import es.taw.gestionbanco.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaEntityRepository extends JpaRepository<PersonaEntity, Integer> {
}