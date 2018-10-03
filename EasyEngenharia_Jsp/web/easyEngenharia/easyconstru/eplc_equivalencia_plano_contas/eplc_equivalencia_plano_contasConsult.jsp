<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="eplc_equivalencia_plano_contasJB" class="br.com.easynet.gwt.easyportal.jb.Eplc_equivalencia_plano_contasConsultJB" scope="request"/>                                         
<jsp:setProperty name="eplc_equivalencia_plano_contasJB" property="*"/>                                         
<jsp:setProperty name="eplc_equivalencia_plano_contasJB" property="page" value="${pageContext}"/>                                         
${eplc_equivalencia_plano_contasJB.execute}                                         
                                                                                

<form name="eplc_equivalencia_plano_contas" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyengenharia/easyconstru/eplc_equivalencia_plano_contas/eplc_equivalencia_plano_contasConsult.jsp"/>
    <center>     
	<label class="msg" align="center">${eplc_equivalencia_plano_contasJB.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOpPortal('eplc_equivalencia_plano_contas','', '/easyengenharia/easyconstru/eplc_equivalencia_plano_contas/eplc_equivalencia_plano_contasInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOpPortal('eplc_equivalencia_plano_contas','consult', '/easyengenharia/easyconstru/eplc_equivalencia_plano_contas/eplc_equivalencia_plano_contasConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
	
	<hr/> 
    <h2 align="center">List</h2>
    <center>
	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${eplc_equivalencia_plano_contasJB.list}"  pagesize="10" requestURI="/easyengenharia/eplc_equivalencia_plano_contas/eplc_equivalencia_plano_contasConsult.jsp?clearop=true">

		<display:column sortable="false" title="Eplc_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyengenharia/easyconstru/eplc_equivalencia_plano_contas/eplc_equivalencia_plano_contasUpdateDelete.jsp&op=findbyid&eplc_equivalencia_plano_contasT.eplc_nr_id=${item.eplc_nr_id}&">
      		<c:out value="${item.eplc_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plc_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyengenharia/easyconstru/eplc_equivalencia_plano_contas/eplc_equivalencia_plano_contasUpdateDelete.jsp&op=findbyid&eplc_equivalencia_plano_contasT.eplc_nr_id=${item.eplc_nr_id}&">
      		<c:out value="${item.plc_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plco_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyengenharia/easyconstru/eplc_equivalencia_plano_contas/eplc_equivalencia_plano_contasUpdateDelete.jsp&op=findbyid&eplc_equivalencia_plano_contasT.eplc_nr_id=${item.eplc_nr_id}&">
      		<c:out value="${item.plco_nr_id}"/>
            </a>
	</display:column>
      
       <display:column title="Apagar">

<!--portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=-->
		<a onclick="setOpPortal('eplc_equivalencia_plano_contas','delete', '/easyengenharia/easyconstru/eplc_equivalencia_plano_contas/eplc_equivalencia_plano_contasConsult.jsp?eplc_equivalencia_plano_contasT.eplc_nr_id=${item.eplc_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.png">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
