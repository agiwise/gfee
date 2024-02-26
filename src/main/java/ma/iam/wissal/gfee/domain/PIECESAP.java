package ma.iam.wissal.gfee.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * A PIECESAP.
 */
@Entity
@Table(name = "gest_redev_piecesap")
public class PIECESAP implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "idPieceSap")
    private Long id;

    @Column(name = "iddlc")
    private Long idDLC;

    @Column(name = "iddirectionregionale")
    private Long idDirectionRegionale;

    @Column(name = "idfournisseur")
    private Long idFournisseur;

    @Column(name = "statutpiecesap")
    private String statutPieceSAP;

    @Column(name = "libelle")
    private String libelle;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public PIECESAP id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdDLC() {
        return this.idDLC;
    }

    public PIECESAP idDLC(Long idDLC) {
        this.setIdDLC(idDLC);
        return this;
    }

    public void setIdDLC(Long idDLC) {
        this.idDLC = idDLC;
    }

    public Long getIdDirectionRegionale() {
        return this.idDirectionRegionale;
    }

    public PIECESAP idDirectionRegionale(Long idDirectionRegionale) {
        this.setIdDirectionRegionale(idDirectionRegionale);
        return this;
    }

    public void setIdDirectionRegionale(Long idDirectionRegionale) {
        this.idDirectionRegionale = idDirectionRegionale;
    }

    public Long getIdFournisseur() {
        return this.idFournisseur;
    }

    public PIECESAP idFournisseur(Long idFournisseur) {
        this.setIdFournisseur(idFournisseur);
        return this;
    }

    public void setIdFournisseur(Long idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    public String getStatutPieceSAP() {
        return this.statutPieceSAP;
    }

    public PIECESAP statutPieceSAP(String statutPieceSAP) {
        this.setStatutPieceSAP(statutPieceSAP);
        return this;
    }

    public void setStatutPieceSAP(String statutPieceSAP) {
        this.statutPieceSAP = statutPieceSAP;
    }

    public String getLibelle() {
        return this.libelle;
    }

    public PIECESAP libelle(String libelle) {
        this.setLibelle(libelle);
        return this;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PIECESAP)) {
            return false;
        }
        return id != null && id.equals(((PIECESAP) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PIECESAP{" +
            "id=" + getId() +
            ", idDLC=" + getIdDLC() +
            ", idDirectionRegionale=" + getIdDirectionRegionale() +
            ", idFournisseur=" + getIdFournisseur() +
            ", statutPieceSAP='" + getStatutPieceSAP() + "'" +
            ", libelle='" + getLibelle() + "'" +
            "}";
    }
}
