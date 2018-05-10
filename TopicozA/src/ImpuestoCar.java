import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class ImpuestoCar extends JFrame{
	private JPanel panelSuperior, panelMedio, panelInferior;
	private JLabel etiqueta1, etiqueta2, etiqueta3, etiqueta4, etiqueta5, etiqueta6, etiquetaMedio, etiquetaInf;
	private JTextField cajaTexto2, cajaTexto3, cajaTexto4, cajaTexto5, cajaTexto6;
	private JButton botonBuscar, botonLimpiar, botonCalcular;
	private JRadioButton bot1, bot2, bot3;
	private JFrame frame;
	
	
	public void superior(){
		panelSuperior = new JPanel();
		etiqueta1 = new JLabel("Datos del Vehiculo");
		etiqueta2 = new JLabel("Marca ");
		cajaTexto2 = new JTextField(10);
		etiqueta3 = new JLabel("Linea   ");
		cajaTexto3 = new JTextField(10);
		etiqueta4 = new JLabel("Modelo");
		cajaTexto4 = new JTextField(10);
		etiqueta5 = new JLabel("Valor   ");
		cajaTexto5 = new JTextField(10);
		botonBuscar = new JButton("Buscar");
		
		panelSuperior.setLayout(new BoxLayout(panelSuperior, BoxLayout.Y_AXIS));
		panelSuperior.add(etiqueta1);
		
		JPanel sup1 = new JPanel();
		sup1.setLayout(new BoxLayout(sup1, BoxLayout.X_AXIS));
		sup1.add(etiqueta2);
		sup1.add(cajaTexto2);
		panelSuperior.add(sup1);
		
		JPanel sup2 = new JPanel();
		sup2.setLayout(new BoxLayout(sup2, BoxLayout.X_AXIS));
		sup2.add(etiqueta3);
		sup2.add(cajaTexto3);
		panelSuperior.add(sup2);
		
		JPanel sup3 = new JPanel();
		sup3.setLayout(new BoxLayout(sup3, BoxLayout.X_AXIS));
		sup3.add(etiqueta4);
		sup3.add(cajaTexto4);
		panelSuperior.add(sup3);
		
		JPanel sup4 = new JPanel();
		sup4.setLayout(new BoxLayout(sup4, BoxLayout.X_AXIS));
		sup4.add(etiqueta5);
		sup4.add(cajaTexto5);
		panelSuperior.add(sup4);
		
		panelSuperior.add(botonBuscar);
	}
	
	public void medio(){
		panelMedio = new JPanel();
		etiquetaMedio = new JLabel("Descuentos");
		
		panelMedio.setLayout(new BoxLayout(panelMedio, BoxLayout.Y_AXIS));
		panelMedio.add(etiquetaMedio);
		
		bot1 = new JRadioButton("Pronto pago");
		bot1.setMnemonic(KeyEvent.VK_B);
		panelMedio.add(bot1);
		
		bot2 = new JRadioButton("Servicio publico");
		bot2.setMnemonic(KeyEvent.VK_C);
		panelMedio.add(bot2);
		
		bot3 = new JRadioButton("Traslado de cuenta");
		bot3.setMnemonic(KeyEvent.VK_D);
		panelMedio.add(bot3);
	}
	
	public void inferior(){
		panelInferior = new JPanel();
		etiquetaInf = new JLabel("Resultados");
		panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.Y_AXIS));
		panelInferior.add(etiquetaInf);
		
		etiqueta6 = new JLabel("Total a pagar");
		cajaTexto6 = new JTextField(10);
		
		JPanel Inf1 = new JPanel();
		Inf1.setLayout(new BoxLayout(Inf1, BoxLayout.X_AXIS));
		Inf1.add(etiqueta6);
		Inf1.add(cajaTexto6);
		panelInferior.add(Inf1);
		
		JPanel Inf2 = new JPanel();
		Inf2.setLayout(new BoxLayout(Inf2, BoxLayout.X_AXIS));
		botonLimpiar = new JButton("Limpiar");
		botonCalcular = new JButton("Calcular");
		Inf2.add(botonLimpiar);
		Inf2.add(botonCalcular);
		panelInferior.add(Inf2);
	}
	
	public void construyeVentana(){
		frame = new JFrame();
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS) );
		frame.add(panelSuperior);
		frame.add(panelMedio);
		frame.add(panelInferior);
		frame.pack();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}
	
	public ImpuestoCar(){
		superior();
		medio();
		inferior();
		construyeVentana();
	}

	public static void main(String[] args) {
		new ImpuestoCar();

	}

}
