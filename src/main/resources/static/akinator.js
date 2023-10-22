$(async function () {
    await thisUser();
});

async function thisUser() {
    const response = await fetch("http://85.116.125.155:8080/userProfile");
    const data = await response.json();

    let voprosId = $(`<td>${data.id}</td>`);
    let voprosValue = $(`<td>${data.value}</td>`);

    $('#vopros-id').append(voprosId);
    $('#vopros-value').append(voprosValue);

    // $("#vopros-image").attr("src", "images/" + data.id + ".jpg");

    $("#vopros-image").attr("src", "http://85.116.125.155:8080/myProject/images/" + data.id + ".jpg");


}





$(function () {
    const addForm = document.forms["yesForm"];
    addForm.addEventListener("submit", async ev => {
        ev.preventDefault();

        await fetch("http://85.116.125.155:8080/userProfile/yes", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({})
        });
    });
});




$(function () {
    const addForm = document.forms["noneForm"];
    addForm.addEventListener("submit", async ev => {
        ev.preventDefault();

        // Отправляем пустое тело запроса
        await fetch("http://85.116.125.155:8080/userProfile/nany", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({})

            });
    });
});


$(function () {
    const addForm = document.forms["noForm"];
    addForm.addEventListener("submit", async ev => {
        ev.preventDefault();

        // Отправляем пустое тело запроса
        await fetch("http://85.116.125.155:8080/userProfile/no", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({})

            });
    });
});

