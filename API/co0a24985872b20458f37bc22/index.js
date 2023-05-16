document.getElementById("search-btn").addEventListener("click", () => {
    document.querySelector(".placeholder-search").classList.add("hide");
    fetch(`http://www.omdbapi.com/?apikey=a80cae51&s=${document.getElementById("search-field").value}`)
        .then(res => res.json())
        .then(data => {
            console.log(data);
            for (let i = 0; i < 10; i++) {
                const imdbID = data.Search[i].imdbID;
                fetch(`http://www.omdbapi.com/?apikey=a80cae51&i=${imdbID}`)
                    .then(res => res.json())
                    .then(data => {
                        console.log(data);
                        const { Poster, Title, Plot, Genre, Runtime, imdbRating } = data;
                        document.getElementById("feed").innerHTML += `
                            <div class="movie">
                                <img class="poster" src="${Poster}">
                                <div>
                                    <div class="first row">
                                        <h3>${Title}</h3>
                                        <div class="rating">
                                            <img src="images/star.png">
                                            <h6>${imdbRating}</h6>
                                        </div>
                                    </div>
                                    <div class="secound row">
                                        <h5>${Runtime}</h5>
                                        <h5>${Genre}</h5>
                                        <div class="watchlist">
                                            <img src="images/plus.png">
                                            <h5>Watchlist</h5>
                                        </div>
                                    </div>
                                    <p class="plot">${Plot}</p>
                                </div>
                            </div>
                        `
                    })
            }
        })
})

