/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.util;

/**
 *
 * @author marcos
 */
public class MatematicaFinanceira {

    public MatematicaFinanceira() {
    }

        public static double getTIR(double[] vet) {
        double inicio = 0.0001;
        double resultado = 0;
        int cont = 0;
        int tt = 0;
        boolean op_sinal = true;
        boolean opVpl;
        while (inicio <= 100) {
            double vlVPL = getVPL(inicio, vet);
            if (inicio == 0.0001) {
                op_sinal = vlVPL < 0;
            } else {
                opVpl = vlVPL < 0;
                if (op_sinal != opVpl) {
                    op_sinal = opVpl;
                    resultado = inicio;
                    cont++;
                }
            }
            inicio += 0.0001;
            tt++;
        }
        if (cont != 1) {
            resultado = 0;
        }
        return resultado;
    }

    public static double getVPL(double fator, double[] array) {
        double valor = 0;
        double newFator = fator / 100;
        newFator += 1;
        for (int i = 0; i < array.length; i++) {
            double elev = valorElevado(newFator, i + 1);
            double vlr = array[i];
            valor += vlr / elev;
        }
        return valor;
    }

    public static double valorElevado(double valor, int elevacao) {
        double vl = valor;
        for (double i = 1; i < elevacao; i++) {
            double e = i;
            vl = vl * valor;
        }
        return vl;
    }

}
