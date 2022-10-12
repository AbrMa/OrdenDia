     function solonumeros1(e)
            {
                key = e.keyCode || e.which;
                if ((key >= 48 && key <= 57))
                    return true;
                else
                    return false;
            }
              function letraVal(e) {
                tecla = document.all ? e.keyCode : e.which;
                if (tecla === 8 || tecla === 32)
                    return true;
                patron = /[a-z]|[A-Z]|á|é|í|ó|ú|Á|É|Í|Ó|Ú/;
                te = String.fromCharCode(tecla);
                return patron.test(te);
            }
     
            
