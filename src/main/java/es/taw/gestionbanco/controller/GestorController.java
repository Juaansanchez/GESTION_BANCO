//Nombre: Marcos Fernández Aranda
package es.taw.gestionbanco.controller;

import es.taw.gestionbanco.dao.BeneficiarioEntityRepository;
import es.taw.gestionbanco.dao.ClienteEntityRepository;
import es.taw.gestionbanco.dao.EmpresaEntityRepository;
import es.taw.gestionbanco.dao.PagoEntityRepository;
import es.taw.gestionbanco.entity.BeneficiarioEntity;
import es.taw.gestionbanco.entity.ClienteEntity;
import es.taw.gestionbanco.entity.EmpresaEntity;
import es.taw.gestionbanco.entity.PagoEntity;
import es.taw.gestionbanco.ui.FiltroGestor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path="/gestor")
public class GestorController {

    @Autowired
    protected EmpresaEntityRepository empresaEntityRepository;

    @Autowired
    protected ClienteEntityRepository clienteEntityRepository;


    @Autowired
    protected BeneficiarioEntityRepository beneficiarioEntityRepository;

    @Autowired
    protected PagoEntityRepository pagoEntityRepository;

    @GetMapping("/")
    public String gestor (Model model){

        return this.procesarFiltrado(new FiltroGestor(), model);
    }

    @GetMapping("/editar")
    public String doEditar (@RequestParam("id") Integer idCliente, Model model) {
        ClienteEntity cliente = this.clienteEntityRepository.findById(idCliente).orElse(null);
        model.addAttribute("ClienteSeleccionado",cliente);

        BeneficiarioEntity beneficiario = this.beneficiarioEntityRepository.findById(idCliente).orElse(null);
        model.addAttribute("Beneficiario",beneficiario);

        List<PagoEntity> listaPagos = this.pagoEntityRepository.buscarPagosPorIdCliente(idCliente);
        model.addAttribute("ListaP",listaPagos);
        return "gestorCliente";
    }

    @GetMapping("/editar/habilitarCuenta")
    public String doHabilitarCuenta (@RequestParam("id") Integer idCliente, Model model) {
        ClienteEntity cliente = this.clienteEntityRepository.findById(idCliente).orElse(null);
        cliente.setEstado("activo");
        this.clienteEntityRepository.save(cliente);
        model.addAttribute("ClienteSeleccionado",cliente);

        BeneficiarioEntity beneficiario = this.beneficiarioEntityRepository.findById(idCliente).orElse(null);
        model.addAttribute("Beneficiario",beneficiario);

        return "gestorCliente";
    }
    @GetMapping("/editar/deshabilitarCuenta")
    public String doDeshabilitarCuenta (@RequestParam("id") Integer idCliente, Model model) {
        ClienteEntity cliente = this.clienteEntityRepository.findById(idCliente).orElse(null);
        cliente.setEstado("bloqueado");
        this.clienteEntityRepository.save(cliente);
        model.addAttribute("ClienteSeleccionado",cliente);

        BeneficiarioEntity beneficiario = this.beneficiarioEntityRepository.findById(idCliente).orElse(null);
        model.addAttribute("Beneficiario",beneficiario);

        List<PagoEntity> listaPagos = this.pagoEntityRepository.buscarPagosPorIdCliente(idCliente);
        model.addAttribute("ListaP",listaPagos);
        return "gestorCliente";
    }

    @GetMapping("/editar/marcarCuentaComoSospechosa")
    public String doMarcarCuentaComoSospechosa (@RequestParam("id") Integer idCliente, Model model) {
        ClienteEntity cliente = this.clienteEntityRepository.findById(idCliente).orElse(null);
        cliente.setEstado("sospechoso");
        this.clienteEntityRepository.save(cliente);

        model.addAttribute("ClienteSeleccionado",cliente);

        BeneficiarioEntity beneficiario = this.beneficiarioEntityRepository.findById(idCliente).orElse(null);
        model.addAttribute("Beneficiario",beneficiario);

        List<PagoEntity> listaPagos = this.pagoEntityRepository.buscarPagosPorIdCliente(idCliente);
        model.addAttribute("ListaP",listaPagos);
        return "gestorCliente";
    }

    @GetMapping("/editar/eliminarCuenta")
    public String doEliminarCuenta (@RequestParam("id") Integer idCliente, Model model) {
        ClienteEntity cliente = this.clienteEntityRepository.findById(idCliente).orElse(null);
        cliente.setEstado("eliminado");
        this.clienteEntityRepository.save(cliente);

        model.addAttribute("ClienteSeleccionado",cliente);


        BeneficiarioEntity beneficiario = this.beneficiarioEntityRepository.findById(idCliente).orElse(null);
        model.addAttribute("Beneficiario",beneficiario);

        List<PagoEntity> listaPagos = this.pagoEntityRepository.buscarPagosPorIdCliente(idCliente);
        model.addAttribute("ListaP",listaPagos);
        return "gestorCliente";
    }





    @PostMapping("/filtrar")
    public String doFiltrar(@ModelAttribute("filtro") FiltroGestor filtro,
                            Model model) {
        return this.procesarFiltrado( filtro, model);
    }

    protected String procesarFiltrado(FiltroGestor filtro, Model model) {

        List<ClienteEntity> clientes = this.clienteEntityRepository.findAll();
        List<EmpresaEntity> empresas = this.empresaEntityRepository.findAll();

        if (filtro == null ||  filtro.getEstado().equals("-1") ){
            filtro = new FiltroGestor();
            filtro.setEstado("-1");
        }if (filtro.getEstado().toString().equals("0")) {
            clientes = this.clienteEntityRepository.bucarClientesActivos();
        }if (filtro.getEstado().toString().equals("1")) {
            clientes = this.clienteEntityRepository.bucarClientesInactivos();
        }if (filtro.getEstado().toString().equals("2")) {
            clientes = this.clienteEntityRepository.bucarClientesSospechosos();
        }if(filtro.getEstado().toString().equals("3")){
            clientes = this.clienteEntityRepository.bucarClientesBloqueados();
        }

        model.addAttribute("listaE", empresas);
        model.addAttribute("listaC", clientes);
        model.addAttribute("filtro", filtro);

        return "gestor";
    }

}
