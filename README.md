# Graph Search in Java

## Overview

This project implements a generic, edge‑weighted graph using `Vertex` objects (rather than explicit `Edge` objects), along with both breadth‑first search (BFS) and Dijkstra’s algorithm for shortest‑path computations.

## Project Structure

* `Vertex<V>.java` — a vertex holding data of type `V` and a map of adjacent vertices with weights.
* `WeightedGraph<V>.java` — directed or undirected graph based on `Vertex<V>` and weights.
* `Search<V>.java` — abstract base class encapsulating common search state and path reconstruction.
* `BreadthFirstSearch<V>.java` — BFS implementation (each edge counts as weight 1).
* `DijkstraSearch<V>.java` — Dijkstra’s algorithm for true weighted shortest paths.
* `Main.java` — example usage: builds a sample graph of cities and runs both searches.


## Prerequisites

* Java SE 17 or higher (tested on OpenJDK 24)
* A Java build tool or IDE (e.g., IntelliJ IDEA, Eclipse) or command‑line `javac`/`java`

## Building & Running

1. **Clone or download** the repository.
2. **Compile** all `.java` files:

   ```bash
   javac *.java
   ```
3. **Run** the `Main` class:

   ```bash
   java Main
   ```

After running, you should see output similar to:

```
BFS path from Almaty to Taraz: [Almaty, Shymkent, Taraz]
Shortest path from Almaty to Karaganda: [Almaty, Nur-Sultan, Karaganda]
```

## Customization

* Modify `Main.java` to add your own vertices and weighted edges.
* Use the `search(...)`, `getDistance(...)` and `pathTo(...)` methods on `BreadthFirstSearch` and `DijkstraSearch` to explore other queries.

---

*Assignment 4 – Graphs (BFS & Dijkstra) — implemented with vertices as first‑class objects*
