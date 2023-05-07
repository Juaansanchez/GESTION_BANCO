package es.taw.gestionbanco.dao;

import es.taw.gestionbanco.entity.BeneficiarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BeneficiarioEntityRepository extends JpaRepository<BeneficiarioEntity, Integer> {
    @Query("SELECT b.idBeneficiario,b.nombre, b.apellido, b.pais, b.moneda, b.ibanCuenta, b.numeroCuenta, b.swift," +
            "b.paisCuenta, b.fechaNacimiento, b.clienteByIdCliente FROM BeneficiarioEntity b WHERE b.clienteByIdCliente.id=:idCliente")
    BeneficiarioEntity findByIdCliente(@Param("idCliente") Integer idCliente);
}