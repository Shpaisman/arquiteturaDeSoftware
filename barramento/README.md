Projeto de arquitetura baseada em micro serviços


### Instruções

Installar o Poetry para instalar as dependências do projeto.

```bash

pip install poetry
poetry install

```

### Servidor

```bash

export FLASK_APP=web.routes
export FLASK_ENV=development
poetry run flask run 

```


### Variáveis de Ambiente para rodar

```bash

export BUSINESS_PORT=localhost:8080
export CLIENT_PORT=localhost:4000

```