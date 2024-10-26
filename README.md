# Sistema de Gerenciamento de Instrumentos Musicais 🎻

Este projeto é um sistema de CRUD desenvolvido em Java com o framework Spring Boot para gerenciamento de instrumentos musicais e seus respectivos oficineiros. Ele permite a criação, leitura, atualização e exclusão (CRUD) de instrumentos e a associação com seus oficineiros, com persistência de dados em um banco de dados relacional.

## 📜 Visão Geral do Projeto

O sistema foi desenvolvido com uma arquitetura em camadas, visando manter a organização e separação de responsabilidades. A aplicação é composta por camadas de *Controller*, *Service* e *Repository*, além do uso de *DTOs* para transferir dados de forma mais controlada entre as camadas. O projeto tem uma estrutura modular que facilita o desenvolvimento, manutenção e escalabilidade.

### 🛠 Estrutura do Projeto

- **Spring Boot**: framework utilizado para construir a API REST e configurar o ambiente de execução do projeto.
- **Hibernate e JPA**: usados para gerenciar o mapeamento objeto-relacional e facilitar a persistência de dados.
- **Banco de Dados H2**: um banco de dados relacional leve, ideal para desenvolvimento e testes.
- **Camada de Serviços (Service)**: onde as regras de negócio e manipulação de dados são realizadas antes de persistir ou recuperar dados.
- **Camada de Controladores (Controller)**: define os endpoints da API e lida com as solicitações HTTP.
- **DTOs (Data Transfer Objects)**: utilizados para transferir dados entre a camada de Controller e a camada de Service.

### 📋 Funcionalidades

- CRUD de Instrumentos Musicais:
  - **Criar Instrumento**: permite adicionar um novo instrumento ao banco de dados, com um tempo de aprendizado e um oficineiro associado.
  - **Listar Instrumentos**: exibe todos os instrumentos cadastrados.
  - **Atualizar Instrumento**: permite a modificação de detalhes de um instrumento existente, incluindo a troca de oficineiro associado.
  - **Deletar Instrumento**: remove um instrumento específico do sistema.
  
- CRUD de Oficineiros:
  - **Cadastro de Oficineiro**: adiciona um novo oficineiro ao sistema.
  - **Associação com Instrumentos**: permite associar um oficineiro a um instrumento.

## 📂 Estrutura de Pastas

- **controller**: contém os controladores REST responsáveis por expor os endpoints da aplicação.
- **service**: implementa as regras de negócio e manipulação de dados.
- **repository**: interface que faz a comunicação direta com o banco de dados usando JPA.
- **entity**: define as entidades de dados do projeto, como `Instrumento` e `Oficineiro`.
- **dto**: define os objetos de transferência de dados (*DTOs*), usados para transferir dados entre as camadas de maneira controlada.

### 🗃 Principais Entidades

#### Instrumento

- **`idInstrumento`** (UUID): Identificador único do instrumento.
- **`nomeInstrumento`** (String): Nome do instrumento.
- **`tempoAprendizado`** (int): Tempo estimado para aprender o instrumento.
- **`fotoInstrumento`** (String): URL de uma foto ilustrativa do instrumento.
- **`oficineiro`** (Oficineiro): Oficineiro responsável pelo ensino do instrumento.

#### Oficineiro

- **`idOficineiro`** (UUID): Identificador único do oficineiro.
- **`nomeOficineiro`** (String): Nome do oficineiro.
- **`instrumentos`** (List\<Instrumento>): Lista de instrumentos associados ao oficineiro.

## 🚀 Começando

### Pré-requisitos

- **Java JDK 17** ou superior
- **Maven** para gerenciamento de dependências
- **Git** para versionamento de código
- **Spring Boot** para executar a aplicação

## 📥 Como Clonar o Projeto
Execute os seguintes comandos no terminal para clonar e configurar o projeto:

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/nome-do-projeto.git

# Navegue até a pasta do projeto
cd nome-do-projeto
```

## ⚙️ Configuração do Banco de Dados
Este projeto utiliza o banco de dados **H2**, que já vem embutido no Spring Boot, facilitando o desenvolvimento e testes locais. A configuração pode ser alterada no arquivo `application.properties`.

## ▶️ Executando o Projeto
Para compilar e iniciar o projeto, use o Maven:

```bash
# Compilar o projeto
mvn clean install

# Executar a aplicação
mvn spring-boot:run
```

Após a inicialização, a aplicação estará disponível em http://localhost:8080.

## 🌐 Endpoints Principais
- GET /instrumentos: Retorna a lista de instrumentos.
- POST /instrumentos: Adiciona um novo instrumento.
- GET /instrumentos/{id}: Retorna um instrumento específico pelo ID.
- PUT /instrumentos/{id}: Atualiza os dados de um instrumento específico.
- DELETE /instrumentos/{id}: Remove um instrumento específico.

## 🎯 Comandos Git
Aqui estão alguns dos comandos básicos do Git que podem ser úteis para gerenciar o repositório:

```bash
# Iniciar um novo repositório Git
git init

# Adicionar arquivos ao staging
git add .

# Fazer um commit das alterações
git commit -m "Descrição da alteração"

# Configurar a URL do repositório remoto
git remote add origin https://github.com/seu-usuario/nome-do-projeto.git

# Enviar as alterações locais para o repositório remoto
git push -u origin main

# Para baixar as alterações do repositório remoto
git pull origin main
```
Para ramificar, testar e desenvolver novas funcionalidades:

```bash
# Criar uma nova branch
git checkout -b nova-feature

# Mudar para a branch principal
git checkout main

# Mesclar uma branch com a branch principal
git merge nova-feature
```

## 📚 Documentação Adicional
Para mais informações sobre o Spring Boot e outras tecnologias utilizadas no projeto, consulte:

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Hibernate](https://hibernate.org/orm/documentation/5.4/)
- [JPA](https://docs.oracle.com/javaee/7/tutorial/persistence-intro.htm)

  
## 📜 Licença
Este projeto está licenciado sob a [MIT License](https://opensource.org/licenses/MIT).

## ✨ Contribuições
Contribuições são bem-vindas! Fique à vontade para abrir uma issue ou enviar um pull request.
