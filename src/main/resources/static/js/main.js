let date = new Date();
let year = date.getFullYear();
let span = document.createElement("span");

span.classList.add("year");
const mainFooter = document.querySelector("#site_footer");
span.innerHTML = year;
mainFooter.appendChild(span);