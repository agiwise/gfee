package ma.iam.wissal.gfee.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link ma.iam.wissal.gfee.domain.Facture} entity.
 */
public class FactureDTO implements Serializable {

    private Long id;

    private Long idIOC;

    private Long numeroFacture;

    private LocalDate dateFacture;

    private String codeMemoire;

    private Long idMemoire;

    private Double montantTTC;

    private Integer typeIndex;

    private Long ancienIndex;

    private Long nouvelIndex;

    private LocalDate dateDebutConso;

    private LocalDate dateFinConso;

    private String periodes;

    private String periodeReference;

    private Integer categorieFacture;

    private String puissanceAppelee;

    private Float cosPhi;

    private String rdpc;

    private Long ancienIndexEan;

    private Long nouvelIndexEan;

    private String eaNormale;

    private Long ancienIndexEac;

    private Long nouvelIndexEac;

    private Long eaCreuse;

    private Long ancienIndexEap;

    private Long nouvelIndexEap;

    private String eaPointes;

    private Float energieReactive;

    private Long heuresUtilisees;

    private Long indiceMaximal;

    private LocalDate dateModification;

    private LocalDate dateSuppression;

    private LocalDate dateRendreFactureAs;

    private String statutFacture;

    private LocalDate dateCreation;

    private LocalDate dateValidation;

    private LocalDate dateRejet;

    private Long idUserCreation;

    private Long idUserValidation;

    private Long idUserRejet;

    private Long idUserModification;

    private Long idUserSuppression;

    private Long idUserRendreFactureAs;

    private String observation;

    private String motifRejet;

    private String rejetMotif;

    private Long ancienIndexEa;

    private Long nouvelIndexEa;

    private Long ancienIndexEr;

    private Long nouvelIndexEr;

    private Long ancienIndexHu;

    private Long nouvelIndexHu;

    private Long ancienIndexIm;

    private Long nouvelIndexIm;

    private Double montantTVA7;

    private Double montantHT7;

    private Double montantTVA14;

    private Double montantHT14;

    private Double montantTVA20;

    private Double montantHT20;

    private Double montantTvaManue;

    private Double diversesTaxes;

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

    public Long getNumeroFacture() {
        return numeroFacture;
    }

    public void setNumeroFacture(Long numeroFacture) {
        this.numeroFacture = numeroFacture;
    }

    public LocalDate getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(LocalDate dateFacture) {
        this.dateFacture = dateFacture;
    }

    public String getCodeMemoire() {
        return codeMemoire;
    }

    public void setCodeMemoire(String codeMemoire) {
        this.codeMemoire = codeMemoire;
    }

    public Long getIdMemoire() {
        return idMemoire;
    }

    public void setIdMemoire(Long idMemoire) {
        this.idMemoire = idMemoire;
    }

    public Double getMontantTTC() {
        return montantTTC;
    }

    public void setMontantTTC(Double montantTTC) {
        this.montantTTC = montantTTC;
    }

    public Integer getTypeIndex() {
        return typeIndex;
    }

    public void setTypeIndex(Integer typeIndex) {
        this.typeIndex = typeIndex;
    }

    public Long getAncienIndex() {
        return ancienIndex;
    }

    public void setAncienIndex(Long ancienIndex) {
        this.ancienIndex = ancienIndex;
    }

    public Long getNouvelIndex() {
        return nouvelIndex;
    }

    public void setNouvelIndex(Long nouvelIndex) {
        this.nouvelIndex = nouvelIndex;
    }

    public LocalDate getDateDebutConso() {
        return dateDebutConso;
    }

    public void setDateDebutConso(LocalDate dateDebutConso) {
        this.dateDebutConso = dateDebutConso;
    }

    public LocalDate getDateFinConso() {
        return dateFinConso;
    }

    public void setDateFinConso(LocalDate dateFinConso) {
        this.dateFinConso = dateFinConso;
    }

    public String getPeriodes() {
        return periodes;
    }

    public void setPeriodes(String periodes) {
        this.periodes = periodes;
    }

    public String getPeriodeReference() {
        return periodeReference;
    }

    public void setPeriodeReference(String periodeReference) {
        this.periodeReference = periodeReference;
    }

    public Integer getCategorieFacture() {
        return categorieFacture;
    }

    public void setCategorieFacture(Integer categorieFacture) {
        this.categorieFacture = categorieFacture;
    }

    public String getPuissanceAppelee() {
        return puissanceAppelee;
    }

    public void setPuissanceAppelee(String puissanceAppelee) {
        this.puissanceAppelee = puissanceAppelee;
    }

    public Float getCosPhi() {
        return cosPhi;
    }

    public void setCosPhi(Float cosPhi) {
        this.cosPhi = cosPhi;
    }

    public String getRdpc() {
        return rdpc;
    }

    public void setRdpc(String rdpc) {
        this.rdpc = rdpc;
    }

