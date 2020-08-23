<#import "parts/common.ftl" as c>
<@c.page>
  <h1>Your resume</h1>
<div>

          <p>Vacancy: ${yourResume.vacancy.name}</p>
          <p>First name: ${yourResume.firstName}</p>
          <p>Last name: ${yourResume.lastName}</p>
          <p>Birthday: ${yourResume.getBirthdayString()}</p>
          <p>Phone: ${yourResume.phone}</p>
          <p>Email: ${yourResume.email}</p>
          <p>About yourself: ${yourResume.text}</p>
    </div>

</@c.page>