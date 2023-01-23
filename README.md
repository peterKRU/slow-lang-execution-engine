# SlowLang Project: Execution Engine

![slowlang-logo]

***

SlowLang is a class-based, object-oriented programming language designed for modularity and ease of extensibility. 
Its primary purpose is to serve as a robust foundation for developing domain-specific languages with more complex syntax 
and features. 

It can also be used an a general-purpose language for developing applications, although there is no good reason for using it as such. SlowLang's name reflects its emphasis on ease of maintenance and extensibility over execution speed. 

Some key characteristics:
- Simplified C-like syntax
- Separate front-end compiler
- Custom Bytecode compilation
- Separate Virtual Machine with JVM-inspired architecture
- Garbage Collection
- Dynamic switching of interpretation behavior
- Native utils library
- Flexible architecture with pipelines for adding new features

***

The program's mode of operation is outlined here:
![intro-project-animation]
> **Note**
> This animated diagram serves only an introductory purpose. <br>For a static, readable version of the diagram, jump to chapter [1. Introduction](#introduction).

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
        * 4.2.1. [Characters](#lexical-grammar)
        * 4.2.2. [Keywords](#lexical-grammar)
        * 4.2.3. [Literals](#lexical-grammar)
        * 4.2.4. [Operators](#lexical-grammar)
        * 4.2.5. [Separators](#lexical-grammar)
        * 4.2.6. [Ignored Tokens](#lexical-grammar)
    * 4.3. [Syntactic Grammar](#syntactic-grammar)
        * 4.3.1. [Statements](#syntactic-grammar)
        * 4.3.2. [Blocks](#syntactic-grammar)
        * 4.3.3. [Expressions](#syntactic-grammar)
        * 4.3.4. [The Main Execution Block](#syntactic-grammar)
        * 4.3.5. [Classes](#syntactic-grammar)
        * 4.3.6. [Interfaces](#syntactic-grammar)
        * 4.3.7. [Declarations & Identifiers](#syntactic-grammar)
        * 4.3.8. [Types, Values & Variables](#syntactic-grammar)
        * 4.3.1. [Collections](#syntactic-grammar)
5. [Features Demonstration](#features-demonstration)
6. [Documentations & References](#documentation-&-references)
7. [Licence](#licence)
8. [Dictionary](#dictionary)
    * 8.1. [Domain-Specific Terminology](#domain-specific-terminology)
    * 8.2. [Project-Specific Terminology](#project-specific-terminology)

***

## Introduction

### The Product
SlowLang is a class-based, object-oriented language that is designed as a foundation for developing domain-specific languages, and can also be used as a general-purpose programming language for developing applications, although it is not optimized for this purpose.

### The Project 
SlowLang Project is divided into three separate components:

 * **Compiler:** compiles SlowLang source code into custom byte-code.

  GitHub repository: [slow-lang-compiler](https://github.com/peterKRU/slow-lang-compiler) **[CURRENT REPOSITORY]**

* **Execution Engine:** executes programs compiled by the SlowLang Compiler. 

 GitHub repository: [slow-lang-execution-engine](https://github.com/peterKRU/slow-lang-execution-engine)

* **Runner:**
Component which uses the Compiler and Execution Engine to compile and run SlowLang programs.
<br>The Runner can also perform updates and run functional tests.
<br>GitHub repository: [slow-lang-runner](https://github.com/peterKRU/slow-lang-runner)

This document focuses on the SlowLang Compiler component, as shown in the concept diagram below:
![architecture-diagram-compiler-context]

***

Take a look at the Compiler's internal components:
![intro-class-diagram-animation]
> **Note**
> This animated diagram serves only an introductory purpose. <br>For a static, readable version of the diagram, visit chapter [3. 2. Compiler Architecture](#compiler-architecture).

##### [Back to top](#table-of-contents)
***

### Document Structure

This document is structured to provide a comprehensive understanding of the SlowLang programming language. It is organized in three major segments:

* **Getting Started** - This segment provides an introduction to the language and guides the reader through the process of installation, configuration, and trying out the program online. It also includes a demonstration of the basic features of SlowLang.

* **Architecture & Design** - This segment delves into the technical details of the project's architecture and design, including an explanation of design decisions and the underlying principles.

* **Language Specification** - This segment provides a detailed explanation of the grammars used in SlowLang, including thorough diagrams and tables.


The reader will also find documentations and references to projects related to SlowLang, as well as thorough visual demonstration of key language features. 

The document contains special domain-specific dictionary. Each chapter includes relevant references to the dictionary for easy navigation.

Example: Some example text. 

This organization aims to provide a comprehensive and easy-to-follow guide for understanding and utilizing the SlowLang programming language.

##### [Back to top](#table-of-contents)

***

### Scope

**Project scope:**

The SlowLang project has a dual scope, which is to serve as a robust foundation for developing domain-specific languages, and also to be used as a general-purpose programming language, although it is not optimized for this purpose.

* As a foundation for developing domain-specific languages, SlowLang provides a modular and easily extendable structure, with a focus on ease of maintenance over speed. Its architecture is designed to allow for easy pipelines for adding new features to the language, making it well-suited for creating specialized languages for specific domains.

* As a general-purpose programming language, SlowLang offers a C-like syntax, a front-end compiler that converts source code to custom bytecode, and an execution engine that includes a JVM-inspired virtual machine for managing class loading, memory management, and garbage collection. While it may not be optimized for this purpose, it still provides a solid foundation for developing applications, with its architecture providing easy pipelines for adding new features to the language.

**Document scope:**

* The scope of this document is to provide a comprehensive understanding of the SlowLang programming language. It includes a detailed demonstration of its features, a guide on how to use it, and thorough information about its architecture and the design decisions taken during its development. The document is organized in a way that makes it easy to understand and follow, starting with an introduction to the language and guiding the reader through installation, configuration, and basic usage. 

* It then delves into the technical details of the project's architecture and design, including an explanation of design decisions and the underlying principles. The last chapter provides a detailed explanation of the grammars used in SlowLang, including a special domain-specific dictionary. Each chapter includes relevant references to the dictionary for easy navigation. This document aims to be a thorough and easy-to-follow guide for understanding and utilizing the SlowLang programming language.

##### [Back to top](#table-of-contents)

***

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

##### [Back to top](#table-of-contents)

***

### Example Program

* Here is an example of the classical merge sort algorithm implemented in SlowLang:

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
* Here is an example SlowLang program that demonstrates some of the main features of object-oriented programming, including classes, interfaces, and interface units:

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

**Pogramming languages:**
> * Java

 **CI tools:**
>* Maven
>* Jenkins
>* Docker

**Domain-specific tools**:
>* [Antlr4](https://www.antlr.org/) : A powerful parser generator for reading, processing, executing, or translating structured text or binary files. It's widely used to build languages, tools, and frameworks. From a grammar, ANTLR generates a parser that can build and walk parse trees.

##### [Back to top](#table-of-contents)

***

## Getting Started

![under-construction]

> **Warning**
> This section of the document is currently under construction and may contain placeholders and/or incomplete information. 

##### [Back to top](#table-of-contents)

***

### Installation

![under-construction]

> **Warning**
> This section of the document is currently under construction and may contain placeholders and/or incomplete information. 

##### [Back to top](#table-of-contents)

***

### Run Example Program

![under-construction]

> **Warning**
> This section of the document is currently under construction and may contain placeholders and/or incomplete information. 

##### [Back to top](#table-of-contents)

***

### Online Compiler

![under-construction]

> **Warning**
> This section of the document is currently under construction and may contain placeholders and/or incomplete information. 

##### [Back to top](#table-of-contents)

***

### Configurations

![under-construction]

> **Warning**
> This section of the document is currently under construction and may contain placeholders and/or incomplete information. 

##### [Back to top](#table-of-contents)

***

## Architecture & Design

This section contains detailed analysis of the project architecture and design. Each chapter contains class diagrams and high-level concept diagrams for better visual representation.

* Chapter 'System Architecture' contains overview of the entire SlowLang Project architecture.

* Chapter 'Compiler Architecture' contains more detailed explanation of the subject of this document - the Compiler component.

* Chapter 'Language Design' contains design overview and arguments for the language itself.

* Chapter 'Design Decisions' takes you on a "fascinating" journey where you will get familiar with topics, such as why I chose to use a parser generator instead of writing a recursive descent parser.

##### [Back to top](#table-of-contents)

***

### System Architecture

> **Warning**
> This section of the document is currently under construction and may contain placeholders and/or incomplete information. 

[placeholder segment]

The class diagrams for this project are designed to represent the main components and their relationships. The diagrams illustrate the classes, interfaces, and their attributes and methods. 

* Diagram 1: [Name of the Diagram]

This diagram represents [what the diagram represents]. The main classes in this diagram are [class 1], [class 2], and [class 3]. 
[class 1] has a relationship of [type of relationship] with [class 2] and [class 3]. [class 2] and [class 3] have a relationship of [type of relationship] with each other.

* Diagram 2: [Name of the Diagram]

This diagram represents [what the diagram represents]. The main classes in this diagram are [class 1], [class 2], and [class 3]. 
[class 1] has a relationship of [type of relationship] with [class 2] and [class 3]. [class 2] and [class 3] have a relationship of [type of relationship] with each other.

* Diagram 3: [Name of the Diagram]

This diagram represents [what the diagram represents]. The main classes in this diagram are [class 1], [class 2], and [class 3]. 
[class 1] has a relationship of [type of relationship] with [class 2] and [class 3]. [class 2] and [class 3] have a relationship of [type of relationship] with each other.

##### [Back to top](#table-of-contents)

***

### Compiler Architecture

> **Warning**
> This section of the document is currently under construction and may contain placeholders and/or incomplete information. 

[placeholder segment]

The class diagrams for this project are designed to represent the main components and their relationships. The diagrams illustrate the classes, interfaces, and their attributes and methods. 

* Diagram 1: [Name of the Diagram]

This diagram represents [what the diagram represents]. The main classes in this diagram are [class 1], [class 2], and [class 3]. 
[class 1] has a relationship of [type of relationship] with [class 2] and [class 3]. [class 2] and [class 3] have a relationship of [type of relationship] with each other.

* Diagram 2: [Name of the Diagram]

This diagram represents [what the diagram represents]. The main classes in this diagram are [class 1], [class 2], and [class 3]. 
[class 1] has a relationship of [type of relationship] with [class 2] and [class 3]. [class 2] and [class 3] have a relationship of [type of relationship] with each other.

* Diagram 3: [Name of the Diagram]

This diagram represents [what the diagram represents]. The main classes in this diagram are [class 1], [class 2], and [class 3]. 
[class 1] has a relationship of [type of relationship] with [class 2] and [class 3]. [class 2] and [class 3] have a relationship of [type of relationship] with each other.

##### [Back to top](#table-of-contents)

***

### Language Design

![under-construction]

> **Warning**
> This section of the document is currently under construction and may contain placeholders and/or incomplete information. 

##### [Back to top](#table-of-contents)

***

### Design Decisions

![under-construction]

> **Warning**
> This section of the document is currently under construction and may contain placeholders and/or incomplete information. 

##### [Back to top](#table-of-contents)

***

## Language Specification

![under-construction]

> **Warning**
> This section of the document is currently under construction and may contain placeholders and/or incomplete information. 

##### [Back to top](#table-of-contents)

***

### Grammar Overview

SlowLang is a programming language that has a standard, easy-to-read syntax, similar to languages like C++, Java, and C#. It has a standard set of statements, expressions, and operators, making it easy for developers to pick up and use.

* One of the key features of SlowLang is that it is an object-oriented programming (OOP) language. It supports classes, interfaces, and interface units, allowing for the encapsulation of data and behavior. However, unlike other OOP languages, SlowLang does not support inheritance. Instead, it uses method overriding and overloading and interface units to provide similar functionality.

* Interface units are a language construct which aims to replace abstract classes and inheritance overall.

* In SlowLang, variables do not require explicit types; their types are inferred implicitly. However, methods require explicit argument and return types. This allows for greater flexibility in the language while still maintaining strong type safety.

* The file structure of SlowLang is also unique, with a concrete monolith file structure. A main block is followed by classes, interfaces, and interface units, in that order. This allows for a clear and organized structure for the code, making it easy to navigate and understand.

Overall, SlowLang is a versatile programming language that combines the best features of other popular languages with its own unique features, such as the monolith file structure and interface units, to create a language that is easy to learn and use.

##### [Back to top](#table-of-contents)

***

### Lexical Grammar

SlowLang has six types of tokens: 
* **Keywords:** 
 Reserved words that have a special meaning and cannot be used as identifiers.
* **Literals:** Fixed values that are used to represent various data types
* **Identifiers:** Names for variables, methods, and classes. 
* **Operators:** Symbols that perform operations on one or more operands.
* **Separators:** Characters that separate elements in a program.
* **Ignored Tokens:** Comments and whitespaces that are ignored by the compiler.

#### Keywords:

| Keyword | Description |
| --- | --- | 
| main | main execution block declaration | 
| class | class declaration | 
| if | marks an 'if'statement |
| else | marks 'else' block|
| while | marks a 'while' loop |
| return | marks return statement |
| new | object instantiation |
| print | marks print statement |

#### Literals:
 
| Type | Example | Regex |
| --- | --- | |
| int | 11 | [0-9]+ | 
| float | 1.1 | [0-9]+ '.' [0-9]+ |    
| string | "example string" | '"' .*? '"' | 
| id | exampleVariable| [a-zA-Z][a-zA-Z0-9]* |

#### Identifiers:

| Type | Example | Rules |
| --- | --- | --- | 
| Variable Identifier | varName | Starts with lowercase letter, uses camleCase notation.
| Class Identifier | ExampleClass | Starts with uppercase letter, uses CamleCase notation.
| Interface Identifier | ExampleInterface | Starts with uppercase letter, uses CamleCase notation.
| Interface Unit Identifier | ExampleInterfaceUnit: | Starts with uppercase letter, uses CamleCase notation, ends with colon.
| Method Identifier | exampleMethod() | Starts with lowercase letter, uses camleCase notation, ends with parentheses.

#### Operators:

| Operator | Name | Type | Example |
| --- | --- | --- | --- |
| + | Addition | Arithmetic | 10 + 2
| - | Subtraction | Arithmetic | 10 - 2
| * | Multiplication | Arithmetic | 10 * 2
| / | Division | Arithmetic | 10 / 2
| % | Modulus | Arithmetic | 10 % 2
|  |  |  |
| == | Equals | Comparison | x == y
| != | Not Equal | Comparison | x != y
| > | Greater Than | Comparison | x > y
| < | Less Than | Comparison | x < y
| >= | Greater Than Equals | Comparison | x >= y
| <= | Less Than Equals | Comparison | x <= y
|  |  |  |
| ! | Not | Logical | !x
| && | And | Logical | x && y
| \|\| | Or | Logical | x \|\| y
|  |  |  |
| = | Assign | Assignment | x = 10
| += | Add And Assignn | Assignment | x += 1
| -= | Subtract And Assignn | Assignment | x -= 1
|  |  |  |
| ++_ | Prefix | Unary | ++x 
| _++ | Postfix | Unary | x++ 

#### Separators

| Token | Type | Meaning |
| --- | --- | |
| { } | Curly Brackets | Marks blocks or statements 
| () | Parentheses | Mark function parameters or expressions 
| [] | Square Brackets | Mark arrays
| ; | Semicolon | Marks end of statement


##### [Back to top](#table-of-contents)

***

### Syntactic Grammar

The following segment contains a thorough analysis of the grammar, ilustrated with concept diagrams and tables.
<br>
<br>Here is a combined concept diagram containing all syntactic elements:
<br>

***

![grammar-combined-diagram]

***

Here is a top-down breakdown of the diagram, starting with the most high-level syntactic components and moving down to lower levels of the grammar:

* **Program:**
<br>  The Program is the highest level element of a the grammar. 
<br>It is defined as either an empty file, or one Main Block followed by zero or more classes, followed by zero or more Interfaces, followed by zero or more Interface Units.

![grammar-program-diagram]

* **Main Block:**
<br>The keyword 'main' followed by a Block.

![grammar-main-block-diagram]

* **Class:**
<br>The keyword 'main', followed by a Block.

![grammar-class-diagram]

* **Interface:**
<br>The keyword 'interface', followed by an Interface Identifier, followed by the optional 'comprises' keyword, followed by zero or more Interface-Unit Identifiers, followed by a Block.

![grammar-interface-diagram]

* **Interface-Unit:**
<br>The keyword 'interface-unit', followed by an Interface-Unit Identifier, followed by a Block.

![grammar-interface-unit-diagram]

* **Block:**
<br>A Block is defined as zero or more statements separated by semicolons.

![grammar-block-diagram]

* **Statement:**
<br>A Statement can be of the following types:
| Statement Type | Definition | Example
| --- | --- | --- |
| Conditional Statement | The keyword 'if', followed by an Expression in parentheses, <br>followed by a Block. |``` if(x){...} ```
| Loop Statement | The keyword 'while', followed by an Expression in parentheses, <br>followed by a Block. | ``` while(x){...} ```
| Return Statement | The keyword 'return' followed by an Expression, ended with a <br>semicolon. | ``` return x; ```
| Variable Definition <br> Statement | An Expression, followed by an Assignment Operator, <br>followed by an Expression, ended with a semicolon. | ``` x = 15; ```
| Object Instantiation <br>Statement | An Expression, followed by an Assignment Operator, <br>followed by the keyword 'new', followed by parentheses <br>with zero or more comma-separated arguments, ended <br>with a semicolon | ``` x = new Object(y, z); ```
| Expression Statement| An Expression, ended with a semicolon. | ``` x; ```
| Print Statement| The keyword 'print', followed by zero or one expression <br>in parentheses. | ``` x; ```

<br>

![grammar-statements-diagram]

* **Expression:**
<br>An Expression can be of the following types:
| Expression Type | Definition | Example
| --- | --- | --- |
| Literal Expression | Contains a Literal Token. | ``` 15 ``` 
| Identifier Expression | Contains an Identifier Token. | ``` x ```
| Binary Expression | An expression, followed by a <br>Binary Operator, followed by an expression. | ```x = 15 ```
| Unary Expression | An Unary Operator, followed by an Expression. | ``` !x ``` 
| Prefix Increment/Decrement Expression | Incremental/Decremental Prefix Operator, <br>followed by an Expression. | ``` ++x ```
| Postfix Increment/Decrement Expression | An Expression followed by <br>Incremental/Decremental Posfix operator. | ``` x++ ```
<br>

![grammar-expressions-diagram]

##### [Back to top](#table-of-contents)

***

## Features Demonstration
![alt text](https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/master/docs/Under-Construction-300x222.png "Under Construction")

## Documentations & References
![alt text](https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/master/docs/Under-Construction-300x222.png "Under Construction")

## Licence

MIT License

Copyright (c) 2023 Peter Krastanov

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

##### [Back to top](#table-of-contents)

***

## Dictionary
![alt text](https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/master/docs/Under-Construction-300x222.png "Under Construction")

### Domain-Specific Terminology

This section contains definitions of domain-specific terms used within the document.
<br>Some definitions contains a link to a resource which contains thorough information on the topic.

[placeholder]

<dl>
  <dt>First Term</dt>
  <dd>This is the definition of the first term.</dd>
  <dt>Second Term</dt>
  <dd>This is one definition of the second term. </dd>
  <dd>This is another definition of the second term.</dd>
</dl>

##### [Back to top](#table-of-contents)

***

### Project-Specific Terminology

This section contains definitions of domain-specific terms used within the document.
<br>Some definitions contains a link to a resource which contains thorough information on the topic.

[placeholder]

<dl>
  <dt>First Term</dt>
  <dd>This is the definition of the first term.</dd>
  <dt>Second Term</dt>
  <dd>This is one definition of the second term. </dd>
  <dd>This is another definition of the second term.</dd>
</dl>

##### [Back to top](#table-of-contents)

***

<!-- MARKDOWN LINKS & IMAGES -->

[slowlang-logo]: https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/master/docs/SlowLang_2.jpg "SlowLang Logo"

[under-construction]: https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/master/docs/Under-Construction-300x222.png "Under Construction"

[architecture-diagram]: https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/b89ee32aa676a197d01b2c80acb5f868df44373e/docs/architecture_overview.jpg

[architecture-diagram-compiler-context]: https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/master/docs/architecture_overview_compiler_context.jpg

[grammar-program-diagram]: https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/8888f3b27eb5da9e89448bdefe5071e757501490/docs/program.jpg

[grammar-main-block-diagram]: https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/8888f3b27eb5da9e89448bdefe5071e757501490/docs/main_block.jpg

[grammar-block-diagram]: https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/e1d4c79f805fd29fd700c70a287d8b186500d900/docs/block.jpg

[grammar-class-diagram]: https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/e1d4c79f805fd29fd700c70a287d8b186500d900/docs/class.jpg

[grammar-interface-unit-diagram]: https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/e1d4c79f805fd29fd700c70a287d8b186500d900/docs/interface-unit.jpg

[grammar-interface-diagram]: https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/e1d4c79f805fd29fd700c70a287d8b186500d900/docs/interface.jpg

[grammar-statements-diagram]: https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/c6c1011f3f5d838d5134641ec3678243cd405c58/docs/statements.jpg

[grammar-expressions-diagram]: https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/306254b3e944f7ffca40707b25648922cf58e00e/docs/expressions.jpg

[grammar-combined-diagram]: https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/51ff0d31615d533772b013bdaa989faa35ebb026/docs/grammar.jpg

[intro-project-animation]: https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/2929209634352f4ff1d5efd0bfadeba6ea8287a1/docs/project_intro.gif

[intro-class-diagram-animation]: https://raw.githubusercontent.com/peterKRU/slow-lang-compiler/172f2ecffb2aaf401b5c43e64e0c8c3bad58d788/docs/class_diagram_animation.gif
