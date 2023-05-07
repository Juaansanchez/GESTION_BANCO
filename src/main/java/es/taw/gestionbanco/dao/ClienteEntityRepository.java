package es.taw.gestionbanco.dao;

import es.taw.gestionbanco.entity.ClienteEntity;
import es.taw.gestionbanco.entity.EmpresaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ClienteEntityRepository extends JpaRepository<ClienteEntity, Integer> {

    @Query("select clientes from ClienteEntity clientes where clientes.estado like 'activo'")
    public List<ClienteEntity> bucarClientesActivos ();

    @Query("select clientes from ClienteEntity clientes where clientes.estado like 'inactivo'")
    public List<ClienteEntity> bucarClientesInactivos ();

    @Query("select clientes from ClienteEntity clientes where clientes.estado like 'sospechoso'")
    public List<ClienteEntity> bucarClientesSospechosos ();

    @Query("select clientes from ClienteEntity clientes where clientes.estado like 'bloqueado'")
    public List<ClienteEntity> bucarClientesBloqueados ();

    @Query("SELECT e.id FROM ClienteEntity e")
    List<Integer> buscarIdClientes();
}
