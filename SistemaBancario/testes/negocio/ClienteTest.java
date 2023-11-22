package negocio;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import negocio.GerenciadoraClientes;



public class ClienteTest {
	Cliente a = new Cliente(1, "José Osvaldo Iago Souza", "321.391.875-04", 16, "iago548@outlook.com", 754, true);
	Cliente b = new Cliente(2, "Lais Emily Novaes", "130.412.929-20", 50, "lais759@yahoo.com.br", 753, false);
	Cliente c = new Cliente(3, "Arthur Anthony da Conceição", "356.047.585-66", 18, "athur548@gmail.com", 758, false);
	Cliente d = new Cliente(4, "Roberto Campos", "706.889.274-40", 24, "roberto521@gmail.com", 750, false);
	
	@Test
	public void Cliente() {
		assertNotNull(d);
	}
	
	@Test
	public void PesquisarClientePorId() {
		GerenciadoraClientes g = new GerenciadoraClientes(new ArrayList<Cliente>());
		g.adicionaCliente(a);
		g.adicionaCliente(b);
		g.adicionaCliente(c);
		g.adicionaCliente(d);
		
		assertSame(b, g.pesquisaClientePorId(2));
		assertSame(c,g.pesquisaClientePorId(3));
		
	}
	
	@Test
	public void PesquisarClientePorCPF() {
		GerenciadoraClientes g = new GerenciadoraClientes(new ArrayList<Cliente>());
		g.adicionaCliente(a);
		g.adicionaCliente(b);
		g.adicionaCliente(c);
		g.adicionaCliente(d);
		
		assertSame(d,g.pesquisaClientePorCPF("706.889.274-40"));
		System.out.println(g.pesquisaClientePorCPF("706.889.274-40").toString());
	}
	
	@Test
	public void AtualizarCliente01(){
		//salvando os atributos
		String Cpf = a.getCpf();
		String nome = a.getNome();
		String email = a.getEmail();
		int id = a.getId();
		int idade = a.getIdade();
		int conta = a.getIdContaCorrente();
		// Mudando os atributos
		a.setNome("Dhomyny");
		a.setCpf("777.777.777-77");
		a.setEmail("dhomyny@gmail.com");
		a.setId(6);
		a.setIdade(30);
		a.setIdContaCorrente(759);
		// Testes
		assertNotSame(nome,a.getNome());
		assertNotSame(Cpf, a.getCpf());
		assertNotSame(email,a.getEmail());
		assertNotSame(id,a.getId());
		assertNotSame(idade,a.getIdade());
		assertNotSame(conta,a.getIdContaCorrente());
		
	}
	
	@Test
	public void AtualizarCliente02(){
		// Salvando os atributos
		String Cpf = b.getCpf();
		String nome = b.getNome();
		String email = b.getEmail();
		int id = b.getId();
		int idade = b.getIdade();
		int conta = b.getIdContaCorrente();
		// Mudando os atributos
		b.setNome("Dhomyny");
		b.setCpf("777.777.777-77");
		b.setEmail("dhomyny@gmail.com");
		b.setId(6);
		b.setIdade(30);
		b.setIdContaCorrente(759);
		
		assertNotSame(nome,b.getNome());
		assertNotSame(Cpf, b.getCpf());
		assertNotSame(email,b.getEmail());
		assertNotSame(id,b.getId());
		assertNotSame(idade,b.getIdade());
		assertNotSame(conta,b.getIdContaCorrente());
		
	}
	
	@Test
	public void AtualizarCliente03(){
		// Salvando os atributos
		String Cpf = c.getCpf();
		String nome = c.getNome();
		String email = c.getEmail();
		int id = c.getId();
		int idade = c.getIdade();
		int conta = c.getIdContaCorrente();
		// Mudando os atributos
		c.setNome("Dhomyny");
		c.setCpf("777.777.777-77");
		c.setEmail("dhomyny@gmail.com");
		c.setId(6);
		c.setIdContaCorrente(759);
		c.setIdade(30);
		// Testes
		assertNotSame(nome,c.getNome());
		assertNotSame(Cpf, c.getCpf());
		assertNotSame(email,c.getEmail());
		assertNotSame(id,c.getId());
		assertNotSame(idade,c.getIdade());
		assertNotSame(conta,c.getIdContaCorrente());
		
	}
	
	@Test
	public void AtualizarCliente04(){
		// Salvando os atributos
		String Cpf = d.getCpf();
		String nome = d.getNome();
		String email = d.getEmail();
		int id = d.getId();
		int idade = d.getIdade();
		int conta = d.getIdContaCorrente();
		// Mudando os atributos
		d.setNome("Dhomyny");
		d.setCpf("777.777.777-77");
		d.setEmail("dhomyny@gmail.com");
		d.setId(6);
		d.setIdContaCorrente(759);
		d.setIdade(30);
		// Testes
		assertNotSame(nome,d.getNome());
		assertNotSame(Cpf, d.getCpf());
		assertNotSame(email,d.getEmail());
		assertNotSame(id,d.getId());
		assertNotSame(idade,d.getIdade());
		assertNotSame(conta,d.getIdContaCorrente());
	}
	
	@Test
	public void AlterarStatus() {
		d.setAtivo(false);
		assertFalse(d.isAtivo());
	}
	
}
