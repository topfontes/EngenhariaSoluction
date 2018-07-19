/*     */ package br.com.easynet.easyportal.modelos_pdf;
/*     */ 
/*     */ import br.com.easynet.gwt.easyportal.dao.Ctp_conta_pagarDAO;
/*     */ import br.com.easynet.gwt.easyportal.jb.Funcoes;
/*     */ import br.com.easynet.gwt.easyportal.jb.SystemBase;
/*     */ import br.com.easynet.gwt.easyportal.transfer.Ctp_conta_pagarT;
/*     */ import br.com.jdragon.dao.DAOFactory;
/*     */ import java.io.File;
/*     */ import java.io.InputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Set;
/*     */ import java.util.TreeMap;
/*     */ import jxl.Cell;
/*     */ import jxl.Sheet;
/*     */ import jxl.Workbook;
/*     */ import jxl.WorkbookSettings;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LMarquezzoAPagarXLS
/*     */   extends SystemBase
/*     */ {
/*     */   private List<Ctp_conta_pagarT> list;
/*  34 */   private TreeMap<String, Ctp_conta_pagarT> treeConta = new TreeMap();
/*     */   private Ctp_conta_pagarT ctp_conta_pagarT;
/*     */   private Ctp_conta_pagarDAO ctp_conta_pagarDAO;
/*     */   private String linha;
/*     */   private InputStream is;
/*  39 */   private Funcoes funcoes = new Funcoes();
/*     */   private double totalImp;
/*     */   private File file;
/*     */   private DAOFactory dao;
/*     */   private String quebraPaginaCodigo;
/*     */   private String status;
/*     */   private float valor;
/*     */   private Date dt_baixa;
/*     */   private static final String ASPAS = "\"";
/*  48 */   private TreeMap<String, String> treNumero = new TreeMap();
/*  49 */   private TreeMap<String, Ctp_conta_pagarT> treeMesAtual = new TreeMap();
/*     */   
/*     */   public void povoaTreeNumero() {
/*  52 */     this.treNumero.put("0", "0");
/*  53 */     this.treNumero.put("1", "1");
/*  54 */     this.treNumero.put("2", "2");
/*  55 */     this.treNumero.put("3", "3");
/*  56 */     this.treNumero.put("4", "4");
/*  57 */     this.treNumero.put("5", "5");
/*  58 */     this.treNumero.put("6", "6");
/*  59 */     this.treNumero.put("7", "7");
/*  60 */     this.treNumero.put("8", "8");
/*  61 */     this.treNumero.put("9", "9");
/*     */   }
/*     */   
/*     */   public LMarquezzoAPagarXLS(Ctp_conta_pagarT ctp_conta_pagarT, Ctp_conta_pagarDAO cdao, InputStream is) throws Exception {
/*  65 */     this.ctp_conta_pagarT = ctp_conta_pagarT;
/*  66 */     this.ctp_conta_pagarDAO = cdao;
/*  67 */     this.is = is;
/*  68 */     this.status = this.status;
/*  69 */     povoaTreeNumero();
/*  70 */     povoaConta();
/*     */   }
/*     */   
/*     */   public void pageLoad() throws Exception
/*     */   {
/*  75 */     super.pageLoad();
/*     */   }
/*     */   
/*     */   public void povoaConta()
/*     */   {
/*     */     try {
/*  81 */       this.treeConta = this.ctp_conta_pagarDAO.getByObr_nr_idTree(this.ctp_conta_pagarT);
/*  82 */       TreeMap<String, Ctp_conta_pagarT> treeTemp = new TreeMap();
/*     */       
/*  84 */       Set<String> keys = this.treeConta.keySet();
/*  85 */       for (Iterator<String> it = keys.iterator(); it.hasNext();) {
/*  86 */         String key = (String)it.next();
/*  87 */         String keyok = clearEspaco(key);
/*  88 */         treeTemp.put(keyok, this.treeConta.get(key));
/*     */       }
/*     */       
/*  91 */       this.treeConta.clear();
/*  92 */       this.treeConta = treeTemp;
/*  93 */       //it = 1;
/*     */     }
/*     */     catch (Exception localException) {}
/*     */   }
/*     */   
/*     */   public String clearEspaco(String valor)
/*     */   {
/* 100 */     if (valor.indexOf("SE") > -1) {
/* 101 */       int i = 1;
/*     */     }
/* 103 */     String novovalor = "";
/* 104 */     int p = 0;
/* 105 */     for (int i = 0; i < valor.length(); i++) {
/* 106 */       String ch = valor.substring(i, i + 1);
/* 107 */       if (this.treNumero.get(ch) != null) {
/* 108 */         p = i;
/* 109 */         break;
/*     */       }
/*     */     }
/* 112 */     novovalor = valor.substring(p, valor.length());
/* 113 */     return novovalor;
/*     */   }
/*     */   
/*     */   public boolean contaExisteID(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
/*     */     try {
/* 118 */       return this.ctp_conta_pagarDAO.getByPK(ctp_conta_pagarT).size() > 0;
/*     */     } catch (Exception e) {
/* 120 */       throw e;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean contaExiste(String key)
/*     */   {
/* 128 */     Ctp_conta_pagarT ct = (Ctp_conta_pagarT)this.treeConta.get(key);
/* 129 */     if (this.treeConta.get(key) != null) {
/* 130 */       return true;
/*     */     }
/* 132 */     return false;
/*     */   }
/*     */   
/*     */   public String read()
/*     */   {
/* 137 */     int lin = 24;
/*     */     try {
/* 139 */       povoaConta();
/* 140 */       WorkbookSettings ws = new WorkbookSettings();
/* 141 */       ws.setEncoding("ISO-8859-1");
/* 142 */       ws.setLocale(new Locale("pt", "BR"));
/* 143 */       Workbook workbook = Workbook.getWorkbook(this.is, ws);
/*     */       
/* 145 */       Sheet sheet = workbook.getSheet(0);
/*     */       
/*     */ 
/* 148 */       double valorLido = 0.0D;
/* 149 */       double valorImp = 0.0D;
/* 150 */       String doc = "";
/* 151 */       String key = "";
/* 152 */       String nome = "";
/* 153 */       String data = "";
/* 154 */       String vlunit = "";
/* 155 */       String vlTotal = "";
/*     */       
/*     */ 
/* 158 */       this.dao = this.ctp_conta_pagarDAO.getDAOFactory();
/*     */       
/* 160 */       this.dao.beginTransaction();
/* 161 */       int linha = 0;
/* 162 */       int cont = 464821;
/* 163 */       int continsert = 0;
/* 164 */       String dt_emissao = "";
/* 165 */       String obs = "";
/*     */       
/* 167 */       SimpleDateFormat sdf4 = new SimpleDateFormat("dd/MM/yyyy");
/* 168 */       SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yy");
/* 169 */       String dataEmi; for (int i = 0; i < sheet.getRows() - 1; i++) {
/* 170 */         linha++;
/*     */         
/*     */ 
/*     */ 

/*     */         
/* 178 */         if (linha > 1) {
/* 179 */           cont++;
/* 180 */           nome = sheet.getCell(0, i).getContents().trim();
/* 181 */           doc = sheet.getCell(3, i).getContents().trim();
/* 182 */           obs = sheet.getCell(7, i).getContents().trim();
/* 183 */           doc = doc.replace(" ", "");
/*     */           
/*     */ 
/*     */ 
/* 187 */           dataEmi = sheet.getCell(5, i).getContents().trim();
/* 188 */           data = sheet.getCell(5, i).getContents().trim();
/* 189 */           vlunit = sheet.getCell(8, i).getContents().trim();
/*     */           
/* 191 */           if (doc.equalsIgnoreCase("33569/01")) {
/* 192 */             System.out.println("data = " + data);
/* 193 */             System.out.println("data = " + dataEmi);
/*     */           }
/*     */           
/*     */ 
/* 197 */           vlunit = formatValueFloat(vlunit);
/* 198 */           if (!valorValido(vlunit)) {
/* 199 */             vlunit = vlunit.replace(".", "");
/* 200 */             vlunit = vlunit.replace(",", ".");
/*     */           }
/* 202 */           if (linha == 6654) {
/* 203 */             int j = 0;
/*     */           }
/*     */           
/* 206 */           if (valorValido(vlunit)) {
/* 207 */             Ctp_conta_pagarT ctp_conta_pagarT = new Ctp_conta_pagarT();
/* 208 */             ctp_conta_pagarT.setCtp_nr_ano(this.ctp_conta_pagarT.getCtp_nr_ano());
/* 209 */             ctp_conta_pagarT.setCtp_nr_mes(this.ctp_conta_pagarT.getCtp_nr_mes());
/* 210 */             ctp_conta_pagarT.setObr_nr_id(this.ctp_conta_pagarT.getObr_nr_id());
/* 211 */             ctp_conta_pagarT.setCtp_tx_status(this.ctp_conta_pagarT.getCtp_tx_status());
/* 212 */             ctp_conta_pagarT.setPlc_nr_id(0);
/* 213 */             String dthr = new Date(System.currentTimeMillis()) + "";
/*     */             
/*     */ 
/* 216 */             Date dt = sdf2.parse(data);
/* 217 */             String dts = sdf4.format(dt);
/* 218 */             String chave = doc + "." + dts;
/*     */             
/* 220 */             if (doc.equalsIgnoreCase("33569/01"))
/*     */             {
/*     */ 
/* 223 */               dt = sdf2.parse(data);
/*     */               
/* 225 */               dts = sdf4.format(dt);
/*     */             }
/*     */             
/*     */ 
/*     */ 
/* 230 */             dthr = clearEspaco(dthr);
/* 231 */             ctp_conta_pagarT.setCtp_nr_documento(doc);
/* 232 */             ctp_conta_pagarT.setCtp_tx_fornecedor(nome.trim());
/* 233 */             ctp_conta_pagarT.setCtp_nr_valor(Float.parseFloat(vlunit));
/* 234 */             SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
/* 235 */             ctp_conta_pagarT.setCtp_dt_emissao(sdf.parse(dts));
/* 236 */             ctp_conta_pagarT.setCtp_dt_vencimento(sdf.parse(dts));
/* 237 */             ctp_conta_pagarT.setCtp_tx_obs(obs);
/*     */             
/*     */ 
/* 240 */             valorLido += Double.parseDouble(vlunit);
/* 241 */             this.treeMesAtual.put(chave, ctp_conta_pagarT);
/* 242 */             Ctp_conta_pagarT ctp = (Ctp_conta_pagarT)this.treeConta.get(chave);
/* 243 */             if (!contaExiste(chave)) {
/* 244 */               this.ctp_conta_pagarDAO.insert(ctp_conta_pagarT);
/* 245 */               valorImp += Double.parseDouble(vlunit);
/* 246 */               continsert++;
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 256 */       this.dao.commitTransaction();
/* 257 */       String msg = "Total Lido = R$ " + Funcoes.FormatoMoedaBR_Double(valorLido) + " Total Importado = R$ " + Funcoes.FormatoMoedaBR_Double(valorImp);
/* 258 */       return msg;
/*     */     } catch (Exception e) {
/* 260 */       System.out.println("Erro na linha " + this.linha);
/* 261 */       e.printStackTrace();
/*     */     } finally {
/* 263 */       this.dao.close();
/*     */     }
/* 265 */     return null;
/*     */   }
/*     */   
/*     */   private String formatValueFloat(String valor) {
/* 269 */     String newValor = valor;
/* 270 */     if (valor.length() - 3 > 0) {
/* 271 */       String vl = valor.substring(valor.length() - 3, valor.length() - 2);
/* 272 */       if (vl.equalsIgnoreCase(".")) {
/* 273 */         newValor = valor.replace(",", "");
/*     */       }
/*     */     }
/*     */     
/* 277 */     return newValor;
/*     */   }
/*     */   
/*     */   private boolean valorValido(String val) {
/*     */     try {
/* 282 */       float vl = Float.parseFloat(val);
/* 283 */       return true;
/*     */     } catch (Exception e) {}
/* 285 */     return false;
/*     */   }
/*     */   
/*     */   public String getdoc(String doc)
/*     */   {
/* 290 */     int p = getPosEspaco(doc);
/* 291 */     doc = doc.substring(p, doc.length());
/* 292 */     return doc;
/*     */   }
/*     */   
/*     */   public int getPosEspaco(String doc) {
/* 296 */     int p = 0;
/* 297 */     this.linha = doc.trim();
/* 298 */     String caracter = "";
/* 299 */     for (int i = this.linha.length(); i > 0; i--) {
/* 300 */       caracter = this.linha.substring(i - 1, i);
/* 301 */       if (caracter.equalsIgnoreCase(" ")) {
/* 302 */         p = i;
/* 303 */         break;
/*     */       }
/*     */     }
/* 306 */     return p;
/*     */   }
/*     */   
/*     */   public boolean isData(String nomeData) {
/*     */     try {
/* 311 */       nomeData = nomeData.trim();
/* 312 */       SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
/* 313 */       Date d = sdf.parse(nomeData.trim());
/* 314 */       return true;
/*     */     } catch (Exception e) {}
/* 316 */     return false;
/*     */   }
/*     */   
/*     */   public boolean linhaValida(String nomeData)
/*     */   {
/*     */     try {
/* 322 */       nomeData = nomeData.trim();
/* 323 */       SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
/* 324 */       Date d = sdf.parse(nomeData.trim());
/* 325 */       return true;
/*     */     } catch (Exception e) {}
/* 327 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/marcos/fontes3/engenharia.jar!/br/com/easynet/easyportal/modelos_pdf/LMarquezzoAPagarXLS.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */