package br.com.thiagocortes.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.thiagocortes.entidades.Pessoa;

public class PessoaDAO {

	private static Connection con = Conexao.getConection();
		
	public void cadastrar(Pessoa pessoa){
		String sql = "INSERT INTO pessoa(nome,sobrenome,cpf) VALUES (?,?,?)";
		try{
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, pessoa.getNome());
			stm.setString(2, pessoa.getSobreNome());
			stm.setString(3, pessoa.getCpf());
			stm.execute();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}	
	}
	
	public void alterar(Pessoa pessoa){
		String sql = "UPDATE disciplinas SET nome=?, sobrenome=?, cpf=? WHERE id_nome = ?";
		
		try{
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, pessoa.getNome());
			stm.setString(2, pessoa.getSobreNome());
			stm.setString(3, pessoa.getCpf());
			stm.setInt(4, pessoa.getIdPessoa());

			stm.execute();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}	
	}
	
	public void delete(Pessoa pessoa){
		String sql = "DELETE FROM disciplinas WHERE id = ?";
		
		try{
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, pessoa.getIdPessoa());
			stm.execute();
			System.out.println("Excluido com sucesso");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}	
	}
	
	public List<Pessoa> consultar(){
		
		Pessoa pessoa = new Pessoa();
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		String sql = "SELECT * FROM disciplinas";
		
		try{
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet resultado = stm.executeQuery();
			
			while(resultado.next()){
				pessoa.setIdPessoa(resultado.getInt("id_pessoa"));
				pessoa.setNome(resultado.getString("nome_pessoa"));
				pessoa.setSobreNome(resultado.getString("sobrenome_pessoa"));
				pessoa.setCpf(resultado.getString("cpf_pessoa"));
				pessoas.add(pessoa);
			}	
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}	
		return pessoas;
	}
	
	public Pessoa buscarId(Pessoa pessoa){
		String sql = "SELECT * FROM pessoa WHERE id_pessoa = ?";
		
		try{
			PreparedStatement stm = con.prepareStatement(sql);
			
			stm.setInt(1, pessoa.getIdPessoa());
			ResultSet resultado = stm.executeQuery();
			if(resultado != null && resultado.next()){
				
				pessoa.setNome(resultado.getString("nome_pessoa"));
				pessoa.setCpf(resultado.getString("cpf_pessoa"));
				pessoa.setSobreNome(resultado.getString("sobrenome_pessoa"));
				
			}
			else{
				System.out.println("Pessoa não localizada");
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return pessoa;
	}
}
