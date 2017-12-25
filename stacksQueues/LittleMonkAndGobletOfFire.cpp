#include <stdlib.h>
#include <iostream>

using namespace std;

struct node{
    struct node * before;
    struct node * next;
    //school no
    int value1;
    //roll no
    int value2;
};

class LinkedList{
    public:
    struct node * start;

    LinkedList(){
        start = NULL;
    }

    void print(){
        struct node * ptr = start;
        while(ptr!=NULL){
            cout<<ptr->value1<<"\t"<<ptr->value2<<"\n";
            ptr = ptr->next;
        }
        cout<<"\n";
    }

    // void insertFront(int value){
    //     struct node * node = (struct node *)malloc(sizeof(struct node));
    //     node->value = value;
    //     node->next = start;
    //     node->before = NULL;
        
    //     start = node;
    // }

    void insertStudent(int value1, int value2){
        if(start == NULL){
            start = (struct node *)malloc(sizeof(struct node));
            start -> next = NULL;
            start -> before = NULL;
            start -> value1 = value1;
            start -> value2 = value2; 
            return;
        }

        struct node * newNode = (struct node *)malloc(sizeof(struct node));
        newNode -> value1 = value1;
        newNode -> value2 = value2;

        if(start -> next == NULL){
            if(start->value1 < value1 ||(start->value1 == value1 && start->value2<value2)){
                newNode -> next = NULL;
                newNode -> before = start;
                start -> next = newNode;
            }else{
                newNode -> next = start;
                newNode -> before = NULL;
                start = newNode;
            }

            return;
        }

        struct node * node = start;
        while(node->next->value1<value1 || node->next!=NULL){
            node = node->next;
        }


        // if(node->next->value1 > value1){
        //     newNode->next = node->next;
        //     newNode->before = node;
        //     node->next = newNode;
        // }else{
        //     while(node->next->value2 < value2){
        //         node = node->next;
        //     }
        //     newNode->next = node->next;
        //     newNode->before = node;
        //     node->next = newNode;
        // }
    }

    // int removeFront(){
    //     if(start == NULL){
    //         return -1;
    //     }
    //     int k = start->value;
    //     if(start->next == NULL){
    //         start = NULL;
    //         return k;
    //     }

    //     start = start->next;
    //     return k;
    // }
    
};

int main(){
    LinkedList linkedList;
    linkedList.insertStudent(2,1);
    linkedList.insertStudent(3,1);
    linkedList.insertStudent(4,1);
    // linkedList.insertStudent(5,1);
    // linkedList.print();
    // linkedList.insertBack(2);
    // linkedList.print();
    // linkedList.insertBack(3);
    // linkedList.print();
    // linkedList.insertBack(4);
    // linkedList.print();
    // linkedList.insertBack(5);
    // linkedList.print();

    // cout<<linkedList.removeFront()<<"\n";
    // linkedList.print();
    // cout<<linkedList.removeFront()<<"\n";
    // linkedList.print();
    // cout<<linkedList.removeFront()<<"\n";
    // linkedList.print();
    // cout<<linkedList.removeFront()<<"\n";
    // linkedList.print();
    // cout<<linkedList.removeFront()<<"\n";
    // linkedList.print();
    // cout<<linkedList.removeFront()<<"\n";
    // linkedList.print();
    // cout<<linkedList.removeFront()<<"\n";
    // linkedList.print();
    // cout<<linkedList.removeFront()<<"\n";
    // linkedList.print();
    // cout<<linkedList.removeFront()<<"\n";
    // linkedList.print();
    // cout<<linkedList.removeFront()<<"\n";
    // linkedList.print();



    return 0;
}