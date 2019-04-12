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
function drawcross(x,y) { 
	ct.beginPath() 
	ct.moveTo(x,y) 
	ct.lineTo(x+30,y) 
	ct.lineTo(x+30,y+45) 
	ct.lineTo(x+75,y+45) 
	ct.lineTo(x+75,y+75)
	ct.lineTo(x+30,y+75) 
	ct.lineTo(x+30,y+120)
	ct.lineTo(x,y+120) 
	ct.lineTo(x,y+75) 
	ct.lineTo(x-45,y+75) 
	ct.lineTo(x-45,y+45) 
	ct.lineTo(x,y+45)  
	ct.fill()
}
A("hello this is program a flag of a country you want") 
var want=prompt("what country do you want the flag of?flags avaliable:Germany,Belgium,Estonia,Italy,Austria,Bugaria,France,Hungary,Ireland,Latvia,Denmark,Czech Republic,Finland,Georgia") 
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
	ct.strokeStyle="black" 
	ct.strokeRect(0,0,600,600)
} 
if(want == "austria"|| want == "Austria") {
	ct.fillStyle="red"; 
	ct.fillRect(0,0,800,200) 
	ct.fillStyle="red" 
	ct.fillRect(0,400,800,200)  
	ct.strokeStyle="black" 
	ct.strokeRect(0,0,800,600)
} 
if(want == "bulgaria"|| want == "Bulgaria") {
	ct.fillStyle="green"; 
	ct.fillRect(0,200,800,200) 
	ct.fillStyle="red" 
	ct.fillRect(0,400,800,200) 
	ct.strokeStyle="black" 
	ct.strokeRect(0,0,800,600)	
}  
if(want == "estonia" || want == "Estonia") { 
	ct.fillStyle="dodgerblue" 
	ct.fillRect(0,0,800,200) 
	ct.fillStyle="black" 
	ct.fillRect(0,200,800,200) 
	ct.strokeStyle="black" 
	ct.strokeRect(0,0,800,600)
}
if(want == "france"|| want == "France") {
	ct.fillStyle="blue"; 
	ct.fillRect(0,0,200,600) 
	ct.fillStyle="red" 
	ct.fillRect(400,0,200,600)  
	ct.strokeStyle="black" 
	ct.strokeRect(0,0,600,600)
} 
if(want == "hungary"|| want == "Hungary") {
	ct.fillStyle="red"; 
	ct.fillRect(0,0,800,200) 
	ct.fillStyle="green" 
	ct.fillRect(0,400,800,200)  
	ct.strokeStyle="black" 
	ct.strokeRect(0,0,800,600)
} 
if(want == "ireland"|| want == "Ireland" || want == "irland") {
	ct.fillStyle="green"; 
	ct.fillRect(0,0,200,600) 
	ct.fillStyle="orange" 
	ct.fillRect(400,0,200,600)  
	ct.strokeStyle="black" 
	ct.strokeRect(0,0,600,600)
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
if(want == "czech" || want == "Czech" || want == "zech" || want == "czech republic" || want == "Czech republic" || want == "czechrepublic" || want == "Czech Republic" || want == "crepublic" || want == "czech Republic") { 
	ct.fillStyle="darkblue" 
	ct.beginPath() 
	ct.moveTo(0,0) 
	ct.lineTo(500,230) 
	ct.lineTo(0,500) 
	ct.fill() 
	ct.fillStyle="firebrick" 
	ct.beginPath() 
	ct.moveTo(0,500) 
	ct.lineTo(500,230) 
	ct.lineTo(1000,230) 
	ct.lineTo(1000,500) 
	ct.fill() 
	ct.strokeStyle="black" 
	ct.strokeRect(0,0,1000,500)
} 
if(want == "finland" || want == "Finland" || want == "angry birds") { 
	ct.fillStyle="darkblue" 
	ct.fillRect(250,0,125,530)  
	ct.fillStyle="darkblue" 
	ct.fillRect(0,200,800,130) 
	ct.strokeStyle="black" 
	ct.strokeRect(0,0,800,530)
	
} 
if(want == "georgia" || want == "Georgia") { 
	ct.fillStyle="red" 
	ct.fillRect(330,0,90,530)  
	ct.fillStyle="red" 
	ct.fillRect(0,200,800,95)  
	drawcross(152,37)  
	drawcross(152,350) 
	drawcross(592,37) 
	drawcross(592,350)
	ct.strokeStyle="black" 
	ct.strokeRect(0,0,800,530)
}
