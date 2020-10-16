<#import "parts/common.ftlh" as c>

<@c.page>
<br>
  <h3 style="margin-left: 20%">Отправить нам резюме</h3><br>
    <p style="margin-left: 20%"><strong>Вакансия: ${vacancy.name}</strong></p>

    <div>
            <form method="post">
                <div class="form-group has-feedback">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-firstName"></i></span>
                        <input type="text" style="margin-left: 20%" class="form-control col-sm-3" required="required" pattern="[A-ZА-ЯЁ][a-zа-яё]+"
                            name="firstName" placeholder="Маша" />
                        <span class="glyphicon form-control-feedback"></span>
                    </div>
                </div>
                <div class="form-group has-feedback">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lastName"></i></span>
                        <input type="text" style="margin-left: 20%" class="form-control col-sm-3" required="required" pattern="[A-ZА-ЯЁ][a-zа-яё]+"
                            name="lastName" placeholder="Иванова" />
                        <span class="glyphicon form-control-feedback"></span>
                    </div>
                </div>
                <div class="form-group has-feedback">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-birthday"></i></span>
                        <input type="text" style="margin-left: 20%" class="form-control col-sm-3" required="required" pattern="(([0][1-9])|([12][0-9])|([3][01]))([.// -]*)(([0][1-9])|([1][0-2]))([.// -]*)(([1][9][4-9][0-9])|([2][0][0][0-5]))"
                            name="birthday" placeholder="13.02.1998" />
                        <span class="glyphicon form-control-feedback"></span>
                    </div>
                </div>
                <div class="form-group has-feedback">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-phone"></i></span>
                        <input type="text" style="margin-left: 20%" class="form-control col-sm-3" required="required" pattern="^\s*(?:\+?(\d{1,3}))?([-. (]*(\d{3})[-. )]*)?((\d{3})[-. ]*(\d{2,4})(?:[-.x ]*(\d+))?)\s*$"
                            name="phone" placeholder="+79999999999" />
                        <span class="glyphicon form-control-feedback"></span>
                    </div>
                </div>
                <div class="form-group has-feedback">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-email"></i></span>
                        <input type="text" style="margin-left: 20%" class="form-control col-sm-3" required="required" pattern="\b[\w\.-]+@[\w\.-]+\.\w{2,4}\b"
                            name="email" placeholder="masha@yandex.com" />
                        <span class="glyphicon form-control-feedback"></span>
                    </div>
                </div>
                <div class="form-group has-feedback">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-text"></i></span>
                        <textarea type="text" style="margin-left: 20%" class="form-control col-sm-3" rows="1" required="required"
                                  name="text" placeholder="Трудолюбивая, умею..."></textarea>
                        <span class="glyphicon form-control-feedback"></span>
                    </div>
                </div>
                <br>
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <div class="row">
               <button type="button" id="save" class="btn btn-dark" style="margin-left: 20.5%" data-toggle="modal" data-target="#send">
                   Отправить</button>
                <a href="/vacancy/${vacancy.id}" class="btn btn-light" style="margin-left: 10px">Назад к вакансии</a>
                </div>
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
                                <button type="submit" class="btn btn-dark">Да, все верно</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        <script>
            $(function() {
                $('#save').click(function() {
                    var formValid = true;
                    $('input|textarea').each(function() {
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

</@c.page>