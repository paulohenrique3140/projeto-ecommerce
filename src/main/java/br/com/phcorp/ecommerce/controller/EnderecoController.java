package br.com.phcorp.ecommerce.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.phcorp.ecommerce.model.Endereco;
import br.com.phcorp.ecommerce.services.IEnderecoService;

@RestController
public class EnderecoController {
  @Autowired
  private IEnderecoService service;

  @GetMapping("/enderecos")
  public ArrayList<Endereco> recuperarTodos(){
    return service.recuperarTodos();
  }

  @GetMapping("/enderecos/{num_seq}")
  public ResponseEntity<Endereco> recuperarPeloCodigo(@PathVariable Integer num_seq){
    Endereco res = service.recuperarPeloCodigo(num_seq);
    if (res != null) {
      return ResponseEntity.ok(res);
    }
    return ResponseEntity.status(404).build();
  }

  @PostMapping("/enderecos")
  public ResponseEntity<Endereco> cadastrarNovo(@RequestBody Endereco novo){
    Endereco res = service.cadastrarNovo(novo);
    if (res != null){
      return ResponseEntity.ok(res);
    }
    return ResponseEntity.badRequest().build();
  }

  @DeleteMapping("/enderecos/{id}")
  public ResponseEntity<Endereco> excluirEndereco(@PathVariable Integer id){
    service.excluirEndereco(id);
    return ResponseEntity.ok(null);
  }

  @PutMapping("/enderecos")
  public ResponseEntity<Endereco> atualizarEndereco(@RequestBody Endereco dados){
    Endereco res = service.atualizarEndereco(dados);
    if (res != null){
      return ResponseEntity.ok(dados);
    }
    return ResponseEntity.badRequest().build();
  }
}
