function openForm() {
    document.getElementById("myForm").style.display = "block";
    firstQuestion();
    document.getElementById('btn').disabled = 1;
    document.getElementById('requests').disabled = 1;
}

function closeForm() {
    document.getElementById("myForm").style.display = "none";
}


function firstQuestion() {
    // console.log("hi");
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
        url: "/chat/question/first",
        dataType: 'json',
        success: function (data) {
            // console.log(data);
            messagesChatView(data);
        }
    });

}

function onclickButtonMessage(button) {
    // let text = document.getElementById("text").value;
    // console.log(button);

    if (button.dataset.idAfterQuestion) {
        let question = {};
        question["id"] = button.dataset.idAfterQuestion;
        // console.log(question);
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
            url: "/chat/question",
            dataType: 'json',
            data: JSON.stringify(question),
            success: function (dataQuestion) {
                // console.log(dataQuestion);
                messagesChatView(dataQuestion);
            }
        });
    } else {

        let fuctionChat = {};
        fuctionChat["id"] = button.dataset.idFunctionChat;
        // console.log(fuctionChat);
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
            url: "/chat/function",
            dataType: 'json',
            data: JSON.stringify(fuctionChat),
            success: function (dataFunction) {
                functionChat(dataFunction.nameFunction);
                // console.log(dataFunction.nameFunction);

            }
        });

    }


}


function messagesChatView(data) {
    let view = "";
    let newLine = "";
    let idQuestion = {};
    idQuestion["id"] = data.id;


    newLine =
        "<li class='right clearfix'>" +
        "<div class='chat-body clearfix'>" +
        "<div class='header'>" +
        "<strong class='primary-font'>Бот</strong>" +
        "<small class='pull-right text-muted'>" +
        "<span class='glyphicon glyphicon-time'></span>" +
        new Date(Date.now()).toLocaleString() + "</small>" +
        "</div>" +
        "<p>" + data.textQuestion + "</p>";

    view = view + newLine;


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
        url: "/chat/answers",
        dataType: 'json',
        data: JSON.stringify(idQuestion),
        success: function (answers) {
            // console.log(answers);
            let afterQuestionid = "";
            let functionChatid = "";

            for (let i = 0; i < answers.length; i++) {
                if (!(answers[i].afterQuestion == null)) {
                    afterQuestionid = answers[i].afterQuestion.id
                } else {
                    afterQuestionid = ""
                }
                if (!(answers[i].functionChat == null)) {
                    functionChatid = answers[i].functionChat.id
                } else {
                    functionChatid = ""
                }
                newLine =
                    "<button value='" + answers[i].id + "' " +
                    "data-id-after-question='" + afterQuestionid + "' " +
                    "data-id-function-chat='" + functionChatid + "' " +
                    "class='btn btn-warning btn-sm' " +
                    "onclick='onclickButtonMessage(this); return false;'>" + (i + 1) + ") " + answers[i].textAnswer + "</button>";

                // console.log(newLine);

                if (view === undefined) {
                    view = "" + newLine;
                } else {
                    view = view + newLine;
                }
            }
            newLine =
                "</div>" +
                "</li>" + "\n";
            // "<div id='nextMessage'></div>";
            view = view + newLine;

            // console.log(view);
            $('#nextMessage').html(view);
            let block = document.getElementById("messagesScroll");
            block.scrollTop = block.scrollHeight;
        }
    });
}

