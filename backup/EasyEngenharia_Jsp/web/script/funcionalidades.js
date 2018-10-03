/**
	@author Breno Souza Oliveira 
	Funcao feita para marcar o checkbox selecionado em uma lista.
	@param Nome (nome do checkbox) 
*/

function verificaCheck(nome) {
	//Pega o checkbox da pagina pelo nome dele passado nas tags do html.
	checkbox = document.getElementById(nome);
	//Teste para saber se o valor que veio foi verdadeiro ou falso e marcar o checkbox de acordo com o teste.
	if (checkbox.value == "T") {
		checkbox.checked = true;
	} else {
		checkbox.checked = false;
	}
}

/**
	@author Breno Souza Oliveira
	@param Nome (nome da combo), value (valor do item)
	Funcao feita para selecionar um item da lista na combobox(SELECT). 
*/
function verificaSelect(nome, value) {
	//Pega o select da pagina pelo nome dele passado nas tags do html.
	select = document.getElementsByName(nome);
	//Tamanho do select (todos os itens dele)
	tamanho = select.length;
	//Varre o select.
	for (i=0; i<=tamanho; i++) {
		//Testa o valor passado com o do select, caso verdadeiro seleciona o item do select.
		if (value == select.value) {
			select.options[i].selected = true;
		}
	}
}

function adicionaBarra(campo) {
	if (campo.value.length == 2 || campo.value.length == 5) {
		campo.value = campo.value + "/";
	}
}



function CPF(campo) {	
	if (campo.value.length == 3 || campo.value.length == 7) {
		campo.value = campo.value + ".";
	}
	if (campo.value.length == 11) {
		campo.value = campo.value + "-";
	}
	if (campo.value.length == 14) {
		validaCPF(campo);
	}
}

function validaCPF(campo) {
	cpf = campo.value;
	erro = new String;
	if (cpf.lenght < 14) {
		erro += "O CPF tem no minimo 11 digitos! \n\n";
	}
	if (cpf == "000.000.000-00" || cpf == "111.111.111-11" || cpf == "222.222.222-22" || cpf == "333.333.333-33" || cpf == "444.444.444-44" || cpf == "555.555.555-55" || cpf == "666.666.666-66" || cpf == "777.777.777-77" || cpf == "888.888.888-88" || cpf == "999.999.999-99") {
		erro += "CPF inv�lido! \n\n";
	}
	var a = [];
	var b = new Number;
	var c = 11;
	var m = 0;
	var j = 0;
	while (m < 9) {
		if (j==3 || j==7 || j==11) {
			j++
		} else {
			a[m] = cpf.charAt(j);	
			m++;
			j++;
		}
			
	}
	
	for (i=0; i<9; i++) {
			b += (a[i] * --c);
	}
	if ((x = b % 11) < 2) {
		a[9] = 0;
	} else {
		a[9] = 11-x;
	}
	b = 0;
	c = 11;
	for (y=0; y<10; y++) {
		b += (a[y] * c--);
	}
	if ((x = b % 11) < 2) {
		a[10] = 0;
	} else {
		a[10] = 11-x;
	}
	if(cpf.charAt(12) != a[9] || cpf.charAt(13) != a[10]) {
		erro += "CPF incorreto! \n\n";
	}
	if (erro.length > 0) {
		alert(erro);
		return false;
	} else {
		alert("CPF OK!");
		return true;
	}
}

function CEP(campo) {
	if (campo.value.length == 5) {
		campo.value = campo.value + "-";
	}
}

function validaEmail(campo) {
	erro = new String;
	cont = new Number;
	j = new Number;
	for (i = 0; i < campo.value.length; i++) {
		if (campo.value.charAt(i) == "@") {
			if (i > 2) {
				cont += 1;
				j = i;
			} else {
				erro = "Campo sem @ ou o nome menor que 3 caracteres!";
			}	
		} 
	}
	t = 0;
	for (z = j; z < campo.value.length; z++) {
		if (campo.value.charAt(z) == ".") {
			if (t >= 1) {
				cont += 1;
				j = 0;
				j = z;
			} else {
				erro += "Servidor com menos de 2 letras!";
			}
		}
		t++;
	}
	for (x = j; x < campo.value.length; x++) {
		if (campo.value.length < 3) {
			erro += "Falta algo apos o . !"; 
		}
	}
	if (cont == 2 && erro == "") {
		alert("EMAIL valido");
	} else {
		alert(erro);
	}
}


function telefone(campo) {
	if(campo.value.length == 0){
		campo.value = campo.value + "(";
	}
	if(campo.value.length == 3){
		campo.value = campo.value + ")";
	}
	if(campo.value.length == 8){
		campo.value = campo.value + "-";
	}
}

 
