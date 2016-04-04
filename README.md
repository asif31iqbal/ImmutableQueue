# ImmutableQueue
## A Java way of implementing an Immutable Queue.

The idea was taken from these two articles on [Immutable Stack] and [Immutable Queue] by [Eric Lippert]. The original articles use C# as the implementation language. For my implementation, I used Java. The immutable queue uses two immutable stacks, *backwards* and *forwards*, to keep track of the items being enQueued and deQueued, respectively.     

[//]: # (References)
[Immutable Stack]: <https://blogs.msdn.microsoft.com/ericlippert/2007/12/04/immutability-in-c-part-two-a-simple-immutable-stack/>
[Immutable Queue]: <https://blogs.msdn.microsoft.com/ericlippert/2007/12/10/immutability-in-c-part-four-an-immutable-queue/>
[Eric Lippert]: <https://social.msdn.microsoft.com/profile/Eric+Lippert>
