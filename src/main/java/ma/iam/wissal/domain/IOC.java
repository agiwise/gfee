package ma.iam.wissal.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;

/**
 * A IOC.
 */
@Entity
@Table(name = "gest_redev_ioc")
public class IOC implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "numero_ioc")
    private String numeroIOC;

    @Column(name = "type_ioc")
    private Integer typeIOC;

    @Column(name = "type_prestation")
    private Integer typePrestation;

    @Column(name = "type_index")
    private Integer typeIndex;

    @Column(name = "categorie")
    private Integer categorie;

    @Column(name = "etat_ioc")
    private Integer etatIOC;

    @Column(name = "libelle")
    private String libelle;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "puissance_souscrite")
    private String puissanceSouscrite;

    @Column(name = "puissance_installe")
    private String puissanceInstalle;

    @Column(name = "date_creation")
    private LocalDate dateCreation;

    @Column(name = "date_modification")
    private LocalDate dateModification;

    @Column(name = "id_direction_regionale")
    private Long idDirectionRegionale;

    @Column(name = "id_dlc")
    private Long idDLC;

    @Column(name = "id_ville")
    private Long idVille;

    @Column(name = "tension")
    private Integer tension;

    @Column(name = "responsable_site")
    private String responsableSite;

    @Column(name = "activite_analytique")
    private Integer activiteAnalytique;

    @Column(name = "code_analytique")
    private String codeAnalytique;

    @Column(name = "categorie_index")
    private Integer categorieIndex;

    @Column(name = "id_fournisseur")
    private Long idFournisseur;

    @Column(name = "periodicite")
    private Integer periodicite;

    @Column(name = "observation")
    private String observation;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public IOC id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroIOC() {
        return this.numeroIOC;
    }

    public IOC numeroIOC(String numeroIOC) {
        this.setNumeroIOC(numeroIOC);
        return this;
    }

    public void setNumeroIOC(String numeroIOC) {
        this.numeroIOC = numeroIOC;
    }

    public Integer getTypeIOC() {
        return this.typeIOC;
    }

    public IOC typeIOC(Integer typeIOC) {
        this.setTypeIOC(typeIOC);
        return this;
    }

    public void setTypeIOC(Integer typeIOC) {
        this.typeIOC = typeIOC;
    }

    public Integer getTypePrestation() {
        return this.typePrestation;
    }

    public IOC typePrestation(Integer typePrestation) {
        this.setTypePrestation(typePrestation);
        return this;
    }

    public void setTypePrestation(Integer typePrestation) {
        this.typePrestation = typePrestation;
    }

    public Integer getTypeIndex() {
        return this.typeIndex;
    }

    public IOC typeIndex(Integer typeIndex) {
        this.setTypeIndex(typeIndex);
        return this;
    }

    public void setTypeIndex(Integer typeIndex) {
        this.typeIndex = typeIndex;
    }

    public Integer getCategorie() {
        return this.categorie;
    }

    public IOC categorie(Integer categorie) {
        this.setCategorie(categorie);
        return this;
    }

    public void setCategorie(Integer categorie) {
        this.categorie = categorie;
    }

    public Integer getEtatIOC() {
        return this.etatIOC;
    }

    public IOC etatIOC(Integer etatIOC) {
        this.setEtatIOC(etatIOC);
        return this;
    }

    public void setEtatIOC(Integer etatIOC) {
        this.etatIOC = etatIOC;
    }

    public String getLibelle() {
        return this.libelle;
    }

    public IOC libelle(String libelle) {
        this.setLibelle(libelle);
        return this;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public IOC adresse(String adresse) {
        this.setAdresse(adresse);
        return this;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPuissanceSouscrite() {
        return this.puissanceSouscrite;
    }

    public IOC puissanceSouscrite(String puissanceSouscrite) {
        this.setPuissanceSouscrite(puissanceSouscrite);
        return this;
    }

    public void setPuissanceSouscrite(String puissanceSouscrite) {
        this.puissanceSouscrite = puissanceSouscrite;
    }

    public String getPuissanceInstalle() {
        return this.puissanceInstalle;
    }

    public IOC puissanceInstalle(String puissanceInstalle) {
        this.setPuissanceInstalle(puissanceInstalle);
        return this;
    }

    public void setPuissanceInstalle(String puissanceInstalle) {
        this.puissanceInstalle = puissanceInstalle;
    }

    public LocalDate getDateCreation() {
        return this.dateCreation;
    }

    public IOC dateCreation(LocalDate dateCreation) {
        this.setDateCreation(dateCreation);
        return this;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalDate getDateModification() {
        return this.dateModification;
    }

    public IOC dateModification(LocalDate dateModification) {
        this.setDateModification(dateModification);
        return this;
    }

    public void setDateModification(LocalDate dateModification) {
        this.dateModification = dateModification;
    }

    public Long getIdDirectionRegionale() {
        return this.idDirectionRegionale;
    }

    public IOC idDirectionRegionale(Long idDirectionRegionale) {
        this.setIdDirectionRegionale(idDirectionRegionale);
        return this;
    }

    public void setIdDirectionRegionale(Long idDirectionRegionale) {
        this.idDirectionRegionale = idDirectionRegionale;
    }

    public Long getIdDLC() {
        return this.idDLC;
    }

    public IOC idDLC(Long idDLC) {
        this.setIdDLC(idDLC);
        return this;
    }

    public void setIdDLC(Long idDLC) {
        this.idDLC = idDLC;
    }

    public Long getIdVille() {
        return this.idVille;
    }

    public IOC idVille(Long idVille) {
        this.setIdVille(idVille);
        return this;
    }

    public void setIdVille(Long idVille) {
        this.idVille = idVille;
    }

    public Integer getTension() {
        return this.tension;
    }

    public IOC tension(Integer tension) {
        this.setTension(tension);
        return this;
    }

    public void setTension(Integer tension) {
        this.tension = tension;
    }

    public String getResponsableSite() {
        return this.responsableSite;
    }

    public IOC responsableSite(String responsableSite) {
        this.setResponsableSite(responsableSite);
        return this;
    }

    public void setResponsableSite(String responsableSite) {
        this.responsableSite = responsableSite;
    }

    public Integer getActiviteAnalytique() {
        return this.activiteAnalytique;
    }

    public IOC activiteAnalytique(Integer activiteAnalytique) {
        this.setActiviteAnalytique(activiteAnalytique);
        return this;
    }

    public void setActiviteAnalytique(Integer activiteAnalytique) {
        this.activiteAnalytique = activiteAnalytique;
    }

    public String getCodeAnalytique() {
        return this.codeAnalytique;
    }

    public IOC codeAnalytique(String codeAnalytique) {
        this.setCodeAnalytique(codeAnalytique);
        return this;
    }

    public void setCodeAnalytique(String codeAnalytique) {
        this.codeAnalytique = codeAnalytique;
    }

    public Integer getCategorieIndex() {
        return this.categorieIndex;
    }

    public IOC categorieIndex(Integer categorieIndex) {
        this.setCategorieIndex(categorieIndex);
        return this;
    }

    public void setCategorieIndex(Integer categorieIndex) {
        this.categorieIndex = categorieIndex;
    }

    public Long getIdFournisseur() {
        return this.idFournisseur;
    }

    public IOC idFournisseur(Long idFournisseur) {
        this.setIdFournisseur(idFournisseur);
        return this;
    }

    public void setIdFournisseur(Long idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    public Integer getPeriodicite() {
        return this.periodicite;
    }

    public IOC periodicite(Integer periodicite) {
        this.setPeriodicite(periodicite);
        return this;
    }

    public void setPeriodicite(Integer periodicite) {
        this.periodicite = periodicite;
    }

    public String getObservation() {
        return this.observation;
    }

    public IOC observation(String observation) {
        this.setObservation(observation);
        return this;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof IOC)) {
            return false;
        }
        return id != null && id.equals(((IOC) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "IOC{" +
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
