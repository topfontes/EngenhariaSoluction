<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="fto_fotosJB" class="br.com.easynet.gwt.easyportal.jb.Fto_fotosUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="fto_fotosJB" property="*"/>                                         
<jsp:setProperty name="fto_fotosJB" property="page" value="${pageContext}"/>                                         
${fto_fotosJB.execute}                                         
                                                                                

<form name="fto_fotos" action="portal.jsp" method="post" enctype="multipart/form-data" >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/fto_fotos/fto_fotosUpdateDelete.jsp"/>
    <center>     
     	<label class="msg">${fto_fotosJB.msg}</label><br/>

    <table align="center" border="0" width="50%">
    		     <tr>
	<td>
		<label>fto_nr_id:</label>
	</td>
	<td>
		<input type="text" name="fto_fotosT.fto_nr_id" value="${fto_fotosJB.fto_fotosT.fto_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>obr_nr_id:</label>
	</td>
	<td>
		<input type="text" name="fto_fotosT.obr_nr_id" value="${fto_fotosJB.fto_fotosT.obr_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>fto_nr_mes:</label>
	</td>
	<td>
		<input type="text" name="fto_fotosT.fto_nr_mes" value="${fto_fotosJB.fto_fotosT.fto_nr_mes}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>fto_nr_ano:</label>
	</td>
	<td>
		<input type="text" name="fto_fotosT.fto_nr_ano" value="${fto_fotosJB.fto_fotosT.fto_nr_ano}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>fto_bt_foto:</label>
	</td>
	<td>
		<input type="file" name="fto_fotosT.fto_bt_foto" value="" onKeyPress="nextField(this, event)"/> <img border="0" src="fto_fotosUpdateDelete.jsp?op=downloadImage&fto_fotosT.fto_nr_id=${fto_fotosJB.fto_fotosT.fto_nr_id}&"/>
	</td>
     </tr>

	  <tr>
     	    <td colspan="2" align="center">
		<input type="button" value="Consult" onClick="setOpPortal('fto_fotos', 'consult', '/easyEngenharia/easyconstru/fto_fotos/fto_fotosConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Update"  onClick="setOpPortal('fto_fotos', 'update' , '/easyEngenharia/easyconstru/fto_fotos/fto_fotosUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Delete"  onClick="setOpPortal('fto_fotos', 'delete' , '/easyEngenharia/easyconstru/fto_fotos/fto_fotosUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Cancel"  onClick="setOpPortal('fto_fotos', 'consult' , '/easyEngenharia/easyconstru/fto_fotos/fto_fotosConsult.jsp')" />
    	    </td>
	  </tr>
	</table>
    
	<br/>
    
    </center>     
	
</form>
