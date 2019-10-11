/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex4;

import java.awt.FlowLayout;
import java.awt.TextField;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author mati
 */
public class Escaleno extends Operador{
    
    TextField[] textos=new TextField[3];
    JButton boton=new JButton("Calcular");
    
    public Escaleno(){
        super("Escaleno");
        
        setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
        
        for(int x=0;x<3;x++){
            JPanel panel=new JPanel();
            panel.setLayout(new FlowLayout());
            
            TextField tf=new TextField();
            textos[x]=tf;
            tf.setColumns(10);
            panel.add(new JLabel("Introduce la longitud del lado número "+(x+1)+":"));
            panel.add(tf);
            add(panel);
        }boton.addActionListener((e)->calcular());
        add(boton);
        
        pack();
    }
    
    public void operar(){
        setVisible(true);
    }
    
    void calcular(){
        float resultado=0;
        try{
            setVisible(false);
            for(int x=0;x<3;x++){
                float lado=Float.valueOf(textos[x].getText());
                if(lado<=0)throw new Exception();
                resultado+=lado;
                textos[x].setText("");
            }JOptionPane.showMessageDialog(Principal.instancia,"El perímetro del triángulo es de "+Principal.DF.format(resultado)+" "+(resultado==1?"unidad":"unidades")+".","Resultado",JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception Ex){
            JOptionPane.showMessageDialog(Principal.instancia,"Un valor introducido no es un número válido.","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @Override
    public String toString(){
        return"Escaleno";
    }
    
}
