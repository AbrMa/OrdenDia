
var vdd = false;

var websocket = new WebSocket("ws://192.168.5.83:8080/OrdenDia/servidor");

websocket.onmessage = function procesaMensaje(mensaje) {
    var jsonDato = JSON.parse(mensaje.data);
    if (jsonDato.Mensaje !== "")
        areaTexto.innerHTML += jsonDato.Mensaje + "\n";
};
function mandarMensaje() {
    if (vdd) {
        if (mensaje.value !== "" && mensaje.value !== null) {
            websocket.send(mensaje.value);
            mensaje.value = "";
        }
    } else {
        mensaje.style.display ="block";
        websocket.send(usuario.value);
        enviar.value = "Enviar";
        vdd = true;
    }
}

