/*
Autor:
    -Álvaro Alemán Rando 20%
    -Juan Sánchez García 20%
    -Marcos Fernández Aranda 20%
    -Ángel Joaquín Rodríguez Rodríguez 20%
    -Ignacio Morillas Rosell 20%
 */
package es.taw.gestionbanco.dao;

import es.taw.gestionbanco.entity.CuentabancoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CuentabancoEntityRepository extends JpaRepository<CuentabancoEntity, Integer> {

    @Query("SELECT c.id FROM CuentabancoEntity c")
    List<Integer> buscarIdCuentasBanco();

    @Query("SELECT c FROM CuentabancoEntity c WHERE c.ibanCuenta=:iban")
    CuentabancoEntity cuentaPorIBAN(@Param("iban") String iban);

}