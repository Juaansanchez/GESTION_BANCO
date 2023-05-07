package es.taw.gestionbanco.controller;

import es.taw.gestionbanco.dao.EmpresaEntityRepository;
import es.taw.gestionbanco.entity.EmpresaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmpresaController {

    @Autowired
    protected EmpresaEntityRepository empresaEntityRepository;
/*
    @GetMapping("/")
    public String doAltaEmpresa (Model model){
        model.addAttribute("empresa",new EmpresaEntity());
        return "altaEmpresa";
    }

    @PostMapping("/guardar")
    public String doGuardar (@ModelAttribute("empresa") EmpresaEntity empresa){
        this.empresaEntityRepository.save(empresa);
        return "redirect:/";
    }
 */
}
