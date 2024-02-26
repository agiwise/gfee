package ma.iam.wissal.gfee.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;

/**
 * A Memoire.
 */
@Entity
@Table(name = "gest_redev_memoire")
public class Memoire implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "idMemoire")
    private Long id;

    @Column(name = "codememoire")
    private String codeMemoire;

    @Column(name = "intitulememoire")
    private String intituleMemoire;

    @Column(name = "datememoire")
    private LocalDate dateMemoire;

    @Column(name = "idfournisseur")
    private Long idFournisseur;

    @Column(name = "iddlc")
    private Long idDLC;

    @Column(name = "idville")
    private Long idVille;

    @Column(name = "montantttc")
    private Double montantTTC;

    @Column(name = "montanttva7")
    private Double montantTVA7;

    @Column(name = "montantht7")
    private Double montantHT7;

    @Column(name = "montanttva14")
    private Double montantTVA14;

    @Column(name = "montantht14")
    private Double montantHT14;

    @Column(name = "montanttva20")
    private Double montantTVA20;

    @Column(name = "montantht20")
    private Double montantHT20;

    @Column(name = "montanttvamanue")
    private Double montantTvaManue;

    @Column(name = "diversestaxes")
    private Double diversesTaxes;

    @Column(name = "datecomptable")
    private LocalDate dateComptable;

    @Column(name = "numpiecesap")
    private Long numPieceSap;

    @Column(name = "numov")
    private Long numOv;

    @Column(name = "datecomptablereelle")
    private LocalDate dateComptableReelle;

    @Column(name = "dateov")
    private LocalDate dateOV;

    @Column(name = "statutmemoire")
    private String statutMemoire;

    @Column(name = "datecreation")
    private LocalDate dateCreation;

    @Column(name = "datevalidation")
    private LocalDate dateValidation;

    @Column(name = "daterejet")
    private LocalDate dateRejet;

    @Column(name = "datecomptabilisation")
    private LocalDate dateComptabilisation;

    @Column(name = "datepaiement")
    private LocalDate datePaiement;

    @Column(name = "datedevalidation")
    private LocalDate dateDevalidation;

    @Column(name = "datemodification")
    private LocalDate dateModification;

    @Column(name = "motifrejet")
    private String motifRejet;

    @Column(name = "idusercreation")
    private Long idUserCreation;

    @Column(name = "iduservalidation")
    private Long idUserValidation;

    @Column(name = "iduserrejet")
    private Long idUserRejet;

    @Column(name = "idusercomptabilisation")
    private Long idUserComptabilisation;

    @Column(name = "iduserpaiement")
    private Long idUserPaiement;

    @Column(name = "iduserdevalidation")
    private Long idUserDevalidation;

    @Column(name = "idusermodification")
    private Long idUserModification;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Memoire id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeMemoire() {
        return this.codeMemoire;
    }

    public Memoire codeMemoire(String codeMemoire) {
        this.setCodeMemoire(codeMemoire);
        return this;
    }

    public void setCodeMemoire(String codeMemoire) {
        this.codeMemoire = codeMemoire;
    }

    public String getIntituleMemoire() {
        return this.intituleMemoire;
    }

    public Memoire intituleMemoire(String intituleMemoire) {
        this.setIntituleMemoire(intituleMemoire);
        return this;
    }

    public void setIntituleMemoire(String intituleMemoire) {
        this.intituleMemoire = intituleMemoire;
    }

    public LocalDate getDateMemoire() {
        return this.dateMemoire;
    }

    public Memoire dateMemoire(LocalDate dateMemoire) {
        this.setDateMemoire(dateMemoire);
        return this;
    }

    public void setDateMemoire(LocalDate dateMemoire) {
        this.dateMemoire = dateMemoire;
    }

    public Long getIdFournisseur() {
        return this.idFournisseur;
    }

    public Memoire idFournisseur(Long idFournisseur) {
        this.setIdFournisseur(idFournisseur);
        return this;
    }

    public void setIdFournisseur(Long idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    public Long getIdDLC() {
        return this.idDLC;
    }

    public Memoire idDLC(Long idDLC) {
        this.setIdDLC(idDLC);
        return this;
    }

    public void setIdDLC(Long idDLC) {
        this.idDLC = idDLC;
    }

    public Long getIdVille() {
        return this.idVille;
    }

    public Memoire idVille(Long idVille) {
        this.setIdVille(idVille);
        return this;
    }

    public void setIdVille(Long idVille) {
        this.idVille = idVille;
    }

    public Double getMontantTTC() {
        return this.montantTTC;
    }

    public Memoire montantTTC(Double montantTTC) {
        this.setMontantTTC(montantTTC);
        return this;
    }

    public void setMontantTTC(Double montantTTC) {
        this.montantTTC = montantTTC;
    }

    public Double getMontantTVA7() {
        return this.montantTVA7;
    }

    public Memoire montantTVA7(Double montantTVA7) {
        this.setMontantTVA7(montantTVA7);
        return this;
    }

    public void setMontantTVA7(Double montantTVA7) {
        this.montantTVA7 = montantTVA7;
    }

    public Double getMontantHT7() {
        return this.montantHT7;
    }

    public Memoire montantHT7(Double montantHT7) {
        this.setMontantHT7(montantHT7);
        return this;
    }

    public void setMontantHT7(Double montantHT7) {
        this.montantHT7 = montantHT7;
    }

    public Double getMontantTVA14() {
        return this.montantTVA14;
    }

    public Memoire montantTVA14(Double montantTVA14) {
        this.setMontantTVA14(montantTVA14);
        return this;
    }

    public void setMontantTVA14(Double montantTVA14) {
        this.montantTVA14 = montantTVA14;
    }

    public Double getMontantHT14() {
        return this.montantHT14;
    }

    public Memoire montantHT14(Double montantHT14) {
        this.setMontantHT14(montantHT14);
        return this;
    }

    public void setMontantHT14(Double montantHT14) {
        this.montantHT14 = montantHT14;
    }

    public Double getMontantTVA20() {
        return this.montantTVA20;
    }

    public Memoire montantTVA20(Double montantTVA20) {
        this.setMontantTVA20(montantTVA20);
        return this;
    }

    public void setMontantTVA20(Double montantTVA20) {
        this.montantTVA20 = montantTVA20;
    }

    public Double getMontantHT20() {
        return this.montantHT20;
    }

    public Memoire montantHT20(Double montantHT20) {
        this.setMontantHT20(montantHT20);
        return this;
    }

    public void setMontantHT20(Double montantHT20) {
        this.montantHT20 = montantHT20;
    }

    public Double getMontantTvaManue() {
        return this.montantTvaManue;
    }

    public Memoire montantTvaManue(Double montantTvaManue) {
        this.setMontantTvaManue(montantTvaManue);
        return this;
    }

    public void setMontantTvaManue(Double montantTvaManue) {
        this.montantTvaManue = montantTvaManue;
    }

    public Double getDiversesTaxes() {
        return this.diversesTaxes;
    }

    public Memoire diversesTaxes(Double diversesTaxes) {
        this.setDiversesTaxes(diversesTaxes);
        return this;
    }

    public void setDiversesTaxes(Double diversesTaxes) {
        this.diversesTaxes = diversesTaxes;
    }

    public LocalDate getDateComptable() {
        return this.dateComptable;
    }

    public Memoire dateComptable(LocalDate dateComptable) {
        this.setDateComptable(dateComptable);
        return this;
    }

    public void setDateComptable(LocalDate dateComptable) {
        this.dateComptable = dateComptable;
    }

    public Long getNumPieceSap() {
        return this.numPieceSap;
    }

    public Memoire numPieceSap(Long numPieceSap) {
        this.setNumPieceSap(numPieceSap);
        return this;
    }

    public void setNumPieceSap(Long numPieceSap) {
        this.numPieceSap = numPieceSap;
    }

    public Long getNumOv() {
        return this.numOv;
    }

    public Memoire numOv(Long numOv) {
        this.setNumOv(numOv);
        return this;
    }

    public void setNumOv(Long numOv) {
        this.numOv = numOv;
    }

    public LocalDate getDateComptableReelle() {
        return this.dateComptableReelle;
    }

    public Memoire dateComptableReelle(LocalDate dateComptableReelle) {
        this.setDateComptableReelle(dateComptableReelle);
        return this;
    }

    public void setDateComptableReelle(LocalDate dateComptableReelle) {
        this.dateComptableReelle = dateComptableReelle;
    }

    public LocalDate getDateOV() {
        return this.dateOV;
    }

    public Memoire dateOV(LocalDate dateOV) {
        this.setDateOV(dateOV);
        return this;
    }

    public void setDateOV(LocalDate dateOV) {
        this.dateOV = dateOV;
    }

    public String getStatutMemoire() {
        return this.statutMemoire;
    }

    public Memoire statutMemoire(String statutMemoire) {
        this.setStatutMemoire(statutMemoire);
        return this;
    }

    public void setStatutMemoire(String statutMemoire) {
        this.statutMemoire = statutMemoire;
    }

    public LocalDate getDateCreation() {
        return this.dateCreation;
    }

    public Memoire dateCreation(LocalDate dateCreation) {
        this.setDateCreation(dateCreation);
        return this;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalDate getDateValidation() {
        return this.dateValidation;
    }

    public Memoire dateValidation(LocalDate dateValidation) {
        this.setDateValidation(dateValidation);
        return this;
    }

    public void setDateValidation(LocalDate dateValidation) {
        this.dateValidation = dateValidation;
    }

    public LocalDate getDateRejet() {
        return this.dateRejet;
    }

    public Memoire dateRejet(LocalDate dateRejet) {
        this.setDateRejet(dateRejet);
        return this;
    }

    public void setDateRejet(LocalDate dateRejet) {
        this.dateRejet = dateRejet;
    }

    public LocalDate getDateComptabilisation() {
        return this.dateComptabilisation;
    }

    public Memoire dateComptabilisation(LocalDate dateComptabilisation) {
        this.setDateComptabilisation(dateComptabilisation);
        return this;
    }

    public void setDateComptabilisation(LocalDate dateComptabilisation) {
        this.dateComptabilisation = dateComptabilisation;
    }

    public LocalDate getDatePaiement() {
        return this.datePaiement;
    }

    public Memoire datePaiement(LocalDate datePaiement) {
        this.setDatePaiement(datePaiement);
        return this;
    }

    public void setDatePaiement(LocalDate datePaiement) {
        this.datePaiement = datePaiement;
    }

    public LocalDate getDateDevalidation() {
        return this.dateDevalidation;
    }

    public Memoire dateDevalidation(LocalDate dateDevalidation) {
        this.setDateDevalidation(dateDevalidation);
        return this;
    }

    public void setDateDevalidation(LocalDate dateDevalidation) {
        this.dateDevalidation = dateDevalidation;
    }

    public LocalDate getDateModification() {
        return this.dateModification;
    }

    public Memoire dateModification(LocalDate dateModification) {
        this.setDateModification(dateModification);
        return this;
    }

    public void setDateModification(LocalDate dateModification) {
        this.dateModification = dateModification;
    }

    public String getMotifRejet() {
        return this.motifRejet;
    }

    public Memoire motifRejet(String motifRejet) {
        this.setMotifRejet(motifRejet);
        return this;
    }

    public void setMotifRejet(String motifRejet) {
        this.motifRejet = motifRejet;
    }

    public Long getIdUserCreation() {
        return this.idUserCreation;
    }

    public Memoire idUserCreation(Long idUserCreation) {
        this.setIdUserCreation(idUserCreation);
        return this;
    }

    public void setIdUserCreation(Long idUserCreation) {
        this.idUserCreation = idUserCreation;
    }

    public Long getIdUserValidation() {
        return this.idUserValidation;
    }

    public Memoire idUserValidation(Long idUserValidation) {
        this.setIdUserValidation(idUserValidation);
        return this;
    }

    public void setIdUserValidation(Long idUserValidation) {
        this.idUserValidation = idUserValidation;
    }

    public Long getIdUserRejet() {
        return this.idUserRejet;
    }

    public Memoire idUserRejet(Long idUserRejet) {
        this.setIdUserRejet(idUserRejet);
        return this;
    }

    public void setIdUserRejet(Long idUserRejet) {
        this.idUserRejet = idUserRejet;
    }

    public Long getIdUserComptabilisation() {
        return this.idUserComptabilisation;
    }

    public Memoire idUserComptabilisation(Long idUserComptabilisation) {
        this.setIdUserComptabilisation(idUserComptabilisation);
        return this;
    }

    public void setIdUserComptabilisation(Long idUserComptabilisation) {
        this.idUserComptabilisation = idUserComptabilisation;
    }

    public Long getIdUserPaiement() {
        return this.idUserPaiement;
    }

    public Memoire idUserPaiement(Long idUserPaiement) {
        this.setIdUserPaiement(idUserPaiement);
        return this;
    }

    public void setIdUserPaiement(Long idUserPaiement) {
        this.idUserPaiement = idUserPaiement;
    }

    public Long getIdUserDevalidation() {
        return this.idUserDevalidation;
    }

    public Memoire idUserDevalidation(Long idUserDevalidation) {
        this.setIdUserDevalidation(idUserDevalidation);
        return this;
    }

    public void setIdUserDevalidation(Long idUserDevalidation) {
        this.idUserDevalidation = idUserDevalidation;
    }

    public Long getIdUserModification() {
        return this.idUserModification;
    }

    public Memoire idUserModification(Long idUserModification) {
        this.setIdUserModification(idUserModification);
        return this;
    }

    public void setIdUserModification(Long idUserModification) {
        this.idUserModification = idUserModification;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Memoire)) {
            return false;
        }
        return id != null && id.equals(((Memoire) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Memoire{" +
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
