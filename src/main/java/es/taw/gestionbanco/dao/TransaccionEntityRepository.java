package es.taw.gestionbanco.dao;

import es.taw.gestionbanco.entity.TransaccionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaccionEntityRepository extends JpaRepository<TransaccionEntity, Integer> {
}
