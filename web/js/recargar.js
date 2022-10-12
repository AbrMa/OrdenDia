/* 
 *@Author: Angel
 */

$(document).ready(function () {
    var id1 = $('#usuario').val();
    var id2 = $('#idRecibe').val();
    $.post('Servidor', {envia: id1,recibe:id2});
});