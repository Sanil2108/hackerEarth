import random
import sys

def quicksort(start, end, A):
    if start == end:
        return A
    pivot = random.randrange(start, end+1)
    A[start], A[pivot] = A[pivot], A[start]
    pivot = start
    i = start
    j = start + 1
    while(j<=end):
        if A[j]<A[pivot]:
            if j!= i + 1:
                A[i], A[i+1] = A[i+1], A[i]
            A[i], A[j] = A[j], A[i]
            i += 1
            pivot = i
        j += 1
    if i-1>=start:
        A = quicksort(start, i-1, A)
    if i+1<=end:
        A = quicksort(i+1, end, A)
    return A

n = input()
arr_s = raw_input()
A = arr_s.split(' ')
for i in range(n):
    A[i] = int(A[i])

# A = [4, 3, 1, 5, 2]
A = quicksort(0, len(A) - 1, A)
for i in range(len(A)):
    sys.stdout.write(str(A[i])+" ") 