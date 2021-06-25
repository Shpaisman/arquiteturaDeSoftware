import core.adapter as adapter
from flask import jsonify
import requests

def get_all_business():

    return jsonify(adapter.get_all_business())
        
def get_id_business(request):
    if 'id' in request.args:
        business_id = request.args.get(
            'id').replace(" ", "").split(",")
    else:
        business_id = []
    if business_id:
        business_id = business_id[0]
    return adapter.get_id_business(business_id)

def get_time_business(start, end):
    return jsonify(adapter.get_time_business(start, end))

def delete_business(id):
    if adapter.delete_business(id):
        return jsonify({"Deleted ID sucessfully": id})

def update_business(id, payload):
    return adapter.update_business(id, payload)
    
def create_business(payload):
    return adapter.create_business(payload)

def login(payload):
    return adapter.login(payload)
