# Sistema de Gerenciamento de Biblioteca

Este é um sistema de gerenciamento de biblioteca desenvolvido com Spring Boot que permite o controle de livros e empréstimos.

## Funcionalidades

### Gerenciamento de Livros
- Cadastrar novos livros
- Listar todos os livros disponíveis
- Buscar livro por ID
- Atualizar informações dos livros
- Remover livros do sistema

### Gerenciamento de Empréstimos
- Registrar empréstimos de livros
- Visualizar todos os empréstimos
- Consultar empréstimos por ID
- Atualizar empréstimo
- Devolver livros

## Estrutura do Banco de Dados

### Tabela de Livros
Armazena informações sobre os livros disponíveis na biblioteca:
- ID
- Título
- Autor
- genero
- ISBN
- ano publicicao
- Status do livro

### Tabela de Empréstimos
Registra os empréstimos realizados:
- ID do empréstimo
- ID do livro
- Data do empréstimo
- Status do empréstimo
- Data da devolução

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Web
- MySQL Driver
- Maven

## Pré-requisitos

- Java 17 instalado
- Maven instalado
- MySQL Server rodando

## Configuração do Banco de Dados

Configure o arquivo `src/main/resources/application.properties` com as credenciais do seu banco MySQL:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/library_db
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

## Como Executar o Projeto

1. Clone o repositório:
   ```bash
   git clone [url-do-repositorio]
   ```
2. Entre na pasta do projeto:
   ```bash
   cd library
   ```
3. Execute o projeto com Maven:
   ```bash
   ./mvnw spring-boot:run
   ```
   O servidor será iniciado em `http://localhost:8080`

## Endpoints da API

### Livros
- `GET /livros` - Lista todos os livros
- `GET /livros/{id}` - Busca um livro específico
- `POST /livros` - Cadastra um novo livro
- `PUT /livros/{id}` - Atualiza um livro existente
- `DELETE /livros/{id}` - Remove um livro

#### Exemplo de requisição para cadastrar livro
```json
{
  "titulo": "Dom Casmurro",
  "autor": "Machado de Assis",
  "genero": "Romance",
  "isbn": "1234567890",
  "anoPublicacao": "1899"
}
```

### Empréstimos
- `GET /emprestimos` - Lista todos os empréstimos
- `GET /emprestimos/{id}` - Busca um empréstimo específico
- `POST /emprestimos` - Registra um novo empréstimo (no corpo precisa do livro_id e dados do leitor)
- `PUT /emprestimos/{id}` - Atualiza um empréstimo existente
- `PUT /emprestimos/{id}/devolver` - Registra a devolução de um livro

#### Exemplo de requisição para registrar empréstimo
```json
{
  "livro": {"id": 1},
  "leitor": "João Silva"
}
```

## Como Rodar os Testes

Execute os testes automatizados com:
```bash
./mvnw test
```

## Contribuição

Contribuições são bem-vindas! Abra uma issue ou envie um pull request.



## Status do Projeto

Finalizado
