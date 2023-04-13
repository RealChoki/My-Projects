// Remember to import the data and Dog class!
import dog from "./Dog.js"
import dogs from "./data.js"

function getNewDog(){
    return dogs.shift()
}

function render() {
    document.getElementById('feed').innerHTML = teddy.getDogHtml()
}

let teddy = new dog(getNewDog())

render()