package es.taw.gestionbanco.dao;

import es.taw.gestionbanco.entity.AutorizadoEntity;
import es.taw.gestionbanco.entity.BeneficiarioEntity;
import es.taw.gestionbanco.entity.PagoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PagoEntityRepository extends JpaRepository<PagoEntity, Integer> {
    @Query("select p from PagoEntity p where p.beneficiarioByIdBeneficiario.idBeneficiario = :idCliente")
    public List<PagoEntity> buscarPagosPorIdCliente(@Param("idCliente") Integer idCliente);


    @Query("select p from PagoEntity p where p.moneda like CONCAT('%', :texto, '%')")
    public List<PagoEntity> filtrarPorMoneda(@Param("texto") String texto);

    @Query("select p from PagoEntity p where p.beneficiarioByIdBeneficiario.nombre like CONCAT('%', :texto, '%')")
    public List<PagoEntity> filtrarPorNombre(@Param("texto") String texto);

    @Query("select p from PagoEntity p where p.beneficiarioByIdBeneficiario.apellido like CONCAT('%', :texto, '%')")
    public List<PagoEntity> filtrarPorApellido(@Param("texto") String texto);

    @Query("SELECT p FROM PagoEntity p " +
            "JOIN TransaccionEntity t on p.idPago=t.id " +
            "JOIN BeneficiarioEntity b ON p.beneficiarioByIdBeneficiario.idBeneficiario = b.idBeneficiario " +
            "WHERE b.idBeneficiario=:idBeneficiario")
    List<PagoEntity> pagosPorIdBeneficiario(@Param("idBeneficiario") Integer idBeneficiario);

}
