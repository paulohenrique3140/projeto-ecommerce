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
import br.com.phcorp.ecommerce.model.Departamento;
import br.com.phcorp.ecommerce.services.IDepartamentoService;

@RestController
public class DepartamentoController {
  
  /* AUTOWIRED > ferramente do Spring que faz a devida injeção de dependencias
   "ei JVM, preciso de algum objeto que implementa esta interface"
   Ele não vai encontrar e vai procurar no Crud Repository
   Vai encontrar a implementação que gera os SQLs em tempo real!!!
   evita de eu precisar de um objeto que implemente os metodos da interface DepartamentoDAO*/              
  @Autowired 
  private IDepartamentoService service; // >>> Para acessar a interface de servico preciso declarar um objeto da classe IDepartamentoService
                              // que é justamente a classe que faz essa comunicação, extendendo o CRUD Repository
  @GetMapping("/departamentos")
  public ArrayList<Departamento> buscarTodos() {
    return service.buscarTodos();
  }

  @PostMapping("/departamentos")
  public ResponseEntity<Departamento> incluirNovo(@RequestBody Departamento novo){ //RequestBody: como o proprio nome
    Departamento res = service.criarNovo(novo); // diz, eh uma requisicao vinda do body da pagina
    if (res != null) {
      return ResponseEntity.ok(res); //ResponseEntity eh um retorno http, pode ser ok, created, badRequest ...
    }                                 // ou seja, retorna uma resposta ao usuario
    return ResponseEntity.badRequest().build();// .build() faz parte do comando badRequest()
  }

  @PutMapping("/departamentos")
  public ResponseEntity<Departamento> alterar(@RequestBody Departamento dados){
    Departamento res = service.atualizarDados(dados);
    if(res != null){
      return ResponseEntity.ok(res);
    }
    return ResponseEntity.badRequest().build();
  }

  @DeleteMapping("/departamentos/{id}")
  public ResponseEntity<Departamento> excluirDepartamento(@PathVariable Integer id){ //Em resumo, o @PathVariable é utilizado quando o valor da variável é passada diretamente na URL, mas não como um parametro que você passa após o sinal de interrogação ( ? ) mas sim quando o valor faz parte da url
    service.excluirDepartamento(id);
    return ResponseEntity.ok(null);
  }

  @GetMapping("/departamentos/{codigo}")
  public ResponseEntity<Departamento> buscarPeloId (@PathVariable Integer codigo){ 
    Departamento res = service.buscarPeloId(codigo);
    if (res != null){
      return ResponseEntity.ok(res);
    }
    return ResponseEntity.notFound().build();
  }


}
