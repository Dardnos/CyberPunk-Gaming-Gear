const login = document.querySelector(".login");
const registerLink = document.querySelector(".register-link");
const loginLink = document.querySelector(".login-link");
let firstTimeLocation = document.location.pathname;

registerLink.onclick = () => {
    funnySwitchingButton("/register");
    switchToRegister();
}
    

window.focus()
window.onload = function() {
    document.getElementById('username').focus();
};

loginLink.onclick = () => {
    funnySwitchingButton("/login");
    switchToLogin();
};

function funnySwitchingButton(url) {
    if(document.location.pathname == firstTimeLocation){
        history.pushState(url, null, url);}
    else{history.back();}
}

function switchToLogin() {
    login.classList.remove("register");
}

function switchToRegister() {
    login.classList.add("register");
}

addEventListener("popstate", () => {
    if ((history.state == null ? firstTimeLocation : history.state) == "/register") {login.classList.add("register");}
    else {login.classList.remove("register");}
});

const username = document.getElementById("signUpUsername");
const usernameText = document.getElementById("signUpUsernameText");
const password = document.getElementById("signUpPassword");
const confirmPassword = document.getElementById("confirmSignUpPassword");
const message = document.getElementById("confirmation");
const submitButton = document.getElementById("submitButton");
const termsCheckbox = document.getElementById("termsCheckbox");
function checkPasswordAlike() {
    const regexName = /^([A-Za-z0-9]){2,}$/;
    const regexPass = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$/;

    if (username.value === "") {
        usernameText.classList.remove("password-mismatch");
        usernameText.innerHTML = "Username";
        submitButton.disabled = true;
    } else if (!regexName.test(username.value)){
        usernameText.classList.add("password-mismatch");
        usernameText.innerHTML = "Invalid username, needs to be 2 or more characters and only contain letters and numbers";
        submitButton.disabled = true;
    } else {
        usernameText.classList.remove("password-mismatch");
        usernameText.innerHTML = "Username";
        submitButton.disabled = !termsCheckbox.checked;
    }

    if (password.value === "" || confirmPassword.value === "") {
        message.classList.remove("password-mismatch");
        message.innerHTML = "Confirm password";
        submitButton.disabled = true;
    } else if (password.value !== confirmPassword.value) {
        message.classList.add("password-mismatch");
        message.innerHTML = "Passwords do not match";
        submitButton.disabled = true;
    } else if (!regexPass.test(password.value)){
        message.classList.add("password-mismatch");
        message.innerHTML = "Password must contain at least one uppercase letter, one lowercase letter, one number, and be at least 8 characters long";
        submitButton.disabled = true;
    } else {
    message.classList.remove("password-mismatch");
    message.innerHTML = "New password confirmed";
    submitButton.disabled = !termsCheckbox.checked;
    }
}

username.addEventListener("keyup", checkPasswordAlike);
password.addEventListener("keyup", checkPasswordAlike);
confirmPassword.addEventListener("keyup", checkPasswordAlike);
termsCheckbox.addEventListener("change", checkPasswordAlike);