document.getElementById("search-btn").addEventListener("click", ()=>{
    fetch("http://www.omdbapi.com/?apikey=a03264ab")
    .then(res => res.json())
    .then(data => console.log(data))
})
