// Autor: Ángel Joaquín Rodríguez Rodríguez

package es.taw.gestionbanco.dao;

import es.taw.gestionbanco.entity.ChatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChatEntityRepository extends JpaRepository<ChatEntity, Integer> {
    @Query("select c from ChatEntity c where c.asistenteByIdEmpleado.idAsistente = :id")
    List<ChatEntity> buscarDeAsistente(@Param("id") Integer idAsistente);

    @Query("select c from ChatEntity c where c.asistenteByIdEmpleado.idAsistente = :id and c.estado = :estado")
    List<ChatEntity> buscarDeAsistentePorEstado(
            @Param("id") Integer idAsistente,
            @Param("estado") Byte estado);

    @Query("select c from ChatEntity c where c.asistenteByIdEmpleado.idAsistente = :idAsistente and " +
            "c.clienteByIdCliente.id = :idCliente")
    List<ChatEntity> buscarDeAsistentePorCliente(
            @Param("idAsistente") Integer idAsistente,
            @Param("idCliente") Integer idCliente);

    @Query("select c from ChatEntity c where c.asistenteByIdEmpleado.idAsistente = :idAsistente and " +
            "c.clienteByIdCliente.id = :idCliente and c.estado = :estado")
    List<ChatEntity> buscarDeAsistentePorClienteYEstado(
            @Param("idAsistente") Integer idAsistente,
            @Param("idCliente") Integer idCliente,
            @Param("estado") Byte estadoCliente);

    @Query("select c from ChatEntity c where c.clienteByIdCliente.id = :id")
    List<ChatEntity> buscarDeCliente(@Param("id") Integer idCliente);
}
