package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Prob2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtnumero;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prob2 frame = new Prob2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Prob2() {
		setTitle("Obsequio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblnumero = new JLabel("Numero");
		lblnumero.setHorizontalAlignment(SwingConstants.CENTER);
		lblnumero.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblnumero.setBounds(49, 47, 102, 33);
		contentPane.add(lblnumero);
		
		txtnumero = new JTextField();
		txtnumero.setBounds(161, 50, 102, 33);
		contentPane.add(txtnumero);
		txtnumero.setColumns(10);
		
		JScrollPane spcresultado = new JScrollPane();
		spcresultado.setBounds(31, 97, 474, 160);
		contentPane.add(spcresultado);
		
		JTextArea txtresultado = new JTextArea();
		spcresultado.setViewportView(txtresultado);
		
		JButton btnprocesar = new JButton("Procesar");
		btnprocesar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Declaracion de Variables
				int numero=0;
				String obsequio="Ninguno";
				
				//Entrada de Datos
				numero=Integer.parseInt(txtnumero.getText());
				
				//Determina el Obsequio
				if (numero>=1 && numero <=20)
					obsequio="Un lapicero";
				
				if (numero>=21 && numero <=40)
					obsequio="Un cuaderno de 100 hojas";
				
				if (numero>=41 && numero <=60)
					obsequio="Una caja de 12 plumones";
				
				if (numero>=61 && numero <=80)
					obsequio="Un cuaderno espiral";
					
				if (numero>=81 && numero<=99)
					obsequio="Una agenda";
				
				if (numero==100)
					obsequio="Una mochila";
				
				//Salida de Resultados
				txtresultado.setText("Obsequio:     "+obsequio);
				
					
			}
		});
		btnprocesar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnprocesar.setBounds(279, 47, 102, 21);
		contentPane.add(btnprocesar);
		
		JButton btnborrar = new JButton("Borrar");
		btnborrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		//Procesa la pulsacion del boton borrar
		btnborrar.addActionListener(new ActionListener()	{	
			public void actionPerformed(ActionEvent e)	{
				txtnumero.setText("");
				txtresultado.setText("");
				txtnumero.requestFocus();
			}
		});
		
		btnborrar.setBounds(279, 66, 102, 21);
		contentPane.add(btnborrar);
	}
}
