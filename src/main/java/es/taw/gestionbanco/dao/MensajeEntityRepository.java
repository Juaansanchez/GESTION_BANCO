package es.taw.gestionbanco.dao;

import es.taw.gestionbanco.entity.MensajeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensajeEntityRepository extends JpaRepository<MensajeEntity, Integer> {
}
