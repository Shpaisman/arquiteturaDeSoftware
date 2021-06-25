from flask import Flask 
import web.controllers as controllers

app = Flask(__name__)

app.config["JWT_SECRET_KEY"] = "secret" 
jwt = JWTManager(app)

@app.route('/')
def home_route():
    return "Nothing Here"

@app.route("/get_all_business", methods=['GET'])
def create_business():
    return controllers.get_current_customer()

@app.route("/get_id_business", methods=['GET'])
def create_business(id):
    return controllers.get_current_customer(request, id)