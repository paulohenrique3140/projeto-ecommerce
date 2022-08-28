package br.com.phcorp.ecommerce.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.phcorp.ecommerce.model.Cliente;
import br.com.phcorp.ecommerce.services.IClienteService;

@RestController
public class ClienteController {
  
  @Autowired
  private IClienteService service;

  @GetMapping("/clientes")
  public ArrayList<Cliente> buscarTodos(){
    return service.buscarTodos();
  }

  @PostMapping("/clientes")
  public ResponseEntity<Cliente> criarNovo(@RequestBody Cliente novo){
    Cliente res = service.criarNovo(novo);
    if (res != null){
      return ResponseEntity.ok(res);
    }
    return ResponseEntity.badRequest().build();
  }

  @PutMapping("/clientes")
  public ResponseEntity<Cliente> atualizarDados(@RequestBody Cliente dados){
    Cliente res = service.atualizarDados(dados);
    if (res != null){    
    return ResponseEntity.ok(res);
    }
    return ResponseEntity.badRequest().build();
  }

  @GetMapping("/clientes/{id}")
  public ResponseEntity<Cliente> buscarPorId(@PathVariable Integer id){
    Cliente res = service.buscarPorId(id);
    if (res != null) {
      return ResponseEntity.ok(res);
    }
    return ResponseEntity.status(404).build();
  }
  
}
