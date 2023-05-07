// Autor: Ángel Joaquín Rodríguez Rodríguez

package es.taw.gestionbanco.dao;

import es.taw.gestionbanco.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteEntityRepository extends JpaRepository<ClienteEntity, Integer> {

    @Query("SELECT e.id FROM ClienteEntity e")
    List<Integer> buscarIdClientes();
}
