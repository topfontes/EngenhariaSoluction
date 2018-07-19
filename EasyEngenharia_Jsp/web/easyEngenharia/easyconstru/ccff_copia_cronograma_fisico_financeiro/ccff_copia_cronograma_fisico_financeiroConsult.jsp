<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="ccff_copia_cronograma_fisico_financeiroJB" class="br.com.easynet.gwt.easyportal.jb.Ccff_copia_cronograma_fisico_financeiroConsultJB" scope="request"/>                                         
<jsp:setProperty name="ccff_copia_cronograma_fisico_financeiroJB" property="*"/>                                         
<jsp:setProperty name="ccff_copia_cronograma_fisico_financeiroJB" property="page" value="${pageContext}"/>                                         
${ccff_copia_cronograma_fisico_financeiroJB.execute}                                         
                                                                                

<form name="ccff_copia_cronograma_fisico_financeiro" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/ccff_copia_cronograma_fisico_financeiro/ccff_copia_cronograma_fisico_financeiroConsult.jsp"/>
    <center>     
	<label class="msg" align="center">${ccff_copia_cronograma_fisico_financeiroJB.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOpPortal('ccff_copia_cronograma_fisico_financeiro','', '/easyEngenharia/easyconstru/ccff_copia_cronograma_fisico_financeiro/ccff_copia_cronograma_fisico_financeiroInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOpPortal('ccff_copia_cronograma_fisico_financeiro','consult', '/easyEngenharia/easyconstru/ccff_copia_cronograma_fisico_financeiro/ccff_copia_cronograma_fisico_financeiroConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
        <br/>
	<hr/> 
    <h2 align="center">List</h2>
    <center>
	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${ccff_copia_cronograma_fisico_financeiroJB.list}"  pagesize="10" requestURI="/easyEngenharia/ccff_copia_cronograma_fisico_financeiro/ccff_copia_cronograma_fisico_financeiroConsult.jsp?clearop=true">

		<display:column sortable="false" title="Ccff_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/ccff_copia_cronograma_fisico_financeiro/ccff_copia_cronograma_fisico_financeiroUpdateDelete.jsp&op=findbyid&ccff_copia_cronograma_fisico_financeiroT.ccff_nr_id=${item.ccff_nr_id}&">
      		<c:out value="${item.ccff_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Obr_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/ccff_copia_cronograma_fisico_financeiro/ccff_copia_cronograma_fisico_financeiroUpdateDelete.jsp&op=findbyid&ccff_copia_cronograma_fisico_financeiroT.ccff_nr_id=${item.ccff_nr_id}&">
      		<c:out value="${item.obr_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plco_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/ccff_copia_cronograma_fisico_financeiro/ccff_copia_cronograma_fisico_financeiroUpdateDelete.jsp&op=findbyid&ccff_copia_cronograma_fisico_financeiroT.ccff_nr_id=${item.ccff_nr_id}&">
      		<c:out value="${item.plco_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ccff_nr_peso" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/ccff_copia_cronograma_fisico_financeiro/ccff_copia_cronograma_fisico_financeiroUpdateDelete.jsp&op=findbyid&ccff_copia_cronograma_fisico_financeiroT.ccff_nr_id=${item.ccff_nr_id}&">
      		<c:out value="${item.ccff_nr_peso}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ccff_nr_mes" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/ccff_copia_cronograma_fisico_financeiro/ccff_copia_cronograma_fisico_financeiroUpdateDelete.jsp&op=findbyid&ccff_copia_cronograma_fisico_financeiroT.ccff_nr_id=${item.ccff_nr_id}&">
      		<c:out value="${item.ccff_nr_mes}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ccff_nr_ano" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/ccff_copia_cronograma_fisico_financeiro/ccff_copia_cronograma_fisico_financeiroUpdateDelete.jsp&op=findbyid&ccff_copia_cronograma_fisico_financeiroT.ccff_nr_id=${item.ccff_nr_id}&">
      		<c:out value="${item.ccff_nr_ano}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ccff_nr_quantidade" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/ccff_copia_cronograma_fisico_financeiro/ccff_copia_cronograma_fisico_financeiroUpdateDelete.jsp&op=findbyid&ccff_copia_cronograma_fisico_financeiroT.ccff_nr_id=${item.ccff_nr_id}&">
      		<c:out value="${item.ccff_nr_quantidade}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ccff_nr_valor" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/ccff_copia_cronograma_fisico_financeiro/ccff_copia_cronograma_fisico_financeiroUpdateDelete.jsp&op=findbyid&ccff_copia_cronograma_fisico_financeiroT.ccff_nr_id=${item.ccff_nr_id}&">
      		<c:out value="${item.ccff_nr_valor}"/>
            </a>
	</display:column>
      
       <display:column title="Apagar">

<!--portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=-->
		<a onclick="setOpPortal('ccff_copia_cronograma_fisico_financeiro','delete', '/easyEngenharia/easyconstru/ccff_copia_cronograma_fisico_financeiro/ccff_copia_cronograma_fisico_financeiroConsult.jsp?ccff_copia_cronograma_fisico_financeiroT.ccff_nr_id=${item.ccff_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.png">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
