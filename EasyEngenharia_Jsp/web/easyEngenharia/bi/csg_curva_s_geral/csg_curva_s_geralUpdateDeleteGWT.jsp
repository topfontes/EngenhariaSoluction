<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="csg_curva_s_geralJB" class="br.com.easynet.gwt.easyportal.jb.Csg_curva_s_geralUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="csg_curva_s_geralJB" property="*"/>                                         
<jsp:setProperty name="csg_curva_s_geralJB" property="page" value="${pageContext}"/>                                         
${csg_curva_s_geralJB.execute}                                         
{"resultado":
{"msg":"${csg_curva_s_geralJB.msg}",
     "csg_curva_s_geral":{	"csg_nr_id":"${csg_curva_s_geralJB.csg_curva_s_geralT.csg_nr_id}"
 ,	"obr_nr_id":"${csg_curva_s_geralJB.csg_curva_s_geralT.obr_nr_id}"
 ,	"csg_nr_mes":"${csg_curva_s_geralJB.csg_curva_s_geralT.csg_nr_mes}"
 ,	"csg_nr_ano":"${csg_curva_s_geralJB.csg_curva_s_geralT.csg_nr_ano}"
,	"csg_nr_mes_plan":"<fmt:formatDate value="${item.csg_nr_mes_plan}" pattern="dd/MM/yyyy"/>"
 ,	"csg_nr_acumulado_plan_po":"${csg_curva_s_geralJB.csg_curva_s_geralT.csg_nr_acumulado_plan_po}"
 ,	"csg_nr_fisico_acumulado_panejado_base":"${csg_curva_s_geralJB.csg_curva_s_geralT.csg_nr_fisico_acumulado_panejado_base}"
 ,	"csg_nr_fisico_acumulado_trab_atual":"${csg_curva_s_geralJB.csg_curva_s_geralT.csg_nr_fisico_acumulado_trab_atual}"
 ,	"csg_nr_fisico_acumulado_trab_projetado":"${csg_curva_s_geralJB.csg_curva_s_geralT.csg_nr_fisico_acumulado_trab_projetado}"
 ,	"csg_nr_fisico_acumulado_atual_projetado":"${csg_curva_s_geralJB.csg_curva_s_geralT.csg_nr_fisico_acumulado_atual_projetado}"
  }
    }
     
}                                                                                
   
