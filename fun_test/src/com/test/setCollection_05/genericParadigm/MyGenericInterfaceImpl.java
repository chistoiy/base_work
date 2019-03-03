package com.test.setCollection_05.genericParadigm;

public class MyGenericInterfaceImpl implements MyGenericInterface<String> {
    @Override
    public void method(String s) {
        System.out.println(s);

    }
}

class MyGenericInterfaceImpl02<I> implements MyGenericInterface<I> {
    @Override
    public void method(I i) {
        System.out.println(i);

    }
}