    public Long getAncienIndexEan() {
        return ancienIndexEan;
    }

    public void setAncienIndexEan(Long ancienIndexEan) {
        this.ancienIndexEan = ancienIndexEan;
    }

    public Long getNouvelIndexEan() {
        return nouvelIndexEan;
    }

    public void setNouvelIndexEan(Long nouvelIndexEan) {
        this.nouvelIndexEan = nouvelIndexEan;
    }

    public String getEaNormale() {
        return eaNormale;
    }

    public void setEaNormale(String eaNormale) {
        this.eaNormale = eaNormale;
    }

    public Long getAncienIndexEac() {
        return ancienIndexEac;
    }

    public void setAncienIndexEac(Long ancienIndexEac) {
        this.ancienIndexEac = ancienIndexEac;
    }

    public Long getNouvelIndexEac() {
        return nouvelIndexEac;
    }

    public void setNouvelIndexEac(Long nouvelIndexEac) {
        this.nouvelIndexEac = nouvelIndexEac;
    }

    public Long getEaCreuse() {
        return eaCreuse;
    }

    public void setEaCreuse(Long eaCreuse) {
        this.eaCreuse = eaCreuse;
    }

    public Long getAncienIndexEap() {
        return ancienIndexEap;
    }

    public void setAncienIndexEap(Long ancienIndexEap) {
        this.ancienIndexEap = ancienIndexEap;
    }

    public Long getNouvelIndexEap() {
        return nouvelIndexEap;
    }

    public void setNouvelIndexEap(Long nouvelIndexEap) {
        this.nouvelIndexEap = nouvelIndexEap;
    }

    public String getEaPointes() {
        return eaPointes;
    }

    public void setEaPointes(String eaPointes) {
        this.eaPointes = eaPointes;
    }

    public Float getEnergieReactive() {
        return energieReactive;
    }

    public void setEnergieReactive(Float energieReactive) {
        this.energieReactive = energieReactive;
    }

    public Long getHeuresUtilisees() {
        return heuresUtilisees;
    }

    public void setHeuresUtilisees(Long heuresUtilisees) {
        this.heuresUtilisees = heuresUtilisees;
    }

    public Long getIndiceMaximal() {
        return indiceMaximal;
    }

    public void setIndiceMaximal(Long indiceMaximal) {
        this.indiceMaximal = indiceMaximal;
    }

    public LocalDate getDateModification() {
        return dateModification;
    }

    public void setDateModification(LocalDate dateModification) {
        this.dateModification = dateModification;
    }

    public LocalDate getDateSuppression() {
        return dateSuppression;
    }

    public void setDateSuppression(LocalDate dateSuppression) {
        this.dateSuppression = dateSuppression;
    }

    public LocalDate getDateRendreFactureAs() {
        return dateRendreFactureAs;
    }

    public void setDateRendreFactureAs(LocalDate dateRendreFactureAs) {
        this.dateRendreFactureAs = dateRendreFactureAs;
    }

    public String getStatutFacture() {
        return statutFacture;
    }

