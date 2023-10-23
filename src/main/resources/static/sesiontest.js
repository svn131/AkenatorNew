const randomNumber = document.getElementById("randomNumber");
randomNumber.innerText = getCookie("session_id");



function getCookie(name) {
    const cookies = document.cookie.split("; ");
    for (let i = 0; i < cookies.length; i++) {
        const cookie = cookies[i].split("=");
        if (cookie[0] === name) {
            return cookie[1];
        }
    }
    return "";
}

// Функция для отправки запроса на сервер с идентификатором сессии
function sendRequest() {
    const sessionId = getCookie("session_id");

    // Отправка AJAX-запроса на сервер
    const xhr = new XMLHttpRequest();
    xhr.open("POST", "http://85.116.125.155:8080/userProfile/sesionnn", true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
            // Обработка ответа от сервера
            const response = JSON.parse(xhr.responseText);
            // Выполнение необходимых действий с полученными данными
            console.log(response);
            // document.getElementById("vopros-value").innerText = response.value;
            document.getElementById("vopros-value").innerText = response.value;

        }
    };
    xhr.send(JSON.stringify({ sessionId: sessionId }));
    // $('#vopros-value').empty().append(data.value);

}
