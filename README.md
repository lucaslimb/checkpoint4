# ☕︎ Checkpoint 5 - Microservice and Web Engineering
*Lucas de Lima - RM98632*

*Isabella Gomes Menezes - RM552327*

*Martin Hilst - RM99451*

API com operações CRUD para controle de Pacientes, Profissionais e Consultas utilizando Java Spring Boot disponível através de imagem no Dokcer Hub e GitHub Actions para CI/CD

## 💻 Stack Utilizada

- Java 17/18
- Spring Boot 3.4.5
- Maven
- Docker
- Dependências:
    - Spring Web
    - Spring DevTools
    - SpringDoc OpenAPI
    - MySQL Connector
    - Spring Boot Data JPA

## Execução a partir da imagem no Docker Hub

1.  **Crie a rede Docker:**
    ```bash
    docker network create app-networks
    ```

2.  **Inicie o contêiner do banco de dados:**
    ```bash
    docker run -d --name mysql-db --network app-networks -e MYSQL_ROOT_PASSWORD=root_pwd -e MYSQL_DATABASE=api -p 3306:3306 mysql:8.0
    ```

3.  **Inicie o contêiner da API:**
    ```bash
    docker run -d --name checkpoint4-api --network app-networks -p 8080:8080 -e DB_SERVER=mysql-db -e DB_DATABASE=api -e DB_USER=root -e DB_PASSWORD=root_pwd lucaslimb/checkpoint4:latest
    ```

---

### Execução a partir do docker-compose

1.  **Para subir os serviços:**
    ```bash
    docker-compose up -d
    ```

2.  **Para derrubar os serviços:**
    ```bash
    docker-compose down
    ```

---

## 🌐 Acesso ao Swagger

[http://localhost:8080/](http://localhost:8080/)

## 📓 Referências
- https://springdoc.org/
