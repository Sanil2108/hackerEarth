if __name__ == '__main__':
    n = int(input())
    names_array = [0] * n
    for i in range(n):
        roll_num_name = input().split(' ')
        names_array[int(roll_num_name[0]) - 1] = roll_num_name[1]

    q = int(input())
    for i in range(q):
        print(names_array[int(input()) - 1])
