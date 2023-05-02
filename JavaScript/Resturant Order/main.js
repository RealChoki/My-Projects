import { menuArray } from "./data.js";

const buyForm = document.getElementById("buy-form")
let cartItems = []

document.addEventListener("click", function(e){
    
    if(e.target.dataset.pizza){
        handlePizzaBtn(e.target.dataset.pizza)
    }

    if(e.target.dataset.burger){
        handleBurgerBtn(e.target.dataset.burger)
    }

    if (e.target.dataset.beer){
        handleBeerBtn(e.target.dataset.beer)
    } 

    if(e.target.dataset.id){
        handleRemovebtn(e.target.dataset.id)
    } 
})    

function handlePizzaBtn(pizza){
    const items = menuArray.filter(function(menu){
        return pizza === menu.id
    })[0]
    
    cartItems.push(items)
    getfoodHtml(cartItems)
    
}

function handleBurgerBtn(burger){
    const items = menuArray.filter(function(menu){
        return burger === menu.id
    })[0]
    
    cartItems.push(items)
    getfoodHtml(cartItems)
}

function handleBeerBtn(beer){
    const items = menuArray.filter(function(menu){
        return beer === menu.id
    })[0]
    
    cartItems.push(items)
    getfoodHtml(cartItems)
}

function handleRemovebtn(id){
    const index = cartItems.findIndex(function(item){
        return item.id === id;
    })
    
    cartItems.splice(index, 1);
    getfoodHtml(cartItems)
}


function getfoodHtml(foodMenu){
    let totalPrice = 0
        cartItems.forEach(function(item){
        totalPrice += item.price
    })
    
    let feedHtml = ''
        foodMenu.forEach(function(menu){
        feedHtml +=`
        <div class="buy">
            <h3>${menu.name}</h3>
            <h5 class="remove pointer" data-id="${menu.id}">remove</h5>
            <h4>$${menu.price}</h4>
        </div> 
    `
    })

        feedHtml +=`
        <div class="buymenu">
            <div class="buy fatborder">
                <h3>Total price:</h3>
                <h4 class="price">$${totalPrice}</h4>    
            </div>
            <button id="order" class="pointer">Complete order</button>
        </div>
    `
    document.getElementById("feed").innerHTML = feedHtml
    document.getElementById("order").addEventListener("click",showForm)
    document.getElementById("close-btn").addEventListener("click",closeForm)
    document.getElementById("pay-btn").addEventListener("click",showThanks)
}

function showThanks(){
    const name = document.getElementById("name-input").value
    
    document.querySelector("#thanks h5").textContent =`Thanks, ${name}! Your order is on its way!`
    document.getElementById("thanks").classList.remove("hidden")
    document.querySelector(".buymenu").remove()
    document.querySelectorAll(".buy").forEach(element => element.remove())

    closeForm()
}

function showForm(){
    buyForm.style.display = "inline"
    buyForm.addEventListener("submit", function(e){
        e.preventDefault()
    })
}

function closeForm(){
    buyForm.style.display = "none"
}


