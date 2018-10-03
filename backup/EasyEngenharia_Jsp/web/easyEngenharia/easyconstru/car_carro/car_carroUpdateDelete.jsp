<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="car_carroJB" class="br.com.easynet.gwt.easyportal.jb.Car_carroUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="car_carroJB" property="*"/>                                         
<jsp:setProperty name="car_carroJB" property="page" value="${pageContext}"/>                                         
${car_carroJB.execute}                                         
                                                                                

<form name="car_carro" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/car_carro/car_carroUpdateDelete.jsp"/>
    <center>     
     	<label class="msg">${car_carroJB.msg}</label><br/>

    <table align="center" border="0" width="50%">
    		     <tr>
	<td>
		<label>car_nr_id:</label>
	</td>
	<td>
		<input type="text" name="car_carroT.car_nr_id" value="${car_carroJB.car_carroT.car_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
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
		<input type="button" value="Consult" onClick="setOpPortal('car_carro', 'consult', '/easyEngenharia/easyconstru/car_carro/car_carroConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Update"  onClick="setOpPortal('car_carro', 'update' , '/easyEngenharia/easyconstru/car_carro/car_carroUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Delete"  onClick="setOpPortal('car_carro', 'delete' , '/easyEngenharia/easyconstru/car_carro/car_carroUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Cancel"  onClick="setOpPortal('car_carro', 'consult' , '/easyEngenharia/easyconstru/car_carro/car_carroConsult.jsp')" />
    	    </td>
	  </tr>
	</table>
    
	<br/>
    
    </center>     
	
</form>
