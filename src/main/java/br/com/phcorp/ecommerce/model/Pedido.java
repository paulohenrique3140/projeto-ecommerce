package br.com.phcorp.ecommerce.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="pedido")
public class Pedido {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="numero")
  private Integer numero;

  @Column(name="data")
  private LocalDate data;

  @Column(name="valor_bruto")
  private Double valorBruto;

  @Column(name="desconto")
  private Double desconto;
  
  @Column(name="valor_final")
  private Double valorFinal;
  
  @Column(name="status", length = 2)
  private String status;

  @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonIgnoreProperties("pedido")
  private List<ItemPedido> itens;

  @ManyToOne
  @JoinColumn(name="cliente_id")
  //@JsonIgnoreProperties("listaPedidos")
  private Cliente cliente;
  
  public Integer getNumero() {
    return numero;
  }
  public void setNumero(Integer numero) {
    this.numero = numero;
  }
  public LocalDate getData() {
    return data;
  }
  public void setData(LocalDate data) {
    this.data = data;
  }
  public Double getValorBruto() {
    return valorBruto;
  }
  public void setValorBruto(Double valorBruto) {
    this.valorBruto = valorBruto;
  }
  public Double getDesconto() {
    return desconto;
  }
  public void setDesconto(Double desconto) {
    this.desconto = desconto;
  }
  public Double getValorFinal() {
    return valorFinal;
  }
  public void setValorFinal(Double valorFinal) {
    this.valorFinal = valorFinal;
  }
 
  public List<ItemPedido> getItens() {
    return itens;
  }
  public void setItens(List<ItemPedido> itens) {
    this.itens = itens;
  }

  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }
  public Cliente getCliente() {
    return cliente;
  }
  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  

  
}
