<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="com_comprometimentoJB" class="br.com.easynet.gwt.easyportal.jb.Com_comprometimentoConsultJB" scope="request"/>                                         
<jsp:setProperty name="com_comprometimentoJB" property="*"/>                                         
<jsp:setProperty name="com_comprometimentoJB" property="page" value="${pageContext}"/>                                         
${com_comprometimentoJB.execute}                                         
                                                                                

<form name="com_comprometimento" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/com_comprometimento/com_comprometimentoConsult.jsp"/>
    <center>     
	<label class="msg" align="center">${com_comprometimentoJB.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOpPortal('com_comprometimento','', '/easyEngenharia/easyconstru/com_comprometimento/com_comprometimentoInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOpPortal('com_comprometimento','consult', '/easyEngenharia/easyconstru/com_comprometimento/com_comprometimentoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
	
	<hr/> 
    <h2 align="center">List</h2>
    <center>
	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${com_comprometimentoJB.list}"  pagesize="10" requestURI="/easyEngenharia/com_comprometimento/com_comprometimentoConsult.jsp?clearop=true">

		<display:column sortable="false" title="Com_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/com_comprometimento/com_comprometimentoUpdateDelete.jsp&op=findbyid&com_comprometimentoT.com_nr_id=${item.com_nr_id}&">
      		<c:out value="${item.com_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plc_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/com_comprometimento/com_comprometimentoUpdateDelete.jsp&op=findbyid&com_comprometimentoT.com_nr_id=${item.com_nr_id}&">
      		<c:out value="${item.plc_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Com_nr_valor" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/com_comprometimento/com_comprometimentoUpdateDelete.jsp&op=findbyid&com_comprometimentoT.com_nr_id=${item.com_nr_id}&">
      		<c:out value="${item.com_nr_valor}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Obr_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/com_comprometimento/com_comprometimentoUpdateDelete.jsp&op=findbyid&com_comprometimentoT.com_nr_id=${item.com_nr_id}&">
      		<c:out value="${item.obr_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Com_nr_mes" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/com_comprometimento/com_comprometimentoUpdateDelete.jsp&op=findbyid&com_comprometimentoT.com_nr_id=${item.com_nr_id}&">
      		<c:out value="${item.com_nr_mes}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Com_nr_ano" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/com_comprometimento/com_comprometimentoUpdateDelete.jsp&op=findbyid&com_comprometimentoT.com_nr_id=${item.com_nr_id}&">
      		<c:out value="${item.com_nr_ano}"/>
            </a>
	</display:column>
      
       <display:column title="Apagar">

<!--portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=-->
		<a onclick="setOpPortal('com_comprometimento','delete', '/easyEngenharia/easyconstru/com_comprometimento/com_comprometimentoConsult.jsp?com_comprometimentoT.com_nr_id=${item.com_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.png">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
