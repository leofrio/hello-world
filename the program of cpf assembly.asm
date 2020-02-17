
; You may customize this and other start-up templates; 
; The location of this template is c:\emu8086\inc\0_com_template.txt

org 100h
jmp inicio 
msg DB "o digito verificador do meu cpf e:",24h
inicio: lea dx,msg 
        mov ah,09h 
        int 21h

mov dx,0
mov al,3
mov bl,2
mul bl
add dx,ax  

mov al,8 
mov bl,3
mul bl 
add dx,ax 

mov al, 0 
mov bl, 4 
mul bl 
add dx,ax

mov al,5 
mov bl,5
mul bl 
add dx,ax  

mov al,2 
mov bl,6
mul bl 
add dx,ax 

mov al,5 
mov bl,7
mul bl 
add dx,ax

mov al,0 
mov bl,8
mul bl 
add dx,ax        
          
mov al,7 
mov bl,9
mul bl 
add dx,ax 

mov al,0 
mov bl,10
mul bl 
add dx,ax 
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

;segundo digito(11 posicao)
mov dx,0
mov al,0
mov bl,2
mul bl
add dx,ax  

mov al,3 
mov bl,3
mul bl 
add dx,ax 

mov al,8 
mov bl,4
mul bl 
add dx,ax 

mov al,0 
mov bl,5
mul bl 
add dx,ax 

mov al,5 
mov bl,6
mul bl 
add dx,ax 

mov al,2 
mov bl,7
mul bl 
add dx,ax
         
mov al,5 
mov bl,8
mul bl 
add dx,ax         
        
mov al,0 
mov bl,9
mul bl 
add dx,ax 

mov al,7 
mov bl,10
mul bl 
add dx,ax  

mov al,0 
mov bl,11
mul bl 
add dx,ax 

  
;dx=soma de tudo  

mov ax,dx 
mov bl,11
div bl    
  
  
cmp ah,0 
je igual1 
jmp diferente1 
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


 

     
         
ret




