<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="obr_obrasJB" class="br.com.easynet.gwt.easyportal.jb.Obr_obrasConsultJB" scope="request"/>                                         
<jsp:setProperty name="obr_obrasJB" property="*"/>                                         
<jsp:setProperty name="obr_obrasJB" property="page" value="${pageContext}"/>                                         
${obr_obrasJB.execute}                                         
                                                                                

<form name="obr_obras" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/obr_obras/obr_obrasConsult.jsp"/>
    <center>     
	<label class="msg" align="center">${obr_obrasJB.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOpPortal('obr_obras','', '/easyEngenharia/easyconstru/obr_obras/obr_obrasInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOpPortal('obr_obras','consult', '/easyEngenharia/easyconstru/obr_obras/obr_obrasConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
	
	<hr/> 
    <h2 align="center">List</h2>
    <center>
	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${obr_obrasJB.list}"  pagesize="10" requestURI="/easyEngenharia/obr_obras/obr_obrasConsult.jsp?clearop=true">

		<display:column sortable="false" title="Obr_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/obr_obras/obr_obrasUpdateDelete.jsp&op=findbyid&obr_obrasT.obr_nr_id=${item.obr_nr_id}&">
      		<c:out value="${item.obr_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Obr_tx_nome" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/obr_obras/obr_obrasUpdateDelete.jsp&op=findbyid&obr_obrasT.obr_nr_id=${item.obr_nr_id}&">
      		<c:out value="${item.obr_tx_nome}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Obr_tx_endereco" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/obr_obras/obr_obrasUpdateDelete.jsp&op=findbyid&obr_obrasT.obr_nr_id=${item.obr_nr_id}&">
      		<c:out value="${item.obr_tx_endereco}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Obr_tx_bairro" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/obr_obras/obr_obrasUpdateDelete.jsp&op=findbyid&obr_obrasT.obr_nr_id=${item.obr_nr_id}&">
      		<c:out value="${item.obr_tx_bairro}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Obr_tx_cidade" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/obr_obras/obr_obrasUpdateDelete.jsp&op=findbyid&obr_obrasT.obr_nr_id=${item.obr_nr_id}&">
      		<c:out value="${item.obr_tx_cidade}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Obr_tx_uf" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/obr_obras/obr_obrasUpdateDelete.jsp&op=findbyid&obr_obrasT.obr_nr_id=${item.obr_nr_id}&">
      		<c:out value="${item.obr_tx_uf}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Emp_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/obr_obras/obr_obrasUpdateDelete.jsp&op=findbyid&obr_obrasT.obr_nr_id=${item.obr_nr_id}&">
      		<c:out value="${item.emp_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Obr_nr_area_construida_total" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/obr_obras/obr_obrasUpdateDelete.jsp&op=findbyid&obr_obrasT.obr_nr_id=${item.obr_nr_id}&">
      		<c:out value="${item.obr_nr_area_construida_total}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Obr_dt_inicio" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/obr_obras/obr_obrasUpdateDelete.jsp&op=findbyid&obr_obrasT.obr_nr_id=${item.obr_nr_id}&">
      		<fmt:formatDate value="${item.obr_dt_inicio}" pattern="dd/MM/yyyy"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Obr_dt_fim" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/obr_obras/obr_obrasUpdateDelete.jsp&op=findbyid&obr_obrasT.obr_nr_id=${item.obr_nr_id}&">
      		<fmt:formatDate value="${item.obr_dt_fim}" pattern="dd/MM/yyyy"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Obr_dt_inicio_controle" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/obr_obras/obr_obrasUpdateDelete.jsp&op=findbyid&obr_obrasT.obr_nr_id=${item.obr_nr_id}&">
      		<fmt:formatDate value="${item.obr_dt_inicio_controle}" pattern="dd/MM/yyyy"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Obr_dt_termino_controle" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/obr_obras/obr_obrasUpdateDelete.jsp&op=findbyid&obr_obrasT.obr_nr_id=${item.obr_nr_id}&">
      		<fmt:formatDate value="${item.obr_dt_termino_controle}" pattern="dd/MM/yyyy"/>
            </a>
	</display:column>
      
       <display:column title="Apagar">

<!--portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=-->
		<a onclick="setOpPortal('obr_obras','delete', '/easyEngenharia/easyconstru/obr_obras/obr_obrasConsult.jsp?obr_obrasT.obr_nr_id=${item.obr_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.png">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
