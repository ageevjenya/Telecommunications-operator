<#import "parts/common.ftlh" as c>
<@c.page>
<br>
  <h3>Ваше резюме на рассмотрении</h3><br>
<div>

          <p><strong>Вакансия: ${yourResume.vacancy.name}</strong></p>
          <p>Имя: ${yourResume.firstName}</p>
          <p>Фамилия: ${yourResume.lastName}</p>
          <p>День рождения: ${yourResume.getBirthday()}</p>
          <p>Телефон: ${yourResume.phone}</p>
          <p>E-mail: ${yourResume.email}</p>
          <p>О себе: ${yourResume.text}</p>
    </div>

    <div class="toast show" role="alert" aria-live="assertive" aria-atomic="true" data-autohide="false"
         style="position: absolute; right: 15px; top: 80%">
        <div class="toast-header">
            <strong class="mr-auto">Отправлено</strong>
            <button type="button" class="ml-2 mb-1 close" data-dismiss="toast show" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <div class="toast-body">
            Вы можете просмотреть и откорректировать ваше резюме в <a href="/personalArea.ftlh">личном кабинете</a>.
        </div>
    </div>
</@c.page>