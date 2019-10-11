/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex4;

import javax.swing.JFrame;

/**
 *
 * @author mati
 */
public abstract class Operador extends JFrame{
    
    public Operador(){
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }
    public Operador(String titulo){
        super(titulo);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }
    
    public abstract void operar();
    
    @Override
    public abstract String toString();
    
}
