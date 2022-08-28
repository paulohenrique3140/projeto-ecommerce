package br.com.phcorp.ecommerce.controller;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.phcorp.ecommerce.model.Produto;
import br.com.phcorp.ecommerce.services.IProdutoService;

@RestController
public class ProdutoController {
  
  @Autowired
  private IProdutoService service;

  @GetMapping("/produtos")
  public ArrayList<Produto> recuperarTodos(){
    return service.recuperarTodos();
  }

  @GetMapping("/produtos/{codigo}")
  public ResponseEntity<Produto> recuperarPeloCodigo(@PathVariable Integer codigo){
    Produto res = service.recuperarPeloCodigo(codigo);
    if (res != null){
      return ResponseEntity.ok(res);
    }
    return ResponseEntity.status(404).build();
  }

  @PostMapping("/produtos")
  public ResponseEntity<Produto> cadastrarNovo(@RequestBody Produto novo){
    Produto res = service.cadastrarNovo(novo);
    if (novo.getNome() != null){
      return ResponseEntity.ok(res);
    }
    return ResponseEntity.badRequest().build();
  }

  @DeleteMapping("/produtos/{id}")
  public ResponseEntity<Produto> excluirProduto(@PathVariable Integer id){
    service.excluirProduto(id);
    return ResponseEntity.ok(null);
  }
  
}
