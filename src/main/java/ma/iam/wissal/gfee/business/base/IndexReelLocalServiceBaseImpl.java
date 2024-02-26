/*     */ package ma.iam.wissal.gfee.business.base;
/*     */ 
/*     */ 
/*     */ 

/*     */ import java.util.List;
/*     */ import javax.annotation.Resource;
/*     */ import ma.iam.wissal.gfee.domain.IndexReel;
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
/*     */ public abstract class IndexReelLocalServiceBaseImpl
/*     */   implements IndexReelLocalService
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
/*     */   public IndexReel addIndexReel(IndexReel indexReel)
/*     */     throws RuntimeException
/*     */   {
/*  91 */     return this.indexReelRepository.save(indexReel);
/*     */   }

/*     */   public void deleteIndexReel(long idIndexReel) throws Exception, RuntimeException
/*     */   {
/* 100 */     this.indexReelRepository.deleteById(idIndexReel);
/*     */   }
/*     */ 
/*     */   public void deleteIndexReel(IndexReel indexReel) throws RuntimeException {
/* 104 */     this.indexReelRepository.deleteById(indexReel.getId());
/*     */   }
/*     */ 
/*     */   public IndexReel getIndexReel(long idIndexReel)
/*     */     throws Exception, RuntimeException
/*     */   {
/* 120 */     return this.indexReelRepository.findById(idIndexReel).get();
/*     */   }
/*     */ 
/*     */   public List<IndexReel> getIndexReels() throws RuntimeException
/*     */   {
/* 125 */     return this.indexReelRepository.findAll();
/*     */   }
/*     */ 
/*     */   public int getIndexReelsCount() throws RuntimeException {
/* 129 */     return (int) this.indexReelRepository.count();
/*     */   }
/*     */ 
/*     */   public IndexReel updateIndexReel(IndexReel indexReel) throws RuntimeException
/*     */   {
/*     */ 
/* 136 */     return this.indexReelRepository.save(indexReel);
/*     */   }
/*     */ 
/*     */   public IOCLocalService getIOCLocalService() {
/* 140 */     return this.iocLocalService;
/*     */   }
/*     */ 
/*     */   public void setIOCLocalService(IOCLocalService iocLocalService) {
/* 144 */     this.iocLocalService = iocLocalService;
/*     */   }
/*     */ 
/*     */   public IOCRepository getIOCPersistence() {
/* 148 */     return this.iocRepository;
/*     */   }
/*     */ 
/*     */   public void setIOCPersistence(IOCRepository iocPersistence) {
/* 152 */     this.iocRepository = iocRepository;
/*     */   }
/*     */ 
/*     */   public FactureLocalService getFactureLocalService() {
/* 156 */     return this.factureLocalService;
/*     */   }
/*     */ 
/*     */   public void setFactureLocalService(FactureLocalService factureLocalService) {
/* 160 */     this.factureLocalService = factureLocalService;
/*     */   }
/*     */ 
/*     */   public FactureRepository getFacturePersistence() {
/* 164 */     return this.factureRepository;
/*     */   }
/*     */ 
/*     */   public void setFacturePersistence(FactureRepository facturePersistence) {
/* 168 */     this.factureRepository = factureRepository;
/*     */   }
/*     */ 
/*     */   public MemoireLocalService getMemoireLocalService() {
/* 172 */     return this.memoireLocalService;
/*     */   }
/*     */ 
/*     */   public void setMemoireLocalService(MemoireLocalService memoireLocalService) {
/* 176 */     this.memoireLocalService = memoireLocalService;
/*     */   }
/*     */ 
/*     */   public MemoireRepository getMemoirePersistence() {
/* 180 */     return this.memoireRepository;
/*     */   }
/*     */ 
/*     */   public void setMemoirePersistence(MemoireRepository memoirePersistence) {
/* 184 */     this.memoireRepository = memoireRepository;
/*     */   }
/*     */ 
/*     */   public FournisseurLocalService getFournisseurLocalService() {
/* 188 */     return this.fournisseurLocalService;
/*     */   }
/*     */ 
/*     */   public void setFournisseurLocalService(FournisseurLocalService fournisseurLocalService)
/*     */   {
/* 193 */     this.fournisseurLocalService = fournisseurLocalService;
/*     */   }
/*     */ 
/*     */   public FournisseurRepository getFournisseurPersistence() {
/* 197 */     return this.fournisseurRepository;
/*     */   }
/*     */ 
/*     */   public void setFournisseurPersistence(FournisseurRepository fournisseurPersistence)
/*     */   {
/* 202 */     this.fournisseurRepository = fournisseurRepository;
/*     */   }
/*     */ 
/*     */   public VilleLocalService getVilleLocalService() {
/* 206 */     return this.villeLocalService;
/*     */   }
/*     */ 
/*     */   public void setVilleLocalService(VilleLocalService villeLocalService) {
/* 210 */     this.villeLocalService = villeLocalService;
/*     */   }
/*     */ 
/*     */   public VilleRepository getVillePersistence() {
/* 214 */     return this.villeRepository;
/*     */   }
/*     */ 
/*     */   public void setVillePersistence(VilleRepository villePersistence) {
/* 218 */     this.villeRepository = villeRepository;
/*     */   }
/*     */ 
/*     */   public DLCLocalService getDLCLocalService() {
/* 222 */     return this.dlcLocalService;
/*     */   }
/*     */ 
/*     */   public void setDLCLocalService(DLCLocalService dlcLocalService) {
/* 226 */     this.dlcLocalService = dlcLocalService;
/*     */   }
/*     */ 
/*     */   public DLCRepository getDLCPersistence() {
/* 230 */     return this.dlcRepository;
/*     */   }
/*     */ 
/*     */   public void setDLCPersistence(DLCRepository dlcPersistence) {
/* 234 */     this.dlcRepository = dlcRepository;
/*     */   }
/*     */ 
/*     */   public DirectionRegionaleLocalService getDirectionRegionaleLocalService() {
/* 238 */     return this.directionRegionaleLocalService;
/*     */   }
/*     */ 
/*     */   public void setDirectionRegionaleLocalService(DirectionRegionaleLocalService directionRegionaleLocalService)
/*     */   {
/* 243 */     this.directionRegionaleLocalService = directionRegionaleLocalService;
/*     */   }
/*     */ 
/*     */   public DirectionRegionaleRepository getDirectionRegionalePersistence() {
/* 247 */     return this.directionRegionaleRepository;
/*     */   }
/*     */ 
/*     */   public void setDirectionRegionalePersistence(DirectionRegionaleRepository directionRegionalePersistence)
/*     */   {
/* 252 */     this.directionRegionaleRepository = directionRegionaleRepository;
/*     */   }
/*     */ 
/*     */   public IndexReelLocalService getIndexReelLocalService() {
/* 256 */     return this.indexReelLocalService;
/*     */   }
/*     */ 
/*     */   public void setIndexReelLocalService(IndexReelLocalService indexReelLocalService)
/*     */   {
/* 261 */     this.indexReelLocalService = indexReelLocalService;
/*     */   }
/*     */ 
/*     */   public IndexReelRepository getIndexReelPersistence() {
/* 265 */     return this.indexReelRepository;
/*     */   }
/*     */ 
/*     */   public void setIndexReelPersistence(IndexReelRepository indexReelPersistence)
/*     */   {
/* 270 */     this.indexReelRepository = indexReelRepository;
/*     */   }
/*     */ 
/*     */   public PIECESAPLocalService getPIECESAPLocalService() {
/* 274 */     return this.piecesapLocalService;
/*     */   }
/*     */ 
/*     */   public void setPIECESAPLocalService(PIECESAPLocalService piecesapLocalService)
/*     */   {
/* 279 */     this.piecesapLocalService = piecesapLocalService;
/*     */   }
/*     */ 
/*     */   public PIECESAPRepository getPIECESAPPersistence() {
/* 283 */     return this.piecesapRepository;
/*     */   }
/*     */ 
/*     */   public void setPIECESAPPersistence(PIECESAPRepository piecesapPersistence) {
/* 287 */     this.piecesapRepository = piecesapRepository;
/*     */   }
/*     */ 
/*     */   public UserDLCLocalService getUserDLCLocalService() {
/* 291 */     return this.userDLCLocalService;
/*     */   }
/*     */ 
/*     */   public void setUserDLCLocalService(UserDLCLocalService userDLCLocalService) {
/* 295 */     this.userDLCLocalService = userDLCLocalService;
/*     */   }
/*     */ 
/*     */   public UserDLCRepository getUserDLCPersistence() {
/* 299 */     return this.userDLCRepository;
/*     */   }
/*     */ 
/*     */   public void setUserDLCPersistence(UserDLCRepository userDLCPersistence) {
/* 303 */     this.userDLCRepository = userDLCRepository;
/*     */   }
/*     */ 
/*     */   public IocDLCLocalService getIocDLCLocalService() {
/* 307 */     return this.iocDLCLocalService;
/*     */   }
/*     */ 
/*     */   public void setIocDLCLocalService(IocDLCLocalService iocDLCLocalService) {
/* 311 */     this.iocDLCLocalService = iocDLCLocalService;
/*     */   }
/*     */ 
/*     */   public IocDLCRepository getIocDLCPersistence() {
/* 315 */     return this.iocDLCRepository;
/*     */   }
/*     */ 
/*     */   public void setIocDLCPersistence(IocDLCRepository iocDLCPersistence) {
/* 319 */     this.iocDLCRepository = iocDLCRepository;
/*     */   }
/*     */ 
/*     */   public MemoireDLCLocalService getMemoireDLCLocalService() {
/* 323 */     return this.memoireDLCLocalService;
/*     */   }
/*     */ 
/*     */   public void setMemoireDLCLocalService(MemoireDLCLocalService memoireDLCLocalService)
/*     */   {
/* 328 */     this.memoireDLCLocalService = memoireDLCLocalService;
/*     */   }
/*     */ 
/*     */   public MemoireDLCRepository getMemoireDLCPersistence() {
/* 332 */     return this.memoireDLCRepository;
/*     */   }
/*     */ 
/*     */   public void setMemoireDLCPersistence(MemoireDLCRepository memoireDLCPersistence)
/*     */   {
/* 337 */     this.memoireDLCRepository = memoireDLCRepository;
/*     */   }
/*     */ }

/* Location:           D:\Alignement\ext-impl.jar
 * Qualified Name:     ma.iam.wissal.gfee.business.base.IndexReelLocalServiceBaseImpl
 * JD-Core Version:    0.5.4
 */