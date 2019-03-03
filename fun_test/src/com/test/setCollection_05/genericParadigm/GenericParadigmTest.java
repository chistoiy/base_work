package com.test.setCollection_05.genericParadigm;
/*
* 泛型  一种未知的数据类型，在不清楚具体是会出现什么数据类型时，使用泛型代替
*           可看作是一种变量，用来接受数据类型
*           E e:element元素
*           T t:Type 类型
*
*           好处：避免类型转换的麻烦，将运行期异常，转为编译期异常
*           弊端：
*               泛型是什么类型，只能存储什么类型的数据
*      定义类 参见GenericT类
*      定义泛型方法：
*           普通方法
*               定义位于修饰符与返回类型之间
*           静态方法;
*      定义泛型接口：
*           第一种实现类在实现接口时，确定泛型类型 MyGenericInterfaceImpl
*           第二种实现类（MyGenericInterfaceImpl02）在实现接口时也使用跟接口一样的泛型，在实现类被实例时确定类型，如ArrayList<String> list = new ArrayList<>();
*
* 泛型通配符：？代表任意数据类型
*           不能创建对象使用，只能作为方法参数使用,例对ArrayList添加数据时，不能使用<?>
*
* 泛型的上限限定： ？ extends E 代表使用的泛型只能是E类型的子类/本身
*       下线限定  ？ super E 代表使用的泛型只能是E类型的父类/本身
* */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

class GenericT<E>{
    private E name;

    public E getName() {
        return name;
    }

    public void setName(E name) {
        this.name = name;
    }
    public <M> void method(M m){
        System.out.println(m);
    }
    public static <L> void methodstatic(L l){
        System.out.println(l);
    }

}


public class GenericParadigmTest {
    public static void main(String[] args) {

        GenericT<String> t = new GenericT<String>();
        t.setName("张三");
        System.out.println(t.getName());
        System.out.println("普通方法泛型==========");
        t.method("abc");
        System.out.println("静态方法泛型==========");
        GenericT.methodstatic("loop");

        System.out.println("接口泛型第一种===========");
        MyGenericInterfaceImpl mi = new MyGenericInterfaceImpl();
        mi.method("蓝波");


        System.out.println("接口泛型第二种===========");
        MyGenericInterfaceImpl02<String> mi2 = new MyGenericInterfaceImpl02<>();
        mi2.method("小南");

        System.out.println("泛型通配符=========");

        ArrayList<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);

        method(list1);
        method(list2);
/*  泛型上下限测试，
        Collection<Integer> l1=new ArrayList<>();
        Collection<String> l2=new ArrayList<>();
        Collection<Number> l3=new ArrayList<>();
        Collection<Object> l4=new ArrayList<>();
        element1(l1);
        element1(l2);//与Number类型无关
        element1(l3);
        element1(l4);

        element2(l1);
        element2(l2);
        element2(l3);
        element2(l4);
*/
    }
    public static  void method(ArrayList<?> list){
        Iterator<?> it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

    }



    public static void element1(Collection<? extends Number> coll){}
    public static void element2(Collection<? super Number> coll){}

}
