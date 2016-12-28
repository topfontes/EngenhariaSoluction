<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="vw_cffo_mesJB" class="br.com.easynet.gwt.easyportal.client.jb.Vw_cffo_mesConsultJB" scope="request"/>                                         
<jsp:setProperty name="vw_cffo_mesJB" property="*"/>                                         
<jsp:setProperty name="vw_cffo_mesJB" property="page" value="${pageContext}"/>                                         
${vw_cffo_mesJB.execute}                                         
                                                                                

<form name="vw_cffo_mes" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/EasyEngenharia/easyconstru/vw_cffo_mes/vw_cffo_mesConsult.jsp"/>
    <center>     
	<label class="msg" align="center">${vw_cffo_mesJB.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOpPortal('vw_cffo_mes','', '/EasyEngenharia/easyconstru/vw_cffo_mes/vw_cffo_mesInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOpPortal('vw_cffo_mes','consult', '/EasyEngenharia/easyconstru/vw_cffo_mes/vw_cffo_mesConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
	
	<hr/> 
    <h2 align="center">List</h2>
    <center>
	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${vw_cffo_mesJB.list}"  pagesize="10" requestURI="/EasyEngenharia/vw_cffo_mes/vw_cffo_mesConsult.jsp?clearop=true">

		<display:column sortable="false" title="Obr_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/EasyEngenharia/easyconstru/vw_cffo_mes/vw_cffo_mesUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.obr_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cffo_nr_mes" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/EasyEngenharia/easyconstru/vw_cffo_mes/vw_cffo_mesUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.cffo_nr_mes}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cffo_nr_ano" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/EasyEngenharia/easyconstru/vw_cffo_mes/vw_cffo_mesUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.cffo_nr_ano}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Total" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/EasyEngenharia/easyconstru/vw_cffo_mes/vw_cffo_mesUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.total}"/>
            </a>
	</display:column>
      
       <display:column title="Apagar">

<!--portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=-->
		<a onclick="setOpPortal('vw_cffo_mes','delete', '/EasyEngenharia/easyconstru/vw_cffo_mes/vw_cffo_mesConsult.jsp?')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.png">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
