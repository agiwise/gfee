package ma.iam.wissal.gfee.business;



import org.hibernate.criterion.DetachedCriteria;
import java.util.List;
import ma.iam.wissal.gfee.domain.Log_Redevances;

public abstract interface Log_RedevancesLocalService
{
  public abstract Log_Redevances addLog_Redevances(Log_Redevances paramLog_Redevances)
    throws RuntimeException;

  public abstract Log_Redevances createLog_Redevances(long paramLong);

  public abstract void deleteLog_Redevances(long paramLong)
    throws RuntimeException, Exception;

  public abstract void deleteLog_Redevances(Log_Redevances paramLog_Redevances)
    throws RuntimeException;

  public abstract List<Object> dynamicQuery(DetachedCriteria paramDynamicQuery)
    throws RuntimeException;

  public abstract List<Object> dynamicQuery(DetachedCriteria paramDynamicQuery, int paramInt1, int paramInt2)
    throws RuntimeException;

  public abstract Log_Redevances getLog_Redevances(long paramLong)
    throws RuntimeException, Exception;

  public abstract List<Log_Redevances> getLog_Redevanceses(int paramInt1, int paramInt2)
    throws RuntimeException;

  public abstract int getLog_RedevancesesCount()
    throws RuntimeException;

  public abstract Log_Redevances updateLog_Redevances(Log_Redevances paramLog_Redevances)
    throws RuntimeException;
}

/* Location:           D:\Alignement\ext-service.jar
 * Qualified Name:     ma.iam.wissal.business.Log_RedevancesLocalService
 * JD-Core Version:    0.5.4
 */