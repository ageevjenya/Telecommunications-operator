<#import "parts/common.ftlh" as c>
<@c.page>
<br>
  <h3>Ваше резюме</h3><br>
<div>

          <p><strong>Вакансия: ${yourResume.vacancy.name}</strong></p>
          <p>Имя: ${yourResume.firstName}</p>
          <p>Фамилия: ${yourResume.lastName}</p>
          <p>День рождения: ${yourResume.getBirthdayString()}</p>
          <p>Телефон: ${yourResume.phone}</p>
          <p>E-mail: ${yourResume.email}</p>
          <p>О себе: ${yourResume.text}</p>
    </div>

</@c.page>