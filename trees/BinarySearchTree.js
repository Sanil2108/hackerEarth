process.stdin.resume();
process.stdin.setEncoding("utf-8");
var stdin_input = "";

process.stdin.on("data", function (input) {
    stdin_input += input;
});

process.stdin.on("end", function () {
   main(stdin_input);
});

class Tree{
    constructor(startElement){
        this.start = new Node(startElement, this);
    }

    print(node){
        if(node==null){
            return;
        }
        this.print(node.left);
        console.log(node.element);
        this.print(node.right);
    }

    find(element, node){
        if(node.element == element){
            return node;
        }
        if(node.element < element){
            if(node.right == null){
                return node;
            }else{
                return this.find(element, node.right);
            }
        }else{
            if(node.left == null){
                return node;
            }else{
                return this.find(element, node.left);
            }
        }
    }

    add(element){
        let node = this.find(element, this.start);
        if(node.element<element){
            node.right = new Node(element, node);
        }else{
            node.left = new Node(element, node);
        }
    }
}

class Node{
    constructor(element, parent){
        this.element = element;
        this.left = null;
        this.right = null;
        this.parent = parent;
    }
}

function main(input) {
    input = input.trim();
    let n = Number(input[0]);
    let es = input.slice(1, input.length - 2);
    let tree = null;
    for(let i=0;i<es.length;i++){
        let temp = Number(es[i].trim());
        if(!tree){
            tree = new Tree(temp);
        }else{
            tree.add(temp);
        }
    }
    let toFind = Number(input[input.length-2].trim())
    let node = tree.find(
        toFind, tree.start
    );
    tree.print(
        node
    );
}