<#import "parts/common.ftl" as c>
<@c.page>
<br>
    <h3>F.A.Q.</h3><br>
    <#list faq as f>
        <div class="accordion" id="accordion">
          <div class="card">
            <div class="card-header" id="${f.id}">
              <h2 class="mb-0">
                <button class="btn btn-link btn-block text-left" type="button" data-toggle="collapse" data-target="#collapse${f.id}" aria-expanded="false" aria-controls="collapse${f.id}">
                  ${f.question}
                </button>
              </h2>
            </div>

            <div id="collapse${f.id}" class="collapse show" aria-labelledby="${f.id}" data-parent="#accordion">

              <div class="card-body">
                ${f.answer}
              </div>
            </div>
          </div>
        </div>
    </#list>
</@c.page>