const allCharacters = ["A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9","~","`","!","@","#","$","%","^","&","*","(",")","_","-","+","=","{","[","}","]",",","|",":",";","<",">",".","?",
"/"];

const passwordLength = 12

let generateButton = document.getElementById("gen-btn")
let generatePassword1 = document.getElementById("secound-Btn")
let generatePassword2 = document.getElementById("third-Btn")

generateButton.addEventListener("click", function(){

function getRandomCharacter(){
    let randomCharacter = Math.floor(Math.random()* allCharacters.length)
    return allCharacters [randomCharacter]
}
    
function getRandomPassword(){
    let randomPassword = ""
    for (let i = 0; i < passwordLength; i++){
    randomPassword += getRandomCharacter() 
    }
    return randomPassword
}
    generatePassword1.textContent = getRandomPassword()
    generatePassword2.textContent = getRandomPassword()
    
})

generatePassword1.addEventListener("click", function(){
    generatePassword1.ariaSelected()
    generatePassword1.selectionRange
})





