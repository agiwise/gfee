package ma.iam.wissal.gfee.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * A DLC.
 */
@Entity
@Table(name = "gest_redev_dlc")
public class DLC implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "idDLC")
    private Long id;

    @Column(name = "libelle")
    private String libelle;

    @Column(name = "iddirectionregionale")
    private Long idDirectionRegionale;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public DLC id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return this.libelle;
    }

    public DLC libelle(String libelle) {
        this.setLibelle(libelle);
        return this;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Long getIdDirectionRegionale() {
        return this.idDirectionRegionale;
    }

    public DLC idDirectionRegionale(Long idDirectionRegionale) {
        this.setIdDirectionRegionale(idDirectionRegionale);
        return this;
    }

    public void setIdDirectionRegionale(Long idDirectionRegionale) {
        this.idDirectionRegionale = idDirectionRegionale;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DLC)) {
            return false;
        }
        return id != null && id.equals(((DLC) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DLC{" +
            "id=" + getId() +
            ", libelle='" + getLibelle() + "'" +
            ", idDirectionRegionale=" + getIdDirectionRegionale() +
            "}";
    }
}
