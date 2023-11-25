package negocio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class ContasTeste {
	private GerenciadoraContas gerenciarContas;
	Cliente c1 = new Cliente(1, "Dhomyny Ryan", "70688927440", 20, "dhomyny@gmail.com", 750, true);
	Cliente c2 = new Cliente(2, "Paulo Roberto", "49284348030", 21, "roberto@gmail", 751, true);
	@Test
	public void abrirContas() {
		ArrayList<ContaCorrente> contasBancarias = new ArrayList<>();
		gerenciarContas = new GerenciadoraContas(contasBancarias);
		
		gerenciarContas.adicionaConta(new ContaCorrente(750, 0, true));
		gerenciarContas.adicionaConta(new ContaCorrente(751, 0, true));
		
		assertNotNull(gerenciarContas.pesquisaConta(750));
		assertNotNull(gerenciarContas.pesquisaConta(751));
		
	}
	
	@Test
	public void consultarContas() {
		ArrayList<ContaCorrente> contasBancarias = new ArrayList<>();
		// declarando lista e adicionando contas
		gerenciarContas = new GerenciadoraContas(contasBancarias);
	
		gerenciarContas.adicionaConta(new ContaCorrente(750, 0, true));
		gerenciarContas.adicionaConta(new ContaCorrente(751, 0, true));
		//pesquisa que ira retornar alguma conta
		ContaCorrente cc1 = gerenciarContas.pesquisaConta(750);
		ContaCorrente cc2 = gerenciarContas.pesquisaConta(751);
		// pesquisa que ira retornar Null
		ContaCorrente cc3 = gerenciarContas.pesquisaConta(752);
		// criando a variavel para comparar com toString
		String str = "========================="+"\n"
				+ 	"Id: " + cc1.getId() + "\n"
				+ 	"Saldo: " + cc1.getSaldo() + "\n"
				+ 	"Status: " + (cc1.isAtiva()?"Ativa":"Inativa") + "\n"
				+ "=========================";
		
		assertNotNull(cc1);
		assertNotNull(cc2);
		assertNull(cc3);
		assertEquals(cc1.toString(), str);
		System.out.println(cc1.toString());
		System.out.println();
	}
	
	@Test
	public void desativarContas() {
		ArrayList<ContaCorrente> contasBancarias = new ArrayList<>();
		// declarando lista e adicionando contas
		gerenciarContas = new GerenciadoraContas(contasBancarias);
				
		gerenciarContas.adicionaConta(new ContaCorrente(750, 0, true));
		gerenciarContas.adicionaConta(new ContaCorrente(751, 0, true));
		
		//pesquisa que ira retornar uma conta
		ContaCorrente cc1 = gerenciarContas.pesquisaConta(750);
		ContaCorrente cc2 = gerenciarContas.pesquisaConta(751);

		
		cc1.setAtiva(false);
		cc2.setAtiva(false);
		
		assertFalse(cc1.isAtiva());
		assertFalse(cc2.isAtiva());
		System.out.println(cc1.toString());
		System.out.println(cc2.toString());
	}
}