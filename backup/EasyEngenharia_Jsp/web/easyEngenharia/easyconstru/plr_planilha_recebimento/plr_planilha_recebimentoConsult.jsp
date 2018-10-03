<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="plr_planilha_permutaJB" class="br.com.easynet.gwt.easyportal.jb.Plr_planilha_recebimentoConsultJB" scope="request"/>
<jsp:setProperty name="plr_planilha_permutaJB" property="*"/>                                         
<jsp:setProperty name="plr_planilha_permutaJB" property="page" value="${pageContext}"/>                                         
${plr_planilha_permutaJB.execute}                                         
                                                                                

<form name="plr_planilha_permuta" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/EasyEngenharia/easyconstru/plr_planilha_recebimento/plr_planilha_recebimentoConsult.jsp"/>
    <center>     
	<label class="msg" align="center">${plr_planilha_permutaJB.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOpPortal('plr_planilha_permuta','', '/EasyEngenharia/easyconstru/plr_planilha_permuta/plr_planilha_permutaInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOpPortal('plr_planilha_permuta','consult', '/EasyEngenharia/easyconstru/plr_planilha_permuta/plr_planilha_permutaConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
	
	<hr/> 
    <h2 align="center">List</h2>
    <center>
	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${plr_planilha_permutaJB.list}"  pagesize="10" requestURI="/EasyEngenharia/plr_planilha_permuta/plr_planilha_permutaConsult.jsp?clearop=true">

		<display:column sortable="false" title="Plr_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/EasyEngenharia/easyconstru/plr_planilha_permuta/plr_planilha_permutaUpdateDelete.jsp&op=findbyid&plr_planilha_permutaT.plr_nr_id=${item.plr_nr_id}&">
      		<c:out value="${item.plr_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Obr_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/EasyEngenharia/easyconstru/plr_planilha_permuta/plr_planilha_permutaUpdateDelete.jsp&op=findbyid&plr_planilha_permutaT.plr_nr_id=${item.plr_nr_id}&">
      		<c:out value="${item.obr_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plr_nr_mes_ref" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/EasyEngenharia/easyconstru/plr_planilha_permuta/plr_planilha_permutaUpdateDelete.jsp&op=findbyid&plr_planilha_permutaT.plr_nr_id=${item.plr_nr_id}&">
      		<c:out value="${item.plr_nr_mes_ref}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plr_nr_ano_ref" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/EasyEngenharia/easyconstru/plr_planilha_permuta/plr_planilha_permutaUpdateDelete.jsp&op=findbyid&plr_planilha_permutaT.plr_nr_id=${item.plr_nr_id}&">
      		<c:out value="${item.plr_nr_ano_ref}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plr_nr_mes" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/EasyEngenharia/easyconstru/plr_planilha_permuta/plr_planilha_permutaUpdateDelete.jsp&op=findbyid&plr_planilha_permutaT.plr_nr_id=${item.plr_nr_id}&">
      		<c:out value="${item.plr_nr_mes}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plr_nr_ano" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/EasyEngenharia/easyconstru/plr_planilha_permuta/plr_planilha_permutaUpdateDelete.jsp&op=findbyid&plr_planilha_permutaT.plr_nr_id=${item.plr_nr_id}&">
      		<c:out value="${item.plr_nr_ano}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plr_nr_efetuado_pj" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/EasyEngenharia/easyconstru/plr_planilha_permuta/plr_planilha_permutaUpdateDelete.jsp&op=findbyid&plr_planilha_permutaT.plr_nr_id=${item.plr_nr_id}&">
      		<c:out value="${item.plr_nr_efetuado_pj}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plr_nr_realizado_pf" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/EasyEngenharia/easyconstru/plr_planilha_permuta/plr_planilha_permutaUpdateDelete.jsp&op=findbyid&plr_planilha_permutaT.plr_nr_id=${item.plr_nr_id}&">
      		<c:out value="${item.plr_nr_realizado_pf}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plr_nr_realizado_pou" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/EasyEngenharia/easyconstru/plr_planilha_permuta/plr_planilha_permutaUpdateDelete.jsp&op=findbyid&plr_planilha_permutaT.plr_nr_id=${item.plr_nr_id}&">
      		<c:out value="${item.plr_nr_realizado_pou}"/>
            </a>
	</display:column>
      
       <display:column title="Apagar">

<!--portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=-->
		<a onclick="setOpPortal('plr_planilha_permuta','delete', '/EasyEngenharia/easyconstru/plr_planilha_permuta/plr_planilha_permutaConsult.jsp?plr_planilha_permutaT.plr_nr_id=${item.plr_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.png">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
