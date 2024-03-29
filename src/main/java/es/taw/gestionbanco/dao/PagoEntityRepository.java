/*
Autor:
    -Álvaro Alemán Rando 20%
    -Juan Sánchez García 20%
    -Marcos Fernández Aranda 20%
    -Ángel Joaquín Rodríguez Rodríguez 20%
    -Ignacio Morillas Rosell 20%
 */
package es.taw.gestionbanco.dao;

import es.taw.gestionbanco.entity.PagoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PagoEntityRepository extends JpaRepository<PagoEntity, Integer> {
    @Query("select p from PagoEntity p where p.beneficiarioByIdBeneficiario.idBeneficiario = :idCliente")
    List<PagoEntity> buscarPagosPorIdCliente(@Param("idCliente") Integer idCliente);


    @Query("select p from PagoEntity p where p.moneda like CONCAT('%', :texto, '%')")
    List<PagoEntity> filtrarPorMoneda(@Param("texto") String texto);

    @Query("select p from PagoEntity p where p.beneficiarioByIdBeneficiario.nombre like CONCAT('%', :texto, '%')")
    List<PagoEntity> filtrarPorNombre(@Param("texto") String texto);

    @Query("select p from PagoEntity p where p.beneficiarioByIdBeneficiario.apellido like CONCAT('%', :texto, '%')")
    List<PagoEntity> filtrarPorApellido(@Param("texto") String texto);

    @Query("SELECT p FROM PagoEntity p " +
            "JOIN TransaccionEntity t on p.idPago=t.id " +
            "JOIN BeneficiarioEntity b ON p.beneficiarioByIdBeneficiario.idBeneficiario = b.idBeneficiario " +
            "WHERE b.idBeneficiario=:idBeneficiario")
    List<PagoEntity> pagosPorIdBeneficiario(@Param("idBeneficiario") Integer idBeneficiario);

}
