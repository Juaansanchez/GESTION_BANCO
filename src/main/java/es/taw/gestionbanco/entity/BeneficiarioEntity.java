package es.taw.gestionbanco.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "beneficiario", schema = "gestion_banco", catalog = "")
public class BeneficiarioEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idBeneficiario", nullable = false)
    private int idBeneficiario;
    @Basic
    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;
    @Basic
    @Column(name = "apellido", nullable = false, length = 255)
    private String apellido;
    @Basic
    @Column(name = "pais", nullable = false, length = 255)
    private String pais;
    @Basic
    @Column(name = "moneda", nullable = false, length = 255)
    private String moneda;
    @Basic
    @Column(name = "ibanCuenta", nullable = false, length = 255)
    private String ibanCuenta;
    @Basic
    @Column(name = "numeroCuenta", nullable = false, length = 255)
    private String numeroCuenta;
    @Basic
    @Column(name = "swift", nullable = false)
    private byte swift;
    @Basic
    @Column(name = "paisCuenta", nullable = false, length = 255)
    private String paisCuenta;
    @Basic
    @Column(name = "fechaNacimiento", nullable = false)
    private Date fechaNacimiento;
    @ManyToOne
    @JoinColumn(name = "idCliente", referencedColumnName = "id", nullable = false)
    private ClienteEntity clienteByIdCliente;
    @OneToMany(mappedBy = "beneficiarioByIdBeneficiario")
    private Collection<PagoEntity> pagosByIdBeneficiario;

    public int getIdBeneficiario() {
        return idBeneficiario;
    }

    public void setIdBeneficiario(int idBeneficiario) {
        this.idBeneficiario = idBeneficiario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getIbanCuenta() {
        return ibanCuenta;
    }

    public void setIbanCuenta(String ibanCuenta) {
        this.ibanCuenta = ibanCuenta;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public byte getSwift() {
        return swift;
    }

    public void setSwift(byte swift) {
        this.swift = swift;
    }

    public String getPaisCuenta() {
        return paisCuenta;
    }

    public void setPaisCuenta(String paisCuenta) {
        this.paisCuenta = paisCuenta;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BeneficiarioEntity that = (BeneficiarioEntity) o;
        return idBeneficiario == that.idBeneficiario && swift == that.swift && Objects.equals(nombre, that.nombre) && Objects.equals(apellido, that.apellido) && Objects.equals(pais, that.pais) && Objects.equals(moneda, that.moneda) && Objects.equals(ibanCuenta, that.ibanCuenta) && Objects.equals(numeroCuenta, that.numeroCuenta) && Objects.equals(paisCuenta, that.paisCuenta) && Objects.equals(fechaNacimiento, that.fechaNacimiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBeneficiario, nombre, apellido, pais, moneda, ibanCuenta, numeroCuenta, swift, paisCuenta, fechaNacimiento);
    }

    public ClienteEntity getClienteByIdCliente() {
        return clienteByIdCliente;
    }

    public void setClienteByIdCliente(ClienteEntity clienteByIdCliente) {
        this.clienteByIdCliente = clienteByIdCliente;
    }

    public Collection<PagoEntity> getPagosByIdBeneficiario() {
        return pagosByIdBeneficiario;
    }

    public void setPagosByIdBeneficiario(Collection<PagoEntity> pagosByIdBeneficiario) {
        this.pagosByIdBeneficiario = pagosByIdBeneficiario;
    }
}
