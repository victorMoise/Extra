from list import *

def main():
    myList = list()
    for i in range(10):
        myList.append(i)
    print(myList.lastIndexOfValue(5))
    myList.display()
    print(myList.listLenght())
    

if __name__ == "__main__":
    main()