function functionChat(nameFunction) {
    let user;
    let view = "";
    let newLine = "";
    // console.log(nameFunction);
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


            user = data;
            // console.log(user);

        }
    });
    switch (nameFunction) {
        case 'firstQuestion':
            firstQuestion();
            return;
            break;
        case 'topUpBalance':
            if (typeof user == "undefined") {
                newLine =
                    "<li class='right clearfix'>" +
                    "<div class='chat-body clearfix'>" +
                    "<div class='header'>" +
                    "<strong class='primary-font'>Бот</strong>" +
                    "<small class='pull-right text-muted'>" +
                    "<span class='glyphicon glyphicon-time'></span>" +
                    new Date(Date.now()).toLocaleString() + "</small>" +
                    "</div>" +
                    "<p>Авторизуйтесь или зарегистрируйтесь</p>" +
                    "</div>" +
                    "</li>" + "\n";
                view = view + newLine;
                // console.log(user);
            } else {
                topUpBalance();
                return;
            }
            break;
        case 'userBalance':
            if (typeof user == "undefined") {
                newLine =
                    "<li class='right clearfix'>" +
                    "<div class='chat-body clearfix'>" +
                    "<div class='header'>" +
                    "<strong class='primary-font'>Бот</strong>" +
                    "<small class='pull-right text-muted'>" +
                    "<span class='glyphicon glyphicon-time'></span>" +
                    new Date(Date.now()).toLocaleString() + "</small>" +
                    "</div>" +
                    "<p>Авторизуйтесь или зарегистрируйтесь</p>" +
                    "</div>" +
                    "</li>" + "\n";
                view = view + newLine;
                // console.log(user);

            } else {
                userBalance();
                return;
            }
            break;
        case 'connectedServices':
            if (typeof user == "undefined") {
                newLine =
                    "<li class='right clearfix'>" +
                    "<div class='chat-body clearfix'>" +
                    "<div class='header'>" +
                    "<strong class='primary-font'>Бот</strong>" +
                    "<small class='pull-right text-muted'>" +
                    "<span class='glyphicon glyphicon-time'></span>" +
                    new Date(Date.now()).toLocaleString() + "</small>" +
                    "</div>" +
                    "<p>Авторизуйтесь или зарегистрируйтесь</p>" +
                    "</div>" +
                    "</li>" + "\n";
                view = view + newLine;
                // console.log(user);

            } else {
                connectedServices();
                return;
            }
            break;

        case 'serviceСatalog':
            serviceСatalog();
            return;
            break;
        case 'myConnectedTarifs':
            if (typeof user == "undefined") {
                newLine =
                    "<li class='right clearfix'>" +
                    "<div class='chat-body clearfix'>" +
                    "<div class='header'>" +
                    "<strong class='primary-font'>Бот</strong>" +
                    "<small class='pull-right text-muted'>" +
                    "<span class='glyphicon glyphicon-time'></span>" +
                    new Date(Date.now()).toLocaleString() + "</small>" +
                    "</div>" +
                    "<p>Авторизуйтесь или зарегистрируйтесь</p>" +
                    "</div>" +
                    "</li>" + "\n";
                view = view + newLine;
                // console.log(user);

            } else {
                myConnectedTarifs();
                return;
            }
            break;
        case 'tarifsCatalog':
            tarifsCatalog();
            return;
            break;
        case 'homeTarifsCatalog':
            homeTarifsCatalog();
            return;
            break;
        case 'mobileTarifsCatalog':
            mobileTarifsCatalog();
            return;
            break;
        case 'modemsCatalog':
            modemsCatalog();
            return;
            break;
        case 'usefulServices':
            usefulServices();
            return;
            break;
        case 'equipmentCatalog':
            equipmentCatalog();
            return;
            break;
        case 'changePassword':
            // userBalance();
            break;
        case 'detailViewer':
            if (typeof user == "undefined") {
                newLine =
                    "<li class='right clearfix'>" +
                    "<div class='chat-body clearfix'>" +
                    "<div class='header'>" +
                    "<strong class='primary-font'>Бот</strong>" +
                    "<small class='pull-right text-muted'>" +
                    "<span class='glyphicon glyphicon-time'></span>" +
                    new Date(Date.now()).toLocaleString() + "</small>" +
                    "</div>" +
                    "<p>Авторизуйтесь или зарегистрируйтесь</p>" +
                    "</div>" +
                    "</li>" + "\n";
                view = view + newLine;
                // console.log(user);

            } else {
                detailViewer();
                return;
            }
            break;
        case 'connectedServicesAll':
            if (typeof user == "undefined") {
                newLine =
                    "<li class='right clearfix'>" +
                    "<div class='chat-body clearfix'>" +
                    "<div class='header'>" +
                    "<strong class='primary-font'>Бот</strong>" +
                    "<small class='pull-right text-muted'>" +
                    "<span class='glyphicon glyphicon-time'></span>" +
                    new Date(Date.now()).toLocaleString() + "</small>" +
                    "</div>" +
                    "<p>Авторизуйтесь или зарегистрируйтесь</p>" +
                    "</div>" +
                    "</li>" + "\n";
                view = view + newLine;
                // console.log(user);

            } else {
                connectedServicesAll();
                return;
            }
            break;
        case 'balancesByPackages':
            if (typeof user == "undefined") {
                newLine =
                    "<li class='right clearfix'>" +
                    "<div class='chat-body clearfix'>" +
                    "<div class='header'>" +
                    "<strong class='primary-font'>Бот</strong>" +
                    "<small class='pull-right text-muted'>" +
                    "<span class='glyphicon glyphicon-time'></span>" +
                    new Date(Date.now()).toLocaleString() + "</small>" +
                    "</div>" +
                    "<p>Авторизуйтесь или зарегистрируйтесь</p>" +
                    "</div>" +
                    "</li>" + "\n";
                view = view + newLine;
                // console.log(user);

            } else {
                balancesByPackages();
                return;
            }
            break;
        case 'operatorСall':
            if (typeof user == "undefined") {
                newLine =
                    "<li class='right clearfix'>" +
                    "<div class='chat-body clearfix'>" +
                    "<div class='header'>" +
                    "<strong class='primary-font'>Бот</strong>" +
                    "<small class='pull-right text-muted'>" +
                    "<span class='glyphicon glyphicon-time'></span>" +
                    new Date(Date.now()).toLocaleString() + "</small>" +
                    "</div>" +
                    "<p>Авторизуйтесь или зарегистрируйтесь</p>" +
                    "</div>" +
                    "</li>" + "\n";
                view = view + newLine;
                // console.log(user);

            } else {
                operatorСall();
                return;
            }
            break;
        default:
            //Здесь находятся инструкции, которые выполняются при отсутствии соответствующего значения
            //statements_def
            break;
    }


    if (typeof user == "undefined") {
        // console.log(view);
        $('#nextMessage').html(view);
        let block = document.getElementById("messagesScroll");
        block.scrollTop = block.scrollHeight;
    }

}

