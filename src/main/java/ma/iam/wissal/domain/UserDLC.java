package ma.iam.wissal.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * A UserDLC.
 */
@Entity
@Table(name = "user_dlc")
public class UserDLC implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "id_user_liferay")
    private Long idUserLiferay;

    @Column(name = "id_dlc")
    private Long idDLC;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public UserDLC id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUserLiferay() {
        return this.idUserLiferay;
    }

    public UserDLC idUserLiferay(Long idUserLiferay) {
        this.setIdUserLiferay(idUserLiferay);
        return this;
    }

    public void setIdUserLiferay(Long idUserLiferay) {
        this.idUserLiferay = idUserLiferay;
    }

    public Long getIdDLC() {
        return this.idDLC;
    }

    public UserDLC idDLC(Long idDLC) {
        this.setIdDLC(idDLC);
        return this;
    }

    public void setIdDLC(Long idDLC) {
        this.idDLC = idDLC;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserDLC)) {
            return false;
        }
        return id != null && id.equals(((UserDLC) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "UserDLC{" +
            "id=" + getId() +
            ", idUserLiferay=" + getIdUserLiferay() +
            ", idDLC=" + getIdDLC() +
            "}";
    }
}
