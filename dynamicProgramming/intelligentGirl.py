import sys

string = raw_input()
arr = [int(i) for i in string]

dynamic_arr = [0]*len(arr)

if arr[-1] % 2 == 0:
    dynamic_arr[-1] = 1
else:
    dynamic_arr[-1] = 0

for i in range(len(dynamic_arr)-2, -1, -1):
    if arr[i]%2 == 0:
        dynamic_arr[i] = dynamic_arr[i+1] + 1
    else:
        dynamic_arr[i] = dynamic_arr[i+1]

for i in dynamic_arr:
    sys.stdout.write(str(i) + ' ')