<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="vw_conta_pagar_alteradaJB" class="br.com.easynet.gwt.easyportal.jb.Vw_conta_pagar_alteradaConsultJB" scope="request"/>                                         
<jsp:setProperty name="vw_conta_pagar_alteradaJB" property="*"/>                                         
<jsp:setProperty name="vw_conta_pagar_alteradaJB" property="page" value="${pageContext}"/>                                         
${vw_conta_pagar_alteradaJB.execute}                                         
                                                                                

<form name="vw_conta_pagar_alterada" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/vw_conta_pagar_alterada/vw_conta_pagar_alteradaConsult.jsp"/>
    <center>     
	<label class="msg" align="center">${vw_conta_pagar_alteradaJB.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOpPortal('vw_conta_pagar_alterada','', '/easyEngenharia/easyconstru/vw_conta_pagar_alterada/vw_conta_pagar_alteradaInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOpPortal('vw_conta_pagar_alterada','consult', '/easyEngenharia/easyconstru/vw_conta_pagar_alterada/vw_conta_pagar_alteradaConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
	
	<hr/> 
    <h2 align="center">List</h2>
    <center>
	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${vw_conta_pagar_alteradaJB.list}"  pagesize="10" requestURI="/easyEngenharia/vw_conta_pagar_alterada/vw_conta_pagar_alteradaConsult.jsp?clearop=true">

		<display:column sortable="false" title="Ctp_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/vw_conta_pagar_alterada/vw_conta_pagar_alteradaUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.ctp_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ctp_nr_mes" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/vw_conta_pagar_alterada/vw_conta_pagar_alteradaUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.ctp_nr_mes}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ctp_nr_ano" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/vw_conta_pagar_alterada/vw_conta_pagar_alteradaUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.ctp_nr_ano}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ctp_nr_documento" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/vw_conta_pagar_alterada/vw_conta_pagar_alteradaUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.ctp_nr_documento}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ctp_tx_obs" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/vw_conta_pagar_alterada/vw_conta_pagar_alteradaUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.ctp_tx_obs}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ctp_tx_fornecedor" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/vw_conta_pagar_alterada/vw_conta_pagar_alteradaUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.ctp_tx_fornecedor}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ctp_nr_valor" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/vw_conta_pagar_alterada/vw_conta_pagar_alteradaUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.ctp_nr_valor}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ctpm_nr_mes" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/vw_conta_pagar_alterada/vw_conta_pagar_alteradaUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.ctpm_nr_mes}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ctpm_nr_ano" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/vw_conta_pagar_alterada/vw_conta_pagar_alteradaUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.ctpm_nr_ano}"/>
            </a>
	</display:column>
      
       <display:column title="Apagar">

<!--portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=-->
		<a onclick="setOpPortal('vw_conta_pagar_alterada','delete', '/easyEngenharia/easyconstru/vw_conta_pagar_alterada/vw_conta_pagar_alteradaConsult.jsp?')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.png">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
