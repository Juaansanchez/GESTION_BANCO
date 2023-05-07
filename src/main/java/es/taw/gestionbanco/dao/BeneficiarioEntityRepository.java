package es.taw.gestionbanco.dao;

import es.taw.gestionbanco.entity.BeneficiarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BeneficiarioEntityRepository extends JpaRepository<BeneficiarioEntity, Integer> {
    @Query("SELECT b.idBeneficiario,b.nombre, b.apellido, b.pais, b.moneda, b.ibanCuenta, b.numeroCuenta, b.swift," +
            "b.paisCuenta, b.fechaNacimiento, b.clienteByIdCliente FROM BeneficiarioEntity b WHERE b.ibanCuenta=:iban")
    BeneficiarioEntity findByIBAN(String iban);
}
