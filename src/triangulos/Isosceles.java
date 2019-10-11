/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triangulos;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author mati
 */
public class Isosceles extends Operador{
    
    JTextField texto=new JTextField();
    JButton boton=new JButton("Calcular");
    
    public Isosceles(){
        super("Calculadora del triángulo isósceles");
        setLayout(new FlowLayout());
        
        add(new JLabel("Introduzca la longitud de cualquier lado:"));
        
        texto.setColumns(10);
        add(texto);
        
        boton.addActionListener((e)->calcular());
        add(boton);
        
        pack();
    }
    
    public void operar(){
        setVisible(true);
    }
    
    void calcular(){
        try{
            float resultado=3*Float.valueOf(texto.getText());
            if(resultado<=0)throw new Exception();
            setVisible(false);
            texto.setText("");
            JOptionPane.showMessageDialog(Principal.instancia,"El perímetro del triángulo es de "+Principal.DF.format(resultado)+" "+(resultado==1?"unidad":"unidades")+".","Resultado",JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception Ex){
            JOptionPane.showMessageDialog(Principal.instancia,"El valor introducido no es un número válido.","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @Override
    public String toString(){
        return"Isósceles";
    }
    
}
