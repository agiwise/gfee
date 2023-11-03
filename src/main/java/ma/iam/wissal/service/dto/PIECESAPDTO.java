package ma.iam.wissal.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link ma.iam.wissal.domain.PIECESAP} entity.
 */
public class PIECESAPDTO implements Serializable {

    private Long id;

    private Long idDLC;

    private Long idDirectionRegionale;

    private Long idFournisseur;

    private String statutPieceSAP;

    private String libelle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdDLC() {
        return idDLC;
    }

    public void setIdDLC(Long idDLC) {
        this.idDLC = idDLC;
    }

    public Long getIdDirectionRegionale() {
        return idDirectionRegionale;
    }

    public void setIdDirectionRegionale(Long idDirectionRegionale) {
        this.idDirectionRegionale = idDirectionRegionale;
    }

    public Long getIdFournisseur() {
        return idFournisseur;
    }

    public void setIdFournisseur(Long idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    public String getStatutPieceSAP() {
        return statutPieceSAP;
    }

    public void setStatutPieceSAP(String statutPieceSAP) {
        this.statutPieceSAP = statutPieceSAP;
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
        if (!(o instanceof PIECESAPDTO)) {
            return false;
        }

        PIECESAPDTO pIECESAPDTO = (PIECESAPDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, pIECESAPDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PIECESAPDTO{" +
            "id=" + getId() +
            ", idDLC=" + getIdDLC() +
            ", idDirectionRegionale=" + getIdDirectionRegionale() +
            ", idFournisseur=" + getIdFournisseur() +
            ", statutPieceSAP='" + getStatutPieceSAP() + "'" +
            ", libelle='" + getLibelle() + "'" +
            "}";
    }
}
