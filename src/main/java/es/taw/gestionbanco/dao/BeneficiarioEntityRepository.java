package es.taw.gestionbanco.dao;

import es.taw.gestionbanco.entity.AutorizadoEntity;
import es.taw.gestionbanco.entity.BeneficiarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BeneficiarioEntityRepository extends JpaRepository<BeneficiarioEntity, Integer> {

}