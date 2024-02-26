package ma.iam.wissal.gfee.business;



import org.hibernate.criterion.DetachedCriteria;
import java.util.List;
import ma.iam.wissal.gfee.domain.Memoire;

public abstract interface MemoireLocalService
{
  public abstract Memoire addMemoire(Memoire paramMemoire)
    throws RuntimeException;

  public abstract void deleteMemoire(long paramLong)
    throws RuntimeException, Exception;

  public abstract void deleteMemoire(Memoire paramMemoire)
    throws RuntimeException;

  public abstract Memoire getMemoire(long paramLong)
    throws RuntimeException, Exception;

  public abstract List<Memoire> getMemoires()
    throws RuntimeException;

  public abstract int getMemoiresCount()
    throws RuntimeException;

  public abstract Memoire updateMemoire(Memoire paramMemoire)
    throws RuntimeException;
}

/* Location:           D:\Alignement\ext-service.jar
 * Qualified Name:     ma.iam.wissal.business.MemoireLocalService
 * JD-Core Version:    0.5.4
 */