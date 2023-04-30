fetch("https://www.thecolorapi.com/scheme?hex=0047AB&rgb=0,71,171&hsl=215,100%,34%&cmyk=100,58,0,33&format=json&mode=analogic&count=6")
    .then((res) => res.json())
    .then((data) => {
        document.getElementById("btn").addEventListener("click", () => {
            const apiValue = data.colors
           document.getElementById("feed").innerHTML = `
           
            <div class="color-field">
                <img class="color" src=${apiValue[0].image.bare}>
                <p class="color-code">${apiValue[0].hex.value}</p>
            </div>
            <div class="color-field">
                <img class="color" src=${apiValue[1].image.bare}>
                <p class="color-code">${apiValue[1].hex.value}</p>
            </div>
            <div class="color-field">
                <img class="color" src=${apiValue[2].image.bare}>
                <p class="color-code">${apiValue[2].hex.value}</p>
            </div>
            <div class="color-field">
                <img class="color" src=${apiValue[3].image.bare}>
                <p class="color-code">${apiValue[3].hex.value}</p>
            </div>
            <div class="color-field">
                <img class="color" src=${apiValue[4].image.bare}>
                <p class="color-code">${apiValue[4].hex.value}</p>
            </div>
           `
        })
    })
