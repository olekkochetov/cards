let date = new Date();
let year = date.getFullYear();
let span = document.createElement("span");

span.classList.add("year");
const mainFooter = document.querySelector("#site_footer");
span.innerHTML = year;
mainFooter.appendChild(span);

let elements = document.querySelectorAll(".center");
//let hidden;
elements.forEach((element, index) => {
	element.addEventListener("click", function(event){
		let hidden = document.querySelector(".hidden");
		element.classList.add("hidden");
		hidden.classList.remove("hidden");
	});	
});
