<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="con_contatosJB" class="br.com.easynet.gwt.easyportal.jb.Con_contatosUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="con_contatosJB" property="*"/>                                         
<jsp:setProperty name="con_contatosJB" property="page" value="${pageContext}"/>                                         
${con_contatosJB.execute}                                         
{"resultado":
{"msg":"${con_contatosJB.msg}",
     "con_contatos":{	"con_nr_id":"${con_contatosJB.con_contatosT.con_nr_id}"
 ,	"cli_nr_id":"${con_contatosJB.con_contatosT.cli_nr_id}"
 ,	"con_tx_nome":"${con_contatosJB.con_contatosT.con_tx_nome}"
 ,	"set_nr_id":"${con_contatosJB.con_contatosT.set_nr_id}"
 ,	"con_tx_cargo_exercicio":"${con_contatosJB.con_contatosT.con_tx_cargo_exercicio}"
 ,	"con_tx_telefone":"${con_contatosJB.con_contatosT.con_tx_telefone}"
 ,	"con_tx_telefone2":"${con_contatosJB.con_contatosT.con_tx_telefone2}"
 ,	"con_tx_email":"${con_contatosJB.con_contatosT.con_tx_email}"
  }
    }
     
}                                                                                
   
