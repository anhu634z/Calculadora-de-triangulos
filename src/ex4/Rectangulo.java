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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author mati
 */
public class Rectangulo extends Operador{
    
    TextField[] textos=new TextField[2];
    JButton boton=new JButton("Calcular");
    JComboBox selector=new JComboBox();
    
    public Rectangulo(){
        super("Rectángulo");
        
        setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
        
        JPanel panel=new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(new JLabel("Introduzca tipo de lado a introducir:"));
        
        selector.addItem("Hipotenusa");
        selector.addItem("2º Cateto");
        panel.add(selector);
        add(panel);
        
        for(int x=0;x<2;x++){
            panel=new JPanel();
            panel.setLayout(new FlowLayout());
            
            TextField tf=new TextField();
            textos[x]=tf;
            tf.setColumns(10);
            panel.add(new JLabel("Introduce la longitud "+(x==0?"tipo de lado seleccionado":"primer cateto")+":"));
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
        float total=0;
        try{
            setVisible(false);
            float[] valores=new float[3];
            for(int x=0;x<2;x++){
                float lado=Float.valueOf(textos[x].getText());
                if(lado<=0)throw new Exception();
                textos[x].setText("");
                valores[x]=lado;
            }valores[2]=(float)Math.sqrt(Math.pow(valores[0],2)+(Math.pow(valores[1],2)*(selector.getSelectedIndex()==0?1:-1)));
            float resultado=0;
            for(int x=0;x<3;x++)resultado+=valores[x];
            JOptionPane.showMessageDialog(Principal.instancia,"El perímetro del triángulo es de "+Principal.DF.format(resultado)+" "+(resultado==1?"unidad":"unidades")+".","Resultado",JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception Ex){
            JOptionPane.showMessageDialog(Principal.instancia,"Un valor introducido no es un número válido.","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @Override
    public String toString(){
        return"Rectángulo";
    }
    
}
