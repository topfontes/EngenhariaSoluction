<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="ctpm_conta_pagar_modificadaJB" class="br.com.easynet.gwt.easyportal.jb.Ctpm_conta_pagar_modificadaConsultJB" scope="request"/>                                         
<jsp:setProperty name="ctpm_conta_pagar_modificadaJB" property="*"/>                                         
<jsp:setProperty name="ctpm_conta_pagar_modificadaJB" property="page" value="${pageContext}"/>                                         
${ctpm_conta_pagar_modificadaJB.execute}                                         
                                                                                

<form name="ctpm_conta_pagar_modificada" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/ctpm_conta_pagar_modificada/ctpm_conta_pagar_modificadaConsult.jsp"/>
    <center>     
	<label class="msg" align="center">${ctpm_conta_pagar_modificadaJB.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOpPortal('ctpm_conta_pagar_modificada','', '/easyEngenharia/easyconstru/ctpm_conta_pagar_modificada/ctpm_conta_pagar_modificadaInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOpPortal('ctpm_conta_pagar_modificada','consult', '/easyEngenharia/easyconstru/ctpm_conta_pagar_modificada/ctpm_conta_pagar_modificadaConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
	
	<hr/> 
    <h2 align="center">List</h2>
    <center>
	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${ctpm_conta_pagar_modificadaJB.list}"  pagesize="10" requestURI="/easyEngenharia/ctpm_conta_pagar_modificada/ctpm_conta_pagar_modificadaConsult.jsp?clearop=true">

		<display:column sortable="false" title="Ctpm_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/ctpm_conta_pagar_modificada/ctpm_conta_pagar_modificadaUpdateDelete.jsp&op=findbyid&ctpm_conta_pagar_modificadaT.ctpm_nr_id=${item.ctpm_nr_id}&">
      		<c:out value="${item.ctpm_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Obr_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/ctpm_conta_pagar_modificada/ctpm_conta_pagar_modificadaUpdateDelete.jsp&op=findbyid&ctpm_conta_pagar_modificadaT.ctpm_nr_id=${item.ctpm_nr_id}&">
      		<c:out value="${item.obr_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ctp_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/ctpm_conta_pagar_modificada/ctpm_conta_pagar_modificadaUpdateDelete.jsp&op=findbyid&ctpm_conta_pagar_modificadaT.ctpm_nr_id=${item.ctpm_nr_id}&">
      		<c:out value="${item.ctp_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ctpm_nr_mes" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/ctpm_conta_pagar_modificada/ctpm_conta_pagar_modificadaUpdateDelete.jsp&op=findbyid&ctpm_conta_pagar_modificadaT.ctpm_nr_id=${item.ctpm_nr_id}&">
      		<c:out value="${item.ctpm_nr_mes}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ctpm_nr_ano" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/ctpm_conta_pagar_modificada/ctpm_conta_pagar_modificadaUpdateDelete.jsp&op=findbyid&ctpm_conta_pagar_modificadaT.ctpm_nr_id=${item.ctpm_nr_id}&">
      		<c:out value="${item.ctpm_nr_ano}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ctpm_tx_tipo" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/ctpm_conta_pagar_modificada/ctpm_conta_pagar_modificadaUpdateDelete.jsp&op=findbyid&ctpm_conta_pagar_modificadaT.ctpm_nr_id=${item.ctpm_nr_id}&">
      		<c:out value="${item.ctpm_tx_tipo}"/>
            </a>
	</display:column>
      
       <display:column title="Apagar">

<!--portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=-->
		<a onclick="setOpPortal('ctpm_conta_pagar_modificada','delete', '/easyEngenharia/easyconstru/ctpm_conta_pagar_modificada/ctpm_conta_pagar_modificadaConsult.jsp?ctpm_conta_pagar_modificadaT.ctpm_nr_id=${item.ctpm_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.png">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
