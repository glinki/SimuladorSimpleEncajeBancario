package encaje;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class ventanaEncaje {

	private JFrame frmEjemploDeEncaje;
	private JTextField textFieldDepos;
	private JTextField textFieldEncaje;

	/**
	 * Inicio la aplicación de Ejemplo de Encajes en un sistema Bancario.
	 * @version 1.0
	 * 
	 * @author Ivan_Glinka
	 * @author Tobias_Flores
	 * @author Matias_Mena_Da_Dalt
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaEncaje window = new ventanaEncaje();
					window.frmEjemploDeEncaje.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});		
		
		
	}

	/**
	 * Creo la aplicacion.
	 */
	public ventanaEncaje() {
		initialize();
	}

	/**
	 * Inicializo los contenidos del frame.
	 */
	private void initialize() {
		frmEjemploDeEncaje = new JFrame();
		frmEjemploDeEncaje.setTitle("Ejemplo de Encaje");
		frmEjemploDeEncaje.setBounds(100, 100, 450, 300);
		frmEjemploDeEncaje.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEjemploDeEncaje.getContentPane().setLayout(null); //desactivamos las configuraciones predeterminadas.
		JPanel panel = new JPanel();
		frmEjemploDeEncaje.getContentPane().add(panel, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.setBounds(28, 149, 114, 35);
		frmEjemploDeEncaje.getContentPane().add(btnNewButton);
		
		textFieldDepos = new JTextField();
		textFieldDepos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				char c = e.getKeyChar();
				if (!Character.isDigit(c) && c != '.') {
					 e.consume();
				}
			
			}
		});
		textFieldDepos.setBounds(28, 49, 139, 20);
		frmEjemploDeEncaje.getContentPane().add(textFieldDepos);
		textFieldDepos.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Ingrese el depósito inicial: (MIN:10, MAX:10000000 )");
		lblNewLabel.setBounds(28, 24, 325, 14);
		frmEjemploDeEncaje.getContentPane().add(lblNewLabel);
		
		JLabel lblIngreseElEncaje = new JLabel("Ingrese el encaje inicial: ( Entre 1.0 y 99.0 )");
		lblIngreseElEncaje.setBounds(28, 80, 335, 14);
		frmEjemploDeEncaje.getContentPane().add(lblIngreseElEncaje);
		
		textFieldEncaje = new JTextField();
		textFieldEncaje.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c) && c != '.') {
					 e.consume();
				}
			}
		});
		
		
		textFieldEncaje.setColumns(10);
		textFieldEncaje.setBounds(28, 106, 139, 20);
		frmEjemploDeEncaje.getContentPane().add(textFieldEncaje);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float encaje = Float.parseFloat(textFieldEncaje.getText());
				float depositos = Float.parseFloat(textFieldDepos.getText());
				Banco banco = new Banco(depositos, 0, encaje);
				banco.calcularResultado();
				
			// Creo un JTextArea para poner la tabla de resultados
		        JTextArea textArea = new JTextArea(banco.lista);
				
			// Creao un JScrollPane para poner el textArea
		        JScrollPane scrollPane = new JScrollPane(textArea);
		   
		    // Seteo la barra de desplazamiento vertical
		        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		     // Seteo el tamaño del scrollPane
		        scrollPane.setPreferredSize(new java.awt.Dimension(400, 250)); 
		        
				JOptionPane.showMessageDialog(null, scrollPane, "Ejemplo de encaje con Deposito: "+ depositos +
															  " y encaje: "+ encaje+"%" , JFrame.EXIT_ON_CLOSE);
			
			banco.lista = ""; // Vacio el contenido de lista para un siguiente ejemplo
			
			}
		});
		
	}
}
