package br.com.phcorp.ecommerce.services;

import br.com.phcorp.ecommerce.model.Pedido;

public interface IPedidoService {
  public Pedido inserirNovoPedido(Pedido novo);
  public Pedido recuperarPeloNumero(Integer numero);
}
