/*
Autor:
    -Álvaro Alemán Rando 20%
    -Juan Sánchez García 20%
    -Marcos Fernández Aranda 20%
    -Ángel Joaquín Rodríguez Rodríguez 20%
    -Ignacio Morillas Rosell 20%
 */
package es.taw.gestionbanco.dao;

import es.taw.gestionbanco.entity.ClienteEntity;
import es.taw.gestionbanco.entity.EmpresaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmpresaEntityRepository extends JpaRepository<EmpresaEntity, Integer> {
    @Query("select empresas from EmpresaEntity empresas")
    public List<EmpresaEntity> getEmpresas();

    @Query("select clientes from ClienteEntity clientes where clientes.id = :id")
    public List<ClienteEntity> getClientes(@Param("id") String id);

    @Query("SELECT empresa.id FROM EmpresaEntity empresa")
    List<Integer> buscarIdEmpresas();
}