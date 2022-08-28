package br.com.phcorp.ecommerce.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity //Informa que sera uma classe armazenavel no DB
@Table(name = "departamento")  // Aqui eu torno explícito o nome da tabela
public class Departamento {
  
  @Column(name = "codigo") // especifico o nome da coluna
  @Id // indico que este atributo corresponde à primary key da table
  @GeneratedValue(strategy = GenerationType.IDENTITY) // informo que é auto incremento
  private Integer codigo;

  @Column(name = "nome", length = 50, nullable = false)
  private String nome;

  @Column(name = "descricao", nullable = true, columnDefinition = "TEXT")
  private String descricao;
  
  @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL) 
  @JsonIgnoreProperties("departamento")
  private List<Produto> listaProdutos;               
/* no mappedBy eu vou lá na classe Model da tabela
que vou referenciar para saber o nome do objeto que insiro
cascade = efeito cascata, ou seja, se eu fizer alguma
alteracao ou remocao em departamento, o produto tambem sera
afetado.
 */

 /*
  * JsonIgnoreProperties: Utilizo quando tenho uma relacao bidirecional, neste caso uma excecao pois quero
  mostrar tambem, todos os produtos vinculados a cada departamento.
  Eu sempre preciso referenciar o retorno, ou seja, referencio a propria classe departamento para que quando bata
  lá em produto nao entre no loop infinito

  Este mesmo processo deve ser feito no model de produto, referenciando o objeto listaProduto daqui de departamento
  OBS: La em produto nao devo criar um novo atributo, e sim inserir o JsonIgnore exatamente no objeto relacional
  */

  public Integer getCodigo() {
    return codigo;
  }
  public void setCodigo(Integer codigo) {
    this.codigo = codigo;
  }
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public String getDescricao() {
    return descricao;
  }
  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }
  public List<Produto> getListaProdutos() {
    return listaProdutos;
  }
  public void setListaProdutos(List<Produto> listaProdutos) {
    this.listaProdutos = listaProdutos;
  }

  
}
