package classes;

public class Cliente {
  private int id;
  private String nome;
  
  public Cliente(int i, java.lang.String n) {
	setId(i);
	setNome(n);
  }
  
  public int getId() {
    return id;
  }
  public void setId(int id_cliente) {
    this.id = id_cliente;
  }
  
  public String getNome() {
    return nome;
  }
  public void setNome(String nome_cliente) {
    this.nome = nome_cliente;
  }
  
}