# SlowLang Project

![alt text](https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/master/docs/SlowLang_2.jpg "SlowLang Logo")

***
SlowLang is a class-based, object-oriented programming language designed for modularity and ease of extensibility. 
Its primary purpose is to serve as a robust foundation for developing domain-specific languages with more complex syntax 
and features. 

It can also be used an a general-purpose language for developing applications, although there is no good reason for using it as such. SlowLang's name reflects its emphasis on ease of maintenance and extensibility over execution speed. 

Some key haracteristics:
- Simplified C-like syntax
- Separate front-end compiler
- Custom Bytecode compilation
- Separate Virtual Machine with JVM-inspired architecture
- Garbage Collection
- Dynamic switching of interpretation behavior
- Native utils library
- Flexible architecture with pipelines for adding new features

***

## Table of Contents
1. [Introduction](#introduction)
    * 1.1. [Document Stucture](#document-structure)
    * 1.2. [Scope](#scope)
    * 1.3. [Key Features](#key-features)
    * 1.4. [Example Program](#example-program)
    * 1.5. [Tools & Software](#tools-software)
    * 1.6. [Project Context](#project-context)
2. [Getting Started](##getting-started)
    * 2.1 [Installation](#installation)
    * 2.2 [Run Example Program](#run-example-program)
    * 2.3 [Online Compiler](#online-compiler)
    * 2.4 [Configurations](#configurations)
3. [Architecture & Design](#architecture-&-design)
    * 3.1. [System Architecture](#system-architecture)
    * 3.2. [Compiler Architecture](#compiler-architecture)
    * 3.3. [Execution Engine Architecture](#execution-engine-architecture)
    * 3.4. [Language Design](#language-design)
    * 3.5. [Design Decisions](#design-decisions)
4. [Language Specification](#language-specification)
    * 4.1. [Grammar Overview](#grammar-overview)
    * 4.2. [Lexical Grammar](#lexical-grammar)
        * 4.2.1. [Characters](#characters)
        * 4.2.2. [Keywords](#keywords)
        * 4.2.3. [Literals](#literals)
        * 4.2.4. [Operators](#operators)
        * 4.2.5. [Separators](#separators)
        * 4.2.6. [Ignored Tokens](#ignored-tokens)
    * 4.3. [Syntactic Grammar](#syntactic-grammar)
        * 4.3.1. [Statements](#statements)
        * 4.3.2. [Blocks](#blocks)
        * 4.3.3. [Expressions](#expressions)
        * 4.3.4. [The Main Execution Block](#the-main-execution-block)
        * 4.3.5. [Classes](#classes)
        * 4.3.6. [Interfaces](#interfaces)
        * 4.3.7. [Declarations & Identifiers](#declarations-&-identifiers)
        * 4.3.8. [Types, Values & Variables](#types-values-&-variables)
        * 4.3.1. [Collections](#collections)
5. [Features Demonstration](#features-demonstration)
6. [Documentations & References](#documentation-&-references)
7. [Licence](#licence)
8. [Dictionary](#dictionary)
    * 8.1. [Domain-Specific Terminology](#domain-specific-terminology)
    * 8.2. [Project-Specific Terminology](#project-specific-terminology)

***

## Introduction

![alt text](https://raw.githubusercontent.com/peterKRU/slow-lang-execution-engine/master/docs/SlowLangEE-ClassDiagram.jpg "Compiler Class Diagram")

### Document Structure

This document is structured to provide a comprehensive understanding of the SlowLang programming language. It is organized in three major segments:

>* **Getting Started** - This segment provides an introduction to the language and guides the reader through the process of installation, configuration, and trying out the program online. It also includes a demonstration of the basic features of SlowLang.

> * **Architecture & Design** - This segment delves into the technical details of the project's architecture and design, including an explanation of design decisions and the underlying principles.

> * **Language Specification** - This segment provides a detailed explanation of the grammars used in SlowLang, including thorough diagrams and tables.


The reader will also find documentations and references to projects related to SlowLang, as well as thorough visual demonstration of key language features. 

The document contains special domain-specific dictionary. Each chapter includes relevant references to the dictionary for easy navigation.

Example: Some example text. 

This organization aims to provide a comprehensive and easy-to-follow guide for understanding and utilizing the SlowLang programming language.

### Scope

**Project scope:**

> The SlowLang project has a dual scope, which is to serve as a robust foundation for developing domain-specific languages, and also to be used as a general-purpose programming language, although it is not optimized for this purpose.
>
> * As a foundation for developing domain-specific languages, SlowLang provides a modular and easily extendable structure, with a focus on ease of maintenance over speed. Its architecture is designed to allow for easy pipelines for adding new features to the language, making it well-suited for creating specialized languages for specific domains.
>
> * As a general-purpose programming language, SlowLang offers a C-like syntax, a front-end compiler that converts source code to custom bytecode, and an execution engine that includes a JVM-inspired virtual machine for managing class loading, memory management, and garbage collection. While it may not be optimized for this purpose, it still provides a solid foundation for developing applications, with its architecture providing easy pipelines for adding new features to the language.

**Document scope:**

> The scope of this document is to provide a comprehensive understanding of the SlowLang programming language. It includes a detailed demonstration of its features, a guide on how to use it, and thorough information about its architecture and the design decisions taken during its development. The document is organized in a way that makes it easy to understand and follow, starting with an introduction to the language and guiding the reader through installation, configuration, and basic usage. It then delves into the technical details of the project's architecture and design, including an explanation of design decisions and the underlying principles. The last chapter provides a detailed explanation of the grammars used in SlowLang, including a special domain-specific dictionary. Each chapter includes relevant references to the dictionary for easy navigation. This document aims to be a thorough and easy-to-follow guide for understanding and utilizing the SlowLang programming language.

### Key Features

Here is a comprehensive list of SlowLang's key features with example code (**click the arrows for example code**):

<details><summary>Standard features: SlowLang includes all the standard features of a programming language, such as arithmetic operations, logical operations, and more.</summary>
<p>

#### Here is a SlowLang block of code which is the programming equivalent of "the quick brown fox jumps over the lazy dog":

```
main {
    x = 5, y = 10;
    a = true, b = false;
    result = (x + y) * (x - y) / (x * y) % (x / y) + (++x) - (--y) + (x >> 2) + (x << 2) + (x >>> 2) & (x | y) ^ (x & y) || (a && b);
}
```

</p>
</details>

<details><summary>Implicit types: SlowLang has implicit types, meaning that the type of a variable is inferred from its value.</summary>
<p>

#### Implicit and explicit declaration of an integer, string and a user-defined class:

```
main {
    x = 1;
    y = "ololo";
    z = new ExampleClass(x, y);
}
```

</p>
</details>

<details><summary>Object-oriented: SlowLang is an object-oriented language and has classes and interfaces.</summary>
<p>

#### Example of interface and class definition:

```
interface ExampleInterface {
    
    public void exampleMethod();
}

class ExampleClass implements ExampleInterface {
    
    @Implement
    public void exampleMethod(){
        ```
    }
}   
```

</p>
</details>

<details><summary>Straightforward organizational structure: SlowLang has a straightforward organizational structure that includes a main execution block followed by class definitions. Classes can be written in separate documents, but the compiler assembles them into a single monolithic document.</summary>
<p>

#### Every program follows the following structure (main block -> classes -> intefaces):

```
main {
    ```
}

class {
    ```
}

interface {
    ```
}

```

</p>
</details>

<details><summary>No Inheritance, supports Interface Units instead: The less time you spend pondering over the ontological difference between abstract classes and interfaces the more time you spend actually writing interfaces. Hue hue.</summary>
<p>

#### If you really, really want to replicate iheritance you can use Interface Unit. An Interface Unit is a collection of interfaces which can be implemented as a single interface:

```
main {
    ```
}

class ExampleClass implements ExampleUnit {
    ```
}

interface ExampleInterface comprises ExampleUnit{
    ```
}

interface AnotherInterface comprises ExampleUnit{
    ```
}

```

</p>
</details>

<details><summary>Native Utils Library: SlowLang has a native utils library which includes implementation of all relevant data structures, such as Array, HashMap, BST, Set, etc.</summary>
<p>

#### You have all relevant data structures at your disposal:

```
main {
    dynamicArray = new DynamicArray(1, 2, 3);
    linkedList = new LinkedList(4, 5, 6);
    
    stack = new Stack(dynamicArray + linkedList);
    hashMap = new HashMap();
    
    exampleString = "ololo";
    hashMap.put(exampleString, stack.pop());
    
    binaryTree = new BinaryTree(exampleString, hashMap.get(exampleString));
}

```

</p>
</details>

<details><summary>Garbage Collection: SlowLang has a garbage collector that automatically frees up memory that is no longer being used. The GC also supports explicit memory dealocation.</summary>
<p>

#### Garbage Collection is automatic, however the user can choose to explicitly mark objects for deletion. The Garbage Collecor will sweep them during the next scheduled garbage collection:

```
main {
    exampleObject = new ExampleClass();
    print(exampleObject);
    GC.collect(exampleObject);
}
```

</p>
</details>

<details><summary>Virtual Machine interpreter: SlowLang's virtual machine interpreter can alter its behavior during runtime.</summary>
<p>

#### Here is a diagram showing high-level overview of SlowLang's Virtual Machine:

[TODO: insert diagram]

</p>
</details>

<details><summary>Chain of Opcode Executors: SlowLang's virtual machine uses a chain of opcode executors which can be easily extended, assembled and rearranged.</summary>
<p>

#### Here is a UML class diagram showing SlowLang's chain of opcode executors:

[TODO: insert diagram]

</p>
</details>

These features make SlowLang a flexible and versatile programming language that is well-suited for building upon.

***

### Example Program
***
Here is an example of the classical merge sort algorithm implemented in SlowLang:

```
main {
    array = {38, 27, 43, 3, 9, 82, 10};
    mergeSort(array);
    print(array);
}

class MergeSort implements SortingAlgorithm{
    
    @Implement
    public static sort(array: int[]) -> void {
        
        mergeSort(array);
    }
    
    public static mergeSort(array: int[]) -> void {
        
        if (array.length < 2) {
            return;
        }
        mid = arr.length / 2;
        left = Utils.copyRange(array, 0, mid);
        right = Utils.copyRange(arr, mid, array.length);
        mergeSort(left);
        mergeSort(right);
        merge(array, left, right);
    }

    public static merge(arr: int[], left: int[], right: int[]) -> void{
        
        i = 0, j = 0, k = 0;
        
        while (i < left.length && j < right.length) {
            
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }
}

interface SortingAlgorithm {
    
    public sort(array: int) -> void;
}

```
***
Here is an example SlowLang program that demonstrates some of the main features of object-oriented programming, including classes, interfaces, and interface units:

```

class Rectangle implements PolygonShape {
    
    private length;
    private  width;
    private  numberOfSides;
    
    public Rectangle(length: double, width: double) {
        
        this.numberOfSides = PolygonShape.Polygon.getNumberOfSides();
        this.length = length;
        this.width = width;
    }
    
    @Implement
    public getNumberOfSides(){
        
        return 4;
    }
    
    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    @Implement
    public getArea() {
        return length * width;
    }

    @Implement
    public getPerimeter() {
        return 2 * (length + width);
    }
}

class Circle implements Shape {
    
    private radius;

    public Circle(radius: double){
        this.radius = radius;
    }

    public getRadius() -> double{
        return radius;
    }

    @Implement
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Implement
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}

interface Shape comprises PolygonShape{
    
    getArea() -> double;
    getPerimeter() -> double;
}

interface Polygon comprises PolygonShape {
    
    public getNumberOfSides() -> int {
        
        return 4;
    }
}

unit PolygonShape {
    
    ```        
}
```

##### [Back to top](#table-of-contents)

***

### Tools & Software
![alt text](https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/master/docs/Under-Construction-300x222.png "Under Construction")

### Project Context
![alt text](https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/master/docs/Under-Construction-300x222.png "Under Construction")

## Getting Started
![alt text](https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/master/docs/Under-Construction-300x222.png "Under Construction")

### Installation
![alt text](https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/master/docs/Under-Construction-300x222.png "Under Construction")

### Run Example Program
![alt text](https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/master/docs/Under-Construction-300x222.png "Under Construction")

### Online Compiler
![alt text](https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/master/docs/Under-Construction-300x222.png "Under Construction")

### Configurations
![alt text](https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/master/docs/Under-Construction-300x222.png "Under Construction")

## Architecture & Design
![alt text](https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/master/docs/Under-Construction-300x222.png "Under Construction")

### System Architecture
![alt text](https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/master/docs/Under-Construction-300x222.png "Under Construction")

### Compiler Architecture
![alt text](https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/master/docs/Under-Construction-300x222.png "Under Construction")

### Execution Engine Architecture
![alt text](https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/master/docs/Under-Construction-300x222.png "Under Construction")

### Language Design
![alt text](https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/master/docs/Under-Construction-300x222.png "Under Construction")

### Design Decisions
![alt text](https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/master/docs/Under-Construction-300x222.png "Under Construction")

## Language Specification
![alt text](https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/master/docs/Under-Construction-300x222.png "Under Construction")

### Grammar Overview
![alt text](https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/master/docs/Under-Construction-300x222.png "Under Construction")

### Lexical Grammar
![alt text](https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/master/docs/Under-Construction-300x222.png "Under Construction")

### Characters
![alt text](https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/master/docs/Under-Construction-300x222.png "Under Construction")

### Keywords
![alt text](https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/master/docs/Under-Construction-300x222.png "Under Construction")

### Literals
![alt text](https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/master/docs/Under-Construction-300x222.png "Under Construction")

### Operators
![alt text](https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/master/docs/Under-Construction-300x222.png "Under Construction")

### Separators
![alt text](https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/master/docs/Under-Construction-300x222.png "Under Construction")

### Ignored Tokens
![alt text](https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/master/docs/Under-Construction-300x222.png "Under Construction")

### Syntactic Grammar
![alt text](https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/master/docs/Under-Construction-300x222.png "Under Construction")

### Statements
![alt text](https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/master/docs/Under-Construction-300x222.png "Under Construction")

### Blocks
![alt text](https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/master/docs/Under-Construction-300x222.png "Under Construction")

### Expressions
![alt text](https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/master/docs/Under-Construction-300x222.png "Under Construction")

### The Main Execution Block
![alt text](https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/master/docs/Under-Construction-300x222.png "Under Construction")

### Classes
![alt text](https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/master/docs/Under-Construction-300x222.png "Under Construction")

### Interfaces
![alt text](https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/master/docs/Under-Construction-300x222.png "Under Construction")

### Declarations & Identifiers
![alt text](https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/master/docs/Under-Construction-300x222.png "Under Construction")

### Types, Values & Variables
![alt text](https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/master/docs/Under-Construction-300x222.png "Under Construction")

### Collections
![alt text](https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/master/docs/Under-Construction-300x222.png "Under Construction")

## Features Demonstration
![alt text](https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/master/docs/Under-Construction-300x222.png "Under Construction")

## Documentations & References
![alt text](https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/master/docs/Under-Construction-300x222.png "Under Construction")

## Licence
![alt text](https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/master/docs/Under-Construction-300x222.png "Under Construction")

## Dictionary
![alt text](https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/master/docs/Under-Construction-300x222.png "Under Construction")

### Domain-Specific Terminology
![alt text](https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/master/docs/Under-Construction-300x222.png "Under Construction")

### Project-Specific Terminology
![alt text](https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/master/docs/Under-Construction-300x222.png "Under Construction")

