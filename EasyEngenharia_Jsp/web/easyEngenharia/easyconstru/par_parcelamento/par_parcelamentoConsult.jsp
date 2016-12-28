<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="par_parcelamentoJB" class="br.com.easynet.gwt.easyportal.jb.Par_parcelamentoConsultJB" scope="request"/>                                         
<jsp:setProperty name="par_parcelamentoJB" property="*"/>                                         
<jsp:setProperty name="par_parcelamentoJB" property="page" value="${pageContext}"/>                                         
${par_parcelamentoJB.execute}                                         
                                                                                

<form name="par_parcelamento" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/par_parcelamento/par_parcelamentoConsult.jsp"/>
    <center>     
	<label class="msg" align="center">${par_parcelamentoJB.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOpPortal('par_parcelamento','', '/easyEngenharia/easyconstru/par_parcelamento/par_parcelamentoInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOpPortal('par_parcelamento','consult', '/easyEngenharia/easyconstru/par_parcelamento/par_parcelamentoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
	
	<hr/> 
    <h2 align="center">List</h2>
    <center>
	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${par_parcelamentoJB.list}"  pagesize="10" requestURI="/easyEngenharia/par_parcelamento/par_parcelamentoConsult.jsp?clearop=true">

		<display:column sortable="false" title="Par_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/par_parcelamento/par_parcelamentoUpdateDelete.jsp&op=findbyid&par_parcelamentoT.par_nr_id=${item.par_nr_id}&">
      		<c:out value="${item.par_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Par_tx_nome" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/par_parcelamento/par_parcelamentoUpdateDelete.jsp&op=findbyid&par_parcelamentoT.par_nr_id=${item.par_nr_id}&">
      		<c:out value="${item.par_tx_nome}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Par_nr_parcelas" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/par_parcelamento/par_parcelamentoUpdateDelete.jsp&op=findbyid&par_parcelamentoT.par_nr_id=${item.par_nr_id}&">
      		<c:out value="${item.par_nr_parcelas}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Par_nr_intervalo_dias" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/par_parcelamento/par_parcelamentoUpdateDelete.jsp&op=findbyid&par_parcelamentoT.par_nr_id=${item.par_nr_id}&">
      		<c:out value="${item.par_nr_intervalo_dias}"/>
            </a>
	</display:column>
      
       <display:column title="Apagar">

<!--portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=-->
		<a onclick="setOpPortal('par_parcelamento','delete', '/easyEngenharia/easyconstru/par_parcelamento/par_parcelamentoConsult.jsp?par_parcelamentoT.par_nr_id=${item.par_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.png">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
