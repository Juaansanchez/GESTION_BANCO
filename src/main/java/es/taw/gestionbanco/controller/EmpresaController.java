package es.taw.gestionbanco.controller;

// Autor: Juan Francisco Sánchez García

import es.taw.gestionbanco.dao.*;
import es.taw.gestionbanco.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/empresa")
public class EmpresaController {
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
    @Autowired
    protected TransaccionEntityRepository transaccionEntityRepository;
    @Autowired
    protected PagoEntityRepository pagoEntityRepository;
    @Autowired
    protected CambiodivisaEntityRepository cambiodivisaEntityRepository;
    @Autowired
    protected BeneficiarioEntityRepository beneficiarioEntityRepository;
    @Autowired
    EmpresaEntityRepository empresaEntityRepository;

    @GetMapping("/")
    public String doAltaEmpresa(Model model, EmpresaEntity empresa) {
        model.addAttribute("empresa", empresa);

        List<Integer> idClientes = this.clienteEntityRepository.buscarIdClientes();

        model.addAttribute("ids", idClientes);

        return "altaEmpresa";
    }

    @GetMapping("/altaSocio")
    public String doAltaSocio(Model model) {

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

    @GetMapping("/hacerTransaccion")
    public String doHacerTransaccion(Model model) {
        model.addAttribute("transaccion", new TransaccionEntity());
        return "nuevaTransaccion";
    }

    @PostMapping("/guardarTransaccion")
    public String doGuardarTransaccion(@ModelAttribute("transaccion") TransaccionEntity transaccion, Model model) {
        this.transaccionEntityRepository.save(transaccion);
        model.addAttribute("transaccionTipo", transaccion);
        return "tipoTransaccion";
    }

    @GetMapping("/hacerPago")
    public String doHacerPago(Model model) {
        model.addAttribute("pago", new PagoEntity());

        List<BeneficiarioEntity> beneficiarios = this.beneficiarioEntityRepository.findAll();
        model.addAttribute("beneficiarios", beneficiarios);

        List<TransaccionEntity> transacciones = this.transaccionEntityRepository.findAll();
        model.addAttribute("transacciones", transacciones);

        return "nuevoPago";
    }

    @PostMapping("/guardarPago")
    public String doGuardarPago(@ModelAttribute("pago") PagoEntity pago) {
        this.pagoEntityRepository.save(pago);
        return "redirect:/empresa/";
    }

    @GetMapping("/hacerCambioDivisa")
    public String doHacerCambioDivisa(Model model) {
        model.addAttribute("cambio", new CambiodivisaEntity());

        List<TransaccionEntity> transacciones = this.transaccionEntityRepository.findAll();
        model.addAttribute("transacciones", transacciones);

        return "nuevoCambioDivisa";
    }

    @PostMapping("/guardarCambioDivisa")
    public String doGuardarCambioDivisa(@ModelAttribute("cambio") CambiodivisaEntity cambio) {
        this.cambiodivisaEntityRepository.save(cambio);
        return "redirect:/empresa/";
    }

    @GetMapping("/listarSocios")
    public String doListarSocios(@RequestParam("id") Integer idEmpresa, Model model) {
        List<AutorizadoEntity> socios = this.autorizadoEntityRepository.buscarSociosPorIdEmpresa(idEmpresa);
        model.addAttribute("autorizados", socios);
        return "socios";
    }

    @GetMapping("/filtrarSocios")
    public String doFiltrarSocios(@RequestParam("texto") String texto, Model model) {
        List<AutorizadoEntity> socios = this.autorizadoEntityRepository.filtrarPorDNI(texto);
        model.addAttribute("autorizados", socios);

        return "socios";
    }

    @GetMapping("/filtrarSociosPorEstado")
    public String doFiltrarSociosEstado(@RequestParam("estado") String estado, Model model) {

        List<AutorizadoEntity> socios = this.autorizadoEntityRepository.filtrarPorEstado(estado);
        model.addAttribute("autorizados", socios);

        return "socios";
    }

    @GetMapping("/filtrarSociosPorNombreEmpresa")
    public String doFiltrarSociosNombreEmpresa(@RequestParam("nombreEmpresa") String nombreEmpresa, Model model) {

        List<AutorizadoEntity> socios = this.autorizadoEntityRepository.filtrarPorNombreEmpresa(nombreEmpresa);
        model.addAttribute("autorizados", socios);

        return "socios";
    }

    @GetMapping("/listarPagos")
    public String doListarPagos(@RequestParam("id") Integer idCliente, Model model) {
        List<PagoEntity> pagos = this.pagoEntityRepository.buscarPagosPorIdCliente(idCliente);
        model.addAttribute("pagos", pagos);
        return "pagos";
    }

    @GetMapping("/filtrarPagosPorMonedas")
    public String doFiltrarPagosMonedas(@RequestParam("moneda") String moneda, Model model) {
        List<PagoEntity> pagos = this.pagoEntityRepository.filtrarPorMoneda(moneda);
        model.addAttribute("pagos", pagos);
        return "pagos";
    }

    @GetMapping("/filtrarPagosPorNombre")
    public String doFiltrarPagosPorNombre(@RequestParam("texto") String texto, Model model) {
        List<PagoEntity> pagos = this.pagoEntityRepository.filtrarPorNombre(texto);
        model.addAttribute("pagos", pagos);
        return "pagos";
    }

    @GetMapping("/filtrarPagosPorApellido")
    public String doFiltrarPagosPorApellido(@RequestParam("texto") String texto, Model model) {
        List<PagoEntity> pagos = this.pagoEntityRepository.filtrarPorApellido(texto);
        model.addAttribute("pagos", pagos);
        return "pagos";
    }

    @GetMapping("/editarEmpresa")
    public String doEditarEmpresa(@RequestParam("id") Integer idEmpresa, Model model) {
        EmpresaEntity empresa = this.empresaEntityRepository.findById(idEmpresa).orElse(null);
        model.addAttribute("empresa", empresa);
        return "editarEmpresa";
    }

    @GetMapping("/editarSocio")
    public String doEditarAutorizado(@RequestParam("id") Integer idAutorizado, Model model) {
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
    public String doGuardar(@ModelAttribute("empresa") EmpresaEntity empresa) {
        this.empresaEntityRepository.save(empresa);
        return "redirect:/empresa/";
    }

    @PostMapping("/guardarAutorizado")
    public String doGuardarAutorizado(@ModelAttribute("autorizado") AutorizadoEntity autorizado) {
        this.autorizadoEntityRepository.save(autorizado);
        return "redirect:/empresa/";
    }

}
