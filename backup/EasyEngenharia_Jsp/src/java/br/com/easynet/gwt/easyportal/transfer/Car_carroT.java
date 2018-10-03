package br.com.easynet.gwt.easyportal.transfer;

import br.com.easynet.annotation.Conversion;

public class Car_carroT { 
	 private int car_nr_id;
	 private String car_tx_nome;
	 private String car_tx_marca;
	 public void setCar_nr_id(int car_nr_id) {
		 this.car_nr_id=car_nr_id;
	}
 
	 public int getCar_nr_id() {
		 return car_nr_id;
 	} 
 	 public void setCar_tx_nome(String car_tx_nome) {
		 this.car_tx_nome=car_tx_nome;
	}
 
	 public String getCar_tx_nome() {
		 return car_tx_nome;
 	} 
 	 public void setCar_tx_marca(String car_tx_marca) {
		 this.car_tx_marca=car_tx_marca;
	}
 
	 public String getCar_tx_marca() {
		 return car_tx_marca;
 	} 
 }