/*     */ package ma.iam.wissal.gfee.business.base;
/*     */ 
/*     */ 
/*     */ 

/*     */ import java.util.List;
/*     */ import javax.annotation.Resource;
/*     */ import ma.iam.wissal.gfee.domain.Ville;
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
/*     */ public abstract class VilleLocalServiceBaseImpl
/*     */   implements VilleLocalService
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
/*     */   public Ville addVille(Ville ville)
/*     */     throws RuntimeException
/*     */   {
/*     */ 
/*  89 */     return this.villeRepository.save(ville);
/*     */   }
/*     */ 
/*     */   public void deleteVille(long idVille) throws Exception, RuntimeException
/*     */   {
/*  98 */     this.villeRepository.deleteById(idVille);
/*     */   }
/*     */ 
/*     */   public void deleteVille(Ville ville) throws RuntimeException {
/* 102 */     this.villeRepository.deleteById(ville.getId());
/*     */   }
/*     */ 
/*     */   public Ville getVille(long idVille) throws Exception, RuntimeException {
/* 116 */     return this.villeRepository.findById(idVille).get();
/*     */   }
/*     */ 
/*     */   public List<Ville> getVilles() throws RuntimeException {
/* 120 */     return this.villeRepository.findAll();
/*     */   }
/*     */ 
/*     */   public int getVillesCount() throws RuntimeException {
/* 124 */     return (int) this.villeRepository.count();
/*     */   }
/*     */ 
/*     */   public Ville updateVille(Ville ville) throws RuntimeException {
/*     */ 
/* 130 */     return this.villeRepository.save(ville);
/*     */   }
/*     */ 
/*     */   public IOCLocalService getIOCLocalService() {
/* 134 */     return this.iocLocalService;
/*     */   }
/*     */ 
/*     */   public void setIOCLocalService(IOCLocalService iocLocalService) {
/* 138 */     this.iocLocalService = iocLocalService;
/*     */   }
/*     */ 
/*     */   public IOCRepository getIOCPersistence() {
/* 142 */     return this.iocRepository;
/*     */   }
/*     */ 
/*     */   public void setIOCPersistence(IOCRepository iocPersistence) {
/* 146 */     this.iocRepository = iocRepository;
/*     */   }
/*     */ 
/*     */   public FactureLocalService getFactureLocalService() {
/* 150 */     return this.factureLocalService;
/*     */   }
/*     */ 
/*     */   public void setFactureLocalService(FactureLocalService factureLocalService) {
/* 154 */     this.factureLocalService = factureLocalService;
/*     */   }
/*     */ 
/*     */   public FactureRepository getFacturePersistence() {
/* 158 */     return this.factureRepository;
/*     */   }
/*     */ 
/*     */   public void setFacturePersistence(FactureRepository facturePersistence) {
/* 162 */     this.factureRepository = factureRepository;
/*     */   }
/*     */ 
/*     */   public MemoireLocalService getMemoireLocalService() {
/* 166 */     return this.memoireLocalService;
/*     */   }
/*     */ 
/*     */   public void setMemoireLocalService(MemoireLocalService memoireLocalService) {
/* 170 */     this.memoireLocalService = memoireLocalService;
/*     */   }
/*     */ 
/*     */   public MemoireRepository getMemoirePersistence() {
/* 174 */     return this.memoireRepository;
/*     */   }
/*     */ 
/*     */   public void setMemoirePersistence(MemoireRepository memoirePersistence) {
/* 178 */     this.memoireRepository = memoireRepository;
/*     */   }
/*     */ 
/*     */   public FournisseurLocalService getFournisseurLocalService() {
/* 182 */     return this.fournisseurLocalService;
/*     */   }
/*     */ 
/*     */   public void setFournisseurLocalService(FournisseurLocalService fournisseurLocalService)
/*     */   {
/* 187 */     this.fournisseurLocalService = fournisseurLocalService;
/*     */   }
/*     */ 
/*     */   public FournisseurRepository getFournisseurPersistence() {
/* 191 */     return this.fournisseurRepository;
/*     */   }
/*     */ 
/*     */   public void setFournisseurPersistence(FournisseurRepository fournisseurPersistence)
/*     */   {
/* 196 */     this.fournisseurRepository = fournisseurRepository;
/*     */   }
/*     */ 
/*     */   public VilleLocalService getVilleLocalService() {
/* 200 */     return this.villeLocalService;
/*     */   }
/*     */ 
/*     */   public void setVilleLocalService(VilleLocalService villeLocalService) {
/* 204 */     this.villeLocalService = villeLocalService;
/*     */   }
/*     */ 
/*     */   public VilleRepository getVillePersistence() {
/* 208 */     return this.villeRepository;
/*     */   }
/*     */ 
/*     */   public void setVillePersistence(VilleRepository villePersistence) {
/* 212 */     this.villeRepository = villeRepository;
/*     */   }
/*     */ 
/*     */   public DLCLocalService getDLCLocalService() {
/* 216 */     return this.dlcLocalService;
/*     */   }
/*     */ 
/*     */   public void setDLCLocalService(DLCLocalService dlcLocalService) {
/* 220 */     this.dlcLocalService = dlcLocalService;
/*     */   }
/*     */ 
/*     */   public DLCRepository getDLCPersistence() {
/* 224 */     return this.dlcRepository;
/*     */   }
/*     */ 
/*     */   public void setDLCPersistence(DLCRepository dlcPersistence) {
/* 228 */     this.dlcRepository = dlcRepository;
/*     */   }
/*     */ 
/*     */   public DirectionRegionaleLocalService getDirectionRegionaleLocalService() {
/* 232 */     return this.directionRegionaleLocalService;
/*     */   }
/*     */ 
/*     */   public void setDirectionRegionaleLocalService(DirectionRegionaleLocalService directionRegionaleLocalService)
/*     */   {
/* 237 */     this.directionRegionaleLocalService = directionRegionaleLocalService;
/*     */   }
/*     */ 
/*     */   public DirectionRegionaleRepository getDirectionRegionalePersistence() {
/* 241 */     return this.directionRegionaleRepository;
/*     */   }
/*     */ 
/*     */   public void setDirectionRegionalePersistence(DirectionRegionaleRepository directionRegionalePersistence)
/*     */   {
/* 246 */     this.directionRegionaleRepository = directionRegionaleRepository;
/*     */   }
/*     */ 
/*     */   public IndexReelLocalService getIndexReelLocalService() {
/* 250 */     return this.indexReelLocalService;
/*     */   }
/*     */ 
/*     */   public void setIndexReelLocalService(IndexReelLocalService indexReelLocalService)
/*     */   {
/* 255 */     this.indexReelLocalService = indexReelLocalService;
/*     */   }
/*     */ 
/*     */   public IndexReelRepository getIndexReelPersistence() {
/* 259 */     return this.indexReelRepository;
/*     */   }
/*     */ 
/*     */   public void setIndexReelPersistence(IndexReelRepository indexReelPersistence)
/*     */   {
/* 264 */     this.indexReelRepository = indexReelRepository;
/*     */   }
/*     */ 
/*     */   public PIECESAPLocalService getPIECESAPLocalService() {
/* 268 */     return this.piecesapLocalService;
/*     */   }
/*     */ 
/*     */   public void setPIECESAPLocalService(PIECESAPLocalService piecesapLocalService)
/*     */   {
/* 273 */     this.piecesapLocalService = piecesapLocalService;
/*     */   }
/*     */ 
/*     */   public PIECESAPRepository getPIECESAPPersistence() {
/* 277 */     return this.piecesapRepository;
/*     */   }
/*     */ 
/*     */   public void setPIECESAPPersistence(PIECESAPRepository piecesapPersistence) {
/* 281 */     this.piecesapRepository = piecesapRepository;
/*     */   }
/*     */ 
/*     */   public UserDLCLocalService getUserDLCLocalService() {
/* 285 */     return this.userDLCLocalService;
/*     */   }
/*     */ 
/*     */   public void setUserDLCLocalService(UserDLCLocalService userDLCLocalService) {
/* 289 */     this.userDLCLocalService = userDLCLocalService;
/*     */   }
/*     */ 
/*     */   public UserDLCRepository getUserDLCPersistence() {
/* 293 */     return this.userDLCRepository;
/*     */   }
/*     */ 
/*     */   public void setUserDLCPersistence(UserDLCRepository userDLCPersistence) {
/* 297 */     this.userDLCRepository = userDLCRepository;
/*     */   }
/*     */ 
/*     */   public IocDLCLocalService getIocDLCLocalService() {
/* 301 */     return this.iocDLCLocalService;
/*     */   }
/*     */ 
/*     */   public void setIocDLCLocalService(IocDLCLocalService iocDLCLocalService) {
/* 305 */     this.iocDLCLocalService = iocDLCLocalService;
/*     */   }
/*     */ 
/*     */   public IocDLCRepository getIocDLCPersistence() {
/* 309 */     return this.iocDLCRepository;
/*     */   }
/*     */ 
/*     */   public void setIocDLCPersistence(IocDLCRepository iocDLCPersistence) {
/* 313 */     this.iocDLCRepository = iocDLCRepository;
/*     */   }
/*     */ 
/*     */   public MemoireDLCLocalService getMemoireDLCLocalService() {
/* 317 */     return this.memoireDLCLocalService;
/*     */   }
/*     */ 
/*     */   public void setMemoireDLCLocalService(MemoireDLCLocalService memoireDLCLocalService)
/*     */   {
/* 322 */     this.memoireDLCLocalService = memoireDLCLocalService;
/*     */   }
/*     */ 
/*     */   public MemoireDLCRepository getMemoireDLCPersistence() {
/* 326 */     return this.memoireDLCRepository;
/*     */   }
/*     */ 
/*     */   public void setMemoireDLCPersistence(MemoireDLCRepository memoireDLCPersistence)
/*     */   {
/* 331 */     this.memoireDLCRepository = memoireDLCRepository;
/*     */   }
/*     */ }

/* Location:           D:\Alignement\ext-impl.jar
 * Qualified Name:     ma.iam.wissal.gfee.business.base.VilleLocalServiceBaseImpl
 * JD-Core Version:    0.5.4
 */