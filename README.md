# ProbeHub

ProbeHub é uma aplicação de plataforma de testes online desenvolvida em Java, utilizando Spring Boot e um banco de dados SQLite. Essa plataforma permite gerenciar usuários e testes, oferecendo endpoints RESTful para realizar operações CRUD completas.

## 🛠️ Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3**
  - Spring Data JPA
  - Spring Web
- **SQLite**
- **Gradle**
- **JUnit 5** para testes
- **Mockito** para mocks nos testes

---

## 🚀 Funcionalidades Principais

### 📋 Gestão de Usuários
- Criar, buscar, atualizar e deletar usuários.

### 📝 Gestão de Testes
- Criar, buscar, atualizar e deletar testes associados a um usuário específico.

---

## 🏃 Executando o Projeto

### Pré-requisitos
- **Java 21+**
- **Gradle**

### Passos

1. Clone o repositório:
   ```bash
   git clone https://github.com/O-Farias/ProbeHub.git
   cd ProbeHub
   ```

2. Compile e execute os testes:
   ```bash
   ./gradlew clean build
   ```

3. Inicie o servidor:
   ```bash
   ./gradlew bootRun
   ```

4. Acesse a aplicação em: [http://localhost:8080](http://localhost:8080)

---

## 🔗 Endpoints

### Usuários
- **GET** `/users`: Lista todos os usuários
- **GET** `/users/{id}`: Busca um usuário pelo ID
- **POST** `/users`: Cria um novo usuário
- **PUT** `/users/{id}`: Atualiza os dados de um usuário
- **DELETE** `/users/{id}`: Remove um usuário

### Testes
- **GET** `/tests`: Lista todos os testes
- **GET** `/tests/{id}`: Busca um teste pelo ID
- **POST** `/tests`: Cria um novo teste
- **PUT** `/tests/{id}`: Atualiza os dados de um teste
- **DELETE** `/tests/{id}`: Remove um teste

---

## 🧪 Testes

Execute os testes com o comando:
```bash
./gradlew test
```
Os testes verificam a funcionalidade de serviços e controladores utilizando JUnit 5 e Mockito.

---

## 📄 Licença

Este projeto está licenciado sob a **MIT License**. Sinta-se à vontade para usá-lo e modificá-lo.

---

