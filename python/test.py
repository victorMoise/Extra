def main():
    n = int(input("Dimensiunea dicționarului: "))

    dictionar = {}

    for i in range(n):
        cheie = input("Cheia {}: ".format(i+1))
        valoare = input("Valoarea pentru cheia {}: ".format(i+1))
        dictionar[cheie] = valoare

    tuplu_chei = tuple(dictionar.keys())
    tuplu_valori = tuple(dictionar.values())

    print("Dicționar: ", dictionar)
    print("Tuplul cheilor: ", tuplu_chei)
    print("Tuplul valorilor: ", tuplu_valori)


main()