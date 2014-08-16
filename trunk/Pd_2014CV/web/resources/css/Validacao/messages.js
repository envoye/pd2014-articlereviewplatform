/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

jQuery.extend(jQuery.validator.messages, {
    required: "Este campo é obrigatório.",
    remote: "Corrija este campo.",
    email: "Por favor insira um endereço de e-mail válido.",
    url: "Digite uma URL válida.",
    date: "Por favor, insira uma data válida.",
    dateISO: "Por favor, insira uma data válida (ISO).",
    number: "Por favor insira um número válido.",
    digits: "Por favor, insira apenas dígitos.",
    creditcard: "Por favor insira um número de cartão de crédito válido.",
    equalTo: "Por favor, insira o mesmo valor novamente.",
    accept: "Por favor o ficheiro terá de ter uma extensão válida.",
    maxlength: jQuery.validator.format("O campo terá de ter no maximo {0} caracteres."),
    minlength: jQuery.validator.format("O campo terá de ter no minimo {0} caracteres."),
    rangelength: jQuery.validator.format("O campo deverá ter entre {0} e {1} caracteres."),
    range: jQuery.validator.format("Intruduza um valor entre {0} e {1}."),
    max: jQuery.validator.format("Por favor insira um valor menor ou igual a {0}."),
    min: jQuery.validator.format("Por favor insira um valor maior ou igual a {0}.")
});

$.validator.addMethod(
        "regex",
        function(value, element, regexp) {
            var re = new RegExp(regexp);
            return this.optional(element) || re.test(value);
        },
        "O formato que intruduzio é invalido({0})"
);
