#include <iostream>

int main()
{
    char str[] = "Hello World";
    char format[] = "%s";
    //printf(format, str);
    /*_asm {
        lea esi, str
        push esi
        push esi
        lea eax, format
        push eax
        call printf
        add esp, 8
        pop esi
    }*/

    int n = 0;
    char numformat[] = "%d";
    _asm {
        lea ebx, n
        push ebx
        lea eax, numformat
        push eax
        call scanf
        add esp, 8
    }
    printf("%d", n + 1);
}