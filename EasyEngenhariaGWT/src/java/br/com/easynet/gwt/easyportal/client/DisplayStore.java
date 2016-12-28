/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client;

import java.util.TreeMap;

/**
 *
 * @author geoleite
 */
public class DisplayStore {
    private static TreeMap<String, Class> defClass = new TreeMap<String, Class>();
    /**
     * Obtem a classe
     * @param classId
     * @return
     */
    public static Class get(String classId) {
        return defClass.get(classId);
    }

    /**
     * Insere uma nova classe no store
     * @param classId
     * @param clas
     */
    public static void put(String classId, Class clas) {
        defClass.put(classId, clas);
    }
}
