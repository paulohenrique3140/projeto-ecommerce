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
@Table(name = "endereco")
public class Endereco {
  
  @Column(name = "num_seq")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer num_seq;

  @Column(name = "tipo", length = 5, nullable = false)
  private String tipo;

  @Column(name = "logradouro", length = 50, nullable = false)
  private String logradouro;

  @Column(name = "numero")
  private Integer numero;

  @Column(name = "compl", length = 20)
  private String compl;

  @Column(name = "bairro", length = 30)
  private String bairro;

  @Column(name = "cidade", length = 50)
  private String cidade;

  @Column(name = "cep", length = 10)
  private String cep;

  @Column(name = "estado", length = 2)
  private String estado;

  @ManyToOne
  @JoinColumn(name = "id_cliente")
  @JsonIgnoreProperties("listaEnderecos")
  private Cliente cliente;

  public Integer getNum_seq() {
    return num_seq;
  }

  public void setNum_seq(Integer num_seq) {
    this.num_seq = num_seq;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public String getLogradouro() {
    return logradouro;
  }

  public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
  }

  public Integer getNumero() {
    return numero;
  }

  public void setNumero(Integer numero) {
    this.numero = numero;
  }

  public String getCompl() {
    return compl;
  }

  public void setCompl(String compl) {
    this.compl = compl;
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  

}
