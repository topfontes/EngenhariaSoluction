<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="car_carroJB" class="br.com.easynet.gwt.easyportal.jb.Car_carroInsertJB" scope="request"/>                                         
<jsp:setProperty name="car_carroJB" property="*"/>                                         
<jsp:setProperty name="car_carroJB" property="page" value="${pageContext}"/>                                         
${car_carroJB.execute}                                         
                                                                               
	
<form name="car_carro" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/car_carro/car_carroInsert.jsp"/>
    <center>     
     	<label class="msg">${car_carroJB.msg}</label><br/>
	<table width="50%" border="0">
	         <tr>
	<td>
		<label>car_tx_nome:</label>
	</td>
	<td>
		<input type="text" name="car_carroT.car_tx_nome" value="${car_carroJB.car_carroT.car_tx_nome}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>car_tx_marca:</label>
	</td>
	<td>
		<input type="text" name="car_carroT.car_tx_marca" value="${car_carroJB.car_carroT.car_tx_marca}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>

		<tr>
			<td colspan="2" align="center">
    			    <input type="button" value="Insert"  onClick="setOpPortal('car_carro','insert', '/easyEngenharia/easyconstru/car_carro/car_carroInsert.jsp')" /> &nbsp;&nbsp;
    			    <input type="reset"  value="Clear" onclick="setOpPortal('car_carro','clear', '/easyEngenharia/easyconstru/car_carro/car_carroInsert.jsp')"/>&nbsp;&nbsp;
    			    <input type="button" value="Voltar"  onClick="setOpPortal('car_carro','', '/easyEngenharia/easyconstru/car_carro/car_carroConsult.jsp')" />
			</td>
		</tr>
    	</table>
    </center>     
	
    
</form>
  
