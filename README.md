# ☕︎ Checkpoint 2 - Microservice and Web Engineering
*Lucas de Lima - RM98632*

API com operações CRUD para controle de Pacientes, Profissionais e Consultas utilizando Java Spring Boot

## 💻 Stack Utilizada

- Java 17/18
- Spring Boot 3.4.4
- Maven
- Dependências:
    - Spring Web
    - Spring DevTools
    - SpringDoc OpenAPI

## 🔧 Instalação
-  Clone o repositório:

```
git clone https://github.com/lucaslimb/checkpoint1.git
```

- Limpe e crie a pasta */target*

```
mvn clean package
```

- Inicie o banco de dados
```
docker run -d \
    --name mysql \
    --rm \
    -e MYSQL_ROOT_PASSWORD=root_pwd \
    -e MYSQL_USER=new_user \
    -e MYSQL_PASSWORD=my_pwd \
    -p 3306:3306 \
    mysql
```

## 🌐 Navegação
-  Execute com **Maven**:

```
mvn spring-boot:run
```

## 📖 Documentação
-  **Swagger**, disponível em:
    - http://localhost:8080/

## 📓 Referências
- https://springdoc.org/
