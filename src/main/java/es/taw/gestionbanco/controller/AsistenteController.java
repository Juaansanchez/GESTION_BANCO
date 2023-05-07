package es.taw.gestionbanco.controller;

import es.taw.gestionbanco.dao.ChatEntityRepository;
import es.taw.gestionbanco.entity.ChatEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/asistente")
public class AsistenteController {
    @Autowired
    protected ChatEntityRepository chatEntityRepository;
/*
    @GetMapping("")
    public String doListaChatsAsistente(@RequestParam("id") Integer idAsistente, Model model) {
        List<ChatEntity> chats = null;
        return null;
    }

 */
}
