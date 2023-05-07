package es.taw.gestionbanco.dao;

import es.taw.gestionbanco.entity.EmpresaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmpresaEntityRepository extends JpaRepository<EmpresaEntity, Integer> {

    @Query("SELECT empresa.id FROM EmpresaEntity empresa")
    List<Integer> buscarIdEmpresas();
}