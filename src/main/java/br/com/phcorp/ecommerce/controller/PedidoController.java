package br.com.phcorp.ecommerce.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.phcorp.ecommerce.model.Pedido;
import br.com.phcorp.ecommerce.services.IPedidoService;


@RestController
public class PedidoController {

  @Autowired
  private IPedidoService service;
  
  @GetMapping("/pedidos/{numero}")
  public ResponseEntity<Pedido> recuperarPeloNumero(@PathVariable Integer numero){
    Pedido res = service.recuperarPeloNumero(numero);
    if (res != null){
      return ResponseEntity.ok(res);
    }
    return ResponseEntity.notFound().build();
  }

  @PostMapping("/pedidos")
  public ResponseEntity<Pedido> inserirNovoPediro(@RequestBody Pedido novo){
    Pedido res = service.inserirNovoPedido(novo);
    if (res != null){
    return ResponseEntity.ok(res);
    }
    return ResponseEntity.badRequest().build();
  }

  @GetMapping("/pedidos")
  public ArrayList<Pedido> buscarTodos(){
    return service.buscarTodos();
  }

}
