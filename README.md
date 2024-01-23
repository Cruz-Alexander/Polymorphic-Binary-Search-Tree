# Polymorphic Binary Search Tree

This repository contains the implementation of a Polymorphic Binary Search Tree in Java.

## Overview

The Polymorphic Binary Search Tree is a data structure that allows efficient insertion, deletion, and retrieval of key-value pairs. It supports polymorphism, allowing it to handle different types of keys and values.

## Contents

1. [Tree Package](./tree)
   - [EmptyTree](./tree/EmptyTree.java): Represents an empty search tree.
   - [NonEmptyTree](./tree/NonEmptyTree.java): Represents a non-empty search tree.
   - [PolymorphicBST](./tree/PolymorphicBST.java): Main class implementing the Polymorphic Binary Search Tree.
   - [TreeIsEmptyException](./tree/TreeIsEmptyException.java): Custom exception for signaling an empty tree.

2. [Performance Report Package](./performanceReport)
   - [TreeSpeed](./performanceReport/TreeSpeed.java): Provides examples on timing information for the Polymorphic Binary Search Tree.

3. [Tests Package](./tests)
   - [StudentTests](./tests/StudentTests.java): JUnit test cases for testing tree functionality.

## Usage

To use the Polymorphic Binary Search Tree, you can create an instance of `PolymorphicBST` and perform operations like insertion, deletion, and retrieval.

```java
// Example usage
PolymorphicBST<String, Integer> tree = new PolymorphicBST<>();
tree.put("John", 25);
tree.put("Alice", 30);
int age = tree.get("John");
System.out.println("John's age: " + age);
