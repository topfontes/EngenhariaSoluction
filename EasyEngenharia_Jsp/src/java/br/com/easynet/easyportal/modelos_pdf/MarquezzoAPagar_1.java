/*     */ package br.com.easynet.easyportal.modelos_pdf;
/*     */ 
/*     */ import br.com.easynet.gwt.easyportal.dao.Ctp_conta_pagarDAO;
/*     */ import br.com.easynet.gwt.easyportal.jb.Funcoes;
/*     */ import br.com.easynet.gwt.easyportal.jb.SystemBase;
/*     */ import br.com.easynet.gwt.easyportal.transfer.Ctp_conta_pagarT;
/*     */ import br.com.easynet.gwt.easyportal.util.ConverPDFString;
/*     */ import br.com.jdragon.dao.DAOFactory;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileReader;
/*     */ import java.io.InputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.TreeMap;
/*     */ import java.util.Vector;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
public class MarquezzoAPagar_1 extends SystemBase
{
/*     */   private List<Ctp_conta_pagarT> list;
/*  34 */   private TreeMap<String, Ctp_conta_pagarT> treeConta = new TreeMap();
/*     */   private Ctp_conta_pagarT ctp_conta_pagarT;
/*  36 */   private Ctp_conta_pagarT ctp_conta_pagarT_Insert = new Ctp_conta_pagarT();
/*     */   private Ctp_conta_pagarDAO ctp_conta_pagarDAO;
/*     */   private static String linha;
/*     */   private InputStream is;
/*  40 */   private int posDoc = 0;
/*  41 */   private Funcoes funcoes = new Funcoes();
/*     */   DAOFactory dao;
/*  43 */   private double totalImp = 0.0D;
/*  44 */   TreeMap<String, Integer> TreeNumeros = new TreeMap();
/*     */   int posVirgula;
/*  46 */   TreeMap<String, Ctp_conta_pagarT> treeMesLan = new TreeMap();
/*     */   
/*     */   public MarquezzoAPagar_1(Ctp_conta_pagarT ctp_conta_pagarT, Ctp_conta_pagarDAO cdao, InputStream is) throws Exception {
/*  49 */     this.ctp_conta_pagarT = ctp_conta_pagarT;
/*  50 */     this.ctp_conta_pagarDAO = cdao;
/*  51 */     this.is = is;
/*  52 */     this.TreeNumeros.put("0", Integer.valueOf(0));
/*  53 */     this.TreeNumeros.put("1", Integer.valueOf(1));
/*  54 */     this.TreeNumeros.put("2", Integer.valueOf(2));
/*  55 */     this.TreeNumeros.put("3", Integer.valueOf(3));
/*  56 */     this.TreeNumeros.put("4", Integer.valueOf(4));
/*  57 */     this.TreeNumeros.put("5", Integer.valueOf(5));
/*  58 */     this.TreeNumeros.put("6", Integer.valueOf(6));
/*  59 */     this.TreeNumeros.put("7", Integer.valueOf(7));
/*  60 */     this.TreeNumeros.put("8", Integer.valueOf(8));
/*  61 */     this.TreeNumeros.put("9", Integer.valueOf(9));
/*     */   }
/*     */   
/*     */ 
/*     */   public MarquezzoAPagar_1()
/*     */   {
/*  67 */     this.TreeNumeros.put("0", Integer.valueOf(0));
/*  68 */     this.TreeNumeros.put("1", Integer.valueOf(1));
/*  69 */     this.TreeNumeros.put("2", Integer.valueOf(2));
/*  70 */     this.TreeNumeros.put("3", Integer.valueOf(3));
/*  71 */     this.TreeNumeros.put("4", Integer.valueOf(4));
/*  72 */     this.TreeNumeros.put("5", Integer.valueOf(5));
/*  73 */     this.TreeNumeros.put("6", Integer.valueOf(6));
/*  74 */     this.TreeNumeros.put("7", Integer.valueOf(7));
/*  75 */     this.TreeNumeros.put("8", Integer.valueOf(8));
/*  76 */     this.TreeNumeros.put("9", Integer.valueOf(9));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void deletarAllContas()
/*     */     throws Exception
/*     */   {
/*  92 */     if (this.ctp_conta_pagarT.getCtp_tx_status().equalsIgnoreCase("A")) {
/*  93 */       this.ctp_conta_pagarDAO.deleteAll(this.ctp_conta_pagarT);
/*     */     }
/*     */   }
/*     */   
/*     */   public void povoaConta()
/*     */   {
/*     */     try {
/* 100 */       this.treeConta = this.ctp_conta_pagarDAO.getByObr_nr_idTree(this.ctp_conta_pagarT);
/*     */     }
/*     */     catch (Exception localException) {}
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean contaExiste(String key)
/*     */   {
/* 109 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isDocumento()
/*     */   {
/* 114 */     int index = linha.indexOf("NO ");
/* 115 */     String lintemp = linha;
/* 116 */     boolean achou = false;
/* 117 */     int p = 0;
/*     */     
/* 119 */     if (index > -1) {
/* 120 */       index += 3;
/*     */       do
/*     */       {
/* 123 */         p = lintemp.indexOf(",");
/* 124 */         if (p > -1) {
/* 125 */           p += 3;
/* 126 */           String v = lintemp.substring(index, p).trim();
/* 127 */           v = v.replace(".", "");
/* 128 */           v = v.replace(",", ".");
/*     */           try
/*     */           {
/* 131 */             float n = Float.parseFloat(v);
/* 132 */             achou = true;
/* 133 */             this.posDoc = p;
/*     */           }
/*     */           catch (Exception e) {
/* 136 */             lintemp = lintemp.substring(p, lintemp.length());
/* 137 */             index = lintemp.indexOf("NO ");
/*     */           }
/*     */         }
/* 140 */       } while (((!achou ? 1 : 0) & (index - lintemp.length() > 3 ? 1 : 0)) != 0);
/*     */       
/* 142 */       return achou;
/*     */     }
/*     */     
/* 145 */     return false;
/*     */   }
/*     */   
/*     */   public String getCodigo()
/*     */   {
/* 150 */     String cod = linha.substring(this.posDoc, linha.length()).trim();
/* 151 */     return cod;
/*     */   }
/*     */   
public String getFornecedor()
{
int idxFor = linha.indexOf("Fornecedor");
String codFor = linha.substring(idxFor + 11, idxFor + 14).trim();
try {
int codf = Integer.parseInt(codFor);
return linha.substring(0, linha.indexOf("Fornecedor"));
} catch (Exception e) {}
return linha.substring(11, linha.length()).trim();
 }

public boolean isVencimento() {
        boolean res = false;
        try {
            if (linha.length() >= 12) {
                String nome = linha.substring(0, 12).trim();
                if ("Vencimento:".equalsIgnoreCase(nome)) {
                    res = true;
                } else {
                    nome = linha.substring(0, 7).trim();
                    res = "Baixa:".equalsIgnoreCase(nome);
                }
            }
            return res;
        } catch (Exception e) {
            return false;
        }
    }
/*     */   
/*     */   public Date getVencimento()
/*     */   {
/*     */     try {
/* 189 */       int index = linha.indexOf(":");
/* 190 */       String d1 = linha.substring(index + 1, linha.length()).trim();
/* 191 */       SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
/* 192 */       return sdf.parse(d1);
/*     */     }
/*     */     catch (Exception localException) {}
/*     */     
/*     */ 
/*     */ 
/* 198 */     return null;
/*     */   }
/*     */   
/*     */   public String getObs()
/*     */   {
/* 203 */     return linha.trim();
/*     */   }
/*     */   
/*     */   public String getObsValor()
/*     */   {
/* 208 */     int index = linha.indexOf("-");
/*     */     
/* 210 */     return linha.substring(index, linha.length()).trim();
/*     */   }
/*     */   
/*     */   public int posVirgula(String testo)
/*     */   {
/* 215 */     int p = 0;
/* 216 */     for (int i = testo.length(); i > 0; i--) {
/* 217 */       String l = testo.substring(i - 1, i);
/* 218 */       if (l.equalsIgnoreCase(",")) {
/* 219 */         p = i;
/* 220 */         i = 0;
/*     */       }
/*     */     }
/* 223 */     return p;
/*     */   }
/*     */   
/*     */   public int posEspaco()
/*     */   {
/* 228 */     int p = 0;
/*     */     
/* 230 */     for (int i = this.posVirgula; i > 0; i--) {
/* 231 */       String l = linha.substring(i - 1, i);
/* 232 */       if (l.equalsIgnoreCase(" ")) {
/* 233 */         p = i;
/* 234 */         i = 0;
/*     */       }
/*     */     }
/* 237 */     return p;
/*     */   }
/*     */   
/*     */   public boolean isDocumento2()
/*     */   {
/*     */     try {
/* 243 */       boolean res = false;
/* 244 */       if (linha.indexOf("/04/G,104/09") > -1) {
/* 245 */         int i = 0;
/*     */       }
/*     */       
/* 248 */       int duasVirgula = linha.indexOf(",,");
/* 249 */       if (duasVirgula > -1) {
/* 250 */         return false;
/*     */       }
/*     */       
/* 253 */       int posBarra = 0;
/* 254 */       int index = linha.length();
/* 255 */       String barra = linha.substring(index - 2, index - 1);
/* 256 */       if (barra.equalsIgnoreCase("/")) {
/* 257 */         posBarra = index - 2;
/* 258 */         String nm = linha.substring(index - 3, index - 2).trim();
/* 259 */         if (this.TreeNumeros.get(nm) != null) {
/* 260 */           nm = linha.substring(index - 1, index);
/* 261 */           if (this.TreeNumeros.get(nm) != null) {
/* 262 */             res = true;
/* 263 */             posBarra = index - 2;
/*     */           }
/*     */         }
/*     */       } else {
/* 267 */         barra = linha.substring(index - 3, index - 2);
/* 268 */         if (barra.equalsIgnoreCase("/")) {
/* 269 */           posBarra = index - 2;
/* 270 */           String nm = linha.substring(index - 4, index - 3).trim();
/* 271 */           if (this.TreeNumeros.get(nm) != null) {
/* 272 */             nm = linha.substring(index - 2, index - 1);
/* 273 */             if (this.TreeNumeros.get(nm) != null) {
/* 274 */               res = true;
/* 275 */               posBarra = index - 3;
/*     */             }
/*     */           }
/*     */         } else {
/* 279 */           barra = linha.substring(index - 4, index - 3);
/* 280 */           if (barra.equalsIgnoreCase("/")) {
/* 281 */             posBarra = index - 2;
/* 282 */             String nm = linha.substring(index - 5, index - 4).trim();
/* 283 */             if (this.TreeNumeros.get(nm) != null) {
/* 284 */               nm = linha.substring(index - 3, index - 2);
/* 285 */               if (this.TreeNumeros.get(nm) != null) {
/* 286 */                 res = true;
/* 287 */                 posBarra = index - 4;
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 294 */       String[] qtBarra = linha.split("/");
/*     */       
/* 296 */       if (res) {
/* 297 */         boolean caracterNumero = true;
/* 298 */         for (int i = posBarra; i < linha.length(); i--) {
/* 299 */           String carac = linha.substring(i - 1, i);
/* 300 */           if (this.TreeNumeros.get(carac) == null) {
/* 301 */             if ((carac.equalsIgnoreCase(",") & caracterNumero)) {
/* 302 */               int pe = posEspaco(linha, i);
/* 303 */               this.posDoc = (i + 2);
/*     */               
/* 305 */               String valor = linha.substring(pe, this.posDoc);
/* 306 */               this.posVirgula = i;
/* 307 */               res = new_ValorValido();
/* 308 */               break;
/*     */             }
/* 310 */             caracterNumero = false;
/* 311 */             res = false;
/* 312 */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 317 */         index = linha.indexOf("NO");
/*     */         
/* 319 */         if (index > -1) {
/* 320 */           int index2 = linha.indexOf(",");
/* 321 */           if (((index2 > -1 ? 1 : 0) & (index2 > index ? 1 : 0)) != 0) {
/* 322 */             String num = linha.substring(index2 + 1, index2 + 2);
/*     */             try {
/* 324 */               int n = Integer.parseInt(num);
/* 325 */               num = linha.substring(index2 + 2, index2 + 3);
/* 326 */               n = Integer.parseInt(num);
/* 327 */               res = true;
/* 328 */               this.posVirgula = index2;
/*     */             } catch (Exception e) {
/* 330 */               res = false;
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/* 335 */       return res;
/*     */     } catch (Exception e) {}
/* 337 */     return false;
/*     */   }
/*     */   
/*     */   public boolean new_ValorValido()
/*     */   {
/*     */     try {
/* 343 */       float valor = getValor();
/* 344 */       return true;
/*     */     } catch (Exception e) {}
/* 346 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isValorValidos()
/*     */   {
/* 351 */     boolean bl = false;
/*     */     try {
/* 353 */       int id = linha.indexOf(",");
/* 354 */       if (id > -1) {
/* 355 */         for (int i = id; i < linha.length(); i++) {
/* 356 */           String fracao1 = linha.substring(i, i + 1);
/*     */           
/* 358 */           if (this.TreeNumeros.get(fracao1) != null) {
/* 359 */             String fracao2 = linha.substring(i + 1, i + 2);
/*     */             
/* 361 */             if (this.TreeNumeros.get(fracao2) != null) {
/* 362 */               String decimal = linha.substring(i - 2, i - 1);
/* 363 */               if (this.TreeNumeros.get(decimal) != null) {
/* 364 */                 String doc = linha.substring(i + 3, linha.length());
/*     */                 
/* 366 */                 if (doc.indexOf("/") > -1) {
/* 367 */                   bl = true;
/* 368 */                   this.posVirgula = i;
/* 369 */                   this.posDoc = (i + 2);
/* 370 */                   break;
/*     */                 }
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 382 */       return bl;
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 378 */       return false;
                } finally {
    return bl;
} 
/*     */   }
/*     */   
/*     */ 
/*     */   public int posVirgula()
/*     */   {
/* 388 */     int p = 0;
/* 389 */     for (int i = linha.length(); 
/* 390 */         i > 0; i--) {
/* 391 */       String l = linha.substring(i - 1, i);
/* 392 */       if (l.equalsIgnoreCase(",")) {
/* 393 */         p = i;
/* 394 */         i = 0;
/*     */       }
/*     */     }
/* 397 */     return p;
/*     */   }
/*     */   
/*     */   public int posEspaco(String testo) {
/* 401 */     int p = 0;
/* 402 */     int pos_virgula = posVirgula();
/* 403 */     for (int i = pos_virgula; 
/* 404 */         i > 0; i--) {
/* 405 */       String l = testo.substring(i - 1, i);
/* 406 */       if (l.equalsIgnoreCase(" ")) {
/* 407 */         p = i;
/* 408 */         i = 0;
/*     */       }
/*     */     }
/* 411 */     return p;
/*     */   }
/*     */   
/*     */   public int posEspaco(String testo, int posvirgula) {
/* 415 */     int p = 0;
/* 416 */     int pos_virgula = posvirgula;
/* 417 */     for (int i = pos_virgula; 
/* 418 */         i > 0; i--) {
/* 419 */       String l = testo.substring(i - 1, i);
/* 420 */       if (l.equalsIgnoreCase(" ")) {
/* 421 */         p = i;
/* 422 */         i = 0;
/*     */       }
/*     */     }
/* 425 */     return p;
/*     */   }
/*     */   
/*     */   public float getValor() throws Exception {
/* 429 */     int index = posEspaco();
/* 430 */     int index2 = posVirgula();
/* 431 */     index2 += 2;
/* 432 */     String vl = linha.substring(index, index2).trim();
/* 433 */     vl = vl.replace(".", "");
/* 434 */     vl = vl.replace(",", ".");
/* 435 */     float vlr = Float.parseFloat(vl);
/* 436 */     this.posDoc = index2;
/* 437 */     return vlr;
/*     */   }
/*     */   
/*     */   public boolean isFornecedor() throws Exception {
/*     */     try {
/* 442 */       boolean res = false;
/* 443 */       if (linha.length() >= 11) {
/* 444 */         String fornec = linha.substring(0, 11).trim();
/* 445 */         if (fornec.equalsIgnoreCase("Fornecedor")) {
/* 446 */           if (linha.indexOf("Total") < 0) {
/* 447 */             res = true;
/*     */           }
/* 449 */         } else if ((linha.indexOf("Fornecedor") <= -1) || 
/* 450 */           (linha.indexOf("Total") >= 0) || (linha.indexOf("Contas Pagar por") >= 0)) {} }
/* 451 */       return true;
/*     */     }
/*     */     catch (Exception e) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 458 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean isrodape()
/*     */   {
/* 465 */     if (linha.length() >= 4) {
/* 466 */       String fim = linha.substring(0, 4).trim();
/* 467 */       if (fim.equals("REL")) {
/* 468 */         return true;
/*     */       }
/*     */     }
/* 471 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String read()
/*     */   {
/* 482 */     File file = null;
/* 483 */     int lin = 0;
/* 484 */     SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
/*     */     try {
/* 486 */       this.list = new Vector();
/* 487 */       ConverPDFString converPDFString = new ConverPDFString();
/* 488 */       String path = converPDFString.getString(this.is);
/* 489 */       this.is.close();
/* 490 */       file = new File(path);
/* 491 */       FileReader fr = new FileReader(path);
/* 492 */       BufferedReader br = new BufferedReader(fr);
/* 493 */       boolean addhist = false;
/* 494 */       Date vencimento = null;
/* 495 */       float valor = 0.0F;
/* 496 */       String hist = "";
/* 497 */       String documento = "";
/* 498 */       String fornecedor = "";
/* 499 */       int cont_linhaRodape = 0;
/* 500 */       double total = 0.0D;
/* 501 */       this.totalImp = 0.0D;
/* 502 */       this.dao = this.ctp_conta_pagarDAO.getDAOFactory();
/* 503 */       this.dao.beginTransaction();
/* 504 */       int cont = 0;
/* 505 */       while (br.ready()) {
/* 506 */         lin++;
/* 507 */         int i; if (((lin == 28 ? 1 : 0) | (lin == 10524 ? 1 : 0) | (lin == 10497 ? 1 : 0) | (lin == 10509 ? 1 : 0)) != 0) {
/* 508 */           i = 0;
/*     */         }
/* 510 */         if (lin == 168) {
/* 511 */           i = 0;
/*     */         }
/* 513 */         linha = br.readLine();
/* 514 */         System.out.println(lin + "  " + linha);
/* 515 */         if (isrodape()) {
/* 516 */           cont_linhaRodape = 0;
/*     */         }
/* 518 */         if (isFornecedor()) {
/* 519 */           fornecedor = getFornecedor();
/* 520 */         } else if (isVencimento()) {
/* 521 */           vencimento = getVencimento();
/* 522 */           addhist = true;
/* 523 */           hist = "";
/*     */         }
/* 525 */         else if (isDocumento2())
/*     */         {
/* 527 */           valor = getValor();
/* 528 */           documento = getCodigo();
/* 529 */           System.out.println(valor);
/* 530 */           if (valor == 1058.75F) {}
/*     */           
/*     */ 
/*     */ 
/* 534 */           String key = documento + "." + sdf.format(vencimento);
/* 535 */           if (!contaExiste(key)) {
/* 536 */             addObject(fornecedor, documento, vencimento, valor, hist);
/*     */           }
/*     */           
/*     */ 
/* 540 */           cont++;
/*     */           
/* 542 */           total += valor;
/* 543 */         } else if ((addhist & cont_linhaRodape > 8)) {
/* 544 */           hist = hist + " " + getObs();
/*     */         }
/*     */         
/* 547 */         cont_linhaRodape++;
/*     */       }
/*     */       
/* 550 */       String a = "s";
/* 551 */       br.close();
/* 552 */       fr.close();
/* 553 */       this.dao.commitTransaction();
/* 554 */       return "Total Geral lido = R$" + Funcoes.FormatoMoedaBR_Double(total) + " Total Importados = R$" + Funcoes.FormatoMoedaBR_Double(this.totalImp);
/*     */     } catch (Exception e) { String path;
/* 556 */       this.dao.rollbackTransaction();
/* 557 */       e.printStackTrace();
/* 558 */       return "Erro na leitura do arquivo na linha " + lin + ", " + linha;
/*     */     } finally {
/* 560 */       file.delete();
/* 561 */       this.dao.close();
/*     */     }
/*     */   }
/*     */   
/*     */   public void addObject(String fornecedor, String documento, Date vencimento, float valor, String hist) throws Exception {
/*     */     try {
/* 567 */       this.ctp_conta_pagarT_Insert.setCtp_nr_ano(this.ctp_conta_pagarT.getCtp_nr_ano());
/* 568 */       this.ctp_conta_pagarT_Insert.setCtp_nr_mes(this.ctp_conta_pagarT.getCtp_nr_mes());
/* 569 */       this.ctp_conta_pagarT_Insert.setObr_nr_id(this.ctp_conta_pagarT.getObr_nr_id());
/* 570 */       this.ctp_conta_pagarT_Insert.setCtp_tx_status(this.ctp_conta_pagarT.getCtp_tx_status());
/* 571 */       this.ctp_conta_pagarT_Insert.setCtp_tx_fornecedor(fornecedor);
/* 572 */       this.ctp_conta_pagarT_Insert.setPlc_nr_id(0);
/* 573 */       this.ctp_conta_pagarT_Insert.setCtp_nr_documento(documento);
/* 574 */       this.ctp_conta_pagarT_Insert.setCtp_dt_vencimento(vencimento);
/* 575 */       this.ctp_conta_pagarT_Insert.setCtp_nr_valor(valor);
/*     */       
/* 577 */       String obs = hist;
/* 578 */       if (hist.length() > 299) {
/* 579 */         obs = hist.substring(0, 299).trim();
/*     */       }
/* 581 */       this.ctp_conta_pagarT_Insert.setCtp_tx_obs(obs);
/* 582 */       SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
/* 583 */       String key = this.ctp_conta_pagarT.getCtp_nr_documento() + "." + sdf.format(vencimento);
/* 584 */       this.treeConta.put(key, this.ctp_conta_pagarT);
/*     */       
/* 586 */       this.ctp_conta_pagarDAO.insert(this.ctp_conta_pagarT_Insert);
/* 587 */       this.totalImp += this.ctp_conta_pagarT_Insert.getCtp_nr_valor();
/*     */     }
/*     */     catch (Exception e) {
/* 590 */       System.out.println("Erro: " + documento);
/* 591 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/marcos/fontes3/engenharia.jar!/br/com/easynet/easyportal/modelos_pdf/MarquezzoAPagar.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */