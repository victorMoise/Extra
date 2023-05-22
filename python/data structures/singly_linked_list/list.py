from node import *

#Indexing starts from 0
class list(object):
    def __init__(self):
        self.head = None
        self.lenght = 0
    

    def valueOfHead(self):
        return self.head.data


    def adressOfHead(self):
        return hex(id(self.head))


    def listLenght(self):
        return self.lenght


    def push(self, newData):
        newNode = Node(newData)
        newNode.next = self.head
        self.head = newNode
        self.lenght += 1
    

    def insertAtIndex(self, newData, index):
        if index > self.lenght:
            print("Given index outside of list index!")
            return
        newNode = Node(newData)
        if index == 0:
            newNode.next = self.head
            self.head = newNode
            self.lenght += 1
            return  
        current = self.head
        for i in range(index - 1):
            current = current.next
        newNode.next = current.next
        current.next = newNode
        self.lenght += 1


    def append(self, newData):
        newNode = Node(newData)
        if self.head == None:
            self.head = newNode
            self.lenght += 1
            return
        current = self.head
        while current.next != None:
            current = current.next
        current.next = newNode
        self.lenght += 1


    def deleteFirstNode(self):
        self.head = self.head.next
        self.lenght -= 1


    def deleteLastNode(self):
        current = self.head
        previous = None
        while current.next != None:
            previous = current
            current = current.next
        previous.next = None
        self.lenght -= 1
        current = None


    def deleteNodeAtIndex(self, index):
        if self.lenght == 0:
            print("List is already empty!")
            return
        if index >= self.lenght:
            print("Given index out of list index!")
            return
        if index == 0:
            self.head = self.head.next
            self.lenght -= 1
            return
        current = self.head
        for i in range(index - 1):
            current = current.next
        current.next = current.next.next
        self.lenght -= 1
        current = None
        

    def deleteFirstValue(self, value):
        current = self.head
        if current != None:
            if current.data == value:
                self.head = current.next
                current = None
                return
        while current != None:
            if current.data == value:
                break
            previous = current
            current = current.next
        if current == None:
            return
        previous.next = current.next
        self.lenght -= 1
        current = None


    def deleteValue(self, value):
        current = self.head
        previous = None
        while current != None and current.data == value:
            self.head = current.next
            current = self.head
            self.lenght -= 1
        while current != None:
            while current != None and current.data != value:
                previous = current
                current = current.next
            if current == None:
                return
            previous.next = current.next
            current = previous.next
            self.lenght -= 1

    
    def deleteLastValue(self, value):
        current = self.head
        lastAppearance = None
        while current != None:
            if current.data == value:
                lastAppearance = current
            current = current.next
        if lastAppearance != None and lastAppearance.next == None:
            current = self.head
            while current.next != lastAppearance:
                current = current.next
            current.next = None
            self.lenght -= 1
        if lastAppearance != None and lastAppearance.next != None:
            lastAppearance.data = lastAppearance.next.data
            current = lastAppearance.next
            lastAppearance.next = lastAppearance.next.next
            self.lenght -= 1


    def firstIndexOfValue(self, value):
        current = self.head
        index = 0
        while current != None:
            if current.data == value:
                return index
            current = current.next
            index += 1
        return -1


    def lastIndexOfValue(self, value):
        current = self.head
        index = 0
        returnIndex = -1
        while current != None:
            if current.data == value:
                returnIndex = index
            index += 1
            current = current.next
        return returnIndex


    def display(self):
        current = self.head
        if self.head is None:
            print("List is empty!")
            return
        print("Data stored in the list: ")
        while current is not None:
            print(current.data, end = " ")
            current = current.next
        print("\n")