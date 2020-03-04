; You may customize this and other start-up templates; 
; The location of this template is c:\emu8086\inc\0_com_template.txt

org 100h 
.DATA   
msg Db "seu digito verificador e:",24h
cpf db 00d,07d,00d,05d,02d,05d,00d,08d,03d


;MOVENDO SEGMENTO DE DADOS
.CODE 
lea dx,msg 
mov ah,09h 
int 21h 



mov ax,0030h 
mov ds,ax  

;manipular a string do inicio

mov si,ax
;dx=soma de tudo 

mov dx,0

;dando valor ao contador

mov cx,9d 

;iniciando loop
inicio: 
mov al,[si]
dec bl 
mul bl  
add dx,ax 
inc si  
loop inicio

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
int 20h    
ret