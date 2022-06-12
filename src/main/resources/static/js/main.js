/** Date */
let date = new Date();
let year = date.getFullYear();
let span = document.createElement("span");

span.classList.add("year");
const mainFooter = document.querySelector("#site_footer");
span.innerHTML = year;
//mainFooter.appendChild(span);


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
let caretIcon;
/**Description */

caretElements.forEach((element) => {
	element.addEventListener("click", function(){
		let theme = element.parentNode.parentNode.parentNode;
		caretIcon = this.querySelector("i");
		const description = theme.querySelector(".description");
		let isHidden = description.classList.toggle("hidden");
		if(isHidden) {
			caretIcon.classList.remove("fa-caret-up");
			caretIcon.classList.add("fa-caret-down");
		}
		else {
			caretIcon.classList.add("fa-caret-up");
			caretIcon.classList.remove("fa-caret-down");
		}
	});
});

/**Delete Theme */

const deleteButtons = document.querySelectorAll(".delete");

deleteButtons.forEach((btn) => {
	btn.addEventListener("click", (event) => {
		if(!confirm("delete ?")) {
			event.preventDefault();
		}
	});
});

/** Active Link */
const links = document.querySelectorAll(".sidebar a");
let pathname = window.location.pathname;

links.forEach((link) => {
	if(link.getAttribute("href")==pathname) {
		link.classList.add("active");
	}
	else {
		link.classList.remove("active");
	}
});


