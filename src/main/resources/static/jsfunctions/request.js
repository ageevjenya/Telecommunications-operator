function requestAll() {

    //this need for work
    $(function () {
        var token = $("input[name='_csrf']").val();
        var header = "X-CSRF-TOKEN";
        $(document).ajaxSend(function (e, xhr, options) {
            xhr.setRequestHeader(header, token);
        });
    });
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/requests/all",
        dataType: 'json',
        success: function (data) {
            // console.log(data);
            requestTableView(data);
        }
    });

};

function requestTableView(data) {
    let view;
    let color;
    let newLine
    for (let i = 0; i < data.length; i++) {
        if (data[i].active) {
            color = '#FFEBCD'
        } else {
            color = '#E0FFFF';
        }
        newLine =
            "<tr><td>" +
            "<div id='" + data[i].id + "' onclick='requestInformation(this.id)' " +
            "style='background:" + color + ";border: 3px solid #fff; border-radius: 10px;' class='border border-primary p-2'>" +
            "id " + data[i].id + " <br>" +
            data[i].description + " <br> " +
            new Date(Date.parse(data[i].localDateTime)).toLocaleString() +

            "</div>" +
            "</td></tr> \n";
        if (view === undefined) {
            view = "" + newLine;
        } else {
            view = view + newLine;
        }
    }
    // console.log(view);
    $('#requestList').html(view);
};

function requestInformation(idReq) {
    let idRequest = {};
    idRequest["id"] = idReq;
    // console.log(idRequest);
    //this need for work
    $(function () {
        var token = $("input[name='_csrf']").val();
        var header = "X-CSRF-TOKEN";
        $(document).ajaxSend(function (e, xhr, options) {
            xhr.setRequestHeader(header, token);
        });
    });
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/requests/info",
        dataType: 'json',
        data: JSON.stringify(idRequest),
        success: function (data) {
            // console.log(data);
            addInformation(data);
        }
    });
    updateChat(idReq);
};


function addInformation(data) {
    let color;
    let textButton;
    if (data.active) {
        color = '#FFEBCD'
        textButton = 'Закрыть';
    } else {
        color = '#E0FFFF';
        textButton = 'Возобновить';
    }
    let info =
        "<div>" +
        "<span>id заявки " + data.id + "</span><br>" +
        "<span>" + data.description + "</span><br>" +
        "<span>" + new Date(Date.parse(data.localDateTime)).toLocaleString() + "</span><br>" +
        "<span>Данные пользователя:</span><br>" +
        "<span>id пользователя: " + data.user.id + "</span><br>" +
        "<span>username: " + data.user.username + "</span><br>" +

        "<span>" + data.user.lastName + " " + data.user.firstName + " " + data.user.middleName + "</span><br>" +
        "</div>";
    let button = "<button type='button'" +
        "onclick='changeActiveRequest()' class='btn btn-default'>" + textButton + "</button>"


    // console.log(info);

    document.getElementById('idRequest').value = data.id;
    document.getElementById('activeRequest').value = data.active;
    document.getElementById('info').style.background = color;
    document.getElementById('info').innerHTML = info;
    $('#button').html(button);
    document.getElementById('btn-chat').disabled = 0;

};

function changeActiveRequest() {
    let infoRequest = {};
    infoRequest["id"] = $("#idRequest").val();
    infoRequest["active"] = $("#activeRequest").val();

    // console.log(infoRequest);
    //this need for work
    $(function () {
        var token = $("input[name='_csrf']").val();
        var header = "X-CSRF-TOKEN";
        $(document).ajaxSend(function (e, xhr, options) {
            xhr.setRequestHeader(header, token);
        });
    });
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/requests/changeActive",
        dataType: 'json',
        data: JSON.stringify(infoRequest),
        success: function (data) {
            // console.log(data);
            requestAll();
            addInformation(data);
        }
    });
};

