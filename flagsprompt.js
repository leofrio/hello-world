function skip() { 
	document.write("<br>")
}
function show(text) { 
	document.write(text) 
	skip()
} 
function A(al) { 
	alert(al)
} 
A("hello this is program that shows the flag of a country you want") 
var want=prompt("what country do you want the flag of?flags avaliable:Germany,Belgium,Italy,Austria,Bugaria,France,Hungary,Ireland,Latvia,Denmark") 
var screen=document.getElementById("screen") 
var ct= screen.getContext("2d")  
if(want == "germany"|| want == "Germany") {
	ct.fillStyle="black"; 
	ct.fillRect(0,0,800,200) 
	ct.fillStyle="red" 
	ct.fillRect(0,200,800,200)
	ct.fillStyle="yellow" 
	ct.fillRect(0,400,800,200) 
} 
if(want == "belgium"|| want == "Belgium") {
	ct.fillStyle="black"; 
	ct.fillRect(0,0,200,600) 
	ct.fillStyle="yellow" 
	ct.fillRect(200,0,200,600)
	ct.fillStyle="red" 
	ct.fillRect(400,0,200,600) 
}  
if(want == "italy"|| want == "Italy") {
	ct.fillStyle="green"; 
	ct.fillRect(0,0,200,600) 
	ct.fillStyle="red" 
	ct.fillRect(400,0,200,600) 
} 
if(want == "austria"|| want == "Austria") {
	ct.fillStyle="red"; 
	ct.fillRect(0,0,800,200) 
	ct.fillStyle="red" 
	ct.fillRect(0,400,800,200) 
} 
if(want == "bulgaria"|| want == "Bulgaria") {
	ct.fillStyle="green"; 
	ct.fillRect(0,200,800,200) 
	ct.fillStyle="red" 
	ct.fillRect(0,400,800,200) 
} 
if(want == "france"|| want == "France") {
	ct.fillStyle="blue"; 
	ct.fillRect(0,0,200,600) 
	ct.fillStyle="red" 
	ct.fillRect(400,0,200,600) 
} 
if(want == "hungary"|| want == "Hungary") {
	ct.fillStyle="red"; 
	ct.fillRect(0,0,800,200) 
	ct.fillStyle="green" 
	ct.fillRect(0,400,800,200) 
} 
if(want == "ireland"|| want == "Ireland" || want == "irland") {
	ct.fillStyle="green"; 
	ct.fillRect(0,0,200,600) 
	ct.fillStyle="orange" 
	ct.fillRect(400,0,200,600) 
} 
if(want == "latvia"|| want == "Latvia" || want == "latva") {
	ct.fillStyle="darkred"; 
	ct.fillRect(0,0,700,150) 
	ct.fillStyle="darkred" 
	ct.fillRect(0,210,700,150) 
} 
if(want == "denmark" || want == "Denmark") { 
	ct.fillStyle="crimson" 
	ct.fillRect(0,0,300,200) 
	ct.fillStyle="crimson" 
	ct.fillRect(370,0,400,200) 
	ct.fillStyle="crimson" 
	ct.fillRect(0,270,300,200) 
	ct.fillStyle="crimson" 
	ct.fillRect(370,270,400,200)
}