function userBalance() {
    let view = "";
    let newLine = "";
    newLine =
        "<li class='right clearfix'>" +
        "<div class='chat-body clearfix'>" +
        "<div class='header'>" +
        "<strong class='primary-font'>Бот</strong>" +
        "<small class='pull-right text-muted'>" +
        "<span class='glyphicon glyphicon-time'></span>" +
        new Date(Date.now()).toLocaleString() + "</small>" +
        "</div>" +
        "<p>Ваш текущий баланс: ";

    view = view + newLine;
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
        url: "/user/auth",
        dataType: 'json',
        success: function (user) {
            // console.log(balance);

            newLine =
                user.balance.money + "</p>" +
                "<button class='btn btn-warning btn-sm' onclick='operatorСall(); return false;'" +
                "id='btn-chat'>Если у Вас остались вопросы, нажмите для соединения с опператором</button>" +
                "</div>" +
                "</li>" + "\n";

            if (view === undefined) {
                view = "" + newLine;
            } else {
                view = view + newLine;
            }
            // console.log(view);
            $('#nextMessage').html(view);
            let block = document.getElementById("messagesScroll");
            block.scrollTop = block.scrollHeight;
        }
    })
}

function operatorСall() {
    let view = "";
    let newLine = "";
    newLine =
        "<li class='right clearfix'>" +
        "<div class='chat-body clearfix'>" +
        "<div class='header'>" +
        "<strong class='primary-font'>Бот</strong>" +
        "<small class='pull-right text-muted'>" +
        "<span class='glyphicon glyphicon-time'></span>" +
        new Date(Date.now()).toLocaleString() + "</small>" +
        "</div>" +
        "<p>Напишите свой вопрос ниже и отправьте, " +
        "автоматически будет создана заявка по которой с вами скоро свяжется оператор </p>" +
        "</div>" +
        "</li>" + "\n";
    view = view + newLine;
    $('#nextMessage').html(view);
    let block = document.getElementById("messagesScroll");
    block.scrollTop = block.scrollHeight;
    document.getElementById('btn').disabled = 0;
    document.getElementById('requests').disabled = 0;
}

