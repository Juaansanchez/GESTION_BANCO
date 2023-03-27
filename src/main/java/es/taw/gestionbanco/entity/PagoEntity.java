package es.taw.gestionbanco.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "pago", schema = "gestion_banco", catalog = "")
public class PagoEntity {
    @Basic
    @Column(name = "moneda", nullable = false, length = 255)
    private String moneda;
    @Basic
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    @ManyToOne
    @JoinColumn(name = "idTransaccion", referencedColumnName = "id", nullable = false)
    private TransaccionEntity transaccionByIdTransaccion;
    @ManyToOne
    @JoinColumn(name = "idBeneficiario", referencedColumnName = "idBeneficiario", nullable = false)
    private BeneficiarioEntity beneficiarioByIdBeneficiario;

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PagoEntity that = (PagoEntity) o;
        return cantidad == that.cantidad && Objects.equals(moneda, that.moneda);
    }

    @Override
    public int hashCode() {
        return Objects.hash(moneda, cantidad);
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
