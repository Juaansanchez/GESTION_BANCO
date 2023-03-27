package es.taw.gestionbanco.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "cuentabanco", schema = "gestion_banco", catalog = "")
public class CuentabancoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "fecha_apertura", nullable = true)
    private Date fechaApertura;
    @Basic
    @Column(name = "fecha_cierre", nullable = true)
    private Date fechaCierre;
    @Basic
    @Column(name = "moneda", nullable = false, length = 255)
    private String moneda;
    @Basic
    @Column(name = "ibanCuenta", nullable = false, length = 255)
    private String ibanCuenta;
    @Basic
    @Column(name = "swift", nullable = false)
    private byte swift;
    @Basic
    @Column(name = "pais", nullable = false, length = 255)
    private String pais;
    @OneToMany(mappedBy = "cuentabancoByIdCuentaBanco")
    private Collection<AutorizadoEntity> autorizadosById;
    @ManyToOne
    @JoinColumn(name = "entidadBancaria", referencedColumnName = "id", nullable = false)
    private EntidadbancariaEntity entidadbancariaByEntidadBancaria;
    @ManyToOne
    @JoinColumn(name = "idCliente", referencedColumnName = "id", nullable = false)
    private ClienteEntity clienteByIdCliente;
    @ManyToOne
    @JoinColumn(name = "estadoCuenta", referencedColumnName = "id", nullable = false)
    private TipoestadocuentaEntity tipoestadocuentaByEstadoCuenta;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
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

    public byte getSwift() {
        return swift;
    }

    public void setSwift(byte swift) {
        this.swift = swift;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CuentabancoEntity that = (CuentabancoEntity) o;
        return id == that.id && swift == that.swift && Objects.equals(fechaApertura, that.fechaApertura) && Objects.equals(fechaCierre, that.fechaCierre) && Objects.equals(moneda, that.moneda) && Objects.equals(ibanCuenta, that.ibanCuenta) && Objects.equals(pais, that.pais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fechaApertura, fechaCierre, moneda, ibanCuenta, swift, pais);
    }

    public Collection<AutorizadoEntity> getAutorizadosById() {
        return autorizadosById;
    }

    public void setAutorizadosById(Collection<AutorizadoEntity> autorizadosById) {
        this.autorizadosById = autorizadosById;
    }

    public EntidadbancariaEntity getEntidadbancariaByEntidadBancaria() {
        return entidadbancariaByEntidadBancaria;
    }

    public void setEntidadbancariaByEntidadBancaria(EntidadbancariaEntity entidadbancariaByEntidadBancaria) {
        this.entidadbancariaByEntidadBancaria = entidadbancariaByEntidadBancaria;
    }

    public ClienteEntity getClienteByIdCliente() {
        return clienteByIdCliente;
    }

    public void setClienteByIdCliente(ClienteEntity clienteByIdCliente) {
        this.clienteByIdCliente = clienteByIdCliente;
    }

    public TipoestadocuentaEntity getTipoestadocuentaByEstadoCuenta() {
        return tipoestadocuentaByEstadoCuenta;
    }

    public void setTipoestadocuentaByEstadoCuenta(TipoestadocuentaEntity tipoestadocuentaByEstadoCuenta) {
        this.tipoestadocuentaByEstadoCuenta = tipoestadocuentaByEstadoCuenta;
    }
}
