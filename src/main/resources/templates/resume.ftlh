<#import "parts/common.ftlh" as c>

<@c.page>
<br>
  <h3>Отправить нам резюме</h3><br>
    <p><strong>Вакансия: ${vacancy.name}</strong></p>
<br></br>

    <div>
            <form method="post" class="form-inline">
                <div class="form-group has-feedback">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-firstName"></i></span>
                        <input type="text" class="form-control" required="required" pattern="[A-Z][a-z]+"
                            name="firstName" placeholder="Маша" />
                        <span class="glyphicon form-control-feedback"></span>
                    </div>
                </div>
                <div class="form-group has-feedback">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-firstName"></i></span>
                        <input type="text" class="form-control" required="required" pattern="[A-Z][a-z]+"
                            name="lastName" placeholder="Иванова" />
                        <span class="glyphicon form-control-feedback"></span>
                    </div>
                </div>
                <div class="form-group has-feedback">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-firstName"></i></span>
                        <input type="text" class="form-control" required="required" pattern="(([0][1-9])|([12][0-9])|([3][01]))([.// -]*)(([0][1-9])|([1][0-2]))([.// -]*)(([1][9][4-9][0-9])|([2][0][0][0-5]))"
                            name="birthday" placeholder="13.02.1998" />
                        <span class="glyphicon form-control-feedback"></span>
                    </div>
                </div>
                <div class="form-group has-feedback">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-firstName"></i></span>
                        <input type="text" class="form-control" required="required" pattern="^\s*(?:\+?(\d{1,3}))?([-. (]*(\d{3})[-. )]*)?((\d{3})[-. ]*(\d{2,4})(?:[-.x ]*(\d+))?)\s*$"
                            name="phone" placeholder="+79999999999" />
                        <span class="glyphicon form-control-feedback"></span>
                    </div>
                </div>
                <div class="form-group has-feedback">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-firstName"></i></span>
                        <input type="text" class="form-control" required="required" pattern="\b[\w\.-]+@[\w\.-]+\.\w{2,4}\b"
                            name="email" placeholder="masha@yandex.com" />
                        <span class="glyphicon form-control-feedback"></span>
                    </div>
                </div>
                <div class="form-group has-feedback">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-firstName"></i></span>
                        <input type="text" class="form-control" required="required"
                            name="text" placeholder="Трудолюбивая, умею..." />
                        <span class="glyphicon form-control-feedback"></span>
                    </div>
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
               <button type="button" id="save" class="btn btn-default" data-toggle="modal" data-target="#send">
                   Отправить</button>

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
                                Все указанные данные верны?
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
                                <button type="submit" class="btn btn-secondary">Да, все верно</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        <script>
            $(function() {
                $('#save').click(function() {
                    var formValid = true;
                    $('input').each(function() {
                        var formGroup = $(this).parents('.form-group');
                        var glyphicon = formGroup.find('.form-control-feedback');
                        if (this.checkValidity()) {
                            formGroup.addClass('has-success').removeClass('has-error');
                            glyphicon.addClass('glyphicon-ok').removeClass('glyphicon-remove');
                        } else {
                            formGroup.addClass('has-error').removeClass('has-success');
                            glyphicon.addClass('glyphicon-remove').removeClass('glyphicon-ok');
                            formValid = false;
                        }
                    });
                   if (formValid) {
                       $('#send');
                   }
                });
            });
        </script>
        </div>

    <br></br>
    <a href="/vacancy/${id}" class="btn text-nowrap-light">Назад к вакансии</a>

</@c.page>