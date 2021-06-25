import os
import requests


# Portas dos outros serviços
bp = os.getenv('BUSINESS_PORT')
cp = os.getenv('CLIENT_PORT')


def get_id_business(business_id):
    url = f"{bp}/exponegocio/comerciante/{business_id}"

    try:
        response = requests.get(url)
        response.raise_for_status()

    except HTTPError as http_err:
        print(f'HTTP error occurred: {http_err}')  
    except Exception as err:
        print(f'Other error occurred: {err}')
    else:
        print('Connected. Fetching data')
        
        data = json.loads(r.text)
        return data

def get_all_business():

    url = f"{bp}/exponegocio/comerciantes"

    try:
        response = requests.get(url)
        response.raise_for_status()

    except HTTPError as http_err:
        print(f'HTTP error occurred: {http_err}')  
    except Exception as err:
        print(f'Other error occurred: {err}')
    else:
        print('Connected. Fetching data')
        
        data = json.loads(r.text)
        return data

def update_business():
    pass

def delete_business(business_id):
    url = f"localhost:8080/exponegocio/{business_id}/deletar"

    try:
        response = requests.delete(url)
        response.raise_for_status()

    except HTTPError as http_err:
        print(f'HTTP error occurred: {http_err}')  
    except Exception as err:
        print(f'Other error occurred: {err}')
    else:
        print('Connected. Deleting data')
        
        data = json.loads(r.text)
        return data


def create_business():
    pass