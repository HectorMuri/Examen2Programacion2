/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.examen2;

    
/**
 *
 * @author m_mur
 */
public class main {
    static conexionDB connM;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        connM = new conexionDB();
        connM.setDB();

        Maquinarias formMaquinarias = new Maquinarias();
        formMaquinarias.setVisible(true);

    }
    
}
