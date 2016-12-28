<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="car_carroJB" class="br.com.easynet.gwt.easyportal.jb.Car_carroConsultJB" scope="request"/>                                         
<jsp:setProperty name="car_carroJB" property="*"/>                                         
<jsp:setProperty name="car_carroJB" property="page" value="${pageContext}"/>                                         
${car_carroJB.execute}                                         
                                                                                

<form name="car_carro" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/car_carro/car_carroConsult.jsp"/>
    <center>     
	<label class="msg" align="center">${car_carroJB.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOpPortal('car_carro','', '/easyEngenharia/easyconstru/car_carro/car_carroInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOpPortal('car_carro','consult', '/easyEngenharia/easyconstru/car_carro/car_carroConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
	
	<hr/> 
    <h2 align="center">List</h2>
    <center>
	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${car_carroJB.list}"  pagesize="10" requestURI="/easyEngenharia/car_carro/car_carroConsult.jsp?clearop=true">

		<display:column sortable="false" title="Car_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/car_carro/car_carroUpdateDelete.jsp&op=findbyid&car_carroT.car_nr_id=${item.car_nr_id}&">
      		<c:out value="${item.car_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Car_tx_nome" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/car_carro/car_carroUpdateDelete.jsp&op=findbyid&car_carroT.car_nr_id=${item.car_nr_id}&">
      		<c:out value="${item.car_tx_nome}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Car_tx_marca" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/car_carro/car_carroUpdateDelete.jsp&op=findbyid&car_carroT.car_nr_id=${item.car_nr_id}&">
      		<c:out value="${item.car_tx_marca}"/>
            </a>
	</display:column>
      
       <display:column title="Apagar">

<!--portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=-->
		<a onclick="setOpPortal('car_carro','delete', '/easyEngenharia/easyconstru/car_carro/car_carroConsult.jsp?car_carroT.car_nr_id=${item.car_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.png">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
