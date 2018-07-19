<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="ipo_item_plano_contas_obraJB" class="br.com.easynet.gwt.easyportal.jb.Ipo_item_plano_contas_obraConsultJB" scope="request"/>                                         
<jsp:setProperty name="ipo_item_plano_contas_obraJB" property="*"/>                                         
<jsp:setProperty name="ipo_item_plano_contas_obraJB" property="page" value="${pageContext}"/>                                         
${ipo_item_plano_contas_obraJB.execute}                                         
                                                                                

<form name="ipo_item_plano_contas_obra" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyengenharia/easyconstru/ipo_item_plano_contas_obra/ipo_item_plano_contas_obraConsult.jsp"/>
    <center>     
	<label class="msg" align="center">${ipo_item_plano_contas_obraJB.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOpPortal('ipo_item_plano_contas_obra','', '/easyengenharia/easyconstru/ipo_item_plano_contas_obra/ipo_item_plano_contas_obraInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOpPortal('ipo_item_plano_contas_obra','consult', '/easyengenharia/easyconstru/ipo_item_plano_contas_obra/ipo_item_plano_contas_obraConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
	
	<hr/> 
    <h2 align="center">List</h2>
    <center>
	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${ipo_item_plano_contas_obraJB.list}"  pagesize="10" requestURI="/easyengenharia/ipo_item_plano_contas_obra/ipo_item_plano_contas_obraConsult.jsp?clearop=true">

		<display:column sortable="false" title="Ipo_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyengenharia/easyconstru/ipo_item_plano_contas_obra/ipo_item_plano_contas_obraUpdateDelete.jsp&op=findbyid&ipo_item_plano_contas_obraT.ipo_nr_id=${item.ipo_nr_id}&">
      		<c:out value="${item.ipo_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ipo_nr_quantidade" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyengenharia/easyconstru/ipo_item_plano_contas_obra/ipo_item_plano_contas_obraUpdateDelete.jsp&op=findbyid&ipo_item_plano_contas_obraT.ipo_nr_id=${item.ipo_nr_id}&">
      		<c:out value="${item.ipo_nr_quantidade}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ipo_nr_vl_unitario" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyengenharia/easyconstru/ipo_item_plano_contas_obra/ipo_item_plano_contas_obraUpdateDelete.jsp&op=findbyid&ipo_item_plano_contas_obraT.ipo_nr_id=${item.ipo_nr_id}&">
      		<c:out value="${item.ipo_nr_vl_unitario}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ipo_nr_vl_total" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyengenharia/easyconstru/ipo_item_plano_contas_obra/ipo_item_plano_contas_obraUpdateDelete.jsp&op=findbyid&ipo_item_plano_contas_obraT.ipo_nr_id=${item.ipo_nr_id}&">
      		<c:out value="${item.ipo_nr_vl_total}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Obr_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyengenharia/easyconstru/ipo_item_plano_contas_obra/ipo_item_plano_contas_obraUpdateDelete.jsp&op=findbyid&ipo_item_plano_contas_obraT.ipo_nr_id=${item.ipo_nr_id}&">
      		<c:out value="${item.obr_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plco_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyengenharia/easyconstru/ipo_item_plano_contas_obra/ipo_item_plano_contas_obraUpdateDelete.jsp&op=findbyid&ipo_item_plano_contas_obraT.ipo_nr_id=${item.ipo_nr_id}&">
      		<c:out value="${item.plco_nr_id}"/>
            </a>
	</display:column>
      
       <display:column title="Apagar">

<!--portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=-->
		<a onclick="setOpPortal('ipo_item_plano_contas_obra','delete', '/easyengenharia/easyconstru/ipo_item_plano_contas_obra/ipo_item_plano_contas_obraConsult.jsp?ipo_item_plano_contas_obraT.ipo_nr_id=${item.ipo_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.png">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
