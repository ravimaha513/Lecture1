
interface RandomAccessSet<T> {
    // Add "x" to the container.  Do nothing if the container already
    // contains "x".  Should execute in O(1) time with respect to the number
    // of items in the container
    void add(T x);

    // Remove "x" from the container.  Do nothing if the container does not
    // contain a value equal to "x".  Should execute in O(1) time with
    // respect to the number of items in the container.
    void remove(T x);

    // Select and return a random member of the container.  Return null
    // if the container is empty.  All items in the container should have
    // an equal probability of being selected.  Should execute in O(1) time
    // with respect to the number of items in the container
    T getRandom();
}

class RandomAccessSetImpl<T> implements RandomAccessSet<T>{

    Map<Integer, T> elements = new HashMap<>();
    Map<T, Integer> dualElements = new HashMap<>();
    
    public void add(T x){
        int random  = elements.size();
        elements.put(random, x);
        dualElements.put(x, random);
    }

    public void remove(T x){
        int idx = dualElements.getOrDefault(x, -1);
        if(idx != -1){
            int size = elements.size();
            T temp = elements.get(size - 1);

            elements.remove(size - 1);
            dualElements.remove(x);
            elements.put(idx,temp);
            dualElements.put(temp, idx);
        }
    }

    public T getRandom(){
        int size = elements.size();
        int idx = (int) ( Math.random() % size );
        return elements.get(idx);
    }
}
