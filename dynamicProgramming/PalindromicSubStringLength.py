string = "aabaaz"

grid = [[0]*len(string) for i in range(len(string))]
m=0
n=0

for i in range(len(grid)):
    for j in range(len(grid)-i):
        if i==0:
            grid[m][n] = 1
        else:
            prev_letter = string[m]
            current_letter = string[n]
            if prev_letter==current_letter:
                grid[m][n]=max(grid[m-1][n-1]+2, grid[m][n-1])
            else:
                grid[m][n]=grid[m][n-1]
        
        m+=1
        n+=1
    m=0
    n=i

print(grid)