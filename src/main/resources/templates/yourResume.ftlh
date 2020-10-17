<#import "parts/common.ftlh" as c>
<@c.page>
<br>
  <h3 style="margin-left: 20%">Ваше резюме на рассмотрении</h3><br>
<div style="margin-left: 20%">

          <p><strong>Вакансия: ${yourResume.vacancy.name}</strong></p>
          <p>Имя: ${yourResume.firstName}</p>
          <p>Фамилия: ${yourResume.lastName}</p>
          <p>День рождения: ${yourResume.getBirthday()}</p>
          <p>Телефон: ${yourResume.phone}</p>
          <p>E-mail: ${yourResume.email}</p>
          <p>О себе: ${yourResume.text}</p>
    </div>

    <div class="toast fade show" role="alert" aria-live="assertive" aria-atomic="true" data-autohide="false"
         style="position: absolute; right: 15px; top: 80%">
        <div class="toast-header">
            <strong class="mr-auto">Отправлено</strong>
            <button type="button" class="ml-2 mb-1 close" data-dismiss="toast" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <div class="toast-body">
            Вы можете просмотреть ваше резюме в <a href="/personalArea">личном кабинете</a>.
        </div>
    </div>
</@c.page>