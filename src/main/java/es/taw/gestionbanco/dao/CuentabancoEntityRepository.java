package es.taw.gestionbanco.dao;

import es.taw.gestionbanco.entity.CuentabancoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CuentabancoEntityRepository extends JpaRepository<CuentabancoEntity, Integer> {

    @Query("SELECT c.id FROM CuentabancoEntity c")
    List<Integer> buscarIdCuentasBanco();

    @Query("SELECT a FROM CuentabancoEntity a WHERE a.ibanCuenta=:iban")
    CuentabancoEntity encuentraCuentaPorIBAN(@Param("iban") String iban);

    @Modifying
    @Query("UPDATE CuentabancoEntity c SET c.saldo = :saldo WHERE c.ibanCuenta = :cuentaBanco and c.clienteByIdCliente.id=:idCliente")
    void actualizaSaldo(@Param("saldo") Integer saldo, @Param("cuentaBanco") String cuentaBanco, @Param("idCliente") Integer idCliente);
}