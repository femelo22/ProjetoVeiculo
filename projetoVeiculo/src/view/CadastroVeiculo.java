package view;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import dao.Persistencia;
import entidade.Veiculo;
import util.TableModel;

public class CadastroVeiculo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField campoModelo;
	private JTextField campoAno;
	private JTextField campoMarca;
	private JTextField campoPlaca;
	private JPanel painelImagem;
	private File imagem;
	private boolean edicao = false; // indicador de novo ou editar
	private Veiculo veiculo;
	private Persistencia conexao = new Persistencia();
	private JButton btnSalvar;
	private TableModel model;
	private JLabel lbimage;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args, TableModel model) {
		try {
			CadastroVeiculo dialog = new CadastroVeiculo(model);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public CadastroVeiculo(Veiculo veiculo, TableModel model) {
		this(model);
		this.model = model;
		this.edicao = true;
		this.veiculo = veiculo;
		setDados();
		
	}
	/**
	 * Create the dialog.
	 * @wbp.parser.constructor
	 */
	public CadastroVeiculo(TableModel model) {
		this.model = model;
		setBounds(100, 100, 879, 440);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblNewLabel = new JLabel("Modelo:");
		lblNewLabel.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 12));
		JLabel lblNewLabel_1 = new JLabel("Marca:");
		lblNewLabel_1.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 12));
		JLabel lblNewLabel_2 = new JLabel("Ano:");
		lblNewLabel_2.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 12));
		JLabel lblNewLabel_3 = new JLabel("Placa:");
		lblNewLabel_3.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 12));
		
		campoModelo = new JTextField();
		campoModelo.setColumns(10);
		
		campoAno = new JTextField();
		campoAno.setColumns(10);
		
		campoMarca = new JTextField();
		campoMarca.setColumns(10);
		
		campoPlaca = new JTextField();
		campoPlaca.setColumns(10);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(10);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		painelImagem = new JPanel();
		painelImagem.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JButton btnAbrir = new JButton("Abrir");
		btnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				imagem = selecionarImagem();
				abrirImagem(imagem);
				
			}

			public File selecionarImagem() {//selecionar a imagem
				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imagens em JPEG e PNG", "jpg", "png");// filtra o tipo de imagens
				fileChooser.addChoosableFileFilter(filtro);
				fileChooser.setAcceptAllFileFilterUsed(false);
				fileChooser.setDialogType(JFileChooser.OPEN_DIALOG);// janela para abrir arquivo
				fileChooser.setCurrentDirectory(new File("C:"));
				fileChooser.showOpenDialog(null);
				
				return fileChooser.getSelectedFile();
			}
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 792, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(28, Short.MAX_VALUE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_3))
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(campoModelo, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
										.addComponent(campoMarca, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
										.addComponent(campoAno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED, 216, Short.MAX_VALUE)
									.addComponent(painelImagem, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(campoPlaca, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 448, Short.MAX_VALUE)
									.addComponent(btnAbrir, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)))
							.addGap(104))))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(53)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(campoModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(38)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(campoMarca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(34)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2)
								.addComponent(campoAno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(35)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_3)
								.addComponent(campoPlaca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(26)
							.addComponent(painelImagem, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnAbrir)))
					.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addGap(42))
		);
		
		lbimage = new JLabel("");
		painelImagem.add(lbimage);
		
		JButton btnNewButton = new JButton("Salvar");//método para salvar e atualizar
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				conexao.conectar();
				if(edicao) {
					veiculo.setModelo(campoModelo.getText());
					veiculo.setMarca(campoMarca.getText());
					veiculo.setAno(Integer.parseInt(campoAno.getText()));
					veiculo.setPlaca(campoPlaca.getText());
					if(imagem != null) {
						veiculo.setImagem(getImagem());
					}
					conexao.alterar(veiculo);
					model.atualizaDados(conexao.listar());
					JOptionPane.showInputDialog(this,"Registro alterado com sucesso!");
					conexao.fecharCon();
					dispose();
					
				}else {
					Veiculo veiculo = new Veiculo();
					veiculo.setModelo(campoModelo.getText());
					veiculo.setMarca(campoMarca.getText());
					veiculo.setAno(Integer.parseInt(campoAno.getText()));// fazemos a conversão de inteiro para string
					veiculo.setPlaca(campoPlaca.getText());
					veiculo.setImagem(getImagem());
					conexao.inserir(veiculo);
					model.atualizaDados(conexao.listar());
					JOptionPane.showInputDialog(this, "O registro foi salvo com sucesso!");
					conexao.fecharCon();
					dispose();
				}
			}
			
			
			//retornar em bytes
			private byte[] getImagem() {
				boolean isPng = false;
				if(imagem != null) {
					isPng = imagem.getName().endsWith("png");
					
					try {
						
						BufferedImage image = ImageIO.read(imagem);
						ByteArrayOutputStream out = new ByteArrayOutputStream();
						int type = BufferedImage.TYPE_INT_RGB;
						
						if(isPng) {
							type = BufferedImage.BITMASK;
						}
						
						BufferedImage novaImagem = new BufferedImage(painelImagem.getWidth() - 5, painelImagem.getHeight() - 10, type);
						Graphics2D g = novaImagem.createGraphics();
						g.setComposite(AlphaComposite.Src);
						g.drawImage(image, 0, 0, painelImagem.getWidth() - 5, painelImagem.getHeight() - 10, null);
						
						if(isPng) {
							ImageIO.write(novaImagem, "png", out);
						}else {
							ImageIO.write(novaImagem, "jpg", out);
						}
						
						out.flush();
						byte[] byteArray = out.toByteArray();
						out.close();
						
						return byteArray;
						
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
				return null;
			}
			
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		panel.add(btnNewButton_1);
		contentPanel.setLayout(gl_contentPanel);
	}
	private void setDados() {// mostra todas as informações no formulario de editar
		campoModelo.setText(veiculo.getModelo());
		campoMarca.setText(veiculo.getMarca());
		campoAno.setText(String.valueOf(veiculo.getAno()));
		campoPlaca.setText(veiculo.getPlaca());
		abrirImagem(veiculo.getImagem());
	}
	
	private void abrirImagem(Object source) {
		if(source instanceof File) {
			ImageIcon icon = new ImageIcon(imagem.getAbsolutePath());
			icon.setImage(icon.getImage().getScaledInstance(painelImagem.getWidth() - 5,painelImagem.getHeight() - 10, 100));
			lbimage.setIcon(icon);
		}else if(source instanceof byte[]) {
			ImageIcon icon = new ImageIcon(veiculo.getImagem());
			icon.setImage(icon.getImage().getScaledInstance(painelImagem.getWidth() - 5,painelImagem.getHeight() - 10, 100));
			lbimage.setIcon(icon);
		}
	}
}

