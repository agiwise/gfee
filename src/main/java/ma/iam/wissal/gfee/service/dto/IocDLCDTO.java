package ma.iam.wissal.gfee.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link ma.iam.wissal.gfee.domain.IocDLC} entity.
 */
public class IocDLCDTO implements Serializable {

    private Long id;

    private Long idIOC;

    private Long numeroIOC;

    private String libelleIOC;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdIOC() {
        return idIOC;
    }

    public void setIdIOC(Long idIOC) {
        this.idIOC = idIOC;
    }

    public Long getNumeroIOC() {
        return numeroIOC;
    }

    public void setNumeroIOC(Long numeroIOC) {
        this.numeroIOC = numeroIOC;
    }

    public String getLibelleIOC() {
        return libelleIOC;
    }

    public void setLibelleIOC(String libelleIOC) {
        this.libelleIOC = libelleIOC;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof IocDLCDTO)) {
            return false;
        }

        IocDLCDTO iocDLCDTO = (IocDLCDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, iocDLCDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "IocDLCDTO{" +
            "id=" + getId() +
            ", idIOC=" + getIdIOC() +
            ", numeroIOC=" + getNumeroIOC() +
            ", libelleIOC='" + getLibelleIOC() + "'" +
            "}";
    }
}
