$(async function () {
    await thisUser();
});

async function thisUser() {
    const response = await fetch("http://85.116.125.155:8080/conec");

    const data = await response.json();


    let voprosValue = $(`<td>${data.value}</td>`);


    $('#vopros-value').append(voprosValue);





    console.log(data);


}





async function answerYes() {
    const response = await fetch("http://85.116.125.155:8080/conec/yes", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({})
    });

    const data = await response.json();
    voprosId = data.id;



    if (voprosId === 5000) {
        console.log('tttttttttttuuuuut');
        window.location.href = "http://85.116.125.155:8080/myProject";
    }


}

// Аналогично для функций answerNo() и answerNone()


async function answerNo() {
    const response = await fetch("http://85.116.125.155:8080/conec/no", {
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



    console.log('dataNo');
}

async function sendData() {
    const userInput = document.getElementById("userInput").value;

    const response = await fetch("http://85.116.125.155:8080/conec/no", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ input: userInput })
    });

    const data = await response.json();
    voprosId = data.id;

    $('#vopros-value').empty().append(data.value);

    console.log('dataaa');

    if (voprosId === 5000) {
        console.log('tttttttttttuuuuut');
        window.location.href = "http://85.116.125.155:8080/myProject";
    }else if (voprosId === 5005){
        console.log('tttttttttttuuuuut5005');
        window.location.href = "http://85.116.125.155:8080/newSuhnost";
    }

}
