# Sistema de Gerenciamento de Usuários

## Descrição
Backend com Spring Boot para gerenciar usuários de uma aplicação web. Permite cadastro, atualização, exclusão e validação de login de usuários.

## Arquitetura do Projeto

O projeto é uma API RESTful desenvolvida com Spring Boot, estruturada em camadas:
- **Controller:** expõe os endpoints da API.
- **Domain/Model:** contém as entidades do sistema.
- **Repository:** acesso ao banco de dados via Spring Data JPA.

## Endpoints da API

### Usuários
- **POST /usuarios**: Cadastra um novo usuário.
  - Campos obrigatórios: `nome`, `email`, `login`, `senha`.
- **GET /usuarios**: Lista todos os usuários.
- **PUT /usuarios/{id}**: Atualiza um usuário existente.
- **DELETE /usuarios/{id}**: Remove um usuário pelo ID.
- **POST /usuarios/login?login=LOGIN&senha=SENHA**: Valida o login do usuário.

## Como executar
### Pré-requisitos
- Docker e Docker Compose instalados (opcional)
- Java 17+ e Maven (para rodar localmente)

### Executando com Docker Compose
1. Clone o repositório.
2. Execute:
   ```sh
   docker-compose up --build
   ```
3. Acesse a API em `http://localhost:8080`.

### Executando Localmente
1. Execute:
   ```sh
   mvn spring-boot:run
   ```

## Testando a API

### Coleção Postman
Uma coleção de testes para o Postman está disponível no arquivo `postman_collection.json` na raiz do projeto. Importe-a no Postman para testar todos os endpoints facilmente.

#### Exemplos de Requisições
- Cadastro de usuário:
  ```json
  POST /usuarios
  {
    "nome": "Administrador",
    "email": "admin@exemplo.com",
    "login": "admin",
    "senha": "1234"
  }
  ```
- Login:
  ```json
  POST /usuarios/login?login=admin&senha=1234
  ```

## Banco de dados
H2 em memória (acessível via `/h2-console`).

## Tecnologias
- Java 17
- Spring Boot
- H2 Database
- Docker / Docker Compose (opcional)

## Observações
- O campo `ultimaAtualizacao` é atualizado automaticamente a cada alteração no usuário.
- O banco H2 é usado tanto localmente quanto em ambiente Docker.

---

> Para dúvidas ou sugestões, entre em contato com o responsável pelo projeto.
