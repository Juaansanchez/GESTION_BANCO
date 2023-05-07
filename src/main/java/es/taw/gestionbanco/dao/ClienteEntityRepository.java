package es.taw.gestionbanco.dao;

import es.taw.gestionbanco.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteEntityRepository extends JpaRepository<ClienteEntity, Integer> {

}
