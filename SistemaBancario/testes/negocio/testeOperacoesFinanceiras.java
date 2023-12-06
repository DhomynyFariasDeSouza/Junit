package negocio;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

public class testeOperacoesFinanceiras {

    private GerenciadoraClientes gerClientes;
    private GerenciadoraContas gerContas;
    

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void setUp() {

        List<ContaCorrente> contasDoBanco = new ArrayList<>();
        contasDoBanco.add(new ContaCorrente(1, 100.0, true));
        contasDoBanco.add(new ContaCorrente(2, 50.0, true));

        List<Cliente> clientesDoBanco = new ArrayList<>();
        clientesDoBanco.add(new Cliente(1, "Pedro Silva", "111111-11", 18, "pedro@gmail.com", 1, true));
        clientesDoBanco.add(new Cliente(2, "Maria Lusardo", "222222-22", 25, "maria@gmail.com", 2, true));

        gerContas = new GerenciadoraContas(contasDoBanco);
        gerClientes = new GerenciadoraClientes(clientesDoBanco);
    }

    @Test
    public void TesteDeDepositoEmConta() {
       
        int idCliente = 2;
        double valorDeposito = 200.0;
    
        double saldoAntesDeposito = gerContas.pesquisaConta(idCliente).getSaldo();
    
        boolean resultado = gerContas.depositaValor(gerClientes.pesquisaCliente(idCliente).getIdContaCorrente(), valorDeposito);
   
        double saldoDepoisDeposito = gerContas.pesquisaConta(idCliente).getSaldo();
    
        System.out.println("Saldo antes do depósito: " + saldoAntesDeposito);
        System.out.println("Depósito de " + valorDeposito + " realizado com sucesso");
        System.out.println("Saldo depois do depósito: " + saldoDepoisDeposito);
    
        assertTrue(resultado);
    
        assertEquals(saldoDepoisDeposito,250,0.001);
    }

    @Test
    public void testTransfereValorEntreClientes() {
        int idClienteOrigem = 1;
        int idClienteDestino = 2;
        double valor = 100;

      
        String nomeClienteOrigem = gerClientes.pesquisaCliente(idClienteOrigem).getNome();
        String nomeClienteDestino = gerClientes.pesquisaCliente(idClienteDestino).getNome();

        double saldoInicialOrigem = gerContas.pesquisaConta(idClienteOrigem).getSaldo();
        double saldoInicialDestino = gerContas.pesquisaConta(idClienteDestino).getSaldo();

       
        boolean resultado = gerContas.transfereValor(
                gerClientes.pesquisaCliente(idClienteOrigem).getIdContaCorrente(),
                valor,
                gerClientes.pesquisaCliente(idClienteDestino).getIdContaCorrente()
        );

       
        assertTrue(resultado);

       
        double saldoAtualizadoOrigem = gerContas.pesquisaConta(idClienteOrigem).getSaldo();
        double saldoAtualizadoDestino = gerContas.pesquisaConta(idClienteDestino).getSaldo();

      
        System.out.println("Saldo inicial de " + nomeClienteOrigem + ": " + saldoInicialOrigem);
        System.out.println("Saldo inicial de " + nomeClienteDestino + ": " + saldoInicialDestino);
        System.out.println("Transferência de " + valor + " feita por " + nomeClienteOrigem  + " realizada com sucesso." );
        System.out.println("Saldo atualizado de " + nomeClienteOrigem + ": " + saldoAtualizadoOrigem);
        System.out.println("Saldo atualizado de " + nomeClienteDestino + ": " + saldoAtualizadoDestino);

     
        assertEquals(saldoInicialOrigem - valor, saldoAtualizadoOrigem, 0.001);
        assertEquals(saldoInicialDestino + valor, saldoAtualizadoDestino, 0.001);
    }
    
    @Test
    public void TesteDeSaque() {
       
        int idCliente = 1;
        double valorSaque = 50;
    
        
        double saldoAntes = gerContas.pesquisaConta(1).getSaldo();
    
     
        boolean resultado = gerContas.sacaValor(gerClientes.pesquisaCliente(idCliente).getIdContaCorrente(), valorSaque);
    
        double saldoAtual = gerContas.pesquisaConta(1).getSaldo();
    
        System.out.println("Saldo antes do saque: " + saldoAntes);
        System.out.println("valor que foi sacado:" + valorSaque);
        System.out.println("Saldo após o saque: " + saldoAtual);
    
        
        assertTrue(resultado);
    
        assertEquals(50.0, saldoAtual, 0.01);
    }
    
    @Test
    public void TesteDeSaqueComSaldoInsuficiente() {
        int idCliente = 1;
        double valorSaque = 150.0; // Um valor que exceda o saldo atual.

        // Configuração da exceção esperada
        exceptionRule.expect(SaldoInsuficienteException.class);
        exceptionRule.expectMessage("Saldo insuficiente na conta.");

        // Executa o método que deveria lançar a exceção
        gerContas.sacaValor(gerClientes.pesquisaCliente(idCliente).getIdContaCorrente(), valorSaque);
}
    
    @Test
    public void TesteDeTranferenciaComSaldoinsuficiente() {
    	int contaOrigem = 1;
    	int contaDestino = 2;
    	double valor = 300.00;
    	
    	exceptionRule.expect(SaldoInsuficienteException.class);
    	exceptionRule.expectMessage("Saldo insuficiente na conta.");
    	
    	gerContas.transfereValor(contaOrigem, valor, contaDestino);
    }

}
