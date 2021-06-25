from flask import Flask, request
import web.controllers as controllers

app = Flask(__name__)

@app.route('/')
def home_route():
    return "Nothing Here"

@app.route("/get_all_business", methods=['GET'])
def get_all_business():
    return controllers.get_all_business(request)

@app.route("/get_id_business", methods=['GET'])
def get_id_business():
    return controllers.get_id_business(request)