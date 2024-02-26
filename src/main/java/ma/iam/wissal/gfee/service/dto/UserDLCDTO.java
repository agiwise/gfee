package ma.iam.wissal.gfee.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link ma.iam.wissal.gfee.domain.UserDLC} entity.
 */
public class UserDLCDTO implements Serializable {

    private Long id;

    private Long idUserLiferay;

    private Long idDLC;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUserLiferay() {
        return idUserLiferay;
    }

    public void setIdUserLiferay(Long idUserLiferay) {
        this.idUserLiferay = idUserLiferay;
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
        if (!(o instanceof UserDLCDTO)) {
            return false;
        }

        UserDLCDTO userDLCDTO = (UserDLCDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, userDLCDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "UserDLCDTO{" +
            "id=" + getId() +
            ", idUserLiferay=" + getIdUserLiferay() +
            ", idDLC=" + getIdDLC() +
            "}";
    }
}
