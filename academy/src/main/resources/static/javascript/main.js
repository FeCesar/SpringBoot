
// Button_Gerar_Matricula

const buttonMatricula = document.getElementById("gerarMatricula")

buttonMatricula.addEventListener('click', () =>{
    var texto = "ACA"
    var aleatorio = Math.floor(Math.random() * 1500);

    document.getElementById("matricula").value = (texto + aleatorio)

})