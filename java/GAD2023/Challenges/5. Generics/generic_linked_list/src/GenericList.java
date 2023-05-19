class GenericList<T> implements IGenericList<T> {
    private IGenericNode<T> root;

    public GenericList(T rootValue) {
        this.root = new GenericNode<>(rootValue);
    }

    @Override
    public void insert(T element) {
        IGenericNode<T> newNode = new GenericNode<>(element);
        IGenericNode<T> current = root;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(newNode);
    }

    @Override
    public void println() {
        IGenericNode<T> current = root;
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
    }
}
