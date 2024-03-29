/*
Autor:
    -Álvaro Alemán Rando 20%
    -Juan Sánchez García 20%
    -Marcos Fernández Aranda 20%
    -Ángel Joaquín Rodríguez Rodríguez 20%
    -Ignacio Morillas Rosell 20%
 */
package es.taw.gestionbanco.dao;

import es.taw.gestionbanco.entity.AutorizadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AutorizadoEntityRepository extends JpaRepository<AutorizadoEntity, Integer> {

    @Query("select a from AutorizadoEntity a where a.empresaByIdEmpresa.id = :idEmpresa")
    List<AutorizadoEntity> buscarSociosPorIdEmpresa(@Param("idEmpresa") Integer idEmpresa);

    @Query("select a from AutorizadoEntity a where a.dni like CONCAT('%', :texto, '%')")
    List<AutorizadoEntity> filtrarPorDNI(@Param("texto") String texto);

    @Query("select a from AutorizadoEntity a where a.tipoestadoautorizadoByEstadoAutorizado.estadoAutorizado like CONCAT('%', :estado, '%')")
    List<AutorizadoEntity> filtrarPorEstado(@Param("estado") String estado);

    @Query("select a from AutorizadoEntity a where a.empresaByIdEmpresa.nombre like CONCAT('%', :nombreEmpresa, '%')")
    List<AutorizadoEntity> filtrarPorNombreEmpresa(@Param("nombreEmpresa") String nombreEmpresa);


}