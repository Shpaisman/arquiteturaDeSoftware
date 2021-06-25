import core.adapter as adapter
from flask import jsonify
import requests

def get_all_business():

    return adapter.get_all_business()
        
def get_id_business(request):
    if 'id' in request.args:
        business_id = request.args.get(
            'id').replace(" ", "").split(",")
    else:
        business_id = []
    if business_id:
        business_id = business_id[0]
    return adapter.get_id_business(business_id)

def delete_business(request):
    if 'id' in request.args:
        business_id = request.args.get(
            'id').replace(" ", "").split(",")
    else:
        business_id = []
    if business_id:
        business_id = business_id[0]
    return adapter.delete_business(business_id)
