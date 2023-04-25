package es.taw.gestionbanco.dao;

import es.taw.gestionbanco.entity.SocioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocioEntityRepository extends JpaRepository<SocioEntity, Integer> {
}