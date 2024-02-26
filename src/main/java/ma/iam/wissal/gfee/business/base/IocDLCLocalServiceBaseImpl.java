/*     */ package ma.iam.wissal.gfee.business.base;
/*     */ 
/*     */ 
/*     */ 

/*     */ import java.util.List;
/*     */ import javax.annotation.Resource;
/*     */ import ma.iam.wissal.gfee.domain.IocDLC;
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
/*     */ public abstract class IocDLCLocalServiceBaseImpl
/*     */   implements IocDLCLocalService
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
/*     */   public IocDLC addIocDLC(IocDLC iocDLC)
/*     */     throws RuntimeException
/*     */   {
/*     */ 
/*  89 */     return this.iocDLCRepository.save(iocDLC);
/*     */   }
/*     */ 
/*     */   public void deleteIocDLC(long idIocDLC) throws Exception, RuntimeException
/*     */   {
/*  98 */     this.iocDLCRepository.deleteById(idIocDLC);
/*     */   }
/*     */ 
/*     */   public void deleteIocDLC(IocDLC iocDLC) throws RuntimeException {
/* 102 */     this.iocDLCRepository.deleteById(iocDLC.getId());
/*     */   }
/*     */ 
/*     */   public IocDLC getIocDLC(long idIocDLC) throws Exception, RuntimeException
/*     */   {
/* 117 */     return this.iocDLCRepository.findById(idIocDLC).get();
/*     */   }
/*     */ 
/*     */   public List<IocDLC> getIocDLCs() throws RuntimeException
/*     */   {
/* 122 */     return this.iocDLCRepository.findAll();
/*     */   }
/*     */ 
/*     */   public int getIocDLCsCount() throws RuntimeException {
/* 126 */     return (int) this.iocDLCRepository.count();
/*     */   }
/*     */ 
/*     */   public IocDLC updateIocDLC(IocDLC iocDLC) throws RuntimeException {
/*     */ 
/* 132 */     return this.iocDLCRepository.save(iocDLC);
/*     */   }
/*     */ 
/*     */   public IOCLocalService getIOCLocalService() {
/* 136 */     return this.iocLocalService;
/*     */   }
/*     */ 
/*     */   public void setIOCLocalService(IOCLocalService iocLocalService) {
/* 140 */     this.iocLocalService = iocLocalService;
/*     */   }
/*     */ 
/*     */   public IOCRepository getIOCPersistence() {
/* 144 */     return this.iocRepository;
/*     */   }
/*     */ 
/*     */   public void setIOCPersistence(IOCRepository iocPersistence) {
/* 148 */     this.iocRepository = iocRepository;
/*     */   }
/*     */ 
/*     */   public FactureLocalService getFactureLocalService() {
/* 152 */     return this.factureLocalService;
/*     */   }
/*     */ 
/*     */   public void setFactureLocalService(FactureLocalService factureLocalService) {
/* 156 */     this.factureLocalService = factureLocalService;
/*     */   }
/*     */ 
/*     */   public FactureRepository getFacturePersistence() {
/* 160 */     return this.factureRepository;
/*     */   }
/*     */ 
/*     */   public void setFacturePersistence(FactureRepository facturePersistence) {
/* 164 */     this.factureRepository = factureRepository;
/*     */   }
/*     */ 
/*     */   public MemoireLocalService getMemoireLocalService() {
/* 168 */     return this.memoireLocalService;
/*     */   }
/*     */ 
/*     */   public void setMemoireLocalService(MemoireLocalService memoireLocalService) {
/* 172 */     this.memoireLocalService = memoireLocalService;
/*     */   }
/*     */ 
/*     */   public MemoireRepository getMemoirePersistence() {
/* 176 */     return this.memoireRepository;
/*     */   }
/*     */ 
/*     */   public void setMemoirePersistence(MemoireRepository memoirePersistence) {
/* 180 */     this.memoireRepository = memoireRepository;
/*     */   }
/*     */ 
/*     */   public FournisseurLocalService getFournisseurLocalService() {
/* 184 */     return this.fournisseurLocalService;
/*     */   }
/*     */ 
/*     */   public void setFournisseurLocalService(FournisseurLocalService fournisseurLocalService)
/*     */   {
/* 189 */     this.fournisseurLocalService = fournisseurLocalService;
/*     */   }
/*     */ 
/*     */   public FournisseurRepository getFournisseurPersistence() {
/* 193 */     return this.fournisseurRepository;
/*     */   }
/*     */ 
/*     */   public void setFournisseurPersistence(FournisseurRepository fournisseurPersistence)
/*     */   {
/* 198 */     this.fournisseurRepository = fournisseurRepository;
/*     */   }
/*     */ 
/*     */   public VilleLocalService getVilleLocalService() {
/* 202 */     return this.villeLocalService;
/*     */   }
/*     */ 
/*     */   public void setVilleLocalService(VilleLocalService villeLocalService) {
/* 206 */     this.villeLocalService = villeLocalService;
/*     */   }
/*     */ 
/*     */   public VilleRepository getVillePersistence() {
/* 210 */     return this.villeRepository;
/*     */   }
/*     */ 
/*     */   public void setVillePersistence(VilleRepository villePersistence) {
/* 214 */     this.villeRepository = villeRepository;
/*     */   }
/*     */ 
/*     */   public DLCLocalService getDLCLocalService() {
/* 218 */     return this.dlcLocalService;
/*     */   }
/*     */ 
/*     */   public void setDLCLocalService(DLCLocalService dlcLocalService) {
/* 222 */     this.dlcLocalService = dlcLocalService;
/*     */   }
/*     */ 
/*     */   public DLCRepository getDLCPersistence() {
/* 226 */     return this.dlcRepository;
/*     */   }
/*     */ 
/*     */   public void setDLCPersistence(DLCRepository dlcPersistence) {
/* 230 */     this.dlcRepository = dlcRepository;
/*     */   }
/*     */ 
/*     */   public DirectionRegionaleLocalService getDirectionRegionaleLocalService() {
/* 234 */     return this.directionRegionaleLocalService;
/*     */   }
/*     */ 
/*     */   public void setDirectionRegionaleLocalService(DirectionRegionaleLocalService directionRegionaleLocalService)
/*     */   {
/* 239 */     this.directionRegionaleLocalService = directionRegionaleLocalService;
/*     */   }
/*     */ 
/*     */   public DirectionRegionaleRepository getDirectionRegionalePersistence() {
/* 243 */     return this.directionRegionaleRepository;
/*     */   }
/*     */ 
/*     */   public void setDirectionRegionalePersistence(DirectionRegionaleRepository directionRegionalePersistence)
/*     */   {
/* 248 */     this.directionRegionaleRepository = directionRegionaleRepository;
/*     */   }
/*     */ 
/*     */   public IndexReelLocalService getIndexReelLocalService() {
/* 252 */     return this.indexReelLocalService;
/*     */   }
/*     */ 
/*     */   public void setIndexReelLocalService(IndexReelLocalService indexReelLocalService)
/*     */   {
/* 257 */     this.indexReelLocalService = indexReelLocalService;
/*     */   }
/*     */ 
/*     */   public IndexReelRepository getIndexReelPersistence() {
/* 261 */     return this.indexReelRepository;
/*     */   }
/*     */ 
/*     */   public void setIndexReelPersistence(IndexReelRepository indexReelPersistence)
/*     */   {
/* 266 */     this.indexReelRepository = indexReelRepository;
/*     */   }
/*     */ 
/*     */   public PIECESAPLocalService getPIECESAPLocalService() {
/* 270 */     return this.piecesapLocalService;
/*     */   }
/*     */ 
/*     */   public void setPIECESAPLocalService(PIECESAPLocalService piecesapLocalService)
/*     */   {
/* 275 */     this.piecesapLocalService = piecesapLocalService;
/*     */   }
/*     */ 
/*     */   public PIECESAPRepository getPIECESAPPersistence() {
/* 279 */     return this.piecesapRepository;
/*     */   }
/*     */ 
/*     */   public void setPIECESAPPersistence(PIECESAPRepository piecesapPersistence) {
/* 283 */     this.piecesapRepository = piecesapRepository;
/*     */   }
/*     */ 
/*     */   public UserDLCLocalService getUserDLCLocalService() {
/* 287 */     return this.userDLCLocalService;
/*     */   }
/*     */ 
/*     */   public void setUserDLCLocalService(UserDLCLocalService userDLCLocalService) {
/* 291 */     this.userDLCLocalService = userDLCLocalService;
/*     */   }
/*     */ 
/*     */   public UserDLCRepository getUserDLCPersistence() {
/* 295 */     return this.userDLCRepository;
/*     */   }
/*     */ 
/*     */   public void setUserDLCPersistence(UserDLCRepository userDLCPersistence) {
/* 299 */     this.userDLCRepository = userDLCRepository;
/*     */   }
/*     */ 
/*     */   public IocDLCLocalService getIocDLCLocalService() {
/* 303 */     return this.iocDLCLocalService;
/*     */   }
/*     */ 
/*     */   public void setIocDLCLocalService(IocDLCLocalService iocDLCLocalService) {
/* 307 */     this.iocDLCLocalService = iocDLCLocalService;
/*     */   }
/*     */ 
/*     */   public IocDLCRepository getIocDLCPersistence() {
/* 311 */     return this.iocDLCRepository;
/*     */   }
/*     */ 
/*     */   public void setIocDLCPersistence(IocDLCRepository iocDLCPersistence) {
/* 315 */     this.iocDLCRepository = iocDLCRepository;
/*     */   }
/*     */ 
/*     */   public MemoireDLCLocalService getMemoireDLCLocalService() {
/* 319 */     return this.memoireDLCLocalService;
/*     */   }
/*     */ 
/*     */   public void setMemoireDLCLocalService(MemoireDLCLocalService memoireDLCLocalService)
/*     */   {
/* 324 */     this.memoireDLCLocalService = memoireDLCLocalService;
/*     */   }
/*     */ 
/*     */   public MemoireDLCRepository getMemoireDLCPersistence() {
/* 328 */     return this.memoireDLCRepository;
/*     */   }
/*     */ 
/*     */   public void setMemoireDLCPersistence(MemoireDLCRepository memoireDLCPersistence)
/*     */   {
/* 333 */     this.memoireDLCRepository = memoireDLCRepository;
/*     */   }
/*     */ }

/* Location:           D:\Alignement\ext-impl.jar
 * Qualified Name:     ma.iam.wissal.gfee.business.base.IocDLCLocalServiceBaseImpl
 * JD-Core Version:    0.5.4
 */