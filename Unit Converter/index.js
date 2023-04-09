/*
1 meter = 3.281 feet
1 liter = 0.264 gallon
1 kilogram = 2.204 pound
*/

let volume = document.getElementById("vlm")
let mass = document.getElementById("mass")
let length = document.getElementById("lgth")
const convert = document.getElementById("convert-btn")
let inputField =document.getElementById("input-fld")

convert.addEventListener("click",function(){
    let calcfeet = inputField.value * 3.281
    let calcmeters = inputField.value / 3.281

    let calcgallons = inputField.value * 0.264
    let calcliters = inputField.value / 0.264

    let calcpounds = inputField.value * 2.204
    let calcmkilos = inputField.value / 2.204
    
    length.textContent = `
        ${inputField.value} meters = ${calcfeet.toFixed(3)} feet |
        ${inputField.value} feet = ${calcmeters.toFixed(3)} meters
    `
    volume.textContent = `
        ${inputField.value} liters = ${calcgallons.toFixed(3)} gallons |
        ${inputField.value} gallons = ${calcliters.toFixed(3)} liters
    `
    mass.textContent = `
        ${inputField.value} kilos = ${calcpounds.toFixed(3)} pounds |
        ${inputField.value} pounds = ${calcmkilos.toFixed(3)} kilos
    `
})



