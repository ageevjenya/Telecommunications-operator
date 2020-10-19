<button class="open-button" onclick="openForm()">Чат</button>

<div class="chat-popup" id="myForm">
    <form class="form-container" method="post" action="/requests">
        <h4>Чат</h4>

        <#--        <label for="msg"><b></b></label>-->
        <#--        <textarea placeholder="Тип сообщения.." name="msg" required></textarea>-->
        <div class="panel panel-primary">
            <div id="messagesScroll" class="panel-body">
                <ul class="chat">
                <div id="nextMessage"></div>
                </ul>
            </div>
            <div class="panel-footer">
                <div class="input-group">
                    <input disabled id="requests" type="text" class="form-control input-sm"
                           name="description"
                           placeholder="Сообщение оператору..."/>
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <div class="input-group-btn">
                        <button disabled type="submit" class="btn btn-warning btn-sm "
<#--                                onclick="sendMessageChat()"-->
                                id="btn">Отправить
                        </button>
                    </div>
                </div>
            </div>
        </div>
        <#--        <button type="submit" onclick="sendMessage()" class="btn">Отправить</button>-->
        <button type="button" class="btn cancel" onclick="closeForm()">Закрыть</button>
    </form>
</div>