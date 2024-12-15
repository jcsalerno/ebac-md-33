# Projeto EBAC MD-33

Este projeto demonstra o uso do **Spring Boot** com **JPA (Jakarta Persistence)** para gerenciar um sistema de carros, marcas, detalhes e acessórios. Inclui operações para salvar dados no banco de dados e exibir as relações entre as entidades.

## Tecnologias Utilizadas
- **Java 23**
- **Spring Boot**
- **Jakarta Persistence (JPA)**
- **PostgreSQL** (ou outro banco de dados relacional configurado)
- **Maven**

## Estrutura do Projeto

### Entidades
1. **Marca**: Representa a marca de um carro.
2. **Carro**: Contém informações sobre o modelo, marca, detalhes e acessórios.
3. **Detalhe**: Inclui atributos como cor e tipo de combustível.
4. **Acessório**: Lista de acessórios associados aos carros.

### Relacionamentos
- **Marca** (1:N) **Carro**
- **Carro** (1:1) **Detalhe**
- **Carro** (N:N) **Acessório** (com tabela intermediária `carro_acessorio`)

## Configuração do Projeto

1. Clone o repositório:
   ```bash
   git clone <URL-do-repositorio>
   ```

2. Configure o arquivo `application.properties` com as credenciais do seu banco de dados:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/ebac_db
   spring.datasource.username=<seu-usuario>
   spring.datasource.password=<sua-senha>
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.format_sql=true
   ```

3. Compile e execute o projeto:
   ```bash
   ./mvnw spring-boot:run
   ```

## Uso do Sistema

### 1. Salvar Dados
Os dados iniciais são salvos automaticamente através do componente `SalvarDados`. Este é um exemplo de inicialização no Spring Boot usando `CommandLineRunner`:

```java
@Bean
public CommandLineRunner run(SalvarDados salvarDados) {
    return args -> {
        salvarDados.salvarDados();
    };
}
```

O método `salvarDados` cria e persiste os seguintes dados:
- Marca: **Toyota**
- Carro: **Corolla** com:
    - Detalhe: Cor **Preto**, Combustível **Gasolina**
    - Acessórios: **Ar-condicionado**, **Airbag**

### 2. Consultar Dados
Utilize os seguintes comandos SQL para verificar os dados no banco:

#### Listar marcas:
```sql
SELECT * FROM marca;
```

#### Listar carros:
```sql
SELECT * FROM carro;
```

#### Listar detalhes dos carros:
```sql
SELECT * FROM detalhe;
```

#### Listar acessórios:
```sql
SELECT * FROM acessorio;
```

#### Listar relação carro-acessório:
```sql
SELECT * FROM carro_acessorio;
```

#### Carros com suas marcas:
```sql
SELECT c.id AS carro_id, c.modelo, m.nome AS marca
FROM carro c
JOIN marca m ON c.marca_id = m.id;
```

#### Carros com seus detalhes:
```sql
SELECT c.id AS carro_id, c.modelo, d.cor, d.combustivel
FROM carro c
JOIN detalhe d ON c.detalhe_id = d.id;
```

#### Carros com seus acessórios:
```sql
SELECT c.id AS carro_id, c.modelo, a.descricao AS acessorio
FROM carro c
JOIN carro_acessorio ca ON c.id = ca.carro_id
JOIN acessorio a ON ca.acessorio_id = a.id;
```

## Personalização
Para adicionar novos dados ou alterar a lógica, edite o método `salvarDados` na classe `SalvarDados`.



