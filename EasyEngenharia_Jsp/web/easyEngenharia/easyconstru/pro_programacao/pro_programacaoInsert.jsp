<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="pro_programacaoJB" class="br.com.easynet.gwt.easyportal.jb.Pro_programacaoInsertJB" scope="request"/>                                         
<jsp:setProperty name="pro_programacaoJB" property="*"/>                                         
<jsp:setProperty name="pro_programacaoJB" property="page" value="${pageContext}"/>                                         
${pro_programacaoJB.execute}                                         
                                                                               
	
<form name="pro_programacao" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/pro_programacao/pro_programacaoInsert.jsp"/>
    <center>     
     	<label class="msg">${pro_programacaoJB.msg}</label><br/>
	<table width="50%" border="0">
	         <tr>
	<td>
		<label>obr_nr_id:</label>
	</td>
	<td>
		<input type="text" name="pro_programacaoT.obr_nr_id" value="${pro_programacaoJB.pro_programacaoT.obr_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>pro_nr_mes:</label>
	</td>
	<td>
		<input type="text" name="pro_programacaoT.pro_nr_mes" value="${pro_programacaoJB.pro_programacaoT.pro_nr_mes}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>pro_nr_ano:</label>
	</td>
	<td>
		<input type="text" name="pro_programacaoT.pro_nr_ano" value="${pro_programacaoJB.pro_programacaoT.pro_nr_ano}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>pro_dt_coleta_orcamento:</label>
	</td>
	<td>
		<input type="text" name="pro_programacaoT.pro_dt_coleta_orcamento" value="<fmt:formatDate value="${pro_programacaoJB.pro_programacaoT.pro_dt_coleta_orcamento}" pattern="dd/MM/yyyy"/>" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>pro_dt_coleta_rh:</label>
	</td>
	<td>
		<input type="text" name="pro_programacaoT.pro_dt_coleta_rh" value="<fmt:formatDate value="${pro_programacaoJB.pro_programacaoT.pro_dt_coleta_rh}" pattern="dd/MM/yyyy"/>" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>pro_dt_analise_inicio:</label>
	</td>
	<td>
		<input type="text" name="pro_programacaoT.pro_dt_analise_inicio" value="<fmt:formatDate value="${pro_programacaoJB.pro_programacaoT.pro_dt_analise_inicio}" pattern="dd/MM/yyyy"/>" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>pro_dt_analise_final:</label>
	</td>
	<td>
		<input type="text" name="pro_programacaoT.pro_dt_analise_final" value="<fmt:formatDate value="${pro_programacaoJB.pro_programacaoT.pro_dt_analise_final}" pattern="dd/MM/yyyy"/>" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>pro_dt_reuniao_engenharia:</label>
	</td>
	<td>
		<input type="text" name="pro_programacaoT.pro_dt_reuniao_engenharia" value="<fmt:formatDate value="${pro_programacaoJB.pro_programacaoT.pro_dt_reuniao_engenharia}" pattern="dd/MM/yyyy"/>" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>pro_dt_reuniao_diretoria:</label>
	</td>
	<td>
		<input type="text" name="pro_programacaoT.pro_dt_reuniao_diretoria" value="<fmt:formatDate value="${pro_programacaoJB.pro_programacaoT.pro_dt_reuniao_diretoria}" pattern="dd/MM/yyyy"/>" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>pro_dt_reuniao_geral:</label>
	</td>
	<td>
		<input type="text" name="pro_programacaoT.pro_dt_reuniao_geral" value="<fmt:formatDate value="${pro_programacaoJB.pro_programacaoT.pro_dt_reuniao_geral}" pattern="dd/MM/yyyy"/>" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>

		<tr>
			<td colspan="2" align="center">
    			    <input type="button" value="Insert"  onClick="setOpPortal('pro_programacao','insert', '/easyEngenharia/easyconstru/pro_programacao/pro_programacaoInsert.jsp')" /> &nbsp;&nbsp;
    			    <input type="reset"  value="Clear" onclick="setOpPortal('pro_programacao','clear', '/easyEngenharia/easyconstru/pro_programacao/pro_programacaoInsert.jsp')"/>&nbsp;&nbsp;
    			    <input type="button" value="Voltar"  onClick="setOpPortal('pro_programacao','', '/easyEngenharia/easyconstru/pro_programacao/pro_programacaoConsult.jsp')" />
			</td>
		</tr>
    	</table>
    </center>     
	
    
</form>
  
