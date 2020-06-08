# API para cadastro de cliente

Atualmente as inserções são realizadas em um banco em memmória (H2).
Sendo assim, uma vez que for feito shutdown na aplicação, os dados serão perdidos.

### Tecnologias
- Spring Boot
- Spring Security
- JWT
- Java 8

### Pré-requisito

Java 8+
Maven

### Instalando

Entre na raiz do projeto e execute o seguinte comando:

mvn spring-boot:run

O projeto possui autenticação, e os dois usuários:
admin 123456
comum 123456

na pasta resource há um script que insere alguns dados para funcionamento da api.
## Como consumir a API

Há um projeto em React no meu github que faz o consumo dessa api.
Mas também é possível utilizar Postman para tal.


## Autor

Valdelar Martins