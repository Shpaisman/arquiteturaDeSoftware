const localStrategy = require("passport-local").Strategy
const bcrypt = require("bcryptjs")

const Usuario = require("../entity/Usuario");


module.exports = function(passport){

    passport.use(new localStrategy({usernameField: "email"}, (email, password, done)=>{
        Usuario.findOne({where:{email: email}}).then((usuario)=>{
            if(!usuario){
                return done(null, false, {message: "Esta conta nao existe"})
            }
            bcrypt.compare(password, usuario.password, (erro, batem) => {
                if(batem){
                    return done(null, usuario)
                }else{
                    return done(null, false, {message: "Senha incorreta"})
                }
            })
        })        
    }))
} 
