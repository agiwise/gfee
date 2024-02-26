/*    */ package ma.iam.wissal.gfee.domain;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class Periode
/*    */   implements Serializable
/*    */ {
/*    */   private long _idperiode;
/*    */   private long _idFacture;
/*    */   private String _periode;
/*    */ 
/*    */   public static Periode toSoapModel(Periode model)
/*    */   {
/* 36 */     Periode soapModel = new Periode();
/*    */ 
/* 38 */     soapModel.setIdperiode(model.getIdperiode());
/* 39 */     soapModel.setIdFacture(model.getIdFacture());
/* 40 */     soapModel.setPeriode(model.getPeriode());
/*    */ 
/* 42 */     return soapModel;
/*    */   }
/*    */ 
/*    */   public static Periode[] toSoapModels(List<Periode> models) {
/* 46 */     List soapModels = new ArrayList(models.size());
/*    */ 
/* 48 */     for (Periode model : models) {
/* 49 */       soapModels.add(toSoapModel(model));
/*    */     }
/*    */ 
/* 52 */     return (Periode[])soapModels.toArray(new Periode[soapModels.size()]);
/*    */   }
/*    */ 
/*    */   public long getPrimaryKey() {
/* 56 */     return this._idperiode;
/*    */   }
/*    */ 
/*    */   public void setPrimaryKey(long pk) {
/* 60 */     setIdperiode(pk);
/*    */   }
/*    */ 
/*    */   public long getIdperiode() {
/* 64 */     return this._idperiode;
/*    */   }
/*    */ 
/*    */   public void setIdperiode(long idperiode) {
/* 68 */     this._idperiode = idperiode;
/*    */   }
/*    */ 
/*    */   public long getIdFacture() {
/* 72 */     return this._idFacture;
/*    */   }
/*    */ 
/*    */   public void setIdFacture(long idFacture) {
/* 76 */     this._idFacture = idFacture;
/*    */   }
/*    */ 
/*    */   public String getPeriode() {
/* 80 */     return this._periode;
/*    */   }
/*    */ 
/*    */   public void setPeriode(String periode) {
/* 84 */     this._periode = periode;
/*    */   }
/*    */ }

/* Location:           D:\Alignement\ext-service.jar
 * Qualified Name:     ma.iam.wissal.gestionredevances.model.PeriodeSoap
 * JD-Core Version:    0.5.4
 */