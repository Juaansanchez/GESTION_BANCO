package es.taw.gestionbanco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/asistente")
public class AsistenteController {
    //@Autowired
    // protected ChatEntityRepository chatEntityRepository;

    @GetMapping("")
    public String doListaChatsAsistente(@RequestParam("id") Integer idAsistente, Model model) {
        return null;
    }
}
