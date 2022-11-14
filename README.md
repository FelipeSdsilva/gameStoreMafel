![GitHub repo size](https://img.shields.io/github/repo-size/FelipeSdsilva/gameStoreMafel?style=plastic)
# Game Store GamesOn

# Sobre este projeto
![GitHub](https://img.shields.io/github/license/FelipeSdsilva/gameStoreMafel)

## Deploy (Front-End)

https://game-on-omega.vercel.app/

## Deploy (Back-End)

https://mafil-felipeback.herokuapp.com/swagger-ui/index.html

Este trabalho foi em conjunto com Matheus Osterno na parte de front-End da loja GamesOn, e na parte de back-End foi desenvolvido por mim onde foi feito,
um CRUD de Games que contem plataformas e generos.
Link para repositório do DEV Matheus Osterno (https://github.com/MatheusOsterno)  responsável pela parte do front-End.

# Layout Desktop 

Framework utilizado por Matheus Osterno foi o Vue.js onde consiste de componentes que renderizam apartir da div que contem a id="root",

![image](https://user-images.githubusercontent.com/47900701/201556257-f4a1ca68-8b6e-4b6d-b5ba-a2e38d588d11.png)
![image](https://user-images.githubusercontent.com/47900701/201556414-3f22de80-a6af-4dd2-8112-45d63159ce19.png)
![image](https://user-images.githubusercontent.com/47900701/201556179-8bd3e954-4bb3-427e-8592-1d1f63efb42f.png)

# Layout Mobile

Responsividade fluida e bem ótimizada.

![image](https://user-images.githubusercontent.com/47900701/201556721-06639661-f755-4ce7-a595-9d5d90d0baff.png)
![image](https://user-images.githubusercontent.com/47900701/201556757-fc46dcf1-3fd5-46db-8677-dafc740d9cd7.png)

# Modelo Conceitual
Baseado no ManyToMany pois um game tem N generos e N plataforams.

![image](https://user-images.githubusercontent.com/47900701/201555643-38c0b3e4-2091-4266-a4ea-b0253c3e52d8.png)

#Tecnologias usadas.

## Front-End (Matheus Osterno)
  - HTML / CSS / JS / TypeScript
  - Vue.js

## Back-End(Felipe Sousa)
  - Java 17
  - Spring boot
  - JPA / Hibernate
  - Maven
## Implantação de produção
  - Back-End: Heroku
  - Front-End: Vercel
  - Banco de dados: PostgreSQL
  
# Como executar o projeto

## Back-End

Pré-requisitos: Java 17.

```bash
 #clonar repositório.
 git clone https://github.com/FelipeSdsilva/gameStoreMafel
 
 #entrar na pasta backend.
 cd backend
 
 #executar o projeto.
 ./mvnw spring-boot:run
```
## Front-End Web

Pré-requisitos: Node.

```bash
#clonar repositório.
git clone https://github.com/MatheusOsterno/game-store-mf

#instalar depêndencia.
npm install

#executar o projeto.
npm run

```

# Autores

Felipe Sousa 
https://www.linkedin.com/in/felipesdsilva/

Matheus Osterno
https://www.linkedin.com/in/matheus-osterno/
