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

public class Prob1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtunidades;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prob1 frame = new Prob1();
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
	public Prob1() {
		setTitle("Tienda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblunidades = new JLabel("Unidades");
		lblunidades.setHorizontalAlignment(SwingConstants.CENTER);
		lblunidades.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblunidades.setBounds(55, 44, 118, 36);
		contentPane.add(lblunidades);
		
		txtunidades = new JTextField();
		txtunidades.setFont(new Font("Dialog", Font.PLAIN, 18));
		txtunidades.setBounds(181, 44, 112, 36);
		contentPane.add(txtunidades);
		txtunidades.setColumns(10);
		
		JScrollPane spcresultado = new JScrollPane();
		spcresultado.setBounds(37, 108, 471, 277);
		contentPane.add(spcresultado);
		
		JTextArea txtresultado = new JTextArea();
		spcresultado.setViewportView(txtresultado);
		
		JButton btnprocesar = new JButton("Procesar");
		btnprocesar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Declaracion de Variables
				
				int unidades;
				double impcom=0, impdes, imppag;
				
				//Entrada de datos
				
				unidades=Integer.parseInt(txtunidades.getText());
				
				//Calcula el importe de la compra
				
				if (unidades>=1 && unidades<=25)
					impcom=unidades*27.7;
				
				if (unidades>=26 && unidades<=50)
					impcom=unidades*25.5;
				
				if (unidades>=51 && unidades<=75)
					impcom=unidades*23.5;
				
				if (unidades>=76)
					impcom=unidades*21.5;
				
				//Calcula el importe del descuento
				
				if (unidades>50)
					impdes=0.15*impcom;
				else
					impdes=0.05*impcom;
				
				//Calcula el importe a pagar
				
				imppag=impcom-impdes;
				
				//Salida de Resultados
				
				txtresultado.setText("Importe de la Compra:"+impcom+"\n");
				txtresultado.append("Importe del Descuento:"+impdes+"\n");
				txtresultado.append("Importe a Pagar:"+imppag+"\n");						
			}
		});
		btnprocesar.setBounds(319, 33, 99, 26);
		contentPane.add(btnprocesar);
		
		JButton btnborrar = new JButton("Borrar");
		btnborrar.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent e)	{			
				txtunidades.setText("");
				txtresultado.setText("");
				txtunidades.requestFocus();
			}
		});
		
		btnborrar.setBounds(319, 71, 99, 26);
		contentPane.add(btnborrar);
	}
}
