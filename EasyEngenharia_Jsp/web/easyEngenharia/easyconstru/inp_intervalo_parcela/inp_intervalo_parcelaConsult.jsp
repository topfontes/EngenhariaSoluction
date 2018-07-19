<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="inp_intervalo_parcelaJB" class="br.com.easynet.gwt.easyportal.jb.Inp_intervalo_parcelaConsultJB" scope="request"/>                                         
<jsp:setProperty name="inp_intervalo_parcelaJB" property="*"/>                                         
<jsp:setProperty name="inp_intervalo_parcelaJB" property="page" value="${pageContext}"/>                                         
${inp_intervalo_parcelaJB.execute}                                         
                                                                                

<form name="inp_intervalo_parcela" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/inp_intervalo_parcela/inp_intervalo_parcelaConsult.jsp"/>
    <center>     
	<label class="msg" align="center">${inp_intervalo_parcelaJB.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOpPortal('inp_intervalo_parcela','', '/easyEngenharia/easyconstru/inp_intervalo_parcela/inp_intervalo_parcelaInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOpPortal('inp_intervalo_parcela','consult', '/easyEngenharia/easyconstru/inp_intervalo_parcela/inp_intervalo_parcelaConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
	
	<hr/> 
    <h2 align="center">List</h2>
    <center>
	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${inp_intervalo_parcelaJB.list}"  pagesize="10" requestURI="/easyEngenharia/inp_intervalo_parcela/inp_intervalo_parcelaConsult.jsp?clearop=true">

		<display:column sortable="false" title="Inp_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/inp_intervalo_parcela/inp_intervalo_parcelaUpdateDelete.jsp&op=findbyid&inp_intervalo_parcelaT.inp_nr_id=${item.inp_nr_id}&">
      		<c:out value="${item.inp_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Par_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/inp_intervalo_parcela/inp_intervalo_parcelaUpdateDelete.jsp&op=findbyid&inp_intervalo_parcelaT.inp_nr_id=${item.inp_nr_id}&">
      		<c:out value="${item.par_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Inp_nr_dias" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/inp_intervalo_parcela/inp_intervalo_parcelaUpdateDelete.jsp&op=findbyid&inp_intervalo_parcelaT.inp_nr_id=${item.inp_nr_id}&">
      		<c:out value="${item.inp_nr_dias}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Inp_nr_per" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/inp_intervalo_parcela/inp_intervalo_parcelaUpdateDelete.jsp&op=findbyid&inp_intervalo_parcelaT.inp_nr_id=${item.inp_nr_id}&">
      		<c:out value="${item.inp_nr_per}"/>
            </a>
	</display:column>
      
       <display:column title="Apagar">

<!--portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=-->
		<a onclick="setOpPortal('inp_intervalo_parcela','delete', '/easyEngenharia/easyconstru/inp_intervalo_parcela/inp_intervalo_parcelaConsult.jsp?inp_intervalo_parcelaT.inp_nr_id=${item.inp_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.png">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
