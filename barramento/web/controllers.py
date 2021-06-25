from flask import jsonify
import requests

def get_all_business():

    url = "localhost:8080/exponegocio/comerciantes"

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
        
