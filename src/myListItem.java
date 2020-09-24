public class myListItem <Type>{
    myListItem prev;
    myListItem next;
    Type data;
    public myListItem(myListItem Prev, myListItem Next, Type Data){
        prev = Prev;
        next = Next;
        data = Data;
    }
}

