package com.anuarOrozco.conversorDivisas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.NumberFormat;
import java.util.HashMap;

public class Ventana extends JFrame {

    // Variables para la interfaz gráfica
    private JTextField campoMonto;
    private JComboBox<String> divisaDesde;
    private JComboBox<String> divisaHasta;
    private JButton convertirButton;
    private JLabel resultadoLabel;

    // HashMap para almacenar las tasas de cambio
    private HashMap<String, Double> tasasDeCambio;

    public Ventana() {
        initComponents();
        inicializarTasasDeCambio();

        this.setSize(400, 250);
        setTitle("Conversor de Divisas");
        setLocationRelativeTo(null);
        setResizable(false);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }

    private void initComponents() {
        // Componentes de la interfaz gráfica
        campoMonto = new JTextField(10);
        divisaDesde = new JComboBox<>(new String[]{"MXN", "USD", "EUR", "GBP", "JPY", "KRW"});
        divisaHasta = new JComboBox<>(new String[]{"MXN", "USD", "EUR", "GBP", "JPY", "KRW"});
        convertirButton = new JButton("Convertir");
        resultadoLabel = new JLabel("Resultado:");

        // Establecer la fuente Segoe UI y tamaño en todos los componentes
        Font font = new Font("Segoe UI", Font.PLAIN, 14);
        campoMonto.setFont(font);
        divisaDesde.setFont(font);
        divisaHasta.setFont(font);
        convertirButton.setFont(font);
        resultadoLabel.setFont(font);

        // Diseño de la ventana con un GridLayout y espaciado vacío en el BorderLayout
        setLayout(new BorderLayout());
        JPanel panelCentral = new JPanel(new GridLayout(3, 2, 10, 20));
        panelCentral.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelCentral.add(new JLabel("Monto:"));
        panelCentral.add(campoMonto);
        panelCentral.add(new JLabel("De:"));
        panelCentral.add(divisaDesde);
        panelCentral.add(new JLabel("A:"));
        panelCentral.add(divisaHasta);

        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelInferior.add(convertirButton);

        JPanel panelResultado = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelResultado.add(resultadoLabel);

        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.add(panelCentral, BorderLayout.CENTER);
        panelPrincipal.add(panelInferior, BorderLayout.SOUTH);
        panelPrincipal.add(panelResultado, BorderLayout.NORTH);

        add(panelPrincipal, BorderLayout.CENTER);

        // Agregar ActionListener al botón "Convertir"
        convertirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertirDivisa();
            }
        });
    }

    private void inicializarTasasDeCambio() {
        // Tasas de cambio 
        tasasDeCambio = new HashMap<>();
        tasasDeCambio.put("MXN->USD", 0.059); // Peso Mexicano a Dólar
        tasasDeCambio.put("USD->MXN", 16.95); // Dólar a Peso Mexicano
        tasasDeCambio.put("MXN->EUR", 0.053); // Peso Mexicano a Euro
        tasasDeCambio.put("EUR->MXN", 18.72); // Euro a Peso Mexicano
        tasasDeCambio.put("MXN->GBP", 0.046); // Peso Mexicano a Libra Esterlina
        tasasDeCambio.put("GBP->MXN", 21.84); // Libra Esterlina a Peso Mexicano
        tasasDeCambio.put("MXN->JPY", 8.32); // Peso Mexicano a Yen Japonés
        tasasDeCambio.put("JPY->MXN", 0.12); // Yen Japonés a Peso Mexicano
        tasasDeCambio.put("MXN->KRW", 75.52); // Peso Mexicano a Won Coreano
        tasasDeCambio.put("KRW->MXN", 0.013); // Won Coreano a Peso Mexicano

    }

    private void convertirDivisa() {
        String divisaOrigen = divisaDesde.getSelectedItem().toString();
        String divisaDestino = divisaHasta.getSelectedItem().toString();
        double monto = Double.parseDouble(campoMonto.getText());

        // Llamamos a la función de conversión y obtenemos el resultado
        double resultado = convertir(monto, divisaOrigen, divisaDestino);
        
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        String tipoMonedaOrigen = obtenerTipoMoneda(divisaOrigen);
        String tipoMonedaDestino = obtenerTipoMoneda(divisaDestino);
        resultadoLabel.setText("Resultado: " + numberFormat.format(resultado) + " " + tipoMonedaDestino);
    }
    
    private String obtenerTipoMoneda(String divisa) {
        HashMap<String, String> simbolosMoneda = new HashMap<>();
        simbolosMoneda.put("MXN", "MXN$"); // Peso Mexicano
        simbolosMoneda.put("USD", "USD$"); // Dólar Estadounidense
        simbolosMoneda.put("EUR", "€"); // Euro
        simbolosMoneda.put("GBP", "£"); // Libra Esterlina
        simbolosMoneda.put("JPY", "¥"); // Yen Japonés
        simbolosMoneda.put("KRW", "₩"); // Won Coreano

        return simbolosMoneda.get(divisa);
    }

    private double convertir(double monto, String divisaOrigen, String divisaDestino) {
        // Implementación de la lógica de conversión similar a la versión anterior
        String claveTasas = divisaOrigen + "->" + divisaDestino;
        double tasaCambio = tasasDeCambio.get(claveTasas);
        double resultado = monto * tasaCambio;
        return resultado;
    }

}
