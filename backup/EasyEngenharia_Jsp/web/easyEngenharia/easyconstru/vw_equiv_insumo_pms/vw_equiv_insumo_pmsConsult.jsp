<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="vw_equiv_insumo_pmsJB" class="br.com.easynet.gwt.easyportal.jb.Vw_equiv_insumo_pmsConsultJB" scope="request"/>                                         
<jsp:setProperty name="vw_equiv_insumo_pmsJB" property="*"/>                                         
<jsp:setProperty name="vw_equiv_insumo_pmsJB" property="page" value="${pageContext}"/>                                         
${vw_equiv_insumo_pmsJB.execute}                                         
                                                                                

<form name="vw_equiv_insumo_pms" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/vw_equiv_insumo_pms/vw_equiv_insumo_pmsConsult.jsp"/>
    <center>     
	<label class="msg" align="center">${vw_equiv_insumo_pmsJB.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOpPortal('vw_equiv_insumo_pms','', '/easyEngenharia/easyconstru/vw_equiv_insumo_pms/vw_equiv_insumo_pmsInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOpPortal('vw_equiv_insumo_pms','consult', '/easyEngenharia/easyconstru/vw_equiv_insumo_pms/vw_equiv_insumo_pmsConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
	
	<hr/> 
    <h2 align="center">List</h2>
    <center>
	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${vw_equiv_insumo_pmsJB.list}"  pagesize="10" requestURI="/easyEngenharia/vw_equiv_insumo_pms/vw_equiv_insumo_pmsConsult.jsp?clearop=true">

		<display:column sortable="false" title="Obr_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/vw_equiv_insumo_pms/vw_equiv_insumo_pmsUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.obr_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plc_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/vw_equiv_insumo_pms/vw_equiv_insumo_pmsUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.plc_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plc_tx_nome" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/vw_equiv_insumo_pms/vw_equiv_insumo_pmsUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.plc_tx_nome}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Insumo" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/vw_equiv_insumo_pms/vw_equiv_insumo_pmsUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.insumo}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ipo_nr_vl_unitario" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/vw_equiv_insumo_pms/vw_equiv_insumo_pmsUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.ipo_nr_vl_unitario}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Pms_nr_mes" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/vw_equiv_insumo_pms/vw_equiv_insumo_pmsUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.pms_nr_mes}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Pms_nr_ano" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/vw_equiv_insumo_pms/vw_equiv_insumo_pmsUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.pms_nr_ano}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plco_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/vw_equiv_insumo_pms/vw_equiv_insumo_pmsUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.plco_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Perc" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/vw_equiv_insumo_pms/vw_equiv_insumo_pmsUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.perc}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Vl_total" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/vw_equiv_insumo_pms/vw_equiv_insumo_pmsUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.vl_total}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Vl_executado" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/vw_equiv_insumo_pms/vw_equiv_insumo_pmsUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.vl_executado}"/>
            </a>
	</display:column>
      
       <display:column title="Apagar">

<!--portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=-->
		<a onclick="setOpPortal('vw_equiv_insumo_pms','delete', '/easyEngenharia/easyconstru/vw_equiv_insumo_pms/vw_equiv_insumo_pmsConsult.jsp?')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.png">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
