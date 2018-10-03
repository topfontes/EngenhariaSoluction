<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="tpms_temporaria_pmsJB" class="br.com.easynet.gwt.easyportal.jb.Tpms_temporaria_pmsConsultJB" scope="request"/>                                         
<jsp:setProperty name="tpms_temporaria_pmsJB" property="*"/>                                         
<jsp:setProperty name="tpms_temporaria_pmsJB" property="page" value="${pageContext}"/>                                         
${tpms_temporaria_pmsJB.execute}                                         
                                                                                

<form name="tpms_temporaria_pms" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/tpms_temporaria_pms/tpms_temporaria_pmsConsult.jsp"/>
    <center>     
	<label class="msg" align="center">${tpms_temporaria_pmsJB.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOpPortal('tpms_temporaria_pms','', '/easyEngenharia/easyconstru/tpms_temporaria_pms/tpms_temporaria_pmsInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOpPortal('tpms_temporaria_pms','consult', '/easyEngenharia/easyconstru/tpms_temporaria_pms/tpms_temporaria_pmsConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
	
	<hr/> 
    <h2 align="center">List</h2>
    <center>
	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${tpms_temporaria_pmsJB.list}"  pagesize="10" requestURI="/easyEngenharia/tpms_temporaria_pms/tpms_temporaria_pmsConsult.jsp?clearop=true">

		<display:column sortable="false" title="Tmps_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/tpms_temporaria_pms/tpms_temporaria_pmsUpdateDelete.jsp&op=findbyid&tpms_temporaria_pmsT.tmps_nr_id=${item.tmps_nr_id}&">
      		<c:out value="${item.tmps_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plco_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/tpms_temporaria_pms/tpms_temporaria_pmsUpdateDelete.jsp&op=findbyid&tpms_temporaria_pmsT.tmps_nr_id=${item.tmps_nr_id}&">
      		<c:out value="${item.plco_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Tmps_nr_quantidade" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/tpms_temporaria_pms/tpms_temporaria_pmsUpdateDelete.jsp&op=findbyid&tpms_temporaria_pmsT.tmps_nr_id=${item.tmps_nr_id}&">
      		<c:out value="${item.tmps_nr_quantidade}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Tpms_bl_servico" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/tpms_temporaria_pms/tpms_temporaria_pmsUpdateDelete.jsp&op=findbyid&tpms_temporaria_pmsT.tmps_nr_id=${item.tmps_nr_id}&">
      		<c:out value="${item.tpms_bl_servico}"/>
            </a>
	</display:column>
      
       <display:column title="Apagar">

<!--portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=-->
		<a onclick="setOpPortal('tpms_temporaria_pms','delete', '/easyEngenharia/easyconstru/tpms_temporaria_pms/tpms_temporaria_pmsConsult.jsp?tpms_temporaria_pmsT.tmps_nr_id=${item.tmps_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.png">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
