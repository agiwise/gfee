package ma.iam.wissal.gfee.business;



import org.hibernate.criterion.DetachedCriteria;
import java.util.List;
import ma.iam.wissal.gfee.domain.Fournisseur;

public abstract interface FournisseurLocalService
{
  public abstract Fournisseur addFournisseur(Fournisseur paramFournisseur)
    throws RuntimeException;

  public abstract void deleteFournisseur(long paramLong)
    throws RuntimeException, Exception;

  public abstract void deleteFournisseur(Fournisseur paramFournisseur)
    throws RuntimeException;

  public abstract Fournisseur getFournisseur(long paramLong)
    throws RuntimeException, Exception;

  public abstract List<Fournisseur> getFournisseurs()
    throws RuntimeException;

  public abstract int getFournisseursCount()
    throws RuntimeException;

  public abstract Fournisseur updateFournisseur(Fournisseur paramFournisseur)
    throws RuntimeException;
}

/* Location:           D:\Alignement\ext-service.jar
 * Qualified Name:     ma.iam.wissal.business.FournisseurLocalService
 * JD-Core Version:    0.5.4
 */