; You may customize this and other start-up templates; 
; The location of this template is c:\emu8086\inc\0_com_template.txt

org 100h 
#MEM=300,000700050205000803#
#make_bin#


;MOVENDO SEGMENTO DE DADOS

mov ax,0030h 
mov ds,ax  

;manipular a string do inicio

mov si,0

;Soma =0

mov dx,0

mov al,[si]
mov bl,10
mul bl
add dx,ax 
inc si

mov al, [si] 
dec bl 
mul bl
add dx,ax 
inc si 

mov al, [si] 
dec bl 
mul bl
add dx,ax 
inc si

mov al, [si] 
dec bl 
mul bl
add dx,ax 
inc si

mov al, [si] 
dec bl 
mul bl
add dx,ax 
inc si

mov al, [si] 
dec bl 
mul bl
add dx,ax 
inc si

mov al, [si] 
dec bl 
mul bl
add dx,ax 
inc si

mov al, [si] 
dec bl 
mul bl
add dx,ax 
inc si

mov al, [si] 
dec bl 
mul bl
add dx,ax 
inc si

mov al, [si] 
dec bl 
mul bl
add dx,ax 
inc si


;dx=soma de tudo  

mov ax,dx 
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