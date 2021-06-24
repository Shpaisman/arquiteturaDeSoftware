
const db = require("./sequelize-config")

const Usuario = db.sequelize.define('usuarios', {

    username: {
        type: db.Sequelize.STRING,
        allowNull: false
    },
    email: {
        type: db.Sequelize.STRING,
        allowNull: false
    },
    password: {
        type: db.Sequelize.STRING,
        allowNull: false
    }
    
})

db.sequelize.sync({force: false, alter: true})
 
module.exports = Usuario 