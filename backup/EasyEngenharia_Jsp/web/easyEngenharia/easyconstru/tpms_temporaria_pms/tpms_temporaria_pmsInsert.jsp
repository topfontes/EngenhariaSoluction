<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="tpms_temporaria_pmsJB" class="br.com.easynet.gwt.easyportal.jb.Tpms_temporaria_pmsInsertJB" scope="request"/>                                         
<jsp:setProperty name="tpms_temporaria_pmsJB" property="*"/>                                         
<jsp:setProperty name="tpms_temporaria_pmsJB" property="page" value="${pageContext}"/>                                         
${tpms_temporaria_pmsJB.execute}                                         
                                                                               
	
<form name="tpms_temporaria_pms" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/tpms_temporaria_pms/tpms_temporaria_pmsInsert.jsp"/>
    <center>     
     	<label class="msg">${tpms_temporaria_pmsJB.msg}</label><br/>
	<table width="50%" border="0">
	    <tr>
	<td>
		<label>plco_nr_id:</label>
	</td>
	<td>
	    <select name="tpms_temporaria_pmsT.plco_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${tpms_temporaria_pmsJB.listplco_plano_contas_orcamento}" var="item">
            	  <option value="${item.plco_nr_id}">${item.plco_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

     <tr>
	<td>
		<label>tmps_nr_quantidade:</label>
	</td>
	<td>
		<input type="text" name="tpms_temporaria_pmsT.tmps_nr_quantidade" value="${tpms_temporaria_pmsJB.tpms_temporaria_pmsT.tmps_nr_quantidade}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>tpms_bl_servico:</label>
	</td>
	<td>
		<input type="text" name="tpms_temporaria_pmsT.tpms_bl_servico" value="${tpms_temporaria_pmsJB.tpms_temporaria_pmsT.tpms_bl_servico}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>

		<tr>
			<td colspan="2" align="center">
    			    <input type="button" value="Insert"  onClick="setOpPortal('tpms_temporaria_pms','insert', '/easyEngenharia/easyconstru/tpms_temporaria_pms/tpms_temporaria_pmsInsert.jsp')" /> &nbsp;&nbsp;
    			    <input type="reset"  value="Clear" onclick="setOpPortal('tpms_temporaria_pms','clear', '/easyEngenharia/easyconstru/tpms_temporaria_pms/tpms_temporaria_pmsInsert.jsp')"/>&nbsp;&nbsp;
    			    <input type="button" value="Voltar"  onClick="setOpPortal('tpms_temporaria_pms','', '/easyEngenharia/easyconstru/tpms_temporaria_pms/tpms_temporaria_pmsConsult.jsp')" />
			</td>
		</tr>
    	</table>
    </center>     
	
    
</form>
  
