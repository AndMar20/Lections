;одна из них применяется
;.386
;.486
;.586
;.686p


;.model модель, языкб модификатор

;TINY
;SMALL
;MEDIUM
;LARGE
;FLAT

;stdcall
;cdecl
;BASIC
;FORTRAN
;PASCAL
;SYSCALL

;NEARSTACK
;FARTACK

.model flat stdcall

;.stack размер стэка

.data

...

.code 
main proc 

...

main endp
end