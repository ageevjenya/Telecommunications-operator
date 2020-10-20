<#import "parts/common.ftlh" as c>
<#import "parts/coveragemap.ftlh" as n>
<#include "parts/security.ftlh">
<@c.page>
    <head>
        <link type="text/css" rel="stylesheet" href="/static/style.css">
        <script src="../static/jsfunctions/request.js" type="text/javascript"></script>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet"
              id="bootstrap-css">
    </head>
    <body>
    <div class="container">
        <div class="row">
            <div class="col mx-1">
                <div class="jumbotron ">
                    <div class="row">
                        <div id="headcolumn">
                            <h4 class="display-5"><#if isAdmin>Заявки<#else>Ваши зявки</#if></h4>
                        </div>
                        <div id="headcolumn">
                            <h4 class="display-5">Инфо</h4>
                        </div>
                        <div id="headcolumn">
                            <h4 class="display-5">Чат</h4>
                        </div>
                    </div>

                    <div class="row">
                        <div style="overflow:auto;" id="column">
                            <table class="table table-striped">
                                <tbody id="requestList">
                                </tbody>
                            </table>
                        </div>
                        <div id="column">
                            <div id="info" style="border: 3px solid #fff; border-radius: 10px;"
                                 class="border border-primary p-2"></div>
                            <br>
                            <div id="button"></div>
                            <div id="idRequest" value=""></div>
                            <div id="activeRequest" value=""></div>
                        </div>

                        <div id="column">
                            <div class="panel panel-primary">
                                <div id="messagesScroll" class="panel-body">
                                    <ul id="messagesList" class="chat">

                                    </ul>
                                </div>
                                <div class="panel-footer">
                                    <div class="input-group">
                                        <input id="text" type="text" class="form-control input-sm"
                                               placeholder="Введите сообщение..."/>
                                        <div class="input-group-btn">
                                            <button disabled class="btn btn-warning btn-sm" onclick="sendMessage()"
                                                    id="btn-chat">Отправить
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
<#--                    <p class="lead">Есть проблема, вопрос или предложение? Напишите нам. <br>-->
<#--                        P.S. Посмотреть статус обращения и написать нам вы можете в разделе заявки</p>-->
<#--                    <form method="post" action="/requests" class="form-inline">-->
<#--                        <input type="text" class="form-control" name="description"-->
<#--                               placeholder="Текст..."/>-->
<#--                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>-->

<#--                        <button type="submit" class="btn btn-default">Отправить</button>-->
<#--                    </form>-->

                </div>
            </div>
        </div>
    </div>
    </body>
    <script>requestAll()</script>
    <script>
        $('#text').on('click', sendMessage)

        $('#text').on('keydown', function(e) {
            if (e.which === 13) {
                sendMessage();
            }
        })
    </script>
</@c.page>