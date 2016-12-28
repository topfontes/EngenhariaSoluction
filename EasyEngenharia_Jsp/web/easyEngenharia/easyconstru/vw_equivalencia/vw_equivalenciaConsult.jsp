<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="vw_equivalenciaJB" class="br.com.easynet.gwt.easyportal.jb.Vw_equivalenciaConsultJB" scope="request"/>                                         
<jsp:setProperty name="vw_equivalenciaJB" property="*"/>                                         
<jsp:setProperty name="vw_equivalenciaJB" property="page" value="${pageContext}"/>                                         
${vw_equivalenciaJB.execute}                                         
                                                                                

<form name="vw_equivalencia" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/vw_equivalencia/vw_equivalenciaConsult.jsp"/>
    <center>     
	<label class="msg" align="center">${vw_equivalenciaJB.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOpPortal('vw_equivalencia','', '/easyEngenharia/easyconstru/vw_equivalencia/vw_equivalenciaInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOpPortal('vw_equivalencia','consult', '/easyEngenharia/easyconstru/vw_equivalencia/vw_equivalenciaConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
	
	<hr/> 
    <h2 align="center">List</h2>
    <center>
	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${vw_equivalenciaJB.list}"  pagesize="10" requestURI="/easyEngenharia/vw_equivalencia/vw_equivalenciaConsult.jsp?clearop=true">

		<display:column sortable="false" title="Eplc_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/vw_equivalencia/vw_equivalenciaUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.eplc_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plc_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/vw_equivalencia/vw_equivalenciaUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.plc_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plco_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/vw_equivalencia/vw_equivalenciaUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.plco_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plco_tx_nome" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/vw_equivalencia/vw_equivalenciaUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.plco_tx_nome}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plc_tx_nome" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/vw_equivalencia/vw_equivalenciaUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.plc_tx_nome}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plco_tx_tipo" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/vw_equivalencia/vw_equivalenciaUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.plco_tx_tipo}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plco_tx_cod_externo" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/vw_equivalencia/vw_equivalenciaUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.plco_tx_cod_externo}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plco_tx_unidade" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/vw_equivalencia/vw_equivalenciaUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.plco_tx_unidade}"/>
            </a>
	</display:column>
      
       <display:column title="Apagar">

<!--portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=-->
		<a onclick="setOpPortal('vw_equivalencia','delete', '/easyEngenharia/easyconstru/vw_equivalencia/vw_equivalenciaConsult.jsp?')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.png">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
