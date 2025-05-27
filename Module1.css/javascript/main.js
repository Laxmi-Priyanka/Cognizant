console.log("Welcome to the Community Portal");

function pageLoaded() {
  alert("Page is fully loaded!");
  displayEvents();
}

const events = [
  { name: "Music Night", date: "2025-06-10", seats: 20, category: "Music" },
  { name: "Art Workshop", date: "2025-06-15", seats: 0, category: "Workshop" },
  { name: "Coding Bootcamp", date: "2025-06-18", seats: 10, category: "Workshop" },
];

// Display Events
function displayEvents(filtered = "All") {
  const eventList = document.getElementById("eventList");
  eventList.innerHTML = "";

  events
    .filter(event => (filtered === "All" || event.category === filtered))
    .forEach(event => {
      if (new Date(event.date) >= new Date() && event.seats > 0) {
        const card = document.createElement("div");
        card.className = "eventCard";
        card.innerHTML = `
          <h3>${event.name}</h3>
          <p>Date: ${event.date}</p>
          <p>Seats Available: ${event.seats}</p>
        `;
        eventList.appendChild(card);

        // Add to form select
        const option = document.createElement("option");
        option.value = event.name;
        option.text = event.name;
        document.querySelector("select[name='event']").appendChild(option);
      }
    });
}

// Filter by category
function filterEvents(category) {
  displayEvents(category);
}

// Handle form submission
document.getElementById("registrationForm").addEventListener("submit", function (e) {
  e.preventDefault();

  const form = e.target;
  const name = form.elements["name"].value;
  const email = form.elements["email"].value;
  const selectedEvent = form.elements["event"].value;

  if (!name || !email || !selectedEvent) {
    document.getElementById("formMessage").textContent = "All fields are required.";
    return;
  }

  document.getElementById("formMessage").textContent = "Thank you for registering!";
  console.log("Registration submitted:", { name, email, selectedEvent });

  // Simulate backend call
  fetch("https://jsonplaceholder.typicode.com/posts", {
    method: "POST",
    body: JSON.stringify({ name, email, event: selectedEvent }),
    headers: {
      "Content-Type": "application/json"
    }
  })
    .then(response => response.json())
    .then(data => console.log("Success:", data))
    .catch(error => console.error("Error:", error));
});

// jQuery usage
$("#registerBtn").click(function () {
  console.log("Register button clicked");
  $("#formMessage").fadeIn().delay(2000).fadeOut();
});
