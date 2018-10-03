<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="scfp_subclasse_operario_previstoJB" class="br.com.easynet.gwt.easyportal.jb.Scfp_subclasse_operario_previstoConsultJB" scope="request"/>                                         
<jsp:setProperty name="scfp_subclasse_operario_previstoJB" property="*"/>                                         
<jsp:setProperty name="scfp_subclasse_operario_previstoJB" property="page" value="${pageContext}"/>                                         
${scfp_subclasse_operario_previstoJB.execute}                                         
                                                                                

<form name="scfp_subclasse_operario_previsto" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/scfp_subclasse_operario_previsto/scfp_subclasse_operario_previstoConsult.jsp"/>
    <center>     
	<label class="msg" align="center">${scfp_subclasse_operario_previstoJB.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOpPortal('scfp_subclasse_operario_previsto','', '/easyEngenharia/easyconstru/scfp_subclasse_operario_previsto/scfp_subclasse_operario_previstoInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOpPortal('scfp_subclasse_operario_previsto','consult', '/easyEngenharia/easyconstru/scfp_subclasse_operario_previsto/scfp_subclasse_operario_previstoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
	
	<hr/> 
    <h2 align="center">List</h2>
    <center>
	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${scfp_subclasse_operario_previstoJB.list}"  pagesize="10" requestURI="/easyEngenharia/scfp_subclasse_operario_previsto/scfp_subclasse_operario_previstoConsult.jsp?clearop=true">

		<display:column sortable="false" title="Scfp_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/scfp_subclasse_operario_previsto/scfp_subclasse_operario_previstoUpdateDelete.jsp&op=findbyid&scfp_subclasse_operario_previstoT.scfp_nr_id=${item.scfp_nr_id}&">
      		<c:out value="${item.scfp_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plc_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/scfp_subclasse_operario_previsto/scfp_subclasse_operario_previstoUpdateDelete.jsp&op=findbyid&scfp_subclasse_operario_previstoT.scfp_nr_id=${item.scfp_nr_id}&">
      		<c:out value="${item.plc_nr_id}"/>
            </a>
	</display:column>
      
       <display:column title="Apagar">

<!--portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=-->
		<a onclick="setOpPortal('scfp_subclasse_operario_previsto','delete', '/easyEngenharia/easyconstru/scfp_subclasse_operario_previsto/scfp_subclasse_operario_previstoConsult.jsp?scfp_subclasse_operario_previstoT.scfp_nr_id=${item.scfp_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.png">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
