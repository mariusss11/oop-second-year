#include <iostream>
#include <fstream>
#include <utility>
#include <iomanip>
#include <limits>
#include <cstdlib>  // for system()

using namespace std;

const int MAX = 100; 
int a[MAX][MAX];
bool viz[MAX][MAX];
int n, m;
int nrInsule = 0;

void clear() {  
#ifdef _WIN32
    system("cls");    
#else
    system("clear"); 
#endif
}

void waitForEnter() {
    cout << "Apasati Enter pentru a continua...";
    cin.ignore(numeric_limits<int>::max(), '\n');
    while (cin.get() != '\n') {
        cout << "Va rog apasati doar enter...";
        cin.ignore(numeric_limits<int>::max(), '\n');
    }
    system("clear");
}

void printMatrix() {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cout << a[i][j] << " ";
        }
        cout << endl;
    }
}

void printMatrixInFile() {
    ofstream fout("insule.in");
    cout << "THE NEW MATRIX IS BEING WRITEN IN THE FILE: " << endl;

    fout << n << " " << m << endl;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            fout << a[i][j] << " ";
        }
        fout << endl;
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

void printTheMatrixInFile(int n, int m) {
    ofstream fout("insule.out");

    fout << n << m << endl;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            fout << a[i][j] << " ";
        }
    }

    
}

int DFS(int i, int j) {
    if (i < 0 || i >= n || j < 0 || j >= m) return 0;       // în afara matricei
    if (a[i][j] == 0 || viz[i][j]) return 0;                // apă sau deja vizitat

    viz[i][j] = true;

    int size = 1; // această celulă

    // Verificăm în 4 direcții
    size += DFS(i - 1, j); // sus
    size += DFS(i + 1, j); // jos
    size += DFS(i, j - 1); // stânga
    size += DFS(i, j + 1); // dreapta

    return size;
}

void countIslands() {
    clear();
    int nrInsule = 0;
    int maxSize = 0;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (a[i][j] == 1 && !viz[i][j]) {
                int currentSize = DFS(i, j);
                nrInsule++;

                if (currentSize > maxSize)
                    maxSize = currentSize;
            }
        }
    }

    cout << " ======= ISLANDS =======\n";
    cout << "Total number of islands: " << nrInsule << endl;
    cout << "The size of the biggest island: " << maxSize << endl;
    waitForEnter();
}


bool validMatrixNumber(int x) {
    return (x == 1 || x == 0);
}

