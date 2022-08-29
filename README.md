# PROJETO ECOMMERCE

Desenvolvi esta Api (MVC) com Spring Boot Java e MySQL para implementar mais um pouco os conhecimentos que venho adquirindo em aula. Uilizei o Maven como gerenciador do projeto, JPA para acessar e gerenciar a conexão de dados entre Java e banco de dados relacional e o Postman para executar os testes.

Utilizei um modelo de ecommerce visto em aula como suporte, e efetuei algumas alterações e inserções de métodos extras. No início do vídeo eu mostro o diagrama do modelo ER que utilizei para criação das classes de entidades com seus devidos mapeamentos através de anotações JPA.

Além disso, utilizei o CrudRepository para gerar os códigos MySQL em tempo real. A api possui 4 camadas:
- Controllers: Responsável pelo request/response;
- Services (Faz o intermédio entre controllers e dao/model). Contém outros dois tipos:
1) Service Interfaces: Contém os cabeçalhos dos métodos que os controllers tem acesso;
2) Service Implementação: Contém as implementações dos métodos declarados nas interfaces.
- Model: Camada que contém as classes de entidades;
- DAO: Interface responsável por extender a biblioteca CrudRepository, que é a camada que faz a comunicação entre as classes e o banco de dados, gerando códigos MySQL.

Implementei as seguintes funcionalidades e as testei via Postman:
- Cadastrar cliente;
- Listar clientes (informando seus respectivos endereços);
- Atualizar dados de cliente;
- Cadastrar endereço e vinculá-lo à um cliente;
- Listar endereços;
- Atualizar endereço;
- Excluir endereço;
- Cadastrar produto e vinculá-lo à um departamento;
- Listar produtos;
- Atualizar produtos;
- Cadastrar departamento;
- Listar departamento e os produtos vinculados à cada um deles;
- Atualizar departamento,
- Cadastrar pedido informando os ítens contidos nele (produtos, quantidade, valor unitário, valor total, etc),
- Listar pedidos exibindo detalhes: Lista de ítens, cliente, endereço, produto, data, departamento, etc.