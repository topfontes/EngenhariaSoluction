/*      */ package br.com.easynet.gwt.easyportal.bl;
/*      */ 
/*      */ import br.com.easynet.gwt.easyportal.transfer.Inp_indicador_planejamentoT;
/*      */ import br.com.easynet.gwt.easyportal.transfer.Inp_intervalo_parcelaT;
/*      */ import br.com.easynet.gwt.easyportal.transfer.Tpms_temporaria_pmsT;
/*      */ import br.com.easynet.gwt.easyportal.transfer.Vw_curva_abc_equivalenciaT;
/*      */ import br.com.easynet.gwt.easyportal.transfer.Vw_importacao_orcamentoT;
/*      */ import br.com.jdragon.dao.DAOFactory;
/*      */ import java.util.List;
/*      */ 
/*      */ public class SystemBusinessBase extends br.com.easynet.bl.BusinessBase
/*      */ {
/*   13 */   private int typeDatabase = 1;
/*   14 */   private String url = "jdbc:postgresql://127.0.0.1:5432/dbengenharia";
/*   15 */   private String user = "postgres";
/*   16 */   private String pass = "postgres";
/*      */   private DAOFactory dao;
/*   18 */   private String datasourceName = "java:comp/env/jdbc/engenhariads";
/*      */   
/*      */   /* Error */
/*      */   private void configureByteaPostgresql()
/*      */   {
/*      */     // Byte code:
/*      */     //   0: aconst_null
/*      */     //   1: astore_1
/*      */     //   2: aload_0
/*      */     //   3: getfield 11	br/com/easynet/gwt/easyportal/bl/SystemBusinessBase:dao	Lbr/com/jdragon/dao/DAOFactory;
/*      */     //   6: invokevirtual 12	br/com/jdragon/dao/DAOFactory:create	()Ljava/sql/Connection;
/*      */     //   9: pop
/*      */     //   10: aload_0
/*      */     //   11: getfield 11	br/com/easynet/gwt/easyportal/bl/SystemBusinessBase:dao	Lbr/com/jdragon/dao/DAOFactory;
/*      */     //   14: invokevirtual 13	br/com/jdragon/dao/DAOFactory:getConnection	()Ljava/sql/Connection;
/*      */     //   17: ldc 14
/*      */     //   19: invokeinterface 15 2 0
/*      */     //   24: astore_1
/*      */     //   25: aload_1
/*      */     //   26: invokeinterface 16 1 0
/*      */     //   31: pop
/*      */     //   32: aload_1
/*      */     //   33: invokeinterface 17 1 0
/*      */     //   38: goto +35 -> 73
/*      */     //   41: astore_2
/*      */     //   42: goto +31 -> 73
/*      */     //   45: astore_2
/*      */     //   46: aload_1
/*      */     //   47: invokeinterface 17 1 0
/*      */     //   52: goto +21 -> 73
/*      */     //   55: astore_2
/*      */     //   56: goto +17 -> 73
/*      */     //   59: astore_3
/*      */     //   60: aload_1
/*      */     //   61: invokeinterface 17 1 0
/*      */     //   66: goto +5 -> 71
/*      */     //   69: astore 4
/*      */     //   71: aload_3
/*      */     //   72: athrow
/*      */     //   73: return
/*      */     // Line number table:
/*      */     //   Java source line #23	-> byte code offset #0
/*      */     //   Java source line #25	-> byte code offset #2
/*      */     //   Java source line #26	-> byte code offset #10
/*      */     //   Java source line #27	-> byte code offset #25
/*      */     //   Java source line #32	-> byte code offset #32
/*      */     //   Java source line #34	-> byte code offset #38
/*      */     //   Java source line #33	-> byte code offset #41
/*      */     //   Java source line #35	-> byte code offset #42
/*      */     //   Java source line #28	-> byte code offset #45
/*      */     //   Java source line #32	-> byte code offset #46
/*      */     //   Java source line #34	-> byte code offset #52
/*      */     //   Java source line #33	-> byte code offset #55
/*      */     //   Java source line #35	-> byte code offset #56
/*      */     //   Java source line #31	-> byte code offset #59
/*      */     //   Java source line #32	-> byte code offset #60
/*      */     //   Java source line #34	-> byte code offset #66
/*      */     //   Java source line #33	-> byte code offset #69
/*      */     //   Java source line #34	-> byte code offset #71
/*      */     //   Java source line #36	-> byte code offset #73
/*      */     // Local variable table:
/*      */     //   start	length	slot	name	signature
/*      */     //   0	74	0	this	SystemBusinessBase
/*      */     //   1	60	1	ps	java.sql.PreparedStatement
/*      */     //   41	1	2	localException	Exception
/*      */     //   45	1	2	localException1	Exception
/*      */     //   55	1	2	localException2	Exception
/*      */     //   59	13	3	localObject	Object
/*      */     //   69	1	4	localException3	Exception
/*      */     // Exception table:
/*      */     //   from	to	target	type
/*      */     //   32	38	41	java/lang/Exception
/*      */     //   2	32	45	java/lang/Exception
/*      */     //   46	52	55	java/lang/Exception
/*      */     //   2	32	59	finally
/*      */     //   60	66	69	java/lang/Exception
/*      */   }
/*      */   
/*      */   public DAOFactory getDAO()
/*      */     throws Exception
/*      */   {
/*   39 */     if ((this.dao != null) && (this.dao.getConnection() != null) && (!this.dao.getConnection().isClosed())) {
/*   40 */       return this.dao;
/*      */     }
/*      */     try {
/*   43 */       String dsName = "";
/*      */       
/*   45 */       if (dsName != null) {
/*   46 */         this.datasourceName = dsName;
/*      */       }
/*   48 */       javax.sql.DataSource ds = getDataSource(this.datasourceName);
/*   49 */       this.dao = DAOFactory.getDAOFactory(this.typeDatabase, ds.getConnection());
/*      */     } catch (Exception e) {
/*   51 */       e.printStackTrace();
/*      */     } finally {
/*   53 */       configureByteaPostgresql();
/*      */     }
/*   55 */     return this.dao;
/*      */   }
/*      */   
/*      */   public DAOFactory getDAO(int typeDatabase, String url, String user, String pass) throws Exception {
/*   59 */     String urlWebConfig = "";
/*      */     
/*      */ 
/*      */ 
/*   63 */     if ((urlWebConfig == null) || 
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*   68 */       (this.dao != null)) {
/*   69 */       return this.dao;
/*      */     }
/*   71 */     this.dao = DAOFactory.getDAOFactory(typeDatabase, url, user, pass);
/*   72 */     configureByteaPostgresql();
/*   73 */     return this.dao;
/*      */   }
/*      */   
/*      */   public void close() {
/*      */     try {
/*   78 */       this.dao.close();
/*   79 */       this.dao = null;
/*      */     }
/*      */     catch (Exception localException) {}
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Cen_centro_custoDAO getCen_centro_custoDAO() throws Exception {
/*   85 */     this.dao = getDAO();
/*   86 */     return new br.com.easynet.gwt.easyportal.dao.Cen_centro_custoDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Cli_clienteDAO getCli_clienteDAO() throws Exception {
/*   90 */     this.dao = getDAO();
/*   91 */     return new br.com.easynet.gwt.easyportal.dao.Cli_clienteDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Con_contatosDAO getCon_contatosDAO() throws Exception {
/*   95 */     this.dao = getDAO();
/*   96 */     return new br.com.easynet.gwt.easyportal.dao.Con_contatosDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Emp_empreendimentoDAO getEmp_empreendimentoDAO() throws Exception {
/*  100 */     this.dao = getDAO();
/*  101 */     return new br.com.easynet.gwt.easyportal.dao.Emp_empreendimentoDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Fop_forma_pagamentoDAO getFop_forma_pagamentoDAO() throws Exception {
/*  105 */     this.dao = getDAO();
/*  106 */     return new br.com.easynet.gwt.easyportal.dao.Fop_forma_pagamentoDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.For_fornecedorDAO getFor_fornecedorDAO() throws Exception {
/*  110 */     this.dao = getDAO();
/*  111 */     return new br.com.easynet.gwt.easyportal.dao.For_fornecedorDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Grp_grupo_produtoDAO getGrp_grupo_produtoDAO() throws Exception {
/*  115 */     this.dao = getDAO();
/*  116 */     return new br.com.easynet.gwt.easyportal.dao.Grp_grupo_produtoDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Infe_item_nota_entradaDAO getInfe_item_nota_entradaDAO() throws Exception {
/*  120 */     this.dao = getDAO();
/*  121 */     return new br.com.easynet.gwt.easyportal.dao.Infe_item_nota_entradaDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Nfe_nota_fiscal_entradaDAO getNfe_nota_fiscal_entradaDAO() throws Exception {
/*  125 */     this.dao = getDAO();
/*  126 */     return new br.com.easynet.gwt.easyportal.dao.Nfe_nota_fiscal_entradaDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Obr_obrasDAO getObr_obrasDAO() throws Exception {
/*  130 */     this.dao = getDAO();
/*  131 */     return new br.com.easynet.gwt.easyportal.dao.Obr_obrasDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Par_parcelamentoDAO getPar_parcelamentoDAO() throws Exception {
/*  135 */     this.dao = getDAO();
/*  136 */     return new br.com.easynet.gwt.easyportal.dao.Par_parcelamentoDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Plc_plano_contasDAO getPlc_plano_contasDAO() throws Exception {
/*  140 */     this.dao = getDAO();
/*  141 */     return new br.com.easynet.gwt.easyportal.dao.Plc_plano_contasDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Pro_produtoDAO getPro_produtoDAO() throws Exception {
/*  145 */     this.dao = getDAO();
/*  146 */     return new br.com.easynet.gwt.easyportal.dao.Pro_produtoDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Set_setorDAO getSet_setorDAO() throws Exception {
/*  150 */     this.dao = getDAO();
/*  151 */     return new br.com.easynet.gwt.easyportal.dao.Set_setorDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Uno_unidade_obraDAO getUno_unidade_obraDAO() throws Exception {
/*  155 */     this.dao = getDAO();
/*  156 */     return new br.com.easynet.gwt.easyportal.dao.Uno_unidade_obraDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Cli_clienteT findbyIdCli_cliente(br.com.easynet.gwt.easyportal.transfer.Cli_clienteT cli_clienteT) throws Exception {
/*      */     try {
/*  161 */       br.com.easynet.gwt.easyportal.dao.Cli_clienteDAO cli_clienteDAO = getCli_clienteDAO();
/*      */       
/*  163 */       List<br.com.easynet.gwt.easyportal.transfer.Cli_clienteT> listTemp = cli_clienteDAO.getByPK(cli_clienteT);
/*      */       
/*  165 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Cli_clienteT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/*  167 */       e.printStackTrace();
/*      */     } finally {
/*  169 */       close();
/*      */     }
/*  171 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Con_contatosT findbyIdCon_contatos(br.com.easynet.gwt.easyportal.transfer.Con_contatosT con_contatosT) throws Exception {
/*      */     try {
/*  176 */       br.com.easynet.gwt.easyportal.dao.Con_contatosDAO con_contatosDAO = getCon_contatosDAO();
/*      */       
/*  178 */       List<br.com.easynet.gwt.easyportal.transfer.Con_contatosT> listTemp = con_contatosDAO.getByPK(con_contatosT);
/*      */       
/*  180 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Con_contatosT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/*  182 */       e.printStackTrace();
/*      */     } finally {
/*  184 */       close();
/*      */     }
/*  186 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Emp_empreendimentoT findbyIdEmp_empreendimento(br.com.easynet.gwt.easyportal.transfer.Emp_empreendimentoT emp_empreendimentoT) throws Exception {
/*      */     try {
/*  191 */       br.com.easynet.gwt.easyportal.dao.Emp_empreendimentoDAO emp_empreendimentoDAO = getEmp_empreendimentoDAO();
/*      */       
/*  193 */       List<br.com.easynet.gwt.easyportal.transfer.Emp_empreendimentoT> listTemp = emp_empreendimentoDAO.getByPK(emp_empreendimentoT);
/*      */       
/*  195 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Emp_empreendimentoT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/*  197 */       e.printStackTrace();
/*      */     } finally {
/*  199 */       close();
/*      */     }
/*  201 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Fop_forma_pagamentoT findbyIdFop_forma_pagamento(br.com.easynet.gwt.easyportal.transfer.Fop_forma_pagamentoT fop_forma_pagamentoT) throws Exception {
/*      */     try {
/*  206 */       br.com.easynet.gwt.easyportal.dao.Fop_forma_pagamentoDAO fop_forma_pagamentoDAO = getFop_forma_pagamentoDAO();
/*      */       
/*  208 */       List<br.com.easynet.gwt.easyportal.transfer.Fop_forma_pagamentoT> listTemp = fop_forma_pagamentoDAO.getByPK(fop_forma_pagamentoT);
/*      */       
/*  210 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Fop_forma_pagamentoT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/*  212 */       e.printStackTrace();
/*      */     } finally {
/*  214 */       close();
/*      */     }
/*  216 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.For_fornecedorT findbyIdFor_fornecedor(br.com.easynet.gwt.easyportal.transfer.For_fornecedorT for_fornecedorT) throws Exception {
/*      */     try {
/*  221 */       br.com.easynet.gwt.easyportal.dao.For_fornecedorDAO for_fornecedorDAO = getFor_fornecedorDAO();
/*      */       
/*  223 */       List<br.com.easynet.gwt.easyportal.transfer.For_fornecedorT> listTemp = for_fornecedorDAO.getByPK(for_fornecedorT);
/*      */       
/*  225 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.For_fornecedorT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/*  227 */       e.printStackTrace();
/*      */     } finally {
/*  229 */       close();
/*      */     }
/*  231 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Grp_grupo_produtoT findbyIdGrp_grupo_produto(br.com.easynet.gwt.easyportal.transfer.Grp_grupo_produtoT grp_grupo_produtoT) throws Exception {
/*      */     try {
/*  236 */       br.com.easynet.gwt.easyportal.dao.Grp_grupo_produtoDAO grp_grupo_produtoDAO = getGrp_grupo_produtoDAO();
/*      */       
/*  238 */       List<br.com.easynet.gwt.easyportal.transfer.Grp_grupo_produtoT> listTemp = grp_grupo_produtoDAO.getByPK(grp_grupo_produtoT);
/*      */       
/*  240 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Grp_grupo_produtoT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/*  242 */       e.printStackTrace();
/*      */     } finally {
/*  244 */       close();
/*      */     }
/*  246 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Infe_item_nota_entradaT findbyIdInfe_item_nota_entrada(br.com.easynet.gwt.easyportal.transfer.Infe_item_nota_entradaT infe_item_nota_entradaT) throws Exception {
/*      */     try {
/*  251 */       br.com.easynet.gwt.easyportal.dao.Infe_item_nota_entradaDAO infe_item_nota_entradaDAO = getInfe_item_nota_entradaDAO();
/*      */       
/*  253 */       List<br.com.easynet.gwt.easyportal.transfer.Infe_item_nota_entradaT> listTemp = infe_item_nota_entradaDAO.getByPK(infe_item_nota_entradaT);
/*      */       
/*  255 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Infe_item_nota_entradaT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/*  257 */       e.printStackTrace();
/*      */     } finally {
/*  259 */       close();
/*      */     }
/*  261 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Nfe_nota_fiscal_entradaT findbyIdNfe_nota_fiscal_entrada(br.com.easynet.gwt.easyportal.transfer.Nfe_nota_fiscal_entradaT nfe_nota_fiscal_entradaT) throws Exception {
/*      */     try {
/*  266 */       br.com.easynet.gwt.easyportal.dao.Nfe_nota_fiscal_entradaDAO nfe_nota_fiscal_entradaDAO = getNfe_nota_fiscal_entradaDAO();
/*      */       
/*  268 */       List<br.com.easynet.gwt.easyportal.transfer.Nfe_nota_fiscal_entradaT> listTemp = nfe_nota_fiscal_entradaDAO.getByPK(nfe_nota_fiscal_entradaT);
/*      */       
/*  270 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Nfe_nota_fiscal_entradaT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/*  272 */       e.printStackTrace();
/*      */     } finally {
/*  274 */       close();
/*      */     }
/*  276 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Obr_obrasT findbyIdObr_obras(br.com.easynet.gwt.easyportal.transfer.Obr_obrasT obr_obrasT) throws Exception {
/*      */     try {
/*  281 */       br.com.easynet.gwt.easyportal.dao.Obr_obrasDAO obr_obrasDAO = getObr_obrasDAO();
/*      */       
/*  283 */       List<br.com.easynet.gwt.easyportal.transfer.Obr_obrasT> listTemp = obr_obrasDAO.getByPK(obr_obrasT);
/*      */       
/*  285 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Obr_obrasT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/*  287 */       e.printStackTrace();
/*      */     } finally {
/*  289 */       close();
/*      */     }
/*  291 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Par_parcelamentoT findbyIdPar_parcelamento(br.com.easynet.gwt.easyportal.transfer.Par_parcelamentoT par_parcelamentoT) throws Exception {
/*      */     try {
/*  296 */       br.com.easynet.gwt.easyportal.dao.Par_parcelamentoDAO par_parcelamentoDAO = getPar_parcelamentoDAO();
/*      */       
/*  298 */       List<br.com.easynet.gwt.easyportal.transfer.Par_parcelamentoT> listTemp = par_parcelamentoDAO.getByPK(par_parcelamentoT);
/*      */       
/*  300 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Par_parcelamentoT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/*  302 */       e.printStackTrace();
/*      */     } finally {
/*  304 */       close();
/*      */     }
/*  306 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Plc_plano_contasT findbyIdPlc_plano_contas(br.com.easynet.gwt.easyportal.transfer.Plc_plano_contasT plc_plano_contasT) throws Exception {
/*      */     try {
/*  311 */       br.com.easynet.gwt.easyportal.dao.Plc_plano_contasDAO plc_plano_contasDAO = getPlc_plano_contasDAO();
/*      */       
/*  313 */       List<br.com.easynet.gwt.easyportal.transfer.Plc_plano_contasT> listTemp = plc_plano_contasDAO.getByPK(plc_plano_contasT);
/*      */       
/*  315 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Plc_plano_contasT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/*  317 */       e.printStackTrace();
/*      */     } finally {
/*  319 */       close();
/*      */     }
/*  321 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Pro_produtoT findbyIdPro_produto(br.com.easynet.gwt.easyportal.transfer.Pro_produtoT pro_produtoT) throws Exception {
/*      */     try {
/*  326 */       br.com.easynet.gwt.easyportal.dao.Pro_produtoDAO pro_produtoDAO = getPro_produtoDAO();
/*      */       
/*  328 */       List<br.com.easynet.gwt.easyportal.transfer.Pro_produtoT> listTemp = pro_produtoDAO.getByPK(pro_produtoT);
/*      */       
/*  330 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Pro_produtoT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/*  332 */       e.printStackTrace();
/*      */     } finally {
/*  334 */       close();
/*      */     }
/*  336 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Set_setorT findbyIdSet_setor(br.com.easynet.gwt.easyportal.transfer.Set_setorT set_setorT) throws Exception {
/*      */     try {
/*  341 */       br.com.easynet.gwt.easyportal.dao.Set_setorDAO set_setorDAO = getSet_setorDAO();
/*      */       
/*  343 */       List<br.com.easynet.gwt.easyportal.transfer.Set_setorT> listTemp = set_setorDAO.getByPK(set_setorT);
/*      */       
/*  345 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Set_setorT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/*  347 */       e.printStackTrace();
/*      */     } finally {
/*  349 */       close();
/*      */     }
/*  351 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Uno_unidade_obraT findbyIdUno_unidade_obra(br.com.easynet.gwt.easyportal.transfer.Uno_unidade_obraT uno_unidade_obraT) throws Exception {
/*      */     try {
/*  356 */       br.com.easynet.gwt.easyportal.dao.Uno_unidade_obraDAO uno_unidade_obraDAO = getUno_unidade_obraDAO();
/*      */       
/*  358 */       List<br.com.easynet.gwt.easyportal.transfer.Uno_unidade_obraT> listTemp = uno_unidade_obraDAO.getByPK(uno_unidade_obraT);
/*      */       
/*  360 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Uno_unidade_obraT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/*  362 */       e.printStackTrace();
/*      */     } finally {
/*  364 */       close();
/*      */     }
/*  366 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Uni_unidadeDAO getUni_unidadeDAO() throws Exception {
/*  370 */     this.dao = getDAO();
/*  371 */     return new br.com.easynet.gwt.easyportal.dao.Uni_unidadeDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Est_estoqueDAO getEst_estoqueDAO() throws Exception {
/*  375 */     this.dao = getDAO();
/*  376 */     return new br.com.easynet.gwt.easyportal.dao.Est_estoqueDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Ctp_conta_pagarDAO getCtp_conta_pagarDAO() throws Exception {
/*  380 */     this.dao = getDAO();
/*  381 */     return new br.com.easynet.gwt.easyportal.dao.Ctp_conta_pagarDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Uni_unidadeT findbyIdUni_unidade(br.com.easynet.gwt.easyportal.transfer.Uni_unidadeT uni_unidadeT) throws Exception {
/*      */     try {
/*  386 */       br.com.easynet.gwt.easyportal.dao.Uni_unidadeDAO uni_unidadeDAO = getUni_unidadeDAO();
/*      */       
/*  388 */       List<br.com.easynet.gwt.easyportal.transfer.Uni_unidadeT> listTemp = uni_unidadeDAO.getByPK(uni_unidadeT);
/*      */       
/*  390 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Uni_unidadeT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/*  392 */       e.printStackTrace();
/*      */     } finally {
/*  394 */       close();
/*      */     }
/*  396 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Est_estoqueT findbyIdEst_estoque(br.com.easynet.gwt.easyportal.transfer.Est_estoqueT est_estoqueT) throws Exception {
/*      */     try {
/*  401 */       br.com.easynet.gwt.easyportal.dao.Est_estoqueDAO est_estoqueDAO = getEst_estoqueDAO();
/*      */       
/*  403 */       List<br.com.easynet.gwt.easyportal.transfer.Est_estoqueT> listTemp = est_estoqueDAO.getByPK(est_estoqueT);
/*      */       
/*  405 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Est_estoqueT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/*  407 */       e.printStackTrace();
/*      */     } finally {
/*  409 */       close();
/*      */     }
/*  411 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Ctp_conta_pagarT findbyIdCtp_conta_pagar(br.com.easynet.gwt.easyportal.transfer.Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
/*      */     try {
/*  416 */       br.com.easynet.gwt.easyportal.dao.Ctp_conta_pagarDAO ctp_conta_pagarDAO = getCtp_conta_pagarDAO();
/*      */       
/*  418 */       List<br.com.easynet.gwt.easyportal.transfer.Ctp_conta_pagarT> listTemp = ctp_conta_pagarDAO.getByPK(ctp_conta_pagarT);
/*      */       
/*  420 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Ctp_conta_pagarT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/*  422 */       e.printStackTrace();
/*      */     } finally {
/*  424 */       close();
/*      */     }
/*  426 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Ume_unidade_medidaDAO getUme_unidade_medidaDAO() throws Exception {
/*  430 */     this.dao = getDAO();
/*  431 */     return new br.com.easynet.gwt.easyportal.dao.Ume_unidade_medidaDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Ume_unidade_medidaT findbyIdUme_unidade_medida(br.com.easynet.gwt.easyportal.transfer.Ume_unidade_medidaT ume_unidade_medidaT) throws Exception {
/*      */     try {
/*  436 */       br.com.easynet.gwt.easyportal.dao.Ume_unidade_medidaDAO ume_unidade_medidaDAO = getUme_unidade_medidaDAO();
/*      */       
/*  438 */       List<br.com.easynet.gwt.easyportal.transfer.Ume_unidade_medidaT> listTemp = ume_unidade_medidaDAO.getByPK(ume_unidade_medidaT);
/*      */       
/*  440 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Ume_unidade_medidaT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/*  442 */       e.printStackTrace();
/*      */     } finally {
/*  444 */       close();
/*      */     }
/*  446 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Eplc_equivalencia_plano_contasDAO getEplc_equivalencia_plano_contasDAO() throws Exception {
/*  450 */     this.dao = getDAO();
/*  451 */     return new br.com.easynet.gwt.easyportal.dao.Eplc_equivalencia_plano_contasDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Ipo_item_plano_contas_obraDAO getIpo_item_plano_contas_obraDAO() throws Exception {
/*  455 */     this.dao = getDAO();
/*  456 */     return new br.com.easynet.gwt.easyportal.dao.Ipo_item_plano_contas_obraDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Plco_plano_contas_orcamentoDAO getPlco_plano_contas_orcamentoDAO() throws Exception {
/*  460 */     this.dao = getDAO();
/*  461 */     return new br.com.easynet.gwt.easyportal.dao.Plco_plano_contas_orcamentoDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Eplc_equivalencia_plano_contasT findbyIdEplc_equivalencia_plano_contas(br.com.easynet.gwt.easyportal.transfer.Eplc_equivalencia_plano_contasT eplc_equivalencia_plano_contasT) throws Exception {
/*      */     try {
/*  466 */       br.com.easynet.gwt.easyportal.dao.Eplc_equivalencia_plano_contasDAO eplc_equivalencia_plano_contasDAO = getEplc_equivalencia_plano_contasDAO();
/*      */       
/*  468 */       List<br.com.easynet.gwt.easyportal.transfer.Eplc_equivalencia_plano_contasT> listTemp = eplc_equivalencia_plano_contasDAO.getByPK(eplc_equivalencia_plano_contasT);
/*      */       
/*  470 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Eplc_equivalencia_plano_contasT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/*  472 */       e.printStackTrace();
/*      */     } finally {
/*  474 */       close();
/*      */     }
/*  476 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Ipo_item_plano_contas_obraT findbyIdIpo_item_plano_contas_obra(br.com.easynet.gwt.easyportal.transfer.Ipo_item_plano_contas_obraT ipo_item_plano_contas_obraT) throws Exception {
/*      */     try {
/*  481 */       br.com.easynet.gwt.easyportal.dao.Ipo_item_plano_contas_obraDAO ipo_item_plano_contas_obraDAO = getIpo_item_plano_contas_obraDAO();
/*      */       
/*  483 */       List<br.com.easynet.gwt.easyportal.transfer.Ipo_item_plano_contas_obraT> listTemp = ipo_item_plano_contas_obraDAO.getByPK(ipo_item_plano_contas_obraT);
/*      */       
/*  485 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Ipo_item_plano_contas_obraT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/*  487 */       e.printStackTrace();
/*      */     } finally {
/*  489 */       close();
/*      */     }
/*  491 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Plco_plano_contas_orcamentoT findbyIdPlco_plano_contas_orcamento(br.com.easynet.gwt.easyportal.transfer.Plco_plano_contas_orcamentoT plco_plano_contas_orcamentoT) throws Exception {
/*      */     try {
/*  496 */       br.com.easynet.gwt.easyportal.dao.Plco_plano_contas_orcamentoDAO plco_plano_contas_orcamentoDAO = getPlco_plano_contas_orcamentoDAO();
/*      */       
/*  498 */       List<br.com.easynet.gwt.easyportal.transfer.Plco_plano_contas_orcamentoT> listTemp = plco_plano_contas_orcamentoDAO.getByPK(plco_plano_contas_orcamentoT);
/*      */       
/*  500 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Plco_plano_contas_orcamentoT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/*  502 */       e.printStackTrace();
/*      */     } finally {
/*  504 */       close();
/*      */     }
/*  506 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Tet_tmp_equivalencia_treetDAO getTet_tmp_equivalencia_treetDAO() throws Exception {
/*  510 */     this.dao = getDAO();
/*  511 */     return new br.com.easynet.gwt.easyportal.dao.Tet_tmp_equivalencia_treetDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Tet_tmp_equivalencia_treetT findbyIdTet_tmp_equivalencia_treet(br.com.easynet.gwt.easyportal.transfer.Tet_tmp_equivalencia_treetT tet_tmp_equivalencia_treetT) throws Exception {
/*      */     try {
/*  516 */       br.com.easynet.gwt.easyportal.dao.Tet_tmp_equivalencia_treetDAO tet_tmp_equivalencia_treetDAO = getTet_tmp_equivalencia_treetDAO();
/*      */       
/*  518 */       List<br.com.easynet.gwt.easyportal.transfer.Tet_tmp_equivalencia_treetT> listTemp = tet_tmp_equivalencia_treetDAO.getByPK(tet_tmp_equivalencia_treetT);
/*      */       
/*  520 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Tet_tmp_equivalencia_treetT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/*  522 */       e.printStackTrace();
/*      */     } finally {
/*  524 */       close();
/*      */     }
/*  526 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Vw_equivalenciaDAO getVw_equivalenciaDAO() throws Exception {
/*  530 */     this.dao = getDAO();
/*  531 */     return new br.com.easynet.gwt.easyportal.dao.Vw_equivalenciaDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Vw_equivalenciaT findbyIdVw_equivalencia(br.com.easynet.gwt.easyportal.transfer.Vw_equivalenciaT vw_equivalenciaT) throws Exception {
/*      */     try {
/*  536 */       br.com.easynet.gwt.easyportal.dao.Vw_equivalenciaDAO vw_equivalenciaDAO = getVw_equivalenciaDAO();
/*      */       
/*  538 */       List<br.com.easynet.gwt.easyportal.transfer.Vw_equivalenciaT> listTemp = vw_equivalenciaDAO.getByPK(vw_equivalenciaT);
/*      */       
/*  540 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Vw_equivalenciaT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/*  542 */       e.printStackTrace();
/*      */     } finally {
/*  544 */       close();
/*      */     }
/*  546 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Vw_importacao_orcamentoDAO getVw_importacao_orcamentoDAO() throws Exception {
/*  550 */     this.dao = getDAO();
/*  551 */     return new br.com.easynet.gwt.easyportal.dao.Vw_importacao_orcamentoDAO(this.dao);
/*      */   }
/*      */   
/*      */   public Vw_importacao_orcamentoT findbyIdVw_importacao_orcamento(Vw_importacao_orcamentoT vw_importacao_orcamentoT) throws Exception {
/*      */     try {
/*  556 */       br.com.easynet.gwt.easyportal.dao.Vw_importacao_orcamentoDAO vw_importacao_orcamentoDAO = getVw_importacao_orcamentoDAO();
/*      */       
/*  558 */       List<Vw_importacao_orcamentoT> listTemp = vw_importacao_orcamentoDAO.getByPK(vw_importacao_orcamentoT);
/*      */       
/*  560 */       return listTemp.size() > 0 ? (Vw_importacao_orcamentoT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/*  562 */       e.printStackTrace();
/*      */     } finally {
/*  564 */       close();
/*      */     }
/*  566 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Vw_curva_abcDAO getVw_curva_abcDAO() throws Exception {
/*  570 */     this.dao = getDAO();
/*  571 */     return new br.com.easynet.gwt.easyportal.dao.Vw_curva_abcDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Vw_curva_abcT findbyIdVw_curva_abc(br.com.easynet.gwt.easyportal.transfer.Vw_curva_abcT vw_curva_abcT) throws Exception {
/*      */     try {
/*  576 */       br.com.easynet.gwt.easyportal.dao.Vw_curva_abcDAO vw_curva_abcDAO = getVw_curva_abcDAO();
/*      */       
/*  578 */       List<br.com.easynet.gwt.easyportal.transfer.Vw_curva_abcT> listTemp = vw_curva_abcDAO.getByPK(vw_curva_abcT);
/*      */       
/*  580 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Vw_curva_abcT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/*  582 */       e.printStackTrace();
/*      */     } finally {
/*  584 */       close();
/*      */     }
/*  586 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Tpms_temporaria_pmsDAO getTpms_temporaria_pmsDAO() throws Exception {
/*  590 */     this.dao = getDAO();
/*  591 */     return new br.com.easynet.gwt.easyportal.dao.Tpms_temporaria_pmsDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Pms_planilha_medicao_servicoDAO getPms_planilha_medicao_servicoDAO() throws Exception {
/*  595 */     this.dao = getDAO();
/*  596 */     return new br.com.easynet.gwt.easyportal.dao.Pms_planilha_medicao_servicoDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Cffo_cronograma_fisico_financeiro_origenalDAO getCffo_cronograma_fisico_financeiro_origenalDAO() throws Exception {
/*  600 */     this.dao = getDAO();
/*  601 */     return new br.com.easynet.gwt.easyportal.dao.Cffo_cronograma_fisico_financeiro_origenalDAO(this.dao);
/*      */   }
/*      */   
/*      */   public Tpms_temporaria_pmsT findbyIdTpms_temporaria_pms(Tpms_temporaria_pmsT tpms_temporaria_pmsT) throws Exception {
/*      */     try {
/*  606 */       br.com.easynet.gwt.easyportal.dao.Tpms_temporaria_pmsDAO tpms_temporaria_pmsDAO = getTpms_temporaria_pmsDAO();
/*      */       
/*  608 */       List<Tpms_temporaria_pmsT> listTemp = tpms_temporaria_pmsDAO.getByPK(tpms_temporaria_pmsT);
/*      */       
/*  610 */       return listTemp.size() > 0 ? (Tpms_temporaria_pmsT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/*  612 */       e.printStackTrace();
/*      */     } finally {
/*  614 */       close();
/*      */     }
/*  616 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Pms_planilha_medicao_servicoT findbyIdPms_planilha_medicao_servico(br.com.easynet.gwt.easyportal.transfer.Pms_planilha_medicao_servicoT pms_planilha_medicao_servicoT) throws Exception {
/*      */     try {
/*  621 */       br.com.easynet.gwt.easyportal.dao.Pms_planilha_medicao_servicoDAO pms_planilha_medicao_servicoDAO = getPms_planilha_medicao_servicoDAO();
/*      */       
/*  623 */       List<br.com.easynet.gwt.easyportal.transfer.Pms_planilha_medicao_servicoT> listTemp = pms_planilha_medicao_servicoDAO.getByPK(pms_planilha_medicao_servicoT);
/*      */       
/*  625 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Pms_planilha_medicao_servicoT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/*  627 */       e.printStackTrace();
/*      */     } finally {
/*  629 */       close();
/*      */     }
/*  631 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Cffo_cronograma_fisico_financeiro_origenalT findbyIdCffo_cronograma_fisico_financeiro_origenal(br.com.easynet.gwt.easyportal.transfer.Cffo_cronograma_fisico_financeiro_origenalT cffo_cronograma_fisico_financeiro_origenalT) throws Exception {
/*      */     try {
/*  636 */       br.com.easynet.gwt.easyportal.dao.Cffo_cronograma_fisico_financeiro_origenalDAO cffo_cronograma_fisico_financeiro_origenalDAO = getCffo_cronograma_fisico_financeiro_origenalDAO();
/*      */       
/*  638 */       List<br.com.easynet.gwt.easyportal.transfer.Cffo_cronograma_fisico_financeiro_origenalT> listTemp = cffo_cronograma_fisico_financeiro_origenalDAO.getByPK(cffo_cronograma_fisico_financeiro_origenalT);
/*      */       
/*  640 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Cffo_cronograma_fisico_financeiro_origenalT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/*  642 */       e.printStackTrace();
/*      */     } finally {
/*  644 */       close();
/*      */     }
/*  646 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Ccff_copia_cronograma_fisico_financeiroDAO getCcff_copia_cronograma_fisico_financeiroDAO() throws Exception {
/*  650 */     this.dao = getDAO();
/*  651 */     return new br.com.easynet.gwt.easyportal.dao.Ccff_copia_cronograma_fisico_financeiroDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Ccff_copia_cronograma_fisico_financeiroT findbyIdCcff_copia_cronograma_fisico_financeiro(br.com.easynet.gwt.easyportal.transfer.Ccff_copia_cronograma_fisico_financeiroT ccff_copia_cronograma_fisico_financeiroT) throws Exception {
/*      */     try {
/*  656 */       br.com.easynet.gwt.easyportal.dao.Ccff_copia_cronograma_fisico_financeiroDAO ccff_copia_cronograma_fisico_financeiroDAO = getCcff_copia_cronograma_fisico_financeiroDAO();
/*      */       
/*  658 */       List<br.com.easynet.gwt.easyportal.transfer.Ccff_copia_cronograma_fisico_financeiroT> listTemp = ccff_copia_cronograma_fisico_financeiroDAO.getByPK(ccff_copia_cronograma_fisico_financeiroT);
/*      */       
/*  660 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Ccff_copia_cronograma_fisico_financeiroT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/*  662 */       e.printStackTrace();
/*      */     } finally {
/*  664 */       close();
/*      */     }
/*  666 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Vw_curva_abc_equivalenciaDAO getVw_curva_abc_equivalenciaDAO() throws Exception {
/*  670 */     this.dao = getDAO();
/*  671 */     return new br.com.easynet.gwt.easyportal.dao.Vw_curva_abc_equivalenciaDAO(this.dao);
/*      */   }
/*      */   
/*      */   public Vw_curva_abc_equivalenciaT findbyIdVw_curva_abc_equivalencia(Vw_curva_abc_equivalenciaT vw_curva_abc_equivalenciaT) throws Exception {
/*      */     try {
/*  676 */       br.com.easynet.gwt.easyportal.dao.Vw_curva_abc_equivalenciaDAO vw_curva_abc_equivalenciaDAO = getVw_curva_abc_equivalenciaDAO();
/*      */       
/*  678 */       List<Vw_curva_abc_equivalenciaT> listTemp = vw_curva_abc_equivalenciaDAO.getByPK(vw_curva_abc_equivalenciaT);
/*      */       
/*  680 */       return listTemp.size() > 0 ? (Vw_curva_abc_equivalenciaT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/*  682 */       e.printStackTrace();
/*      */     } finally {
/*  684 */       close();
/*      */     }
/*  686 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Pao_parcelamento_obraDAO getPao_parcelamento_obraDAO() throws Exception {
/*  690 */     this.dao = getDAO();
/*  691 */     return new br.com.easynet.gwt.easyportal.dao.Pao_parcelamento_obraDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Pao_parcelamento_obraT findbyIdPao_parcelamento_obra(br.com.easynet.gwt.easyportal.transfer.Pao_parcelamento_obraT pao_parcelamento_obraT) throws Exception {
/*      */     try {
/*  696 */       br.com.easynet.gwt.easyportal.dao.Pao_parcelamento_obraDAO pao_parcelamento_obraDAO = getPao_parcelamento_obraDAO();
/*      */       
/*  698 */       List<br.com.easynet.gwt.easyportal.transfer.Pao_parcelamento_obraT> listTemp = pao_parcelamento_obraDAO.getByPK(pao_parcelamento_obraT);
/*      */       
/*  700 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Pao_parcelamento_obraT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/*  702 */       e.printStackTrace();
/*      */     } finally {
/*  704 */       close();
/*      */     }
/*  706 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Inp_intervalo_parcelaDAO getInp_intervalo_parcelaDAO() throws Exception {
/*  710 */     this.dao = getDAO();
/*  711 */     return new br.com.easynet.gwt.easyportal.dao.Inp_intervalo_parcelaDAO(this.dao);
/*      */   }
/*      */   
/*      */   public Inp_intervalo_parcelaT findbyIdInp_intervalo_parcela(Inp_intervalo_parcelaT inp_intervalo_parcelaT) throws Exception {
/*      */     try {
/*  716 */       br.com.easynet.gwt.easyportal.dao.Inp_intervalo_parcelaDAO inp_intervalo_parcelaDAO = getInp_intervalo_parcelaDAO();
/*      */       
/*  718 */       List<Inp_intervalo_parcelaT> listTemp = inp_intervalo_parcelaDAO.getByPK(inp_intervalo_parcelaT);
/*      */       
/*  720 */       return listTemp.size() > 0 ? (Inp_intervalo_parcelaT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/*  722 */       e.printStackTrace();
/*      */     } finally {
/*  724 */       close();
/*      */     }
/*  726 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Vw_maximo_dias_parcela_plcDAO getVw_maximo_dias_parcela_plcDAO() throws Exception {
/*  730 */     this.dao = getDAO();
/*  731 */     return new br.com.easynet.gwt.easyportal.dao.Vw_maximo_dias_parcela_plcDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Vw_maximo_mes_ccff_digitadoDAO getVw_maximo_mes_ccff_digitadoDAO() throws Exception {
/*  735 */     this.dao = getDAO();
/*  736 */     return new br.com.easynet.gwt.easyportal.dao.Vw_maximo_mes_ccff_digitadoDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Vw_maximo_dias_parcela_plcT findbyIdVw_maximo_dias_parcela_plc(br.com.easynet.gwt.easyportal.transfer.Vw_maximo_dias_parcela_plcT vw_maximo_dias_parcela_plcT) throws Exception {
/*      */     try {
/*  741 */       br.com.easynet.gwt.easyportal.dao.Vw_maximo_dias_parcela_plcDAO vw_maximo_dias_parcela_plcDAO = getVw_maximo_dias_parcela_plcDAO();
/*      */       
/*  743 */       List<br.com.easynet.gwt.easyportal.transfer.Vw_maximo_dias_parcela_plcT> listTemp = vw_maximo_dias_parcela_plcDAO.getByPK(vw_maximo_dias_parcela_plcT);
/*      */       
/*  745 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Vw_maximo_dias_parcela_plcT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/*  747 */       e.printStackTrace();
/*      */     } finally {
/*  749 */       close();
/*      */     }
/*  751 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Vw_maximo_mes_ccff_digitadoT findbyIdVw_maximo_mes_ccff_digitado(br.com.easynet.gwt.easyportal.transfer.Vw_maximo_mes_ccff_digitadoT vw_maximo_mes_ccff_digitadoT) throws Exception {
/*      */     try {
/*  756 */       br.com.easynet.gwt.easyportal.dao.Vw_maximo_mes_ccff_digitadoDAO vw_maximo_mes_ccff_digitadoDAO = getVw_maximo_mes_ccff_digitadoDAO();
/*      */       
/*  758 */       List<br.com.easynet.gwt.easyportal.transfer.Vw_maximo_mes_ccff_digitadoT> listTemp = vw_maximo_mes_ccff_digitadoDAO.getByPK(vw_maximo_mes_ccff_digitadoT);
/*      */       
/*  760 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Vw_maximo_mes_ccff_digitadoT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/*  762 */       e.printStackTrace();
/*      */     } finally {
/*  764 */       close();
/*      */     }
/*  766 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Com_comprometimentoDAO getCom_comprometimentoDAO() throws Exception {
/*  770 */     this.dao = getDAO();
/*  771 */     return new br.com.easynet.gwt.easyportal.dao.Com_comprometimentoDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Com_comprometimentoT findbyIdCom_comprometimento(br.com.easynet.gwt.easyportal.transfer.Com_comprometimentoT com_comprometimentoT) throws Exception {
/*      */     try {
/*  776 */       br.com.easynet.gwt.easyportal.dao.Com_comprometimentoDAO com_comprometimentoDAO = getCom_comprometimentoDAO();
/*      */       
/*  778 */       List<br.com.easynet.gwt.easyportal.transfer.Com_comprometimentoT> listTemp = com_comprometimentoDAO.getByPK(com_comprometimentoT);
/*      */       
/*  780 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Com_comprometimentoT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/*  782 */       e.printStackTrace();
/*      */     } finally {
/*  784 */       close();
/*      */     }
/*  786 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Vw_comprometimentoDAO getVw_comprometimentoDAO() throws Exception {
/*  790 */     this.dao = getDAO();
/*  791 */     return new br.com.easynet.gwt.easyportal.dao.Vw_comprometimentoDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Vw_comprometimentoT findbyIdVw_comprometimento(br.com.easynet.gwt.easyportal.transfer.Vw_comprometimentoT vw_comprometimentoT) throws Exception {
/*      */     try {
/*  796 */       br.com.easynet.gwt.easyportal.dao.Vw_comprometimentoDAO vw_comprometimentoDAO = getVw_comprometimentoDAO();
/*      */       
/*  798 */       List<br.com.easynet.gwt.easyportal.transfer.Vw_comprometimentoT> listTemp = vw_comprometimentoDAO.getByPK(vw_comprometimentoT);
/*      */       
/*  800 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Vw_comprometimentoT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/*  802 */       e.printStackTrace();
/*      */     } finally {
/*  804 */       close();
/*      */     }
/*  806 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Fat_fatorDAO getFat_fatorDAO() throws Exception {
/*  810 */     this.dao = getDAO();
/*  811 */     return new br.com.easynet.gwt.easyportal.dao.Fat_fatorDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Fat_fatorT findbyIdFat_fator(br.com.easynet.gwt.easyportal.transfer.Fat_fatorT fat_fatorT) throws Exception {
/*      */     try {
/*  816 */       br.com.easynet.gwt.easyportal.dao.Fat_fatorDAO fat_fatorDAO = getFat_fatorDAO();
/*      */       
/*  818 */       List<br.com.easynet.gwt.easyportal.transfer.Fat_fatorT> listTemp = fat_fatorDAO.getByPK(fat_fatorT);
/*      */       
/*  820 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Fat_fatorT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/*  822 */       e.printStackTrace();
/*      */     } finally {
/*  824 */       close();
/*      */     }
/*  826 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Vw_insumo_plc_pmsDAO getVw_insumo_plc_pmsDAO() throws Exception {
/*  830 */     this.dao = getDAO();
/*  831 */     return new br.com.easynet.gwt.easyportal.dao.Vw_insumo_plc_pmsDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Vw_insumo_plc_pmsT findbyIdVw_insumo_plc_pms(br.com.easynet.gwt.easyportal.transfer.Vw_insumo_plc_pmsT vw_insumo_plc_pmsT) throws Exception {
/*      */     try {
/*  836 */       br.com.easynet.gwt.easyportal.dao.Vw_insumo_plc_pmsDAO vw_insumo_plc_pmsDAO = getVw_insumo_plc_pmsDAO();
/*      */       
/*  838 */       List<br.com.easynet.gwt.easyportal.transfer.Vw_insumo_plc_pmsT> listTemp = vw_insumo_plc_pmsDAO.getByPK(vw_insumo_plc_pmsT);
/*      */       
/*  840 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Vw_insumo_plc_pmsT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/*  842 */       e.printStackTrace();
/*      */     } finally {
/*  844 */       close();
/*      */     }
/*  846 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Vw_equiv_insumo_pmsDAO getVw_equiv_insumo_pmsDAO() throws Exception {
/*  850 */     this.dao = getDAO();
/*  851 */     return new br.com.easynet.gwt.easyportal.dao.Vw_equiv_insumo_pmsDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Vw_equiv_insumo_pmsT findbyIdVw_equiv_insumo_pms(br.com.easynet.gwt.easyportal.transfer.Vw_equiv_insumo_pmsT vw_equiv_insumo_pmsT) throws Exception {
/*      */     try {
/*  856 */       br.com.easynet.gwt.easyportal.dao.Vw_equiv_insumo_pmsDAO vw_equiv_insumo_pmsDAO = getVw_equiv_insumo_pmsDAO();
/*      */       
/*  858 */       List<br.com.easynet.gwt.easyportal.transfer.Vw_equiv_insumo_pmsT> listTemp = vw_equiv_insumo_pmsDAO.getByPK(vw_equiv_insumo_pmsT);
/*      */       
/*  860 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Vw_equiv_insumo_pmsT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/*  862 */       e.printStackTrace();
/*      */     } finally {
/*  864 */       close();
/*      */     }
/*  866 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Fol_folha_pagamentoDAO getFol_folha_pagamentoDAO() throws Exception
/*      */   {
/*  871 */     this.dao = getDAO();
/*  872 */     return new br.com.easynet.gwt.easyportal.dao.Fol_folha_pagamentoDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Htf_horas_trabalha_folhaDAO getHtf_horas_trabalha_folhaDAO() throws Exception {
/*  876 */     this.dao = getDAO();
/*  877 */     return new br.com.easynet.gwt.easyportal.dao.Htf_horas_trabalha_folhaDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Fol_folha_pagamentoT findbyIdFol_folha_pagamento(br.com.easynet.gwt.easyportal.transfer.Fol_folha_pagamentoT fol_folha_pagamentoT) throws Exception {
/*      */     try {
/*  882 */       br.com.easynet.gwt.easyportal.dao.Fol_folha_pagamentoDAO fol_folha_pagamentoDAO = getFol_folha_pagamentoDAO();
/*      */       
/*  884 */       List<br.com.easynet.gwt.easyportal.transfer.Fol_folha_pagamentoT> listTemp = fol_folha_pagamentoDAO.getByPK(fol_folha_pagamentoT);
/*      */       
/*  886 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Fol_folha_pagamentoT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/*  888 */       e.printStackTrace();
/*      */     } finally {
/*  890 */       close();
/*      */     }
/*  892 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Htf_horas_trabalha_folhaT findbyIdHtf_horas_trabalha_folha(br.com.easynet.gwt.easyportal.transfer.Htf_horas_trabalha_folhaT htf_horas_trabalha_folhaT) throws Exception {
/*      */     try {
/*  897 */       br.com.easynet.gwt.easyportal.dao.Htf_horas_trabalha_folhaDAO htf_horas_trabalha_folhaDAO = getHtf_horas_trabalha_folhaDAO();
/*      */       
/*  899 */       List<br.com.easynet.gwt.easyportal.transfer.Htf_horas_trabalha_folhaT> listTemp = htf_horas_trabalha_folhaDAO.getByPK(htf_horas_trabalha_folhaT);
/*      */       
/*  901 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Htf_horas_trabalha_folhaT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/*  903 */       e.printStackTrace();
/*      */     } finally {
/*  905 */       close();
/*      */     }
/*  907 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Dso_descricao_servico_obraDAO getDso_descricao_servico_obraDAO() throws Exception {
/*  911 */     this.dao = getDAO();
/*  912 */     return new br.com.easynet.gwt.easyportal.dao.Dso_descricao_servico_obraDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Dso_descricao_servico_obraT findbyIdDso_descricao_servico_obra(br.com.easynet.gwt.easyportal.transfer.Dso_descricao_servico_obraT dso_descricao_servico_obraT) throws Exception {
/*      */     try {
/*  917 */       br.com.easynet.gwt.easyportal.dao.Dso_descricao_servico_obraDAO dso_descricao_servico_obraDAO = getDso_descricao_servico_obraDAO();
/*      */       
/*  919 */       List<br.com.easynet.gwt.easyportal.transfer.Dso_descricao_servico_obraT> listTemp = dso_descricao_servico_obraDAO.getByPK(dso_descricao_servico_obraT);
/*      */       
/*  921 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Dso_descricao_servico_obraT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/*  923 */       e.printStackTrace();
/*      */     } finally {
/*  925 */       close();
/*      */     }
/*  927 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Scfp_subclasse_operario_previstoDAO getScfp_subclasse_operario_previstoDAO() throws Exception {
/*  931 */     this.dao = getDAO();
/*  932 */     return new br.com.easynet.gwt.easyportal.dao.Scfp_subclasse_operario_previstoDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Scfp_subclasse_operario_previstoT findbyIdScfp_subclasse_operario_previsto(br.com.easynet.gwt.easyportal.transfer.Scfp_subclasse_operario_previstoT scfp_subclasse_operario_previstoT) throws Exception {
/*      */     try {
/*  937 */       br.com.easynet.gwt.easyportal.dao.Scfp_subclasse_operario_previstoDAO scfp_subclasse_operario_previstoDAO = getScfp_subclasse_operario_previstoDAO();
/*      */       
/*  939 */       List<br.com.easynet.gwt.easyportal.transfer.Scfp_subclasse_operario_previstoT> listTemp = scfp_subclasse_operario_previstoDAO.getByPK(scfp_subclasse_operario_previstoT);
/*      */       
/*  941 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Scfp_subclasse_operario_previstoT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/*  943 */       e.printStackTrace();
/*      */     } finally {
/*  945 */       close();
/*      */     }
/*  947 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Frd_faturamento_rec_devolucaoDAO getFrd_faturamento_rec_devolucaoDAO() throws Exception {
/*  951 */     this.dao = getDAO();
/*  952 */     return new br.com.easynet.gwt.easyportal.dao.Frd_faturamento_rec_devolucaoDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Frd_faturamento_rec_devolucaoT findbyIdFrd_faturamento_rec_devolucao(br.com.easynet.gwt.easyportal.transfer.Frd_faturamento_rec_devolucaoT frd_faturamento_rec_devolucaoT) throws Exception {
/*      */     try {
/*  957 */       br.com.easynet.gwt.easyportal.dao.Frd_faturamento_rec_devolucaoDAO frd_faturamento_rec_devolucaoDAO = getFrd_faturamento_rec_devolucaoDAO();
/*      */       
/*  959 */       List<br.com.easynet.gwt.easyportal.transfer.Frd_faturamento_rec_devolucaoT> listTemp = frd_faturamento_rec_devolucaoDAO.getByPK(frd_faturamento_rec_devolucaoT);
/*      */       
/*  961 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Frd_faturamento_rec_devolucaoT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/*  963 */       e.printStackTrace();
/*      */     } finally {
/*  965 */       close();
/*      */     }
/*  967 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Flr_fluxo_receitaDAO getFlr_fluxo_receitaDAO() throws Exception {
/*  971 */     this.dao = getDAO();
/*  972 */     return new br.com.easynet.gwt.easyportal.dao.Flr_fluxo_receitaDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Flr_fluxo_receitaT findbyIdFlr_fluxo_receita(br.com.easynet.gwt.easyportal.transfer.Flr_fluxo_receitaT flr_fluxo_receitaT) throws Exception {
/*      */     try {
/*  977 */       br.com.easynet.gwt.easyportal.dao.Flr_fluxo_receitaDAO flr_fluxo_receitaDAO = getFlr_fluxo_receitaDAO();
/*      */       
/*  979 */       List<br.com.easynet.gwt.easyportal.transfer.Flr_fluxo_receitaT> listTemp = flr_fluxo_receitaDAO.getByPK(flr_fluxo_receitaT);
/*      */       
/*  981 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Flr_fluxo_receitaT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/*  983 */       e.printStackTrace();
/*      */     } finally {
/*  985 */       close();
/*      */     }
/*  987 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public br.com.easynet.gwt.easyportal.dao.Evl_evolucao_lucroDAO getEvl_evolucao_lucroDAO()
/*      */     throws Exception
/*      */   {
/* 1011 */     this.dao = getDAO();
/* 1012 */     return new br.com.easynet.gwt.easyportal.dao.Evl_evolucao_lucroDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Pro_programacaoDAO getPro_programacaoDAO() throws Exception {
/* 1016 */     this.dao = getDAO();
/* 1017 */     return new br.com.easynet.gwt.easyportal.dao.Pro_programacaoDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Evl_evolucao_lucroT findbyIdEvl_evolucao_lucro(br.com.easynet.gwt.easyportal.transfer.Evl_evolucao_lucroT evl_evolucao_lucroT) throws Exception {
/*      */     try {
/* 1022 */       br.com.easynet.gwt.easyportal.dao.Evl_evolucao_lucroDAO evl_evolucao_lucroDAO = getEvl_evolucao_lucroDAO();
/*      */       
/* 1024 */       List<br.com.easynet.gwt.easyportal.transfer.Evl_evolucao_lucroT> listTemp = evl_evolucao_lucroDAO.getByPK(evl_evolucao_lucroT);
/*      */       
/* 1026 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Evl_evolucao_lucroT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/* 1028 */       e.printStackTrace();
/*      */     } finally {
/* 1030 */       close();
/*      */     }
/* 1032 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Pro_programacaoT findbyIdPro_programacao(br.com.easynet.gwt.easyportal.transfer.Pro_programacaoT pro_programacaoT) throws Exception {
/*      */     try {
/* 1037 */       br.com.easynet.gwt.easyportal.dao.Pro_programacaoDAO pro_programacaoDAO = getPro_programacaoDAO();
/*      */       
/* 1039 */       List<br.com.easynet.gwt.easyportal.transfer.Pro_programacaoT> listTemp = pro_programacaoDAO.getByPK(pro_programacaoT);
/*      */       
/* 1041 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Pro_programacaoT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/* 1043 */       e.printStackTrace();
/*      */     } finally {
/* 1045 */       close();
/*      */     }
/* 1047 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Plr_planilha_recebimentoDAO getPlr_planilha_permutaDAO() throws Exception {
/* 1051 */     this.dao = getDAO();
/* 1052 */     return new br.com.easynet.gwt.easyportal.dao.Plr_planilha_recebimentoDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Plv_planilha_vendasDAO getPlv_planilha_vendasDAO() throws Exception {
/* 1056 */     this.dao = getDAO();
/* 1057 */     return new br.com.easynet.gwt.easyportal.dao.Plv_planilha_vendasDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Plp_planilha_permutaDAO getPlp_planilha_permutaDAO() throws Exception {
/* 1061 */     this.dao = getDAO();
/* 1062 */     return new br.com.easynet.gwt.easyportal.dao.Plp_planilha_permutaDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Plr_planilha_recebimentoT findbyIdPlr_planilha_permuta(br.com.easynet.gwt.easyportal.transfer.Plr_planilha_recebimentoT plr_planilha_permutaT) throws Exception {
/*      */     try {
/* 1067 */       br.com.easynet.gwt.easyportal.dao.Plr_planilha_recebimentoDAO plr_planilha_permutaDAO = getPlr_planilha_permutaDAO();
/*      */       
/* 1069 */       List<br.com.easynet.gwt.easyportal.transfer.Plr_planilha_recebimentoT> listTemp = plr_planilha_permutaDAO.getByPK(plr_planilha_permutaT);
/*      */       
/* 1071 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Plr_planilha_recebimentoT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/* 1073 */       e.printStackTrace();
/*      */     } finally {
/* 1075 */       close();
/*      */     }
/* 1077 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Plv_planilha_vendasT findbyIdPlv_planilha_vendas(br.com.easynet.gwt.easyportal.transfer.Plv_planilha_vendasT plv_planilha_vendasT) throws Exception {
/*      */     try {
/* 1082 */       br.com.easynet.gwt.easyportal.dao.Plv_planilha_vendasDAO plv_planilha_vendasDAO = getPlv_planilha_vendasDAO();
/*      */       
/* 1084 */       List<br.com.easynet.gwt.easyportal.transfer.Plv_planilha_vendasT> listTemp = plv_planilha_vendasDAO.getByPK(plv_planilha_vendasT);
/*      */       
/* 1086 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Plv_planilha_vendasT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/* 1088 */       e.printStackTrace();
/*      */     } finally {
/* 1090 */       close();
/*      */     }
/* 1092 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Plp_planilha_permutaT findbyIdPlp_planilha_permuta(br.com.easynet.gwt.easyportal.transfer.Plp_planilha_permutaT plp_planilha_permutaT) throws Exception {
/*      */     try {
/* 1097 */       br.com.easynet.gwt.easyportal.dao.Plp_planilha_permutaDAO plp_planilha_permutaDAO = getPlp_planilha_permutaDAO();
/*      */       
/* 1099 */       List<br.com.easynet.gwt.easyportal.transfer.Plp_planilha_permutaT> listTemp = plp_planilha_permutaDAO.getByPK(plp_planilha_permutaT);
/*      */       
/* 1101 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Plp_planilha_permutaT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/* 1103 */       e.printStackTrace();
/*      */     } finally {
/* 1105 */       close();
/*      */     }
/* 1107 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Inc_informacoes_custoDAO getInc_informacoes_custoDAO() throws Exception {
/* 1111 */     this.dao = getDAO();
/* 1112 */     return new br.com.easynet.gwt.easyportal.dao.Inc_informacoes_custoDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Inc_informacoes_custoT findbyIdInc_informacoes_custo(br.com.easynet.gwt.easyportal.transfer.Inc_informacoes_custoT inc_informacoes_custoT) throws Exception {
/*      */     try {
/* 1117 */       br.com.easynet.gwt.easyportal.dao.Inc_informacoes_custoDAO inc_informacoes_custoDAO = getInc_informacoes_custoDAO();
/*      */       
/* 1119 */       List<br.com.easynet.gwt.easyportal.transfer.Inc_informacoes_custoT> listTemp = inc_informacoes_custoDAO.getByPK(inc_informacoes_custoT);
/*      */       
/* 1121 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Inc_informacoes_custoT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/* 1123 */       e.printStackTrace();
/*      */     } finally {
/* 1125 */       close();
/*      */     }
/* 1127 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Fto_fotosDAO getFto_fotosDAO() throws Exception {
/* 1131 */     this.dao = getDAO();
/* 1132 */     return new br.com.easynet.gwt.easyportal.dao.Fto_fotosDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Fto_fotosT findbyIdFto_fotos(br.com.easynet.gwt.easyportal.transfer.Fto_fotosT fto_fotosT) throws Exception {
/*      */     try {
/* 1137 */       br.com.easynet.gwt.easyportal.dao.Fto_fotosDAO fto_fotosDAO = getFto_fotosDAO();
/*      */       
/* 1139 */       List<br.com.easynet.gwt.easyportal.transfer.Fto_fotosT> listTemp = fto_fotosDAO.getByPK(fto_fotosT);
/*      */       
/* 1141 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Fto_fotosT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/* 1143 */       e.printStackTrace();
/*      */     } finally {
/* 1145 */       close();
/*      */     }
/* 1147 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Coa_composicao_anteriorDAO getCoa_composicao_anteriorDAO() throws Exception {
/* 1151 */     this.dao = getDAO();
/* 1152 */     return new br.com.easynet.gwt.easyportal.dao.Coa_composicao_anteriorDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Con_composicao_novaDAO getCon_composicao_novaDAO() throws Exception {
/* 1156 */     this.dao = getDAO();
/* 1157 */     return new br.com.easynet.gwt.easyportal.dao.Con_composicao_novaDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Eqc_equivalencia_composicaoDAO getEqc_equivalencia_composicaoDAO() throws Exception {
/* 1161 */     this.dao = getDAO();
/* 1162 */     return new br.com.easynet.gwt.easyportal.dao.Eqc_equivalencia_composicaoDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Eqi_equivalencia_insumoDAO getEqi_equivalencia_insumoDAO() throws Exception {
/* 1166 */     this.dao = getDAO();
/* 1167 */     return new br.com.easynet.gwt.easyportal.dao.Eqi_equivalencia_insumoDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Ina_insumo_antigoDAO getIna_insumo_antigoDAO() throws Exception {
/* 1171 */     this.dao = getDAO();
/* 1172 */     return new br.com.easynet.gwt.easyportal.dao.Ina_insumo_antigoDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Inn_insumo_novoDAO getInn_insumo_novoDAO() throws Exception {
/* 1176 */     this.dao = getDAO();
/* 1177 */     return new br.com.easynet.gwt.easyportal.dao.Inn_insumo_novoDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Coa_composicao_anteriorT findbyIdCoa_composicao_anterior(br.com.easynet.gwt.easyportal.transfer.Coa_composicao_anteriorT coa_composicao_anteriorT) throws Exception {
/*      */     try {
/* 1182 */       br.com.easynet.gwt.easyportal.dao.Coa_composicao_anteriorDAO coa_composicao_anteriorDAO = getCoa_composicao_anteriorDAO();
/*      */       
/* 1184 */       List<br.com.easynet.gwt.easyportal.transfer.Coa_composicao_anteriorT> listTemp = coa_composicao_anteriorDAO.getByPK(coa_composicao_anteriorT);
/*      */       
/* 1186 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Coa_composicao_anteriorT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/* 1188 */       e.printStackTrace();
/*      */     } finally {
/* 1190 */       close();
/*      */     }
/* 1192 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Con_composicao_novaT findbyIdCon_composicao_nova(br.com.easynet.gwt.easyportal.transfer.Con_composicao_novaT con_composicao_novaT) throws Exception {
/*      */     try {
/* 1197 */       br.com.easynet.gwt.easyportal.dao.Con_composicao_novaDAO con_composicao_novaDAO = getCon_composicao_novaDAO();
/*      */       
/* 1199 */       List<br.com.easynet.gwt.easyportal.transfer.Con_composicao_novaT> listTemp = con_composicao_novaDAO.getByPK(con_composicao_novaT);
/*      */       
/* 1201 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Con_composicao_novaT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/* 1203 */       e.printStackTrace();
/*      */     } finally {
/* 1205 */       close();
/*      */     }
/* 1207 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Eqc_equivalencia_composicaoT findbyIdEqc_equivalencia_composicao(br.com.easynet.gwt.easyportal.transfer.Eqc_equivalencia_composicaoT eqc_equivalencia_composicaoT) throws Exception {
/*      */     try {
/* 1212 */       br.com.easynet.gwt.easyportal.dao.Eqc_equivalencia_composicaoDAO eqc_equivalencia_composicaoDAO = getEqc_equivalencia_composicaoDAO();
/*      */       
/* 1214 */       List<br.com.easynet.gwt.easyportal.transfer.Eqc_equivalencia_composicaoT> listTemp = eqc_equivalencia_composicaoDAO.getByPK(eqc_equivalencia_composicaoT);
/*      */       
/* 1216 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Eqc_equivalencia_composicaoT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/* 1218 */       e.printStackTrace();
/*      */     } finally {
/* 1220 */       close();
/*      */     }
/* 1222 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Eqi_equivalencia_insumoT findbyIdEqi_equivalencia_insumo(br.com.easynet.gwt.easyportal.transfer.Eqi_equivalencia_insumoT eqi_equivalencia_insumoT) throws Exception {
/*      */     try {
/* 1227 */       br.com.easynet.gwt.easyportal.dao.Eqi_equivalencia_insumoDAO eqi_equivalencia_insumoDAO = getEqi_equivalencia_insumoDAO();
/*      */       
/* 1229 */       List<br.com.easynet.gwt.easyportal.transfer.Eqi_equivalencia_insumoT> listTemp = eqi_equivalencia_insumoDAO.getByPK(eqi_equivalencia_insumoT);
/*      */       
/* 1231 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Eqi_equivalencia_insumoT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/* 1233 */       e.printStackTrace();
/*      */     } finally {
/* 1235 */       close();
/*      */     }
/* 1237 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Ina_insumo_antigoT findbyIdIna_insumo_antigo(br.com.easynet.gwt.easyportal.transfer.Ina_insumo_antigoT ina_insumo_antigoT) throws Exception {
/*      */     try {
/* 1242 */       br.com.easynet.gwt.easyportal.dao.Ina_insumo_antigoDAO ina_insumo_antigoDAO = getIna_insumo_antigoDAO();
/*      */       
/* 1244 */       List<br.com.easynet.gwt.easyportal.transfer.Ina_insumo_antigoT> listTemp = ina_insumo_antigoDAO.getByPK(ina_insumo_antigoT);
/*      */       
/* 1246 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Ina_insumo_antigoT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/* 1248 */       e.printStackTrace();
/*      */     } finally {
/* 1250 */       close();
/*      */     }
/* 1252 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Inn_insumo_novoT findbyIdInn_insumo_novo(br.com.easynet.gwt.easyportal.transfer.Inn_insumo_novoT inn_insumo_novoT) throws Exception {
/*      */     try {
/* 1257 */       br.com.easynet.gwt.easyportal.dao.Inn_insumo_novoDAO inn_insumo_novoDAO = getInn_insumo_novoDAO();
/* 1258 */       List<br.com.easynet.gwt.easyportal.transfer.Inn_insumo_novoT> listTemp = inn_insumo_novoDAO.getByPK(inn_insumo_novoT);
/* 1259 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Inn_insumo_novoT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/* 1261 */       e.printStackTrace();
/*      */     } finally {
/* 1263 */       close();
/*      */     }
/* 1265 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Ort_orcamento_temporarioDAO getOrt_orcamento_temporarioDAO() throws Exception {
/* 1269 */     this.dao = getDAO();
/* 1270 */     return new br.com.easynet.gwt.easyportal.dao.Ort_orcamento_temporarioDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Ort_orcamento_temporarioT findbyIdOrt_orcamento_temporario(br.com.easynet.gwt.easyportal.transfer.Ort_orcamento_temporarioT ort_orcamento_temporarioT) throws Exception {
/*      */     try {
/* 1275 */       br.com.easynet.gwt.easyportal.dao.Ort_orcamento_temporarioDAO ort_orcamento_temporarioDAO = getOrt_orcamento_temporarioDAO();
/*      */       
/* 1277 */       List<br.com.easynet.gwt.easyportal.transfer.Ort_orcamento_temporarioT> listTemp = ort_orcamento_temporarioDAO.getByPK(ort_orcamento_temporarioT);
/*      */       
/* 1279 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Ort_orcamento_temporarioT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/* 1281 */       e.printStackTrace();
/*      */     } finally {
/* 1283 */       close();
/*      */     }
/* 1285 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Ctpm_conta_pagar_modificadaDAO getCtpm_conta_pagar_modificadaDAO() throws Exception {
/* 1289 */     this.dao = getDAO();
/* 1290 */     return new br.com.easynet.gwt.easyportal.dao.Ctpm_conta_pagar_modificadaDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Vw_conta_pagar_alteradaDAO getVw_conta_pagar_alteradaDAO() throws Exception {
/* 1294 */     this.dao = getDAO();
/* 1295 */     return new br.com.easynet.gwt.easyportal.dao.Vw_conta_pagar_alteradaDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Ctpm_conta_pagar_modificadaT findbyIdCtpm_conta_pagar_modificada(br.com.easynet.gwt.easyportal.transfer.Ctpm_conta_pagar_modificadaT ctpm_conta_pagar_modificadaT) throws Exception {
/*      */     try {
/* 1300 */       br.com.easynet.gwt.easyportal.dao.Ctpm_conta_pagar_modificadaDAO ctpm_conta_pagar_modificadaDAO = getCtpm_conta_pagar_modificadaDAO();
/*      */       
/* 1302 */       List<br.com.easynet.gwt.easyportal.transfer.Ctpm_conta_pagar_modificadaT> listTemp = ctpm_conta_pagar_modificadaDAO.getByPK(ctpm_conta_pagar_modificadaT);
/*      */       
/* 1304 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Ctpm_conta_pagar_modificadaT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/* 1306 */       e.printStackTrace();
/*      */     } finally {
/* 1308 */       close();
/*      */     }
/* 1310 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Vw_conta_pagar_alteradaT findbyIdVw_conta_pagar_alterada(br.com.easynet.gwt.easyportal.transfer.Vw_conta_pagar_alteradaT vw_conta_pagar_alteradaT) throws Exception {
/*      */     try {
/* 1315 */       br.com.easynet.gwt.easyportal.dao.Vw_conta_pagar_alteradaDAO vw_conta_pagar_alteradaDAO = getVw_conta_pagar_alteradaDAO();
/* 1316 */       List<br.com.easynet.gwt.easyportal.transfer.Vw_conta_pagar_alteradaT> listTemp = vw_conta_pagar_alteradaDAO.getByPK(vw_conta_pagar_alteradaT);
/* 1317 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Vw_conta_pagar_alteradaT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/* 1319 */       e.printStackTrace();
/*      */     } finally {
/* 1321 */       close();
/*      */     }
/* 1323 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public br.com.easynet.gwt.easyportal.dao.Com_comenrcialDAO getCom_comenrcialDAO()
/*      */     throws Exception
/*      */   {
/* 1331 */     this.dao = getDAO();
/* 1332 */     return new br.com.easynet.gwt.easyportal.dao.Com_comenrcialDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Csg_curva_s_geralDAO getCsg_curva_s_geralDAO() throws Exception
/*      */   {
/* 1337 */     this.dao = getDAO();
/* 1338 */     return new br.com.easynet.gwt.easyportal.dao.Csg_curva_s_geralDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Idc_indice_custoDAO getIdc_indice_custoDAO() throws Exception
/*      */   {
/* 1343 */     this.dao = getDAO();
/* 1344 */     return new br.com.easynet.gwt.easyportal.dao.Idc_indice_custoDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Inp_indicador_planejamentoDAO getInp_indicador_planejamentoDAO() throws Exception
/*      */   {
/* 1349 */     this.dao = getDAO();
/* 1350 */     return new br.com.easynet.gwt.easyportal.dao.Inp_indicador_planejamentoDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Rep_resumo_planejamentoDAO getRep_resumo_planejamentoDAO() throws Exception
/*      */   {
/* 1355 */     this.dao = getDAO();
/* 1356 */     return new br.com.easynet.gwt.easyportal.dao.Rep_resumo_planejamentoDAO(this.dao);
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.dao.Ret_restricao_planejamentoDAO getRet_restricao_planejamentoDAO() throws Exception
/*      */   {
/* 1361 */     this.dao = getDAO();
/* 1362 */     return new br.com.easynet.gwt.easyportal.dao.Ret_restricao_planejamentoDAO(this.dao);
/*      */   }
/*      */   
/*      */ 
/*      */   public br.com.easynet.gwt.easyportal.transfer.Com_comenrcialT findbyIdCom_comenrcial(br.com.easynet.gwt.easyportal.transfer.Com_comenrcialT com_comenrcialT)
/*      */     throws Exception
/*      */   {
/*      */     try
/*      */     {
/* 1371 */       br.com.easynet.gwt.easyportal.dao.Com_comenrcialDAO com_comenrcialDAO = getCom_comenrcialDAO();
/*      */       
/* 1373 */       List<br.com.easynet.gwt.easyportal.transfer.Com_comenrcialT> listTemp = com_comenrcialDAO.getByPK(com_comenrcialT);
/*      */       
/* 1375 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Com_comenrcialT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/* 1377 */       e.printStackTrace();
/*      */     } finally {
/* 1379 */       close();
/*      */     }
/* 1381 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Csg_curva_s_geralT findbyIdCsg_curva_s_geral(br.com.easynet.gwt.easyportal.transfer.Csg_curva_s_geralT csg_curva_s_geralT) throws Exception
/*      */   {
/*      */     try
/*      */     {
/* 1388 */       br.com.easynet.gwt.easyportal.dao.Csg_curva_s_geralDAO csg_curva_s_geralDAO = getCsg_curva_s_geralDAO();
/*      */       
/* 1390 */       List<br.com.easynet.gwt.easyportal.transfer.Csg_curva_s_geralT> listTemp = csg_curva_s_geralDAO.getByPK(csg_curva_s_geralT);
/*      */       
/* 1392 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Csg_curva_s_geralT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/* 1394 */       e.printStackTrace();
/*      */     } finally {
/* 1396 */       close();
/*      */     }
/* 1398 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Idc_indice_custoT findbyIdIdc_indice_custo(br.com.easynet.gwt.easyportal.transfer.Idc_indice_custoT idc_indice_custoT) throws Exception
/*      */   {
/*      */     try
/*      */     {
/* 1405 */       br.com.easynet.gwt.easyportal.dao.Idc_indice_custoDAO idc_indice_custoDAO = getIdc_indice_custoDAO();
/*      */       
/* 1407 */       List<br.com.easynet.gwt.easyportal.transfer.Idc_indice_custoT> listTemp = idc_indice_custoDAO.getByPK(idc_indice_custoT);
/*      */       
/* 1409 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Idc_indice_custoT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/* 1411 */       e.printStackTrace();
/*      */     } finally {
/* 1413 */       close();
/*      */     }
/* 1415 */     return null;
/*      */   }
/*      */   
/*      */   public Inp_indicador_planejamentoT findbyIdInp_indicador_planejamento(Inp_indicador_planejamentoT inp_indicador_planejamentoT) throws Exception
/*      */   {
/*      */     try
/*      */     {
/* 1422 */       br.com.easynet.gwt.easyportal.dao.Inp_indicador_planejamentoDAO inp_indicador_planejamentoDAO = getInp_indicador_planejamentoDAO();
/*      */       
/* 1424 */       List<Inp_indicador_planejamentoT> listTemp = inp_indicador_planejamentoDAO.getByPK(inp_indicador_planejamentoT);
/*      */       
/* 1426 */       return listTemp.size() > 0 ? (Inp_indicador_planejamentoT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/* 1428 */       e.printStackTrace();
/*      */     } finally {
/* 1430 */       close();
/*      */     }
/* 1432 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Rep_resumo_planejamentoT findbyIdRep_resumo_planejamento(br.com.easynet.gwt.easyportal.transfer.Rep_resumo_planejamentoT rep_resumo_planejamentoT) throws Exception
/*      */   {
/*      */     try
/*      */     {
/* 1439 */       br.com.easynet.gwt.easyportal.dao.Rep_resumo_planejamentoDAO rep_resumo_planejamentoDAO = getRep_resumo_planejamentoDAO();
/*      */       
/* 1441 */       List<br.com.easynet.gwt.easyportal.transfer.Rep_resumo_planejamentoT> listTemp = rep_resumo_planejamentoDAO.getByPK(rep_resumo_planejamentoT);
/*      */       
/* 1443 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Rep_resumo_planejamentoT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/* 1445 */       e.printStackTrace();
/*      */     } finally {
/* 1447 */       close();
/*      */     }
/* 1449 */     return null;
/*      */   }
/*      */   
/*      */   public br.com.easynet.gwt.easyportal.transfer.Ret_restricao_planejamentoT findbyIdRet_restricao_planejamento(br.com.easynet.gwt.easyportal.transfer.Ret_restricao_planejamentoT ret_restricao_planejamentoT) throws Exception
/*      */   {
/*      */     try
/*      */     {
/* 1456 */       br.com.easynet.gwt.easyportal.dao.Ret_restricao_planejamentoDAO ret_restricao_planejamentoDAO = getRet_restricao_planejamentoDAO();
/*      */       
/* 1458 */       List<br.com.easynet.gwt.easyportal.transfer.Ret_restricao_planejamentoT> listTemp = ret_restricao_planejamentoDAO.getByPK(ret_restricao_planejamentoT);
/*      */       
/* 1460 */       return listTemp.size() > 0 ? (br.com.easynet.gwt.easyportal.transfer.Ret_restricao_planejamentoT)listTemp.get(0) : null;
/*      */     } catch (Exception e) {
/* 1462 */       e.printStackTrace();
/*      */     } finally {
/* 1464 */       close();
/*      */     }
/* 1466 */     return null;
/*      */   }
/*      */ }


/* Location:              /Users/marcos/fontes3/engenharia.jar!/br/com/easynet/gwt/easyportal/bl/SystemBusinessBase.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */