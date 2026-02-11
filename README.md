# Algorithms and Data Structures

En samling implementationer av fundamentala datastrukturer och algoritmer i Java. Projektet innehåller både grundläggande ADT-implementationer och praktiska tillämpningar som postfix-evaluering, labyrintlösning och backtracking-problem.

## Beskrivning

Detta är ett utbildningsprojekt som implementerar klassiska datastrukturer från grunden utan externa bibliotek (förutom Javas standardbibliotek). Varje datastruktur är implementerad i flera varianter för att visa olika tekniker, inklusive array-baserade och länkade implementationer.

## Funktioner

- Stack-implementationer (array-baserad, ArrayList-baserad och länkad lista)
- Kö-implementationer (array-baserad cirkulär kö och länkad lista)
- Länkade listor (enkellänkad och dubbellänkad)
- Binära sökträd (BST) med insert, find, remove och traversering
- Dynamisk array med automatisk storleksförändring
- Postfix- och infix-uttrycksevaluering
- Parentesmatchning med stack
- Rekursiva algoritmer (fakultet, GCD, binärsökning, linjärsökning)
- Backtracking-problem (labyrintlösning, elevatorproblem, brick puzzle)
- Sorteringsalgoritmer (QuickSort, MergeSort, ShellSort, Selection Sort, Insertion Sort)
- Iteratorer för anpassade datastrukturer

## Teknikstack

- Språk: Java
- IDE-konfiguration: IntelliJ IDEA (.iml-filer)
- Inga externa bibliotek eller ramverk

## Projektstruktur

```
Algorithms-and-data-structure/
├── ADT/                    # Array-baserad dynamisk datastruktur
│   └── src/
│       ├── Array.java      # Generisk dynamisk array
│       ├── P2.java         # ArrayList-operationer
│       └── Main.java
├── Stack/                  # Stack-implementationer
│   └── src/
│       ├── Stack.java      # Array-baserad stack
│       ├── NB5.java        # ArrayList-baserad stack
│       ├── NB7.java        # Länkad lista-baserad stack
│       ├── StackNode.java
│       ├── Calculator.java # Postfix-evaluering
│       └── NB4.java        # Parentesmatchning
├── Queue/                  # Kö-implementationer
│   └── src/
│       ├── ArrayQueue.java # Cirkulär array-baserad kö
│       ├── LinkedListQueue.java
│       ├── NB9.java        # Länkad lista-baserad kö
│       ├── PostfixEvaluator.java
│       └── InfixEvaluator.java
├── linkedlist/             # Länkade lista-implementationer
│   └── src/
│       ├── LinkedList.java # Enkellänkad lista
│       ├── DbLinkedList.java # Dubbellänkad lista
│       ├── SingleLinkedList.java # Med iterator
│       └── IntList.java    # Heltalslista
├── BinaryTree/             # Binärt sökträd
│   └── src/
│       ├── BST.java        # Komplett BST-implementation
│       ├── NB21.java       # Med inorder-traversering
│       └── NB22.java       # Med trädutskrift
├── Rekursion/              # Rekursiva algoritmer
│   └── src/
│       ├── Factorial.java  # Fakultet och GCD
│       ├── Serach.java     # Binär- och linjärsökning
│       ├── NB11.java       # Max-värde rekursivt
│       ├── NB12.java       # Potensberäkning
│       ├── NB13.java       # Kvadratrot (Newton-Raphson)
│       ├── NB15.java       # Binär till decimal
│       ├── CoinMachine.java
│       └── Test.java       # Vägar i rutnät
├── backtracking/           # Backtracking-problem
│   └── src/
│       ├── Maze.java       # Labyrintlösare
│       ├── BrickPuzzle.java # Brädspel med BFS
│       ├── BulletsGame.java # Spel med rekursiv backtracking
│       ├── Elevator.java   # Elevatorproblem
│       └── LinkedList.java # Rekursiv länkad lista
├── sorting/                # Sorteringsalgoritmer
│   └── src/
│       ├── QuickSort.java  # QuickSort-implementation
│       ├── MergeSort.java  # MergeSort-implementation
│       ├── ShellSort.java  # ShellSort-implementation
│       ├── SelectAndInsert.java # Selection & Insertion Sort
│       ├── DiviAndConq.java # Divide and Conquer-algoritmer
│       ├── Car.java        # Bil-klass för sorteringsexempel
│       ├── CarMain.java    # Huvudprogram för bil-sortering
│       ├── CompareCar.java # Comparator för bilar
│       └── Main.java       # Huvudprogram för sortering
└── laboratories/           # Laborationsuppgifter
```
