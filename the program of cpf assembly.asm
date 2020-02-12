
; You may customize this and other start-up templates; 
; The location of this template is c:\emu8086\inc\0_com_template.txt

org 100h

mov dx,0
mov al,9
mov bl,2
mul bl
add dx,ax  

mov al,4 
mov bl,3
mul bl 
add dx,ax 

mov al, 4 
mov bl, 4 
mul bl 
add dx,ax

mov al,9 
mov bl,5
mul bl 
add dx,ax  

mov al,4 
mov bl,6
mul bl 
add dx,ax 

mov al,7 
mov bl,7
mul bl 
add dx,ax

mov al,7 
mov bl,8
mul bl 
add dx,ax        
          
mov al,1 
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
div bl ;09   
  
mov bl,11
sub bl,ah  ;02   
                             
mov dl,bl
add dl,30h 
mov ah,02h 
int 21h

ret




