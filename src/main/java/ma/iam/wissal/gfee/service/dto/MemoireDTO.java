package ma.iam.wissal.gfee.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link ma.iam.wissal.gfee.domain.Memoire} entity.
 */
public class MemoireDTO implements Serializable {

    private Long id;

    private String codeMemoire;

    private String intituleMemoire;

    private LocalDate dateMemoire;

    private Long idFournisseur;

    private Long idDLC;

    private Long idVille;

    private Double montantTTC;

    private Double montantTVA7;

    private Double montantHT7;

    private Double montantTVA14;

    private Double montantHT14;

    private Double montantTVA20;

    private Double montantHT20;

    private Double montantTvaManue;

    private Double diversesTaxes;

    private LocalDate dateComptable;

    private Long numPieceSap;

    private Long numOv;

    private LocalDate dateComptableReelle;

    private LocalDate dateOV;

    private String statutMemoire;

    private LocalDate dateCreation;

    private LocalDate dateValidation;

    private LocalDate dateRejet;

    private LocalDate dateComptabilisation;

    private LocalDate datePaiement;

    private LocalDate dateDevalidation;

    private LocalDate dateModification;

    private String motifRejet;

    private Long idUserCreation;

    private Long idUserValidation;

    private Long idUserRejet;

    private Long idUserComptabilisation;

    private Long idUserPaiement;

    private Long idUserDevalidation;

    private Long idUserModification;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeMemoire() {
        return codeMemoire;
    }

    public void setCodeMemoire(String codeMemoire) {
        this.codeMemoire = codeMemoire;
    }

    public String getIntituleMemoire() {
        return intituleMemoire;
    }

    public void setIntituleMemoire(String intituleMemoire) {
        this.intituleMemoire = intituleMemoire;
    }

    public LocalDate getDateMemoire() {
        return dateMemoire;
    }

    public void setDateMemoire(LocalDate dateMemoire) {
        this.dateMemoire = dateMemoire;
    }

    public Long getIdFournisseur() {
        return idFournisseur;
    }

