package es.taw.gestionbanco.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "pago", schema = "gestion_banco", catalog = "")
public class PagoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idPago", nullable = false)
    private Integer idPago;
    @Basic
    @Column(name = "moneda", nullable = false, length = 255)
    private String moneda;
    @Basic
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;
    @ManyToOne
    @JoinColumn(name = "idTransaccion", referencedColumnName = "id", nullable = false)
    private TransaccionEntity transaccionByIdTransaccion;
    @ManyToOne
    @JoinColumn(name = "idBeneficiario", referencedColumnName = "idBeneficiario", nullable = false)
    private BeneficiarioEntity beneficiarioByIdBeneficiario;

    public Integer getIdPago() {
        return idPago;
    }

    public void setIdPago(Integer idPago) {
        this.idPago = idPago;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PagoEntity that = (PagoEntity) o;
        return Objects.equals(idPago, that.idPago) && Objects.equals(moneda, that.moneda) && Objects.equals(cantidad, that.cantidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPago, moneda, cantidad);
    }

    public TransaccionEntity getTransaccionByIdTransaccion() {
        return transaccionByIdTransaccion;
    }

    public void setTransaccionByIdTransaccion(TransaccionEntity transaccionByIdTransaccion) {
        this.transaccionByIdTransaccion = transaccionByIdTransaccion;
    }

    public BeneficiarioEntity getBeneficiarioByIdBeneficiario() {
        return beneficiarioByIdBeneficiario;
    }

    public void setBeneficiarioByIdBeneficiario(BeneficiarioEntity beneficiarioByIdBeneficiario) {
        this.beneficiarioByIdBeneficiario = beneficiarioByIdBeneficiario;
    }
}
