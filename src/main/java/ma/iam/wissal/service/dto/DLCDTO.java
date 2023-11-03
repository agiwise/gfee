package ma.iam.wissal.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link ma.iam.wissal.domain.DLC} entity.
 */
public class DLCDTO implements Serializable {

    private Long id;

    private String libelle;

    private Long idDirectionRegionale;

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

    public Long getIdDirectionRegionale() {
        return idDirectionRegionale;
    }

    public void setIdDirectionRegionale(Long idDirectionRegionale) {
        this.idDirectionRegionale = idDirectionRegionale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DLCDTO)) {
            return false;
        }

        DLCDTO dLCDTO = (DLCDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, dLCDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DLCDTO{" +
            "id=" + getId() +
            ", libelle='" + getLibelle() + "'" +
            ", idDirectionRegionale=" + getIdDirectionRegionale() +
            "}";
    }
}