function updateChat(idReq) {
    let user;
    $(function () {
        var token = $("input[name='_csrf']").val();
        var header = "X-CSRF-TOKEN";
        $(document).ajaxSend(function (e, xhr, options) {
            xhr.setRequestHeader(header, token);
        });
    });
    $.ajax({
        async: false,
        type: "GET",
        contentType: "application/json",
        url: "/user/auth",
        dataType: 'json',
        success: function (data) {
            // console.log(data);
            //
            // console.log(JSON.parse(data));
            user = data;
        }
    });

    messagesOnRequest(idReq, user);

}

function messagesOnRequest(idReq, user) {
    let infoRequest = {};
    infoRequest["id"] = idReq;
    let intervalID;

    // clearInterval(intervalID);
    var t = window.setTimeout(function () {
        var idMax = t;
        for (var i = 0; i < idMax; i++) {
            window.clearInterval(i);
            window.clearTimeout(i);
        }
    }, 4);


    let quantityMes = -1;
    let quantityMesNew = 0;
    // console.log(quantityMes + " " + quantityMesNew);
    intervalID = setInterval(() => {
            $(function () {
                var token = $("input[name='_csrf']").val();
                var header = "X-CSRF-TOKEN";
                $(document).ajaxSend(function (e, xhr, options) {
                    xhr.setRequestHeader(header, token);
                });
            });
            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: "/requests/messages/quantity",
                dataType: 'json',
                data: JSON.stringify(infoRequest),
                success: function (data) {
                    // console.log(data);
                    quantityMesNew = data.length;
                }
            });

            if (quantityMesNew > quantityMes) {
                quantityMes = quantityMesNew;

                $(function () {
                    var token = $("input[name='_csrf']").val();
                    var header = "X-CSRF-TOKEN";
                    $(document).ajaxSend(function (e, xhr, options) {
                        xhr.setRequestHeader(header, token);
                    });
                });
                $.ajax({
                    type: "POST",
                    contentType: "application/json",
                    url: "/requests/messages",
                    dataType: 'json',
                    data: JSON.stringify(infoRequest),

                    success: function (data) {
                        // console.log(data);
                        messagesTableView(data, user);
                    }

                });
            }
        }
        , 300);


};


function messagesTableView(data, user) {
    let view;
    let side;
    console.log(data);
    let newLine
    if (data[0] === undefined) {
        view =
            "\n";
    } else {
        for (let i = 0; i < data.length; i++) {
            if (user.id != data[i].user.id) {
                side = 'right'
            } else {
                side = 'left';
            }
            newLine =
                "<li class='" + side + " clearfix'>" +
                "<div class='chat-body clearfix'>" +
                "<div class='header'>" +
                "<strong class='primary-font'>" + data[i].user.username + "</strong>" +
                "<small class='pull-right text-muted'>" +
                "<span class='glyphicon glyphicon-time'></span>" +
                new Date(Date.parse(data[i].localDateTime)).toLocaleString() + "</small>" +
                "</div>" +
                "<p>" + data[i].text + "</p>" +
                "</div>" +
                "</li>" + "\n";

            if (view === undefined) {
                view = "" + newLine;
            } else {
                view = view + newLine;
            }
        }
    }

    $('#messagesList').html(view);
    let block = document.getElementById("messagesScroll");
    block.scrollTop = block.scrollHeight;


};

function sendMessage() {
    let infoMessage = {};
    infoMessage["id"] = $("#idRequest").val();
    infoMessage["text"] = $("#text").val();
    if ($("#text").val() == "") {
        return;
    }
    // console.log(infoMessage);
    //this need for work
    $(function () {
        var token = $("input[name='_csrf']").val();
        var header = "X-CSRF-TOKEN";
        $(document).ajaxSend(function (e, xhr, options) {
            xhr.setRequestHeader(header, token);
        });
    });
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/requests/messages/send",
        dataType: 'json',
        data: JSON.stringify(infoMessage),
        success: function (data) {
            // console.log(data);
            // messagesTableView(data);
            document.getElementById('text').value = "";
        }
    });
};
