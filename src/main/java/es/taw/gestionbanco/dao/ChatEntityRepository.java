package es.taw.gestionbanco.dao;

import es.taw.gestionbanco.entity.ChatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatEntityRepository extends JpaRepository<ChatEntity, Integer> {
}
