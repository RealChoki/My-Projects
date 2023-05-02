import dog from "./Dog.js"
import dogs from "./data.js"

let isWaiting = false

function getNewDog(){
    if(dogs.length > 0){
        return dogs[0]
    } 
    
}


function actOnBtnPress(btnid , popupid){
    document.getElementById(btnid).addEventListener('click', function(){
        if (!isWaiting) {
            isWaiting = true;
            handleSwipe(popupid);
            setTimeout(() => {
                isWaiting = false;
            }, 1000);
        }
    })
}

function handleSwipe(popupid){
    document.getElementById(popupid).style.display = "block"
    
    if(dogs.length > 1){
        setTimeout(()=> {
            dogs.shift()
            teddy = new dog(getNewDog())
            render()
        },1000)
    } else if(dogs.length === 1) {
        document.getElementById("footer").style.display = "none"
    }
}

function render() {
    document.getElementById('feed').innerHTML = teddy.getDogHtml()
}

actOnBtnPress("like", "likepop")
actOnBtnPress("dislike", "dislikepop")

let teddy = new dog(getNewDog())

render()