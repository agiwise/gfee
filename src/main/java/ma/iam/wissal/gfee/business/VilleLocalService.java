package ma.iam.wissal.gfee.business;



import org.hibernate.criterion.DetachedCriteria;
import java.util.List;
import ma.iam.wissal.gfee.domain.Ville;

public abstract interface VilleLocalService
{
  public abstract Ville addVille(Ville paramVille)
    throws RuntimeException;

  public abstract void deleteVille(long paramLong)
    throws RuntimeException, Exception;

  public abstract void deleteVille(Ville paramVille)
    throws RuntimeException;

  public abstract Ville getVille(long paramLong)
    throws RuntimeException, Exception;

  public abstract List<Ville> getVilles()
    throws RuntimeException;

  public abstract int getVillesCount()
    throws RuntimeException;

  public abstract Ville updateVille(Ville paramVille)
    throws RuntimeException;
}

/* Location:           D:\Alignement\ext-service.jar
 * Qualified Name:     ma.iam.wissal.business.VilleLocalService
 * JD-Core Version:    0.5.4
 */