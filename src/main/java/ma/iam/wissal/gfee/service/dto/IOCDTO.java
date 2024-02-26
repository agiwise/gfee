package ma.iam.wissal.gfee.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link ma.iam.wissal.gfee.domain.IOC} entity.
 */
public class IOCDTO implements Serializable {

    private Long id;

    private String numeroIOC;

    private Integer typeIOC;

    private Integer typePrestation;

    private Integer typeIndex;

    private Integer categorie;

    private Integer etatIOC;

    private String libelle;

    private String adresse;

    private String puissanceSouscrite;

    private String puissanceInstalle;

    private LocalDate dateCreation;

    private LocalDate dateModification;

    private Long idDirectionRegionale;

    private Long idDLC;

    private Long idVille;

    private Integer tension;

    private String responsableSite;

    private Integer activiteAnalytique;

    private String codeAnalytique;

    private Integer categorieIndex;

    private Long idFournisseur;

    private Integer periodicite;

    private String observation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroIOC() {
        return numeroIOC;
    }

    public void setNumeroIOC(String numeroIOC) {
        this.numeroIOC = numeroIOC;
    }

    public Integer getTypeIOC() {
        return typeIOC;
    }

    public void setTypeIOC(Integer typeIOC) {
        this.typeIOC = typeIOC;
    }

    public Integer getTypePrestation() {
        return typePrestation;
    }

    public void setTypePrestation(Integer typePrestation) {
        this.typePrestation = typePrestation;
    }

    public Integer getTypeIndex() {
        return typeIndex;
    }

    public void setTypeIndex(Integer typeIndex) {
        this.typeIndex = typeIndex;
    }

    public Integer getCategorie() {
        return categorie;
    }

    public void setCategorie(Integer categorie) {
        this.categorie = categorie;
    }

    public Integer getEtatIOC() {
        return etatIOC;
    }

    public void setEtatIOC(Integer etatIOC) {
        this.etatIOC = etatIOC;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPuissanceSouscrite() {
        return puissanceSouscrite;
    }

    public void setPuissanceSouscrite(String puissanceSouscrite) {
        this.puissanceSouscrite = puissanceSouscrite;
    }

    public String getPuissanceInstalle() {
        return puissanceInstalle;
    }

    public void setPuissanceInstalle(String puissanceInstalle) {
        this.puissanceInstalle = puissanceInstalle;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalDate getDateModification() {
        return dateModification;
    }

    public void setDateModification(LocalDate dateModification) {
        this.dateModification = dateModification;
    }

    public Long getIdDirectionRegionale() {
        return idDirectionRegionale;
    }

    public void setIdDirectionRegionale(Long idDirectionRegionale) {
        this.idDirectionRegionale = idDirectionRegionale;
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

    public Integer getTension() {
        return tension;
    }

    public void setTension(Integer tension) {
        this.tension = tension;
    }

    public String getResponsableSite() {
        return responsableSite;
    }

    public void setResponsableSite(String responsableSite) {
        this.responsableSite = responsableSite;
    }

    public Integer getActiviteAnalytique() {
        return activiteAnalytique;
    }

    public void setActiviteAnalytique(Integer activiteAnalytique) {
        this.activiteAnalytique = activiteAnalytique;
    }

    public String getCodeAnalytique() {
        return codeAnalytique;
    }

    public void setCodeAnalytique(String codeAnalytique) {
        this.codeAnalytique = codeAnalytique;
    }

    public Integer getCategorieIndex() {
        return categorieIndex;
    }

    public void setCategorieIndex(Integer categorieIndex) {
        this.categorieIndex = categorieIndex;
    }

    public Long getIdFournisseur() {
        return idFournisseur;
    }

    public void setIdFournisseur(Long idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    public Integer getPeriodicite() {
        return periodicite;
    }

    public void setPeriodicite(Integer periodicite) {
        this.periodicite = periodicite;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof IOCDTO)) {
            return false;
        }

        IOCDTO iOCDTO = (IOCDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, iOCDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "IOCDTO{" +
            "id=" + getId() +
            ", numeroIOC='" + getNumeroIOC() + "'" +
            ", typeIOC=" + getTypeIOC() +
            ", typePrestation=" + getTypePrestation() +
            ", typeIndex=" + getTypeIndex() +
            ", categorie=" + getCategorie() +
            ", etatIOC=" + getEtatIOC() +
            ", libelle='" + getLibelle() + "'" +
            ", adresse='" + getAdresse() + "'" +
            ", puissanceSouscrite='" + getPuissanceSouscrite() + "'" +
            ", puissanceInstalle='" + getPuissanceInstalle() + "'" +
            ", dateCreation='" + getDateCreation() + "'" +
            ", dateModification='" + getDateModification() + "'" +
            ", idDirectionRegionale=" + getIdDirectionRegionale() +
            ", idDLC=" + getIdDLC() +
            ", idVille=" + getIdVille() +
            ", tension=" + getTension() +
            ", responsableSite='" + getResponsableSite() + "'" +
            ", activiteAnalytique=" + getActiviteAnalytique() +
            ", codeAnalytique='" + getCodeAnalytique() + "'" +
            ", categorieIndex=" + getCategorieIndex() +
            ", idFournisseur=" + getIdFournisseur() +
            ", periodicite=" + getPeriodicite() +
            ", observation='" + getObservation() + "'" +
            "}";
    }
}
