const userPasswordInputBox = document.getElementById("user-password-inputobox");
const emailErrorMsg = document.getElementById("email-error-msg-p");
const forgotPasswordDiv = document.getElementById("forgot-password-link");
const passwordErrorMsg = document.getElementById("password-error-msg-p");
const userEmailInputBox = document.getElementById("user-email-inputobox");
const userSubmitBtn = document.getElementById("user-submit-button");
const url = new URL("http://localhost:8080/user/get");
var isEmailInputBoxEmpty = false;
var isPasswordInputBoxEmpty = false;
var userGetStatus;
//TODO
/**
 *The display of forgot password div, will be "display FLEX" when the user will try
 to  login and miss his login data, but, by default it will be none
 */

userSubmitBtn.addEventListener("click",()=>{ submitUser()});

function submitUser() {
  if (userEmailInputBox.value !== "" && userPasswordInputBox.value !== "") {
    console.log("a")
    url.search = new URLSearchParams(getUserDataObject()).toString();
    sendToServerGETRequest();
  }
}

function getUserDataObject() {
  const userData = {
    userEmail: userEmailInputBox.value,
    userPassword: userPasswordInputBox.value
  }
  return userData;
}
getSome()
function getSome(){
  console.log("Entrando")
  const url = new URL("http://localhost:8080/user/getcookie");
  fetch(url, { method: "GET", headers: { "content-Type": "application/json" } })
  .then(serverResponse =>serverResponse.text())
  .then(data=>{
    console.log(data)
    console.log(document.cookie)
  })
}
function sendToServerGETRequest() {
  fetch(url, { method: "GET", headers: { "content-Type": "application/json" } })
    .then(serverResponse =>serverResponse.json())
    .then(data=>{
userGetStatus=data;
console.log(userGetStatus.user.userEmail)
    });
    
//  .catch(error)
}

/**
 * Este método, verifica se o usuário preencheu quaiquer dado na input box, se ele não
 * for a preencher, o método irá disparar uma mensagem vermelha e deixará a borda esquerda
 * da input box vermelha...
 * Caso contrário, irá reverter as acções
 * @param {Input box} inputBoxElement
 * @param {Mensagem abaixo da input box} inputBoxElementMsg
 * @param {variável que define se o usuário escreveu pela primeira vez} isInputBoxEmpty
 */
function isUserWroteFirstTime(inputBoxElement,inputBoxElementMsg,isInputBoxEmpty) {
  if (isInputBoxEmpty) {
    if (inputBoxElement.value === "") {
      inputBoxElement.style.borderColor = "red";
      toggleDisplay(inputBoxElementMsg, "block");
    } else {
      //userSubmitBtnStyle();
      inputBoxElement.style.borderColor = "var(--blue-color)";
      toggleDisplay(inputBoxElementMsg, "none");
    }
  }
}

/**
 * Este método faz a troca de display das mensagens abaixo das input boxes
 * @param {Mensagem abaixo da input box} element
 * @param {Tipo de display(none ou block)} displayType
 */
function toggleDisplay(element, displayType) {
  element.style.display = displayType;
}

//EVENTS
userEmailInputBox.addEventListener("input", () => {isUserWroteFirstTime(userEmailInputBox, emailErrorMsg, isEmailInputBoxEmpty);});
userPasswordInputBox.addEventListener("input", () => {isUserWroteFirstTime(userPasswordInputBox,passwordErrorMsg,isPasswordInputBoxEmpty);});
userEmailInputBox.addEventListener("mouseleave", () => {isUserWroteFirstTime(userEmailInputBox, emailErrorMsg, isEmailInputBoxEmpty);});
userPasswordInputBox.addEventListener("mouseleave", () => {isUserWroteFirstTime(userPasswordInputBox,passwordErrorMsg,isPasswordInputBoxEmpty);});
userEmailInputBox.addEventListener("click", () => {isEmailInputBoxEmpty = true;});
userPasswordInputBox.addEventListener("click", () => {isPasswordInputBoxEmpty = true;});
