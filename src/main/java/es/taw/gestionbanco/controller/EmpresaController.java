package es.taw.gestionbanco.controller;

import es.taw.gestionbanco.dao.*;
import es.taw.gestionbanco.entity.AutorizadoEntity;
import es.taw.gestionbanco.entity.ClienteEntity;
import es.taw.gestionbanco.entity.EmpresaEntity;
import es.taw.gestionbanco.entity.SocioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    protected EmpresaEntityRepository empresaEntityRepository;

    @Autowired
    protected ClienteEntityRepository clienteEntityRepository;

    @Autowired
    protected AutorizadoEntityRepository autorizadoEntityRepository;

    @Autowired
    protected PersonaEntityRepository personaEntityRepository;

    @Autowired
    protected CuentabancoEntityRepository cuentabancoEntityRepository;

    @Autowired
    protected TipoestadoautorizadoEntityRepository tipoestadoautorizadoEntityRepository;

    @GetMapping("/")
    public String doAltaEmpresa (Model model, EmpresaEntity empresa){
        model.addAttribute("empresa",empresa);

        List<Integer> idClientes = this.clienteEntityRepository.buscarIdClientes();

        model.addAttribute("ids", idClientes);

        return "altaEmpresa";
    }

    @GetMapping("/altaSocio")
    public String doAltaSocio(Model model){

        model.addAttribute("autorizado", new AutorizadoEntity());

        List<Integer> idPersonas = this.personaEntityRepository.buscarIdPersonas();

        model.addAttribute("idPers", idPersonas);

        List<Integer> idCuentasBanco = this.cuentabancoEntityRepository.buscarIdCuentasBanco();

        model.addAttribute("idCuentas", idCuentasBanco);

        List<Integer> idEmpresas = this.empresaEntityRepository.buscarIdEmpresas();

        model.addAttribute("idEmp", idEmpresas);

        List<Integer> tipoEstadoAutorizado = this.tipoestadoautorizadoEntityRepository.buscarIdTipoEstadoAutorizado();

        model.addAttribute("idEstados", tipoEstadoAutorizado);

        return "altaSocio";
    }

    @GetMapping("/listarSocios")
    public String doListarSocios(@RequestParam("id") Integer idEmpresa, Model model){
        List<AutorizadoEntity> socios = this.autorizadoEntityRepository.buscarSociosPorIdEmpresa(idEmpresa);
        model.addAttribute("autorizados", socios);
        return "socios";
    }

    @GetMapping("/editarEmpresa")
    public String doEditarEmpresa(@RequestParam("id") Integer idEmpresa, Model model){
        EmpresaEntity empresa = this.empresaEntityRepository.findById(idEmpresa).orElse(null);
        model.addAttribute("empresa", empresa);
        return "editarEmpresa";
    }

    @GetMapping("/editarSocio")
    public String doEditarAutorizado(@RequestParam("id") Integer idAutorizado, Model model){
        AutorizadoEntity autorizado = this.autorizadoEntityRepository.findById(idAutorizado).orElse(null);
        model.addAttribute("autorizado", autorizado);

        List<Integer> idCuentasBanco = this.cuentabancoEntityRepository.buscarIdCuentasBanco();

        model.addAttribute("idCuentas", idCuentasBanco);

        List<Integer> idEmpresas = this.empresaEntityRepository.buscarIdEmpresas();

        model.addAttribute("idEmp", idEmpresas);

        List<Integer> tipoEstadoAutorizado = this.tipoestadoautorizadoEntityRepository.buscarIdTipoEstadoAutorizado();

        model.addAttribute("idEstados", tipoEstadoAutorizado);
        return "editarSocio";
    }

    @PostMapping("/guardar")
    public String doGuardar (@ModelAttribute("empresa") EmpresaEntity empresa){
        this.empresaEntityRepository.save(empresa);
        return "redirect:/empresa/";
    }

    @PostMapping("/guardarAutorizado")
    public String doGuardarAutorizado (@ModelAttribute("autorizado") AutorizadoEntity autorizado){
        this.autorizadoEntityRepository.save(autorizado);
        return "redirect:/empresa/";
    }


}
