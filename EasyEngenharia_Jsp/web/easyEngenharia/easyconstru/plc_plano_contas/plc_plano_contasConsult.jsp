<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="plc_plano_contasJB" class="br.com.easynet.gwt.easyportal.jb.Plc_plano_contasConsultJB" scope="request"/>                                         
<jsp:setProperty name="plc_plano_contasJB" property="*"/>                                         
<jsp:setProperty name="plc_plano_contasJB" property="page" value="${pageContext}"/>                                         
${plc_plano_contasJB.execute}                                         
                                                                                

<form name="plc_plano_contas" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/plc_plano_contas/plc_plano_contasConsult.jsp"/>
    <center>     
	<label class="msg" align="center">${plc_plano_contasJB.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOpPortal('plc_plano_contas','', '/easyEngenharia/easyconstru/plc_plano_contas/plc_plano_contasInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOpPortal('plc_plano_contas','consult', '/easyEngenharia/easyconstru/plc_plano_contas/plc_plano_contasConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
	
	<hr/> 
    <h2 align="center">List</h2>
    <center>
	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${plc_plano_contasJB.list}"  pagesize="10" requestURI="/easyEngenharia/plc_plano_contas/plc_plano_contasConsult.jsp?clearop=true">

		<display:column sortable="false" title="Plc_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/plc_plano_contas/plc_plano_contasUpdateDelete.jsp&op=findbyid&plc_plano_contasT.plc_nr_id=${item.plc_nr_id}&">
      		<c:out value="${item.plc_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plc_tx_nome" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/plc_plano_contas/plc_plano_contasUpdateDelete.jsp&op=findbyid&plc_plano_contasT.plc_nr_id=${item.plc_nr_id}&">
      		<c:out value="${item.plc_tx_nome}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plc_nr_id_super" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/plc_plano_contas/plc_plano_contasUpdateDelete.jsp&op=findbyid&plc_plano_contasT.plc_nr_id=${item.plc_nr_id}&">
      		<c:out value="${item.plc_nr_id_super}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plc_tx_caixa_banco" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/plc_plano_contas/plc_plano_contasUpdateDelete.jsp&op=findbyid&plc_plano_contasT.plc_nr_id=${item.plc_nr_id}&">
      		<c:out value="${item.plc_tx_caixa_banco}"/>
            </a>
	</display:column>
      
       <display:column title="Apagar">

<!--portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=-->
		<a onclick="setOpPortal('plc_plano_contas','delete', '/easyEngenharia/easyconstru/plc_plano_contas/plc_plano_contasConsult.jsp?plc_plano_contasT.plc_nr_id=${item.plc_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.png">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
