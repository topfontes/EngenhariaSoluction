<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="inc_informacoes_custoJB" class="br.com.easynet.gwt.easyportal.jb.Inc_informacoes_custoConsultJB" scope="request"/>                                         
<jsp:setProperty name="inc_informacoes_custoJB" property="*"/>                                         
<jsp:setProperty name="inc_informacoes_custoJB" property="page" value="${pageContext}"/>                                         
${inc_informacoes_custoJB.execute}                                         
                                                                                

<form name="inc_informacoes_custo" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/inc_informacoes_custo/inc_informacoes_custoConsult.jsp"/>
    <center>     
	<label class="msg" align="center">${inc_informacoes_custoJB.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOpPortal('inc_informacoes_custo','', '/easyEngenharia/easyconstru/inc_informacoes_custo/inc_informacoes_custoInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOpPortal('inc_informacoes_custo','consult', '/easyEngenharia/easyconstru/inc_informacoes_custo/inc_informacoes_custoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
	
	<hr/> 
    <h2 align="center">List</h2>
    <center>
	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${inc_informacoes_custoJB.list}"  pagesize="10" requestURI="/easyEngenharia/inc_informacoes_custo/inc_informacoes_custoConsult.jsp?clearop=true">

		<display:column sortable="false" title="Inc_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/inc_informacoes_custo/inc_informacoes_custoUpdateDelete.jsp&op=findbyid&inc_informacoes_custoT.inc_nr_id=${item.inc_nr_id}&">
      		<c:out value="${item.inc_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Obr_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/inc_informacoes_custo/inc_informacoes_custoUpdateDelete.jsp&op=findbyid&inc_informacoes_custoT.inc_nr_id=${item.inc_nr_id}&">
      		<c:out value="${item.obr_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Inc_nes_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/inc_informacoes_custo/inc_informacoes_custoUpdateDelete.jsp&op=findbyid&inc_informacoes_custoT.inc_nr_id=${item.inc_nr_id}&">
      		<c:out value="${item.inc_nes_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Inc_nr_ano" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/inc_informacoes_custo/inc_informacoes_custoUpdateDelete.jsp&op=findbyid&inc_informacoes_custoT.inc_nr_id=${item.inc_nr_id}&">
      		<c:out value="${item.inc_nr_ano}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plc_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/inc_informacoes_custo/inc_informacoes_custoUpdateDelete.jsp&op=findbyid&inc_informacoes_custoT.inc_nr_id=${item.inc_nr_id}&">
      		<c:out value="${item.plc_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Inc_tx_custo_acumulado" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/inc_informacoes_custo/inc_informacoes_custoUpdateDelete.jsp&op=findbyid&inc_informacoes_custoT.inc_nr_id=${item.inc_nr_id}&">
      		<c:out value="${item.inc_tx_custo_acumulado}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Inc_nr_custo_periodo" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/inc_informacoes_custo/inc_informacoes_custoUpdateDelete.jsp&op=findbyid&inc_informacoes_custoT.inc_nr_id=${item.inc_nr_id}&">
      		<c:out value="${item.inc_nr_custo_periodo}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Inc_tx_calsas" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/inc_informacoes_custo/inc_informacoes_custoUpdateDelete.jsp&op=findbyid&inc_informacoes_custoT.inc_nr_id=${item.inc_nr_id}&">
      		<c:out value="${item.inc_tx_calsas}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Inc_tx_problemas" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/inc_informacoes_custo/inc_informacoes_custoUpdateDelete.jsp&op=findbyid&inc_informacoes_custoT.inc_nr_id=${item.inc_nr_id}&">
      		<c:out value="${item.inc_tx_problemas}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Inc_tx_acoes" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/inc_informacoes_custo/inc_informacoes_custoUpdateDelete.jsp&op=findbyid&inc_informacoes_custoT.inc_nr_id=${item.inc_nr_id}&">
      		<c:out value="${item.inc_tx_acoes}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Inc_tx_responsavel" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/inc_informacoes_custo/inc_informacoes_custoUpdateDelete.jsp&op=findbyid&inc_informacoes_custoT.inc_nr_id=${item.inc_nr_id}&">
      		<c:out value="${item.inc_tx_responsavel}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Inc_dt_prazo" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/inc_informacoes_custo/inc_informacoes_custoUpdateDelete.jsp&op=findbyid&inc_informacoes_custoT.inc_nr_id=${item.inc_nr_id}&">
      		<fmt:formatDate value="${item.inc_dt_prazo}" pattern="dd/MM/yyyy"/>
            </a>
	</display:column>
      
       <display:column title="Apagar">

<!--portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=-->
		<a onclick="setOpPortal('inc_informacoes_custo','delete', '/easyEngenharia/easyconstru/inc_informacoes_custo/inc_informacoes_custoConsult.jsp?inc_informacoes_custoT.inc_nr_id=${item.inc_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.png">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
