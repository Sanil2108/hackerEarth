from math import sqrt


class Node(object):
    def __init__(self, x, y):
        self.posx = x
        self.posy = y
        self.nodes = []

    def add_node(self, node):
        self.nodes.append(node)

    def __str__(self):
        return str(self.posx) + ", " + str(self.posy)


class Graph(object):
    def __init__(self, start):
        self.start = start

    def print_depth2(self, node):
        print(node)
        for i in range(len(node.nodes)):
            self.print_depth2(node.nodes[i])

    def print_depth(self):
        self.print_depth2(self.start)

    def print_breadth(self):
        queue = [self.start]
        queue_permanent = [self.start]
        while len(queue) is not 0:
            new_node = queue[0]
            queue = queue[1:]
            for node in new_node.nodes:
                if node not in queue_permanent:
                    queue_permanent.append(node)
                    queue.append(node)

        print(queue_permanent)

    def __len__(self):
        return self.size

def get_input():
    string = raw_input()
    number = 8 - int(string[1])

    letter = string[0]
    number2 = ord(letter) - 97

    # print(number, number2)

    return (number, number2)

def get_queue(m, n, x, y, target_x, target_y):
    grid = [[0] * m for i in range(n)]
    start = Node(x, y)
    graph = Graph(start)

    if x == target_x and y == target_y:
    	return 0

    current_x = x
    current_y = y

    previous_node = start
    nodes_queue = [start]
    nodes_queue_permanent = [(x, y)]

    energy_count = 0

    next_counter = 1

    while (True):
        if len(nodes_queue_permanent) == next_counter:
            next_counter = (sqrt(next_counter) + 2) ** 2
            energy_count += 1
        new_node = nodes_queue[0]
        nodes_queue = nodes_queue[1:]
        current_x = new_node.posx
        current_y = new_node.posy
        for i in range(current_y - 1, current_y + 2):
            for j in range(current_x - 1, current_x + 2):
                n = Node(j, i)
                if j == target_x and i == target_y:
                    return energy_count
                if not (i == current_y and j == current_x) and (
                j, i) not in nodes_queue_permanent:
                    new_node.add_node(n)
                    nodes_queue.append(n)
                    nodes_queue_permanent.append((j, i))
        # energy_count += 1

    print(energy_count)
    graph.print_breadth()


def easy_way(a, b, start1, start2, target1, target2):
	# print(start1, start2)
	# print(target1, target2)
	return max(abs(target2 - start2), abs(target1 - start1))

t = input()
for i in range(t):
    start = get_input()
    target = get_input()
    # print(get_queue(8, 8, start[0], start[1], target[0], target[1]))
    print(easy_way(8, 8, start[0], start[1], target[0], target[1]))

