//
// $(function () {
//     const addForm = document.forms["newUserForm"];
//     addForm.addEventListener("submit", async ev => {
//         ev.preventDefault();
//
//         // Отправляем пустое тело запроса
//         await fetch("http://localhost:8080/userProfile/nany", {
//             method: 'POST',
//             headers: {
//                 'Content-Type': 'application/json'
//             },
//             body: JSON.stringify({})
//         })
//             .then(() => {
//                 // Сбрасываем форму и выполняем другие действия
//                 addForm.reset();
//                 // Вызываем функцию allUsers(), если она определена
//                 if (typeof allUsers === "function") {
//                     allUsers();
//                 }
//                 // Кликаем на элемент с id nav-adminTable
//                 $('#nav-adminTable').click();
//             });
//     });
// });








// $(async function () {
//     await addUser();
// });
//
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
//         await fetch("adminProfile/newUser/", {
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
