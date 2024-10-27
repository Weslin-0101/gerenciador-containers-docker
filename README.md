# <strong>Gerenciador de Containers Docker</strong>

## <strong>Descrição</strong>

O intuito desse projeto é para estudo e aprender sobre como poderia criar uma Dashboard para gerenciar os containers
do Docker, utilizando a API do Docker.

O projeto consiste em uma aplicação web que se comunica com a API do Docker. As suas funcionalidades são:

- Listar os containers em execução
- Listar as imagens disponíveis
- Criar um novo container
- Parar um container
- Iniciar um container
- Remover um container

Vale lembrar que para que a aplicação funcione é necessário que o Docker esteja instalado e em execução em sua máquina.

## <strong>Como executar</strong>

A aplicação foi feita usando **Java 17** e **Spring Boot 3.3.5**. Para executar a aplicação basta clonar o projeto e executar a
aplicação a partir da sua própria IDE.

Sempre bom executar o comando para buildar o projeto antes de executar a aplicação:

```
mvn clean install
```