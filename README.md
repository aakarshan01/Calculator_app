# Calculator_app
It is a simple calculator app on the android platform.  The app displays the numerals 0-9, supports arithmetic operations -,+,* and /, answer button =, the clear button C,decimal point ., +/- button to change the  sign of whole expression and % operation.
* If you tap the clear button for a long time, it will work as all clear button.

The order of precedence for the arithmetic operators is as follows:
( / = * = % ) > ( + = - )

Algorithm analysis

I take whole expression as string then using two stacks, one stack stores
operands and other stack stores operators.
One by one the values are popped from the stacks and then the calculated 
values are pushed onto the stack
