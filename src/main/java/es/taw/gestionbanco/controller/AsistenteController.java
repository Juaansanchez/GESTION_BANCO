// Autor: Ángel Joaquín Rodríguez Rodríguez

package es.taw.gestionbanco.controller;

import es.taw.gestionbanco.dao.AsistenteEntityRepository;
import es.taw.gestionbanco.dao.ChatEntityRepository;
import es.taw.gestionbanco.entity.AsistenteEntity;
import es.taw.gestionbanco.entity.ChatEntity;
import es.taw.gestionbanco.entity.ClienteEntity;
import es.taw.gestionbanco.ui.FiltroChat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/asistente")
public class AsistenteController {
    @Autowired
    protected ChatEntityRepository chatEntityRepository;

    @Autowired
    protected AsistenteEntityRepository asistenteEntityRepository;

    @GetMapping("/chats")
    public String doListaChatsAsistente(@RequestParam("id") Integer idAsistente, Model model) {
        return this.procesarFiltrado(idAsistente, null, model);
    }

    @PostMapping("/filtrar")
    public String doFiltrar(@ModelAttribute("filtro") FiltroChat filtro,
                            Model model) {
        return this.procesarFiltrado(filtro.getIdAsistente(), filtro, model);
    }

    protected String procesarFiltrado(Integer idAsistente, FiltroChat filtro, Model model) {
        AsistenteEntity asistente = this.asistenteEntityRepository.findById(idAsistente).orElseThrow();
        model.addAttribute("asistente", asistente);

        List<ChatEntity> chats;

        if (filtro == null || (filtro.getIdCliente() == null && filtro.getEstadoChat() == -1)) {
            chats = this.chatEntityRepository.buscarDeAsistente(idAsistente);
            filtro = new FiltroChat();
            filtro.setIdAsistente(asistente.getIdAsistente());
        } else if (filtro.getEstadoChat() == -1) {
            chats = this.chatEntityRepository.buscarDeAsistentePorCliente(filtro.getIdAsistente(), filtro.getIdCliente());
        } else if (filtro.getIdCliente() == null) {
            chats = this.chatEntityRepository.buscarDeAsistentePorEstado(filtro.getIdAsistente(), Byte.valueOf(filtro.getEstadoChat().toString()));
        } else {
            chats = this.chatEntityRepository.buscarDeAsistentePorClienteYEstado(filtro.getIdAsistente(),
                    filtro.getIdCliente(),
                    Byte.valueOf(filtro.getEstadoChat().toString()));
        }

        model.addAttribute("listaChatsAsistente", chats);
        model.addAttribute("filtro", filtro);

        List<ClienteEntity> clientes = new ArrayList<>();

        for (ChatEntity chat : chats) {
            ClienteEntity cliente = chat.getClienteByIdCliente();
            if (!clientes.contains(cliente))
                clientes.add(chat.getClienteByIdCliente());
        }

        model.addAttribute("clientesAsistente", clientes);

        return "listaChatsAsistente";
    }
}
