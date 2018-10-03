<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="fto_fotosJB" class="br.com.easynet.gwt.easyportal.jb.Fto_fotosConsultJB" scope="request"/>                                         
<jsp:setProperty name="fto_fotosJB" property="*"/>                                         
<jsp:setProperty name="fto_fotosJB" property="page" value="${pageContext}"/>                                         
${fto_fotosJB.execute}                                         
                                                                                

<form name="fto_fotos" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/fto_fotos/fto_fotosConsult.jsp"/>
    <center>     
	<label class="msg" align="center">${fto_fotosJB.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOpPortal('fto_fotos','', '/easyEngenharia/easyconstru/fto_fotos/fto_fotosInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOpPortal('fto_fotos','consult', '/easyEngenharia/easyconstru/fto_fotos/fto_fotosConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
	
	<hr/> 
    <h2 align="center">List</h2>
    <center>
	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${fto_fotosJB.list}"  pagesize="10" requestURI="/easyEngenharia/fto_fotos/fto_fotosConsult.jsp?clearop=true">

		<display:column sortable="false" title="Fto_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/fto_fotos/fto_fotosUpdateDelete.jsp&op=findbyid&fto_fotosT.fto_nr_id=${item.fto_nr_id}&">
      		<c:out value="${item.fto_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Obr_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/fto_fotos/fto_fotosUpdateDelete.jsp&op=findbyid&fto_fotosT.fto_nr_id=${item.fto_nr_id}&">
      		<c:out value="${item.obr_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Fto_nr_mes" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/fto_fotos/fto_fotosUpdateDelete.jsp&op=findbyid&fto_fotosT.fto_nr_id=${item.fto_nr_id}&">
      		<c:out value="${item.fto_nr_mes}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Fto_nr_ano" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/fto_fotos/fto_fotosUpdateDelete.jsp&op=findbyid&fto_fotosT.fto_nr_id=${item.fto_nr_id}&">
      		<c:out value="${item.fto_nr_ano}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Fto_bt_foto" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/fto_fotos/fto_fotosUpdateDelete.jsp&op=findbyid&fto_fotosT.fto_nr_id=${item.fto_nr_id}&">
      		<img border="0" src="/easyportal/easyEngenharia/fto_fotos/fto_fotosUpdateDelete.jsp?op=downloadImage&fto_fotosT.fto_nr_id=${item.fto_nr_id}&"/>
            </a>
	</display:column>
      
       <display:column title="Apagar">

<!--portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=-->
		<a onclick="setOpPortal('fto_fotos','delete', '/easyEngenharia/easyconstru/fto_fotos/fto_fotosConsult.jsp?fto_fotosT.fto_nr_id=${item.fto_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.png">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
