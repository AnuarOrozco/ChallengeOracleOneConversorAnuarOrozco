package com.anuarOrozco.conversorDivisas;

import javax.swing.SwingUtilities;

public class Main {
    
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override   
            public void run() {
                Ventana ventana = new Ventana();
                ventana.setVisible(true);
            }
        });
        
    }
    
}
