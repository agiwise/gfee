package ma.iam.wissal.gfee.business;



import org.hibernate.criterion.DetachedCriteria;
import java.util.List;
import ma.iam.wissal.gfee.domain.DLC;

public abstract interface DLCLocalService
{
  public abstract DLC addDLC(DLC paramDLC)
    throws RuntimeException;

  public abstract void deleteDLC(long paramLong)
    throws RuntimeException, Exception;

  public abstract void deleteDLC(DLC paramDLC)
    throws RuntimeException;

  public abstract DLC getDLC(long paramLong)
    throws RuntimeException, Exception;

  public abstract List<DLC> getDLCs()
    throws RuntimeException;

  public abstract int getDLCsCount()
    throws RuntimeException;

  public abstract DLC updateDLC(DLC paramDLC)
    throws RuntimeException;
}

/* Location:           D:\Alignement\ext-service.jar
 * Qualified Name:     ma.iam.wissal.business.DLCLocalService
 * JD-Core Version:    0.5.4
 */