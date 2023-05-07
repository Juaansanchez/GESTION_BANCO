/*
Autor:
    -Álvaro Alemán Rando 20%
    -Juan Sánchez García 20%
    -Marcos Fernández Aranda 20%
    -Ángel Joaquín Rodríguez Rodríguez 20%
    -Ignacio Morillas Rosell 20%
 */
package es.taw.gestionbanco.dao;

import es.taw.gestionbanco.entity.TipoestadoautorizadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TipoestadoautorizadoEntityRepository extends JpaRepository<TipoestadoautorizadoEntity, Integer> {

    @Query("SELECT estado.id FROM TipoestadoautorizadoEntity estado")
    List<Integer> buscarIdTipoEstadoAutorizado();
}