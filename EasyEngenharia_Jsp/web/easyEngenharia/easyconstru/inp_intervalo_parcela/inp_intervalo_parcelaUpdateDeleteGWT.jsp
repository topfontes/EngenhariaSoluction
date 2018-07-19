<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="inp_intervalo_parcelaJB" class="br.com.easynet.gwt.easyportal.jb.Inp_intervalo_parcelaUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="inp_intervalo_parcelaJB" property="*"/>                                         
<jsp:setProperty name="inp_intervalo_parcelaJB" property="page" value="${pageContext}"/>                                         
${inp_intervalo_parcelaJB.execute}                                         
{"resultado":
    {"msg":"${inp_intervalo_parcelaJB.msg}"
    ,"inp_intervalo_parcela":{"inp_nr_id":"${inp_intervalo_parcelaJB.inp_intervalo_parcelaT.inp_nr_id}"
    ,"par_nr_id":"${inp_intervalo_parcelaJB.inp_intervalo_parcelaT.par_nr_id}"
    ,"inp_nr_dias":"${inp_intervalo_parcelaJB.inp_intervalo_parcelaT.inp_nr_dias}"
    ,"inp_nr_per":"${inp_intervalo_parcelaJB.inp_intervalo_parcelaT.inp_nr_per}"
    }
}

}                                                                                

