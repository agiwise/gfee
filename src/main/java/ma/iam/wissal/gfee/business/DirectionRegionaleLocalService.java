package ma.iam.wissal.gfee.business;



import org.hibernate.criterion.DetachedCriteria;
import java.util.List;
import ma.iam.wissal.gfee.domain.DirectionRegionale;

public abstract interface DirectionRegionaleLocalService
{
  public abstract DirectionRegionale addDirectionRegionale(DirectionRegionale paramDirectionRegionale)
    throws RuntimeException;

  public abstract void deleteDirectionRegionale(long paramLong)
    throws RuntimeException, Exception;

  public abstract void deleteDirectionRegionale(DirectionRegionale paramDirectionRegionale)
    throws RuntimeException;

//  public abstract List<Object> dynamicQuery(DetachedCriteria paramDynamicQuery)
//    throws RuntimeException;
//
//  public abstract List<Object> dynamicQuery(DetachedCriteria paramDynamicQuery, int paramInt1, int paramInt2)
//    throws RuntimeException;

  public abstract DirectionRegionale getDirectionRegionale(long paramLong)
    throws RuntimeException, Exception;

  public abstract List<DirectionRegionale> getDirectionRegionales()
    throws RuntimeException;

  public abstract int getDirectionRegionalesCount()
    throws RuntimeException;

  public abstract DirectionRegionale updateDirectionRegionale(DirectionRegionale paramDirectionRegionale)
    throws RuntimeException;
}

/* Location:           D:\Alignement\ext-service.jar
 * Qualified Name:     ma.iam.wissal.business.DirectionRegionaleLocalService
 * JD-Core Version:    0.5.4
 */