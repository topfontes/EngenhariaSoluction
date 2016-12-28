<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="vw_importacao_orcamentoJB" class="br.com.easynet.gwt.easyportal.jb.Vw_importacao_orcamentoConsultJB" scope="request"/>                                         
<jsp:setProperty name="vw_importacao_orcamentoJB" property="*"/>                                         
<jsp:setProperty name="vw_importacao_orcamentoJB" property="page" value="${pageContext}"/>                                         
${vw_importacao_orcamentoJB.execute}                                         
                                                                                

<form name="vw_importacao_orcamento" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/vw_importacao_orcamento/vw_importacao_orcamentoConsult.jsp"/>
    <center>     
	<label class="msg" align="center">${vw_importacao_orcamentoJB.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOpPortal('vw_importacao_orcamento','', '/easyEngenharia/easyconstru/vw_importacao_orcamento/vw_importacao_orcamentoInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOpPortal('vw_importacao_orcamento','consult', '/easyEngenharia/easyconstru/vw_importacao_orcamento/vw_importacao_orcamentoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
	
	<hr/> 
    <h2 align="center">List</h2>
    <center>
	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${vw_importacao_orcamentoJB.list}"  pagesize="10" requestURI="/easyEngenharia/vw_importacao_orcamento/vw_importacao_orcamentoConsult.jsp?clearop=true">

		<display:column sortable="false" title="Plco_tx_nome" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/vw_importacao_orcamento/vw_importacao_orcamentoUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.plco_tx_nome}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plco_tx_tipo" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/vw_importacao_orcamento/vw_importacao_orcamentoUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.plco_tx_tipo}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plco_tx_unidade" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/vw_importacao_orcamento/vw_importacao_orcamentoUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.plco_tx_unidade}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ipo_nr_quantidade" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/vw_importacao_orcamento/vw_importacao_orcamentoUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.ipo_nr_quantidade}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ipo_nr_vl_unitario" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/vw_importacao_orcamento/vw_importacao_orcamentoUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.ipo_nr_vl_unitario}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ipo_nr_vl_total" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/vw_importacao_orcamento/vw_importacao_orcamentoUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.ipo_nr_vl_total}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plco_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/vw_importacao_orcamento/vw_importacao_orcamentoUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.plco_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ipo_plc_nr_id_servico" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/vw_importacao_orcamento/vw_importacao_orcamentoUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.ipo_plc_nr_id_servico}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plco_tx_cod_externo" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/vw_importacao_orcamento/vw_importacao_orcamentoUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.plco_tx_cod_externo}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Obr_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/vw_importacao_orcamento/vw_importacao_orcamentoUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.obr_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plco_nr_nivel" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/vw_importacao_orcamento/vw_importacao_orcamentoUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.plco_nr_nivel}"/>
            </a>
	</display:column>
      
       <display:column title="Apagar">

<!--portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=-->
		<a onclick="setOpPortal('vw_importacao_orcamento','delete', '/easyEngenharia/easyconstru/vw_importacao_orcamento/vw_importacao_orcamentoConsult.jsp?')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.png">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
