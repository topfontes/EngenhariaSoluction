<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="ctp_conta_pagarJB" class="br.com.easynet.gwt.easyportal.jb.Ctp_conta_pagarConsultJB" scope="request"/>                                         
<jsp:setProperty name="ctp_conta_pagarJB" property="*"/>                                         
<jsp:setProperty name="ctp_conta_pagarJB" property="page" value="${pageContext}"/>                                         
${ctp_conta_pagarJB.execute}                                         
                                                                                

<form name="ctp_conta_pagar" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/ctp_conta_pagar/ctp_conta_pagarConsult.jsp"/>
    <center>     
	<label class="msg" align="center">${ctp_conta_pagarJB.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOpPortal('ctp_conta_pagar','', '/easyEngenharia/easyconstru/ctp_conta_pagar/ctp_conta_pagarInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOpPortal('ctp_conta_pagar','consult', '/easyEngenharia/easyconstru/ctp_conta_pagar/ctp_conta_pagarConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
	
	<hr/> 
    <h2 align="center">List</h2>
    <center>
	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${ctp_conta_pagarJB.list}"  pagesize="10" requestURI="/easyEngenharia/ctp_conta_pagar/ctp_conta_pagarConsult.jsp?clearop=true">

		<display:column sortable="false" title="Ctp_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/ctp_conta_pagar/ctp_conta_pagarUpdateDelete.jsp&op=findbyid&ctp_conta_pagarT.ctp_nr_id=${item.ctp_nr_id}&">
      		<c:out value="${item.ctp_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="For_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/ctp_conta_pagar/ctp_conta_pagarUpdateDelete.jsp&op=findbyid&ctp_conta_pagarT.ctp_nr_id=${item.ctp_nr_id}&">
      		<c:out value="${item.for_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ctp_nr_mes" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/ctp_conta_pagar/ctp_conta_pagarUpdateDelete.jsp&op=findbyid&ctp_conta_pagarT.ctp_nr_id=${item.ctp_nr_id}&">
      		<c:out value="${item.ctp_nr_mes}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plc_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/ctp_conta_pagar/ctp_conta_pagarUpdateDelete.jsp&op=findbyid&ctp_conta_pagarT.ctp_nr_id=${item.ctp_nr_id}&">
      		<c:out value="${item.plc_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ctp_nr_valor" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/ctp_conta_pagar/ctp_conta_pagarUpdateDelete.jsp&op=findbyid&ctp_conta_pagarT.ctp_nr_id=${item.ctp_nr_id}&">
      		<c:out value="${item.ctp_nr_valor}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ctp_nr_documento" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/ctp_conta_pagar/ctp_conta_pagarUpdateDelete.jsp&op=findbyid&ctp_conta_pagarT.ctp_nr_id=${item.ctp_nr_id}&">
      		<c:out value="${item.ctp_nr_documento}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ctp_tx_status" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/ctp_conta_pagar/ctp_conta_pagarUpdateDelete.jsp&op=findbyid&ctp_conta_pagarT.ctp_nr_id=${item.ctp_nr_id}&">
      		<c:out value="${item.ctp_tx_status}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Obr_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/ctp_conta_pagar/ctp_conta_pagarUpdateDelete.jsp&op=findbyid&ctp_conta_pagarT.ctp_nr_id=${item.ctp_nr_id}&">
      		<c:out value="${item.obr_nr_id}"/>
            </a>
	</display:column>
      
       <display:column title="Apagar">

<!--portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=-->
		<a onclick="setOpPortal('ctp_conta_pagar','delete', '/easyEngenharia/easyconstru/ctp_conta_pagar/ctp_conta_pagarConsult.jsp?ctp_conta_pagarT.ctp_nr_id=${item.ctp_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.png">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
