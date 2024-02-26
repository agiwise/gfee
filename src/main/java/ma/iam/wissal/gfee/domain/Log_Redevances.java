/*     */ package ma.iam.wissal.gfee.domain;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ 
/*     */ public class Log_Redevances
/*     */   implements Serializable
/*     */ {
/*     */   private long _idLog;
/*     */   private String _typeOperation;
/*     */   private int _userId;
/*     */   private Date _dateOperation;
/*     */   private String _libelleOperation;
/*     */ 
/*     */   public static Log_Redevances toSoapModel(Log_Redevances model)
/*     */   {
/*  39 */     Log_Redevances soapModel = new Log_Redevances();
/*     */ 
/*  41 */     soapModel.setIdLog(model.getIdLog());
/*  42 */     soapModel.setTypeOperation(model.getTypeOperation());
/*  43 */     soapModel.setUserId(model.getUserId());
/*  44 */     soapModel.setDateOperation(model.getDateOperation());
/*  45 */     soapModel.setLibelleOperation(model.getLibelleOperation());
/*     */ 
/*  47 */     return soapModel;
/*     */   }
/*     */ 
/*     */   public static Log_Redevances[] toSoapModels(List<Log_Redevances> models) {
/*  51 */     List soapModels = new ArrayList(models.size());
/*     */ 
/*  53 */     for (Log_Redevances model : models) {
/*  54 */       soapModels.add(toSoapModel(model));
/*     */     }
/*     */ 
/*  57 */     return (Log_Redevances[])soapModels.toArray(new Log_Redevances[soapModels.size()]);
/*     */   }
/*     */ 
/*     */   public long getPrimaryKey() {
/*  61 */     return this._idLog;
/*     */   }
/*     */ 
/*     */   public void setPrimaryKey(long pk) {
/*  65 */     setIdLog(pk);
/*     */   }
/*     */ 
/*     */   public long getIdLog() {
/*  69 */     return this._idLog;
/*     */   }
/*     */ 
/*     */   public void setIdLog(long idLog) {
/*  73 */     this._idLog = idLog;
/*     */   }
/*     */ 
/*     */   public String getTypeOperation() {
/*  77 */     return this._typeOperation;
/*     */   }
/*     */ 
/*     */   public void setTypeOperation(String typeOperation) {
/*  81 */     this._typeOperation = typeOperation;
/*     */   }
/*     */ 
/*     */   public int getUserId() {
/*  85 */     return this._userId;
/*     */   }
/*     */ 
/*     */   public void setUserId(int userId) {
/*  89 */     this._userId = userId;
/*     */   }
/*     */ 
/*     */   public Date getDateOperation() {
/*  93 */     return this._dateOperation;
/*     */   }
/*     */ 
/*     */   public void setDateOperation(Date dateOperation) {
/*  97 */     this._dateOperation = dateOperation;
/*     */   }
/*     */ 
/*     */   public String getLibelleOperation() {
/* 101 */     return this._libelleOperation;
/*     */   }
/*     */ 
/*     */   public void setLibelleOperation(String libelleOperation) {
/* 105 */     this._libelleOperation = libelleOperation;
/*     */   }
/*     */ }

/* Location:           D:\Alignement\ext-service.jar
 * Qualified Name:     ma.iam.wissal.gestionredevances.model.Log_RedevancesSoap
 * JD-Core Version:    0.5.4
 */