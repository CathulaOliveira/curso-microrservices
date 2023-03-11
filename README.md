# curso-microrservices
Projeto Avaliador Crédito desenvolvido no curso de microrservices

### Conteúdo do curso

Arquitetura completa de microservices

Módulos Spring Cloud/Boot

Service Discovery com Eureka

Balanceamento de Carga com Api Gateway

Serviço/Fila de Mensageria com RabbitMQ

Authorization Server com Keycloak

**Importante**

No Keycloak precisa ter o Frontend URL = http://cursoms-keycloak:8080 para rodar o projeto todo em docker.

Se for rodar pela IDE o Frontend URL pode ficar vazio.

*Comandos para subir instancias docker:*
```
Criar network -> docker network create cursoms-network  
```
```
Rabbit MQ -> docker run --name cursoms-rabbitmq -p 5672:5672 -p 15672:15672 --network cursoms-network rabbitmq:3.11-management
```
```
Keycloak -> docker run -p 8081:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin --network cursoms-network --name cursoms-keycloak quay.io/keycloak/keycloak:18.0.0 start-dev
```
*Para os demais é preciso fazer o build na pasta de cada modulo*
```
Eureka -> docker build --tag cursoms-eureka .
Eureka -> docker run --name cursoms-eureka -p 8761:8761 --network cursoms-network cursoms-eureka
```
```
Gateway -> docker build -t cursoms-gateway .
Gateway -> docker run --name cursoms-gateway -p 8080:8080 -e EUREKA_SERVER=cursoms-eureka -e KEYCLOAK_SERVER=cursoms-keycloak -e KEYCLOAK_PORT=8080 --network cursoms-network -d cursoms-gateway
```
```
avaliador credito -> docker build --tag cursoms-avaliadorcredito .
avaliador credito -> docker run --name cursoms-avaliadorcredito --network cursoms-network -e RABBITMQ_SERVER=cursoms-rabbitmq -e EUREKA_SERVER=cursoms-eureka -d cursoms-avaliadorcredito
```
```
clientes -> docker build --tag cursoms-clientes . 
clientes -> docker run --name cursoms-clientes --network cursoms-network -e EUREKA_SERVER=cursoms-eureka -d cursoms-clientes

cartoes -> docker build --tag cursoms-cartoes .
cartoes -> docker run --name cursoms-cartoes --network cursoms-network -e RABBITMQ_SERVER=cursoms-rabbitmq -e EUREKA_SERVER=cursoms-eureka -d cursoms-cartoes
```
