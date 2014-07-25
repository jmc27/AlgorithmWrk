Jonathan Chu

This is a coding sample problem where given a collection of 2D geometric shapes, sort them in ascending order of area, and also in ascending order of circumference.

To accomplish this I use an abstract class called Shape which specifies that all subclasses of Shape will have methods to calculate area, and circumference. Also, the abstract class Shape defines methods for comparing shapes by area and circumference.

I made classes that extend Shape to represent circles, rectangles, and triangles(the three example shapes specified). 

ShapeSorter is an object that can sort a list of shapes by area and circumference.

ShapeTest tests my implementation on the specified collection of shapes.