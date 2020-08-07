# StackCalculator

It is a calculator that accumulates a sequence of operands and operations in the stack, and then successively extracts them from the stack and calculates the result of the expression.

# To use
  Type name of command in uppercase and parameters if available. <br />You can use "#" for acomment.<br />
  Example:<br /><br />
  DEFINE a 4<br />
  PUSH a<br />
  PUSH 5<br />
  PRINT<br />
  +<br />
  SQRT<br />
  PRINT<br />
  
  Output of example:<br /><br />
  5.0<br />
  3.0<br />
  
  # All commands
  - PRINT (prints first element from stack)
  - POP (deletes first element from stack)
  - PUSH [variable name or value] (add variable name or number at the beginning of stack)
  - SQRT (take first from stack, get square root, and put back on the top of stack)
  - DEFINE [variable name] [value] (remember variable name with value)
  - "+" (take two first values from stack, add together and put answer at the beginning of stack)
  - "/" (take two first values from stack, devide and put answer at the beginning of stack)
  - "*" (take two first values from stack, multiple together and put answer at the beginning of stack)
  - "-" (take two first values from stack, deduct from one another and put answer at the beginning of stack)
  - "#" (after this simbol you can put comment and it won't execute)
