package ma.iam.wissal.gfee.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * A IocDLC.
 */
@Entity
@Table(name = "gest_redev_ioc_dlc")
public class IocDLC implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "idIocDLC")
    private Long id;

    @Column(name = "idioc")
    private Long idIOC;

    @Column(name = "numeroioc")
    private Long numeroIOC;

    @Column(name = "libelleioc")
    private String libelleIOC;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public IocDLC id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdIOC() {
        return this.idIOC;
    }

    public IocDLC idIOC(Long idIOC) {
        this.setIdIOC(idIOC);
        return this;
    }

    public void setIdIOC(Long idIOC) {
        this.idIOC = idIOC;
    }

    public Long getNumeroIOC() {
        return this.numeroIOC;
    }

    public IocDLC numeroIOC(Long numeroIOC) {
        this.setNumeroIOC(numeroIOC);
        return this;
    }

    public void setNumeroIOC(Long numeroIOC) {
        this.numeroIOC = numeroIOC;
    }

    public String getLibelleIOC() {
        return this.libelleIOC;
    }

    public IocDLC libelleIOC(String libelleIOC) {
        this.setLibelleIOC(libelleIOC);
        return this;
    }

    public void setLibelleIOC(String libelleIOC) {
        this.libelleIOC = libelleIOC;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof IocDLC)) {
            return false;
        }
        return id != null && id.equals(((IocDLC) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "IocDLC{" +
            "id=" + getId() +
            ", idIOC=" + getIdIOC() +
            ", numeroIOC=" + getNumeroIOC() +
            ", libelleIOC='" + getLibelleIOC() + "'" +
            "}";
    }
}
