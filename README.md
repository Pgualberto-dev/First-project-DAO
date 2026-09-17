# Primeiro projeto com Banco de Dados em Java (DAO + JDBC)

Este é um projeto de estudo para praticar acesso a banco de dados com Java, usando o padrão **DAO** e **JDBC** com **MySQL**.

## Objetivo

Implementar operações de CRUD para as entidades:

- **Department**
- **Seller**

seguindo uma arquitetura simples com separação entre entidades, interfaces DAO e implementação JDBC.

## Tecnologias

- Java 21
- Maven
- JDBC
- MySQL Connector/J (`com.mysql:mysql-connector-j:8.4.0`)

## Estrutura do projeto

- `src/main/java/application/Program.java` → classe principal com testes de uso dos DAOs
- `src/main/java/db` → conexão e tratamento de exceções de banco
- `src/main/java/model/entities` → entidades (`Department`, `Seller`)
- `src/main/java/model/dao` → interfaces DAO e `DaoFactory`
- `src/main/java/model/dao/imp` → implementações JDBC dos DAOs

## Configuração do banco

O projeto lê as credenciais a partir de um arquivo **`db.properties`** na raiz do projeto.

Exemplo:

```properties
user=seu_usuario
******
dburl=jdbc:mysql://localhost:3306/seu_banco
useSSL=false
```

> Observação: o `db.properties` está no `.gitignore`, então ele não deve ser versionado.

## Modelo mínimo de tabelas

```sql
CREATE TABLE department (
  Id INT PRIMARY KEY AUTO_INCREMENT,
  Name VARCHAR(60) NOT NULL
);

CREATE TABLE seller (
  Id INT PRIMARY KEY AUTO_INCREMENT,
  Name VARCHAR(60) NOT NULL,
  Email VARCHAR(100) NOT NULL,
  BirthDate DATE NOT NULL,
  BaseSalary DOUBLE NOT NULL,
  DepartmentId INT NOT NULL,
  FOREIGN KEY (DepartmentId) REFERENCES department(Id)
);
```

## Como executar

1. Configure o banco MySQL.
2. Crie as tabelas.
3. Crie o arquivo `db.properties` na raiz do projeto.
4. Execute:

```bash
mvn compile
mvn exec:java -Dexec.mainClass=application.Program
```

## Funcionalidades implementadas

### SellerDao

- `findById`
- `findByDepartment`
- `findAll`
- `insert`
- `update`
- `deleteById`

### DepartmentDao

- `findById`
- `findAll`
- `insert`
- `update`
- `deleteById`
