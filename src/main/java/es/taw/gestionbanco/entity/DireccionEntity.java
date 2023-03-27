package es.taw.gestionbanco.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "direccion", schema = "gestion_banco", catalog = "")
public class DireccionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "tipo", nullable = false, length = 255)
    private String tipo;
    @Basic
    @Column(name = "calle", nullable = false, length = 255)
    private String calle;
    @Basic
    @Column(name = "numero", nullable = false)
    private int numero;
    @Basic
    @Column(name = "plantaPuertaOficina", nullable = false, length = 255)
    private String plantaPuertaOficina;
    @Basic
    @Column(name = "ciudad", nullable = false, length = 255)
    private String ciudad;
    @Basic
    @Column(name = "region", nullable = false, length = 255)
    private String region;
    @Basic
    @Column(name = "codigoPostal", nullable = false, length = 255)
    private String codigoPostal;
    @Basic
    @Column(name = "pais", nullable = false, length = 255)
    private String pais;
    @Basic
    @Column(name = "valida", nullable = false)
    private byte valida;
    @ManyToOne
    @JoinColumn(name = "idCliente", referencedColumnName = "id", nullable = false)
    private ClienteEntity clienteByIdCliente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPlantaPuertaOficina() {
        return plantaPuertaOficina;
    }

    public void setPlantaPuertaOficina(String plantaPuertaOficina) {
        this.plantaPuertaOficina = plantaPuertaOficina;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public byte getValida() {
        return valida;
    }

    public void setValida(byte valida) {
        this.valida = valida;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DireccionEntity that = (DireccionEntity) o;
        return id == that.id && numero == that.numero && valida == that.valida && Objects.equals(tipo, that.tipo) && Objects.equals(calle, that.calle) && Objects.equals(plantaPuertaOficina, that.plantaPuertaOficina) && Objects.equals(ciudad, that.ciudad) && Objects.equals(region, that.region) && Objects.equals(codigoPostal, that.codigoPostal) && Objects.equals(pais, that.pais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipo, calle, numero, plantaPuertaOficina, ciudad, region, codigoPostal, pais, valida);
    }

    public ClienteEntity getClienteByIdCliente() {
        return clienteByIdCliente;
    }

    public void setClienteByIdCliente(ClienteEntity clienteByIdCliente) {
        this.clienteByIdCliente = clienteByIdCliente;
    }
}
