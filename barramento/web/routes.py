from flask import Flask, request
import web.controllers as controllers

app = Flask(__name__)

auth = False


@app.route('/')
def home_route():
    return "Nothing Here"

@app.route("/login", methods=['POST'])
def login():
    payload = request.json
    jwt = controller.login(payload)
    if jwt:
        global auth
        auth = True    

@app.route("/get_all_business", methods=['GET'])
def get_all_business():
    global auth
    if auth:
        return controllers.get_all_business()
    else:
        return "You are not Authenticated. Please login."

@app.route("/get_id_business", methods=['GET'])
def get_id_business():
    return controllers.get_id_business(request)

@app.route("/get_time_business", methods=['GET'])
def get_time_business():
    start = request.args.get('start_time', None)
    end = request.args.get('end_time', None)
    return controllers.get_time_business(start,end)

@app.route("/delete_business/<id>", methods=['DELETE'])
def delete_business(id):
    return controllers.delete_business(id)

@app.route("/update_business/<id>", methods=['PUT'])
def update_business(id):
    payload = request.json
    return controllers.update_business(id, payload)

@app.route("/create_business", methods=['POST'])
def create_business():
    payload = request.json
    return controllers.create_business(payload)