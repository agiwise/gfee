package ma.iam.wissal.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link ma.iam.wissal.domain.Fournisseur} entity.
 */
public class FournisseurDTO implements Serializable {

    private Long id;

    private String libelle;

    private Long idDLC;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Long getIdDLC() {
        return idDLC;
    }

    public void setIdDLC(Long idDLC) {
        this.idDLC = idDLC;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FournisseurDTO)) {
            return false;
        }

        FournisseurDTO fournisseurDTO = (FournisseurDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, fournisseurDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "FournisseurDTO{" +
            "id=" + getId() +
            ", libelle='" + getLibelle() + "'" +
            ", idDLC=" + getIdDLC() +
            "}";
    }
}
