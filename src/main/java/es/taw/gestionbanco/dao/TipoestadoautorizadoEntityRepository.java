package es.taw.gestionbanco.dao;

import es.taw.gestionbanco.entity.TipoestadoautorizadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TipoestadoautorizadoEntityRepository extends JpaRepository<TipoestadoautorizadoEntity, Integer> {

    @Query("SELECT estado.id FROM TipoestadoautorizadoEntity estado")
    public List<Integer> buscarIdTipoEstadoAutorizado();
}