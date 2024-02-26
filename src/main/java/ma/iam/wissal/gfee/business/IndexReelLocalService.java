package ma.iam.wissal.gfee.business;



import org.hibernate.criterion.DetachedCriteria;
import java.util.List;
import ma.iam.wissal.gfee.domain.IndexReel;

public abstract interface IndexReelLocalService
{
  public abstract IndexReel addIndexReel(IndexReel paramIndexReel)
    throws RuntimeException;

  public abstract void deleteIndexReel(long paramLong)
    throws RuntimeException, Exception;

  public abstract void deleteIndexReel(IndexReel paramIndexReel)
    throws RuntimeException;

  public abstract IndexReel getIndexReel(long paramLong)
    throws RuntimeException, Exception;

  public abstract List<IndexReel> getIndexReels()
    throws RuntimeException;

  public abstract int getIndexReelsCount()
    throws RuntimeException;

  public abstract IndexReel updateIndexReel(IndexReel paramIndexReel)
    throws RuntimeException;
}

/* Location:           D:\Alignement\ext-service.jar
 * Qualified Name:     ma.iam.wissal.business.IndexReelLocalService
 * JD-Core Version:    0.5.4
 */