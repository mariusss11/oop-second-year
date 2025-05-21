#include <iostream>
#include <fstream>
#include <utility>
#include <iomanip>
#include <limits>

using namespace std;

const int MAX = 100; 
int a[MAX][MAX];
bool viz[MAX][MAX];
int n, m;
int nrInsule = 0;

void waitForEnter() {
    cout << "Apasati Enter pentru a continua...";
    cin.ignore(numeric_limits<int>::max(), '\n');
    while (cin.get() != '\n') {
        cout << "Va rog apasati doar enter...";
        cin.ignore(numeric_limits<int>::max(), '\n');

    }
}

void printMatrix() {
    cout << "Matricea este: " << endl;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cout << a[i][j] << " ";
        }
        cout << endl;
    }
}

void readIslands() {
    ifstream fin("insule.in");

    if (!fin) {
        cout << "Eroare la deschiderea fisierului!" << endl;
        return;
    }

    fin >> n >> m;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            fin >> a[i][j];
        }
    }
    printMatrix();
}

void printTheNewMatrix(int n, int m) {
    ofstream fout("insule.out");

    fout << n << m << endl;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            fout << a[i][j] << " ";
        }
    }

    
}

void DFS(int i, int j) {
    if (i < 0 || i >= n || j < 0 || j >= m) return;       // în afara matricei
    if (a[i][j] == 0 || viz[i][j]) return;                // e apă sau deja vizitat

    viz[i][j] = true;

    // Verificăm în 4 direcții
    DFS(i - 1, j); // sus
    DFS(i + 1, j); // jos
    DFS(i, j - 1); // stânga
    DFS(i, j + 1); // dreapta

}

void countIslands() {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (a[i][j] == 1 && !viz[i][j]) {
                DFS(i, j);
                nrInsule++;
            }
            
        }
    }

    cout << "Numarul total de insule este: ";
    cout << nrInsule << endl;  
}

bool validNumber(int x) {
    return (x == 1 || x == 0);
}

void addNewLine() {
    int lineNum;
    cout << "Enter which line you want to add: ";
    cin >> lineNum;
    lineNum--;

    int newLine[m];

    cout << "Enter the numbers of the new line: " << endl;
    for (int i = 0; i < m; i++) {
        cout << "Enter element no. " << (i + 1) << " : "; 
        int x;
        while (true) {
            cin >> x;
            if (validNumber(x)) {
                newLine[i] = x;
                break;        
            }

            cout << "Please enter a valid number: ";
        }        
    }

    cout << "The new line is: ";
    for (int i = 0; i < m; i++) {
        cout << newLine[i] << " ";
    }
    cout << endl;

    cout << "Matrix before: " << endl;
    printMatrix();

    n++;
    for (int i = n - 1; i >= lineNum; i--) {
        for (int j = 0; j < m; j++) {
            // cout << "From " << i << " " << j << " -> " << (i+1) << " " << j << endl;
            a[i+1][j] = a[i][j];
        }
    }

    for (int i = lineNum; i < m; i++){
        a[lineNum][i] = newLine[i];
    }

    cout << "The new matrix is: ";
    printMatrix();   
    
}

void addNewColumn() {
    int coloumnNum;
    cout << "Enter which coloumn you want to add: ";
    cin >> coloumnNum;
    coloumnNum--;

    int newColoumn[m];

    cout << "Enter the numbers of the new coloumn: " << endl;
    for (int i = 0; i < n; i++) {
        cout << "Enter element no. " << (i + 1) << " : "; 
        int x;
        while (true) {
            cin >> x;
            if (validNumber(x)) {
                newColoumn[i] = x;
                break;        
            }

            cout << "Please enter a valid number: ";
        }        
    }

    cout << "The new column is: " << endl;
    for (int i = 0; i < n; i++) {
        cout << newColoumn[i] << endl;

    }
    cout << endl;

    cout << "Matrix before: " << endl;
    printMatrix();

    m++;
    for (int i = 0; i < n; i++) {
        for (int j = m; j >= coloumnNum ; j--) {
            cout << "From " << i << " " << j << " -> " << i << " " << (j+i) << endl;
            a[i][j] = a[i][j - 1];
        }
    }

    for (int i = coloumnNum; i < n; i++) {
        a[i][coloumnNum] = newColoumn[i];
    }

    cout << "The new matrix is: ";
    printMatrix();   
    
}