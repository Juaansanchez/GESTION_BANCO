package es.taw.gestionbanco.dao;

import es.taw.gestionbanco.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonaEntityRepository extends JpaRepository<PersonaEntity, Integer> {

    @Query("SELECT p.id FROM PersonaEntity p")
    List<Integer> buscarIdPersonas();
}