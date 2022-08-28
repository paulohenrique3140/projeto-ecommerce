package br.com.phcorp.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "produto")
public class Produto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="codigo")
  private Integer codigo;

  @Column(name="nome", length=50, nullable=false)
  private String nome;

  @Column(name="descricao", columnDefinition="TEXT", nullable=true)
  private String descricao;

  @Column(name="preco", nullable=true)
  private Double preco;

  @Column(name="estoque", nullable=true)
  private Integer estoque;

  @Column(name="link_foto", length=255, nullable=true)
  private String linkFoto;

  @ManyToOne
  @JoinColumn(name = "numero_depto")
  @JsonIgnoreProperties("listaProdutos")
  private Departamento departamento;

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

  public Double getPreco() {
    return preco;
  }

  public void setPreco(Double preco) {
    this.preco = preco;
  }

  public Integer getEstoque() {
    return estoque;
  }

  public void setEstoque(Integer estoque) {
    this.estoque = estoque;
  }

  public String getLinkFoto() {
    return linkFoto;
  }

  public void setLinkFoto(String linkFoto) {
    this.linkFoto = linkFoto;
  }

  public Departamento getDepartamento() {
    return departamento;
  }

  public void setDepartamento(Departamento departamento) {
    this.departamento = departamento;
  }

  

}
