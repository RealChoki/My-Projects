fetch("https://www.thecolorapi.com/scheme?hex=0047AB&rgb=0,71,171&hsl=215,100%,34%&cmyk=100,58,0,33&format=json&mode=analogic&count=6")
    .then((res) => res.json())
    .then((data) => {
        document.getElementById("btn").addEventListener("click", () => {
           data.mode =  document.getElementById("color-schemes").value
           data.colors = document.getElementById("selected-color").value
           const hexValue = data.seed.hex.value
           console.log(hexValue.hex)
           document.getElementById("feed").innerHTML = `
           
            <p class="color-code">${hexValue}</p>
           
           
           `
        })
    })
