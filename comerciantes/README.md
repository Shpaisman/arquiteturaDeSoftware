# Comando para subir uma imagem postgres (Docker):

docker run --name postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=postgres -p 5432:5432 -d postgres
Obs: Se o postgres já estiver instalado, certificar que existe um schema "public". 

<h1>Para 'buildar' entre na pasta raiz do projeto e digite:</h1>

mvn clean package install -DskipTests

obs: maven previamente instalado na maquina

<h1>Para rodar entre na pasta target e digite:</h1>

java -jar comerciantes-0.0.1-SNAPSHOT.jar

<h1>Para testar no insomnia importar o json abaixo para dentro do app:</h1>

<a href="https://drive.google.com/u/0/uc?id=1yr4iO5R6l-_bLSv5QG5ALYDHhYnm3Gjf&export=download">Download json</a>

<h1>Swagger</h1>
http://localhost:8080/swagger-ui/#/