package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.Veiculo;

public class Persistencia {
	
	private Connection con; //variavel de conexão	
	private PreparedStatement stmt;// statement
	
	private final String USER = "root";
	private final String PASS = "";
	private final String URL = "jdbc:mysql://localhost:3306/veiculos";
	
	// criar nosso método de conexão
	public void conectar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(URL,USER,PASS);// inicializar o objeto con(conecction)
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	// método responsavel por INSERIR um registro no banco
	public void inserir (Veiculo veiculo) {
		String sql = "INSERT INTO veiculo(modelo, marca, ano, placa, imagem) VALUES (?, ?, ?, ?, ?)";
		
		try {
			
			stmt = con.prepareStatement(sql);
			stmt.setString(1, veiculo.getModelo());// manupulando o objeto statemen
			stmt.setString(2, veiculo.getMarca());
			stmt.setInt(3, veiculo.getAno());
			stmt.setString(4, veiculo.getPlaca());
			stmt.setBytes(5,veiculo.getImagem());
		
			stmt.execute();// mandar executar
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// método de EXCLUSÃO
	public void excluir (Veiculo veiculo) {
		String sql = "DELETE FROM veiculo WHERE idveiculo = ?";
		
		try {
			
			stmt = con.prepareStatement(sql);
			stmt.setLong(1, veiculo.getIdveiculo());
			stmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//método para fazer ALTERAÇÃO
	public void alterar(Veiculo veiculo) {
		String sql = "UPDATE veiculo SET modelo = ?, marca = ?, ano = ?, placa = ?, imagem = ? WHERE idveiculo = ?";
		
		try {
			
			stmt = con.prepareStatement(sql);
			stmt.setString(1, veiculo.getModelo());
			stmt.setString(2, veiculo.getMarca());
			stmt.setInt(3, veiculo.getAno());
			stmt.setString(4, veiculo.getPlaca());
			stmt.setBytes(5,veiculo.getImagem());
			
			stmt.setLong(6, veiculo.getIdveiculo());
			
			stmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//método de LISTAGEM
	public List<Veiculo> listar(){
		String sql = "SELECT * FROM veiculo";
		//criar uma lista que ira receber os objetos tipo veiculo
		List<Veiculo> lista = new ArrayList<Veiculo>();
		
		try {
			
			stmt = con.prepareStatement(sql);
			ResultSet res = stmt.executeQuery();// recebe os dados do objeto e armazena no objeto res
			
			while(res.next()) {
				Veiculo veiculo = new Veiculo();
				veiculo.setIdveiculo(res.getLong("idveiculo"));
				veiculo.setModelo(res.getString("modelo"));
				veiculo.setMarca(res.getString("marca"));
				veiculo.setAno(res.getInt("ano"));
				veiculo.setPlaca(res.getString("placa"));
				veiculo.setImagem(res.getBytes("imagem"));
				
				lista.add(veiculo);// adcionando os objetos na nossa lista
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;// retornar essa lista que a gnt criou
	}
	
	// método que ira fechar a conexão com o banco
	public void fecharCon() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
