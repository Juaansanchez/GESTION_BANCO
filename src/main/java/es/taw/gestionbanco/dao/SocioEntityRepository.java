package es.taw.gestionbanco.dao;

import es.taw.gestionbanco.entity.SocioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SocioEntityRepository extends JpaRepository<SocioEntity, Integer> {
}