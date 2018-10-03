<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="eqc_equivalencia_composicaoJB" class="br.com.easynet.gwt.easyportal.jb.Eqc_equivalencia_composicaoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="eqc_equivalencia_composicaoJB" property="*"/>                                         
<jsp:setProperty name="eqc_equivalencia_composicaoJB" property="page" value="${pageContext}"/>                                         
${eqc_equivalencia_composicaoJB.execute}                                         
{"resultado":
{"msg":"${eqc_equivalencia_composicaoJB.msg}",
     "eqc_equivalencia_composicao":{	"coa_nr_id":"${eqc_equivalencia_composicaoJB.eqc_equivalencia_composicaoT.coa_nr_id}"
 ,	"con_nr_id":"${eqc_equivalencia_composicaoJB.eqc_equivalencia_composicaoT.con_nr_id}"
  }
    }
     
}                                                                                
   
