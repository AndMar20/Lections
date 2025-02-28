.686
.model flat, stdcall
.stack 4096

extern GetStdHandle@4 : PROC
extern ReadConsoleA@20 : PROC
extern WriteConsoleA@20 : PROC
extern ExitProcess@4 : PROC

includelib kernel32.lib

.data
	inputBuffer db 255 dup(?)
	bytesRead dd ?
	hStdInput dd ?
	hStdOutput dd ?

.code
start:
	push -10
	call GetStdHandle@4
	mov hStdInput, eax

	push -11
	call GetStdHandle@4
	mov hStdOutput, eax

	push 0
	push offset bytesRead
	push 255
	push offset inputBuffer
	push hStdInput
	call ReadConsoleA@20

	push 0
	push offset bytesRead
	push 255
	push offset inputBuffer
	push hStdOutput
	call WriteConsoleA@20

	push 0 
	call ExitProcess@4

end start