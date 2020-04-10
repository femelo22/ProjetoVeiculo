package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import dao.Persistencia;
import entidade.Veiculo;
import util.TableModel;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaVeiculo extends JFrame {

	private JPanel contentPane;
	private JTextField campoModelo;
	private JTextField campoMarca;
	private JTextField campoPlaca;
	private JTextField campoAno;
	private JTable table;
	private TableModel model;
	Persistencia conexao = new Persistencia();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVeiculo frame = new TelaVeiculo();
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
	public TelaVeiculo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 990, 603);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Modelo:");
		lblNewLabel.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 18));
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 18));
		
		JLabel lblAno = new JLabel("Ano:");
		lblAno.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 18));
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 18));
		
		campoModelo = new JTextField();
		campoModelo.setEditable(false);
		campoModelo.setColumns(10);
		
		campoMarca = new JTextField();
		campoMarca.setEditable(false);
		campoMarca.setColumns(10);
		
		campoPlaca = new JTextField();
		campoPlaca.setEditable(false);
		campoPlaca.setColumns(10);
		
		campoAno = new JTextField();
		campoAno.setEditable(false);
		campoAno.setColumns(10);
		
		JPanel painelImagem = new JPanel();
		painelImagem.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(campoModelo, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblMarca, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(campoMarca, 176, 176, 176)))
								.addGap(53)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblAno, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(campoAno, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblPlaca, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(campoPlaca)))
								.addGap(158)
								.addComponent(painelImagem, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(18)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 894, GroupLayout.PREFERRED_SIZE)
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
					.addGap(103))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(painelImagem, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(campoModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAno, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
								.addComponent(campoAno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(42)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMarca, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
								.addComponent(campoMarca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPlaca, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
								.addComponent(campoPlaca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(34)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addGap(53)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(41, Short.MAX_VALUE))
		);
		
		JLabel image = new JLabel("");
		painelImagem.add(image);
		
		conexao.conectar();
		model = new TableModel(conexao.listar()); //inicializar o nosso model
		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(arg0.getClickCount() == 1) {
					carregarInfo(table.getSelectedRow());
				}
			}
			
			private void carregarInfo(int index) {
				Veiculo carro = (Veiculo) model.getSelecionado(index);
				if(carro != null) {
					campoModelo.setText(carro.getModelo());
					campoMarca.setText(carro.getMarca());
					campoAno.setText(String.valueOf(carro.getAno()));
					campoPlaca.setText(carro.getPlaca());
					
					ImageIcon icone = new ImageIcon(carro.getImagem());
					icone.setImage(icone.getImage().getScaledInstance(painelImagem.getWidth() -2 , painelImagem.getHeight() - 4, 100));// define o tamanho da imagem que ira aparecer na tela principal
					image.setIcon(icone);
				}
			}
			
		});
		scrollPane_1.setViewportView(table);
		
		JButton btnNewButton = new JButton("Novo ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroVeiculo cadastro = new CadastroVeiculo(model);
				cadastro.setVisible(true);
				cadastro.setLocationRelativeTo(null);
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 12));
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Alterar");
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int indice = table.getSelectedRow();
				if(indice >= 0) {
					Veiculo veiculoEdicao = (Veiculo) model.getSelecionado(indice);
					CadastroVeiculo guiEdicao = new CadastroVeiculo(veiculoEdicao, model);
					guiEdicao.setVisible(true);
					guiEdicao.setLocationRelativeTo(null);
				}else {
					JOptionPane.showMessageDialog(null,"Selecione um registro!");// se clicar sem selecionar uma linha, aparece um alerta
				}
			}
		});
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 12));
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Exluir");
		btnNewButton_2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				int indice = table.getSelectedRow(); // capturando o indice
				if(indice >= 0) {
					Veiculo veiculoExclusao = (Veiculo) model.getSelecionado(indice);
					if(JOptionPane.showConfirmDialog(null,"Deseja mesmo exluir esse registro?") == JOptionPane.YES_OPTION){
					conexao.excluir(veiculoExclusao);	
					model.refreshData(conexao.listar());
					JOptionPane.showMessageDialog(null,"Registro exluido com sucesso!");
					}
				}else {
					JOptionPane.showMessageDialog(null,"Selecione um registro!");// se clicar sem selecionar uma linha, aparece um alerta
					
				}
			}
		});
		btnNewButton_2.setFont(new Font("Dialog", Font.BOLD, 12));
		panel_1.add(btnNewButton_2);
		contentPane.setLayout(gl_contentPane);
	}
}
