package es.taw.gestionbanco.dao;

import es.taw.gestionbanco.entity.AutorizadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AutorizadoEntityRepository extends JpaRepository<AutorizadoEntity, Integer> {

    @Query("select a from AutorizadoEntity a where a.empresaByIdEmpresa.id = :idEmpresa")
    public List<AutorizadoEntity> buscarSociosPorIdEmpresa(@Param("idEmpresa") Integer idEmpresa);
}