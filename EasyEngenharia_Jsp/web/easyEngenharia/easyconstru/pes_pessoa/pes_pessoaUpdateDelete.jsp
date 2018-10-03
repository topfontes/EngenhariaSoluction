<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="pes_pessoaJB" class="br.com.easynet.gwt.easyportal.jb.Pes_pessoaUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="pes_pessoaJB" property="*"/>                                         
<jsp:setProperty name="pes_pessoaJB" property="page" value="${pageContext}"/>                                         
${pes_pessoaJB.execute}                                         
                                                                                

<form name="pes_pessoa" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/EasyEngenharia/easyconstru/pes_pessoa/pes_pessoaUpdateDelete.jsp"/>
    <center>     
     	<label class="msg">${pes_pessoaJB.msg}</label><br/>

    <table align="center" border="0" width="50%">
    		     <tr>
	<td>
		<label>pes_nr_id:</label>
	</td>
	<td>
		<input type="text" name="pes_pessoaT.pes_nr_id" value="${pes_pessoaJB.pes_pessoaT.pes_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>pes_tx_nome:</label>
	</td>
	<td>
		<input type="text" name="pes_pessoaT.pes_tx_nome" value="${pes_pessoaJB.pes_pessoaT.pes_tx_nome}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>pes_tx_fone:</label>
	</td>
	<td>
		<input type="text" name="pes_pessoaT.pes_tx_fone" value="${pes_pessoaJB.pes_pessoaT.pes_tx_fone}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>

	  <tr>
     	    <td colspan="2" align="center">
		<input type="button" value="Consult" onClick="setOpPortal('pes_pessoa', 'consult', '/EasyEngenharia/easyconstru/pes_pessoa/pes_pessoaConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Update"  onClick="setOpPortal('pes_pessoa', 'update' , '/EasyEngenharia/easyconstru/pes_pessoa/pes_pessoaUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Delete"  onClick="setOpPortal('pes_pessoa', 'delete' , '/EasyEngenharia/easyconstru/pes_pessoa/pes_pessoaUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Cancel"  onClick="setOpPortal('pes_pessoa', 'consult' , '/EasyEngenharia/easyconstru/pes_pessoa/pes_pessoaConsult.jsp')" />
    	    </td>
	  </tr>
	</table>
    
	<br/>
    
    </center>     
	
</form>
