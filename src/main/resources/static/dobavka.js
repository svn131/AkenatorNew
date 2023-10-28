var BASEUUUUUURRRLLLL = "http://85.116.125.155:8080";


$(async function () {
    await thisUser();
});

async function thisUser() {
    const response = await fetch(BASEUUUUUURRRLLLL + "/dobavka");

    const data = await response.json();

    let voprosId = $(`<td>${data.id}</td>`);
    let voprosValue = $(`<td>${data.value}</td>`);

    $('#vopros-id').append(voprosId);
    $('#vopros-value').append(voprosValue);

    $('#vopros-image').attr('src', '/images/' + data.id + '.jpg');


    console.log(data);


}





async function answerYes() {
    const response = await fetch(BASEUUUUUURRRLLLL + "/dobavka/yes", {
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
        window.location.href = BASEUUUUUURRRLLLL + "/new_game";
    }


}

// Аналогично для функций answerNo() и answerNone()


async function answerNo() {
    const response = await fetch(BASEUUUUUURRRLLLL + "/dobavka/no", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({})
    });

    const data = await response.json();
    voprosId = data.id;

    // $('#vopros-value').text(data.value);
    $('#vopros-value').empty().append(data.value);
    $('#vopros-image').attr('src', '/images/' + data.id + '.jpg');

    if (voprosId === 7007) {
        console.log('tttttttttttuuuuut7007');
        window.location.href = BASEUUUUUURRRLLLL + "/new_game";
    }
}

async function answerNone() {
    const response = await fetch(BASEUUUUUURRRLLLL + "/dobavka/nany", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({})
    });

    const data = await response.json();
    voprosId = data.id;

    $('#vopros-value').text(data.value);
    $('#vopros-image').attr('src', '/images/' + data.id + '.jpg');

    if (voprosId === 7007) {
        console.log('tttttttttttuuuuut7007');
        window.location.href = BASEUUUUUURRRLLLL + "/new_game";
    }
}
