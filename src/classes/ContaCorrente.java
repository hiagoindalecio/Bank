package classes;

import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class ContaCorrente {
  private Cliente cliente;
  private int numeroConta;
  private double saldo;
  private String historico;
  private boolean status;
  
  public ContaCorrente(Cliente c, int nConta) {
	setCliente(c);
	setNumeroConta(nConta);
	setSaldo(0);
	setStatus(true);
	Date dataHoraAtual = new Date(); 
	String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual); 
	String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
	setHistorico("HISTORICO DA CONTA #" + this.numeroConta + 
			"\n\nProprietario: " + this.cliente.getNome() +
			"\nStatus: " + (this.status ? "Ativo" : "Inativo") +
			"\n\n- Conta " + this.numeroConta + " (Cliente: " + this.cliente.getNome() + ") foi criada com sucesso." + 
			"\n  - Data: " + data + " Hora: " + hora);
	System.out.println(getHistorico());
  }
  
  public Cliente getCliente() {
  	return cliente;
  }
  public void setCliente(Cliente cliente) {
	this.cliente = cliente;
  }
  
  public int getNumeroConta() {
	return numeroConta;
  }
  public void setNumeroConta(int numerroConta) {
	this.numeroConta = numerroConta;
  }
  
  public double getSaldo() {
	return saldo;
  }
  public void setSaldo(double saldo) {
	this.saldo = saldo;
  }
  
  public String getHistorico() {
	return historico;
  }
  public void setHistorico(String historico) {
	this.historico = historico;
  }
  
  public boolean isStatus() {
	return status;
  }
  public void setStatus(boolean status) {
	this.status = status;
  }
  
  public void deposito(double valor) {
	double saldoAnterior = getSaldo();
	setSaldo(getSaldo() + valor);
	Date dataHoraAtual = new Date(); 
	String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual); 
	String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
	String message = "\n\n- Deposito efetuado com sucesso." + 
					"\n  - Valor do deposito: R$" + valor +
					"\n  - Saldo em conta antes do deposito: R$" + saldoAnterior +
					"\n  - Saldo em conta apos o deposito: R$" + getSaldo() +
					"\n  - Data: " + data + " Hora: " + hora;
	System.out.println(message);
	setHistorico(getHistorico() + message);
  }

  public void saque(double valor) {
	double saldo = getSaldo();
	double taxa = valor*0.0033;
	if(saldo > (valor + taxa)){
		setSaldo((getSaldo() - valor) - taxa);
		Date dataHoraAtual = new Date(); 
		String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual); 
		String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
		String message = "\n\n- Saque efetuado com sucesso." + 
						"\n  - Valor do saque: R$" + valor +
						"\n  - Valor da taxa bancaria: R$" + taxa +
						"\n  - Valor total do saque: R$" + (valor + taxa) +
						"\n  - Saldo em conta antes do saque: R$" + saldo +
						"\n  - Saldo em conta apos o saque: R$" + getSaldo() +
						"\n  - Data: " + data + " Hora: " + hora;
		System.out.println(message);
		setHistorico(getHistorico() + message);
	}
	else{
		System.out.println("\nSaldo insuficiente para realizar o saque de R$" + valor +
						   "\n*Temos uma taxa adicional no saque de 0,033%: R$" + taxa);
	}
  }
  
  public void desativarConta() {
	double saldo = getSaldo();
	Scanner leitor = new Scanner(System.in);
	char resp;

	System.out.print("\nDeseja realmente desativar sua conta " + getCliente() + " ?(S/N)\n");
	resp = leitor.next().charAt(0);


	if(Character.toUpperCase(resp) == 'S'){
		Date dataHoraAtual = new Date(); 
		String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual); 
		String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
		setStatus(false);
		setSaldo(0);
		String message = ("\n\n- fechamento efetuado com sucesso." + 
						"\n  - Valor do saque de Fechamento: R$" + (saldo - (saldo*0.0033)) +
						"\n  - Valor da taxa bancaria: R$" + (saldo*0.0033) +
						"\n  - Valor total do saque: R$" + (saldo) +
						"\n  - Saldo em conta antes do saque: R$" + (saldo) +
						"\n  - Saldo em conta apos o saque: R$" + getSaldo() +
						"\n  - Fechamento da conta realizada com sucesso." +
						"\n  - Data: " + data + " Hora: " + hora);
		System.out.println(message);
		setHistorico(getHistorico() + message);
	}
	else{
		System.out.println("\n - Fechamento de conta cancelado.");
	}
	leitor.close();
  }



}