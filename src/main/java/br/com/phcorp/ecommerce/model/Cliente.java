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

@Entity
@Table(name="cliente")
public class Cliente {
  
  @Column(name = "id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "nome", length = 100, nullable = false)
  private String nome;

  @Column(name = "email", length = 70, nullable = false)
  private String email;

  @Column(name = "senha", length = 20, nullable = false)
  private String senha;

  @Column(name = "rg", length = 20, nullable = false)
  private String rg;

  @Column(name = "cpf", length = 15, nullable = false)
  private String cpf;

  /*@OneToMany(cascade=CascadeType.REMOVE, fetch=FetchType.EAGER,mappedBy="presente", orphanRemoval=true)
    @Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)*/

  @OneToMany(mappedBy="cliente", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonIgnoreProperties("cliente")
  private List<Endereco> listaEnderecos;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public String getRg() {
    return rg;
  }

  public void setRg(String rg) {
    this.rg = rg;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public List<Endereco> getListaEnderecos() {
    return listaEnderecos;
  }

  public void setListaEnderecos(List<Endereco> listaEnderecos) {
    this.listaEnderecos = listaEnderecos;
  }

  
}
