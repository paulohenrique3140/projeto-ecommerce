package br.com.phcorp.ecommerce.services;

import java.util.ArrayList;

import br.com.phcorp.ecommerce.model.Pedido;

public interface IPedidoService {
  public ArrayList<Pedido> buscarTodos();
  public Pedido inserirNovoPedido(Pedido novo);
  public Pedido recuperarPeloNumero(Integer numero);
  public void excluirPedido(Integer numero);
}
