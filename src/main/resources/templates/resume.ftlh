<#import "parts/common.ftlh" as c>

<@c.page>
<br>
  <h3>Отправить нам резюме</h3><br>
    <p><strong>Вакансия: ${vacancy.name}</strong></p>
<br></br>

    <div>
            <form method="post" class="form-inline">
               <input type="text" class="form-control" name="firstName" placeholder="Маша" />
               <input type="text" class="form-control" name="lastName" placeholder="Иванова" />
               <input type="text" class="form-control" name="birthday" placeholder="13.02.1998" />
               <input type="text" class="form-control" name="phone" placeholder="+79999999999" />
               <input type="text" class="form-control" name="email" placeholder="masha@yandex.com" />
               <input type="text" class="form-control" name="text" placeholder="Трудолюбивая, умею..." />
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
               <button type="submit" class="btn btn-default">Отправить</button>
            </form>
        </div>

    <br></br>
    <a href="/vacancy/${id}" class="btn text-nowrap-light">Назад к вакансии</a>

</@c.page>