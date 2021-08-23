package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Fornecedor;
import factories.ConnectionFactory;
import interfaces.IFornecedorRepository;

public class FornecedorRepository implements IFornecedorRepository {

	@Override
	public void create(Fornecedor obj) throws Exception {

		String query = "INSERT INTO FORNECEDOR(NOME, CNPJ) VALUES(?, ?)";

		// abrindo uma conexão com o banco de dados
		Connection connection = ConnectionFactory.getConnection();

		// executando o comando SQL
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, obj.getNome());
		statement.setString(2, obj.getCnpj());

		statement.execute();
		statement.close();

		connection.close();
	}

	@Override
	public void update(Fornecedor obj) throws Exception {

		String query = "UPDATE FORNECEDOR SET NOME = ?, CNPJ = ? WHERE IDFORNECEDOR = ?";

		// abrindo uma conexão com o banco de dados
		Connection connection = ConnectionFactory.getConnection();

		// executando o comando SQL
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, obj.getNome());
		statement.setString(2, obj.getCnpj());
		statement.setInt(3, obj.getIdFornecedor());

		statement.execute();
		statement.close();

		connection.close();
	}

	@Override
	public void delete(Fornecedor obj) throws Exception {

		String query = "DELETE FROM FORNECEDOR WHERE IDFORNECEDOR = ?";

		// abrindo uma conexão com o banco de dados
		Connection connection = ConnectionFactory.getConnection();

		// executando o comando SQL
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, obj.getIdFornecedor());

		statement.execute();
		statement.close();

		connection.close();
	}

	@Override
	public List<Fornecedor> read() throws Exception {

		String query = "SELECT * FROM FORNECEDOR";

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement(query);
		ResultSet result = statement.executeQuery();

		List<Fornecedor> lista = new ArrayList<Fornecedor>(); // lista vazia!

		// enquanto houver registros..
		while (result.next()) { // ler cada linha da consulta

			// ler os dados de cada fornecedor obtido na consulta
			Fornecedor fornecedor = new Fornecedor();

			fornecedor.setIdFornecedor(result.getInt("IDFORNECEDOR")); // coluna
			fornecedor.setNome(result.getString("NOME")); // coluna
			fornecedor.setCnpj(result.getString("CNPJ")); // coluna

			lista.add(fornecedor);
		}

		statement.close();
		result.close();

		connection.close();

		return lista;
	}

}
