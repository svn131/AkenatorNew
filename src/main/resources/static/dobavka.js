$(async function () {
    await thisUser();
});

async function thisUser() {
    const response = await fetch("http://85.116.125.155:8080/dobavka");

    const data = await response.json();

    let voprosId = $(`<td>${data.id}</td>`);
    let voprosValue = $(`<td>${data.value}</td>`);

    $('#vopros-id').append(voprosId);
    $('#vopros-value').append(voprosValue);

    $('#vopros-image').attr('src', '/images/' + data.id + '.jpg');


    console.log(data);


}





async function answerYes() {
    const response = await fetch("http://85.116.125.155:8080/dobavka/yes", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({})
    });

    const data = await response.json();
    voprosId = data.id;

    $('#vopros-value').empty().append(data.value);
    $('#vopros-image').attr('src', '/images/' + data.id + '.jpg');


    if (voprosId === 7007) {
        console.log('tttttttttttuuuuut7007');
        window.location.href = "http://85.116.125.155:8080/myProject";
    }


}

// Аналогично для функций answerNo() и answerNone()


async function answerNo() {
    const response = await fetch("http://85.116.125.155:8080/userProfile/no", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({})
    });

    const data = await response.json();

    // $('#vopros-value').text(data.value);
    $('#vopros-value').empty().append(data.value);
    $('#vopros-image').attr('src', '/images/' + data.id + '.jpg');
    console.log(data);
}

async function answerNone() {
    const response = await fetch("http://85.116.125.155:8080/userProfile/nany", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({})
    });

    const data = await response.json();

    $('#vopros-value').text(data.value);
    $('#vopros-image').attr('src', '/images/' + data.id + '.jpg');
    console.log(data);
}
