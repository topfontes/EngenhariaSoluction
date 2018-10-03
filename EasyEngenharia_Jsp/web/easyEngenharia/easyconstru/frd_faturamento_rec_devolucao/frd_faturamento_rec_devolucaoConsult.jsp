<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="frd_faturamento_rec_devolucaoJB" class="br.com.easynet.gwt.easyportal.jb.Frd_faturamento_rec_devolucaoConsultJB" scope="request"/>                                         
<jsp:setProperty name="frd_faturamento_rec_devolucaoJB" property="*"/>                                         
<jsp:setProperty name="frd_faturamento_rec_devolucaoJB" property="page" value="${pageContext}"/>                                         
${frd_faturamento_rec_devolucaoJB.execute}                                         
                                                                                

<form name="frd_faturamento_rec_devolucao" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/EasyEngenharia/easyconstru/frd_faturamento_rec_devolucao/frd_faturamento_rec_devolucaoConsult.jsp"/>
    <center>     
	<label class="msg" align="center">${frd_faturamento_rec_devolucaoJB.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOpPortal('frd_faturamento_rec_devolucao','', '/EasyEngenharia/easyconstru/frd_faturamento_rec_devolucao/frd_faturamento_rec_devolucaoInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOpPortal('frd_faturamento_rec_devolucao','consult', '/EasyEngenharia/easyconstru/frd_faturamento_rec_devolucao/frd_faturamento_rec_devolucaoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
	
	<hr/> 
    <h2 align="center">List</h2>
    <center>
	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${frd_faturamento_rec_devolucaoJB.list}"  pagesize="10" requestURI="/EasyEngenharia/frd_faturamento_rec_devolucao/frd_faturamento_rec_devolucaoConsult.jsp?clearop=true">

		<display:column sortable="false" title="Frd_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/EasyEngenharia/easyconstru/frd_faturamento_rec_devolucao/frd_faturamento_rec_devolucaoUpdateDelete.jsp&op=findbyid&frd_faturamento_rec_devolucaoT.frd_nr_id=${item.frd_nr_id}&">
      		<c:out value="${item.frd_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Frd_nr_valor_permutado" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/EasyEngenharia/easyconstru/frd_faturamento_rec_devolucao/frd_faturamento_rec_devolucaoUpdateDelete.jsp&op=findbyid&frd_faturamento_rec_devolucaoT.frd_nr_id=${item.frd_nr_id}&">
      		<c:out value="${item.frd_nr_valor_permutado}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Frd_nr_vgv" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/EasyEngenharia/easyconstru/frd_faturamento_rec_devolucao/frd_faturamento_rec_devolucaoUpdateDelete.jsp&op=findbyid&frd_faturamento_rec_devolucaoT.frd_nr_id=${item.frd_nr_id}&">
      		<c:out value="${item.frd_nr_vgv}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Frd_nr_valor_devolucao" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/EasyEngenharia/easyconstru/frd_faturamento_rec_devolucao/frd_faturamento_rec_devolucaoUpdateDelete.jsp&op=findbyid&frd_faturamento_rec_devolucaoT.frd_nr_id=${item.frd_nr_id}&">
      		<c:out value="${item.frd_nr_valor_devolucao}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Frd_nr_valor_faturamento" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/EasyEngenharia/easyconstru/frd_faturamento_rec_devolucao/frd_faturamento_rec_devolucaoUpdateDelete.jsp&op=findbyid&frd_faturamento_rec_devolucaoT.frd_nr_id=${item.frd_nr_id}&">
      		<c:out value="${item.frd_nr_valor_faturamento}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Frd_nr_valor_recebimento" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/EasyEngenharia/easyconstru/frd_faturamento_rec_devolucao/frd_faturamento_rec_devolucaoUpdateDelete.jsp&op=findbyid&frd_faturamento_rec_devolucaoT.frd_nr_id=${item.frd_nr_id}&">
      		<c:out value="${item.frd_nr_valor_recebimento}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Frd_nr_valor_permutas" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/EasyEngenharia/easyconstru/frd_faturamento_rec_devolucao/frd_faturamento_rec_devolucaoUpdateDelete.jsp&op=findbyid&frd_faturamento_rec_devolucaoT.frd_nr_id=${item.frd_nr_id}&">
      		<c:out value="${item.frd_nr_valor_permutas}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Obr_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/EasyEngenharia/easyconstru/frd_faturamento_rec_devolucao/frd_faturamento_rec_devolucaoUpdateDelete.jsp&op=findbyid&frd_faturamento_rec_devolucaoT.frd_nr_id=${item.frd_nr_id}&">
      		<c:out value="${item.obr_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Frd_nr_mes" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/EasyEngenharia/easyconstru/frd_faturamento_rec_devolucao/frd_faturamento_rec_devolucaoUpdateDelete.jsp&op=findbyid&frd_faturamento_rec_devolucaoT.frd_nr_id=${item.frd_nr_id}&">
      		<c:out value="${item.frd_nr_mes}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Frd_nr_ano" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/EasyEngenharia/easyconstru/frd_faturamento_rec_devolucao/frd_faturamento_rec_devolucaoUpdateDelete.jsp&op=findbyid&frd_faturamento_rec_devolucaoT.frd_nr_id=${item.frd_nr_id}&">
      		<c:out value="${item.frd_nr_ano}"/>
            </a>
	</display:column>
      
       <display:column title="Apagar">

<!--portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=-->
		<a onclick="setOpPortal('frd_faturamento_rec_devolucao','delete', '/EasyEngenharia/easyconstru/frd_faturamento_rec_devolucao/frd_faturamento_rec_devolucaoConsult.jsp?frd_faturamento_rec_devolucaoT.frd_nr_id=${item.frd_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.png">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
