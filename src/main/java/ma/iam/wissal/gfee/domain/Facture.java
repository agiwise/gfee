package ma.iam.wissal.gfee.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;

/**
 * A Facture.
 */
@Entity
@Table(name = "gest_redev_facture")
public class Facture implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "idFacture")
    private Long id;

    @Column(name = "idioc")
    private Long idIOC;

    @Column(name = "numerofacture")
    private Long numeroFacture;

    @Column(name = "datefacture")
    private LocalDate dateFacture;

    @Column(name = "codememoire")
    private String codeMemoire;

    @Column(name = "idmemoire")
    private Long idMemoire;

    @Column(name = "montantttc")
    private Double montantTTC;

    @Column(name = "typeindex")
    private Integer typeIndex;

    @Column(name = "ancienindex")
    private Long ancienIndex;

    @Column(name = "nouvelindex")
    private Long nouvelIndex;

    @Column(name = "datedebutconso")
    private LocalDate dateDebutConso;

    @Column(name = "datefinconso")
    private LocalDate dateFinConso;

    @Column(name = "periodes")
    private String periodes;

    @Column(name = "periodereference")
    private String periodeReference;

    @Column(name = "categoriefacture")
    private Integer categorieFacture;

    @Column(name = "puissanceappelee")
    private String puissanceAppelee;

    @Column(name = "cosphi")
    private Float cosPhi;

    @Column(name = "rdpc")
    private String rdpc;

    @Column(name = "ancienindexean")
    private Long ancienIndexEan;

    @Column(name = "nouvelindexean")
    private Long nouvelIndexEan;

    @Column(name = "eanormale")
    private String eaNormale;

    @Column(name = "ancienindexeac")
    private Long ancienIndexEac;

    @Column(name = "nouvelindexeac")
    private Long nouvelIndexEac;

    @Column(name = "eacreuse")
    private Long eaCreuse;

    @Column(name = "ancienindexeap")
    private Long ancienIndexEap;

    @Column(name = "nouvelindexeap")
    private Long nouvelIndexEap;

    @Column(name = "eapointes")
    private String eaPointes;

    @Column(name = "energiereactive")
    private Float energieReactive;

    @Column(name = "heuresutilisees")
    private Long heuresUtilisees;

    @Column(name = "indicemaximal")
    private Long indiceMaximal;

    @Column(name = "datemodification")
    private LocalDate dateModification;

    @Column(name = "datesuppression")
    private LocalDate dateSuppression;

    @Column(name = "daterendrefactureas")
    private LocalDate dateRendreFactureAs;

    @Column(name = "statutfacture")
    private String statutFacture;

    @Column(name = "datecreation")
    private LocalDate dateCreation;

    @Column(name = "datevalidation")
    private LocalDate dateValidation;

    @Column(name = "daterejet")
    private LocalDate dateRejet;

    @Column(name = "idusercreation")
    private Long idUserCreation;

    @Column(name = "iduservalidation")
    private Long idUserValidation;

    @Column(name = "iduserrejet")
    private Long idUserRejet;

    @Column(name = "idusermodification")
    private Long idUserModification;

    @Column(name = "idusersuppression")
    private Long idUserSuppression;

    @Column(name = "iduserrendrefactureas")
    private Long idUserRendreFactureAs;

    @Column(name = "observation")
    private String observation;

    @Column(name = "motifrejet")
    private String motifRejet;

    @Column(name = "rejetmotif")
    private String rejetMotif;

    @Column(name = "ancienindexea")
    private Long ancienIndexEa;

    @Column(name = "nouvelindexea")
    private Long nouvelIndexEa;

    @Column(name = "ancienindexer")
    private Long ancienIndexEr;

    @Column(name = "nouvelindexer")
    private Long nouvelIndexEr;

    @Column(name = "ancienindexhu")
    private Long ancienIndexHu;

    @Column(name = "nouvelindexhu")
    private Long nouvelIndexHu;

    @Column(name = "ancienindexim")
    private Long ancienIndexIm;

    @Column(name = "nouvelindexim")
    private Long nouvelIndexIm;

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

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Facture id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdIOC() {
        return this.idIOC;
    }

    public Facture idIOC(Long idIOC) {
        this.setIdIOC(idIOC);
        return this;
    }

    public void setIdIOC(Long idIOC) {
        this.idIOC = idIOC;
    }

    public Long getNumeroFacture() {
        return this.numeroFacture;
    }

    public Facture numeroFacture(Long numeroFacture) {
        this.setNumeroFacture(numeroFacture);
        return this;
    }

    public void setNumeroFacture(Long numeroFacture) {
        this.numeroFacture = numeroFacture;
    }

    public LocalDate getDateFacture() {
        return this.dateFacture;
    }

    public Facture dateFacture(LocalDate dateFacture) {
        this.setDateFacture(dateFacture);
        return this;
    }

    public void setDateFacture(LocalDate dateFacture) {
        this.dateFacture = dateFacture;
    }

    public String getCodeMemoire() {
        return this.codeMemoire;
    }

    public Facture codeMemoire(String codeMemoire) {
        this.setCodeMemoire(codeMemoire);
        return this;
    }

    public void setCodeMemoire(String codeMemoire) {
        this.codeMemoire = codeMemoire;
    }

    public Long getIdMemoire() {
        return this.idMemoire;
    }

    public Facture idMemoire(Long idMemoire) {
        this.setIdMemoire(idMemoire);
        return this;
    }

    public void setIdMemoire(Long idMemoire) {
        this.idMemoire = idMemoire;
    }

    public Double getMontantTTC() {
        return this.montantTTC;
    }

    public Facture montantTTC(Double montantTTC) {
        this.setMontantTTC(montantTTC);
        return this;
    }

    public void setMontantTTC(Double montantTTC) {
        this.montantTTC = montantTTC;
    }

    public Integer getTypeIndex() {
        return this.typeIndex;
    }

    public Facture typeIndex(Integer typeIndex) {
        this.setTypeIndex(typeIndex);
        return this;
    }

    public void setTypeIndex(Integer typeIndex) {
        this.typeIndex = typeIndex;
    }

    public Long getAncienIndex() {
        return this.ancienIndex;
    }

    public Facture ancienIndex(Long ancienIndex) {
        this.setAncienIndex(ancienIndex);
        return this;
    }

    public void setAncienIndex(Long ancienIndex) {
        this.ancienIndex = ancienIndex;
    }

    public Long getNouvelIndex() {
        return this.nouvelIndex;
    }

    public Facture nouvelIndex(Long nouvelIndex) {
        this.setNouvelIndex(nouvelIndex);
        return this;
    }

    public void setNouvelIndex(Long nouvelIndex) {
        this.nouvelIndex = nouvelIndex;
    }

    public LocalDate getDateDebutConso() {
        return this.dateDebutConso;
    }

    public Facture dateDebutConso(LocalDate dateDebutConso) {
        this.setDateDebutConso(dateDebutConso);
        return this;
    }

    public void setDateDebutConso(LocalDate dateDebutConso) {
        this.dateDebutConso = dateDebutConso;
    }

    public LocalDate getDateFinConso() {
        return this.dateFinConso;
    }

    public Facture dateFinConso(LocalDate dateFinConso) {
        this.setDateFinConso(dateFinConso);
        return this;
    }

    public void setDateFinConso(LocalDate dateFinConso) {
        this.dateFinConso = dateFinConso;
    }

    public String getPeriodes() {
        return this.periodes;
    }

    public Facture periodes(String periodes) {
        this.setPeriodes(periodes);
        return this;
    }

    public void setPeriodes(String periodes) {
        this.periodes = periodes;
    }

    public String getPeriodeReference() {
        return this.periodeReference;
    }

    public Facture periodeReference(String periodeReference) {
        this.setPeriodeReference(periodeReference);
        return this;
    }

    public void setPeriodeReference(String periodeReference) {
        this.periodeReference = periodeReference;
    }

    public Integer getCategorieFacture() {
        return this.categorieFacture;
    }

    public Facture categorieFacture(Integer categorieFacture) {
        this.setCategorieFacture(categorieFacture);
        return this;
    }

    public void setCategorieFacture(Integer categorieFacture) {
        this.categorieFacture = categorieFacture;
    }

    public String getPuissanceAppelee() {
        return this.puissanceAppelee;
    }

    public Facture puissanceAppelee(String puissanceAppelee) {
        this.setPuissanceAppelee(puissanceAppelee);
        return this;
    }

    public void setPuissanceAppelee(String puissanceAppelee) {
        this.puissanceAppelee = puissanceAppelee;
    }

    public Float getCosPhi() {
        return this.cosPhi;
    }

    public Facture cosPhi(Float cosPhi) {
        this.setCosPhi(cosPhi);
        return this;
    }

    public void setCosPhi(Float cosPhi) {
        this.cosPhi = cosPhi;
    }

    public String getRdpc() {
        return this.rdpc;
    }

    public Facture rdpc(String rdpc) {
        this.setRdpc(rdpc);
        return this;
    }

    public void setRdpc(String rdpc) {
        this.rdpc = rdpc;
    }

    public Long getAncienIndexEan() {
        return this.ancienIndexEan;
    }

    public Facture ancienIndexEan(Long ancienIndexEan) {
        this.setAncienIndexEan(ancienIndexEan);
        return this;
    }

    public void setAncienIndexEan(Long ancienIndexEan) {
        this.ancienIndexEan = ancienIndexEan;
    }

    public Long getNouvelIndexEan() {
        return this.nouvelIndexEan;
    }

    public Facture nouvelIndexEan(Long nouvelIndexEan) {
        this.setNouvelIndexEan(nouvelIndexEan);
        return this;
    }

    public void setNouvelIndexEan(Long nouvelIndexEan) {
        this.nouvelIndexEan = nouvelIndexEan;
    }

    public String getEaNormale() {
        return this.eaNormale;
    }

    public Facture eaNormale(String eaNormale) {
        this.setEaNormale(eaNormale);
        return this;
    }

    public void setEaNormale(String eaNormale) {
        this.eaNormale = eaNormale;
    }

    public Long getAncienIndexEac() {
        return this.ancienIndexEac;
    }

    public Facture ancienIndexEac(Long ancienIndexEac) {
        this.setAncienIndexEac(ancienIndexEac);
        return this;
    }

    public void setAncienIndexEac(Long ancienIndexEac) {
        this.ancienIndexEac = ancienIndexEac;
    }

    public Long getNouvelIndexEac() {
        return this.nouvelIndexEac;
    }

    public Facture nouvelIndexEac(Long nouvelIndexEac) {
        this.setNouvelIndexEac(nouvelIndexEac);
        return this;
    }

    public void setNouvelIndexEac(Long nouvelIndexEac) {
        this.nouvelIndexEac = nouvelIndexEac;
    }

    public Long getEaCreuse() {
        return this.eaCreuse;
    }

    public Facture eaCreuse(Long eaCreuse) {
        this.setEaCreuse(eaCreuse);
        return this;
    }

    public void setEaCreuse(Long eaCreuse) {
        this.eaCreuse = eaCreuse;
    }

    public Long getAncienIndexEap() {
        return this.ancienIndexEap;
    }

    public Facture ancienIndexEap(Long ancienIndexEap) {
        this.setAncienIndexEap(ancienIndexEap);
        return this;
    }

    public void setAncienIndexEap(Long ancienIndexEap) {
        this.ancienIndexEap = ancienIndexEap;
    }

    public Long getNouvelIndexEap() {
        return this.nouvelIndexEap;
    }

    public Facture nouvelIndexEap(Long nouvelIndexEap) {
        this.setNouvelIndexEap(nouvelIndexEap);
        return this;
    }

    public void setNouvelIndexEap(Long nouvelIndexEap) {
        this.nouvelIndexEap = nouvelIndexEap;
    }

    public String getEaPointes() {
        return this.eaPointes;
    }

    public Facture eaPointes(String eaPointes) {
        this.setEaPointes(eaPointes);
        return this;
    }

    public void setEaPointes(String eaPointes) {
        this.eaPointes = eaPointes;
    }

    public Float getEnergieReactive() {
        return this.energieReactive;
    }

    public Facture energieReactive(Float energieReactive) {
        this.setEnergieReactive(energieReactive);
        return this;
    }

    public void setEnergieReactive(Float energieReactive) {
        this.energieReactive = energieReactive;
    }

    public Long getHeuresUtilisees() {
        return this.heuresUtilisees;
    }

    public Facture heuresUtilisees(Long heuresUtilisees) {
        this.setHeuresUtilisees(heuresUtilisees);
        return this;
    }

    public void setHeuresUtilisees(Long heuresUtilisees) {
        this.heuresUtilisees = heuresUtilisees;
    }

    public Long getIndiceMaximal() {
        return this.indiceMaximal;
    }

    public Facture indiceMaximal(Long indiceMaximal) {
        this.setIndiceMaximal(indiceMaximal);
        return this;
    }

    public void setIndiceMaximal(Long indiceMaximal) {
        this.indiceMaximal = indiceMaximal;
    }

    public LocalDate getDateModification() {
        return this.dateModification;
    }

    public Facture dateModification(LocalDate dateModification) {
        this.setDateModification(dateModification);
        return this;
    }

    public void setDateModification(LocalDate dateModification) {
        this.dateModification = dateModification;
    }

    public LocalDate getDateSuppression() {
        return this.dateSuppression;
    }

    public Facture dateSuppression(LocalDate dateSuppression) {
        this.setDateSuppression(dateSuppression);
        return this;
    }

    public void setDateSuppression(LocalDate dateSuppression) {
        this.dateSuppression = dateSuppression;
    }

    public LocalDate getDateRendreFactureAs() {
        return this.dateRendreFactureAs;
    }

    public Facture dateRendreFactureAs(LocalDate dateRendreFactureAs) {
        this.setDateRendreFactureAs(dateRendreFactureAs);
        return this;
    }

    public void setDateRendreFactureAs(LocalDate dateRendreFactureAs) {
        this.dateRendreFactureAs = dateRendreFactureAs;
    }

    public String getStatutFacture() {
        return this.statutFacture;
    }

    public Facture statutFacture(String statutFacture) {
        this.setStatutFacture(statutFacture);
        return this;
    }

    public void setStatutFacture(String statutFacture) {
        this.statutFacture = statutFacture;
    }

    public LocalDate getDateCreation() {
        return this.dateCreation;
    }

    public Facture dateCreation(LocalDate dateCreation) {
        this.setDateCreation(dateCreation);
        return this;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalDate getDateValidation() {
        return this.dateValidation;
    }

    public Facture dateValidation(LocalDate dateValidation) {
        this.setDateValidation(dateValidation);
        return this;
    }

    public void setDateValidation(LocalDate dateValidation) {
        this.dateValidation = dateValidation;
    }

    public LocalDate getDateRejet() {
        return this.dateRejet;
    }

    public Facture dateRejet(LocalDate dateRejet) {
        this.setDateRejet(dateRejet);
        return this;
    }

    public void setDateRejet(LocalDate dateRejet) {
        this.dateRejet = dateRejet;
    }

    public Long getIdUserCreation() {
        return this.idUserCreation;
    }

    public Facture idUserCreation(Long idUserCreation) {
        this.setIdUserCreation(idUserCreation);
        return this;
    }

    public void setIdUserCreation(Long idUserCreation) {
        this.idUserCreation = idUserCreation;
    }

    public Long getIdUserValidation() {
        return this.idUserValidation;
    }

    public Facture idUserValidation(Long idUserValidation) {
        this.setIdUserValidation(idUserValidation);
        return this;
    }

    public void setIdUserValidation(Long idUserValidation) {
        this.idUserValidation = idUserValidation;
    }

    public Long getIdUserRejet() {
        return this.idUserRejet;
    }

    public Facture idUserRejet(Long idUserRejet) {
        this.setIdUserRejet(idUserRejet);
        return this;
    }

    public void setIdUserRejet(Long idUserRejet) {
        this.idUserRejet = idUserRejet;
    }

    public Long getIdUserModification() {
        return this.idUserModification;
    }

    public Facture idUserModification(Long idUserModification) {
        this.setIdUserModification(idUserModification);
        return this;
    }

    public void setIdUserModification(Long idUserModification) {
        this.idUserModification = idUserModification;
    }

    public Long getIdUserSuppression() {
        return this.idUserSuppression;
    }

    public Facture idUserSuppression(Long idUserSuppression) {
        this.setIdUserSuppression(idUserSuppression);
        return this;
    }

    public void setIdUserSuppression(Long idUserSuppression) {
        this.idUserSuppression = idUserSuppression;
    }

    public Long getIdUserRendreFactureAs() {
        return this.idUserRendreFactureAs;
    }

    public Facture idUserRendreFactureAs(Long idUserRendreFactureAs) {
        this.setIdUserRendreFactureAs(idUserRendreFactureAs);
        return this;
    }

    public void setIdUserRendreFactureAs(Long idUserRendreFactureAs) {
        this.idUserRendreFactureAs = idUserRendreFactureAs;
    }

    public String getObservation() {
        return this.observation;
    }

    public Facture observation(String observation) {
        this.setObservation(observation);
        return this;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getMotifRejet() {
        return this.motifRejet;
    }

    public Facture motifRejet(String motifRejet) {
        this.setMotifRejet(motifRejet);
        return this;
    }

    public void setMotifRejet(String motifRejet) {
        this.motifRejet = motifRejet;
    }

    public String getRejetMotif() {
        return this.rejetMotif;
    }

    public Facture rejetMotif(String rejetMotif) {
        this.setRejetMotif(rejetMotif);
        return this;
    }

    public void setRejetMotif(String rejetMotif) {
        this.rejetMotif = rejetMotif;
    }

    public Long getAncienIndexEa() {
        return this.ancienIndexEa;
    }

    public Facture ancienIndexEa(Long ancienIndexEa) {
        this.setAncienIndexEa(ancienIndexEa);
        return this;
    }

    public void setAncienIndexEa(Long ancienIndexEa) {
        this.ancienIndexEa = ancienIndexEa;
    }

    public Long getNouvelIndexEa() {
        return this.nouvelIndexEa;
    }

    public Facture nouvelIndexEa(Long nouvelIndexEa) {
        this.setNouvelIndexEa(nouvelIndexEa);
        return this;
    }

    public void setNouvelIndexEa(Long nouvelIndexEa) {
        this.nouvelIndexEa = nouvelIndexEa;
    }

    public Long getAncienIndexEr() {
        return this.ancienIndexEr;
    }

    public Facture ancienIndexEr(Long ancienIndexEr) {
        this.setAncienIndexEr(ancienIndexEr);
        return this;
    }

    public void setAncienIndexEr(Long ancienIndexEr) {
        this.ancienIndexEr = ancienIndexEr;
    }

    public Long getNouvelIndexEr() {
        return this.nouvelIndexEr;
    }

    public Facture nouvelIndexEr(Long nouvelIndexEr) {
        this.setNouvelIndexEr(nouvelIndexEr);
        return this;
    }

    public void setNouvelIndexEr(Long nouvelIndexEr) {
        this.nouvelIndexEr = nouvelIndexEr;
    }

    public Long getAncienIndexHu() {
        return this.ancienIndexHu;
    }

    public Facture ancienIndexHu(Long ancienIndexHu) {
        this.setAncienIndexHu(ancienIndexHu);
        return this;
    }

    public void setAncienIndexHu(Long ancienIndexHu) {
        this.ancienIndexHu = ancienIndexHu;
    }

    public Long getNouvelIndexHu() {
        return this.nouvelIndexHu;
    }

    public Facture nouvelIndexHu(Long nouvelIndexHu) {
        this.setNouvelIndexHu(nouvelIndexHu);
        return this;
    }

    public void setNouvelIndexHu(Long nouvelIndexHu) {
        this.nouvelIndexHu = nouvelIndexHu;
    }

    public Long getAncienIndexIm() {
        return this.ancienIndexIm;
    }

    public Facture ancienIndexIm(Long ancienIndexIm) {
        this.setAncienIndexIm(ancienIndexIm);
        return this;
    }

    public void setAncienIndexIm(Long ancienIndexIm) {
        this.ancienIndexIm = ancienIndexIm;
    }

    public Long getNouvelIndexIm() {
        return this.nouvelIndexIm;
    }

    public Facture nouvelIndexIm(Long nouvelIndexIm) {
        this.setNouvelIndexIm(nouvelIndexIm);
        return this;
    }

    public void setNouvelIndexIm(Long nouvelIndexIm) {
        this.nouvelIndexIm = nouvelIndexIm;
    }

    public Double getMontantTVA7() {
        return this.montantTVA7;
    }

    public Facture montantTVA7(Double montantTVA7) {
        this.setMontantTVA7(montantTVA7);
        return this;
    }

    public void setMontantTVA7(Double montantTVA7) {
        this.montantTVA7 = montantTVA7;
    }

    public Double getMontantHT7() {
        return this.montantHT7;
    }

    public Facture montantHT7(Double montantHT7) {
        this.setMontantHT7(montantHT7);
        return this;
    }

    public void setMontantHT7(Double montantHT7) {
        this.montantHT7 = montantHT7;
    }

    public Double getMontantTVA14() {
        return this.montantTVA14;
    }

    public Facture montantTVA14(Double montantTVA14) {
        this.setMontantTVA14(montantTVA14);
        return this;
    }

    public void setMontantTVA14(Double montantTVA14) {
        this.montantTVA14 = montantTVA14;
    }

    public Double getMontantHT14() {
        return this.montantHT14;
    }

    public Facture montantHT14(Double montantHT14) {
        this.setMontantHT14(montantHT14);
        return this;
    }

    public void setMontantHT14(Double montantHT14) {
        this.montantHT14 = montantHT14;
    }

    public Double getMontantTVA20() {
        return this.montantTVA20;
    }

    public Facture montantTVA20(Double montantTVA20) {
        this.setMontantTVA20(montantTVA20);
        return this;
    }

    public void setMontantTVA20(Double montantTVA20) {
        this.montantTVA20 = montantTVA20;
    }

    public Double getMontantHT20() {
        return this.montantHT20;
    }

    public Facture montantHT20(Double montantHT20) {
        this.setMontantHT20(montantHT20);
        return this;
    }

    public void setMontantHT20(Double montantHT20) {
        this.montantHT20 = montantHT20;
    }

    public Double getMontantTvaManue() {
        return this.montantTvaManue;
    }

    public Facture montantTvaManue(Double montantTvaManue) {
        this.setMontantTvaManue(montantTvaManue);
        return this;
    }

    public void setMontantTvaManue(Double montantTvaManue) {
        this.montantTvaManue = montantTvaManue;
    }

    public Double getDiversesTaxes() {
        return this.diversesTaxes;
    }

    public Facture diversesTaxes(Double diversesTaxes) {
        this.setDiversesTaxes(diversesTaxes);
        return this;
    }

    public void setDiversesTaxes(Double diversesTaxes) {
        this.diversesTaxes = diversesTaxes;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Facture)) {
            return false;
        }
        return id != null && id.equals(((Facture) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Facture{" +
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
