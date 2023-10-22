$(async function () {
    await thisUser();
});

async function thisUser() {
    const response = await fetch("http://localhost:8080/userProfile");
    const data = await response.json();

    let voprosId = $(`<td>${data.id}</td>`);
    let voprosValue = $(`<td>${data.value}</td>`);

    $('#vopros-id').append(voprosId);
    $('#vopros-value').append(voprosValue);

    $("#vopros-image").attr("src", "images/" + data.id + ".jpg");

}





$(function () {
    const addForm = document.forms["yesForm"];
    addForm.addEventListener("submit", async ev => {
        ev.preventDefault();

        // Отправляем пустое тело запроса
        await fetch("http://localhost:8080/userProfile/yes", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({})
        })
            .then(() => {
                // Сбрасываем форму и выполняем другие действия
                addForm.reset();
                // Вызываем функцию allUsers(), если она определена
                if (typeof allUsers === "function") {
                    allUsers();
                }
                // Кликаем на элемент с id nav-adminTable
                $('#nav-adminTable').click();
            });
    });
});



$(function () {
    const addForm = document.forms["noneForm"];
    addForm.addEventListener("submit", async ev => {
        ev.preventDefault();

        // Отправляем пустое тело запроса
        await fetch("http://localhost:8080/userProfile/nany", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({})
        })
            .then(() => {
                // Сбрасываем форму и выполняем другие действия
                addForm.reset();
                // Вызываем функцию allUsers(), если она определена
                if (typeof allUsers === "function") {
                    allUsers();
                }
                // Кликаем на элемент с id nav-adminTable
                $('#nav-adminTable').click();
            });
    });
});


$(function () {
    const addForm = document.forms["noForm"];
    addForm.addEventListener("submit", async ev => {
        ev.preventDefault();

        // Отправляем пустое тело запроса
        await fetch("http://localhost:8080/userProfile/no", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({})
        })
            .then(() => {
                // Сбрасываем форму и выполняем другие действия
                addForm.reset();
                // Вызываем функцию allUsers(), если она определена
                if (typeof allUsers === "function") {
                    allUsers();
                }
                // Кликаем на элемент с id nav-adminTable
                $('#nav-adminTable').click();
            });
    });
});




























// function answerYes() {
//     // Выполняем запрос POST к REST API с информацией о нажатии кнопки "ДА"
//     $.ajax({
//         url: 'http://localhost:8080/userProfile/yes',
//         type: 'POST',
//         data: { answer: 'yes' },
//         success: function(response) {
//             // Обработка успешного ответа от сервера
//         },
//         error: function(error) {
//             // Обработка ошибок
//         }
//     });
// }
//
// function answerNo() {
//     // Выполняем запрос POST к REST API с информацией о нажатии кнопки "НЕТ"
//     $.ajax({
//         url: 'http://localhost:8080/userProfile/no',
//         type: 'POST',
//         data: { answer: 'no' },
//         success: function(response) {
//             // Обработка успешного ответа от сервера
//         },
//         error: function(error) {
//             // Обработка ошибок
//         }
//     });
// }
//
//
// function answerNany() {
//     // Выполняем запрос POST к REST API с информацией о нажатии кнопки "НЕТ"
//     $.ajax({
//         url: 'http://localhost:8080/userProfile/nany',
//         type: 'POST',
//         data: { answer: 'nany' },
//         success: function(response) {
//             // Обработка успешного ответа от сервера
//         },
//         error: function(error) {
//             // Обработка ошибок
//         }
//     });
// }


// $(document).ready(function() {
//     $('#newUserButton').click(async function() {
//         await addUser();
//     });
// });
// async function addUser() {
//     const addForm = document.forms["newUserForm"];
//     addForm.addEventListener("submit", async ev => {
//         ev.preventDefault();
//         const roles = addForm.roles.options;
//         let rolesList = [];
//         for (let i = 0; i < roles.length; i++) {
//             if (roles[i].selected) rolesList.push({
//                 id: roles[i].value,
//                 name: "ROLE_" + roles[i].text
//             });
//         }
//         let body = JSON.stringify({
//             id: addForm.id.value,
//             firstName: addForm.firstName.value,
//             lastName: addForm.lastName.value,
//             age: addForm.age.value,
//             email: addForm.email.value,
//             password: addForm.password.value,
//             roles: rolesList
//         })
//         console.log(body)
//         await fetch( 'http://localhost:8080/userProfile/nany', {
//             method: 'POST',
//             headers: {
//                 'Content-Type': 'application/json'
//             },
//             body: body
//         })
//             .then(() => {
//                 addForm.reset();
//                 allUsers();
//                 $('#nav-adminTable').click();
//             })
//     })
// }