function setOp(operacao) {
    var f = document.forms[0];
    var c = f.elements['op'];
    c.value = operacao;
    f.submit();
}

function setOpForm(formname, operacao) {
    var f = document.forms[formname];
    var c = f.elements['op'];
    c.value = operacao;
    f.submit();
}

function setOpPortal(formname, operacao, page) {
    //alert(formname + ' ' + operacao + ' ' + page );
    var f = document.forms[formname];
    var c = f.elements['op'];
    c.value = operacao;
    //alert(c.value);
    var p = f.elements['urlCanal'];
    p.value=page;
    //alert(p.value);
    f.submit();
}

function setfocus() {
    var campos = document.forms[0].elements;
    for (var i=0; i < campos.length; i++) {
        if (campos[i].type != "hidden" && campos[i].type != "button" && 
            campos[i].type != "reset" && campos[i].type != "submit") {

            campos[i].focus();
            return;
        }
    }
    return;
}
 
/**
 * Define o foco para o proximo campo do formulário
 */
function nextField(fieldActual, e) {
    if (e && e.keyCode == 13) {
        var f = document.forms[0];
        var fields = f.elements;
        for(i=0; i < fields.length; i++) {
            if (fields[i]  == fieldActual) {
                fields[i+1].focus();
                return;
            }
        }
    }
}
function enter(e) {
    if (e && e.keyCode == 13)
        document.forms[0].submit();
}
    
function formata(val)
{
    var pass = val.value;
    var expr = /[0123456789]/;
		
    for(i=0; i<pass.length; i++){
        // charAt -> retorna o caractere posicionado no índice especificado
        var lchar = val.value.charAt(i);
        var nchar = val.value.charAt(i+1);
	
        if(i==0){
            // search -> retorna um valor inteiro, indicando a posição do inicio da primeira
            // ocorrência de expReg dentro de instStr. Se nenhuma ocorrencia for encontrada o método retornara -1
            // instStr.search(expReg);
            if ((lchar.search(expr) != 0) || (lchar>3)){
                val.value = "";
            }
		   
        }else if(i==1){
			   
            if(lchar.search(expr) != 0){
                // substring(indice1,indice2)
                // indice1, indice2 -> será usado para delimitar a string
                var tst1 = val.value.substring(0,(i));
                val.value = tst1;				
                continue;			
            }
			   
            if ((nchar != '/') && (nchar != '')){
                var tst1 = val.value.substring(0, (i)+1);
				
                if(nchar.search(expr) != 0) 
                    var tst2 = val.value.substring(i+2, pass.length);
                else
                    var tst2 = val.value.substring(i+1, pass.length);
	
                val.value = tst1 + '/' + tst2;
            }

        }else if(i==4){
			
            if(lchar.search(expr) != 0){
                var tst1 = val.value.substring(0, (i));
                val.value = tst1;
                continue;			
            }
		
            if	((nchar != '/') && (nchar != '')){
                var tst1 = val.value.substring(0, (i)+1);

                if(nchar.search(expr) != 0) 
                    var tst2 = val.value.substring(i+2, pass.length);
                else
                    var tst2 = val.value.substring(i+1, pass.length);
	
                val.value = tst1 + '/' + tst2;
            }
        }
		
        if(i>=6){
            if(lchar.search(expr) != 0) {
                var tst1 = val.value.substring(0, (i));
                val.value = tst1;			
            }
        }
    }
	
    if(pass.length>10)
        val.value = val.value.substring(0, 10);
    return true;
}

function mascara(o,f){
    v_obj=o
    v_fun=f
    setTimeout("execmascara()",1)
}

function execmascara(){
    v_obj.value=v_fun(v_obj.value)
}

function soNumeros(v){
    return v.replace(/\D/g,"")
}

function telefone(v){
    v=v.replace(/\D/g,"")                 //Remove tudo o que não é dígito
    v=v.replace(/^(\d\d)(\d)/g,"($1) $2") //Coloca parênteses em volta dos dois primeiros dígitos
    v=v.replace(/(\d{4})(\d)/,"$1-$2")    //Coloca hífen entre o quarto e o quinto dígitos
    return v
}

function cpf(v){
    v=v.replace(/\D/g,"")                    //Remove tudo o que não é dígito
    v=v.replace(/(\d{3})(\d)/,"$1.$2")       //Coloca um ponto entre o terceiro e o quarto dígitos
    v=v.replace(/(\d{3})(\d)/,"$1.$2")       //Coloca um ponto entre o terceiro e o quarto dígitos
                                             //de novo (para o segundo bloco de números)
    v=v.replace(/(\d{3})(\d{1,2})$/,"$1-$2") //Coloca um hífen entre o terceiro e o quarto dígitos
    return v
}

