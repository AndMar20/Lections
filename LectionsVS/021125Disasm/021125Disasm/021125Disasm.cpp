#include <iostream>
using namespace std;

int main()
{
    cout << "Calculate\n";
    int x, y, z;

    cin >> x >> y;

    z = x * 2 + y * x + 5;

    cout << "z = x * 2 + y * x + 5 = " << z << endl;

    cin >> z;
}

//средства командная строка разработчика разработчика dumpbin название /all | /disasm