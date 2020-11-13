package com.donte.mergehull;
/**
 *
 * @author Donte
 */
public class ListaCircular {
    private Object item;
    private ListaCircular next;
    private ListaCircular prev;

    public ListaCircular(Object ob){
       item = ob;
       next = prev = this;
    }

    public ListaCircular getNext() {
        return next;
    }

    public ListaCircular getPrev() {
        return prev;
    }

    public Object getItem() {
        return item;
    }

    public void setNext (ListaCircular list) {
        next = list;
    }

    public void setPrev (ListaCircular list) {
        prev = list;
    }

    public void setItem (Object ob) {
        item = ob;
    }

    public void insereFim (ListaCircular list) {
        list.setNext(this.getNext());
        this.getNext().setPrev(list);
        list.setPrev(this);
        this.setNext(list);
    }

    public void insereInicio (ListaCircular list) {
        list.setPrev(this.getPrev());
        this.getPrev().setNext(list);
        list.setNext(this);
        this.setPrev(list);
    }

    public void remove () {
        this.getNext().setPrev(this.getPrev());
        this.getPrev().setNext(this.getNext());
    }

    public ListaCircular procura (Object o) {
        ListaCircular ret = this;
        do {
            if (o.equals(ret)) return ret;
            ret = ret.getNext();
        } while (ret != this);
        return null;
    }

    public ListaCircular procuraItemMenorXMenorY() {
        int minX = ((Ponto)this.getItem()).getX();
        int minY = ((Ponto)this.getItem()).getY();
        ListaCircular lmin = this;
        ListaCircular temp = this.getNext();

        while(temp != this){
            if (((Ponto)temp.getItem()).getX() < minX) {
                minX = ((Ponto)temp.getItem()).getX();
                minY = ((Ponto)temp.getItem()).getY();
                lmin = temp;
            }else if(((Ponto)temp.getItem()).getX() == minX && ((Ponto)temp.getItem()).getY() < minY){
                minX = ((Ponto)temp.getItem()).getX();
                minY = ((Ponto)temp.getItem()).getY();
                lmin = temp;
            }
            temp = temp.getNext();
        }
        return lmin;

    }

    public ListaCircular procuraItemMenorXMaiorY() {
        int minX = ((Ponto)this.getItem()).getX();
        int maxY = ((Ponto)this.getItem()).getY();
        ListaCircular lmin = this;
        ListaCircular temp = this.getNext();

        while(temp != this){
            if (((Ponto)temp.getItem()).getX() < minX) {
                minX = ((Ponto)temp.getItem()).getX();
                maxY = ((Ponto)temp.getItem()).getY();
                lmin = temp;
            }else if(((Ponto)temp.getItem()).getX() == minX && ((Ponto)temp.getItem()).getY() > maxY){
                minX = ((Ponto)temp.getItem()).getX();
                maxY = ((Ponto)temp.getItem()).getY();
                lmin = temp;
            }
            temp = temp.getNext();
        }
        return lmin;
    }

     public ListaCircular procuraItemMaiorXMenorY() {
        int maxX = ((Ponto)this.getItem()).getX();
        int minY = ((Ponto)this.getItem()).getY();
        ListaCircular lmin = this;
        ListaCircular temp = this.getNext();

        while(temp != this){
            if (((Ponto)temp.getItem()).getX() > maxX) {
                maxX = ((Ponto)temp.getItem()).getX();
                minY = ((Ponto)temp.getItem()).getY();
                lmin = temp;
            }else if(((Ponto)temp.getItem()).getX() == maxX && ((Ponto)temp.getItem()).getY() < minY){
                maxX = ((Ponto)temp.getItem()).getX();
                minY = ((Ponto)temp.getItem()).getY();
                lmin = temp;
            }
            temp = temp.getNext();
        }
        return lmin;

    }

    public ListaCircular procuraItemMaiorXMaiorY() {
        int maxX = ((Ponto)this.getItem()).getX();
        int maxY = ((Ponto)this.getItem()).getY();
        ListaCircular lmin = this;
        ListaCircular temp = this.getNext();

        while(temp != this){
            if (((Ponto)temp.getItem()).getX() > maxX) {
                maxX = ((Ponto)temp.getItem()).getX();
                maxY = ((Ponto)temp.getItem()).getY();
                lmin = temp;
            }else if(((Ponto)temp.getItem()).getX() == maxX && ((Ponto)temp.getItem()).getY() > maxY){
                maxX = ((Ponto)temp.getItem()).getX();
                maxY = ((Ponto)temp.getItem()).getY();
                lmin = temp;
            }
            temp = temp.getNext();
        }
        return lmin;
    }

}

/*
  /*public ListaCircular procuraItemMaiorX() {
        int max = ((Ponto)this.getItem()).getX();
        ListaCircular lmax = this;
        ListaCircular temp = this.getNext();

        while(temp != this){
            if (((Ponto)temp.getItem()).getX() > max) {
                max = ((Ponto)temp.getItem()).getX();
                lmax = temp;
            }
            temp = temp.getNext();
        }
        return lmax;

    }

    public ListaCircular procuraItemMenorX() {
        int min = ((Ponto)this.getItem()).getX();
        ListaCircular lmin = this;
        ListaCircular temp = this.getNext();

        while(temp != this){
            if (((Ponto)temp.getItem()).getX() < min) {
                min = ((Ponto)temp.getItem()).getX();
                lmin = temp;
            }
            temp = temp.getNext();
        }
        return lmin;

    }
 */