function topUpBalance() {
    let view = "";
    let newLine = "";
    newLine =
        "<li class='right clearfix'>" +
        "<div class='chat-body clearfix'>" +
        "<div class='header'>" +
        "<strong class='primary-font'>Бот</strong>" +
        "<small class='pull-right text-muted'>" +
        "<span class='glyphicon glyphicon-time'></span>" +
        new Date(Date.now()).toLocaleString() + "</small>" +
        "</div>" +
        "<p><a href='/personalArea'>Перейдите по ссылке для пополнения баланса</a> " +
        "</p>" +
        "</div>" +
        "</li>" + "\n";

    view = view + newLine;
    // console.log(view);
    $('#nextMessage').html(view);
    let block = document.getElementById("messagesScroll");
    block.scrollTop = block.scrollHeight;
}

function connectedServices() {
    let view = "";
    let newLine = "";
    let usertariffHome = "";
    let usertariffMobile = "";

    newLine =
        "<li class='right clearfix'>" +
        "<div class='chat-body clearfix'>" +
        "<div class='header'>" +
        "<strong class='primary-font'>Бот</strong>" +
        "<small class='pull-right text-muted'>" +
        "<span class='glyphicon glyphicon-time'></span>" +
        new Date(Date.now()).toLocaleString() + "</small>" +
        "</div>" +
        "<p>Подключенные услуги: </p>";

    view = view + newLine;
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
        url: "/user/auth",
        dataType: 'json',
        success: function (user) {
            // console.log(user);
            if (!(user.tariffHome == null)) {
                usertariffHome = "<p>Домашний интернет: " + user.tariffHome.description + "</p>"
            } else {
                usertariffHome = "<p>Домашний интернет не подключен</p>"
            }
            if (!(user.tariffMobile == null)) {
                usertariffMobile = "<p>Мобильная связь: " + user.tariffMobile.description + "</p>"
            } else {
                usertariffMobile = "<p>Мобильная связь не подключена</p>"
            }
            newLine =
                usertariffHome + usertariffMobile +
                "<button class='btn btn-warning btn-sm' onclick='operatorСall(); return false;'" +
                "id='btn-chat'>Если у Вас остались вопросы, нажмите для соединения с опператором</button>" +
                "</div>" +
                "</li>" + "\n";

            if (view === undefined) {
                view = "" + newLine;
            } else {
                view = view + newLine;
            }
            // console.log(view);
            $('#nextMessage').html(view);
            let block = document.getElementById("messagesScroll");
            block.scrollTop = block.scrollHeight;
        }
    })

}

function serviceСatalog() {
    let view = "";
    let newLine = "";
    newLine =
        "<li class='right clearfix'>" +
        "<div class='chat-body clearfix'>" +
        "<div class='header'>" +
        "<strong class='primary-font'>Бот</strong>" +
        "<small class='pull-right text-muted'>" +
        "<span class='glyphicon glyphicon-time'></span>" +
        new Date(Date.now()).toLocaleString() + "</small>" +
        "</div>" +
        "<p>Перейдите в раздел тарифы в верхней панели</p>" +
        "<button class='btn btn-warning btn-sm' onclick='operatorСall(); return false;'" +
        "id='btn-chat'>Если у Вас остались вопросы, нажмите для соединения с опператором</button>" +
        "</div>" +
        "</li>" + "\n";


    view = view + newLine;
    // console.log(view);
    $('#nextMessage').html(view);
    // console.log(document.getElementById("nextMessage"));
    let block = document.getElementById("messagesScroll");
    block.scrollTop = block.scrollHeight;
}

