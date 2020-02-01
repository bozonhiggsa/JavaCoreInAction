package net.core.tutorial.elementary._25_Collections._01_Lists.ownListImplementation;

import java.util.Iterator;

/**
 * Own List implementation.
 *
 * @author Ihor Savchenko
 * @version 1.0
 */
public class MyListImpl implements MyList, ListIterable {

    private int length = 100;
    private Object[] items;
    private int index;

    public MyListImpl() {
        this.items = new Object[length];
    }

    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    @Override
    public ListIterator listIterator() {

        return new ListIteratorImpl();
    }

    public class IteratorImpl implements Iterator<Object> {
        private int nextIndex;
        private boolean changeAllow;
        private boolean afterNext;

        @Override
        public boolean hasNext() {
            if(nextIndex < index) return true;
            else{
                return false;
            }
        }

        @Override
        public Object next() {
            if(nextIndex >= index){
                throw new IllegalStateException();
            }
            changeAllow = true;
            afterNext = true;
            return items[nextIndex++];
        }

        @Override
        public void remove() {
            if(!changeAllow){
                throw new IllegalStateException();
            }
            else{
                if(afterNext){
                    MyListImpl.this.remove(items[--nextIndex]);
                    changeAllow = false;
                }
                else{
                    MyListImpl.this.remove(items[nextIndex--]);
                    changeAllow = false;
                }
            }
        }
    }

    private class ListIteratorImpl extends IteratorImpl implements ListIterator {

        @Override
        public boolean hasPrevious() {
            if(super.nextIndex > 0 && index!= 0) return true;
            else{
                return false;
            }
        }

        @Override
        public Object previous() {
            if(super.nextIndex == 0 || index == 0){
                throw new IllegalStateException();
            }
            super.changeAllow = true;
            super.afterNext = false;
            super.nextIndex--;
            return items[super.nextIndex];
        }

        @Override
        public void set(Object e) {
            if(!super.changeAllow){
                throw new IllegalStateException();
            }
            else{
                if(super.afterNext){
                    MyListImpl.this.items[super.nextIndex-1] = e;
                }
                else{
                    MyListImpl.this.items[super.nextIndex] = e;
                }
                super.changeAllow = false;
            }
        }
    }

    @Override
    public void add(Object e) {
        if(index < length){
            items[index] = e;
            index++;
        }
        else System.out.println("Ошибка добавления элемента. Массив переполнен");
    }

    @Override
    public void clear() {
        for(int i = 0; i < index; i++){
            items[i] = null;
        }
        index = 0;
    }

    @Override
    public boolean remove(Object o) {
        if(size() == 0){
            throw new IllegalStateException();
        }
        int ind = -1;
        for(int i = 0; i < index; i++){
            if(items[i] == o){
                ind = i;
                break;
            }
        }
        if(ind >= 0 && ind < index-1){
            for(int i = ind; i < index-1; i++){
                items[i] = items[i+1];
            }
            index--;
            return true;
        }
        else if(ind == index-1){
            items[ind] = null;
            index--;
            return true;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] out = new Object[index];
        for(int i = 0; i < index; i++){
            out[i] = items[i];
        }
        return out;
    }

    @Override
    public int size() {
        return index;
    }

    @Override
    public boolean contains(Object o) {
        for(int i = 0; i < index; i++){
            if(items[i] == o){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(MyList c) {
        Object[] anotherArray = c.toArray();
        int listSize = c.size();
        boolean mark = true;
        if(listSize > this.size()) return false;
        for(int i = 0; i < listSize; i++){
            if(!this.contains(anotherArray[i])){
                mark = false;
            }
        }
        return mark;
    }

    @Override
    public String toString() {
        String result = "[";

        for (int i = 0; i < index; i++) {
            if(i == 0){
                result+=items[i];
            }
            else{
                result+=", " + items[i];
            }
        }
        return result + "]";
    }
}
