const allCharacters = ["A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9","~","`","!","@","#","$","%","^","&","*","(",")","_","-","+","=","{","[","}","]",",","|",":",";","<",">",".","?",
"/"];

const passwordLength = 12
const secoundBtn = document.getElementById("secound-Btn")

document.getElementById("gen-btn").addEventListener("click", () => {
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
    secoundBtn.textContent = getRandomPassword()
    document.getElementById("third-Btn").textContent = getRandomPassword()
})

secoundBtn.addEventListener("click", () => {
    const copiedPassword = secoundBtn.textContent
    navigator.clipboard.writeText(copiedPassword)     
    secoundBtn.classList.add("button-clicked")
    setTimeout(() => {
        secoundBtn.classList.remove("button-clicked")
    },500)
})




