package br.com.phcorp.ecommerce.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
  public ResponseEntity<String> criarNovo(@Valid @RequestBody Cliente novo){
    Cliente res = service.criarNovo(novo);
    if (res != null){
      String cliente = novo.getNome();
      String msg = "Bem vindo " +cliente+"!";
      return ResponseEntity.ok(msg);
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

  @GetMapping("/clientes/busca")
  public ArrayList<Cliente> buscarPorNome(@RequestParam(name = "palavraChave") String palavraChave){
    return service.buscarPorNome(palavraChave);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
      MethodArgumentNotValidException ex) {
       Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
          String fieldName = ((FieldError) error).getField();
          String errorMessage = error.getDefaultMessage();
          errors.put(fieldName, errorMessage);
    });
    return errors;
  }
  
}
