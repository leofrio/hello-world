org 100h

.DATA   
msg Db "seu digito verificador e:",24h
;cpf db 00,07,00,05,02,05,00,08,03,00 ;leo
cpf db 00,07,06,06,00,07,06,07,03,02 ;jao
;cpf db 00,03,07,09,02,04,02,01,03,03 ;sara


;MOVENDO SEGMENTO DE DADOS
.CODE 
lea dx,msg 
mov ah,09h 
int 21h 



;mov ax,0030h 
;mov ds,ax  
lea ax, cpf

;manipular a string do inicio

mov si,ax
;dx=soma de tudo 

mov dx,0

;dando valor ao contador
mov bl,10
mov cx,9

;iniciando loop
inicio: 
mov al,[si]
mul bl  
add dx,ax 
dec bl 
inc si  
loop inicio

mov ax, dx

;dividindo por 11
;mov ax,dx 
mov bl,11
div bl  
cmp ah,0 
je igual 
jmp diferente 
cmp ah,1  
je igual 
jmp diferente

diferente:sub bl,ah 
          mov dl,bl
          jmp exit        

igual: mov dx,0 
       jmp exit 
exit:                             
add dl,30h 
mov ah,02h 
int 21h     

mov al,[si] 
cmp bl,al 
jz invaldo: 
mov ah,02h 
mov dx  
int 21h 
mov dx 'I' 
int 21h
mov dx 'N' 
int 21h
mov dx 'V' 
int 21h
mov dx 'A' 
int 21h
mov dx 'L' 
int 21h
mov dx 'I' 
int 21h
mov dx 'D' 
int 21h
mov dx 'O' 
int 21h
int 20h

jz invaldo: 
mov ah,02h 
mov dx  
int 21h 
mov dx 'V' 
int 21h
mov dx 'A' 
int 21h
mov dx 'L' 
int 21h
mov dx 'I' 
int 21h
mov dx 'D' 
int 21h
mov dx 'O' 
int 21h
            
;segundo digito           
lea ax, cpf

;manipular a string do inicio

mov si,ax
;dx=soma de tudo 

mov dx,0            

mov bl,11d
mov cx,10d

inicio1: 
mov al,[si]
mul bl  
add dx,ax 
dec bl 
inc si  
loop inicio1 

mov ax,dx 

;dividindo por 11 dnv
;mov ax,dx 
mov bl,11
div bl  
cmp ah,0 
je igual1  
cmp ah,1  
je igual1 
jmp diferente1                              

diferente1:sub bl,ah 
          mov dl,bl
          jmp exit1        

igual1: mov dx,0 
       jmp exit1 
exit1:                             
add dl,30h  
mov ah,02h 
int 21h  
mov al,[si] 
cmp bl,al 
jz invaldo1: 
mov ah,02h 
mov dx  
int 21h 
mov dx 'I' 
int 21h
mov dx 'N' 
int 21h
mov dx 'V' 
int 21h
mov dx 'A' 
int 21h
mov dx 'L' 
int 21h
mov dx 'I' 
int 21h
mov dx 'D' 
int 21h
mov dx 'O' 
int 21h
int 20h

jz invaldo: 
mov ah,02h 
mov dx  
int 21h 
mov dx 'V' 
int 21h
mov dx 'A' 
int 21h
mov dx 'L' 
int 21h
mov dx 'I' 
int 21h
mov dx 'D' 
int 21h
mov dx 'O' 
int 21h


ret