bool validNumber(const string &str)
{
    for (char ch : str)
    {
        if (!isdigit(ch))
        {
            return false;
        }
    }
    return true;
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
            if (validMatrixNumber(x)) {
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

    // Shift rows down
    for (int i = n; i > lineNum; i--) {
        for (int j = 0; j < m; j++) {
            a[i][j] = a[i - 1][j];
        }
    }

    // Insert new line
    for (int i = 0; i < m; i++) {
        a[lineNum][i] = newLine[i];
    }

    n++; // Increase row count

    cout << "The new matrix is: " << endl;
    printMatrix();  

    printMatrixInFile();
}

void addNewColumn() {
    clear();
    int coloumnNum;
    cout << "Enter which column you want to add: ";
    cin >> coloumnNum;
    coloumnNum--;

    int newColoumn[n];

    cout << "Enter the numbers of the new column: " << endl;
    for (int i = 0; i < n; i++) {
        cout << "Enter element no. " << (i + 1) << " : "; 
        int x;
        while (true) {
            cin >> x;
            if (validMatrixNumber(x)) {
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

    // Shift columns to the right
    for (int i = 0; i < n; i++) {
        for (int j = m; j > coloumnNum; j--) {
            a[i][j] = a[i][j - 1];
        }
    }

    // Insert new column
    for (int i = 0; i < n; i++) {
        a[i][coloumnNum] = newColoumn[i];
    }

    m++; // Increase column count after insertion

    cout << "The new matrix is: " << endl;
    printMatrix();   

    printMatrixInFile();
    waitForEnter();
}


void excludeLine() {
    clear();
    printMatrix();
    int lineNum;
    cout << "Enter which line you want to exclude: ";
    cin >> lineNum;
    lineNum--;

    if (lineNum < 0 || lineNum >= n) {
        cout << "Invalid line number." << endl;
        return;
    }

    // Shift all rows after lineNum up by one
    for (int i = lineNum; i < n - 1; i++) {
        for (int j = 0; j < m; j++) {
            a[i][j] = a[i + 1][j];
        }
    }

    n--; // Decrement the row count

    cout << "Matrix after excluding line " << (lineNum + 1) << ":" << endl;
    printMatrix();
}


void excludeColumn() {
    clear();
    printMatrix();
    int colNum;
    cout << "Enter which column you want to exclude: ";
    cin >> colNum;
    colNum--;

    if (colNum < 0 || colNum >= m) {
        cout << "Invalid column number." << endl;
        return;
    }

    // Shift all columns after colNum left by one
    for (int i = 0; i < n; i++) {
        for (int j = colNum; j < m - 1; j++) {
            a[i][j] = a[i][j + 1];
        }
    }

    m--; // Decrement the column count

    cout << "Matrix after excluding column " << (colNum + 1) << ":" << endl;
    printMatrix();
}

void getEasiestPath(int endX, int endY, int ways[100][100]) {
    ofstream fout("insule.out");

    if (endX < 0 || endY < 0 || a[endX][endY] == 0) {
        cout << "No path to the end position.\n";
        return;
    }

    int i = endX, j = endY;
    int length = 0;

    int path[100][2] = {0};

    cout << "Easiest path to (" << endX + 1 << ", " << endY + 1 << "): ";
    
    while (i != 0 || j != 0) {
        path[length][0] = i;
        path[length][1] = j;
        length++;

        if (i > 0 && ways[i - 1][j] > 0) {
            i--; // move up
        } else if (j > 0 && ways[i][j - 1] > 0) {
            j--; // move left
        } else {
            cout << "No valid path found.\n";
            return;
        }
    }

    cout << "The number path is being written in the insule.out file: " << endl;
        
    // Print in reverse (from start to end)
    fout << "Number of total solutions: " << ways[endX][endY] << endl;
    fout << "Easiest path: " << endl;
    for (int k = length - 1; k >= 0; k--) {
        fout << path[k][0] + 1 << " " << path[k][1] + 1 << endl;
    }
    fout << "Number of steps: " << length << endl;    
}


void countPossibleWays() {
    clear();
    // printMatrix();
    cout << " ======== SOLVING THE WATER PROBLEM ========.\n";
    int ways[100][100] = {0}; 
    int endX, endY;

    // Input end point
    while (true) {
        cout << "Enter the end position (x y): ";
        int x, y;
        cin >> x >> y;
        if (x <= 0 || x > n || y <= 0 || y > m) {
            cout << "Position out of bounds, try again.\n";
            continue;
        }
        if (a[x - 1][y - 1] == 0) {
            cout << "End position is water, try again.\n";
            continue;
        }
        endX = x - 1;
        endY = y - 1;
        break;
    }

    printMatrix();
    cout << "End position: (" << endX + 1 << ", " << endY + 1 << ")" << endl;

    // Base case
    ways[0][0] = 1;

    // Dynamic Programming
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {

            if (a[i][j] == 0) {
                ways[i][j] = 0; // water — cannot go here
                continue;
            }
            
            if (i > 0 && j > 0){
                ways[i][j] = ways[i - 1][j] + ways[i][j - 1];
            } else if (i > 0) {
                ways[i][j] = ways[i - 1][j]; // can only come from above
            } else if (j > 0) {
                ways[i][j] = ways[i][j - 1]; // can only come from the left
            }
            
        }
    }

    int numberOfWays = ways[endX][endY];

    if (numberOfWays == 0) 
        cout << "No way to reach the end position because of the water.\n";
    else 
        cout << "Number of ways to reach the end position (" << endX + 1 << ", " << endY + 1 << ") is: " << numberOfWays << endl;
    

    if (numberOfWays != 0)
        getEasiestPath(endX, endY, ways);

    waitForEnter();
}





