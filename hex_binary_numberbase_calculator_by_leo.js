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
var want=prompt("do you want to have your number calculated in 1-binary 2-hexadecimal 3- a base you decide;type only the number or the word with no capitals") 

if(want == "1" || want == "binary") { 
	var number=parseInt(prompt("what is the number you want to pass to binary"))
	if(number >= 0) {
		a=[] 
		var i = 0 
		var arnaldo; 
		for(var c=number ; c > 0; c=Math.floor(c/2)) { 
			arnaldo=c % 2 
			a[i]=arnaldo 
			i++
		}  
		document.write(number +  " in binary equals:")
		for(var b = i-1 ; b >= 0; b--) { 
			document.write(a[b])
		} 
 	} 
	if(number <  0) { 
		A("since the number you want is negaative, we will have to use the binary signed 2 format")
		a=[] 
		var i = 0 
		var arnaldo; 
		for(var c=number ; c > 0; c=Math.floor(c/2)) { 
			arnaldo=c % 2 
			if(arnaldo == 1) { 
				arnaldo = 0
			} 
			if(arnaldo == 0) { 
				arnaldo = 1
			} 
			a[i]=arnaldo  
			i++
		}  
		document.write(number +  " in binary signed 2 form equals:")
		for(var b = i-1 ; b >= 0; b--) { 
			document.write(a[b])
		}
	}
} 
if(want == "2" || want == "hexadecimal") {
	a=[] 
	var i = 0 
	var arnaldo; 
	var number=parseInt(prompt("what is the number you want to pass to hexadecimal"))
	for(var c=number ; c > 0; c=Math.floor(c/16)) { 
		arnaldo=c % 16  
		if(arnaldo >= 10 && arnaldo <= 15) { 
			if(arnaldo == 10) { 
				arnaldo="A"
			} 
			if(arnaldo == 11) { 
				arnaldo="B"
			} 
			if(arnaldo == 12) { 
				arnaldo="C"
			} 
			if(arnaldo == 13) { 
				arnaldo="D"
			} 
			if(arnaldo == 14) { 
				arnaldo="E"
			} 
			if(arnaldo == 15) { 
				arnaldo="F"
			}
		} 
		a[i]=arnaldo 
		i++
	}  
	document.write(number +  " in hexadecimal equals:")
	for(var b = i-1 ; b >= 0; b--) { 
		document.write(a[b])
	} 
} 
if(want == "3" || want == "a base you decide" || want == "base") { 
	base=parseInt(prompt("what is the base you want to put your number in?the number you put is a decimal, so its already on the 10 base)")) 
	a=[] 
	var i = 0 
	var arnaldo; 
	var number=parseInt(prompt("what is the number you want to pass to the" + base + "th base"))
	for(var c=number ; c > 0; c=Math.floor(c/base)) { 
		arnaldo=c % base 
		a[i]=arnaldo 
		i++
	}  
	if(base == 2 || base == 10) {  
		if(base == 2) { 
			document.write(number +  " in the second base(binary) equals:")
		} 
		if(base == 10) {  
		document.write(number +  " in the tenth base(decimal,just the number itself) equals: ")
		}
	} 
	else { 
	document.write(number +  " in the " + base + "th base equals:") 	 
	}
	for(var b = i-1 ; b >= 0; b--) { 
		document.write(a[b])
	} 
} 
