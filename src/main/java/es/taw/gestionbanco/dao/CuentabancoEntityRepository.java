package es.taw.gestionbanco.dao;

import es.taw.gestionbanco.entity.CuentabancoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CuentabancoEntityRepository extends JpaRepository<CuentabancoEntity, Integer> {

    @Query("SELECT c.id FROM CuentabancoEntity c")
    public List<Integer> buscarIdCuentasBanco();
}