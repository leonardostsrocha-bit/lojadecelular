## CellStore

Um sistema de gerenciamento de loja de celulares desenvolvido para facilitar o controle e a visualização do catálogo de produtos. A plataforma conta com funcionalidades de cadastro, edição e remoção de produtos, tornando o gerenciamento do estoque mais simples e eficiente.

#### Equipe:

- Ana Luiza de Castro - 1250116586; 
- Luiz Felipe Sousa e Sena - 1250109314;
- Sibelle Mendes Maciel - 1250111964;
- Leonardo Assis Rocha dos Santos - 1250115659;
- Matheus de Oliveira dos Santos - 1260116266; 

#### Tema:

- Sistema de Loja de Celulares.

#### Tecnologias utilizadas:

- Java 21;
- Spring boot;
- Spring Data JPA;
- PostgreSQL;
- Thymeleaf;
- HTML/CSS/JavaScript;
- Docker;

#### Funcionalidades:

##### Listar celulares: 
<img src="https://cdn.discordapp.com/attachments/1085259720920666275/1510702412673974312/image.png?ex=6a1dc6c2&is=6a1c7542&hm=4b9beb6a13adf8781ba12e9a8230287b5fbd93fd43da48cdb41a92759980a37f&" width="1000" height="500" />

##### Adicionar celular:
<img src="https://cdn.discordapp.com/attachments/1085259720920666275/1510702605838586089/image.png?ex=6a1dc6f0&is=6a1c7570&hm=46dc1812449c121bb1445e0ea087a522d3cc5fedf549e25651b2a71790eb4992&" width="1000" height="500" />

##### Remover celular:
<img src="https://cdn.discordapp.com/attachments/1085259720920666275/1510702920637874288/image.png?ex=6a1dc73b&is=6a1c75bb&hm=9dd688a973481e8b9773a83444e25e2faa8b5131763be3d28abd0e291e1f30ba&" width="1000" height="500" />

##### Editar celular:
<img src="https://cdn.discordapp.com/attachments/1085259720920666275/1510703248548429864/image.png?ex=6a1dc789&is=6a1c7609&hm=6411b3373aae287dc8a7f4ab64190e3251f2b8ae6b806ae8cccd32dde8f0ebf7&" width="1000" height="500" />

#### Instruções para execução:

##### Pré-requisitos
- Docker instalado e em execução;

1.Criar a rede Docker

```
docker network create loja-network
```

2.Subir o container do banco de dados

```
docker run -d \
  --name db \
  --network loja-network \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_PASSWORD=postgres \
  -e POSTGRES_DB=backend \
  -p 5432:5432 \
  postgres:latest
```

3.Gerar o arquivo .jar do backend

```
mvn clean package -DskipTests
```

4.Gerar a imagem docker do backend

```
docker build -t lojadecelular:1.0 .
```

5.Subir o container do backend

```
docker run -d \
	--name backend \
	--network loja-network \
	-p 8080:8080 \
	lojadecelular:1.0
```

6.Acessar a aplicação

```
http://localhost:8080/celulares
```
#### Comandos Docker utilizados

| 
 Comando
|
 Descrição
|
|
--
| 
--
|
|
 `docker network create loja-network` 
| 
 Cria a rede para comunicação entre os containers
| 
|
 `docker run ... postgres:latest`
| 
 Sobe o container do PostgreSQL
|
|
 `docker build -t lojadecelular:1.0 .`
|
 Gera a imagem Docker do backend
|
|
 `docker run ... lojadecelular:1.0`
|
 Sobe o container do backend
|
|
 `docker ps`
|
 Lista os containers em execução
|
|
 `docker exec -it db psql -U postgres -d backend -c "\dt"`
|
 Lista as tabelas do banco de dados
|
|
 `docker stop backend db`
| 
 Para os containers
|
|
 `docker rm backend db`
|
 Remove os containers 
| 
