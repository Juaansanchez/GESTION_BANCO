package es.taw.gestionbanco.dao;

import es.taw.gestionbanco.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteEntityRepository extends JpaRepository<ClienteEntity, Integer> {
    @Query("SELECT cl.id, cl.numeroIdentificacion, cl.estado, cl.fechaInicio FROM ClienteEntity cl JOIN PersonaEntity p ON cl.id=p.id WHERE cl.id=:idCliente")
    ClienteEntity buscaClientePorId(int idCliente);
}
