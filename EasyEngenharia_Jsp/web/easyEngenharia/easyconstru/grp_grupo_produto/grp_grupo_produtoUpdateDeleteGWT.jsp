<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="grp_grupo_produtoJB" class="br.com.easynet.gwt.easyportal.jb.Grp_grupo_produtoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="grp_grupo_produtoJB" property="*"/>                                         
<jsp:setProperty name="grp_grupo_produtoJB" property="page" value="${pageContext}"/>                                         
${grp_grupo_produtoJB.execute}                                         
{"resultado":
{"msg":"${grp_grupo_produtoJB.msg}",
     "grp_grupo_produto":{	"grp_nr_id":"${grp_grupo_produtoJB.grp_grupo_produtoT.grp_nr_id}"
 ,	"grp_tx_nome":"${grp_grupo_produtoJB.grp_grupo_produtoT.grp_tx_nome}"
  }
    }
     
}                                                                                
   
