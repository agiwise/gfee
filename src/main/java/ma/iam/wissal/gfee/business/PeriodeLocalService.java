package ma.iam.wissal.gfee.business;



import org.hibernate.criterion.DetachedCriteria;
import java.util.List;
import ma.iam.wissal.gfee.domain.Periode;

public abstract interface PeriodeLocalService
{
  public abstract Periode addPeriode(Periode paramPeriode)
    throws RuntimeException;

  public abstract void deletePeriode(long paramLong)
    throws RuntimeException, Exception;

  public abstract void deletePeriode(Periode paramPeriode)
    throws RuntimeException;

  public abstract Periode getPeriode(long paramLong)
    throws RuntimeException, Exception;

  public abstract List<Periode> getPeriodes()
    throws RuntimeException;

  public abstract int getPeriodesCount()
    throws RuntimeException;

  public abstract Periode updatePeriode(Periode paramPeriode)
    throws RuntimeException;
}

/* Location:           D:\Alignement\ext-service.jar
 * Qualified Name:     ma.iam.wissal.business.PeriodeLocalService
 * JD-Core Version:    0.5.4
 */