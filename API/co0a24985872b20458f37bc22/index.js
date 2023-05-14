document.getElementById("search-btn").addEventListener("click", ()=>{
    document.querySelector(".placeholder-search").classList.add("hide")
    fetch(`http://www.omdbapi.com/?apikey=a80cae51&s=${document.getElementById("search-field").value}`)
    .then(res => res.json())
    .then(data => {
        console.log(data)
        document.getElementById("feed").innerHTML = `
            <img src="${data.Search[0].Poster}">   
            <h3>${data.Search[0].Title}</h3>
        `
    })
})