function myConnectedTarifs() {
    let view = "";
    let newLine = "";
    let usertariffHome = "";
    let usertariffMobile = "";

    newLine =
        "<li class='right clearfix'>" +
        "<div class='chat-body clearfix'>" +
        "<div class='header'>" +
        "<strong class='primary-font'>Бот</strong>" +
        "<small class='pull-right text-muted'>" +
        "<span class='glyphicon glyphicon-time'></span>" +
        new Date(Date.now()).toLocaleString() + "</small>" +
        "</div>" +
        "<p>Подключенные услуги: </p>";

    view = view + newLine;
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
        url: "/user/auth",
        dataType: 'json',
        success: function (user) {
            // console.log(user);
            if (!(user.tariffHome == null)) {
                usertariffHome = "<p>Домашний интернет: " + user.tariffHome.description + "</p>"
            } else {
                usertariffHome = "<p>Домашний интернет не подключен</p>"
            }
            if (!(user.tariffMobile == null)) {
                usertariffMobile = "<p>Мобильная связь: " + user.tariffMobile.description + "</p>"
            } else {
                usertariffMobile = "<p>Мобильная связь не подключена</p>"
            }
            newLine =
                usertariffHome + usertariffMobile +
                "<button class='btn btn-warning btn-sm' onclick='operatorСall(); return false;'" +
                "id='btn-chat'>Если у Вас остались вопросы, нажмите для соединения с опператором</button>" +
                "</div>" +
                "</li>" + "\n";

            if (view === undefined) {
                view = "" + newLine;
            } else {
                view = view + newLine;
            }
            // console.log(view);
            $('#nextMessage').html(view);
            let block = document.getElementById("messagesScroll");
            block.scrollTop = block.scrollHeight;
        }
    })
}

function tarifsCatalog() {
    let view = "";
    let newLine = "";
    newLine =
        "<li class='right clearfix'>" +
        "<div class='chat-body clearfix'>" +
        "<div class='header'>" +
        "<strong class='primary-font'>Бот</strong>" +
        "<small class='pull-right text-muted'>" +
        "<span class='glyphicon glyphicon-time'></span>" +
        new Date(Date.now()).toLocaleString() + "</small>" +
        "</div>" +
        // "<p><a href='/personalArea'>Перейдите по ссылке чтобы посмотреть подключенные услуги</a></p>" +
        "<p>Перейдите в раздел тарифы в верхней панели</p>" +
        "<button class='btn btn-warning btn-sm' onclick='operatorСall(); return false;'" +
        "id='btn-chat'>Если у Вас остались вопросы, нажмите для соединения с опператором</button>" +
        "</div>" +
        "</li>" + "\n";

    view = view + newLine;
    // console.log(view);
    $('#nextMessage').html(view);
    let block = document.getElementById("messagesScroll");
    block.scrollTop = block.scrollHeight;
}

function homeTarifsCatalog() {
    let view = "";
    let newLine = "";
    newLine =
        "<li class='right clearfix'>" +
        "<div class='chat-body clearfix'>" +
        "<div class='header'>" +
        "<strong class='primary-font'>Бот</strong>" +
        "<small class='pull-right text-muted'>" +
        "<span class='glyphicon glyphicon-time'></span>" +
        new Date(Date.now()).toLocaleString() + "</small>" +
        "</div>" +
        "<p><a href='/tariffsHome'>Перейдите по ссылке чтобы посмотреть тарифы домашнего интернета</a></p>" +
        "<button class='btn btn-warning btn-sm' onclick='operatorСall(); return false;'" +
        "id='btn-chat'>Если у Вас остались вопросы, нажмите для соединения с опператором</button>" +
        "</div>" +
        "</li>" + "\n";

    view = view + newLine;
    // console.log(view);
    $('#nextMessage').html(view);
    let block = document.getElementById("messagesScroll");
    block.scrollTop = block.scrollHeight;
}

