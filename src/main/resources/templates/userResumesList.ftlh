<#import "parts/common.ftlh" as c>

<@c.page>
    <div style="margin-left: 3%">
        <br>
        <h3>Список вакансий</h3>
        <br>
    </div>
        <#if resumes??>
            <#if exists == "нет">
                <div style="margin-left: 20%">Нет нерассмотренных резюме</div>
            <#else>
            <table class="table table-hover" style="margin-left: 3%; width: 95%">
            <tr>
          <th>user_role</th>
                <th>Вакансия</th>
          <th>ФИО</th>
          <th>Brth</th>
          <th>Phone</th>
                <th>О себе</th>
                <th></th>
                <th></th>
        </tr>
        <#list resumes as resume>
        <tr>
            <#assign roles = "" />
            <#list resume.getUser().getRoles() as role>
                <#assign roles += role.name() + " " />
            </#list>
            <td>${roles}</td>
            <td>${resume.getVacancy().name}</td>
            <td>${resume.getUser().getLastName()} ${resume.getUser().getFirstName()} ${resume.getUser().getMiddleName()}</td>
            <td>${resume.getBirthday()}</td>
            <td>${resume.getPhone()}</td>
            <td>${resume.getText()}</td>
            <td>
            <form method="post" action="/no">
            <input type="hidden" name="resumeId" value="${resume.getId()}"/>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button type="submit" class="btn btn-danger">Отклонить</button>
            </form>
                </td>
            <td>
                <form method="post" action="/yes">
                    <input type="hidden" name="userId" value="${resume.getUser().getId()}"/>
                    <input type="hidden" name="resumeId" value="${resume.getId()}"/>
                    <input type="hidden" name="vacancyId" value="${resume.getVacancy().getId()}"/>
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <button type="submit" class="btn btn-success">Принять</button>
                </form>
            </td>

            </#list>
            </#if>
            <#else>
            <div style="margin-left: 20%">Нет отправленных резюме</div>
        </#if>
</@c.page>