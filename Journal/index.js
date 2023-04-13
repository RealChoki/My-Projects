const view = document.getElementById("view")

view.addEventListener("click", () =>{
  let feedHtml = ''

  feedHtml = `
    <div class="content grid">
        <img src="images/blog-image-05.png">
        <h5>JULY 23, 2022</h5>
        <h1>Blog three</h1>
        <p>I'm excited to start a new learning journey as a Scrimba Bootcamp student! After several months of learning in the Frontend Developer Career Path.</p>   
    </div> 

    <div class="content grid">
        <img src="images/article-image-03.png">
        <h5>JULY 23, 2022</h5>
        <h1>Blog two</h1>
        <p>I'm excited to start a new learning journey as a Scrimba Bootcamp student! After several months of learning in the Frontend Developer Career Path.</p>  
    </div> 
  
    <div id="last-blog" class="content grid">
        <img src="images/article-image-02.png">
        <h5>JULY 23, 2022</h5>
        <h1>Blog one</h1>
        <p>I'm excited to start a new learning journey as a Scrimba Bootcamp student! After several months of learning in the Frontend Developer Career Path.</p>
    </div>
  `
  view.style.display = "none"
  document.getElementById("last-blog").style.marginBottom = "40px"
  document.getElementById("feed").innerHTML = feedHtml
})

//! nice
