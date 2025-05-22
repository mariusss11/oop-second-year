#include <iostream>
#include "island.h"

using namespace std;

void program() {
    readIslands();

    int option;

    do {
        cout << "\n===== Meniu Arhipelag =====\n";
        cout << "1. Insereaza o noua linie\n";
        cout << "2. Insereaza o noua coloana\n";
        cout << "3. Exclude o line\n";
        cout << "4. Exclude o coloana\n";
        cout << "5. Numarul de insule si marimea celei mai mari insule\n";
        cout << "6. Găseşte numarul de solutii posibile de la o insula la alta\n";
        // cout << "2. Exclude un rând / o coloană\n";
        // cout << "3. Determină numărul de unităţi dintr-o linie / coloană\n";
        // cout << "4. Afişează coloanele în ordinea descendentă a numărului de unităţi\n";
        cout << "0. Ieșire\n";
        cout << "Alege o opțiune: ";
        cin >> option;

        switch (option) {
            case 1: addNewLine(); break;
            case 2: addNewColumn(); break;
            case 3: excludeLine(); break;
            case 4: excludeColumn(); break;
            case 5: countIslands(); break;
            case 6: countPossibleWays(); break;
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

