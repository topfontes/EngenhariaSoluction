<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="pro_programacaoJB" class="br.com.easynet.gwt.easyportal.jb.Pro_programacaoConsultJB" scope="request"/>                                         
<jsp:setProperty name="pro_programacaoJB" property="*"/>                                         
<jsp:setProperty name="pro_programacaoJB" property="page" value="${pageContext}"/>                                         
${pro_programacaoJB.execute}                                         
                                                                                

<form name="pro_programacao" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/pro_programacao/pro_programacaoConsult.jsp"/>
    <center>     
	<label class="msg" align="center">${pro_programacaoJB.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOpPortal('pro_programacao','', '/easyEngenharia/easyconstru/pro_programacao/pro_programacaoInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOpPortal('pro_programacao','consult', '/easyEngenharia/easyconstru/pro_programacao/pro_programacaoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
	
	<hr/> 
    <h2 align="center">List</h2>
    <center>
	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${pro_programacaoJB.list}"  pagesize="10" requestURI="/easyEngenharia/pro_programacao/pro_programacaoConsult.jsp?clearop=true">

		<display:column sortable="false" title="Pro_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/pro_programacao/pro_programacaoUpdateDelete.jsp&op=findbyid&pro_programacaoT.pro_nr_id=${item.pro_nr_id}&">
      		<c:out value="${item.pro_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Obr_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/pro_programacao/pro_programacaoUpdateDelete.jsp&op=findbyid&pro_programacaoT.pro_nr_id=${item.pro_nr_id}&">
      		<c:out value="${item.obr_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Pro_nr_mes" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/pro_programacao/pro_programacaoUpdateDelete.jsp&op=findbyid&pro_programacaoT.pro_nr_id=${item.pro_nr_id}&">
      		<c:out value="${item.pro_nr_mes}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Pro_nr_ano" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/pro_programacao/pro_programacaoUpdateDelete.jsp&op=findbyid&pro_programacaoT.pro_nr_id=${item.pro_nr_id}&">
      		<c:out value="${item.pro_nr_ano}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Pro_dt_coleta_orcamento" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/pro_programacao/pro_programacaoUpdateDelete.jsp&op=findbyid&pro_programacaoT.pro_nr_id=${item.pro_nr_id}&">
      		<fmt:formatDate value="${item.pro_dt_coleta_orcamento}" pattern="dd/MM/yyyy"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Pro_dt_coleta_rh" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/pro_programacao/pro_programacaoUpdateDelete.jsp&op=findbyid&pro_programacaoT.pro_nr_id=${item.pro_nr_id}&">
      		<fmt:formatDate value="${item.pro_dt_coleta_rh}" pattern="dd/MM/yyyy"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Pro_dt_analise_inicio" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/pro_programacao/pro_programacaoUpdateDelete.jsp&op=findbyid&pro_programacaoT.pro_nr_id=${item.pro_nr_id}&">
      		<fmt:formatDate value="${item.pro_dt_analise_inicio}" pattern="dd/MM/yyyy"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Pro_dt_analise_final" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/pro_programacao/pro_programacaoUpdateDelete.jsp&op=findbyid&pro_programacaoT.pro_nr_id=${item.pro_nr_id}&">
      		<fmt:formatDate value="${item.pro_dt_analise_final}" pattern="dd/MM/yyyy"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Pro_dt_reuniao_engenharia" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/pro_programacao/pro_programacaoUpdateDelete.jsp&op=findbyid&pro_programacaoT.pro_nr_id=${item.pro_nr_id}&">
      		<fmt:formatDate value="${item.pro_dt_reuniao_engenharia}" pattern="dd/MM/yyyy"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Pro_dt_reuniao_diretoria" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/pro_programacao/pro_programacaoUpdateDelete.jsp&op=findbyid&pro_programacaoT.pro_nr_id=${item.pro_nr_id}&">
      		<fmt:formatDate value="${item.pro_dt_reuniao_diretoria}" pattern="dd/MM/yyyy"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Pro_dt_reuniao_geral" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/pro_programacao/pro_programacaoUpdateDelete.jsp&op=findbyid&pro_programacaoT.pro_nr_id=${item.pro_nr_id}&">
      		<fmt:formatDate value="${item.pro_dt_reuniao_geral}" pattern="dd/MM/yyyy"/>
            </a>
	</display:column>
      
       <display:column title="Apagar">

<!--portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=-->
		<a onclick="setOpPortal('pro_programacao','delete', '/easyEngenharia/easyconstru/pro_programacao/pro_programacaoConsult.jsp?pro_programacaoT.pro_nr_id=${item.pro_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.png">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
