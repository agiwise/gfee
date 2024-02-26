/*     */ package ma.iam.wissal.gfee.business.base;
/*     */ 
/*     */ import java.util.List;
/*     */ import javax.annotation.Resource;

import org.springframework.data.domain.Pageable;

/*     */ import ma.iam.wissal.gfee.domain.DirectionRegionale;
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
/*     */ public abstract class DirectionRegionaleLocalServiceBaseImpl
/*     */   implements DirectionRegionaleLocalService
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
/*     */   public DirectionRegionale addDirectionRegionale(DirectionRegionale directionRegionale)
/*     */     throws RuntimeException
/*     */   {
/*  91 */     return this.directionRegionaleRepository.save(directionRegionale);
/*     */   }
/*     */ 
/*     */   public void deleteDirectionRegionale(long idDirectionRegionale) throws Exception, RuntimeException
/*     */   {
/* 101 */     this.directionRegionaleRepository.deleteById(idDirectionRegionale);
/*     */   }
/*     */ 
/*     */   public void deleteDirectionRegionale(DirectionRegionale directionRegionale) throws RuntimeException
/*     */   {
/* 106 */     this.directionRegionaleRepository.deleteById(directionRegionale.getId());
/*     */   }
/*     */ 
///*     */   public List<Object> dynamicQuery(DynamicQuery dynamicQuery) throws RuntimeException
///*     */   {
///* 111 */     return this.directionRegionaleRepository.findWithDynamicQuery(dynamicQuery);
///*     */   }
///*     */ 
///*     */   public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start, int end) throws RuntimeException
///*     */   {
///* 116 */     return this.directionRegionaleRepository.findWithDynamicQuery(dynamicQuery, start, end);
///*     */   }
/*     */ 
/*     */   public DirectionRegionale getDirectionRegionale(long idDirectionRegionale)
/*     */     throws Exception, RuntimeException
/*     */   {
/* 122 */     return this.directionRegionaleRepository.findById(idDirectionRegionale).get();
/*     */   }
/*     */ 
/*     */   public List<DirectionRegionale> getDirectionRegionales() throws RuntimeException
/*     */   {
/* 127 */     return this.directionRegionaleRepository.findAll();
/*     */   }
/*     */ 
/*     */   public int getDirectionRegionalesCount() throws RuntimeException {
/* 131 */     return (int) this.directionRegionaleRepository.count();
/*     */   }
/*     */ 
/*     */   public DirectionRegionale updateDirectionRegionale(DirectionRegionale directionRegionale) throws RuntimeException
/*     */   {
/* 138 */     return this.directionRegionaleRepository.save(directionRegionale);
/*     */   }
/*     */ 
/*     */   public IOCLocalService getIOCLocalService() {
/* 142 */     return this.iocLocalService;
/*     */   }
/*     */ 
/*     */   public void setIOCLocalService(IOCLocalService iocLocalService) {
/* 146 */     this.iocLocalService = iocLocalService;
/*     */   }
/*     */ 
/*     */   public IOCRepository getIOCPersistence() {
/* 150 */     return this.iocRepository;
/*     */   }
/*     */ 
/*     */   public void setIOCPersistence(IOCRepository iocPersistence) {
/* 154 */     this.iocRepository = iocRepository;
/*     */   }
/*     */ 
/*     */   public FactureLocalService getFactureLocalService() {
/* 158 */     return this.factureLocalService;
/*     */   }
/*     */ 
/*     */   public void setFactureLocalService(FactureLocalService factureLocalService) {
/* 162 */     this.factureLocalService = factureLocalService;
/*     */   }
/*     */ 
/*     */   public FactureRepository getFacturePersistence() {
/* 166 */     return this.factureRepository;
/*     */   }
/*     */ 
/*     */   public void setFacturePersistence(FactureRepository facturePersistence) {
/* 170 */     this.factureRepository = factureRepository;
/*     */   }
/*     */ 
/*     */   public MemoireLocalService getMemoireLocalService() {
/* 174 */     return this.memoireLocalService;
/*     */   }
/*     */ 
/*     */   public void setMemoireLocalService(MemoireLocalService memoireLocalService) {
/* 178 */     this.memoireLocalService = memoireLocalService;
/*     */   }
/*     */ 
/*     */   public MemoireRepository getMemoirePersistence() {
/* 182 */     return this.memoireRepository;
/*     */   }
/*     */ 
/*     */   public void setMemoirePersistence(MemoireRepository memoirePersistence) {
/* 186 */     this.memoireRepository = memoireRepository;
/*     */   }
/*     */ 
/*     */   public FournisseurLocalService getFournisseurLocalService() {
/* 190 */     return this.fournisseurLocalService;
/*     */   }
/*     */ 
/*     */   public void setFournisseurLocalService(FournisseurLocalService fournisseurLocalService)
/*     */   {
/* 195 */     this.fournisseurLocalService = fournisseurLocalService;
/*     */   }
/*     */ 
/*     */   public FournisseurRepository getFournisseurPersistence() {
/* 199 */     return this.fournisseurRepository;
/*     */   }
/*     */ 
/*     */   public void setFournisseurPersistence(FournisseurRepository fournisseurPersistence)
/*     */   {
/* 204 */     this.fournisseurRepository = fournisseurRepository;
/*     */   }
/*     */ 
/*     */   public VilleLocalService getVilleLocalService() {
/* 208 */     return this.villeLocalService;
/*     */   }
/*     */ 
/*     */   public void setVilleLocalService(VilleLocalService villeLocalService) {
/* 212 */     this.villeLocalService = villeLocalService;
/*     */   }
/*     */ 
/*     */   public VilleRepository getVillePersistence() {
/* 216 */     return this.villeRepository;
/*     */   }
/*     */ 
/*     */   public void setVillePersistence(VilleRepository villePersistence) {
/* 220 */     this.villeRepository = villeRepository;
/*     */   }
/*     */ 
/*     */   public DLCLocalService getDLCLocalService() {
/* 224 */     return this.dlcLocalService;
/*     */   }
/*     */ 
/*     */   public void setDLCLocalService(DLCLocalService dlcLocalService) {
/* 228 */     this.dlcLocalService = dlcLocalService;
/*     */   }
/*     */ 
/*     */   public DLCRepository getDLCPersistence() {
/* 232 */     return this.dlcRepository;
/*     */   }
/*     */ 
/*     */   public void setDLCPersistence(DLCRepository dlcPersistence) {
/* 236 */     this.dlcRepository = dlcRepository;
/*     */   }
/*     */ 
/*     */   public DirectionRegionaleLocalService getDirectionRegionaleLocalService() {
/* 240 */     return this.directionRegionaleLocalService;
/*     */   }
/*     */ 
/*     */   public void setDirectionRegionaleLocalService(DirectionRegionaleLocalService directionRegionaleLocalService)
/*     */   {
/* 245 */     this.directionRegionaleLocalService = directionRegionaleLocalService;
/*     */   }
/*     */ 
/*     */   public DirectionRegionaleRepository getDirectionRegionalePersistence() {
/* 249 */     return this.directionRegionaleRepository;
/*     */   }
/*     */ 
/*     */   public void setDirectionRegionalePersistence(DirectionRegionaleRepository directionRegionalePersistence)
/*     */   {
/* 254 */     this.directionRegionaleRepository = directionRegionaleRepository;
/*     */   }
/*     */ 
/*     */   public IndexReelLocalService getIndexReelLocalService() {
/* 258 */     return this.indexReelLocalService;
/*     */   }
/*     */ 
/*     */   public void setIndexReelLocalService(IndexReelLocalService indexReelLocalService)
/*     */   {
/* 263 */     this.indexReelLocalService = indexReelLocalService;
/*     */   }
/*     */ 
/*     */   public IndexReelRepository getIndexReelPersistence() {
/* 267 */     return this.indexReelRepository;
/*     */   }
/*     */ 
/*     */   public void setIndexReelPersistence(IndexReelRepository indexReelPersistence)
/*     */   {
/* 272 */     this.indexReelRepository = indexReelRepository;
/*     */   }
/*     */ 
/*     */   public PIECESAPLocalService getPIECESAPLocalService() {
/* 276 */     return this.piecesapLocalService;
/*     */   }
/*     */ 
/*     */   public void setPIECESAPLocalService(PIECESAPLocalService piecesapLocalService)
/*     */   {
/* 281 */     this.piecesapLocalService = piecesapLocalService;
/*     */   }
/*     */ 
/*     */   public PIECESAPRepository getPIECESAPPersistence() {
/* 285 */     return this.piecesapRepository;
/*     */   }
/*     */ 
/*     */   public void setPIECESAPPersistence(PIECESAPRepository piecesapPersistence) {
/* 289 */     this.piecesapRepository = piecesapRepository;
/*     */   }
/*     */ 
/*     */   public UserDLCLocalService getUserDLCLocalService() {
/* 293 */     return this.userDLCLocalService;
/*     */   }
/*     */ 
/*     */   public void setUserDLCLocalService(UserDLCLocalService userDLCLocalService) {
/* 297 */     this.userDLCLocalService = userDLCLocalService;
/*     */   }
/*     */ 
/*     */   public UserDLCRepository getUserDLCPersistence() {
/* 301 */     return this.userDLCRepository;
/*     */   }
/*     */ 
/*     */   public void setUserDLCPersistence(UserDLCRepository userDLCPersistence) {
/* 305 */     this.userDLCRepository = userDLCRepository;
/*     */   }
/*     */ 
/*     */   public IocDLCLocalService getIocDLCLocalService() {
/* 309 */     return this.iocDLCLocalService;
/*     */   }
/*     */ 
/*     */   public void setIocDLCLocalService(IocDLCLocalService iocDLCLocalService) {
/* 313 */     this.iocDLCLocalService = iocDLCLocalService;
/*     */   }
/*     */ 
/*     */   public IocDLCRepository getIocDLCPersistence() {
/* 317 */     return this.iocDLCRepository;
/*     */   }
/*     */ 
/*     */   public void setIocDLCPersistence(IocDLCRepository iocDLCPersistence) {
/* 321 */     this.iocDLCRepository = iocDLCRepository;
/*     */   }
/*     */ 
/*     */   public MemoireDLCLocalService getMemoireDLCLocalService() {
/* 325 */     return this.memoireDLCLocalService;
/*     */   }
/*     */ 
/*     */   public void setMemoireDLCLocalService(MemoireDLCLocalService memoireDLCLocalService)
/*     */   {
/* 330 */     this.memoireDLCLocalService = memoireDLCLocalService;
/*     */   }
/*     */ 
/*     */   public MemoireDLCRepository getMemoireDLCPersistence() {
/* 334 */     return this.memoireDLCRepository;
/*     */   }
/*     */ 
/*     */   public void setMemoireDLCPersistence(MemoireDLCRepository memoireDLCPersistence)
/*     */   {
/* 339 */     this.memoireDLCRepository = memoireDLCRepository;
/*     */   }
/*     */ }

/* Location:           D:\Alignement\ext-impl.jar
 * Qualified Name:     ma.iam.wissal.gfee.business.base.DirectionRegionaleLocalServiceBaseImpl
 * JD-Core Version:    0.5.4
 */