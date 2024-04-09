package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.DAO;

import modeli.Knjiga;
import modeli.Korisnik;
import modeli.Pozajmica;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class Program1 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private DAO dao=new DAO();
	private JPanel panel_1;
	private JLabel lblNewLabel_2;
	private JPanel panel_2;
	private JLabel lblNewLabel_3;
	private JList<Knjiga> list;
	private JList<Pozajmica> list_1;
	private JPanel panel_4 ;
	
	private ArrayList<Knjiga> lista=new ArrayList<Knjiga>();
	private ArrayList<Korisnik> korisnici=new ArrayList<Korisnik>();
	private ArrayList<Pozajmica> pozajmice = new ArrayList<Pozajmica>();
	private ArrayList<Knjiga> sve_pozajmice = new ArrayList<Knjiga>();
	private ArrayList<Pozajmica> moje_pozajmice=new ArrayList<Pozajmica>();
	private JLabel lblNewLabel_4;
	private JScrollPane scrollPane_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JList<Knjiga> list_2;
	private JPanel panel_3;
	private JScrollPane scrollPane_3;
	private JList<Korisnik> list_3;
	private JList<Pozajmica> list_4;
	Korisnik k;
	private JButton btnNAZAD;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Program1 window = new Program1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Program1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		 JButton btnNewButton_1 = new JButton("dodaj");
		frame = new JFrame();
		frame.setBounds(100, 100, 559, 433);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, "name_769133048098100");
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("username");
		lblNewLabel.setBounds(203, 95, 58, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("password");
		lblNewLabel_1.setBounds(202, 140, 59, 14);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(281, 92, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(281, 137, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		DefaultListModel<Knjiga> dlm=new DefaultListModel<Knjiga>();
		
		DefaultListModel<Pozajmica> dlmp=new DefaultListModel<Pozajmica>();
		
		JButton btnNewButton = new JButton("log in");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().trim()!=null&& textField_1.getText().trim()!=null && textField.getText().trim().length()>0 && textField_1.getText().trim().length()>0) {
			  try {
				k=dao.vratiKorisnika(textField.getText());
				System.out.println(k);
				System.out.println(k.getTip());
				System.out.println(textField_1.getText());
				if(k!=null && k.getTip().equals("korisnik") && k.getPassword().equals(textField_1.getText())) {
					lista=dao.vratiKnjige();
					for (Knjiga knjiga : lista) {
						dlm.addElement(knjiga);
					}
					pozajmice = dao.pozajmice(k);
					if (pozajmice.size() >=3) {
						btnNewButton_1.setEnabled(false);					
						}
					list.setModel(dlm);
					for (Pozajmica p : pozajmice) {
						dlmp.addElement(p);
					}
					list_1.setModel(dlmp);
					changePanel(panel, panel_1);
					
					
					
				}
				if(k!=null && k.getTip().equals("radnik") && k.getPassword().equals(textField_1.getText())) {
					lista=dao.vratiKnjige();
					for (Knjiga knjiga : lista) {
						dlm.addElement(knjiga);
					}
					korisnici=dao.vratiKorisnike();
					list_2.setModel(dlm);
					changePanel(panel, panel_2);
					
				}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
			}
				else JOptionPane.showMessageDialog(btnNewButton, "Greska");
					}
			
		});
		btnNewButton.setBounds(234, 197, 89, 23);
		panel.add(btnNewButton);
		
		 panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, "name_769156606439100");
		panel_1.setLayout(null);
		
		lblNewLabel_2 = new JLabel("korisnik");
		lblNewLabel_2.setBounds(45, 21, 46, 14);
		panel_1.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(311, 73, 186, 196);
		panel_1.add(scrollPane);
		
		 list = new JList();
		 scrollPane.setViewportView(list);
		 
		 lblNewLabel_4 = new JLabel("dostupne knjige");
		 lblNewLabel_4.setBounds(348, 48, 83, 14);
		 panel_1.add(lblNewLabel_4);
		 
		 scrollPane_1 = new JScrollPane();
		 scrollPane_1.setBounds(45, 99, 163, 245);
		 panel_1.add(scrollPane_1);
		 
		  list_1 = new JList();
		 scrollPane_1.setViewportView(list_1);
		 
		 JLabel lblNewLabel_5 = new JLabel("pozajmljene");
		 lblNewLabel_5.setBounds(68, 75, 116, 14);
		 panel_1.add(lblNewLabel_5);
		 
		 btnNewButton_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		Knjiga k1 = list.getSelectedValue();
		 		System.out.println(list.getSelectedIndex());
		 		Pozajmica p = new Pozajmica(k1.getId(), k.getId(), new Date(), null);
		 		dlmp.addElement(p);
		 		try {
					dao.unesiPozajmicu(k1, k);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		 	
		 		pozajmice.add(p);
		 		if (pozajmice.size() >=3) {
		 			btnNewButton_1.setEnabled(false);
		 			
		 		}
		 		list_1.setModel(dlmp);
		 		
		 		
		 	}
		 });
		 btnNewButton_1.setBounds(212, 141, 89, 23);
		 panel_1.add(btnNewButton_1);
		 
		 JButton btnVrati = new JButton("vrati knjigu");
		 btnVrati.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		btnNewButton_1.setEnabled(true);
		 		Pozajmica p1 = list_1.getSelectedValue();
				System.out.println(p1);
		 		System.out.println(list.getSelectedIndex());
				try {
					dao.vratiPozajmice(p1.getId_pozajmice());
					}
				 catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		 	
		 		pozajmice.remove(list_1.getSelectedIndex());
		 		dlmp.removeAllElements();
		 		for (Pozajmica p : pozajmice) {
					dlmp.addElement(p);
				}
		 		list.setModel(dlm);
		 		if (pozajmice.size() >=3) {
		 			btnNewButton_1.setEnabled(false);
		 			
		 		}
		 		list_1.setModel(dlmp);
		 	}
		 });
		 btnVrati.setBounds(212, 175, 89, 23);
		 panel_1.add(btnVrati);
		
		panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, "name_772159132753100");
		panel_2.setLayout(null);
		
		lblNewLabel_3 = new JLabel("radnik");
		lblNewLabel_3.setBounds(52, 43, 46, 14);
		panel_2.add(lblNewLabel_3);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(34, 86, 164, 211);
		panel_2.add(scrollPane_2);
		
		 list_2 = new JList();
		scrollPane_2.setViewportView(list_2);
		
		JButton btnObrisi = new JButton("obrisi knjigu");
		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list_2.getSelectedIndex()!=-1) {
				Knjiga knjiga = list_2.getSelectedValue();
				try {
					Knjiga k1=list_2.getSelectedValue();
					dao.obrisiKnjigu(k1.getId());
					lista = dao.vratiKnjige();
					dlm.removeAllElements();
					dlm.addAll(lista);
					list_2.setModel(dlm);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}}
				else {
					JOptionPane.showMessageDialog(btnObrisi, "Izaberite knjigu");
				}
			}
		});
		btnObrisi.setBounds(21, 327, 139, 23);
		panel_2.add(btnObrisi);
		
		textField_2 = new JTextField();
		textField_2.setBounds(342, 24, 86, 20);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(342, 63, 86, 20);
		panel_2.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(342, 108, 86, 20);
		panel_2.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("naziv");
		lblNewLabel_6.setBounds(239, 27, 46, 14);
		panel_2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("autor");
		lblNewLabel_7.setBounds(239, 66, 46, 14);
		panel_2.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("zanr");
		lblNewLabel_8.setBounds(239, 111, 46, 14);
		panel_2.add(lblNewLabel_8);
		
		JButton btnDodaj = new JButton("Dodaj knjigu");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Knjiga k = new Knjiga(textField_2.getText(), textField_3.getText(), textField_4.getText(), false);
				lista.add(k);
				dlm.removeAllElements();
				dlm.addAll(lista);
				try {
					dao.unesiKnjigu(k);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDodaj.setBounds(283, 139, 118, 23);
		panel_2.add(btnDodaj);
		
		JButton btnPrikazi = new JButton("prikazi  korisnike");
		btnPrikazi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println("eeeeeeee");
					for (Korisnik korisnik : korisnici) {
						System.out.println(korisnik);
					}
					DefaultListModel<Korisnik> dlk=new DefaultListModel<Korisnik>();
					dlk.addAll(korisnici);
					list_3.setModel(dlk);
					changePanel(panel_2, panel_3);
				}  catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnPrikazi.setBounds(262, 248, 155, 23);
		panel_2.add(btnPrikazi);
		
		panel_3 = new JPanel();
		frame.getContentPane().add(panel_3, "name_948923887983400");
		panel_3.setLayout(null);
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(68, 62, 173, 248);
		panel_3.add(scrollPane_3);
		
		list_3 = new JList();
		scrollPane_3.setViewportView(list_3);
		
		btnNAZAD = new JButton("nazad");
		btnNAZAD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_3.setVisible(false);
				panel_2.setVisible(true);
			}
		});
		btnNAZAD.setBounds(327, 155, 89, 23);
		panel_3.add(btnNAZAD);
		
		btnNewButton_2 = new JButton("prikazi pozajmice");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list_3.getSelectedIndex()!=-1) {
					k=list_3.getSelectedValue();
					try {
						moje_pozajmice=dao.moje_pozajmice(k);
						DefaultListModel<Pozajmica> dlp =new DefaultListModel<Pozajmica>();
						dlp.addAll(moje_pozajmice);
						list_4.setModel(dlp);
						changePanel(panel_3, panel_4);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				else {
					JOptionPane.showMessageDialog(btnPrikazi, "Izaberite korisnika");
				}
			}
		});
		btnNewButton_2.setBounds(327, 241, 161, 23);
		panel_3.add(btnNewButton_2);
		
		panel_4 = new JPanel();
		frame.getContentPane().add(panel_4, "name_1798787667730200");
		panel_4.setLayout(null);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(87, 45, 166, 260);
		panel_4.add(scrollPane_4);
		
		 list_4 = new JList();
		scrollPane_4.setViewportView(list_4);
		
		btnNewButton_3 = new JButton("nazad");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_4.setVisible(false);
				panel_3.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(351, 153, 89, 23);
		panel_4.add(btnNewButton_3);
	}
	public void changePanel(JPanel current, JPanel next) {
		current.setVisible(false);
	    next.setVisible(true);
	}
}