    public void setStatutFacture(String statutFacture) {
        this.statutFacture = statutFacture;
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

    public Long getIdUserModification() {
        return idUserModification;
    }

    public void setIdUserModification(Long idUserModification) {
        this.idUserModification = idUserModification;
    }

    public Long getIdUserSuppression() {
        return idUserSuppression;
    }

    public void setIdUserSuppression(Long idUserSuppression) {
        this.idUserSuppression = idUserSuppression;
    }

    public Long getIdUserRendreFactureAs() {
        return idUserRendreFactureAs;
    }

    public void setIdUserRendreFactureAs(Long idUserRendreFactureAs) {
        this.idUserRendreFactureAs = idUserRendreFactureAs;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getMotifRejet() {
        return motifRejet;
    }

    public void setMotifRejet(String motifRejet) {
        this.motifRejet = motifRejet;
    }

    public String getRejetMotif() {
        return rejetMotif;
    }

    public void setRejetMotif(String rejetMotif) {
        this.rejetMotif = rejetMotif;
    }

    public Long getAncienIndexEa() {
        return ancienIndexEa;
    }

    public void setAncienIndexEa(Long ancienIndexEa) {
        this.ancienIndexEa = ancienIndexEa;
    }

    public Long getNouvelIndexEa() {
        return nouvelIndexEa;
    }

    public void setNouvelIndexEa(Long nouvelIndexEa) {
        this.nouvelIndexEa = nouvelIndexEa;
    }

    public Long getAncienIndexEr() {
        return ancienIndexEr;
    }

    public void setAncienIndexEr(Long ancienIndexEr) {
        this.ancienIndexEr = ancienIndexEr;
    }

    public Long getNouvelIndexEr() {
        return nouvelIndexEr;
    }

    public void setNouvelIndexEr(Long nouvelIndexEr) {
        this.nouvelIndexEr = nouvelIndexEr;
    }

    public Long getAncienIndexHu() {
        return ancienIndexHu;
    }

    public void setAncienIndexHu(Long ancienIndexHu) {
        this.ancienIndexHu = ancienIndexHu;
    }

    public Long getNouvelIndexHu() {
        return nouvelIndexHu;
    }

    public void setNouvelIndexHu(Long nouvelIndexHu) {
        this.nouvelIndexHu = nouvelIndexHu;
    }

    public Long getAncienIndexIm() {
        return ancienIndexIm;
    }

    public void setAncienIndexIm(Long ancienIndexIm) {
        this.ancienIndexIm = ancienIndexIm;
    }

    public Long getNouvelIndexIm() {
        return nouvelIndexIm;
    }

    public void setNouvelIndexIm(Long nouvelIndexIm) {
        this.nouvelIndexIm = nouvelIndexIm;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FactureDTO)) {
            return false;
        }

        FactureDTO factureDTO = (FactureDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, factureDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "FactureDTO{" +
            "id=" + getId() +
            ", idIOC=" + getIdIOC() +
            ", numeroFacture=" + getNumeroFacture() +
            ", dateFacture='" + getDateFacture() + "'" +
            ", codeMemoire='" + getCodeMemoire() + "'" +
            ", idMemoire=" + getIdMemoire() +
            ", montantTTC=" + getMontantTTC() +
            ", typeIndex=" + getTypeIndex() +
            ", ancienIndex=" + getAncienIndex() +
            ", nouvelIndex=" + getNouvelIndex() +
            ", dateDebutConso='" + getDateDebutConso() + "'" +
            ", dateFinConso='" + getDateFinConso() + "'" +
            ", periodes='" + getPeriodes() + "'" +
            ", periodeReference='" + getPeriodeReference() + "'" +
            ", categorieFacture=" + getCategorieFacture() +
            ", puissanceAppelee='" + getPuissanceAppelee() + "'" +
            ", cosPhi=" + getCosPhi() +
            ", rdpc='" + getRdpc() + "'" +
            ", ancienIndexEan=" + getAncienIndexEan() +
            ", nouvelIndexEan=" + getNouvelIndexEan() +
            ", eaNormale='" + getEaNormale() + "'" +
            ", ancienIndexEac=" + getAncienIndexEac() +
            ", nouvelIndexEac=" + getNouvelIndexEac() +
            ", eaCreuse=" + getEaCreuse() +
            ", ancienIndexEap=" + getAncienIndexEap() +
            ", nouvelIndexEap=" + getNouvelIndexEap() +
            ", eaPointes='" + getEaPointes() + "'" +
            ", energieReactive=" + getEnergieReactive() +
            ", heuresUtilisees=" + getHeuresUtilisees() +
            ", indiceMaximal=" + getIndiceMaximal() +
            ", dateModification='" + getDateModification() + "'" +
            ", dateSuppression='" + getDateSuppression() + "'" +
            ", dateRendreFactureAs='" + getDateRendreFactureAs() + "'" +
            ", statutFacture='" + getStatutFacture() + "'" +
            ", dateCreation='" + getDateCreation() + "'" +
            ", dateValidation='" + getDateValidation() + "'" +
            ", dateRejet='" + getDateRejet() + "'" +
            ", idUserCreation=" + getIdUserCreation() +
            ", idUserValidation=" + getIdUserValidation() +
            ", idUserRejet=" + getIdUserRejet() +
            ", idUserModification=" + getIdUserModification() +
            ", idUserSuppression=" + getIdUserSuppression() +
            ", idUserRendreFactureAs=" + getIdUserRendreFactureAs() +
            ", observation='" + getObservation() + "'" +
            ", motifRejet='" + getMotifRejet() + "'" +
            ", rejetMotif='" + getRejetMotif() + "'" +
            ", ancienIndexEa=" + getAncienIndexEa() +
            ", nouvelIndexEa=" + getNouvelIndexEa() +
            ", ancienIndexEr=" + getAncienIndexEr() +
            ", nouvelIndexEr=" + getNouvelIndexEr() +
            ", ancienIndexHu=" + getAncienIndexHu() +
            ", nouvelIndexHu=" + getNouvelIndexHu() +
            ", ancienIndexIm=" + getAncienIndexIm() +
            ", nouvelIndexIm=" + getNouvelIndexIm() +
            ", montantTVA7=" + getMontantTVA7() +
            ", montantHT7=" + getMontantHT7() +
            ", montantTVA14=" + getMontantTVA14() +
            ", montantHT14=" + getMontantHT14() +
            ", montantTVA20=" + getMontantTVA20() +
            ", montantHT20=" + getMontantHT20() +
            ", montantTvaManue=" + getMontantTvaManue() +
            ", diversesTaxes=" + getDiversesTaxes() +
            "}";
    }
}
