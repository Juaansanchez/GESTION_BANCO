package es.taw.gestionbanco.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "cambiodivisa", schema = "gestion_banco", catalog = "")
public class CambiodivisaEntity {
    @Basic
    @Column(name = "monedaVenta", nullable = false, length = 255)
    private String monedaVenta;
    @Basic
    @Column(name = "monedaCompra", nullable = false, length = 255)
    private String monedaCompra;
    @Basic
    @Column(name = "tipoDeCambio", nullable = false, length = 255)
    private String tipoDeCambio;
    @Basic
    @Column(name = "cantidadCompra", nullable = false)
    private Integer cantidadCompra;
    @Basic
    @Column(name = "cantidadVenta", nullable = false)
    private Integer cantidadVenta;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idTransaccion", nullable = false)
    private Integer idTransaccion;
    @OneToOne
    @JoinColumn(name = "idTransaccion", referencedColumnName = "id", nullable = false)
    private TransaccionEntity transaccionByIdTransaccion;

    public String getMonedaVenta() {
        return monedaVenta;
    }

    public void setMonedaVenta(String monedaVenta) {
        this.monedaVenta = monedaVenta;
    }

    public String getMonedaCompra() {
        return monedaCompra;
    }

    public void setMonedaCompra(String monedaCompra) {
        this.monedaCompra = monedaCompra;
    }

    public String getTipoDeCambio() {
        return tipoDeCambio;
    }

    public void setTipoDeCambio(String tipoDeCambio) {
        this.tipoDeCambio = tipoDeCambio;
    }

    public Integer getCantidadCompra() {
        return cantidadCompra;
    }

    public void setCantidadCompra(Integer cantidadCompra) {
        this.cantidadCompra = cantidadCompra;
    }

    public Integer getCantidadVenta() {
        return cantidadVenta;
    }

    public void setCantidadVenta(Integer cantidadVenta) {
        this.cantidadVenta = cantidadVenta;
    }

    public Integer getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(Integer idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CambiodivisaEntity that = (CambiodivisaEntity) o;
        return Objects.equals(monedaVenta, that.monedaVenta) && Objects.equals(monedaCompra, that.monedaCompra) && Objects.equals(tipoDeCambio, that.tipoDeCambio) && Objects.equals(cantidadCompra, that.cantidadCompra) && Objects.equals(cantidadVenta, that.cantidadVenta) && Objects.equals(idTransaccion, that.idTransaccion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(monedaVenta, monedaCompra, tipoDeCambio, cantidadCompra, cantidadVenta, idTransaccion);
    }

    public TransaccionEntity getTransaccionByIdTransaccion() {
        return transaccionByIdTransaccion;
    }

    public void setTransaccionByIdTransaccion(TransaccionEntity transaccionByIdTransaccion) {
        this.transaccionByIdTransaccion = transaccionByIdTransaccion;
    }
}
