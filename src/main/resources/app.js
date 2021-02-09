const input = document.querySelector('.formInput');
const anchor = document.querySelector('.anchor');
const button = document.querySelector('.submitButton');

const displayShortenedUrl = (shortenedUrl) => {
    let urlDiv = document.createElement('div');
    urlDiv.innerText = "Shortened Url: " + shortenedUrl;
    anchor.appendChild(urlDiv);
}

button.addEventListener('click', () => {
    fetch("http://localhost:8080/", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(input)
    })
    .then(response => response.json())
    .then(jsonReponse => displayShortenedUrl(jsonReponse))
    .catch(err => console.error(err));
})
