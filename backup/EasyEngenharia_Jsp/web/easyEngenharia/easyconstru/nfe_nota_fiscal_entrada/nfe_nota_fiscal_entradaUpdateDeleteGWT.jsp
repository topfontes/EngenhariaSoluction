<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="nfe_nota_fiscal_entradaJB" class="br.com.easynet.gwt.easyportal.jb.Nfe_nota_fiscal_entradaUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="nfe_nota_fiscal_entradaJB" property="*"/>                                         
<jsp:setProperty name="nfe_nota_fiscal_entradaJB" property="page" value="${pageContext}"/>                                         
${nfe_nota_fiscal_entradaJB.execute}                                         
{"resultado":
{"msg":"${nfe_nota_fiscal_entradaJB.msg}",
     "nfe_nota_fiscal_entrada":{	"nfe_nr_id":"${nfe_nota_fiscal_entradaJB.nfe_nota_fiscal_entradaT.nfe_nr_id}"
 ,	"nfe_dt_emissao":"<fmt:formatDate value="${nfe_nota_fiscal_entradaJB.nfe_nota_fiscal_entradaT.nfe_dt_emissao}" pattern="dd/MM/yyyy"/>"
 ,	"for_nr_id":"${nfe_nota_fiscal_entradaJB.nfe_nota_fiscal_entradaT.for_nr_id}"
 ,	"nfe_nr_valor_nota":"${nfe_nota_fiscal_entradaJB.nfe_nota_fiscal_entradaT.nfe_nr_valor_nota}"
  }
    }
     
}                                                                                
   
