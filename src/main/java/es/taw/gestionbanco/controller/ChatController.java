// Autor: Ángel Joaquín Rodríguez Rodríguez

package es.taw.gestionbanco.controller;

import es.taw.gestionbanco.dao.AsistenteEntityRepository;
import es.taw.gestionbanco.dao.ChatEntityRepository;
import es.taw.gestionbanco.dao.ClienteEntityRepository;
import es.taw.gestionbanco.dao.MensajeEntityRepository;
import es.taw.gestionbanco.entity.AsistenteEntity;
import es.taw.gestionbanco.entity.ChatEntity;
import es.taw.gestionbanco.entity.ClienteEntity;
import es.taw.gestionbanco.entity.MensajeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@Controller
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    ChatEntityRepository chatEntityRepository;

    @Autowired
    MensajeEntityRepository mensajeEntityRepository;

    @Autowired
    ClienteEntityRepository clienteEntityRepository;

    @Autowired
    AsistenteEntityRepository asistenteEntityRepository;

    @GetMapping("")
    public String doMostrarChat(@RequestParam("id") Integer idChat,
                                @RequestParam("esAsistente") boolean esAsistente,
                                Model model) {
        ChatEntity chat = this.chatEntityRepository.findById(idChat).orElseThrow();
        model.addAttribute("chatActual", chat);

        MensajeEntity mensaje = new MensajeEntity();
        mensaje.setChatByChat(chat);
        if (esAsistente)
            mensaje.setEmisorEsAsistente(Byte.valueOf("1"));
        else
            mensaje.setEmisorEsAsistente(Byte.valueOf("0"));
        model.addAttribute("mensajeNuevo", mensaje);

        return "vistaChat";
    }

    @PostMapping("/enviarMensaje")
    public String doEnviarMensaje(@ModelAttribute("mensajeNuevo") MensajeEntity mensajeNuevo) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        mensajeNuevo.setFechaEnvio(timestamp);
        List<MensajeEntity> mensajesChat = mensajeNuevo.getChatByChat().getMensajesByIdChat();
        mensajesChat.add(mensajeNuevo);
        this.mensajeEntityRepository.save(mensajeNuevo);
        this.chatEntityRepository.save(mensajeNuevo.getChatByChat());

        boolean esAsistente = mensajeNuevo.getEmisorEsAsistente() == 1;

        return "redirect:/chat?id=" + mensajeNuevo.getChatByChat().getIdChat() + "&esAsistente=" + esAsistente;
    }

    @GetMapping("/nuevoChat")
    public String doNuevoChat(@RequestParam("idCliente") Integer idCliente, Model model) {
        ClienteEntity cliente = this.clienteEntityRepository.findById(idCliente).orElseThrow();

        List<AsistenteEntity> asistentes = this.asistenteEntityRepository.findAll();
        model.addAttribute("listaAsistentes", asistentes);

        ChatEntity chat = new ChatEntity();
        chat.setClienteByIdCliente(cliente);
        model.addAttribute("nuevoChat", chat);

        return "nuevoChat";
    }

    @PostMapping("/abrirChat")
    public String doAbrirChat(@ModelAttribute("nuevoChat") ChatEntity chat) {
        List<ChatEntity> listaChatsCliente = chat.getClienteByIdCliente().getChatsById();
        listaChatsCliente.add(chat);

        List<ChatEntity> listaChatsAsistente = chat.getAsistenteByIdEmpleado().getChatsByIdAsistente();
        listaChatsAsistente.add(chat);

        this.chatEntityRepository.save(chat);
        this.clienteEntityRepository.save(chat.getClienteByIdCliente());
        this.asistenteEntityRepository.save(chat.getAsistenteByIdEmpleado());

        return "redirect:/cliente/chats?id=" + chat.getClienteByIdCliente().getId();
    }

    @GetMapping("/cerrarChat")
    public String doCerrarChat(@RequestParam("id") Integer idChat) {
        ChatEntity chat = this.chatEntityRepository.findById(idChat).orElseThrow();
        chat.setEstado((byte) 0);
        this.chatEntityRepository.save(chat);

        return "redirect:/cliente/chats?id=" + chat.getAsistenteByIdEmpleado().getIdAsistente();
    }
}
