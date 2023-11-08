var BASEUUUUUURRRLLLL = "http://85.116.125.155:8080";

$(async function () {
    await thisUser();
});

async function thisUser() {
    // const response = await fetch("http://85.116.125.155:8080/userProfile");
    const response = await fetch(BASEUUUUUURRRLLLL + "/userProfile2");



    // const response = await fetch("http://85.116.125.155:8080/userProfile?" + Date.now());

    const data = await response.json();
    voprosIdi = data.id;

    let voprosId = $(`<td>${data.id}</td>`);
    let voprosValue = $(`<td>${data.value}</td>`);

    $('#vopros-id').append(voprosId);
    $('#vopros-value').append(voprosValue);



    $('#vopros-image').attr('src', '/images/' + data.id + '.jpg');

    if (voprosIdi === 5011) {
        console.log('tttttttttttuuuuut123123');
        window.location.href = BASEUUUUUURRRLLLL + "/ugadal";
    }
    console.log(data);


}





async function answerYes() {
    const response = await fetch(BASEUUUUUURRRLLLL + "/userProfile2/yes", {
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


    if (voprosId === 5000) {
        console.log('tttttttttttuuuuut');
        window.location.href = BASEUUUUUURRRLLLL + "/ugadalverdo";
    }
    if (voprosId === 5001) {
        console.log('tttttttttttuuuuuta');
        window.location.href = BASEUUUUUURRRLLLL + "/neznayuChto";
    }
    if (voprosId === 5012) {
        console.log('tttttttttttuuuuuta');
        window.location.href = BASEUUUUUURRRLLLL + "/ugadalverdo";
    }

}

// Аналогично для функций answerNo() и answerNone()


async function answerNo() {
    const response = await fetch(BASEUUUUUURRRLLLL + "/userProfile2/no", {
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

    if (voprosId === 5000) {
        console.log('tttttttttttuuuuut');
        window.location.href = BASEUUUUUURRRLLLL + "/ugadalverdo";
    }
    if (voprosId === 5001) {
        console.log('tttttttttttuuuuuta');
        window.location.href = BASEUUUUUURRRLLLL + "/neznayuChto";
    }
    if (voprosId === 5012) {
        console.log('tttttttttttuuuuuta');
        window.location.href = BASEUUUUUURRRLLLL + "/ugadalverdo";
    }
}

async function answerNone() {
    const response = await fetch(BASEUUUUUURRRLLLL + "/userProfile2/nany", {
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
    console.log(data);

    if (voprosId === 5000) {
        console.log('tttttttttttuuuuut');
        window.location.href = BASEUUUUUURRRLLLL + "/ugadalverdo";
    }
    if (voprosId === 5001) {
        console.log('tttttttttttuuuuuta');
        window.location.href = BASEUUUUUURRRLLLL + "/neznayuChto";
    }
    if (voprosId === 5012) {
        console.log('tttttttttttuuuuuta');
        window.location.href = BASEUUUUUURRRLLLL + "/ugadalverdo";
    }


}
