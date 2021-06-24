const express = require ('express')
const bcrypt = require("bcryptjs")
const jwt = require("jsonwebtoken")

const app = express()
app.use(express.json())

const Usuario = require('./entity/Usuario')

const passport = require("passport")
require("./config/auth")(passport)

app.use(passport.initialize())
  
app.post('/usuario', (req, res) => {
  bcrypt.hash(req.body.password, 10, (err, hash)=>{
    Usuario.create({
      username: req.body.username,
      email: req.body.email,
      password: hash
    }).then(function(){
      res.status(201).send({msg: "Usuario criado com sucesso"})
    }).catch(function(erro){
      res.status(400).send({msg: "O seu erro e: " + erro})
    })
  })

});

app.post("/login", 
(req, res, next) => {
  
  passport.authenticate("local", (err, user) => {
    if(err){
      return next(err)
    }
    if(!user){
      return res.send("Senha ou email errados")
    }
    req.login(user, () => {
      const token = jwt.sign({id: req.body.email}, "secret", {expiresIn:600})
      res.send({"resposta": token}).status(200)
    })
  })(req, res, next)
})

app.listen(4000, () => {
    console.log("Microsserviço de usuario executando na porta 4000.")
});

