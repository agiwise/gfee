package ma.iam.wissal.gfee.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * A MemoireDLC.
 */
@Entity
@Table(name = "gest_redev_memoire_dlc")
public class MemoireDLC implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "idMemoireDLC")
    private Long id;

    @Column(name = "codememoire")
    private Long codeMemoire;

    @Column(name = "libelledirection")
    private String libelleDirection;

    @Column(name = "libelledlc")
    private String libelleDLC;

    @Column(name = "statutmemoire")
    private String statutMemoire;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public MemoireDLC id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCodeMemoire() {
        return this.codeMemoire;
    }

    public MemoireDLC codeMemoire(Long codeMemoire) {
        this.setCodeMemoire(codeMemoire);
        return this;
    }

    public void setCodeMemoire(Long codeMemoire) {
        this.codeMemoire = codeMemoire;
    }

    public String getLibelleDirection() {
        return this.libelleDirection;
    }

    public MemoireDLC libelleDirection(String libelleDirection) {
        this.setLibelleDirection(libelleDirection);
        return this;
    }

    public void setLibelleDirection(String libelleDirection) {
        this.libelleDirection = libelleDirection;
    }

    public String getLibelleDLC() {
        return this.libelleDLC;
    }

    public MemoireDLC libelleDLC(String libelleDLC) {
        this.setLibelleDLC(libelleDLC);
        return this;
    }

    public void setLibelleDLC(String libelleDLC) {
        this.libelleDLC = libelleDLC;
    }

    public String getStatutMemoire() {
        return this.statutMemoire;
    }

    public MemoireDLC statutMemoire(String statutMemoire) {
        this.setStatutMemoire(statutMemoire);
        return this;
    }

    public void setStatutMemoire(String statutMemoire) {
        this.statutMemoire = statutMemoire;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MemoireDLC)) {
            return false;
        }
        return id != null && id.equals(((MemoireDLC) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "MemoireDLC{" +
            "id=" + getId() +
            ", codeMemoire=" + getCodeMemoire() +
            ", libelleDirection='" + getLibelleDirection() + "'" +
            ", libelleDLC='" + getLibelleDLC() + "'" +
            ", statutMemoire='" + getStatutMemoire() + "'" +
            "}";
    }
}
