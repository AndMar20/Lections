#include <iostream>

int main()
{
	// y = x*x - 3*x +6
	int x = 5;

	int y;

	_asm {
		MOV EAX, x
		IMUL EAX 
		MOV ECX, x
		IMUL ECX, 3
		SUB EAX, ECX
		ADD EAX, 6
		MOV y, EAX
	}

	std::cout << y;


	//int x = 5;

	//int y; //= x * x + 5;

	//_asm {
	//	MOV EAX, x
	//	IMUL EAX
	//	ADD EAX, 5
	//	MOV y, EAX
	//}
	//std::cout << y;
	//int x = 5;
	//_asm {
	//	;//цикл
	//	; start:
	//	; cmp eax, ebx
	//		; je end

	//		; dec eax
	//		; jmp start

	//		; end:
	//	; mov x, eax
	//	
	//	mov ecx, 5
	//		cycle:
	//	add eax, 1
	//	loop cycle

	//	mov x, eax


	//	and ax, 0f0fh
	//	or ax, 0f0fh
	//	xor ax, ax - обнуление
	//	not ax
	//}
	//std::cout << x;
}