package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Prob3 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtcantidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prob3 frame = new Prob3();
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
	public Prob3() {
		setTitle("Dulceria");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 698, 567);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbltipo = new JLabel("Tipo");
		lbltipo.setHorizontalAlignment(SwingConstants.CENTER);
		lbltipo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbltipo.setBounds(23, 23, 98, 46);
		contentPane.add(lbltipo);
		
		JLabel lblcantidad = new JLabel("Cantidad");
		lblcantidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblcantidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblcantidad.setBounds(23, 94, 98, 46);
		contentPane.add(lblcantidad);
		
		JComboBox<String> cbox = new JComboBox<>();
		cbox.setModel(new DefaultComboBoxModel<String>(new String[] {"Primor", "Dulzura", "Tentacion", "Explosion"}));		
		cbox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbox.setToolTipText("");
		cbox.setBounds(149, 23, 137, 46);
		contentPane.add(cbox);
		
		txtcantidad = new JTextField();
		txtcantidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtcantidad.setBounds(149, 94, 137, 46);
		contentPane.add(txtcantidad);
		txtcantidad.setColumns(10);
		
		JScrollPane spcresultado = new JScrollPane();
		spcresultado.setBounds(33, 150, 585, 340);
		contentPane.add(spcresultado);
		
		JTextArea txtresultado = new JTextArea();
		txtresultado.setFont(new Font("Courier New", Font.PLAIN, 18));
		spcresultado.setViewportView(txtresultado);
		
		JButton btnprocesar = new JButton("Procesar");
		btnprocesar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Declaracion de Variables
				int tipo, cantidad, caramelos;
				double impcom=0, impdes=0, imppag;
				
				//Entrada de Datos
				tipo=cbox.getSelectedIndex();
				cantidad=Integer.parseInt(txtcantidad.getText());
				
				//Calcula el importe de la compra
				if (tipo==0)
					impcom=8.5*cantidad;
				
				if (tipo==1)
					impcom=10.0*cantidad;
				
				if (tipo==2)
					impcom=7.0*cantidad;
				
				if (tipo==3)
					impcom=12.5*cantidad;
				
				//Calcula el Importe del Descuento
				
				if (cantidad<5)
					impdes=0.04*impcom;
				
				if (cantidad>=5 && cantidad<10)
					impdes=0.065*impcom;
				
				if (cantidad>=10 && cantidad<15)
					impdes=0.09*impcom;
				
				if (cantidad>=15)
					impdes=0.115*impcom;
				
				//Calcula el Importe a Pagar
				
				imppag=impcom-impdes;
				
				//Calcula la cantidad de Caramelos de Regalo
				
				if (imppag<250)
					caramelos=2*cantidad;
				else
					caramelos=3*cantidad;
				
				//Salida de Resultados
				
				txtresultado.setText("Importe de la Compra      :S/. "+impcom+"\n");
				txtresultado.append("Importe del descuento  :S/."+impdes+"\n");
				txtresultado.append("Importe por pagar :S/."+imppag+"\n");
				txtresultado.append("Caramelos de obsequio  : "+caramelos);
				
			}
		});
		btnprocesar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnprocesar.setBounds(354, 23, 146, 46);
		contentPane.add(btnprocesar);
		
		JButton btnborrar = new JButton("Borrar");
		btnborrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnborrar.setBounds(354, 94, 146, 46);
		contentPane.add(btnborrar);
	}
}
