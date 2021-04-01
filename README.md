# Brainfuck interpreter

## Table of contents
* [What is Brainfuck?](#what-is-brainfuck?)
* [General info](#general-info)
* [Technologies](#technologies)
* [Solutions used in the project](#solutions-used-in-the-projects)
* [Examples of program effects](#examples-of-program-effects)
* [Status](#status)

## What is Brainfuck? <a name="what-is-brainfuck?"></a>
Brainfuck is an esoteric programming language. It was created in 1993 by Urban Müller. Brainfuck is characterized by extreme minimalism.
Despite its simplicity, it is complete in the sense of a Turing machine.

The entire language consists of only eight simple commands and the instruction pointer:

```txt
>     increment the data pointer (to point to the next cell to the right)

<     decrement the data pointer (to point to the next cell to the left)

+     increment the byte at the data pointer

-     decrement the byte at the data pointer

[     if the byte at the data pointer is zero, then instead of moving the instruction pointer forward 
      to the next command, jump it forward to the command after the matching ] command
      
]     if the byte at the data pointer is nonzero, then instead of moving the instruction pointer forward 
      to the next command, jump it back to the command after the matching [ command
      
,     accept one byte of input, storing its value in the byte at the data pointer

.     output the byte at the data pointer
```

## General info
The program obtains Brainfuck code as input, and then prints its output (see the examples below for more).

The "Brainfuck interpreter" was created for personal use (especially fun). In addition, it was a repetition of the Java language.

The whole idea of the project seemed interesting, it pointed to the power of the inconspicuous Brainfuck language (in the examples, among others, the calculation of successive words of the Fibonacci sequence and other mathematical operations).

## Technologies
The program was written in Java. 

## Solutions used in the project <a name="solutions-used-in-the-projects"></a>
I made an assumption, to simplify the project, the user enters the .BF code in the console (non-language characters will be omitted). 
If the `.` character is not used in the instruction string then we print all cells of our" machine ". Otherwise, "strict output" will be printed.
The program also works with "nested loops" (`[` and `]`), and each memory cell's range is contained in Integer.

## Examples of program effects

#### Ex. 1 (Hello world)
```BF
   // console 'input'
   
   ++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++.>+.+++++++..
   +++.>++.<<+++++++++++++++.>.+++.------.--------.>+.>.
   
   
   // console 'output'
   
   Hello World!
   
```
#### Ex. 2 (Fibonacci Sequence)
```BF
   // console 'input'
   
   >++++++++++>+>+[[+++++[>++++++++<-]>.<++++++[>--------<-]+<<<]>.>>[[-]<[>+<-]>>[<<+>+>-]>
   <[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>[-]>+>+<<<-[>+<-]]]]]]]]]]]+>>>]<<<]
   
   
   // console 'output'
   
   0
   1
   1
   2
   3
   5
   8
   13
   21
   34
   55
   89
   144
   ... (never terminates)
```

#### Ex.3 (Golden Ratio)
```BF
  // console 'input'
  ++++++[>++++++++<-]>+.---.>>>+>>+>++>+>+>+>>+>+++>+>>+>+>+>>+>>>>+>>>>+>++>>>>+>+<[[>>>]<<<[>>>>>>>>
  >+<<<<<<<<[>>>>>>>>>+<<<<<<<<<-]<-<<<]>>>>>>+>>>+[<<<]<<<<<[>>>+<<[>>>+<<<-]<-<<<]>>>+<<<<<<<<[<<]>>
  >>[->[<<<+>>>>[>>]>+<<<[<<]>-]<<<-[>>>+<<<-]+>>>>[>>]+>[-[-[-<->>>>>>[[>>>]>>]<<<<<[>+<-<<<]<<[<<<]>
  >>[->>>[>>>]>>[>>>]+[<<<]<<[<<<]+>>>]>>>[<[-]+>->>>]<[>>>]<<<[>+++++++++<<<<]<<[<<<]>>>[->[<<+>+>-]<
  [>+<-]>[>>[>>>]>>>>[>>>]<-<<[<<<]<<<<[<<<]>-]>>[>>>]>>>>[>>>]+[<<<]<<<<[<<<]<[>>+<<-]>+>>>]>>>>[->>>
  ]<<[>>>]<<<[>[-[-[-[-[-[-[-[-[-<->[<+>[-]>+<]]]]]]]]]]<[[>>[<<<+>>>-]<[-]<-<<<]>>>]<<<]>+>[-<-<<<[[<
  <<]<<]<<<[<<]+>>->>[>>]>>>>>>>-<[[>>>]>>]<]<[-<<<[[<<<]<<]<<<[<<]+[<<]>>->>[>>]>>>>>>[[>>>]>>]<<]<<<
  [[<<<]<<]]<[->>>>>>>+[<<+>+>-]<-[>+<-]+<[-[-[-[-[-[-[-[-[-[->>-<<<<<<<<<[<<]+>>>>>>>>->>[>>]>>>>>]]]
  ]]]]]]]<<<<<]>]<[->>>>>>>[<<<+>+>>-]<<[>>+<<-]+<[>-<[>>[>>>]>>[>>>]>>[>>>]<<<[-<<<]<<[<<<]<<[<<<]>>>
  [->[<<+>+>-]<[>+<-]<[>>>>[>>>]>>[>>>]>>[>>>]>++<<<<[<<<]<<[<<<]<<[<<<]<-]>>>>[>>>]>>[>>>]>>[>>>]+[<<
  <]<<[<<<]<<[<<<]+>>>]<<<[<<<]>-]>>[>>>]>>[>>>]>>[->[<+>>+<-]<[[<+>>+<-]<[>+<-]>->-[<->-[<->-[<->-[<-
  >-[<->-[<->-[<->-[<->-[<->[-]>---------->[-]+>+<<<]]]]]]]]]<]+>>[<+>-]>]<<<[[<<<]<<]>>>>>>[<<+>>>+<-
  ]>[<+>-]<<<[>[[>>>]>>]<+<<<<[[<<<]<<]>>>>-]>[[>>>]>>]>+<<-[>+<-]>[>+++<-[>+++++<-[>--->>+>+<<<<-[>->
  >>+<<<<-[>+>>>+<<<<-[>+++>>>+<<<<-[>----->>>++<<<<-[>--->>>++<<<<-]]]]]]]]+[[<<<]<<]>>>]>[->[[>>>]>>
  ]+>>>>>+[[<<<]<<]>>>>]<<<<<]>]<[->>>>>>[[>>>]>>]<<<<<[<<<]>>>[-<<<[<<<]<<[<<<]>>[>>>]+>[>>>]>>[>>>]>
  [<<<<[<<<]<<[<<<]>>[>>>]<<<+>[>>>]>>[>>>]>-]<+>>>]<<<[-<<<]<<[<<<]>>[->>>]<<[<<<]>>>[++++++++<[>-<-]
  >[>+<-]+>>>]<<<[<<<]>>>>+<[->[<<+>+>-]<[-[-[-[-[-[-[-[-[-[<---------->>>>[-]+>+<<<<[-]]]]]]]]]]]<[>>
  +<<-]>+>>>]<<[-<]<<[<<<]>>>->[<<+>>-]>>[>>>]<<<[>>+<[>-<<[<<<]>]>[-<<-<]<<]+<[>>+<<-]>[[<<<]<<]<]<<[
  <<]+>>]>+>[>+++++[>++>++<<-]<-]>>>>>[<<<+>+>+>-]<-[>+<-]+<<[<[<+>-]<<[>>+<<-]>[<+>-]>>-]<<<[-]>>[<+>
  >>-<<-]++++++[>++++++++<-]>>[<+>--]<.[-]>>[>>>]>>]
  
  
  // console 'output'
  
  1.61803398874989484820458... (never terminates) 
  ```

## Status
Input entered by the user in the console via java.util.Scanner. In the future, the program should read input from an external file (for example, notepad). The current form can be a bit burdensome for the user.

However, in its assumptions, the project was completed.
