<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="nfe_nota_fiscal_entradaJB" class="br.com.easynet.gwt.easyportal.jb.Nfe_nota_fiscal_entradaConsultJB" scope="request"/>                                         
<jsp:setProperty name="nfe_nota_fiscal_entradaJB" property="*"/>                                         
<jsp:setProperty name="nfe_nota_fiscal_entradaJB" property="page" value="${pageContext}"/>                                         
${nfe_nota_fiscal_entradaJB.execute}                                         
                                                                                

<form name="nfe_nota_fiscal_entrada" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/nfe_nota_fiscal_entrada/nfe_nota_fiscal_entradaConsult.jsp"/>
    <center>     
	<label class="msg" align="center">${nfe_nota_fiscal_entradaJB.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOpPortal('nfe_nota_fiscal_entrada','', '/easyEngenharia/easyconstru/nfe_nota_fiscal_entrada/nfe_nota_fiscal_entradaInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOpPortal('nfe_nota_fiscal_entrada','consult', '/easyEngenharia/easyconstru/nfe_nota_fiscal_entrada/nfe_nota_fiscal_entradaConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
	
	<hr/> 
    <h2 align="center">List</h2>
    <center>
	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${nfe_nota_fiscal_entradaJB.list}"  pagesize="10" requestURI="/easyEngenharia/nfe_nota_fiscal_entrada/nfe_nota_fiscal_entradaConsult.jsp?clearop=true">

		<display:column sortable="false" title="Nfe_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/nfe_nota_fiscal_entrada/nfe_nota_fiscal_entradaUpdateDelete.jsp&op=findbyid&nfe_nota_fiscal_entradaT.nfe_nr_id=${item.nfe_nr_id}&">
      		<c:out value="${item.nfe_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Nfe_dt_emissao" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/nfe_nota_fiscal_entrada/nfe_nota_fiscal_entradaUpdateDelete.jsp&op=findbyid&nfe_nota_fiscal_entradaT.nfe_nr_id=${item.nfe_nr_id}&">
      		<fmt:formatDate value="${item.nfe_dt_emissao}" pattern="dd/MM/yyyy"/>
            </a>
	</display:column>
	<display:column sortable="false" title="For_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/nfe_nota_fiscal_entrada/nfe_nota_fiscal_entradaUpdateDelete.jsp&op=findbyid&nfe_nota_fiscal_entradaT.nfe_nr_id=${item.nfe_nr_id}&">
      		<c:out value="${item.for_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Nfe_nr_valor_nota" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/nfe_nota_fiscal_entrada/nfe_nota_fiscal_entradaUpdateDelete.jsp&op=findbyid&nfe_nota_fiscal_entradaT.nfe_nr_id=${item.nfe_nr_id}&">
      		<c:out value="${item.nfe_nr_valor_nota}"/>
            </a>
	</display:column>
      
       <display:column title="Apagar">

<!--portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=-->
		<a onclick="setOpPortal('nfe_nota_fiscal_entrada','delete', '/easyEngenharia/easyconstru/nfe_nota_fiscal_entrada/nfe_nota_fiscal_entradaConsult.jsp?nfe_nota_fiscal_entradaT.nfe_nr_id=${item.nfe_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.png">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
