# Exercise_SIBS

## Visão Geral
Esta aplicação é um backend para gerenciar clientes, implementada com Spring Boot. A documentação da API está disponível via Swagger UI.

## Acesso à Aplicação
- **GiutHUB:** [https://github.com/MacarioRodrigues/Exercise_SIBS]
- **Swagger UI:** [https://localhost:8080/swagger-ui.html]

## Tecnologias Utilizadas
- Java 17
- Spring Boot
- PostgreSQL
- Swagger

## Endpoints Principais
- `POST /api/client/guardar`: Salvar um novo cliente.
- `DELETE /api/client/apagar`: Apagar um cliente por ID.
- `GET /api/client/listar`: Listar todos os clientes.
- `GET /api/client/por-nif`: Buscar cliente por NIF.
- `GET /api/client/por-nome`: Buscar uma lista de clientes por nome.

## Executando Localmente
Para rodar a aplicação localmente:
1. Clone o repositório:
   ```sh
   git clone https://github.com/MacarioRodrigues/Exercise_SIBS.git
   cd client
   mvn clean build 
   execute o ClientAplication.java como um ficheiro java 