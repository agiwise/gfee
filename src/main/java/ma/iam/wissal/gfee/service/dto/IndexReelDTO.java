package ma.iam.wissal.gfee.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link ma.iam.wissal.gfee.domain.IndexReel} entity.
 */
public class IndexReelDTO implements Serializable {

    private Long id;

    private String numeroIOC;

    private LocalDate dateDebutConso;

    private LocalDate dateFinConso;

    private Long indexDebut;

    private Long indexFin;

    private LocalDate dateVisite;

    private LocalDate dateCreation;

    private Long idUserCreation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroIOC() {
        return numeroIOC;
    }

    public void setNumeroIOC(String numeroIOC) {
        this.numeroIOC = numeroIOC;
    }

    public LocalDate getDateDebutConso() {
        return dateDebutConso;
    }

    public void setDateDebutConso(LocalDate dateDebutConso) {
        this.dateDebutConso = dateDebutConso;
    }

    public LocalDate getDateFinConso() {
        return dateFinConso;
    }

    public void setDateFinConso(LocalDate dateFinConso) {
        this.dateFinConso = dateFinConso;
    }

    public Long getIndexDebut() {
        return indexDebut;
    }

    public void setIndexDebut(Long indexDebut) {
        this.indexDebut = indexDebut;
    }

    public Long getIndexFin() {
        return indexFin;
    }

    public void setIndexFin(Long indexFin) {
        this.indexFin = indexFin;
    }

    public LocalDate getDateVisite() {
        return dateVisite;
    }

    public void setDateVisite(LocalDate dateVisite) {
        this.dateVisite = dateVisite;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Long getIdUserCreation() {
        return idUserCreation;
    }

    public void setIdUserCreation(Long idUserCreation) {
        this.idUserCreation = idUserCreation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof IndexReelDTO)) {
            return false;
        }

        IndexReelDTO indexReelDTO = (IndexReelDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, indexReelDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "IndexReelDTO{" +
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
