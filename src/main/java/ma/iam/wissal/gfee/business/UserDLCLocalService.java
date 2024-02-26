package ma.iam.wissal.gfee.business;



import org.hibernate.criterion.DetachedCriteria;
import java.util.List;
import ma.iam.wissal.gfee.domain.UserDLC;

public abstract interface UserDLCLocalService
{
  public abstract UserDLC addUserDLC(UserDLC paramUserDLC)
    throws RuntimeException;

  public abstract void deleteUserDLC(long paramLong)
    throws RuntimeException, Exception;

  public abstract void deleteUserDLC(UserDLC paramUserDLC)
    throws RuntimeException;

  public abstract UserDLC getUserDLC(long paramLong)
    throws RuntimeException, Exception;

  public abstract List<UserDLC> getUserDLCs()
    throws RuntimeException;

  public abstract int getUserDLCsCount()
    throws RuntimeException;

  public abstract UserDLC updateUserDLC(UserDLC paramUserDLC)
    throws RuntimeException;
}

/* Location:           D:\Alignement\ext-service.jar
 * Qualified Name:     ma.iam.wissal.business.UserDLCLocalService
 * JD-Core Version:    0.5.4
 */