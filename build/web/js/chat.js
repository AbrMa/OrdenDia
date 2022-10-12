// init
window.chat = {};

// post to send message to chat.do
chat.sendMsg = function (msg) {
    var request;
    msg = msg.replace(/&/g, '&amp;') //Evita la inserción de caracteres que puedan alterar el chat
                .replace(/</g, '&lt;')
                .replace(/>/g, '&gt;')
                .replace(/"/g, '&quot;')
                .replace(/\n/g, '<br/>'); 
    if (request = this.getXmlHttpRequest()) {
        request.open('POST', 'chat.do?action=send&msg='+msg+'&time='+new Date().getTime());
        request.send(null);
        chat.updateContent('<div>Mensaje: '+msg+'</div>');
    }
};

// Recupera el estatus de conexión 
chat.startListen = function () {
    if (!chat.listen)
        chat.listen = setInterval (function () {
            var request;
            if (request = chat.getXmlHttpRequest()) {
                request.open('POST', 'chat.do?action=get&time='+new Date().getTime());
                request.send(null);
                request.onreadystatechange = function() {
                    if(request.readyState === 4) {
                        if(request.status === 200) {
                            var json = request.responseText;
                            // nuevo meensaje
                            if (json && json.length) {
                                //arreglo
                                var obj = eval('(' + json + ')');
                                var msg = '';
                                for (var i = 0; i < obj.length; i++) {
                                    msg += '<div>'+obj[i]+'</div>';
                                }
                                chat.updateContent(msg);
                            }
                        } else if(request.status === 400 || request.status === 500)
                            //document.location.href = 'index.html';
                                alert("ya fuiste men");
                    }
                };
            }
        }, 3000);
};

chat.updateContent = function (msg) {
    var content = document.getElementById('content'),
        atBottom = (content.scrollTop + content.offsetHeight) >= content.scrollHeight;
    content.innerHTML += msg;
    // Sube los mensajes
    if (atBottom)
        content.scrollTop = content.scrollHeight;
};
chat.dokeyup = function (event) {
    if (!event) //Internet Explores
        event = window.event;
    if (event.keyCode == 13 && !event.shiftKey) { //Envía mensaje
        var target = (event.currentTarget) ? event.currentTarget : event.srcElement,
            value = target.value;
        // Inserta el mensaje en el cuadro de texto
        if (value && value.replace(/^\s\s*/, '').replace(/\s\s*$/, '').length > 0) {
            this.sendMsg(target.value);
            target.value = '';
        }
    }
};
// get the XmlHttpRequest object
chat.getXmlHttpRequest = function () {
    if (window.XMLHttpRequest
        && (window.location.protocol !== 'file:' 
        || !window.ActiveXObject))
        return new XMLHttpRequest();
    try {
        return new ActiveXObject('Microsoft.XMLHTTP');
    } catch(e) {
        throw new Error('XMLHttpRequest not supported');
    }
};
onload = function () {
    chat.startListen();
};/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


