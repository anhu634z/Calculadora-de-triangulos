/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triangulos;
import java.awt.FlowLayout;
import java.text.DecimalFormat;
import javax.swing.*;

/**
 *
 * @author mati
 */
public class Principal extends JFrame{
    
    public static Principal instancia;
    public static DecimalFormat DF=new DecimalFormat("#.###");

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception{
        instancia=new Principal();
    }
    
    final JComboBox selector=new JComboBox();
    final JButton boton=new JButton("Calcular");
    
    Principal(){
        super("Calculadora de triángulos");
        setLayout(new FlowLayout());
        
        add(new JLabel("Tipo de triángulo:"));
        
        selector.addItem(new Isosceles());
        selector.addItem(new Rectangulo());
        selector.addItem(new Escaleno());
        add(selector);
        
        boton.addActionListener((e)->((Operador)selector.getSelectedItem()).operar());
        add(boton);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        if(getWidth()<280)this.setSize(280,getHeight());
        setResizable(false);
        this.setLocationRelativeTo(null);
        setVisible(true);
    }
    
}
