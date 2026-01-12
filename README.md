# Data Structures and Algorithms (Java)

This repository contains a comprehensive and systematically built collection of **Data Structures and Algorithms implemented in Java**.
It follows a fundamentals-first approach with a strong emphasis on **correctness, clarity, and conceptual depth**, and is intended as a complete reference for DSA learning and interview preparation.

All implementations are written from scratch (where appropriate) and organized by concept to make the learning progression explicit and easy to follow.

---

## Repository Structure

```
.
├── data-structures/
│   ├── arrays/
│   ├── linked-lists/
│   │   ├── SinglyLinkedList
│   │   └── DoublyLinkedList
│   ├── stacks/
│   ├── queues/
│   ├── deques/
│   ├── trees/
│   │   ├── BinaryTree
│   │   ├── BinarySearchTree
│   │   └── AVLTree
│   ├── tries/
│   ├── graphs/
│   │   ├── AdjacencyList
│   │   └── AdjacencyMatrix
│   ├── hash-table/
│   │   ├── HashSet (custom)
│   │   └── HashMap (custom)
│   └── heaps/
│       ├── MinHeap
│       ├── MaxHeap
│       └── PriorityQueue
│
└── algorithms/
    ├── searching/
    │   ├── LinearSearch
    │   └── BinarySearch
    ├── sorting/
    │   ├── BubbleSort
    │   ├── SelectionSort
    │   ├── InsertionSort
    │   ├── MergeSort
    │   ├── QuickSort
    │   └── HeapSort
    ├── dynamic-programming/
    ├── greedy/
    ├── tree-algorithms/
    │   ├── TreeDFS
    │   └── TreeBFS
    └── graph-algorithms/
        ├── GraphDFS
        ├── GraphBFS
        ├── Dijkstra
        ├── BellmanFord
        ├── FloydWarshall
        ├── PrimsMST
        └── KruskalsMST
```

---

## Coverage Overview

### Data Structures

- Arrays
- Singly and Doubly Linked Lists
- Stack (linked list implementation)
- Queue (linked list implementation)
- Deque (double-ended queue)
- Binary Tree
- Binary Search Tree
- AVL Tree (self-balancing BST)
- Trie (Prefix Tree)
- Graph representations

  - Adjacency List
  - Adjacency Matrix

- Hashing

  - Custom HashSet
  - Custom HashMap

- Heaps

  - Min Heap
  - Max Heap
  - Priority Queue

---

### Algorithms

#### Searching

- Linear Search
- Binary Search

#### Sorting

- Bubble Sort
- Selection Sort
- Insertion Sort
- Merge Sort
- Quick Sort
- Heap Sort

#### Dynamic Programming

- Fibonacci (memoization, tabulation, space optimization)
- Climbing Stairs
- House Robber
- Coin Change
- 0/1 Knapsack
- Longest Increasing Subsequence (LIS)
- Longest Common Subsequence (LCS)

#### Greedy Algorithms

- Activity Selection
- Fractional Knapsack
- Job Sequencing with Deadlines

#### Tree Algorithms

- Depth First Search (DFS)
- Breadth First Search (BFS)

#### Graph Algorithms

- Depth First Search (DFS)
- Breadth First Search (BFS)
- Dijkstra’s Algorithm
- Bellman–Ford Algorithm
- Floyd–Warshall Algorithm
- Prim’s Minimum Spanning Tree
- Kruskal’s Minimum Spanning Tree

---

## Design Philosophy

- Emphasis on **manual implementations** over library abstractions
- Clear separation between **data structures** and **algorithms**
- Each concept implemented in isolation for clarity
- Menu-driven and interactive programs where appropriate
- Code written for **learning and understanding**, not micro-optimizations

The goal of this repository is not to maximize the number of problems, but to deeply understand **patterns, principles, and internal mechanics**.

---

## Language and Tools

- Language: Java
- No external libraries used for core implementations
- Compiled using standard Java tooling (`javac`, `java`)
- Designed to run in a terminal-based environment

---

## Getting Started

Clone the repository:

```bash
git clone https://github.com/YHQZ1/Data-Structures-and-Algorithms.git
cd Data-Structures-and-Algorithms
```

Compile all Java files recursively:

```bash
javac $(find . -name "*.java")
```

Run a specific implementation:

```bash
cd data-structures/heaps
java MinHeap
```

---

## Notes

- Compiled `.class` files are excluded via `.gitignore`
- This repository represents a **complete DSA foundation**
- Additional problem-solving and optimization can be built on top of this base

---

## Contact

- GitHub: [https://github.com/YHQZ1](https://github.com/YHQZ1)
- LinkedIn: [https://www.linkedin.com/in/uttkarsh-ruparel/](https://www.linkedin.com/in/uttkarsh-ruparel/)
- Email: [rupareluttkarsh2309@gmail.com](mailto:rupareluttkarsh2309@gmail.com)
