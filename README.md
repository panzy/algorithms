Here is an incomplete collection of algorithms I practised over the years, with
the problems mainly from LeetCode.

The goal is not just to solve the problems, but also to write clean code.

To keep the code clean, this methodology is used to organize a program: the
main function reads like pseudo-code, clearly showing the solution's idea, and
subroutines provide vocabularies for the pseudo-code. Each subroutine is proved
correct by unit tests.

Unit tests are heavily used. They are not written after the solution code has
finished, but are written in parallel with the solution being developed. They
serve as milestones for the final solution.

Every solution should be easy to test in a shell with a command as simple as
`bash run.sh`.
