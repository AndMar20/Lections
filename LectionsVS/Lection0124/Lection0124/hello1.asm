includelib uer32.lib

.686
.model flat stdcall
.stack 4096
.data
	MB_OK equ 0
	str1 db "Привет",0
	str2 db "мир!",0
	HW dd ?
	EXTERN MessageBoxA@16: NEAR
.code
main proc
	push MB_OK
	push offset str1
	push offset str2
	push HW
	call MessageBoxA@16
	ret
main endp
end