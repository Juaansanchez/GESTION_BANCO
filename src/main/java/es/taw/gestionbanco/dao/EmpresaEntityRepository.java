package es.taw.gestionbanco.dao;

import es.taw.gestionbanco.entity.EmpresaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaEntityRepository extends JpaRepository<EmpresaEntity, Integer> {
}