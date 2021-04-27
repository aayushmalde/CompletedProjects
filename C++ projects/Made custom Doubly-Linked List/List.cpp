//Aayush Malde, asm7yaq, 9/14/2020, List.cpp

#include "List.h"
#include "ListNode.h"
#include <iostream>
#include <string>
using namespace std;

List::List(){
  head = new ListNode();
  tail = new ListNode();
  head -> next = tail;
  tail -> previous = head;
  count = 0;
}

List::List(const List& source) {
    head=new ListNode();
    tail=new ListNode();
    head->next=tail;
    tail->previous=head;
    count=0;

    // Make a deep copy of the list
    ListItr iter(source.head->next);
    while (!iter.isPastEnd()) {
        insertAtTail(iter.retrieve());
        iter.moveForward();
    }
}

List::~List(){
  //need to delete head and tail as well
  makeEmpty();
  delete head;
  delete tail;
  
}

List& List::operator=(const List& source) {
    if (this == &source) {
        // The two are the same list; no need to do anything
        return *this;
    } else {
        // Clear out anything this list contained
        // before copying over the items from the other list
        makeEmpty();

        // Make a deep copy of the list
        ListItr iter(source.head->next);
        while (!iter.isPastEnd()) {
            insertAtTail(iter.retrieve());
            iter.moveForward();
        }
    }
    return *this;
}

bool List::isEmpty() const{
  if(size()>0){
    return false;
  }
  return true;
}

void List::makeEmpty(){
  if(size()>0){
    ListItr temp = head;
    temp.moveForward();
    while(temp.isPastEnd()==false){
      remove(temp.retrieve());
      temp=head->next;
    }
    
    }
}

ListItr List::first(){
  return head->next;
}

ListItr List::last(){
  return tail->previous;
}

void List::insertAfter(int x, ListItr position){
  ListNode *temp = new ListNode();
  temp->value = x;
  temp->next=position.current->next;
  temp->previous=position.current;
  position.current->next->previous=temp;
  position.current->next=temp;
  count++;
}

void List::insertBefore(int x, ListItr position){
  ListNode *temp = new ListNode();
  temp->value = x;
  temp->next=position.current;
  temp->previous=position.current->previous;
  temp->previous->next=temp;
  position.current->previous=temp;
  count++;
}

void List::insertAtTail(int x){
  ListNode *temp = new ListNode();
  temp->value = x;
  temp->previous=tail->previous;
  temp->next=tail;
  tail->previous->next=temp;
  tail->previous=temp;
  count++;
}

//if not in list, return ListItr object that points to dummy tail node
ListItr List::find(int x){
  ListItr temp = head;
  while(temp.isPastEnd()==false){
    temp.moveForward();
    if(x==temp.retrieve()){
      return temp;
    }
  }
  return temp;
}

void List::remove(int x){
  ListItr temp = find(x);
  if(temp.isPastEnd()==false){
    temp.current->previous->next=temp.current->next;
    temp.current->next->previous=temp.current->previous;
    delete temp.current;
  }
  count--;
}

int List:: size() const{
  return count;
}

void printList(List& source, bool forward){
  if(forward==true){
    ListItr temp = source.first();
    while(temp.isPastEnd()==false){
      cout << temp.retrieve() << " ";
      temp.moveForward();
    }
    cout << endl;
  }
  else{
    ListItr temp = source.last();
    while(temp.isPastBeginning()==false){
      cout << temp.retrieve() << " ";
      temp.moveBackward();
    }
    cout << endl;
  }
}



