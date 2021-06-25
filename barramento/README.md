Projeto de arquitetura baseada em micro serviços


### Instruções

Installar o Poetry para instalar as dependências do projeto.

```bash

pip install poetry
poetry install

```

### Servidor

```bash

export FLASK_APP=barramento.web.routes
export FLASK_ENV=development
poetry run flask run 

```
