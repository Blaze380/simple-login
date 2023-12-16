const button1 = document.getElementById("button1");
const button2 = document.getElementById("button2");

const data = {
  userId: null,
  userName: "Madumane",
  userBirthDate: "1952-11-26",
  userPhoneNumber: "853195222",
  userEmail: "focalist@gmail.com",
  userPassword: "focalist",
};
const getData = {
  userEmail: "blaze@gmail.com",
  userPassword: "blazeland",
}

const url = new URL("http://localhost:8080/user/get");
url.search = new URLSearchParams(getData).toString();

button1.addEventListener("click", () => { postResponse(); });
button2.addEventListener("click", () => { getResponse(); });

function postResponse() {
  fetch("http://localhost:8080/user/post", {
    method: "POST",
    headers: { "content-Type": "application/json" },
    body: JSON.stringify(data),
  })
    .then((response) => response.json())
    .then((data) => {
      console.log("Data was posted?: ", data);
    })
    .catch((error) => {
      console.error("error: ", error);
    });
}

function getResponse() {
  fetch(url, {
    method: "GET",
    headers: { "content-Type": "application/json" },
  }
  ).then(response => response.json()).then(data => { console.log("Data: ", data) })
}
