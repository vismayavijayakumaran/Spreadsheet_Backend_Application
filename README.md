# Spreadsheet\_Backend\_Application

A simple Java Spring Boot application that implements a mini spreadsheet engine.   Supports basic cell operations like setCellValue and getCellValue, including formulas with cell references (e.g., =A1+A2).   Demonstrates recursive formula evaluation, error handling, and unit testing.



Spreadsheet Backend in Java



This is a simple spreadsheet backend implementation in Java that supports:



Setting cell values (numbers or formulas)



Getting evaluated cell values (resolving formulas recursively)





Features



setCellValue(String cellId, Object value) → set a cell value (e.g., 10 or "=A1+A2")



getCellValue(String cellId) → get the evaluated integer value of the cell



Supports formulas like =A1+A2+A3



Recursive evaluation of formulas (a cell can depend on other cells)



Throws exceptions for invalid references or invalid formulas



Steps



Save the code as Spreadsheet.java



Compile the program:



**javac Spreadsheet.java**





Run it:



**java Spreadsheet**

