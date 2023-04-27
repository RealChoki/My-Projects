fetch ("https://www.thecolorapi.com/scheme?hex=24B1E0&mode=triad&count=6 || /scheme?rgb=rgb(0,71,171)")
    .then (res => res.json())
    .then (data => {
        console.log(data)
        document.getElementById("feed").innerHTML = `
           <img src="${data}">
        
        
        `


    })

document.getElementById("btn").addEventListener("click", () => {
    console.log("Clicked")
})