function cep(v){
    v=v.replace(/D/g,"")                //Remove tudo o que não é dígito
    v=v.replace(/^(\d{5})(\d)/,"$1-$2") //Esse é tão fácil que não merece explicações
    return v
}

function cnpj(v){
    v=v.replace(/\D/g,"")                           //Remove tudo o que não é dígito
    v=v.replace(/^(\d{2})(\d)/,"$1.$2")             //Coloca ponto entre o segundo e o terceiro dígitos
    v=v.replace(/^(\d{2})\.(\d{3})(\d)/,"$1.$2.$3") //Coloca ponto entre o quinto e o sexto dígitos
    v=v.replace(/\.(\d{3})(\d)/,".$1/$2")           //Coloca uma barra entre o oitavo e o nono dígitos
    v=v.replace(/(\d{4})(\d)/,"$1-$2")              //Coloca um hífen depois do bloco de quatro dígitos
    return v
}

function romanos(v){
    v=v.toUpperCase()             //Maiúsculas
    v=v.replace(/[^IVXLCDM]/g,"") //Remove tudo o que não for I, V, X, L, C, D ou M
    //Essa é complicada! Copiei daqui: http://www.diveintopython.org/refactoring/refactoring.html
    while(v.replace(/^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$/,"")!="")
        v=v.replace(/.$/,"")
    return v
}

function site(v){
    //Esse sem comentarios para que você entenda sozinho ;-)
    v=v.replace(/^http:\/\/?/,"")
    dominio=v
    caminho=""
    if(v.indexOf("/")>-1)
        dominio=v.split("/")[0]
        caminho=v.replace(/[^\/]*/,"")
    dominio=dominio.replace(/[^\w\.\+-:@]/g,"")
    caminho=caminho.replace(/[^\w\d\+-@:\?&=%\(\)\.]/g,"")
    caminho=caminho.replace(/([\?&])=/,"$1")
    if(caminho!="")dominio=dominio.replace(/\.+$/,"")
    v="http://"+dominio+caminho
    return v
}
function Limpar(valor, validos) {
// retira caracteres invalidos da string
var result = "";
var aux;
for (var i=0; i < valor.length; i++) {
aux = validos.indexOf(valor.substring(i, i+1));
if (aux>=0) {
result += aux;
}
}
return result;
}

//Formata número tipo moeda usando o evento onKeyDown

function Formata(campo,tammax,teclapres,decimal) {
var tecla = teclapres.keyCode;
vr = Limpar(campo.value,"0123456789");
tam = vr.length;
dec=decimal

if (tam < tammax && tecla != 8){ tam = vr.length + 1 ; }

if (tecla == 8 )
{ tam = tam - 1 ; }

if ( tecla == 8 || tecla >= 48 && tecla <= 57 || tecla >= 96 && tecla <= 105 )
{

if ( tam <= dec )
{ campo.value = vr ; }

if ( (tam > dec) && (tam <= 5) ){
campo.value = vr.substr( 0, tam - 2 ) + "," + vr.substr( tam - dec, tam ) ; }
if ( (tam >= 6) && (tam <= 8) ){
campo.value = vr.substr( 0, tam - 5 ) + "." + vr.substr( tam - 5, 3 ) + "," + vr.substr( tam - dec, tam ) ;
}
if ( (tam >= 9) && (tam <= 11) ){
campo.value = vr.substr( 0, tam - 8 ) + "." + vr.substr( tam - 8, 3 ) + "." + vr.substr( tam - 5, 3 ) + "," + vr.substr( tam - dec, tam ) ; }
if ( (tam >= 12) && (tam <= 14) ){
campo.value = vr.substr( 0, tam - 11 ) + "." + vr.substr( tam - 11, 3 ) + "." + vr.substr( tam - 8, 3 ) + "." + vr.substr( tam - 5, 3 ) + "," + vr.substr( tam - dec, tam ) ; }
if ( (tam >= 15) && (tam <= 17) ){
campo.value = vr.substr( 0, tam - 14 ) + "." + vr.substr( tam - 14, 3 ) + "." + vr.substr( tam - 11, 3 ) + "." + vr.substr( tam - 8, 3 ) + "." + vr.substr( tam - 5, 3 ) + "," + vr.substr( tam - 2, tam ) ;}
}

}


