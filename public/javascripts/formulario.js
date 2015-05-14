/**
 * Created by andreluiz on 5/14/15.
 * Javascript para a checagem da validade de formulário.
 *
 * */
function validarFormulario(event)
{
    var okay = false;
    var fb = document.getElementsByName("fb").value;
    var email = document.getElementsByName("email").value;

    if((fb == "" || fb == null) || (email == "" || email == null)) {
        okay = false;
        mensagem = "Você deve preencher ao menos uma forma de contato."
    }

    if(!okay)
        var n = noty({
            text: mensagem,
            type: "error",
            layout: "bottom",
            theme: "relax",
            animation: {
                open: 'animated flipInX', // Animate.css class names
                close: 'animated flipOutX', // Animate.css class names
                easing: 'swing', // unavailable - no need
                speed: 500 // unavailable - no need
            }
        });
    return okay;
}

