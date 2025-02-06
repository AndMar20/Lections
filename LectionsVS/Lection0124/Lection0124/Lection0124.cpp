#include <iostream>

int main()
{
	/*int evenNumbers[10];
	_asm {
		cld
		lea edi, evenNumbers
		mov eax, 2
		mov ecx, 10
		start_loop:

			stosd 
			add eax, 2

		loop start_loop
	}

	for (size_t i = 0; i < 10; i++)
	{
		printf("%d\n", evenNumbers[i]);
	}

	char src[] = "Hello ASM";

	char find = 'o';
	int pos = -1;

	int x = sizeof(src);*/

	//_asm {
	//	cld
	//	lea edi src
	//	mov esi, edi;// Для сравнения адресов в конце
	//	mov al, find;// Значение искомого символа в аккумулятор
	//	mov ecx, x;//	Счетчик на длину нашей строки
	//	;//repne - Повторяется до тех пор пока значение не совпадет пока ecx != 0 и в zf = 0
	//	repne scasb;//  Поиск пока ZF = 0, остановка на ZF = 1 либо ecx = 0
	//	jnz not_found;//Если не нашли символа ZF = 0 то jnz -  переход на строчку not_found

	//	sub edi, esi;// Если нашли, то вычитаемадреса- в результате индекс следующего элемента после искомого
	//	dec edi;//		Уменьшаем индекс на 1 
	//	mov pos, edi;// Записываем в переменнную

	//	not_found:
	//}

	//printf("%d\n",pos);

	// y = x*x - 3*x +6
	//int x = 5;

	//int y;

	//_asm {
	//	MOV EAX, x
	//	IMUL EAX 
	//	MOV ECX, x
	//	IMUL ECX, 3
	//	SUB EAX, ECX
	//	ADD EAX, 6
	//	MOV y, EAX
	//}

	//std::cout << y;


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