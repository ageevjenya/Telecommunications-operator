<#import "parts/common.ftlh" as c>
<@c.page>
<br>
    <h3 style="margin-left: 20%">${vacancy.name}</h3><br>
    <p style="margin-left: 19.3%; margin-right: 20%">${vacancy.text}</p>

<br>
    <#assign value = resumes?size />
    <#if value gt 0 >
        <#if resumes[0].vacancy.id == vacancy.id && exists == "да">
            <button type="button" id="save" class="btn btn-dark" style="margin-left: 20%" data-toggle="modal" data-target="#send">
                Отправить резюме</button>
            <div class="modal fade" id="send" tabindex="-1" aria-labelledby="sendLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="sendLabel">Отправить резюме</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            Вы уже отправили резюме на эту вакансию! Вы можете просмотреть его в личном кабинете.
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Ок</button>
                            <a href="/personalArea" class="btn btn-dark">Перейти в личный кабинет</a>
                        </div>
                    </div>
                </div>
            </div>
            <#else>
                <a href="/resume/${vacancy.id}" class="btn btn-dark" style="margin-left: 20%">Отправить резюме</a>
        </#if>
        <#else>
            <a href="/resume/${vacancy.id}" class="btn btn-dark" style="margin-left: 20%">Отправить резюме</a>
    </#if>
    <br><br>
    <a href="/work" class="btn btn-light" style="margin-left: 20%">Назад к вакансиям</a>
</@c.page>