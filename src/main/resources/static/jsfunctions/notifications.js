function notificationAllActive() {
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
        url: "/notifications/all",
        dataType: 'json',
        success: function (data) {
            // console.log(data);
            notificationListView(data);
        }
    });

};

function notificationListView(data) {
    let view;
    /*let color;*/
    let newLine;
    if (data[0] === undefined) {
        view =
            "\n";
        document.getElementById('notification').style.border = '0px';
    } else {
        for (let i = 0; i < data.length; i++) {
            /*if (data[i].active) {
                color = '#fbcece'
            } else {
                color = '#cafea7';
            }*/
            newLine =
                "<li>" +
                "<div id='" + data[i].id + "' onclick='changeActive(this.id)' " +
                "class='border'>" + // border-primary
                data[i].description + " <br> " +
                new Date(Date.parse(data[i].localDateTime)).toLocaleString() +
                "</div>" +
                "</li> \n";
            if (view === undefined) {
                view = "" + newLine;
            } else {
                view = view + newLine;
            }
        }
        /*document.getElementById('notification').style.border = '2px solid #A9A9A9';*/

    }
    // console.log(view);
    $('#notificationList').html(view);
}

function changeActive(id) {
    let idNotification = {};
    idNotification["id"] = id;
    // console.log(idNotification);
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
        url: "/notifications/changeActive",
        dataType: 'json',
        data: JSON.stringify(idNotification),

        success: function () {
            setTimeout(function () {
                notificationAllActive();
            }, (300));

        }
    });

};



function notificationProduct() {

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
        url: "/notifications/product",
        dataType: 'json',
        success: function (data) {
            // console.log(data);
            notificationView(data);
        }
    });

};

function notificationView(data) {
    let view = data.description;
    // console.log(view);
    $('#notificationProductView').html(view);
};

function notificationsAmount() {

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
        url: "/notifications/allCount",
        dataType: 'json',
        success: function (data) {
            // console.log(data);
            notificationAmountListView(data);
        }
    });

};

function notificationAmountListView(data) {
    let view = data.length;
    // console.log(view);
    $('#notificationsAmountList').html(view);
};