    public void setIdFournisseur(Long idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    public Long getIdDLC() {
        return idDLC;
    }

    public void setIdDLC(Long idDLC) {
        this.idDLC = idDLC;
    }

    public Long getIdVille() {
        return idVille;
    }

    public void setIdVille(Long idVille) {
        this.idVille = idVille;
    }

    public Double getMontantTTC() {
        return montantTTC;
    }

    public void setMontantTTC(Double montantTTC) {
        this.montantTTC = montantTTC;
    }

    public Double getMontantTVA7() {
        return montantTVA7;
    }

    public void setMontantTVA7(Double montantTVA7) {
        this.montantTVA7 = montantTVA7;
    }

    public Double getMontantHT7() {
        return montantHT7;
    }

    public void setMontantHT7(Double montantHT7) {
        this.montantHT7 = montantHT7;
    }

    public Double getMontantTVA14() {
        return montantTVA14;
    }

    public void setMontantTVA14(Double montantTVA14) {
        this.montantTVA14 = montantTVA14;
    }

    public Double getMontantHT14() {
        return montantHT14;
    }

    public void setMontantHT14(Double montantHT14) {
        this.montantHT14 = montantHT14;
    }

    public Double getMontantTVA20() {
        return montantTVA20;
    }

    public void setMontantTVA20(Double montantTVA20) {
        this.montantTVA20 = montantTVA20;
    }

    public Double getMontantHT20() {
        return montantHT20;
    }

    public void setMontantHT20(Double montantHT20) {
        this.montantHT20 = montantHT20;
    }

    public Double getMontantTvaManue() {
        return montantTvaManue;
    }

    public void setMontantTvaManue(Double montantTvaManue) {
        this.montantTvaManue = montantTvaManue;
    }

    public Double getDiversesTaxes() {
        return diversesTaxes;
    }

    public void setDiversesTaxes(Double diversesTaxes) {
        this.diversesTaxes = diversesTaxes;
    }

    public LocalDate getDateComptable() {
        return dateComptable;
    }

    public void setDateComptable(LocalDate dateComptable) {
        this.dateComptable = dateComptable;
    }

    public Long getNumPieceSap() {
        return numPieceSap;
    }

    public void setNumPieceSap(Long numPieceSap) {
        this.numPieceSap = numPieceSap;
    }

    public Long getNumOv() {
        return numOv;
    }

    public void setNumOv(Long numOv) {
        this.numOv = numOv;
    }

    public LocalDate getDateComptableReelle() {
        return dateComptableReelle;
    }

    public void setDateComptableReelle(LocalDate dateComptableReelle) {
        this.dateComptableReelle = dateComptableReelle;
    }

    public LocalDate getDateOV() {
        return dateOV;
    }

    public void setDateOV(LocalDate dateOV) {
        this.dateOV = dateOV;
    }

    public String getStatutMemoire() {
        return statutMemoire;
    }

    public void setStatutMemoire(String statutMemoire) {
        this.statutMemoire = statutMemoire;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalDate getDateValidation() {
        return dateValidation;
    }

    public void setDateValidation(LocalDate dateValidation) {
        this.dateValidation = dateValidation;
    }

    public LocalDate getDateRejet() {
        return dateRejet;
    }

    public void setDateRejet(LocalDate dateRejet) {
        this.dateRejet = dateRejet;
    }

    public LocalDate getDateComptabilisation() {
        return dateComptabilisation;
    }

    public void setDateComptabilisation(LocalDate dateComptabilisation) {
        this.dateComptabilisation = dateComptabilisation;
    }

    public LocalDate getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(LocalDate datePaiement) {
        this.datePaiement = datePaiement;
    }

    public LocalDate getDateDevalidation() {
        return dateDevalidation;
    }

    public void setDateDevalidation(LocalDate dateDevalidation) {
        this.dateDevalidation = dateDevalidation;
    }

    public LocalDate getDateModification() {
        return dateModification;
    }

    public void setDateModification(LocalDate dateModification) {
        this.dateModification = dateModification;
    }

    public String getMotifRejet() {
        return motifRejet;
    }

    public void setMotifRejet(String motifRejet) {
        this.motifRejet = motifRejet;
    }

    public Long getIdUserCreation() {
        return idUserCreation;
    }

    public void setIdUserCreation(Long idUserCreation) {
        this.idUserCreation = idUserCreation;
    }

    public Long getIdUserValidation() {
        return idUserValidation;
    }

    public void setIdUserValidation(Long idUserValidation) {
        this.idUserValidation = idUserValidation;
    }

    public Long getIdUserRejet() {
        return idUserRejet;
    }

    public void setIdUserRejet(Long idUserRejet) {
        this.idUserRejet = idUserRejet;
    }

    public Long getIdUserComptabilisation() {
        return idUserComptabilisation;
    }

    public void setIdUserComptabilisation(Long idUserComptabilisation) {
        this.idUserComptabilisation = idUserComptabilisation;
    }

    public Long getIdUserPaiement() {
        return idUserPaiement;
    }

    public void setIdUserPaiement(Long idUserPaiement) {
        this.idUserPaiement = idUserPaiement;
    }

    public Long getIdUserDevalidation() {
        return idUserDevalidation;
    }

    public void setIdUserDevalidation(Long idUserDevalidation) {
        this.idUserDevalidation = idUserDevalidation;
    }

    public Long getIdUserModification() {
        return idUserModification;
    }

    public void setIdUserModification(Long idUserModification) {
        this.idUserModification = idUserModification;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MemoireDTO)) {
            return false;
        }

        MemoireDTO memoireDTO = (MemoireDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, memoireDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "MemoireDTO{" +
            "id=" + getId() +
            ", codeMemoire='" + getCodeMemoire() + "'" +
            ", intituleMemoire='" + getIntituleMemoire() + "'" +
            ", dateMemoire='" + getDateMemoire() + "'" +
            ", idFournisseur=" + getIdFournisseur() +
            ", idDLC=" + getIdDLC() +
            ", idVille=" + getIdVille() +
            ", montantTTC=" + getMontantTTC() +
            ", montantTVA7=" + getMontantTVA7() +
            ", montantHT7=" + getMontantHT7() +
            ", montantTVA14=" + getMontantTVA14() +
            ", montantHT14=" + getMontantHT14() +
            ", montantTVA20=" + getMontantTVA20() +
            ", montantHT20=" + getMontantHT20() +
            ", montantTvaManue=" + getMontantTvaManue() +
            ", diversesTaxes=" + getDiversesTaxes() +
            ", dateComptable='" + getDateComptable() + "'" +
            ", numPieceSap=" + getNumPieceSap() +
            ", numOv=" + getNumOv() +
            ", dateComptableReelle='" + getDateComptableReelle() + "'" +
            ", dateOV='" + getDateOV() + "'" +
            ", statutMemoire='" + getStatutMemoire() + "'" +
            ", dateCreation='" + getDateCreation() + "'" +
            ", dateValidation='" + getDateValidation() + "'" +
            ", dateRejet='" + getDateRejet() + "'" +
            ", dateComptabilisation='" + getDateComptabilisation() + "'" +
            ", datePaiement='" + getDatePaiement() + "'" +
            ", dateDevalidation='" + getDateDevalidation() + "'" +
            ", dateModification='" + getDateModification() + "'" +
            ", motifRejet='" + getMotifRejet() + "'" +
            ", idUserCreation=" + getIdUserCreation() +
            ", idUserValidation=" + getIdUserValidation() +
            ", idUserRejet=" + getIdUserRejet() +
            ", idUserComptabilisation=" + getIdUserComptabilisation() +
            ", idUserPaiement=" + getIdUserPaiement() +
            ", idUserDevalidation=" + getIdUserDevalidation() +
            ", idUserModification=" + getIdUserModification() +
            "}";
    }
}