function mobileTarifsCatalog() {
    let view = "";
    let newLine = "";
    newLine =
        "<li class='right clearfix'>" +
        "<div class='chat-body clearfix'>" +
        "<div class='header'>" +
        "<strong class='primary-font'>Бот</strong>" +
        "<small class='pull-right text-muted'>" +
        "<span class='glyphicon glyphicon-time'></span>" +
        new Date(Date.now()).toLocaleString() + "</small>" +
        "</div>" +
        "<p><a href='/tariffs'>Перейдите по ссылке чтобы посмотреть тарифы мобильной связи</a></p>" +
        "<button class='btn btn-warning btn-sm' onclick='operatorСall(); return false;'" +
        "id='btn-chat'>Если у Вас остались вопросы, нажмите для соединения с опператором</button>" +
        "</div>" +
        "</li>" + "\n";

    view = view + newLine;
    // console.log(view);
    $('#nextMessage').html(view);
    let block = document.getElementById("messagesScroll");
    block.scrollTop = block.scrollHeight;
}


function modemsCatalog() {
    let view = "";
    let newLine = "";
    newLine =
        "<li class='right clearfix'>" +
        "<div class='chat-body clearfix'>" +
        "<div class='header'>" +
        "<strong class='primary-font'>Бот</strong>" +
        "<small class='pull-right text-muted'>" +
        "<span class='glyphicon glyphicon-time'></span>" +
        new Date(Date.now()).toLocaleString() + "</small>" +
        "</div>" +
        "<p><a href='/modems'>Перейдите по ссылке чтобы посмотреть каталог модемов и роутеров</a></p>" +
        "<button class='btn btn-warning btn-sm' onclick='operatorСall(); return false;'" +
        "id='btn-chat'>Если у Вас остались вопросы, нажмите для соединения с опператором</button>" +
        "</div>" +
        "</li>" + "\n";

    view = view + newLine;
    // console.log(view);
    $('#nextMessage').html(view);
    let block = document.getElementById("messagesScroll");
    block.scrollTop = block.scrollHeight;

}

function equipmentCatalog() {
    let view = "";
    let newLine = "";
    newLine =
        "<li class='right clearfix'>" +
        "<div class='chat-body clearfix'>" +
        "<div class='header'>" +
        "<strong class='primary-font'>Бот</strong>" +
        "<small class='pull-right text-muted'>" +
        "<span class='glyphicon glyphicon-time'></span>" +
        new Date(Date.now()).toLocaleString() + "</small>" +
        "</div>" +
        "<p><a href='/techs'>Перейдите по ссылке чтобы посмотреть каталог техники</a></p>" +
        "<button class='btn btn-warning btn-sm' onclick='operatorСall(); return false;'" +
        "id='btn-chat'>Если у Вас остались вопросы, нажмите для соединения с опператором</button>" +
        "</div>" +
        "</li>" + "\n";

    view = view + newLine;
    // console.log(view);
    $('#nextMessage').html(view);
    let block = document.getElementById("messagesScroll");
    block.scrollTop = block.scrollHeight;

}

function usefulServices() {
    let view = "";
    let newLine = "";
    newLine =
        "<li class='right clearfix'>" +
        "<div class='chat-body clearfix'>" +
        "<div class='header'>" +
        "<strong class='primary-font'>Бот</strong>" +
        "<small class='pull-right text-muted'>" +
        "<span class='glyphicon glyphicon-time'></span>" +
        new Date(Date.now()).toLocaleString() + "</small>" +
        "</div>" +
        "<p><a href='/shop'>Перейдите по ссылке чтобы посмотреть полезное</a></p>" +
        "<button class='btn btn-warning btn-sm' onclick='operatorСall(); return false;'" +
        "id='btn-chat'>Если у Вас остались вопросы, нажмите для соединения с опператором</button>" +
        "</div>" +
        "</li>" + "\n";

    view = view + newLine;
    // console.log(view);
    $('#nextMessage').html(view);
    let block = document.getElementById("messagesScroll");
    block.scrollTop = block.scrollHeight;
}

