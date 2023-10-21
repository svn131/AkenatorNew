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


