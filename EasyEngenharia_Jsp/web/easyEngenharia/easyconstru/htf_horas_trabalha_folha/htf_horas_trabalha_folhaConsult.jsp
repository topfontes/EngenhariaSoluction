<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="htf_horas_trabalha_folhaJB" class="br.com.easynet.gwt.easyportal.jb.Htf_horas_trabalha_folhaConsultJB" scope="request"/>                                         
<jsp:setProperty name="htf_horas_trabalha_folhaJB" property="*"/>                                         
<jsp:setProperty name="htf_horas_trabalha_folhaJB" property="page" value="${pageContext}"/>                                         
${htf_horas_trabalha_folhaJB.execute}                                         
                                                                                

<form name="htf_horas_trabalha_folha" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/htf_horas_trabalha_folha/htf_horas_trabalha_folhaConsult.jsp"/>
    <center>     
	<label class="msg" align="center">${htf_horas_trabalha_folhaJB.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOpPortal('htf_horas_trabalha_folha','', '/easyEngenharia/easyconstru/htf_horas_trabalha_folha/htf_horas_trabalha_folhaInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOpPortal('htf_horas_trabalha_folha','consult', '/easyEngenharia/easyconstru/htf_horas_trabalha_folha/htf_horas_trabalha_folhaConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
	
	<hr/> 
    <h2 align="center">List</h2>
    <center>
	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${htf_horas_trabalha_folhaJB.list}"  pagesize="10" requestURI="/easyEngenharia/htf_horas_trabalha_folha/htf_horas_trabalha_folhaConsult.jsp?clearop=true">

		<display:column sortable="false" title="Htf_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/htf_horas_trabalha_folha/htf_horas_trabalha_folhaUpdateDelete.jsp&op=findbyid&htf_horas_trabalha_folhaT.htf_nr_id=${item.htf_nr_id}&">
      		<c:out value="${item.htf_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Obr_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/htf_horas_trabalha_folha/htf_horas_trabalha_folhaUpdateDelete.jsp&op=findbyid&htf_horas_trabalha_folhaT.htf_nr_id=${item.htf_nr_id}&">
      		<c:out value="${item.obr_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Htf_nr_mes" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/htf_horas_trabalha_folha/htf_horas_trabalha_folhaUpdateDelete.jsp&op=findbyid&htf_horas_trabalha_folhaT.htf_nr_id=${item.htf_nr_id}&">
      		<c:out value="${item.htf_nr_mes}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Htf_nr_ano" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/htf_horas_trabalha_folha/htf_horas_trabalha_folhaUpdateDelete.jsp&op=findbyid&htf_horas_trabalha_folhaT.htf_nr_id=${item.htf_nr_id}&">
      		<c:out value="${item.htf_nr_ano}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Htf_nr_horas_trabalhada" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/htf_horas_trabalha_folha/htf_horas_trabalha_folhaUpdateDelete.jsp&op=findbyid&htf_horas_trabalha_folhaT.htf_nr_id=${item.htf_nr_id}&">
      		<c:out value="${item.htf_nr_horas_trabalhada}"/>
            </a>
	</display:column>
      
       <display:column title="Apagar">

<!--portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=-->
		<a onclick="setOpPortal('htf_horas_trabalha_folha','delete', '/easyEngenharia/easyconstru/htf_horas_trabalha_folha/htf_horas_trabalha_folhaConsult.jsp?htf_horas_trabalha_folhaT.htf_nr_id=${item.htf_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.png">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
