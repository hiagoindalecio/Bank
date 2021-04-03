package classes;

public class mainTest {
  public static void main(String[] args) {
    Cliente c1 = new Cliente(1, "Jokiba");
    ContaCorrente conta1 = new ContaCorrente(c1, 123);
    conta1.deposito(101.50);
    conta1.saque(10.40);

    conta1.desativarConta();
    conta1.getHistorico();
  }
}
