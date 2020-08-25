<#import "parts/common.ftl" as c>
<@c.page>
<br>
  <h3>Your resume</h3><br>
<div>

          <p><strong>Vacancy: ${yourResume.vacancy.name}</strong></p>
          <p>First name: ${yourResume.firstName}</p>
          <p>Last name: ${yourResume.lastName}</p>
          <p>Birthday: ${yourResume.getBirthdayString()}</p>
          <p>Phone: ${yourResume.phone}</p>
          <p>E-mail: ${yourResume.email}</p>
          <p>About yourself: ${yourResume.text}</p>
    </div>

</@c.page>