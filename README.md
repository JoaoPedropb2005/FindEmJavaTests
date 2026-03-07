# FindEm

Aplicação Java simples para gerenciar anúncios de animais perdidos, encontrados e para adoção. O sistema inclui funcionalidades básicas de cadastro e login de usuários, publicação de anúncios, favoritar animais e entrar em contato com o dono através de um terminal de linha de comando.

> Esta implementação é voltada para testes e aprendizado; não utiliza banco de dados real — os repositórios armazenam os objetos em memória.

---

## 📁 Estrutura do projeto

```
FindEmJavaTests/
├── pom.xml             # configuração Maven
├── src/main/java/com/mycompany/findem
│   ├── controller/     # camada de controle
│   │   └── AnimalController.java
│   ├── model/          # objetos de domínio e formulários
│   │   ├── CategoriaAnuncio.java
│   │   ├── Especie.java
│   │   ├── FormAnimal.java
│   │   ├── FormCadastro.java
│   │   ├── FormLogin.java
│   │   └── User.java
│   ├── repository/     # repositórios em memória
│   │   ├── AnimalRepository.java (interface)
│   │   └── UserRepository.java
│   ├── service/        # regras de negócio
│   │   ├── AnimalService.java
│   │   ├── CadastroService.java
│   │   └── LoginService.java
│   └── FindEm.java     # classe `main` (exemplo de CLI comentado)
└── src/test/java/com/mycompany/findem/service
    ├── AnimalServiceTest.java
    ├── CadastroServiceTest.java
    └── LoginServiceTest.java
```

O código segue o padrão **MVC**/camadas, com testes unitários usando JUnit 5 e Mockito.

---

## ⚙️ Requisitos

- Java 21 (o `maven.compiler.release` está configurado para 21)
- Apache Maven 3.6+

---

## 🛠️ Compilação e execução

1. **Compilar o projeto**
   ```bash
   mvn clean package
   ```
   O artefato gerado ficará em `target/FindEm-1.0-SNAPSHOT.jar`.

2. **Executar a aplicação (CLI)**
   ```bash
   # se preferir usar o plugin exec, adicione o plugin ao POM ou execute:
   java -cp target/FindEm-1.0-SNAPSHOT.jar com.mycompany.findem.FindEm
   ```

   > Observação: a classe `FindEm` contém um exemplo de fluxo interativo que está atualmente comentado;
   > basta descomentar o código para testar a interface de linha de comando.

---

## ✅ Testes

Os serviços têm cobertura de testes unitários para as principais regras de validação e autenticação.
Execute-os com:

```bash
mvn test
```

Os pacotes utilizados são:
- `junit-jupiter` (API e engine)
- `mockito-junit-jupiter` para mocks nos testes do `AnimalService`.

---

## ✨ Funcionalidades Principais

- **Cadastro de usuário** com validações (email gmail, senha mínima, confirmação, contato obrigatório)
- **Login/Logout** de usuário com estado interno (`logado`)
- **Publicação de anúncios de animais** (perdido/encontrado/adoção) com validações de campos obrigatórios
- **Listagem** de anúncios e visualização de detalhes
- **Favoritar** animais (usuário deve estar logado)
- **Entrar em contato** com o dono do animal (usuário deve estar logado)

---

## 📦 Dependências

Gerenciadas via Maven (veja `pom.xml`), apenas as bibliotecas de teste estão declaradas explicitamente.

---
