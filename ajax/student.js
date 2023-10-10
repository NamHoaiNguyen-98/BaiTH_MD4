function displayClassroom() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/classrooms",
        success: function (data) {
            let content = "";
            for (let i = 0; i < data.length; i++) {
                content += `<option value = ${data[i].id}>${data[i].name}</option>`;
            }
            document.getElementById("classroom").innerHTML = content;
        }
    })
}

function displayStudent() {
    displayClassroom();
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/students",
        success: function (data) {
            let content = "<table border='1' <tr>" +
                ' <th>#</th></td>\n' +
                ' <th>Name</th></td>\n' +
                ' <th>DateOfBirth</th></td>\n' +
                ' <th>Email</th></td>\n' +
                ' <th>Address</th></td>\n' +
                ' <th>Phone</th></td>\n' +
                ' <th>Classroom</th></td>\n' +
                ' <th colspan="3">Option</td>\n' +
                ' </tr>';

            for (let i = 0; i < data.length; i++) {
                content += `<tr>
               <td> ${data[i].id}</td>
               <td>${data[i].name}</td>
               <td>${data[i].dob}</td>
               <td>${data[i].email}</td>
               <td>${data[i].address}</td>
               <td>${data[i].phone}</td>
               <td>${data[i].classroom.name}</td>
               <td><button onclick="findById(${data[i].id})">Edit</button></td>
               <td><button onclick="deleteCity(${data[i].id})">Delete</button></td></tr>
                <tr></tr>`;
            }
            content += "</table>"
            document.getElementById("students").innerHTML = content;
        }
    })
}

function findById(id) {
    $.ajax({
        type : "GET",
        url :`http://localhost:8080/api/students/${id}`,
        success : function (data) {
            $("#name").val(`${data.name}`);
            $("#email").val(`${data.email}`);
            $("#dob").val(`${data.dob}`);
            $("#address").val(`${data.address}`);
            $("#phone").val(`${data.phone}`);
            $("#classroom").val(`${data.classroom.id}`);
            localStorage.setItem("idUpdate", data.id);
        }
    })

}
function saveStudent() {
    let newStudent;
    let name = $("#name").val();
    let email = $("#email").val();
    let dob = $("#dob").val();
    let address = $("#address").val();
    let phone = $("#phone").val();
    let idClassroom = $("#classroom").val();
    let id = +localStorage.getItem("idUpdate");

    if (id !== 0) {
        newStudent = {
            id : id,
            name : name,
            email : email,
            dob : dob,
            address : address,
            phone : phone,
            classroom : {
                id : idClassroom
            }

        }
    } else {
        newStudent = {
            name : name,
            email : email,
            dob : dob,
            address : address,
            phone : phone,
            classroom : {
                id : idClassroom
            }
        }
    }
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(newStudent),
        url: "http://localhost:8080/api/students",
        success: function () {
            alert("save success")
            displayStudent();
            localStorage.setItem("idUpdate", "0")

        }
    })


    event.preventDefault();
}
function deleteCity(id) {
    if (confirm("Bạn có muốn xóa không")) {
        $.ajax({
            url: `http://localhost:8080/api/students/${id}`,
            type: "DELETE",
            success: function () {
                alert("Delete success!")
                displayStudent()
            }
        });
    }
}

function searchByName() {
    let name = $("#search").val();
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/api/students/search/${name}`,
        success: function (data) {
            let content = "<table border='1' <tr>" +
                ' <th>#</th></td>\n' +
                ' <th>Name</th></td>\n' +
                ' <th>DateOfBirth</th></td>\n' +
                ' <th>Email</th></td>\n' +
                ' <th>Address</th></td>\n' +
                ' <th>Phone</th></td>\n' +
                ' <th>Classroom</th></td>\n' +
                ' <th colspan="3">Option</td>\n' +
                ' </tr>';

            for (let i = 0; i < data.length; i++) {
                content += `<tr>
               <td> ${data[i].id}</td>
               <td>${data[i].name}</td>
               <td>${data[i].dob}</td>
               <td>${data[i].email}</td>
               <td>${data[i].address}</td>
               <td>${data[i].phone}</td>
               <td>${data[i].classroom.name}</td>
               <td><button onclick="findById(${data[i].id})">Edit</button></td>
               <td><button onclick="deleteCity(${data[i].id})">Delete</button></td></tr>
                <tr></tr>`;
            }
            content += "</table>"
            document.getElementById("students").innerHTML = content;
        }
    })
event.preventDefault();
}




