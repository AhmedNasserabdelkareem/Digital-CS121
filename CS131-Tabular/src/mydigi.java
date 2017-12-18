import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Button;

import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.TextArea;

import javax.swing.DropMode;
import javax.swing.ImageIcon;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;

public class mydigi {
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblDontCare;
	private JLabel lblResult;
	public int[] minterms;
	public int[] dontcares;
	public int k;
	public boolean check = true;
	String nl = System.getProperty("line.separator");
	private JTextArea textArea_2;
	SinglyLinkedList min = new SinglyLinkedList(), dont = new SinglyLinkedList();
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame r = new JFrame();

					// ***********************************************************************//
					r.getContentPane().setForeground(Color.LIGHT_GRAY);
					// r.getContentPane().setBackground();
					r.getContentPane().setLayout(null);

					JLabel lblFlora = new JLabel("Welcome to Our Project");
					lblFlora.setForeground(Color.RED);
					lblFlora.setFont(new Font("Tahoma", Font.BOLD, 50));
					lblFlora.setBounds(191, 12, 643, 90);
					r.getContentPane().add(lblFlora);

					JLabel lblNewLabel_1 = new JLabel("All Copyrights reserved to Ahmed Nasser & Bassam Ashraf  ");
					lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 24));
					lblNewLabel_1.setForeground(Color.RED);
					lblNewLabel_1.setBounds(12, 415, 709, 28);
					r.getContentPane().add(lblNewLabel_1);

					JLabel label = new JLabel("---------------------------");
					label.setForeground(Color.RED);
					label.setFont(new Font("Tahoma", Font.BOLD, 50));
					label.setBounds(199, 59, 643, 90);
					r.getContentPane().add(label);

					// **************************************************************
					r.getContentPane().setBackground(Color.LIGHT_GRAY);
					r.setBounds(100, 100, 1000, 500);
					r.setVisible(true);
					JButton read = new JButton("let’s start");
					// read.setBackground(Color.PINK);
					read.setForeground(Color.BLACK);
					read.setFont(new Font("Tahoma", Font.PLAIN, 20));
					read.setBounds(380, 198, 153, 51);
					r.getContentPane().add(read);
					r.getContentPane().add(read);

					JLabel lblNewLabel_2 = new JLabel("");
					lblNewLabel_2.setBackground(Color.LIGHT_GRAY);
					lblNewLabel_2.setIcon(
							new ImageIcon("C:\\Users\\Ahmed\\Downloads\\305549-digital-wallpaper-1152x768.jpg"));
					lblNewLabel_2.setBounds(0, 0, 982, 453);
					r.getContentPane().add(lblNewLabel_2);
					read.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							r.dispose();
							mydigi window = new mydigi();
							window.frame.setVisible(true);
						}
					});

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 */
	public mydigi() {

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.PINK);
		frame.setBounds(100, 100, 1180, 573);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("add");
		btnNewButton.setFont(new Font("Agency FB", Font.BOLD, 20));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String p = textField.getText();
					p.replaceAll(" ", "");
					String s[] = p.split(",");

					int out[] = new int[s.length];

					for (int i = 0; i < s.length; i++) {

						out[i] = Integer.parseInt(s[i]);
					}
					minterms = out;
					for (int k = 0; k < minterms.length; k++) {
						min.add(minterms[k]);
					}

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Enter numbers please ^_^ ");
				}
			}
		});
		btnNewButton.setBounds(99, 109, 160, 41);
		frame.getContentPane().add(btnNewButton);

		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.BOLD, 18));
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		textField.setBounds(30, 46, 300, 50);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("                       MINTERM");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Agency FB", Font.BOLD, 24));
		lblNewLabel.setBounds(30, 0, 300, 50);
		frame.getContentPane().add(lblNewLabel);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.BOLD, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(30, 209, 300, 50);
		frame.getContentPane().add(textField_1);

		lblDontCare = new JLabel("                     DON\u2019T CARE");
		lblDontCare.setForeground(Color.BLACK);
		lblDontCare.setFont(new Font("Agency FB", Font.BOLD, 24));
		lblDontCare.setBounds(30, 159, 300, 50);
		frame.getContentPane().add(lblDontCare);

		lblResult = new JLabel("Final Result :");
		lblResult.setForeground(Color.BLACK);
		lblResult.setFont(new Font("Agency FB", Font.BOLD, 26));
		lblResult.setBounds(30, 339, 184, 39);
		frame.getContentPane().add(lblResult);

		JLabel lblSteps = new JLabel("Steps : ");
		lblSteps.setForeground(Color.BLACK);
		lblSteps.setFont(new Font("Agency FB", Font.BOLD, 26));
		lblSteps.setBounds(637, 9, 95, 33);
		frame.getContentPane().add(lblSteps);

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Arial", Font.BOLD, 18));
		textArea_1.setEditable(false);
		frame.getContentPane().add(textArea_1);
		JScrollPane c = new JScrollPane(textArea_1);
		c.setBounds(637, 53, 470, 460);
		frame.getContentPane().add(c);

		textArea_2 = new JTextArea();
		textArea_2.setFont(new Font("Arial", Font.PLAIN, 18));
		textArea_2.setEditable(false);
		textArea_2.setBounds(31, 391, 500, 122);
		frame.getContentPane().add(textArea_2);
		JScrollPane k = new JScrollPane(textArea_2);
		k.setBounds(31, 391, 500, 122);
		frame.getContentPane().add(k);

		JButton button = new JButton("add");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					String r = textField_1.getText();
					r.replaceAll(" ", "");
					String y[] = r.split(",");
					int in[] = new int[y.length];

					for (int i = 0; i < y.length; i++) {

						in[i] = Integer.parseInt(y[i]);
					}
					dontcares = in;

					for (int k = 0; k < dontcares.length; k++) {
						dont.add(dontcares[k]);
					}
					for (int k = 0; k < minterms.length; k++) {
						for (int g = 0; g < dontcares.length; g++) {
							if (minterms[k] == dontcares[g]) {
								JOptionPane.showMessageDialog(null, " Duplicate number in both ");
								break;
							}

						}

					}

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Enter numbers please ^_^ ");
				}
			}
		});
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Agency FB", Font.BOLD, 20));
		button.setBackground(Color.CYAN);
		button.setBounds(99, 285, 160, 41);
		frame.getContentPane().add(button);

		JButton btnShowResults = new JButton("Show Results");
		btnShowResults.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent w) {

				TabularMethode x = new TabularMethode();
				SinglyLinkedList y = new SinglyLinkedList(), z = new SinglyLinkedList();
				y = min;
				z = dont;
				try {
					int er=0;
					String c = textField_2.getText();
					if (c.length()==0){
						er=0;
					
					}else{
					 er = Integer.parseInt(c);
					
					}
					x.program(y, z, er);
					// }catch(Exception e){
					// JOptionPane.showMessageDialog(null, "Enter Number of
					// Variables , Please .");

					// }

					MinTerm primeImplicants[][] = x.patric(x.MinTermA());
					String[] d = x.getSolution(primeImplicants);
					if (d[0].length() == 0) {
						textArea_2.append("Solution (1) : 1");
					} else {
						textArea_2.append(" these variables will be used in Expression : ");
						textArea_2.append("\n");
						for (int i = 0; i < x.variables; i++) {
							textArea_2.append(" " + (char) (65 + i));

						}
						textArea_2.append(".");
						textArea_2.append("\n");

						for (int i = 0; i < d.length; i++) {
							textArea_2.append(" Solution Number ( " + (i + 1) + " )");
							textArea_2.append("\n");
							textArea_2.append(" " + d[i]);
							textArea_2.append("\n");
							textArea_2.append("\n");

						}
					}
					// ********************************************************************************************************\\
					for (int i = 0; i < x.group.length; i++) {
						if (!x.group[i].isEmpty()){
							textArea_1.append(" Group(" + i + ") :");
							textArea_1.append("\n");
						}

						for (int j = 0; j < x.group[i].size(); j++) {
							MinTerm temp = (MinTerm) x.group[i].get(j);
							textArea_1.append(" " + temp.index + "(");
							for (int k = 0; k < temp.minimizations.size(); k++) {
								int pi = (int) temp.minimizations.get(k);
								String di = Integer.toString(pi);

								textArea_1.append(" " + di);
								if (k < temp.minimizations.size() - 1) {
									textArea_1.append(",");
								}

							}
							textArea_1.append(")");
							textArea_1.append(" >>> Covering : ");

							for (int l = 0; l < temp.covering.size(); l++) {
								int pi = (int) temp.covering.get(l);
								String di = Integer.toString(pi);

								textArea_1.append(" " + di + " ");

							}
							String exp = x.getValueOfPrime(temp);
							textArea_1.append(">> Expression : ");
							textArea_1.append(exp);
							textArea_1.append(".");
							textArea_1.append("\n");

						}

					}
					textArea_1.append("=================================");
					textArea_1.append("\n\n");

					MinTerm a[];
					a = x.MinTermA();
					int ed = 0;
					for (int i = 0; i < a.length; i++) {
						if (a[i].ifessintial == true) {
							ed++;
						}
					}
					if (ed > 0) {
						textArea_1.append(" Essential prime Implicants ");
						textArea_1.append("\n");
					}

					for (int i = 0; i < a.length; i++) {
						if (a[i].ifessintial == true) {
							int r = a[i].index;
							String p = Integer.toString(r);

							textArea_1.append(" " + x.getValueOfPrime(a[i]));
							textArea_1.append("\n");
						}
					}
				} catch (Exception e) {
					String c = Integer.toString(x.recommend);
					JOptionPane.showMessageDialog(null, "Invalid Input!\nRecommended no of variables is " + c);
				}

				/*
				 * String c = textField_2.getText(); int g=Integer.parseInt(c);
				 * x.program(y, z,g);
				 * 
				 * 
				 * 
				 * 
				 * 
				 * 
				 * //}catch(Exception e){ //JOptionPane.showMessageDialog(null,
				 * "Enter Number of Variables , Please .");
				 * 
				 * //}
				 * 
				 * MinTerm primeImplicants[][] = x.patric(x.MinTermA()); String
				 * [] d=x.getSolution(primeImplicants); textArea_2.
				 * append(" these variables will be used in Expression : ");
				 * textArea_2.append("\n"); for (int i = 0; i < x.variables;
				 * i++) { textArea_2.append(" " + (char)(65+i));
				 * 
				 * 
				 * } textArea_2.append("."); textArea_2.append("\n");
				 * 
				 * 
				 * for (int i=0;i<d.length;i++){
				 * textArea_2.append(" Solution Number ( " + (i+1)+" )");
				 * textArea_2.append("\n"); textArea_2.append(" "+d[i]);
				 * textArea_2.append("\n"); textArea_2.append("\n");
				 * 
				 * 
				 * }
				 * //***********************************************************
				 * *********************************************\\ for(int i =
				 * 0;i < x.group.length;i++){ if(!x.group[i].isEmpty())
				 * textArea_1.append(" Group("+i+") :");
				 * textArea_1.append("\n");
				 * 
				 * 
				 * for(int j = 0;j < x.group[i].size();j++){ MinTerm temp =
				 * (MinTerm)x.group[i].get(j);
				 * textArea_1.append(" "+temp.index+"("); for(int k = 0; k <
				 * temp.minimizations.size();k++){ int pi=(int)
				 * temp.minimizations.get(k); String di = Integer.toString(pi);
				 * 
				 * textArea_1.append(" "+di); if(k < temp.minimizations.size() -
				 * 1){ textArea_1.append(","); }
				 * 
				 * } textArea_1.append(")");
				 * textArea_1.append(" >>> Covering : ");
				 * 
				 * for(int l = 0;l < temp.covering.size();l++){ int pi=(int)
				 * temp.covering.get(l); String di = Integer.toString(pi);
				 * 
				 * textArea_1.append( " " +di + " ");
				 * 
				 * } String exp = x.getValueOfPrime(temp);
				 * textArea_1.append(">> Expression : ");
				 * textArea_1.append(exp); textArea_1.append(".");
				 * textArea_1.append("\n");
				 * 
				 * }
				 * 
				 * 
				 * } textArea_1.append("=================================");
				 * textArea_1.append("\n\n");
				 * 
				 * MinTerm a []; a=x.MinTermA(); int ed=0; for (int
				 * i=0;i<a.length;i++){ if (a[i].ifessintial==true){ ed++; } }
				 * if (ed>0){ textArea_1.append(" Essential prime Implicants ");
				 * textArea_1.append("\n"); }
				 * 
				 * 
				 * for (int i=0;i<a.length;i++){ if (a[i].ifessintial==true){
				 * int r= a[i].index; String p=Integer.toString(r);
				 * 
				 * 
				 * textArea_1.append(" "+x.getValueOfPrime(a[i]));
				 * textArea_1.append("\n"); } }
				 */
			}
		});
		btnShowResults.setForeground(Color.BLACK);
		btnShowResults.setFont(new Font("Agency FB", Font.BOLD, 20));
		btnShowResults.setBackground(Color.MAGENTA);
		btnShowResults.setBounds(387, 256, 184, 41);
		frame.getContentPane().add(btnShowResults);

		JButton btnNewProblem = new JButton("New Problem");
		btnNewProblem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea_1.setText("");
				textArea_2.setText("");
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				min.clear();
				dont.clear();

			}
		});
		btnNewProblem.setForeground(Color.BLACK);
		btnNewProblem.setFont(new Font("Agency FB", Font.BOLD, 20));
		btnNewProblem.setBackground(Color.CYAN);
		btnNewProblem.setBounds(397, 310, 160, 41);
		frame.getContentPane().add(btnNewProblem);

		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(1086, 53, 21, 460);
		frame.getContentPane().add(scrollBar);

		JButton btnReadFromFile = new JButton("Read from File");
		btnReadFromFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					SinglyLinkedList b = new SinglyLinkedList();
					Readingfile x = new Readingfile();
					b = x.getno();
					for (int i = 0; i < b.size; i++) {
						if (b.size == 0) {
							JOptionPane.showMessageDialog(null, "file is empty");
							check = false;

						} else if (b.size == 1) {
							//String h = (String) b.get(0);
							//textField_2.setText(h);
							String d = (String) b.get(0);
							textField.setText(d);
						} else if (b.size > 1) {
							//String h = (String) b.get(0);
							//textField_2.setText(h);
							String v = (String) b.get(0);
							textField.setText(v);
							String d = (String) b.get(1);
							textField_1.setText(d);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();

				}

			}
		});
		btnReadFromFile.setForeground(Color.BLACK);
		btnReadFromFile.setFont(new Font("Agency FB", Font.BOLD, 20));
		btnReadFromFile.setBackground(Color.CYAN);
		btnReadFromFile.setBounds(397, 209, 160, 41);
		frame.getContentPane().add(btnReadFromFile);

		textField_2 = new JTextField();
		textField_2.setBounds(440, 51, 69, 43);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNumberOfVariables = new JLabel("Number of Variables");
		lblNumberOfVariables.setFont(new Font("Agency FB", Font.BOLD, 26));
		lblNumberOfVariables.setBounds(440, 13, 185, 25);
		frame.getContentPane().add(lblNumberOfVariables);

	}
}
