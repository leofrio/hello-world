//aqui eu fiz rapidamente uma funcao skip para pular uma linha necessaria
function skip() {
	document.write("<br>")
} 
//abaixo estao as tres funcoes das 3 portas logias usadas nesse circuito
function NOT(a) {
	return !a 
} 
function OR(a,b) { 
	var s=a||b 
	return s
} 
function AND(a,b) { 
	var s=a&&b 
	return s
}  
//aqui esta  funcao parseBin que usa um if para podermos printar na tela um 1 ou 0 ao invez de um true ou false
function parseBin(c) { 
	if(c == true) { 
		c="1"
	} 
	else { 
		c="0"
	}  
	return c
}
var sum; 
var cout;
var x; 
/* aqui em baixo e onde se colocam as entradas em binario, que com o parseint ja deixam de ser strings
e a funcao "Boolean" garante que os resultado serao lidos na forma de true ou false"
*/
var a=Boolean(parseInt(prompt("qual o valor de a?"))) 
var b=Boolean(parseInt(prompt("qual o valor de b"))) 
//como a apenas um fulladder o cin e ligado ao zero,ou seja e false
var cin=false 
//aqui temos a variavel x que e uma forma de simplificar o codigo,ela e a primeira xor,que e usada nas variaveis a e b  
x=OR(AND(a,NOT(b)),AND(NOT(a),b)) 
//a sum, ja e a primeira saida e a o resultado da soma do full adder,e uma xor que usa o carry in ,junto com a x, que foi criada pois simplifica o programa
sum=OR(AND(x,NOT(cin)),AND(NOT(x),cin)) 
//a cout e a segunda saida que corresponde ao carryout,ela e uma or e com duas ands com x e carryin como entrada 
cout=OR(AND(cin,x),AND(a,b))   
//aqui printamos o resultado usando a funcao parseBin que mostra o resultado em 1 ou 0
document.write("sum=" + parseBin(sum))
skip() 
document.write("carryout=" + parseBin(cout)) 
 

 