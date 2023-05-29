const feed = document.getElementById("feed")
const watchList = document.getElementById("watch-list")
const fetchLink = "http://www.omdbapi.com/?apikey=a80cae51&"
const searchPlaceHolder = document.querySelector(".placeholder-search")
const title = document.getElementById("title")
const search = document.querySelector(".search")
let listOfMovies = []

document.getElementById("search-btn").addEventListener("click", () => {
    searchPlaceHolder.classList.add("hide")
    feed.innerHTML = ""
    fetch(`${fetchLink}s=${document.getElementById("search-field").value}`)
        .then(res => res.json())
        .then(data => {
            data.Response == "False" ? feed.innerHTML = `<h1 class="false">Unable to find what you’re looking for. Please try another search.</h1>` : 
            console.log(data)
            for (let i = 0; i < data.Search.length; i++) {
                const imdbID = data.Search[i].imdbID
                fetch(`${fetchLink}i=${imdbID}`)
                    .then(res => res.json())
                    .then(data => {
                        console.log(data)
                        const { Poster, Title, Plot, Genre, Runtime, imdbRating } = data
                        feed.innerHTML += `
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
                                        <h5 class="run-time">${Runtime}</h5>
                                        <h5 class="genre">${Genre}</h5>
                                        <div class="watchlist">
                                            <img id="add-btn" src="images/plus.png">
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

watchList.addEventListener("click", () => {
    watchList.textContent = "Search for movies"
    title.textContent = "My Watchlist"
    search.classList.add("hide")
    feed.innerHTML = ""
    for (let i = 0; i < listOfMovies.length; i++) {
        const {poster, title, plot, rating, runtime, genre} = listOfMovies[i]
        feed.innerHTML += `
            <div class="movie">
                <img class="poster" src="${poster}">
                <div>
                    <div class="first row">
                        <h3>${title}</h3>
                        <div class="rating">
                            <img src="images/star.png">
                            <h6>${rating}</h6>
                        </div>
                    </div>
                    <div class="secound row">
                        <h5 class="run-time">${runtime}</h5>
                        <h5 class="genre">${genre}</h5>
                        <div class="watchlist">
                            <img id="delete-btn" src="images/minus.png">
                            <h5>Watchlist</h5>
                        </div>
                    </div>
                    <p class="plot">${plot}</p>
                </div>
            </div>
        `
    
    }
})

feed.addEventListener("click", (e) => {
    if (e.target.id == "delete-btn"){
        const movieElement = e.target.closest(".movie")
        const movieTitle = movieElement.querySelector("h3").textContent
        listOfMovies = listOfMovies.filter(movie => movie.title !== movieTitle)
        movieElement.remove()
    }else if (e.target.id == "add-movie"){
        feed.innerHTML = ""
        watchList.textContent = "my Watchlist"
        title.textContent = "Find your film"
        searchPlaceHolder.classList.remove("hide")
        search.classList.remove("hide")
        document.querySelector(".false").classList.add("hide")
    }
    feed.querySelectorAll(".movie").length == 0 ? feed.innerHTML = `
    <h1 class="false">Your watchlist is looking a little empty...</h1>
    <div class="go-add-movies">
        <img id="add-movie" src="images/plus.png">
        <h2 class="go">Let’s add some movies!</h2>
    </div>
    `: null
})

feed.addEventListener("click", (e) => {
    if (e.target.id == "add-btn") {
        const movieElement = e.target.closest(".movie")
        const movieElSelector = movieElement.querySelector
        const movie = {
            title: movieElSelector("h3").textContent,
            poster: movieElSelector(".poster").src,
            plot: movieElSelector(".plot").textContent,
            rating: movieElSelector("h6").textContent,
            runtime: movieElSelector(".run-time").textContent,
            genre: movieElSelector(".genre").textContent
        }
        listOfMovies.push(movie)
    }
})


