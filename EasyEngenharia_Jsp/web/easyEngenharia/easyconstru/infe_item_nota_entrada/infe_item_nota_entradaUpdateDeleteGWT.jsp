<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="infe_item_nota_entradaJB" class="br.com.easynet.gwt.easyportal.jb.Infe_item_nota_entradaUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="infe_item_nota_entradaJB" property="*"/>                                         
<jsp:setProperty name="infe_item_nota_entradaJB" property="page" value="${pageContext}"/>                                         
${infe_item_nota_entradaJB.execute}                                         
{"resultado":
{"msg":"${infe_item_nota_entradaJB.msg}",
     "infe_item_nota_entrada":{	"infe_nr_id":"${infe_item_nota_entradaJB.infe_item_nota_entradaT.infe_nr_id}"
 ,	"infe_nr_quantidade":"${infe_item_nota_entradaJB.infe_item_nota_entradaT.infe_nr_quantidade}"
 ,	"infe_nr_valor_unit":"${infe_item_nota_entradaJB.infe_item_nota_entradaT.infe_nr_valor_unit}"
 ,	"infe_nr_valor_total":"${infe_item_nota_entradaJB.infe_item_nota_entradaT.infe_nr_valor_total}"
 ,	"nfe_nr_id":"${infe_item_nota_entradaJB.infe_item_nota_entradaT.nfe_nr_id}"
 ,	"pro_nr_id":"${infe_item_nota_entradaJB.infe_item_nota_entradaT.pro_nr_id}"
  }
    }
     
}                                                                                
   
