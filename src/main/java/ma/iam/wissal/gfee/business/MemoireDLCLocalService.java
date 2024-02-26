package ma.iam.wissal.gfee.business;



import org.hibernate.criterion.DetachedCriteria;
import java.util.List;
import ma.iam.wissal.gfee.domain.MemoireDLC;

public abstract interface MemoireDLCLocalService
{
  public abstract MemoireDLC addMemoireDLC(MemoireDLC paramMemoireDLC)
    throws RuntimeException;

  public abstract void deleteMemoireDLC(long paramLong)
    throws RuntimeException, Exception;

  public abstract void deleteMemoireDLC(MemoireDLC paramMemoireDLC)
    throws RuntimeException;

  public abstract MemoireDLC getMemoireDLC(long paramLong)
    throws RuntimeException, Exception;

  public abstract List<MemoireDLC> getMemoireDLCs()
    throws RuntimeException;

  public abstract int getMemoireDLCsCount()
    throws RuntimeException;

  public abstract MemoireDLC updateMemoireDLC(MemoireDLC paramMemoireDLC)
    throws RuntimeException;
}

/* Location:           D:\Alignement\ext-service.jar
 * Qualified Name:     ma.iam.wissal.business.MemoireDLCLocalService
 * JD-Core Version:    0.5.4
 */