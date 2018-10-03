<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="dso_descricao_servico_obraJB" class="br.com.easynet.gwt.easyportal.jb.Dso_descricao_servico_obraConsultJB" scope="request"/>                                         
<jsp:setProperty name="dso_descricao_servico_obraJB" property="*"/>                                         
<jsp:setProperty name="dso_descricao_servico_obraJB" property="page" value="${pageContext}"/>                                         
${dso_descricao_servico_obraJB.execute}                                         
                                                                                

<form name="dso_descricao_servico_obra" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/dso_descricao_servico_obra/dso_descricao_servico_obraConsult.jsp"/>
    <center>     
	<label class="msg" align="center">${dso_descricao_servico_obraJB.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOpPortal('dso_descricao_servico_obra','', '/easyEngenharia/easyconstru/dso_descricao_servico_obra/dso_descricao_servico_obraInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOpPortal('dso_descricao_servico_obra','consult', '/easyEngenharia/easyconstru/dso_descricao_servico_obra/dso_descricao_servico_obraConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
	
	<hr/> 
    <h2 align="center">List</h2>
    <center>
	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${dso_descricao_servico_obraJB.list}"  pagesize="10" requestURI="/easyEngenharia/dso_descricao_servico_obra/dso_descricao_servico_obraConsult.jsp?clearop=true">

		<display:column sortable="false" title="Plco_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/dso_descricao_servico_obra/dso_descricao_servico_obraUpdateDelete.jsp&op=findbyid&dso_descricao_servico_obraT.dso_nr_id=${item.dso_nr_id}&">
      		<c:out value="${item.plco_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Dso_tx_codigo_externo" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/dso_descricao_servico_obra/dso_descricao_servico_obraUpdateDelete.jsp&op=findbyid&dso_descricao_servico_obraT.dso_nr_id=${item.dso_nr_id}&">
      		<c:out value="${item.dso_tx_codigo_externo}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Dso_tx_descriaco" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/dso_descricao_servico_obra/dso_descricao_servico_obraUpdateDelete.jsp&op=findbyid&dso_descricao_servico_obraT.dso_nr_id=${item.dso_nr_id}&">
      		<c:out value="${item.dso_tx_descriaco}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Dso_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/dso_descricao_servico_obra/dso_descricao_servico_obraUpdateDelete.jsp&op=findbyid&dso_descricao_servico_obraT.dso_nr_id=${item.dso_nr_id}&">
      		<c:out value="${item.dso_nr_id}"/>
            </a>
	</display:column>
      
       <display:column title="Apagar">

<!--portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=-->
		<a onclick="setOpPortal('dso_descricao_servico_obra','delete', '/easyEngenharia/easyconstru/dso_descricao_servico_obra/dso_descricao_servico_obraConsult.jsp?dso_descricao_servico_obraT.dso_nr_id=${item.dso_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.png">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
