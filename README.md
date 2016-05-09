# Immutable Queue
## A Java way of implementing an Immutable Queue

The idea was taken from these two articles on [Immutable Stack] and [Immutable Queue] by [Eric Lippert]. The original articles use C# as the implementation language. For my implementation, I used Java. The immutable queue uses two immutable stacks, *backwards* and *forwards*, to keep track of the items being enQueued and deQueued, respectively. The summary of the data structures and algorithms is as follows.

### Immutable Stack
* Implements interface *Stack*.
* Represented by class *ImmutableStack*.
* Has a head element and a tail which is another ImmutableStack.
* No public constructor. Forced to start with an empty stack, which is a singleton represented by inner class *EmptyStack*.
* Has a private constructor which builds itself using the head and tail provided as parameters.
* *push()* operation just creates a new stack using the existing stack as tail and the new element as head, and returns the new stack. Runs in O(1) time.
* *pop()* operation just returns the tail. Runs in O(1) time.
* *head()* operation just returns the head. Runs in O(1) time.
* *IsEmpty()* is always true for the empty singleton stack. Otherwise it's always false. Runs in O(1) time.

### Immutable Queue
* Implements interface *Queue*.
* Represented by class *ImmutableQueue*.
* The philosophy is that since a queue is effectively a reverse stack, it can be implemented using 2 stacks.
* Has 2 immutable stacks, *backwards* and *forwards*, to keep track of the items being enQueued and deQueued, respectively.
* No public constructor. Forced to start with an empty queue, which is a singleton represented by inner class *EmptyQueue*.
* Has a *reverse()* utility method that is used to reverse a stack. Runs in O(n) time.
* Has a private constructor which builds itself using the *backwards* and *forwards* stacks provided as parameters.
* *enQueue()* operation just pushes the new item to the *backwards* and creates a new queue using the existing *forwards* stack and the new *backwards* stack. There is one exception to this, however, when the very first *enQueue* is done. In that case, the item is pushed to the *forwards* stack. This is necessary since otherwise *deQueue()* will always fail, as per the *deQueue* logic described below. Runs in O(1) time.
* *deQueue()* operation is a bit tricky. It first pops from the *forwards* stack. Now it can have a few cases:
  - If the resulting stack of the *pop()* operation is the not the empty stack (means there are still items on the *forwards* stack to be deQueued), it returns a new queue constructed with the empty stack as *forwards* and the existing *backwards* as *backwards*.
  - If the resulting stack of the *pop()* operation is the empty stack (means there are no more items on the *forwards* stack to be deQueued), there could be two further sub-cases:
    - If the *backwards* stack is empty as well, then what we have at this point is an empty queue. So it just returns the empty singleton queue.
    - If the *backwards* stack is not empty, however, then we need to get rd of the bottommost item in the *backwards* stack. This is accomplished by reversing the *backwards* stack (using the *rervse()* method). Finally, it returns a new queue constructed using the reversed stack as *forwards* and the empty singleton stack as *backwards*.

  The last case is the worst case where the runtime of *deQueue()* is O(n). All the previous cases are O(1).
* *head()* operation just returns the head of the *forwards* stack. Runs in O(1) time.
* *IsEmpty()* is always true for the empty singleton queue. Otherwise it's always false. Runs in O(1) time.

[//]: # (References)
[Immutable Stack]: <https://blogs.msdn.microsoft.com/ericlippert/2007/12/04/immutability-in-c-part-two-a-simple-immutable-stack/>
[Immutable Queue]: <https://blogs.msdn.microsoft.com/ericlippert/2007/12/10/immutability-in-c-part-four-an-immutable-queue/>
[Eric Lippert]: <https://social.msdn.microsoft.com/profile/Eric+Lippert>
