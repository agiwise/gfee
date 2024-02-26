/*     */ package ma.iam.wissal.gfee.business.base;
/*     */ 
/*     */ 
/*     */ 

/*     */ import java.util.List;
/*     */ import javax.annotation.Resource;
/*     */ import ma.iam.wissal.gfee.domain.MemoireDLC;
/*     */ import ma.iam.wissal.gfee.business.DLCLocalService;
/*     */ import ma.iam.wissal.gfee.business.DirectionRegionaleLocalService;
/*     */ import ma.iam.wissal.gfee.business.FactureLocalService;
/*     */ import ma.iam.wissal.gfee.business.FournisseurLocalService;
/*     */ import ma.iam.wissal.gfee.business.IOCLocalService;
/*     */ import ma.iam.wissal.gfee.business.IndexReelLocalService;
/*     */ import ma.iam.wissal.gfee.business.IocDLCLocalService;
/*     */ import ma.iam.wissal.gfee.business.MemoireDLCLocalService;
/*     */ import ma.iam.wissal.gfee.business.MemoireLocalService;
/*     */ import ma.iam.wissal.gfee.business.PIECESAPLocalService;
/*     */ import ma.iam.wissal.gfee.business.UserDLCLocalService;
/*     */ import ma.iam.wissal.gfee.business.VilleLocalService;
/*     */ import ma.iam.wissal.gfee.repository.DLCRepository;
/*     */ import ma.iam.wissal.gfee.repository.DirectionRegionaleRepository;
/*     */ import ma.iam.wissal.gfee.repository.FactureRepository;
/*     */ import ma.iam.wissal.gfee.repository.FournisseurRepository;
/*     */ import ma.iam.wissal.gfee.repository.IOCRepository;
/*     */ import ma.iam.wissal.gfee.repository.IndexReelRepository;
/*     */ import ma.iam.wissal.gfee.repository.IocDLCRepository;
/*     */ import ma.iam.wissal.gfee.repository.MemoireDLCRepository;
/*     */ import ma.iam.wissal.gfee.repository.MemoireRepository;
/*     */ import ma.iam.wissal.gfee.repository.PIECESAPRepository;
/*     */ import ma.iam.wissal.gfee.repository.UserDLCRepository;
/*     */ import ma.iam.wissal.gfee.repository.VilleRepository;
/*     */ 
/*     */ public abstract class MemoireDLCLocalServiceBaseImpl
/*     */   implements MemoireDLCLocalService
/*     */ {
/*     */ 
/*     */   @Resource(name="ma.iam.wissal.gfee.business.IOCLocalService.impl")
/*     */   protected IOCLocalService iocLocalService;
/*     */ 
/*     */   @Resource(name="ma.iam.wissal.gfee.business.persistence.IOCRepository.impl")
/*     */   protected IOCRepository iocRepository;
/*     */ 
/*     */   @Resource(name="ma.iam.wissal.gfee.business.FactureLocalService.impl")
/*     */   protected FactureLocalService factureLocalService;
/*     */ 
/*     */   @Resource(name="ma.iam.wissal.gfee.business.persistence.FactureRepository.impl")
/*     */   protected FactureRepository factureRepository;
/*     */ 
/*     */   @Resource(name="ma.iam.wissal.gfee.business.MemoireLocalService.impl")
/*     */   protected MemoireLocalService memoireLocalService;
/*     */ 
/*     */   @Resource(name="ma.iam.wissal.gfee.business.persistence.MemoireRepository.impl")
/*     */   protected MemoireRepository memoireRepository;
/*     */ 
/*     */   @Resource(name="ma.iam.wissal.gfee.business.FournisseurLocalService.impl")
/*     */   protected FournisseurLocalService fournisseurLocalService;
/*     */ 
/*     */   @Resource(name="ma.iam.wissal.gfee.business.persistence.FournisseurRepository.impl")
/*     */   protected FournisseurRepository fournisseurRepository;
/*     */ 
/*     */   @Resource(name="ma.iam.wissal.gfee.business.VilleLocalService.impl")
/*     */   protected VilleLocalService villeLocalService;
/*     */ 
/*     */   @Resource(name="ma.iam.wissal.gfee.business.persistence.VilleRepository.impl")
/*     */   protected VilleRepository villeRepository;
/*     */ 
/*     */   @Resource(name="ma.iam.wissal.gfee.business.DLCLocalService.impl")
/*     */   protected DLCLocalService dlcLocalService;
/*     */ 
/*     */   @Resource(name="ma.iam.wissal.gfee.business.persistence.DLCRepository.impl")
/*     */   protected DLCRepository dlcRepository;
/*     */ 
/*     */   @Resource(name="ma.iam.wissal.gfee.business.DirectionRegionaleLocalService.impl")
/*     */   protected DirectionRegionaleLocalService directionRegionaleLocalService;
/*     */ 
/*     */   @Resource(name="ma.iam.wissal.gfee.business.persistence.DirectionRegionaleRepository.impl")
/*     */   protected DirectionRegionaleRepository directionRegionaleRepository;
/*     */ 
/*     */   @Resource(name="ma.iam.wissal.gfee.business.IndexReelLocalService.impl")
/*     */   protected IndexReelLocalService indexReelLocalService;
/*     */ 
/*     */   @Resource(name="ma.iam.wissal.gfee.business.persistence.IndexReelRepository.impl")
/*     */   protected IndexReelRepository indexReelRepository;
/*     */ 
/*     */   @Resource(name="ma.iam.wissal.gfee.business.PIECESAPLocalService.impl")
/*     */   protected PIECESAPLocalService piecesapLocalService;
/*     */ 
/*     */   @Resource(name="ma.iam.wissal.gfee.business.persistence.PIECESAPRepository.impl")
/*     */   protected PIECESAPRepository piecesapRepository;
/*     */ 
/*     */   @Resource(name="ma.iam.wissal.gfee.business.UserDLCLocalService.impl")
/*     */   protected UserDLCLocalService userDLCLocalService;
/*     */ 
/*     */   @Resource(name="ma.iam.wissal.gfee.business.persistence.UserDLCRepository.impl")
/*     */   protected UserDLCRepository userDLCRepository;
/*     */ 
/*     */   @Resource(name="ma.iam.wissal.gfee.business.IocDLCLocalService.impl")
/*     */   protected IocDLCLocalService iocDLCLocalService;
/*     */ 
/*     */   @Resource(name="ma.iam.wissal.gfee.business.persistence.IocDLCRepository.impl")
/*     */   protected IocDLCRepository iocDLCRepository;
/*     */ 
/*     */   @Resource(name="ma.iam.wissal.gfee.business.MemoireDLCLocalService.impl")
/*     */   protected MemoireDLCLocalService memoireDLCLocalService;
/*     */ 
/*     */   @Resource(name="ma.iam.wissal.gfee.business.persistence.MemoireDLCRepository.impl")
/*     */   protected MemoireDLCRepository memoireDLCRepository;
/*     */ 
/*     */   public MemoireDLC addMemoireDLC(MemoireDLC memoireDLC)
/*     */     throws RuntimeException
/*     */   {
/*     */ 
/*  91 */     return this.memoireDLCRepository.save(memoireDLC);
/*     */   }
/*     */ 
/*     */   public void deleteMemoireDLC(long idMemoireDLC) throws Exception, RuntimeException
/*     */   {
/* 100 */     this.memoireDLCRepository.deleteById(idMemoireDLC);
/*     */   }
/*     */ 
/*     */   public void deleteMemoireDLC(MemoireDLC memoireDLC) throws RuntimeException
/*     */   {
/* 105 */     this.memoireDLCRepository.deleteById(memoireDLC.getId());
/*     */   }
/*     */ 
/*     */   public MemoireDLC getMemoireDLC(long idMemoireDLC)
/*     */     throws Exception, RuntimeException
/*     */   {
/* 121 */     return this.memoireDLCRepository.findById(idMemoireDLC).get();
/*     */   }
/*     */ 
/*     */   public List<MemoireDLC> getMemoireDLCs() throws RuntimeException
/*     */   {
/* 126 */     return this.memoireDLCRepository.findAll();
/*     */   }
/*     */ 
/*     */   public int getMemoireDLCsCount() throws RuntimeException {
/* 130 */     return (int) this.memoireDLCRepository.count();
/*     */   }
/*     */ 
/*     */   public MemoireDLC updateMemoireDLC(MemoireDLC memoireDLC) throws RuntimeException
/*     */   {
/*     */ 
/* 137 */     return this.memoireDLCRepository.save(memoireDLC);
/*     */   }
/*     */ 
/*     */   public IOCLocalService getIOCLocalService() {
/* 141 */     return this.iocLocalService;
/*     */   }
/*     */ 
/*     */   public void setIOCLocalService(IOCLocalService iocLocalService) {
/* 145 */     this.iocLocalService = iocLocalService;
/*     */   }
/*     */ 
/*     */   public IOCRepository getIOCPersistence() {
/* 149 */     return this.iocRepository;
/*     */   }
/*     */ 
/*     */   public void setIOCPersistence(IOCRepository iocPersistence) {
/* 153 */     this.iocRepository = iocRepository;
/*     */   }
/*     */ 
/*     */   public FactureLocalService getFactureLocalService() {
/* 157 */     return this.factureLocalService;
/*     */   }
/*     */ 
/*     */   public void setFactureLocalService(FactureLocalService factureLocalService) {
/* 161 */     this.factureLocalService = factureLocalService;
/*     */   }
/*     */ 
/*     */   public FactureRepository getFacturePersistence() {
/* 165 */     return this.factureRepository;
/*     */   }
/*     */ 
/*     */   public void setFacturePersistence(FactureRepository facturePersistence) {
/* 169 */     this.factureRepository = factureRepository;
/*     */   }
/*     */ 
/*     */   public MemoireLocalService getMemoireLocalService() {
/* 173 */     return this.memoireLocalService;
/*     */   }
/*     */ 
/*     */   public void setMemoireLocalService(MemoireLocalService memoireLocalService) {
/* 177 */     this.memoireLocalService = memoireLocalService;
/*     */   }
/*     */ 
/*     */   public MemoireRepository getMemoirePersistence() {
/* 181 */     return this.memoireRepository;
/*     */   }
/*     */ 
/*     */   public void setMemoirePersistence(MemoireRepository memoirePersistence) {
/* 185 */     this.memoireRepository = memoireRepository;
/*     */   }
/*     */ 
/*     */   public FournisseurLocalService getFournisseurLocalService() {
/* 189 */     return this.fournisseurLocalService;
/*     */   }
/*     */ 
/*     */   public void setFournisseurLocalService(FournisseurLocalService fournisseurLocalService)
/*     */   {
/* 194 */     this.fournisseurLocalService = fournisseurLocalService;
/*     */   }
/*     */ 
/*     */   public FournisseurRepository getFournisseurPersistence() {
/* 198 */     return this.fournisseurRepository;
/*     */   }
/*     */ 
/*     */   public void setFournisseurPersistence(FournisseurRepository fournisseurPersistence)
/*     */   {
/* 203 */     this.fournisseurRepository = fournisseurRepository;
/*     */   }
/*     */ 
/*     */   public VilleLocalService getVilleLocalService() {
/* 207 */     return this.villeLocalService;
/*     */   }
/*     */ 
/*     */   public void setVilleLocalService(VilleLocalService villeLocalService) {
/* 211 */     this.villeLocalService = villeLocalService;
/*     */   }
/*     */ 
/*     */   public VilleRepository getVillePersistence() {
/* 215 */     return this.villeRepository;
/*     */   }
/*     */ 
/*     */   public void setVillePersistence(VilleRepository villePersistence) {
/* 219 */     this.villeRepository = villeRepository;
/*     */   }
/*     */ 
/*     */   public DLCLocalService getDLCLocalService() {
/* 223 */     return this.dlcLocalService;
/*     */   }
/*     */ 
/*     */   public void setDLCLocalService(DLCLocalService dlcLocalService) {
/* 227 */     this.dlcLocalService = dlcLocalService;
/*     */   }
/*     */ 
/*     */   public DLCRepository getDLCPersistence() {
/* 231 */     return this.dlcRepository;
/*     */   }
/*     */ 
/*     */   public void setDLCPersistence(DLCRepository dlcPersistence) {
/* 235 */     this.dlcRepository = dlcRepository;
/*     */   }
/*     */ 
/*     */   public DirectionRegionaleLocalService getDirectionRegionaleLocalService() {
/* 239 */     return this.directionRegionaleLocalService;
/*     */   }
/*     */ 
/*     */   public void setDirectionRegionaleLocalService(DirectionRegionaleLocalService directionRegionaleLocalService)
/*     */   {
/* 244 */     this.directionRegionaleLocalService = directionRegionaleLocalService;
/*     */   }
/*     */ 
/*     */   public DirectionRegionaleRepository getDirectionRegionalePersistence() {
/* 248 */     return this.directionRegionaleRepository;
/*     */   }
/*     */ 
/*     */   public void setDirectionRegionalePersistence(DirectionRegionaleRepository directionRegionalePersistence)
/*     */   {
/* 253 */     this.directionRegionaleRepository = directionRegionaleRepository;
/*     */   }
/*     */ 
/*     */   public IndexReelLocalService getIndexReelLocalService() {
/* 257 */     return this.indexReelLocalService;
/*     */   }
/*     */ 
/*     */   public void setIndexReelLocalService(IndexReelLocalService indexReelLocalService)
/*     */   {
/* 262 */     this.indexReelLocalService = indexReelLocalService;
/*     */   }
/*     */ 
/*     */   public IndexReelRepository getIndexReelPersistence() {
/* 266 */     return this.indexReelRepository;
/*     */   }
/*     */ 
/*     */   public void setIndexReelPersistence(IndexReelRepository indexReelPersistence)
/*     */   {
/* 271 */     this.indexReelRepository = indexReelRepository;
/*     */   }
/*     */ 
/*     */   public PIECESAPLocalService getPIECESAPLocalService() {
/* 275 */     return this.piecesapLocalService;
/*     */   }
/*     */ 
/*     */   public void setPIECESAPLocalService(PIECESAPLocalService piecesapLocalService)
/*     */   {
/* 280 */     this.piecesapLocalService = piecesapLocalService;
/*     */   }
/*     */ 
/*     */   public PIECESAPRepository getPIECESAPPersistence() {
/* 284 */     return this.piecesapRepository;
/*     */   }
/*     */ 
/*     */   public void setPIECESAPPersistence(PIECESAPRepository piecesapPersistence) {
/* 288 */     this.piecesapRepository = piecesapRepository;
/*     */   }
/*     */ 
/*     */   public UserDLCLocalService getUserDLCLocalService() {
/* 292 */     return this.userDLCLocalService;
/*     */   }
/*     */ 
/*     */   public void setUserDLCLocalService(UserDLCLocalService userDLCLocalService) {
/* 296 */     this.userDLCLocalService = userDLCLocalService;
/*     */   }
/*     */ 
/*     */   public UserDLCRepository getUserDLCPersistence() {
/* 300 */     return this.userDLCRepository;
/*     */   }
/*     */ 
/*     */   public void setUserDLCPersistence(UserDLCRepository userDLCPersistence) {
/* 304 */     this.userDLCRepository = userDLCRepository;
/*     */   }
/*     */ 
/*     */   public IocDLCLocalService getIocDLCLocalService() {
/* 308 */     return this.iocDLCLocalService;
/*     */   }
/*     */ 
/*     */   public void setIocDLCLocalService(IocDLCLocalService iocDLCLocalService) {
/* 312 */     this.iocDLCLocalService = iocDLCLocalService;
/*     */   }
/*     */ 
/*     */   public IocDLCRepository getIocDLCPersistence() {
/* 316 */     return this.iocDLCRepository;
/*     */   }
/*     */ 
/*     */   public void setIocDLCPersistence(IocDLCRepository iocDLCPersistence) {
/* 320 */     this.iocDLCRepository = iocDLCRepository;
/*     */   }
/*     */ 
/*     */   public MemoireDLCLocalService getMemoireDLCLocalService() {
/* 324 */     return this.memoireDLCLocalService;
/*     */   }
/*     */ 
/*     */   public void setMemoireDLCLocalService(MemoireDLCLocalService memoireDLCLocalService)
/*     */   {
/* 329 */     this.memoireDLCLocalService = memoireDLCLocalService;
/*     */   }
/*     */ 
/*     */   public MemoireDLCRepository getMemoireDLCPersistence() {
/* 333 */     return this.memoireDLCRepository;
/*     */   }
/*     */ 
/*     */   public void setMemoireDLCPersistence(MemoireDLCRepository memoireDLCPersistence)
/*     */   {
/* 338 */     this.memoireDLCRepository = memoireDLCRepository;
/*     */   }
/*     */ }

/* Location:           D:\Alignement\ext-impl.jar
 * Qualified Name:     ma.iam.wissal.gfee.business.base.MemoireDLCLocalServiceBaseImpl
 * JD-Core Version:    0.5.4
 */