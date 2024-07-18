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
   mvn clean build / mvnw clean build
   execute o ClientAplication.java como um ficheiro java 

2. Executar os testes:
   mvn test /mvnw test

## Query executada no pgAdmin4 (PostgreSQL)

CREATE TABLE IF NOT EXISTS public.cliente
(
    id integer NOT NULL,
    nome character varying(20) COLLATE pg_catalog."default" DEFAULT NULL::character varying,
    nif character varying(9) COLLATE pg_catalog."default" DEFAULT NULL::character varying,
    morada character varying(50) COLLATE pg_catalog."default" DEFAULT NULL::character varying,
    telefone character varying(9) COLLATE pg_catalog."default" DEFAULT NULL::character varying,
    CONSTRAINT cliente_pkey PRIMARY KEY (id)
)