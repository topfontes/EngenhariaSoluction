<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="cffo_cronograma_fisico_financeiro_origenalJB" class="br.com.easynet.gwt.easyportal.jb.Cffo_cronograma_fisico_financeiro_origenalConsultJB" scope="request"/>                                         
<jsp:setProperty name="cffo_cronograma_fisico_financeiro_origenalJB" property="*"/>                                         
<jsp:setProperty name="cffo_cronograma_fisico_financeiro_origenalJB" property="page" value="${pageContext}"/>                                         
${cffo_cronograma_fisico_financeiro_origenalJB.execute}                                         
                                                                                

<form name="cffo_cronograma_fisico_financeiro_origenal" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/cffo_cronograma_fisico_financeiro_origenal/cffo_cronograma_fisico_financeiro_origenalConsult.jsp"/>
    <center>     
	<label class="msg" align="center">${cffo_cronograma_fisico_financeiro_origenalJB.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOpPortal('cffo_cronograma_fisico_financeiro_origenal','', '/easyEngenharia/easyconstru/cffo_cronograma_fisico_financeiro_origenal/cffo_cronograma_fisico_financeiro_origenalInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOpPortal('cffo_cronograma_fisico_financeiro_origenal','consult', '/easyEngenharia/easyconstru/cffo_cronograma_fisico_financeiro_origenal/cffo_cronograma_fisico_financeiro_origenalConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
	
	<hr/> 
    <h2 align="center">List</h2>
    <center>
	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${cffo_cronograma_fisico_financeiro_origenalJB.list}"  pagesize="10" requestURI="/easyEngenharia/cffo_cronograma_fisico_financeiro_origenal/cffo_cronograma_fisico_financeiro_origenalConsult.jsp?clearop=true">

		<display:column sortable="false" title="Cffo_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/cffo_cronograma_fisico_financeiro_origenal/cffo_cronograma_fisico_financeiro_origenalUpdateDelete.jsp&op=findbyid&cffo_cronograma_fisico_financeiro_origenalT.cffo_nr_id=${item.cffo_nr_id}&">
      		<c:out value="${item.cffo_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plco_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/cffo_cronograma_fisico_financeiro_origenal/cffo_cronograma_fisico_financeiro_origenalUpdateDelete.jsp&op=findbyid&cffo_cronograma_fisico_financeiro_origenalT.cffo_nr_id=${item.cffo_nr_id}&">
      		<c:out value="${item.plco_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Obr_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/cffo_cronograma_fisico_financeiro_origenal/cffo_cronograma_fisico_financeiro_origenalUpdateDelete.jsp&op=findbyid&cffo_cronograma_fisico_financeiro_origenalT.cffo_nr_id=${item.cffo_nr_id}&">
      		<c:out value="${item.obr_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cffo_nr_peso" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/cffo_cronograma_fisico_financeiro_origenal/cffo_cronograma_fisico_financeiro_origenalUpdateDelete.jsp&op=findbyid&cffo_cronograma_fisico_financeiro_origenalT.cffo_nr_id=${item.cffo_nr_id}&">
      		<c:out value="${item.cffo_nr_peso}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cffo_nr_mes" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/cffo_cronograma_fisico_financeiro_origenal/cffo_cronograma_fisico_financeiro_origenalUpdateDelete.jsp&op=findbyid&cffo_cronograma_fisico_financeiro_origenalT.cffo_nr_id=${item.cffo_nr_id}&">
      		<c:out value="${item.cffo_nr_mes}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cffo_nr_ano" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/cffo_cronograma_fisico_financeiro_origenal/cffo_cronograma_fisico_financeiro_origenalUpdateDelete.jsp&op=findbyid&cffo_cronograma_fisico_financeiro_origenalT.cffo_nr_id=${item.cffo_nr_id}&">
      		<c:out value="${item.cffo_nr_ano}"/>
            </a>
	</display:column>
      
       <display:column title="Apagar">

<!--portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=-->
		<a onclick="setOpPortal('cffo_cronograma_fisico_financeiro_origenal','delete', '/easyEngenharia/easyconstru/cffo_cronograma_fisico_financeiro_origenal/cffo_cronograma_fisico_financeiro_origenalConsult.jsp?cffo_cronograma_fisico_financeiro_origenalT.cffo_nr_id=${item.cffo_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.png">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
