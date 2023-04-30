fetch("https://www.thecolorapi.com/scheme?hex=0047AB&rgb=0,71,171&hsl=215,100%,34%&cmyk=100,58,0,33&format=json&mode=analogic&count=6")
    .then((res) => res.json())
    .then((data) => {
        document.getElementById("btn").addEventListener("click", () => {
           
           console.log(data)
           const hexValue = data.colors
           console.log(hexValue.hex)
           document.getElementById("feed").innerHTML = `
           
            <div class="color-field">
                <img class="color" src=${hexValue[0].image.bare}>
                <p class="color-code">${hexValue[0].hex.value}</p>
            </div>
            <div class="color-field">
                <img class="color" src=${hexValue[1].image.bare}>
                <p class="color-code">${hexValue[1].hex.value}</p>
            </div>
            <div class="color-field">
                <img class="color" src=${hexValue[2].image.bare}>
                <p class="color-code">${hexValue[2].hex.value}</p>
            </div>
            <div class="color-field">
                <img class="color" src=${hexValue[3].image.bare}>
                <p class="color-code">${hexValue[3].hex.value}</p>
            </div>
            <div class="color-field">
                <img class="color" src=${hexValue[4].image.bare}>
                <p class="color-code">${hexValue[4].hex.value}</p>
            </div>
           `
        })
    })
