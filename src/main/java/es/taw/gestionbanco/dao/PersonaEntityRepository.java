/*
Autor:
    -Álvaro Alemán Rando 20%
    -Juan Sánchez García 20%
    -Marcos Fernández Aranda 20%
    -Ángel Joaquín Rodríguez Rodríguez 20%
    -Ignacio Morillas Rosell 20%
 */
package es.taw.gestionbanco.dao;

import es.taw.gestionbanco.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonaEntityRepository extends JpaRepository<PersonaEntity, Integer> {

    PersonaEntity findByDni(String dni);

    @Query("SELECT p.id FROM PersonaEntity p")
    List<Integer> buscarIdPersonas();
}