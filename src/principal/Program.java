package principal;

import entities.Fornecedor;
import entities.Produto;
import repositories.FornecedorRepository;
import repositories.ProdutoRepository;

public class Program {

	public static void main(String[] args) {

		try {

			FornecedorRepository fornecedorRepository = new FornecedorRepository();
			ProdutoRepository produtoRepository = new ProdutoRepository();

			// Cadastrando fornecedor:
			Fornecedor fornecedor = new Fornecedor();
			fornecedor.setNome("Fornecedor Teste");
			fornecedor.setCnpj("16.235.775/0001-86");

			fornecedorRepository.create(fornecedor);

			System.out.println("\nFornecedor cadastrado com sucesso!");

			System.out.println("\nCONSULTA DE FORNECEDORES:");
			for (Fornecedor f : fornecedorRepository.read()) {
				System.out.println(f.toString());
			}

			System.out.println("\nCONSULTA DE PRODUTOS:");
			for (Produto p : produtoRepository.read()) {
				System.out.println(p.toString());
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

}
