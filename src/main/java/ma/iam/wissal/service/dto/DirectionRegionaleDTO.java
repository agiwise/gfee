package ma.iam.wissal.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link ma.iam.wissal.domain.DirectionRegionale} entity.
 */
public class DirectionRegionaleDTO implements Serializable {

    private Long id;

    private String libelle;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DirectionRegionaleDTO)) {
            return false;
        }

        DirectionRegionaleDTO directionRegionaleDTO = (DirectionRegionaleDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, directionRegionaleDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DirectionRegionaleDTO{" +
            "id=" + getId() +
            ", libelle='" + getLibelle() + "'" +
            "}";
    }
}
