<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="fto_fotosJB" class="br.com.easynet.gwt.easyportal.jb.Fto_fotosInsertJB" scope="request"/>                                         
<jsp:setProperty name="fto_fotosJB" property="*"/>                                         
<jsp:setProperty name="fto_fotosJB" property="page" value="${pageContext}"/>                                         
${fto_fotosJB.execute}                                         
                                                                               
	
<form name="fto_fotos" action="portal.jsp" method="post" enctype="multipart/form-data" > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/fto_fotos/fto_fotosInsert.jsp"/>
    <center>     
     	<label class="msg">${fto_fotosJB.msg}</label><br/>
	<table width="50%" border="0">
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
    			    <input type="button" value="Insert"  onClick="setOpPortal('fto_fotos','insert', '/easyEngenharia/easyconstru/fto_fotos/fto_fotosInsert.jsp')" /> &nbsp;&nbsp;
    			    <input type="reset"  value="Clear" onclick="setOpPortal('fto_fotos','clear', '/easyEngenharia/easyconstru/fto_fotos/fto_fotosInsert.jsp')"/>&nbsp;&nbsp;
    			    <input type="button" value="Voltar"  onClick="setOpPortal('fto_fotos','', '/easyEngenharia/easyconstru/fto_fotos/fto_fotosConsult.jsp')" />
			</td>
		</tr>
    	</table>
    </center>     
	
    
</form>
  
