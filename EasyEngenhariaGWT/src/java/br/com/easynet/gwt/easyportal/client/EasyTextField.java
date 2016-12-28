/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client;

import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.KeyEvent;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.form.TextField;

/**
 *
 * @author geoleite
 */
public class EasyTextField extends TextField<String> {

    public final static String CPF_MASK = "999.999.999-99";
    public final static String CNPJ_MASK = "99.999.999/9999-99";
    public final static String FONE_MASK = "9999-9999";
    public final static String FONE_DDD_MASK = "(99)9999-9999";
    public final static String PACA_CAR_MASK = "LLL-9999";
    public final static String DATE_MASK = "99/99/9999";
    private String mask = "";

    public EasyTextField(String mask) {
        setMask(mask);
        setMaxLength(mask.length());
        final EasyTextField etf = this;
        String prepareMasc = mask.replaceAll("9", "_");
        prepareMasc = prepareMasc.replaceAll("L", "_");
        setValue(prepareMasc);

        KeyListener keyListener = new KeyListener() {

            public void componentKeyPress(ComponentEvent event) {
                //componentKeyPress(event);
                executeMask(event);
            }

            public void componentKeyUp(ComponentEvent event) {
                finalizeMask(event);
            }

            private int menorValor(int v1, int v2) {
                if (v1 < v2) {
                    return v1;
                } else {
                    return v2;
                }

            }

            private boolean valideLetra(int code) {
                return (code >= 65 && code <= 90);
            }

            private boolean valideNumber(int code) {
                return (code >= 48 && code <= 57);
            }

            /**
             * 9- Numero
             * L- Letra
             * S- Simbolo
             */
            private String getType(int position) {
                String letra = etf.mask.substring(position, position);
                return letra;
            }
        };

        this.addKeyListener(keyListener);
    }

    private void finalizeMask(ComponentEvent event) {
        int code = event.getKeyCode();
        if ( code != 46 && code != 8 && code != 37 && code != 38 && code != 39 && code != 40) {
            setValue(getValue().substring(0, mask.length()));
        }

    }

    private void executeMask(ComponentEvent event) {
        String str = getValue();
        char[] strChar = str.toCharArray();
        String strNew = "";
        int code = event.getKeyCode();
//        Info.display("", "" + code);
        String simb = "" + (char) code;
        boolean alterado = false;
        if (code == 8) {
            int pos = -1;
            for (int i = strChar.length - 1; i >= 0; i--) {
                char tipo = strChar[i];
                if ('_' != tipo && (tipo != mask.charAt(i) || tipo == 'L' || tipo == '9')) {
                    strNew = str.substring(0, i) + "_" + strNew;
                    //strNew += "_";
                    //strNew += str.substring(i+1, masc.length());

                    break;
                } else {
                    strNew = tipo + strNew;
                }
            }
            strNew += "_";
            alterado = true;

        } else if (code != 46 && code != 37 && code != 38 && code != 39 && code != 40) { // verificando se foi clicado nas setas do teclado
            for (int i = 0; i < mask.length(); i++) {
                if (i < strChar.length) {
                    char tipo = strChar[i];
                    if ('_' == tipo && simb != null) {
                        char tipoCaracter = mask.charAt(i);
                        char s = simb.charAt(0);
                        if ('9' == tipoCaracter) {

                            if (s == '0' || s == '1' ||
                                    s == '2' || s == '3' || s == '4' ||
                                    s == '5' || s == '6' || s == '7' ||
                                    s == '8' || s == '9') {
                                strNew += simb;
                            } else {
                                strNew += "_";
                            }
                        } else if ('L' == tipoCaracter) {
                            int c = (int) s;
                            if (c >= 65 && c <= 122) {
                                strNew += simb;
                            } else {
                                strNew += "_";
                            }

                        } else {
                            strNew += simb;
                        }
                        simb = null;

//                        strNew += simb;
//                        simb = null;
                    } else {
                        strNew += tipo;
                    }
                }
            }
            alterado = true;
        }

        //System.out.println(code + " " + evt.getKeyChar());

        if (alterado) {
            setValue(strNew);
        }
    }

    /**
     * @return the mask
     */
    public String getMask() {
        return mask;
    }

    /**
     * @param mask the mask to set
     */
    public void setMask(String mask) {
        this.mask = mask;
    }
}
