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
- Atualizar status do empréstimo
- Devolver livros

## Estrutura do Banco de Dados

### Tabela de Livros
Armazena informações sobre os livros disponíveis na biblioteca:
- ID
- Título
- Autor
- ISBN
- Quantidade disponível
- Status do livro

### Tabela de Empréstimos
Registra os empréstimos realizados:
- ID do empréstimo
- ID do livro
- Data do empréstimo
- Data prevista de devolução
- Status do empréstimo
- Data da devolução

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Web
- MySql Driver
- Maven

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

### Empréstimos
- `GET /emprestimos` - Lista todos os empréstimos
- `GET /emprestimos/{id}` - Busca um empréstimo específico
- `POST /emprestimos` - Registra um novo empréstimo(no corpo precisa do livro_id e dados do leitor)
- `PUT /emprestimos/{id}` - Atualiza um empréstimo existente
- `PUT /emprestimos/{id}/devolver` - Registra a devolução de um livro

## Status do Projeto

Em desenvolvimento
