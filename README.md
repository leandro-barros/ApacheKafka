<h1 style="text-align: center; font-weight: bold;">ApacheKafka</h1>

<p align="center">
  <img alt="GitHub top language" src="https://img.shields.io/github/languages/top/leandro-barros/ApacheKafka.svg">

  <img alt="GitHub language count" src="https://img.shields.io/github/languages/count/leandro-barros/ApacheKafka.svg">

  <img alt="Repository size" src="https://img.shields.io/github/repo-size/leandro-barros/ApacheKafka.svg">
  
  <a href="https://github.com/leandro-barros/rabbitmq-springAMQP/commits/master">
    <img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/leandro-barros/ApacheKafka.svg">
  </a>

  <a href="https://github.com/leandro-barros/rabbitmq-springAMQP/issues">
    <img alt="Repository issues" src="https://img.shields.io/github/issues/leandro-barros/ApacheKafka.svg">
  </a>

  <img alt="License" src="https://img.shields.io/badge/license-MIT-brightgreen">
</p>

<h4 align="center"> 
	🚧  ApacheKafka ♻️ Concluído 🚀 🚧
</h4>

<p align="center">
 <a href="#-sobre-o-projeto">Sobre o Projeto</a> •
 <a href="#-executar-o-projeto">Executar Projeto</a> • 
 <a href="#-tecnologias">Tecnologias</a> • 
 <a href="#-autor">Autor</a> • 
 <a href="#-licença">Licença</a>
</p>

## 💻 Sobre o projeto

Repositório criado para praticar conhecimentos adquiridos sobre Apache Kafka. Aqui abordamos questões como produtores, consumidores, tópicos, partições, filas. E lógico comunicação assícrono em microsserviços.

## 🚀 Executar o projeto

Este repositório possui APIs RESTful desenvolvidas com Spring Boot, possuindo endpoints expostos para efetuar requisições.

### Pré-requisitos

Para executar os projetos é necessário possuir instalado na máquina as seguintes ferramentas:
[Git](https://git-scm.com), [Java 11](https://aws.amazon.com/pt/corretto/?filtered-posts.sort-by=item.additionalFields.createdDate&filtered-posts.sort-order=desc), [Docker](https://docs.docker.com/desktop/install/windows-install/) e [Postman](https://www.postman.com/). 
Além disto é bom ter um editor para trabalhar com o código como [Intellij](https://www.jetbrains.com/pt-br/idea/).

O Postman é utilizado para executar as requisições. Já o Docker é para criar contâiner com servidor ApacheKafka.

#### 🧭 Rodando projetos do repositório

```bash
# Clone este repositório
$ git clone <https://github.com/leandro-barros/ApacheKafka.git>

# Execute o contâiner Docker com Docker Compose
$ docker-compose up

# Na classe principal de cada projeto execute-o.

# O servidor inciará na porta indicada no arquivo (application.properties) de cada projeto
```

## 🛠 Tecnologias

As seguintes tecnologias foram utilizadas na construção dos projetos:

- [Java 11](https://aws.amazon.com/pt/corretto/?filtered-posts.sort-by=item.additionalFields.createdDate&filtered-posts.sort-order=desc)
- [Apache Kafka](https://kafka.apache.org/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Spring for Apache Kafka](https://docs.spring.io/spring-kafka/reference/html/)
- [MySQL](https://www.mysql.com/downloads/)
- [Maven](https://maven.apache.org/)
- [Docker](https://docs.docker.com/get-docker/)
- [Docker Compose](https://docs.docker.com/compose/)

## 👨‍💻 Autor

<a href="https://www.linkedin.com/in/leandroebarros/">
   <img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/13985064?v=4" width="100px;" alt=""/>
  <br />
  <sub><b>Leandro Barros</b></sub></a> <a href="https://www.linkedin.com/in/leandroebarros/" title="leandro">🚀
</a>

[![Linkedin Badge](https://img.shields.io/badge/-Leandro-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/leandroebarros/)](https://www.linkedin.com/in/leandroebarros/) 
[![Gmail Badge](https://img.shields.io/badge/-leandroedbarros@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:leandroedbarros@gmail.com)](leandroedbarros@gmail.com)

## 📝 Licença

Projeto esta sobe a licença [MIT](./LICENSE).
