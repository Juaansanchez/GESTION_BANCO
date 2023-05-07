// Autor: Ángel Joaquín Rodríguez Rodríguez

package es.taw.gestionbanco.controller;

import es.taw.gestionbanco.dao.ChatEntityRepository;
import es.taw.gestionbanco.dao.ClienteEntityRepository;
import es.taw.gestionbanco.entity.ChatEntity;
import es.taw.gestionbanco.entity.ClienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    protected ChatEntityRepository chatEntityRepository;

    @Autowired
    protected ClienteEntityRepository clienteEntityRepository;

    @GetMapping("/chats")
    public String doListaChatsCliente(@RequestParam("id") Integer idCliente, Model model) {
        ClienteEntity cliente = this.clienteEntityRepository.findById(idCliente).orElseThrow();
        model.addAttribute("cliente", cliente);

        List<ChatEntity> chats = this.chatEntityRepository.buscarDeCliente(idCliente);
        model.addAttribute("listaChatsCliente", chats);

        return "listaChatsCliente";
    }
}
