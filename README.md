# Algorithms and Data Structures

Classic data structures and algorithms implemented from scratch in Java, using
nothing beyond the standard library.

Coursework, organised as a set of independent IntelliJ modules rather than one
project. Each top-level directory has its own `src/` and its own `Main`.

## What is here

**`ADT/`** — a generic dynamic array that doubles its backing store when full,
plus a phone directory built on it.

**`Stack/`** — three stack implementations (fixed array, `ArrayList`-backed,
and linked-node), an interactive postfix calculator, and bracket matching.

**`Queue/`** — a circular array queue, a linked-list queue, and two expression
evaluators: postfix, and an infix evaluator implemented as a real two-stack
shunting-yard with operator precedence and parentheses.

**`linkedlist/`** — singly and doubly linked lists, both with their own
`Iterator` implementations.

**`BinaryTree/`** — a binary search tree with insert, find (recursive and
iterative), **remove with all three cases handled** including the two-child
successor relink, in-order/pre-order/post-order traversal, level-order printing
via a node queue, and height/leaf counts. Also a map and an N-Queens solver.

**`Rekursion/`** — factorial, GCD, binary and linear search, recursive power,
Newton-Raphson square root, binary-to-decimal, and a lattice path counter.

**`backtracking/`** — four solvers:

| File | Problem |
| --- | --- |
| `Maze.java` | Reads an ASCII labyrinth and finds a path from start to goal by recursive depth-first backtracking, marking cells on the way in and re-marking them on a successful unwind. Genuine backtracking. |
| `Elevator.java` | An elevator that can only jump a fixed number of floors up or down; finds the fewest trips to a target floor. |
| `BulletsGame.java` | A token-exchange puzzle over counts of blue, white and red marbles under three fixed swap rules; finds the fewest swaps to equalise them. |
| `BrickPuzzle.java` | The frog-jump puzzle — turn `BBB_WWW` into `WWW_BBB` where each piece moves one or two cells into the gap. Solved by breadth-first search, not backtracking. |

**`sorting/`** — QuickSort (Lomuto partition), MergeSort (top-down),
ShellSort (Ciura-style gap sequence), selection and insertion sort, and a
`Comparator`-based example that sorts cars from a file.

**`laboratories/`** — nine graded assignments in their own projects: an
iterator with `remove()`, an airport simulation, two robot-path problems, a
sliding puzzle, a binary search tree, and radix sort. Assignment 1 also
includes a MATLAB script (`Uppgift1.m`) that fits polynomials to measured
runtimes to estimate complexity empirically, with the written reports alongside.

## Requirements

A JDK. Nothing here uses a language feature newer than generics, so any modern
JDK works. There is no Maven or Gradle build — the repository predates one and
does not need one.

## Building and running

Every class is in the **default package**, and names repeat across modules —
there are 16 different `Main.java`, three `SingleLinkedList.java`, and a
user-defined `Queue` interface that shadows `java.util.Queue`. A single `javac`
over the whole repository therefore cannot work. **Compile one module at a
time.**

```bash
cd sorting/src
javac -d ../out *.java
java -cp ../out Main
```

The same pattern works for every module. Substitute `BinaryTree`, `backtracking`,
`Stack`, `Queue`, `ADT`, `linkedlist` or `Rekursion`; the entry point is `Main`
in each. Assignment directories contain spaces, so quote them:

```bash
cd "laboratories/Uppgift 9/radixSort/src"
javac -d ../out *.java && java -cp ../out Main
```

Two things to know before you run anything:

- `Stack`'s `Main` is an interactive postfix calculator that reads from stdin.
  Type `q` to exit.
- `sorting`'s `CarMain` reads `Cars.txt` by relative path and writes its output
  next to it, so it only works with the working directory set to `sorting/`,
  not `sorting/src/`.

Several demo `main` methods are commented out — `sorting/src/Main.java` only
runs selection and insertion sort, and `Maze`, `BulletsGame` and `BullesGame2`
have no active entry point. Uncomment to run them.

There are no tests. `Queue/src/TestQueue.java` is a queue implementation despite
the name, `Rekursion/src/Test.java` is a path-counting exercise, and
`Queue/src/FullTest.java` has its entire body commented out.

## Known gaps

- **`Maze.java` cannot run anywhere but the machine it was written on.** Its
  constructor reads `Labyrint.txt` through a hardcoded absolute Windows path
  (`D:\My Documents\KTH\...`), and on failure it calls `System.exit(1)`. The
  maze file it wants is committed next to the source; only the path is wrong.
- **`Elevator.java` returns wrong answers.** It counts depth twice — once in
  the accumulator on the way down and once in the return value on the way back
  up — so every result is double the true number of trips. Worse, the
  depth-limit sentinel `Integer.MAX_VALUE` gets `1 +` applied by its caller,
  wrapping to `Integer.MIN_VALUE`, which then wins every `Math.min` and turns
  "unreachable" into a large negative number.
- **`MergeSort` never terminates on an empty array.** Its base case is
  `if (n == 1) return;`, so a zero-length input recurses forever into two more
  zero-length halves. The fix is `n <= 1`.

## License

[MIT](LICENSE)
