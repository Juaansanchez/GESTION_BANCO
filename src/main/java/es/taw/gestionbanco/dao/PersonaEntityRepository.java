package es.taw.gestionbanco.dao;

import es.taw.gestionbanco.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;

public interface PersonaEntityRepository extends JpaRepository<PersonaEntity, Integer> {

}