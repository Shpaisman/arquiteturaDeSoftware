import os
import requests
import json


# Portas dos outros serviços
bp = os.getenv('BUSINESS_PORT')
cp = os.getenv('CLIENT_PORT')

def add_business():
    url = "http://localhost:8081/relatorio/comerciante"
    try:
        data = requests.put(url)
    except Exception as err:
        print(f'Other error occurred: {err}')
    else:
        print("Business successfully added.")
        return True


def get_id_business(business_id):
    url = f"http://{bp}/exponegocio/comerciante/{business_id}"

    try:
        response = requests.get(url)
        response.raise_for_status()

    except Exception as err:
        print(f'Other error occurred: {err}')
    else:
        print('Connected. Fetching data')
        
        data = json.loads(response.text)
        return data

def get_all_business():

    url = f"http://{bp}/exponegocio/comerciantes"

    try:
        response = requests.get(url)
        response.raise_for_status()

    except Exception as err:
        print(f'Other error occurred: {err}')
    else:
        print('Connected. Fetching data')
        
        data = json.loads(response.text)
        return data

def get_time_business(start, end):
    url = f"http://{bp}/exponegocio/horarios/{start}&&{end}"
    print(url)
    try:
        response = requests.get(url)
        print(response)
        response.raise_for_status()
    except Exception as err:
        print(f'Other error occurred: {err}')
    else:
        print('Connected. Fetching data')
        
        data = json.loads(response.text)
        return data


def update_business(id, payload):

    url = f"http://{bp}/exponegocio/comerciante/{id}/atualizar"

    try:
        response = requests.put(url, json=payload)
        print('Connected. Updating data')
    except Exception as err:
        print(f'Other error occurred: {err}')
    else:
        print('Connected. Updating data')
        data = json.loads(response.text)
        return data

def delete_business(business_id):

    url = f"http://{bp}/exponegocio/comerciante/{business_id}/deletar"

    try:
        response = requests.delete(url)
        response.raise_for_status()

    except Exception as err:
        print(f'Other error occurred: {err}')
    else:
        print('Connected. Deleting data')
        return True

def create_business(payload):
    url = f"http://{bp}/exponegocio/cadastro"

    try:
        response = requests.post(url, json=payload)
        response.raise_for_status()
    except Exception as err:
        print(f'Other error occurred: {err}')
    else:
        print('Connected. Creating business')
        data = json.loads(response.text)
        add_business()
        return data

def login(payload):
    url = f"http://{cp}/login"

    try:
        response = requests.post(url, json=payload)
        response.raise_for_status()
    except Exception as err:
        print(f'Other error occurred: {err}')
    else:
        print('Connected. Login successful')
        jwt = json.loads(response.text)
        return jwt    