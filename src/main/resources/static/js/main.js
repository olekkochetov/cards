/** Date */
let date = new Date();
let year = date.getFullYear();
let span = document.createElement("span");

span.classList.add("year");
const mainFooter = document.querySelector("#site_footer");
span.innerHTML = year;
mainFooter.appendChild(span);


/**
 * Flip Card
 */

let elements = document.querySelectorAll(".center");
//let hidden;
elements.forEach((element, index) => {
	element.addEventListener("click", function(event){
		let hidden = document.querySelector(".hidden");
		element.classList.add("hidden");
		hidden.classList.remove("hidden");
	});	
});

/**Caret */
const caretElements = document.querySelectorAll(".caret");

/**Description */

caretElements.forEach((element) => {
	element.addEventListener("click", function(){
		let theme = element.parentNode.parentNode.parentNode;
		console.log(theme);
		const description = theme.querySelector(".description");
		description.classList.toggle("hidden");
	});
});

/**Delete */

const deleteButtons = document.querySelectorAll(".delete");

deleteButtons.forEach((btn) => {
	btn.addEventListener("click", (event) => {
		if(!confirm("delete ?")) {
			event.preventDefault();
		}
	});
});



