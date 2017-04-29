class UndirectedGraph:
    MIN_VALUE = 3

    def __init__(self):
        self.__init__(self, UndirectedGraph.MIN_VALUE)

    def __init__(self, n):
        self.n = n;

        self.adjacency_matrix = [[0 for i in range(n)] for j in range(n)]
        self.V = []
        self.E = []

    def add_vertice(self, v):
        self.V.append(v)

    def add_edge(self, e):
        self.E.append(e)

    def add_adjacency(self, m, n):
        if (m >= len(self.adjacency_matrix[0]) or n >= len(self.adjacency_matrix[0])):
            for i in range(len(self.adjacency_matrix)):
                for j in range(max(m, n) - len(self.adjacency_matrix) + 1):
                    self.adjacency_matrix[i].append(0)
            for j in range(max(m, n)-len(self.adjacency_matrix)+1):
                self.adjacency_matrix.append([0 for i in range(len(self.adjacency_matrix[0]))])

            self.adjacency_matrix[m][n] = 1
            self.adjacency_matrix[n][m] = 1

        else:
            self.adjacency_matrix[m][n] = 1
            self.adjacency_matrix[n][m] = 1

    def print_adjacency_matrix(self):
        for i in range(len(self.adjacency_matrix)):
            for j in range(len(self.adjacency_matrix)):
                print(self.adjacency_matrix[i][j], end='\t')
            print()

    class Vertice:

        _id = 0

        def __init__(self, n, G):
            self._id = UndirectedGraph.Vertice._id
            UndirectedGraph.Vertice._id += 1
            self.n = n
            self.edges = []
            self.G = G
            G.add_vertice(self)

        def add_edge(self, edge):
            self.edges.append(edge)

    class Edge:

        def __init__(self, v1, v2, G):
            v1.add_edge(self)
            v2.add_edge(self)
            G.add_edge(self)

            G.add_adjacency(v1._id, v2._id)


def get_input_arr():
    temp1 = input().split(' ')
    N = int(temp1[0])
    M = int(temp1[1])
    arr=[0 for i in range(2*M+2)]
    arr[0]=N
    arr[1]=M
    i=2
    while(i<2*M+2):
        temp = list(input().split(' '))
        arr[i] = int(temp[0])
        i+=1
        arr[i] = int(temp[1])
        i+=1

    Q = int(input())

    arr2 = [0 for j in range(2*Q+1)]
    arr2[0]=Q
    i=1

    while(i<2*Q+1):
        temp = list(input().split(' '))
        arr2[i] = int(temp[0])
        i += 1
        arr2[i] = int(temp[1])
        i += 1

    # print(arr2)
    return arr+arr2


def edge_existence():
    # Create an array to store values
    # temp=input()

    # arr = list(input().split(' '))
    # arr = [int(i) for i in arr]
    # print(arr)
    arr=get_input_arr()
    # index to increment by one each time a data item is used
    index = 0

    g = UndirectedGraph(arr[index])
    index += 1
    M = arr[index]
    index += 1
    for i in range(M):
        temp = arr[index]
        index += 1
        temp2 = arr[index]
        index += 1
        g.add_adjacency(temp, temp2)
    Q = arr[index]
    index += 1
    for i in range(Q):
        m = arr[index]
        index += 1
        n = arr[index]
        index += 1
        if (g.adjacency_matrix[m][n] == 1):
            print('YES')
        else:
            print('NO')

edge_existence()


# get_input_arr()