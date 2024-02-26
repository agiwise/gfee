package ma.iam.wissal.gfee.business;



import org.hibernate.criterion.DetachedCriteria;
import java.util.List;
import ma.iam.wissal.gfee.domain.Facture;

public abstract interface FactureLocalService
{
  public abstract Facture addFacture(Facture paramFacture)
    throws RuntimeException;

  public abstract void deleteFacture(long paramLong)
    throws RuntimeException, Exception;

  public abstract void deleteFacture(Facture paramFacture)
    throws RuntimeException;


  public abstract Facture getFacture(long paramLong)
    throws RuntimeException, Exception;

  public abstract List<Facture> getFactures()
    throws RuntimeException;

  public abstract int getFacturesCount()
    throws RuntimeException;

  public abstract Facture updateFacture(Facture paramFacture)
    throws RuntimeException;
}

/* Location:           D:\Alignement\ext-service.jar
 * Qualified Name:     ma.iam.wissal.business.FactureLocalService
 * JD-Core Version:    0.5.4
 */