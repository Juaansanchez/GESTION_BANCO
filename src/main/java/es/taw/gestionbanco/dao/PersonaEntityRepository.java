package es.taw.gestionbanco.dao;

import es.taw.gestionbanco.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;

public interface PersonaEntityRepository extends JpaRepository<PersonaEntity, Integer> {
    @Modifying
    @Query("UPDATE PersonaEntity p " +
            "SET p.nombre = :nombre, p.apellido=:apellido, p.segundoApellido=:segundoApellido, p.fechaNacimiento=:fechaNacimiento " +
            "WHERE p.id=:id")
    void actualizaCliente(@Param("id") int id,@Param("nombre") String nombre, @Param("apellido")String apellido,
                          @Param("segundoApellido") String segundoApellido,@Param("fechaNacimiento") Date fechaNacimiento);
}