package ma.iam.wissal.gfee.business;



import org.hibernate.criterion.DetachedCriteria;
import java.util.List;
import ma.iam.wissal.gfee.domain.PIECESAP;

public abstract interface PIECESAPLocalService
{
  public abstract PIECESAP addPIECESAP(PIECESAP paramPIECESAP)
    throws RuntimeException;

  public abstract void deletePIECESAP(long paramLong)
    throws RuntimeException, Exception;

  public abstract void deletePIECESAP(PIECESAP paramPIECESAP)
    throws RuntimeException;

  public abstract PIECESAP getPIECESAP(long paramLong)
    throws RuntimeException, Exception;

  public abstract List<PIECESAP> getPIECESAPs()
    throws RuntimeException;

  public abstract int getPIECESAPsCount()
    throws RuntimeException;

  public abstract PIECESAP updatePIECESAP(PIECESAP paramPIECESAP)
    throws RuntimeException;
}

/* Location:           D:\Alignement\ext-service.jar
 * Qualified Name:     ma.iam.wissal.business.PIECESAPLocalService
 * JD-Core Version:    0.5.4
 */