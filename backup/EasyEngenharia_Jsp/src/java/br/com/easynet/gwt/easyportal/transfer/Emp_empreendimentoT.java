package br.com.easynet.gwt.easyportal.transfer;

import br.com.easynet.annotation.Conversion;

public class Emp_empreendimentoT {

	 private int emp_nr_id;
	 private String emp_tx_nome;
	 private String emp_tx_bairro;
	 private String emp_tx_cidade;
	 private String emp_tx_uf;
	 private int cli_nr_id;
         private String emp_tx_endereco;
         private byte[] emp_bt_logo;

	 public void setEmp_nr_id(int emp_nr_id) {
		 this.emp_nr_id=emp_nr_id;
	}
 
	 public int getEmp_nr_id() {
		 return emp_nr_id;
 	} 
 	 public void setEmp_tx_nome(String emp_tx_nome) {
		 this.emp_tx_nome=emp_tx_nome;
	}
 
	 public String getEmp_tx_nome() {
		 return emp_tx_nome;
 	} 
 	 public void setEmp_tx_bairro(String emp_tx_bairro) {
		 this.emp_tx_bairro=emp_tx_bairro;
	}
 
	 public String getEmp_tx_bairro() {
		 return emp_tx_bairro;
 	} 
 	 public void setEmp_tx_cidade(String emp_tx_cidade) {
		 this.emp_tx_cidade=emp_tx_cidade;
	}
 
	 public String getEmp_tx_cidade() {
		 return emp_tx_cidade;
 	} 
 	 public void setEmp_tx_uf(String emp_tx_uf) {
		 this.emp_tx_uf=emp_tx_uf;
	}
 
	 public String getEmp_tx_uf() {
		 return emp_tx_uf;
 	} 
 	 public void setCli_nr_id(int cli_nr_id) {
		 this.cli_nr_id=cli_nr_id;
	}
 
	 public int getCli_nr_id() {
		 return cli_nr_id;
 	}

    /**
     * @return the emp_tx_endereco
     */
    public String getEmp_tx_endereco() {
        return emp_tx_endereco;
    }

    /**
     * @param emp_tx_endereco the emp_tx_endereco to set
     */
    public void setEmp_tx_endereco(String emp_tx_endereco) {
        this.emp_tx_endereco = emp_tx_endereco;
    }

    /**
     * @return the emp_bt_logo
     */
    public byte[] getEmp_bt_logo() {
        return emp_bt_logo;
    }

    /**
     * @param emp_bt_logo the emp_bt_logo to set
     */
    public void setEmp_bt_logo(byte[] emp_bt_logo) {
        this.emp_bt_logo = emp_bt_logo;
    }
 }