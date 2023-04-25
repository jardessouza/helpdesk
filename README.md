<h2>Help Desk API Manager</h2>

O objetivo do projeto Help Desk API Manager é disponibilizar uma API para cadastro de clientes, técnicos e chamados
para uma empresa de uma API REST.

Durante o projeto, são abordados os seguintes tópicos:

* Setup inicial de projeto com o Spring Boot Initialzr.
* Criação de modelo de dados para o mapeamento de entidades em bancos de dados.
* Desenvolvimento de operações de gerenciamento de clientes, técnicos e chamados.
* Desenvolvimento de autenticaçao e autorização de usuários através do Spring Security, e com suporte a JWT.
* Relação de cada uma das operações acima com o padrão arquitetural REST.
* Deploy na Heroku

Para executar o projeto em uma API Client, digite o seguinte comando:

```
https://helpdesk-prodd.herokuapp.com/login
```
Para fazer o login segue abaixo:
```
login: thomas@mail.com
senha: 123
```

Para abrir a documentação (disponibilizada através do Swagger 2) de todas as operações implementadas com o padrão arquitetural REST, acesse o seguinte link abaixo:
```
https://helpdesk-prodd.herokuapp.com/swagger-ui.html
```

Após executar o comando acima, basta apenas abrir o seguinte endereço e visualizar a execução do projeto:

As seguintes ferramentas abaixo são utilizadas como parte do desenvolvimento do projeto:

* Java 11 ou versões superiores.
* Maven 4.0.0 ou versões superiores.
* SDKMan! para o gerenciamento de múltiplcas versões de Java, Maven e Spring Boot.
* Banco de dados H2 como SGBD do nosso projeto (no ambiente Test)
* Banco de dados MySQL como SGBD do nosso projeto (no ambient Dev)
* Intellj IDEA Community Edition.
* Controle de versão GIT.
* Conta no GitHub para o armazenamento do seu projeto na nuvem.
* Postman para execução de testes de integração para a validação de ponta a ponta da API.

