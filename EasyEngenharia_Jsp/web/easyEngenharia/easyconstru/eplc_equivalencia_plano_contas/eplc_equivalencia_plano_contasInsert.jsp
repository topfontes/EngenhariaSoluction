<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="eplc_equivalencia_plano_contasJB" class="br.com.easynet.gwt.easyportal.jb.Eplc_equivalencia_plano_contasInsertJB" scope="request"/>                                         
<jsp:setProperty name="eplc_equivalencia_plano_contasJB" property="*"/>                                         
<jsp:setProperty name="eplc_equivalencia_plano_contasJB" property="page" value="${pageContext}"/>                                         
${eplc_equivalencia_plano_contasJB.execute}                                         
                                                                               
	
<form name="eplc_equivalencia_plano_contas" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyengenharia/easyconstru/eplc_equivalencia_plano_contas/eplc_equivalencia_plano_contasInsert.jsp"/>
    <center>     
     	<label class="msg">${eplc_equivalencia_plano_contasJB.msg}</label><br/>
	<table width="50%" border="0">
	    <tr>
	<td>
		<label>plc_nr_id:</label>
	</td>
	<td>
	    <select name="eplc_equivalencia_plano_contasT.plc_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${eplc_equivalencia_plano_contasJB.listplc_plano_contas}" var="item">
            	  <option value="${item.plc_nr_id}">${item.plc_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

<tr>
	<td>
		<label>plco_nr_id:</label>
	</td>
	<td>
	    <select name="eplc_equivalencia_plano_contasT.plco_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${eplc_equivalencia_plano_contasJB.listplco_plano_contas_orcamento}" var="item">
            	  <option value="${item.plco_nr_id}">${item.plco_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	


		<tr>
			<td colspan="2" align="center">
    			    <input type="button" value="Insert"  onClick="setOpPortal('eplc_equivalencia_plano_contas','insert', '/easyengenharia/easyconstru/eplc_equivalencia_plano_contas/eplc_equivalencia_plano_contasInsert.jsp')" /> &nbsp;&nbsp;
    			    <input type="reset"  value="Clear" onclick="setOpPortal('eplc_equivalencia_plano_contas','clear', '/easyengenharia/easyconstru/eplc_equivalencia_plano_contas/eplc_equivalencia_plano_contasInsert.jsp')"/>&nbsp;&nbsp;
    			    <input type="button" value="Voltar"  onClick="setOpPortal('eplc_equivalencia_plano_contas','', '/easyengenharia/easyconstru/eplc_equivalencia_plano_contas/eplc_equivalencia_plano_contasConsult.jsp')" />
			</td>
		</tr>
    	</table>
    </center>     
	
    
</form>
  
