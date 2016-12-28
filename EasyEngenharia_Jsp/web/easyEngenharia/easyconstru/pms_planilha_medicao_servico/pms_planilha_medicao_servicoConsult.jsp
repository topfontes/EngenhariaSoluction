<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="pms_planilha_medicao_servicoJB" class="br.com.easynet.gwt.easyportal.jb.Pms_planilha_medicao_servicoConsultJB" scope="request"/>                                         
<jsp:setProperty name="pms_planilha_medicao_servicoJB" property="*"/>                                         
<jsp:setProperty name="pms_planilha_medicao_servicoJB" property="page" value="${pageContext}"/>                                         
${pms_planilha_medicao_servicoJB.execute}                                         
                                                                                

<form name="pms_planilha_medicao_servico" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/pms_planilha_medicao_servico/pms_planilha_medicao_servicoConsult.jsp"/>
    <center>     
	<label class="msg" align="center">${pms_planilha_medicao_servicoJB.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOpPortal('pms_planilha_medicao_servico','', '/easyEngenharia/easyconstru/pms_planilha_medicao_servico/pms_planilha_medicao_servicoInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOpPortal('pms_planilha_medicao_servico','consult', '/easyEngenharia/easyconstru/pms_planilha_medicao_servico/pms_planilha_medicao_servicoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
	
	<hr/> 
    <h2 align="center">List</h2>
    <center>
	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${pms_planilha_medicao_servicoJB.list}"  pagesize="10" requestURI="/easyEngenharia/pms_planilha_medicao_servico/pms_planilha_medicao_servicoConsult.jsp?clearop=true">

		<display:column sortable="false" title="Pms_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/pms_planilha_medicao_servico/pms_planilha_medicao_servicoUpdateDelete.jsp&op=findbyid&pms_planilha_medicao_servicoT.pms_nr_id=${item.pms_nr_id}&">
      		<c:out value="${item.pms_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Obr_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/pms_planilha_medicao_servico/pms_planilha_medicao_servicoUpdateDelete.jsp&op=findbyid&pms_planilha_medicao_servicoT.pms_nr_id=${item.pms_nr_id}&">
      		<c:out value="${item.obr_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Pms_nr_mes" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/pms_planilha_medicao_servico/pms_planilha_medicao_servicoUpdateDelete.jsp&op=findbyid&pms_planilha_medicao_servicoT.pms_nr_id=${item.pms_nr_id}&">
      		<c:out value="${item.pms_nr_mes}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plco_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/pms_planilha_medicao_servico/pms_planilha_medicao_servicoUpdateDelete.jsp&op=findbyid&pms_planilha_medicao_servicoT.pms_nr_id=${item.pms_nr_id}&">
      		<c:out value="${item.plco_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Pms_nr_quantidade_servico" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/pms_planilha_medicao_servico/pms_planilha_medicao_servicoUpdateDelete.jsp&op=findbyid&pms_planilha_medicao_servicoT.pms_nr_id=${item.pms_nr_id}&">
      		<c:out value="${item.pms_nr_quantidade_servico}"/>
            </a>
	</display:column>
      
       <display:column title="Apagar">

<!--portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=-->
		<a onclick="setOpPortal('pms_planilha_medicao_servico','delete', '/easyEngenharia/easyconstru/pms_planilha_medicao_servico/pms_planilha_medicao_servicoConsult.jsp?pms_planilha_medicao_servicoT.pms_nr_id=${item.pms_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.png">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
