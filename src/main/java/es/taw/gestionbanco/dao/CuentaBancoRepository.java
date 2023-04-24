package es.taw.gestionbanco.dao;

import es.taw.gestionbanco.entity.CuentabancoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CuentaBancoRepository extends JpaRepository<CuentabancoEntity, Integer> {
    @Query("SELECT cb.fechaApertura, cb.moneda, cb.ibanCuenta, cb.swift, cb.pais, cb.entidadbancariaByEntidadBancaria, cb.tipoestadocuentaByEstadoCuenta " +
            "FROM CuentabancoEntity cb JOIN ClienteEntity cl ON cb.clienteByIdCliente.id=cl.id WHERE cb.clienteByIdCliente.id = :idCliente")
    CuentabancoEntity parametrosCliente(@Param("idCliente") int idCliente ) ;
}
