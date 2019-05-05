import sys

class Node():
    def __init__(self, value):
        self.value = value
        self.right = None
        self.left = None
        
    def __str__(self):
        return str(self.value);

class BinaryTree():
    def __init__(self):
        self.start = None;
        
    def findPosition(self, value, node):
        if(node.value < value):
            if(node.right == None):
                return node
            else:
                return self.findPosition(value, node.right)
        else:
            if(node.left == None):
                return node
            else:
                return self.findPosition(value, node.left)
    
    def addNode(self, value):
        n = Node(value)
        if(self.start == None):
            self.start = n
        else:
            oldNode = self.findPosition(value, self.start);
            if(oldNode.value < value):
                oldNode.right = n;
            else:
                oldNode.left = n
                
    def findNode(self, value, node):
        if(node.value == value):
            return node
        if(node.value < value):
            if(node.right == None):
                return None
            else:
                return self.findPosition(value, node.right)
        else:
            if(node.left == None):
                return None
            else:
                return self.findPosition(value, node.left)
            
    def findPathFromRoot(self, value, node, arr):
        arr.append(node.value)
        if(node.value == value):
            return arr
        if(node.value < value):
            if(node.right == None):
                return None
            else:
                return self.findPathFromRoot(value, node.right, arr)
        else:
            if(node.left == None):
                return None
            else:
                return self.findPathFromRoot(value, node.left, arr)
                
    def findPathNaive(self, value1, value2):
        path1 = self.findPathFromRoot(value1, self.start, [])
        path2 = self.findPathFromRoot(value2, self.start, [])
        i=0
        while(i<len(path1) and i<len(path2) and path1[i] == path2[i]):
            i+=1
        if i!=0:
            path1 = path1[(i):]
            path2 = path2[(i-1):]
        path1.reverse()
        return path1 + path2
                
    def printInorder(self, node):
        if(node.left != None):
            self.printInorder(node.left)
        print(node.value)
        if(node.right != None):
            self.printInorder(node.right)

sys.setrecursionlimit(1500)

# def main():
inp = input().split()
t = int(inp[0])
inp = input().split()
k=0
b = BinaryTree()
for i in range(t):
    b.addNode(int(inp[k]))
    k+=1
inp = input().split()
k=0
x = int(inp[k])
y = int(inp[k+1])
print(max(b.findPathNaive(x, y)))
