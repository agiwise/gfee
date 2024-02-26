/*    */ package ma.iam.wissal.gfee.business.base;
/*    */ 
/*    */ 
/*    */ 
/*    */ import com.liferay.portal.kernel.dao.orm.DynamicQuery;
/*    */ import java.util.List;
/*    */ import javax.annotation.Resource;
/*    */ import ma.iam.wissal.gfee.domain.Log_Redevances;
/*    */ import ma.iam.wissal.gfee.business.Log_RedevancesLocalService;
/*    */ import ma.iam.wissal.gfee.repository.Log_RedevancesRepository;
/*    */ 
/*    */ public abstract class Log_RedevancesLocalServiceBaseImpl
/*    */   implements Log_RedevancesLocalService
/*    */ {
/*    */ 
/*    */   @Resource(name="ma.iam.wissal.gfee.business.Log_RedevancesLocalService.impl")
/*    */   protected Log_RedevancesLocalService log_RedevancesLocalService;
/*    */ 
/*    */   @Resource(name="ma.iam.wissal.gfee.business.persistence.Log_RedevancesRepository.impl")
/*    */   protected Log_RedevancesRepository log_RedevancesRepository;
/*    */ 
/*    */   public Log_Redevances addLog_Redevances(Log_Redevances log_Redevances)
/*    */     throws RuntimeException
/*    */   {
/* 24 */     log_Redevances.setNew(true);
/*    */ 
/* 26 */     return this.log_RedevancesRepository.save(log_Redevances, false);
/*    */   }
/*    */ 
/*    */   public Log_Redevances createLog_Redevances(long idLog) {
/* 30 */     return this.log_RedevancesRepository.save(idLog);
/*    */   }
/*    */ 
/*    */   public void deleteLog_Redevances(long idLog) throws Exception, RuntimeException
/*    */   {
/* 35 */     this.log_RedevancesRepository.deleteById(idLog);
/*    */   }
/*    */ 
/*    */   public void deleteLog_Redevances(Log_Redevances log_Redevances) throws RuntimeException
/*    */   {
/* 40 */     this.log_RedevancesRepository.deleteById(log_Redevances);
/*    */   }
/*    */ 
/*    */   public List<Object> dynamicQuery(DynamicQuery dynamicQuery) throws RuntimeException
/*    */   {
/* 45 */     return this.log_RedevancesRepository.findWithDynamicQuery(dynamicQuery);
/*    */   }
/*    */ 
/*    */   public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start, int end) throws RuntimeException
/*    */   {
/* 50 */     return this.log_RedevancesRepository.findWithDynamicQuery(dynamicQuery, start, end);
/*    */   }
/*    */ 
/*    */   public Log_Redevances getLog_Redevances(long idLog)
/*    */     throws Exception, RuntimeException
/*    */   {
/* 56 */     return this.log_RedevancesRepository.findById(idLog);
/*    */   }
/*    */ 
/*    */   public List<Log_Redevances> getLog_Redevanceses(int start, int end) throws RuntimeException
/*    */   {
/* 61 */     return this.log_RedevancesRepository.findAll(start, end);
/*    */   }
/*    */ 
/*    */   public int getLog_RedevancesesCount() throws RuntimeException {
/* 65 */     return this.log_RedevancesRepository.count();
/*    */   }
/*    */ 
/*    */   public Log_Redevances updateLog_Redevances(Log_Redevances log_Redevances) throws RuntimeException
/*    */   {
/* 70 */     log_Redevances.setNew(false);
/*    */ 
/* 72 */     return this.log_RedevancesRepository.save(log_Redevances, true);
/*    */   }
/*    */ 
/*    */   public Log_RedevancesLocalService getLog_RedevancesLocalService() {
/* 76 */     return this.log_RedevancesLocalService;
/*    */   }
/*    */ 
/*    */   public void setLog_RedevancesLocalService(Log_RedevancesLocalService log_RedevancesLocalService)
/*    */   {
/* 81 */     this.log_RedevancesLocalService = log_RedevancesLocalService;
/*    */   }
/*    */ 
/*    */   public Log_RedevancesRepository getLog_RedevancesPersistence() {
/* 85 */     return this.log_RedevancesRepository;
/*    */   }
/*    */ 
/*    */   public void setLog_RedevancesPersistence(Log_RedevancesRepository log_RedevancesPersistence)
/*    */   {
/* 90 */     this.log_RedevancesRepository = log_RedevancesRepository;
/*    */   }
/*    */ }

/* Location:           D:\Alignement\ext-impl.jar
 * Qualified Name:     ma.iam.wissal.gfee.business.base.Log_RedevancesLocalServiceBaseImpl
 * JD-Core Version:    0.5.4
 */