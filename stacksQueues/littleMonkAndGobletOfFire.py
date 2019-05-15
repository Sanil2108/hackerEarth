arr = []
n = int(input())
for i in range(n):
    temp = input().split(' ')
    if(temp[0] == 'E'):
        temp[1] = int(temp[1])
        temp[2] = int(temp[2])
        indexOfSchool = -1
        for i in range(len(arr)):
            if len(arr[i])>0 and len(arr[i][0])>0 and arr[i][0][0] == temp[1]:
                indexOfSchool = i
        if(indexOfSchool == -1):
            arr.append(
                [
                    (temp[1], temp[2])
                ]
            )
        else:
            arr[indexOfSchool].append(
                (temp[1], temp[2])
            )
    else:
        for i in range(len(arr)):
            if len(arr[i])>0:
                print(str(arr[i][0][0]) + ' ' + str(arr[i][0][1]))
                arr[i] = arr[i][1:len(arr[i])]
                break;
#     print(arr)
