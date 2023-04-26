fetch ("https://www.thecolorapi.com/id?hex=0047AB&rgb=0,71,171&hsl=215,100%,34%&cmyk=100,58,0,33&format=html")
    .then (res => res.json())
    .then (data => console.log(data))