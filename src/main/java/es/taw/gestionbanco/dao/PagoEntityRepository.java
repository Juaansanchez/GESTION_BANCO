package es.taw.gestionbanco.dao;

import es.taw.gestionbanco.entity.PagoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PagoEntityRepository extends JpaRepository<PagoEntity, Integer> {
    @Query("SELECT p FROM PagoEntity p " +
            "JOIN TransaccionEntity t on p.idPago=t.id " +
            "JOIN BeneficiarioEntity b ON p.beneficiarioByIdBeneficiario.idBeneficiario = b.idBeneficiario " +
            "WHERE b.idBeneficiario=:idBeneficiario")
    List<PagoEntity> pagosPorIdBeneficiario(@Param("idBeneficiario") Integer idBeneficiario);

}
