package ma.iam.wissal.gfee.business;



import org.hibernate.criterion.DetachedCriteria;
import java.util.List;
import ma.iam.wissal.gfee.domain.IocDLC;

public abstract interface IocDLCLocalService
{
  public abstract IocDLC addIocDLC(IocDLC paramIocDLC)
    throws RuntimeException;

  public abstract void deleteIocDLC(long paramLong)
    throws RuntimeException, Exception;

  public abstract void deleteIocDLC(IocDLC paramIocDLC)
    throws RuntimeException;

  public abstract IocDLC getIocDLC(long paramLong)
    throws RuntimeException, Exception;

  public abstract List<IocDLC> getIocDLCs()
    throws RuntimeException;

  public abstract int getIocDLCsCount()
    throws RuntimeException;

  public abstract IocDLC updateIocDLC(IocDLC paramIocDLC)
    throws RuntimeException;
}

/* Location:           D:\Alignement\ext-service.jar
 * Qualified Name:     ma.iam.wissal.business.IocDLCLocalService
 * JD-Core Version:    0.5.4
 */