<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="fat_fatorJB" class="br.com.easynet.gwt.easyportal.jb.Fat_fatorConsultJB" scope="request"/>                                         
<jsp:setProperty name="fat_fatorJB" property="*"/>                                         
<jsp:setProperty name="fat_fatorJB" property="page" value="${pageContext}"/>                                         
${fat_fatorJB.execute}                                         
                                                                                

<form name="fat_fator" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/fat_fator/fat_fatorConsult.jsp"/>
    <center>     
	<label class="msg" align="center">${fat_fatorJB.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOpPortal('fat_fator','', '/easyEngenharia/easyconstru/fat_fator/fat_fatorInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOpPortal('fat_fator','consult', '/easyEngenharia/easyconstru/fat_fator/fat_fatorConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
	
	<hr/> 
    <h2 align="center">List</h2>
    <center>
	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${fat_fatorJB.list}"  pagesize="10" requestURI="/easyEngenharia/fat_fator/fat_fatorConsult.jsp?clearop=true">

		<display:column sortable="false" title="Fat_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/fat_fator/fat_fatorUpdateDelete.jsp&op=findbyid&fat_fatorT.fat_nr_id=${item.fat_nr_id}&">
      		<c:out value="${item.fat_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plc_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/fat_fator/fat_fatorUpdateDelete.jsp&op=findbyid&fat_fatorT.fat_nr_id=${item.fat_nr_id}&">
      		<c:out value="${item.plc_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Fat_nr_fator_atual" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/fat_fator/fat_fatorUpdateDelete.jsp&op=findbyid&fat_fatorT.fat_nr_id=${item.fat_nr_id}&">
      		<c:out value="${item.fat_nr_fator_atual}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Fat_nr_fator_projetado" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/fat_fator/fat_fatorUpdateDelete.jsp&op=findbyid&fat_fatorT.fat_nr_id=${item.fat_nr_id}&">
      		<c:out value="${item.fat_nr_fator_projetado}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Fat_nr_mes" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/fat_fator/fat_fatorUpdateDelete.jsp&op=findbyid&fat_fatorT.fat_nr_id=${item.fat_nr_id}&">
      		<c:out value="${item.fat_nr_mes}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Fat_nr_ano" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/fat_fator/fat_fatorUpdateDelete.jsp&op=findbyid&fat_fatorT.fat_nr_id=${item.fat_nr_id}&">
      		<c:out value="${item.fat_nr_ano}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Obr_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/fat_fator/fat_fatorUpdateDelete.jsp&op=findbyid&fat_fatorT.fat_nr_id=${item.fat_nr_id}&">
      		<c:out value="${item.obr_nr_id}"/>
            </a>
	</display:column>
      
       <display:column title="Apagar">

<!--portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=-->
		<a onclick="setOpPortal('fat_fator','delete', '/easyEngenharia/easyconstru/fat_fator/fat_fatorConsult.jsp?fat_fatorT.fat_nr_id=${item.fat_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.png">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
