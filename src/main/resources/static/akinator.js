$(async function () {
    await thisUser();
});

async function thisUser() {
    const response = await fetch("http://85.116.125.155:8080/userProfile");
    // const response = await fetch("http://85.116.125.155:8080/userProfile?" + Date.now());

    const data = await response.json();

    let voprosId = $(`<td>${data.id}</td>`);
    let voprosValue = $(`<td>${data.value}</td>`);

    $('#vopros-id').append(voprosId);
    $('#vopros-value').append(voprosValue);

    // $("#vopros-image").attr("src", "images/" + data.id + ".jpg");

    $('#vopros-image').attr('src', '/images/' + data.id + '.jpg');


    console.log(data);


}





async function answerYes() {
    const response = await fetch("http://85.116.125.155:8080/userProfile/yes", {
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
        window.location.href = "http://85.116.125.155:8080/ugadal";
    }
    if (voprosId === 5001) {
        console.log('tttttttttttuuuuuta');
        window.location.href = "http://85.116.125.155:8080/neznayuChto";
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
    voprosId = data.id;

    // $('#vopros-value').text(data.value);
    $('#vopros-value').empty().append(data.value);
    $('#vopros-image').attr('src', '/images/' + data.id + '.jpg');

    if (voprosId === 5000) {
        console.log('tttttttttttuuuuut');
        window.location.href = "http://85.116.125.155:8080/ugadal";
    }
    if (voprosId === 5001) {
        console.log('tttttttttttuuuuuta');
        window.location.href = "http://85.116.125.155:8080/neznayuChto";
    }
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