function detailViewer() {
    let view = "";
    let newLine = "";
    newLine =
        "<li class='right clearfix'>" +
        "<div class='chat-body clearfix'>" +
        "<div class='header'>" +
        "<strong class='primary-font'>Бот</strong>" +
        "<small class='pull-right text-muted'>" +
        "<span class='glyphicon glyphicon-time'></span>" +
        new Date(Date.now()).toLocaleString() + "</small>" +
        "</div>" +
        "<p><a href='/personalArea'>Перейдите по ссылке чтобы посмотреть детализацию в личном кабинете</a> " +
        "</p>" +
        "<button class='btn btn-warning btn-sm' onclick='operatorСall(); return false;'" +
        "id='btn-chat'>Если у Вас остались вопросы, нажмите для соединения с опператором</button>" +
        "</div>" +
        "</li>" + "\n";

    view = view + newLine;
    // console.log(view);
    $('#nextMessage').html(view);
    let block = document.getElementById("messagesScroll");
    block.scrollTop = block.scrollHeight;
}

function connectedServicesAll() {
    let view = "";
    let newLine = "";
    let usertariffHome = "";
    let usertariffMobile = "";

    newLine =
        "<li class='right clearfix'>" +
        "<div class='chat-body clearfix'>" +
        "<div class='header'>" +
        "<strong class='primary-font'>Бот</strong>" +
        "<small class='pull-right text-muted'>" +
        "<span class='glyphicon glyphicon-time'></span>" +
        new Date(Date.now()).toLocaleString() + "</small>" +
        "</div>" +
        "<p>Подключенные услуги: </p>";

    view = view + newLine;
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
        url: "/user/auth",
        dataType: 'json',
        success: function (user) {
            // console.log(user);
            if (!(user.tariffHome == null)) {
                usertariffHome = "<p>Домашний интернет: " + user.tariffHome.description + "</p>"
            } else {
                usertariffHome = "<p>Домашний интернет не подключен</p>"
            }
            if (!(user.tariffMobile == null)) {
                usertariffMobile = "<p>Мобильная связь: " + user.tariffMobile.description + "</p>"
            } else {
                usertariffMobile = "<p>Мобильная связь не подключена</p>"
            }
            newLine =
                usertariffHome + usertariffMobile +
                "<button class='btn btn-warning btn-sm' onclick='operatorСall(); return false;'" +
                "id='btn-chat'>Если у Вас остались вопросы, нажмите для соединения с опператором</button>" +
                "</div>" +
                "</li>" + "\n";

            if (view === undefined) {
                view = "" + newLine;
            } else {
                view = view + newLine;
            }
            // console.log(view);
            $('#nextMessage').html(view);
            let block = document.getElementById("messagesScroll");
            block.scrollTop = block.scrollHeight;
        }
    })

}

function balancesByPackages() {
    let view = "";
    let newLine = "";
    let usedInternet = "";
    let usedMinutes = "";
    let usedSms = "";

    newLine =
        "<li class='right clearfix'>" +
        "<div class='chat-body clearfix'>" +
        "<div class='header'>" +
        "<strong class='primary-font'>Бот</strong>" +
        "<small class='pull-right text-muted'>" +
        "<span class='glyphicon glyphicon-time'></span>" +
        new Date(Date.now()).toLocaleString() + "</small>" +
        "</div>" +
        "<p>Подключенные услуги: </p>";

    view = view + newLine;
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
        url: "/user/auth",
        dataType: 'json',
        success: function (user) {
            console.log(user);
            usedInternet = "<p>Израсходовано мб мобильного интернета: " + user.userUsedTariffMobile.usedInternet + "</p>";
            usedMinutes = "<p>Израсходовано минут: " + user.userUsedTariffMobile.usedMinutes + "</p>";
            usedSms = "<p>Израсходовано SMS: " + user.userUsedTariffMobile.usedSms + "</p>";

            newLine =
                usedInternet + usedMinutes + usedSms +
                "<button class='btn btn-warning btn-sm' onclick='operatorСall(); return false;'" +
                "id='btn-chat'>Если у Вас остались вопросы, нажмите для соединения с опператором</button>" +
                "</div>" +
                "</li>" + "\n";

            if (view === undefined) {
                view = "" + newLine;
            } else {
                view = view + newLine;
            }
            // console.log(view);
            $('#nextMessage').html(view);
            let block = document.getElementById("messagesScroll");
            block.scrollTop = block.scrollHeight;
        }
    })
}