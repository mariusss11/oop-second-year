#include <iostream>
#include "island.h"

using namespace std;

void program() {
    int option;

    do {
        cout << "\n===== Meniu Arhipelag =====\n";
        cout << "1. Inserează un nou rând / o nouă coloană\n";
        cout << "2. Inserează o nouă coloană\n";
        // cout << "2. Exclude un rând / o coloană\n";
        // cout << "3. Determină numărul de unităţi dintr-o linie / coloană\n";
        // cout << "4. Afişează coloanele în ordinea descendentă a numărului de unităţi\n";
        // cout << "5. Calculează numărul de insule\n";
        // cout << "6. Determină numărul de unităţi din cea mai mare insulă\n";
        // cout << "7. Găseşte pătratul maximal cu diagonala secundară de zerouri\n";
        cout << "0. Ieșire\n";
        cout << "Alege o opțiune: ";
        cin >> option;

        switch (option) {
            case 1: addNewLine(); break;
            case 2: addNewColumn(); break;
            // case 3: countUnitsInLineOrColumn(); break;
            // case 4: sortColumnsByUnitCount(); break;
            // case 5: cout << "Număr de insule: " << countIslands() << endl; break;
            // case 6: cout << "Cea mai mare insulă are " << maxIslandSize() << " unități.\n"; break;
            // case 7: maxSquareWithZeroOnSecDiagonal(); break;
            case 0: cout << "Ieșire din program.\n"; break;
            default: cout << "Opțiune invalidă. Reîncearcă.\n";
        }

    } while (option != 0);

}

