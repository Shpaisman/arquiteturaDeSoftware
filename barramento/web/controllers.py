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
        
def get_id_business(request):
    if 'id' in request.args:
        business_id = request.args.get(
            'id').replace(" ", "").split(",")
    else:
        business_id = []
    if business_id:
        business_id = business_id[0]
    return business_id
