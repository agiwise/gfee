package ma.iam.wissal.gfee.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link ma.iam.wissal.gfee.domain.MemoireDLC} entity.
 */
public class MemoireDLCDTO implements Serializable {

    private Long id;

    private Long codeMemoire;

    private String libelleDirection;

    private String libelleDLC;

    private String statutMemoire;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCodeMemoire() {
        return codeMemoire;
    }

    public void setCodeMemoire(Long codeMemoire) {
        this.codeMemoire = codeMemoire;
    }

    public String getLibelleDirection() {
        return libelleDirection;
    }

    public void setLibelleDirection(String libelleDirection) {
        this.libelleDirection = libelleDirection;
    }

    public String getLibelleDLC() {
        return libelleDLC;
    }

    public void setLibelleDLC(String libelleDLC) {
        this.libelleDLC = libelleDLC;
    }

    public String getStatutMemoire() {
        return statutMemoire;
    }

    public void setStatutMemoire(String statutMemoire) {
        this.statutMemoire = statutMemoire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MemoireDLCDTO)) {
            return false;
        }

        MemoireDLCDTO memoireDLCDTO = (MemoireDLCDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, memoireDLCDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "MemoireDLCDTO{" +
            "id=" + getId() +
            ", codeMemoire=" + getCodeMemoire() +
            ", libelleDirection='" + getLibelleDirection() + "'" +
            ", libelleDLC='" + getLibelleDLC() + "'" +
            ", statutMemoire='" + getStatutMemoire() + "'" +
            "}";
    }
}
