package ma.iam.wissal.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;

/**
 * A IndexReel.
 */
@Entity
@Table(name = "gest_redev_index_reel")
public class IndexReel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "numero_ioc")
    private String numeroIOC;

    @Column(name = "date_debut_conso")
    private LocalDate dateDebutConso;

    @Column(name = "date_fin_conso")
    private LocalDate dateFinConso;

    @Column(name = "index_debut")
    private Long indexDebut;

    @Column(name = "index_fin")
    private Long indexFin;

    @Column(name = "date_visite")
    private LocalDate dateVisite;

    @Column(name = "date_creation")
    private LocalDate dateCreation;

    @Column(name = "id_user_creation")
    private Long idUserCreation;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public IndexReel id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroIOC() {
        return this.numeroIOC;
    }

    public IndexReel numeroIOC(String numeroIOC) {
        this.setNumeroIOC(numeroIOC);
        return this;
    }

    public void setNumeroIOC(String numeroIOC) {
        this.numeroIOC = numeroIOC;
    }

    public LocalDate getDateDebutConso() {
        return this.dateDebutConso;
    }

    public IndexReel dateDebutConso(LocalDate dateDebutConso) {
        this.setDateDebutConso(dateDebutConso);
        return this;
    }

    public void setDateDebutConso(LocalDate dateDebutConso) {
        this.dateDebutConso = dateDebutConso;
    }

    public LocalDate getDateFinConso() {
        return this.dateFinConso;
    }

    public IndexReel dateFinConso(LocalDate dateFinConso) {
        this.setDateFinConso(dateFinConso);
        return this;
    }

    public void setDateFinConso(LocalDate dateFinConso) {
        this.dateFinConso = dateFinConso;
    }

    public Long getIndexDebut() {
        return this.indexDebut;
    }

    public IndexReel indexDebut(Long indexDebut) {
        this.setIndexDebut(indexDebut);
        return this;
    }

    public void setIndexDebut(Long indexDebut) {
        this.indexDebut = indexDebut;
    }

    public Long getIndexFin() {
        return this.indexFin;
    }

    public IndexReel indexFin(Long indexFin) {
        this.setIndexFin(indexFin);
        return this;
    }

    public void setIndexFin(Long indexFin) {
        this.indexFin = indexFin;
    }

    public LocalDate getDateVisite() {
        return this.dateVisite;
    }

    public IndexReel dateVisite(LocalDate dateVisite) {
        this.setDateVisite(dateVisite);
        return this;
    }

    public void setDateVisite(LocalDate dateVisite) {
        this.dateVisite = dateVisite;
    }

    public LocalDate getDateCreation() {
        return this.dateCreation;
    }

    public IndexReel dateCreation(LocalDate dateCreation) {
        this.setDateCreation(dateCreation);
        return this;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Long getIdUserCreation() {
        return this.idUserCreation;
    }

    public IndexReel idUserCreation(Long idUserCreation) {
        this.setIdUserCreation(idUserCreation);
        return this;
    }

    public void setIdUserCreation(Long idUserCreation) {
        this.idUserCreation = idUserCreation;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof IndexReel)) {
            return false;
        }
        return id != null && id.equals(((IndexReel) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "IndexReel{" +
            "id=" + getId() +
            ", numeroIOC='" + getNumeroIOC() + "'" +
            ", dateDebutConso='" + getDateDebutConso() + "'" +
            ", dateFinConso='" + getDateFinConso() + "'" +
            ", indexDebut=" + getIndexDebut() +
            ", indexFin=" + getIndexFin() +
            ", dateVisite='" + getDateVisite() + "'" +
            ", dateCreation='" + getDateCreation() + "'" +
            ", idUserCreation=" + getIdUserCreation() +
            "}";
    }
}
