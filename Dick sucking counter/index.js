let count = 0

document.getElementById("increment-btn").addEventListener("click",()=>{
    count += 1
    document.getElementById("count-el").textContent = count
}) 

document.getElementById("save-btn").addEventListener("click",()=>{
    let saveEl = document.getElementById("save-el")
    const countStr = count
    if( saveEl.textContent === "Previous amount of dicks sucked:"){
        saveEl.textContent += ` ${countStr} `
    } else{
        saveEl.textContent += `- ${countStr} `
    }
    document.getElementById("count-el").textContent = 0
    count = 0
})


