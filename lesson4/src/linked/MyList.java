package linked;

import java.util.Collection;
import java.util.Iterator;

//https://habr.com/ru/post/127864/
public class MyList<E> implements Iterable<E> {

    private int size = 0;

    //всегда =null, nextElem и prevElem указывают на первыи и последний элемент списка
    private Node<E> header = new Node<>(null, null, null);

    public MyList() {
        //список пуст- nextElem и prevElem указывают сами на себя, т.е на header
        header.nextElem = header.prevElem = header;
    }

    //кол-во элементов
    public int size() {
        return size;
    }

    //в конец
    public void add(E element) {
        Node<E> newNode = new Node<>(header.prevElem, element, null);

        //Переопределяем указатели
        newNode.prevElem.nextElem = newNode;
        header.prevElem = newNode;
        size++;
    }

    //по индексу
    public void add(int index, E element) {

        if (index == size) {    //Если добавляем в конец
            add(element);
            return;
        }

        Node<E> nextNode = node(index);
        Node<E> newNode = new Node<>(nextNode.prevElem, element, nextNode);

        nextNode.prevElem = newNode;
        newNode.prevElem.nextElem = newNode;
        size++;
    }

    //узел по индексу
    private Node<E> node(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        Node<E> n = header;

        //В целях экономии проходим только половину списка
        if (index < (size >> 1))     //Cдвиг вправо - выполняется деление на два с отбрасыванием остатка
        {
            for (int i = 0; i <= index; i++)
                n = n.nextElem;
        } else {
            for (int i = size; i > index; i--)
                n = n.prevElem;
        }
        return n;
    }

    //возвращаем элемент
    public E get(int index) {
        return node(index).item;
    }

    //удаляем по индексу
    public E remove(int index) {
        Node<E> removeNode = node(index);

        if (removeNode.nextElem != null) {                  //Это не последний элемент
            removeNode.prevElem.nextElem = removeNode.nextElem;
            removeNode.nextElem.prevElem = removeNode.prevElem;
        } else {                                        //Это последний элемент
            removeNode.prevElem.nextElem = null;
            header.prevElem = removeNode.prevElem;
        }

        //Обрываем все связи
        removeNode.nextElem = null;
        removeNode.prevElem = null;
        size--;

        return removeNode.item;
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> e = header;

            @Override
            public boolean hasNext() {
                return e.nextElem != null;
            }

            @Override
            public E next() {
                e = e.nextElem;
                return e.item;
            }
        };
    }

    //добавляем все элементы
    public boolean addAll(Collection<? extends E> collection) {
        if (collection.size() == 0) return false;
        for (E elem : collection) {
            this.add(elem);
        }
        return true;
    }


    public boolean copy(Collection<? super E> collection) {
        if (size == 0) return false;
        for (E element : this) {
            collection.add(element);
        }
        return true;

    }

    private static class Node<E> {
        E item;
        Node<E> nextElem;
        Node<E> prevElem;

        Node(Node<E> prevElem, E element, Node<E> nextElem) {
            this.item = element;
            this.nextElem = nextElem;
            this.prevElem = prevElem;
        }
    }
}

