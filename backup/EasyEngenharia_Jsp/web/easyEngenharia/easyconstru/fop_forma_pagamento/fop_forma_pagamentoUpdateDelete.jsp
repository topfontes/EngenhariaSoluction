<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="fop_forma_pagamentoJB" class="br.com.easynet.gwt.easyportal.jb.Fop_forma_pagamentoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="fop_forma_pagamentoJB" property="*"/>                                         
<jsp:setProperty name="fop_forma_pagamentoJB" property="page" value="${pageContext}"/>                                         
${fop_forma_pagamentoJB.execute}                                         
                                                                                

<form name="fop_forma_pagamento" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/fop_forma_pagamento/fop_forma_pagamentoUpdateDelete.jsp"/>
    <center>     
     	<label class="msg">${fop_forma_pagamentoJB.msg}</label><br/>

    <table align="center" border="0" width="50%">
    		     <tr>
	<td>
		<label>fop_nr_id:</label>
	</td>
	<td>
		<input type="text" name="fop_forma_pagamentoT.fop_nr_id" value="${fop_forma_pagamentoJB.fop_forma_pagamentoT.fop_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>fop_tx_nome:</label>
	</td>
	<td>
		<input type="text" name="fop_forma_pagamentoT.fop_tx_nome" value="${fop_forma_pagamentoJB.fop_forma_pagamentoT.fop_tx_nome}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>fop_tx_avista:</label>
	</td>
	<td>
		<input type="text" name="fop_forma_pagamentoT.fop_tx_avista" value="${fop_forma_pagamentoJB.fop_forma_pagamentoT.fop_tx_avista}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>

	  <tr>
     	    <td colspan="2" align="center">
		<input type="button" value="Consult" onClick="setOpPortal('fop_forma_pagamento', 'consult', '/easyEngenharia/easyconstru/fop_forma_pagamento/fop_forma_pagamentoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Update"  onClick="setOpPortal('fop_forma_pagamento', 'update' , '/easyEngenharia/easyconstru/fop_forma_pagamento/fop_forma_pagamentoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Delete"  onClick="setOpPortal('fop_forma_pagamento', 'delete' , '/easyEngenharia/easyconstru/fop_forma_pagamento/fop_forma_pagamentoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Cancel"  onClick="setOpPortal('fop_forma_pagamento', 'consult' , '/easyEngenharia/easyconstru/fop_forma_pagamento/fop_forma_pagamentoConsult.jsp')" />
    	    </td>
	  </tr>
	</table>
    
	<br/>
    
    </center>     
	
</form>
