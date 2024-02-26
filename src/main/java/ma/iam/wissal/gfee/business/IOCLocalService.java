package ma.iam.wissal.gfee.business;



import org.hibernate.criterion.DetachedCriteria;
import java.util.List;
import ma.iam.wissal.gfee.domain.IOC;

public abstract interface IOCLocalService
{
  public abstract IOC addIOC(IOC paramIOC)
    throws RuntimeException;

  public abstract void deleteIOC(long paramLong)
    throws RuntimeException, Exception;

  public abstract void deleteIOC(IOC paramIOC)
    throws RuntimeException;

  public abstract IOC getIOC(long paramLong)
    throws RuntimeException, Exception;

  public abstract List<IOC> getIOCs()
    throws RuntimeException;

  public abstract int getIOCsCount()
    throws RuntimeException;

  public abstract IOC updateIOC(IOC paramIOC)
    throws RuntimeException;
}

/* Location:           D:\Alignement\ext-service.jar
 * Qualified Name:     ma.iam.wissal.business.IOCLocalService
 * JD-Core Version:    0.5.4
 */