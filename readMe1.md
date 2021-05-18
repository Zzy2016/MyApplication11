void main(List<String> arguments) {
  // print('Hello world!');
  // var t="123";
  //
  // print(t);

  // dynamic object
  // dynamic t1;
  // t1="123";
  // t1=123;
  // print(t1);

  // dynamic a;
  // Object b;
  //
  // a="";
  // b="";
  // print(a.length);
  // print(b.length)

  // say("123");

  // say1("123", "234","23");
  // enableFlags(bold: false,hidden: true);

  // Stream.fromFuture(future)

  yibu();
}

void yibu() {
  // async await
  //表示一个异步操作的最终完成或失败及其结果值的表示。用于处理异步操作的，异步处理成功就执行成功
  //的操作，异步处理失败就捕获操作或停止后续操作
  //一个Future只对应一个结果，成功或者失败。Future的返回值仍然时一个Future对象
  Future.delayed(new Duration(seconds: 2), () {
    return "hi !";
  }).then((value) => print(value));

  Future.delayed(new Duration(seconds: 2), () {
    throw AssertionError("Error");
  }).then((value) => print(value)).catchError((e) {
    print(e);
  });

  // Future
//  then
//  catchError
//  whenComplete
//  wait 接受一个Future数组参数，只有数组中所有Future都执行成功后，才会出发then的成功回调
  Future.wait([
    Future.delayed(new Duration(seconds: 2), () {
      return "Hello";
    }),
    Future.delayed(new Duration(seconds: 4), () {
      return "world";
    })
  ]).then((value) => print(value)).catchError((e) => print(e));

  // Async/await

  // login().then((value){
  //   getUserInfo().then((value){
  //    saveUserInfo().then((value) => null)
  //   });
  // });

  /*消除 Callback Hell*/
  // login()
  //     .then((value) {
  //       return getUserInfo();
  //     })
  //     .then((value) {
  //       return saveUserInfo();
  //     })
  //     .then((value) => print("123"))
  //     .catchError((e) => {print(e)});



}

Future<String> login() {}

Future<String> getUserInfo() {}

Future<String> saveUserInfo() {}

//可选的命名参数
//调用函数时，可以使用指定命名参数
void enableFlags({bool bold, bool hidden}) {}

//可选的位置参数
String say1(String from, String msg, [String device]) {}

bool isEmpty() {}

//var 一旦赋值，类型确定，不能再改变其类型
//object是Dart所有对象的根基类。所有类型都是object的子类。任何类型的数据都可以赋值给Object对象。
//dynamic和var一样，声明的变量可以赋值任意对象，并且声明的变量类型可以在后期改变赋值类型
//dynamic声明的对象编译器会提供所有可能的组合
//object声明的对象只能使用object的属性和方法
//final const 常量
//final 只能被设置一次 final变量在第一次使用时被初始化
//const 变量是一个编译时常量

//函数也是对象
//
bool isNoble(int atomicNumber) {
  return true;
}

//函数声明没有显式声明返回值类型，会默认当作dynamic处理
bool isEmpty1() {
  return false;
}

//函数作为变量
var say = (str) {
  print(str);
};



import java.io.File

fun main() {
    //List<T> MutableList<T>
    //Map<T,V> MutableMap<T,V>
    //Set<T> MutableSet<T>


//    val numbers= listOf("1","2","3")
//
//    println("Number 2 --> ${numbers[2]}")
//    val numbers1= listOf("1","2","3")
//    println(numbers==numbers1)
    //list 元素可为空，可重复，如果两个list在相同位置有相同的元素，相等

//    var numbers2= mutableListOf("1","2")
//    println(numbers2)
//    numbers2.add("3")
//    println(numbers2)
//    numbers2.removeAt(2)
//    println(numbers2)

//    val numbers = mutableListOf(1, 2, 3, 4)
//    println(numbers)
//    numbers.add(5)
//    println(numbers)
//    numbers.removeAt(1) //1345
//    println(numbers)
//    numbers[0] = 0  //0345
//    println(numbers)
//    numbers.shuffle()
//    println(numbers)
//    numbers.shuffle()
//    println(numbers)
//    numbers.shuffle()
//    println(numbers)
//    var numbers= MutableList(4,{index: Int -> index*4  })
    //函数的最后一个参数是函数，那么作为相应参数传入的lambda表达式可以放在圆括号之外
//    var numbers= MutableList(4) { index: Int -> index * 4 }
//    print(numbers)


//    SET  无序  唯一
//    var set1= setOf(1,2,3)
//    println(set1.size)
//    val set2= setOf(3,2,1)
//    println(set1==set2)
//
//    println(set1.first())

    //Map
//    var map= mapOf("key1" to 1,"key2" to 2)
//    println(map)
//
//    var map1= mutableMapOf("key1" to 1,"key1" to 2,"key3" to 3)
//    println(map1)
//    map1["key4"] = 4
//    println(map1["key3"])

//    test()
//    test2()
//    test3()
//    test4()
//    test5()
//    testFilter()
//    plusOrMinus()
//    sliceTest()
//    getSingleElement()
//    paixu()
    listAbout()
}

//构造集合
//使用元素 listOf() mapOf() setOf()
//空集合  emptyList()  emptySet()  emptyMap()
//
fun test() {
    val test = List(3) { index -> index * 3 }
    println(test)

//    val sourceList= mutableListOf(1,2,3)
//
//    val copy=sourceList.toMutableList()
//
//    val readOnlyCopyList=sourceList.toList()

//    val source= mutableListOf(1,2,3)
//   val copySet=source.toMutableSet()
//    copySet.add(3)
//    copySet.add(4)
//    println(copySet)

//    val source= mutableListOf(1,2,3)
//    val reference:MutableList<Int> = source
//    source.add(4)
//    reference.add(5)
//    println(reference)

    //过滤
    var numbers = listOf(1, 2, 3, 4, 5)
    var numbersto = numbers.filter { it % 2 == 0 }
    println(numbersto)

    //映射
    val number1 = setOf(1, 2, 3)
    println(number1.map { it * 3 })
    println(number1.mapIndexed { index, value -> value * index })

    //关联
    val number2 = listOf(1, 2, 3, 4)
    println(number2.associateWith { it + 1 })

    val numbers3 = listOf("one", "two", "three", "four")
    println(numbers3.associateWith { it.length })


}

fun test2() {
//    val numbers= listOf("1","2","3","4")
//    var inter=numbers.iterator()
//    while (inter.hasNext()){
//        println(inter.next())
//    }
//    for(item in numbers){
//        println(item)
//    }

//    numbers.forEach{
//        println(it)
//    }
//    var iterator=numbers.listIterator()
//    while (iterator.hasNext()){
//        println(iterator.next())
//    }
//    var iteratorLast= numbers.

//    val numbers = listOf("one", "two", "three", "four")
//    val listIterator = numbers.listIterator()
//    while (listIterator.hasNext()) listIterator.next()
//    println("Iterating backwards:")
//    while (listIterator.hasPrevious()) {
//        print("Index: ${listIterator.previousIndex()}")
//        println(", value: ${listIterator.previous()}")
//    }

//    val numbers= mutableListOf("one","two","three","four")
//    val mutableIterator=numbers.iterator()
//    mutableIterator.next()
//    mutableIterator.remove()
//    println("After removal :$numbers")

    val numbers = mutableListOf("one", "two1", "three1")
    val mutableListIterator = numbers.listIterator()
    mutableListIterator.next()
    mutableListIterator.add("two")
    mutableListIterator.next()
    mutableListIterator.set("three")
    println(numbers)


}

//区间 数列
fun test3() {
    for(i in 1..4){
        println("i ---- > $i")
    }

    for(i in 1 until 4){
        println("i until --> $i ")
    }

    for(i in 10 downTo 0){
        println("i   ---->   $i  ")
    }

    if(2 in 1..4){

    } else{

    }



    if(5 !in 1..4){

    } else{

    }
    //区间
    //由两个端点值定义，这两个端点值都包含在该区间内。

    //数列
    //一个整数类型的区间可视为等差数列。
    //数列具有三个基本属性 first  last 和非零step

}

//序列 sequence
fun test4(){
    //序列构造
    //元素
//    var numberSequence= sequenceOf("four","three","two","one")
//    var iterator=numberSequence.iterator()
//    while (iterator.hasNext()){
//        println(iterator.next())
//    }

    //Iterable
//    val numbers= listOf("one","two","three","four")
//    val sequence1=numbers.asSequence()
//    println(sequence1)

    //函数
//    val oddNumbers= generateSequence(1){
//        println(it)
//        it+2
//    }
//    println(oddNumbers.take(5).toList())
//    val odd= generateSequence(1){if(it+2<10) it+2 else null}
//    println(odd)

//    由组块
//    val odd= sequence {
//        yield(1)
//        yieldAll(listOf(3,5))
//        yieldAll(generateSequence(7){it+2})
//    }
//    println(odd.take(5).toList())

//    val words = "The quick brown fox jumps over the lazy dog".split(" ")
//// 将列表转换为序列
//    val wordsSequence = words.asSequence()
//
//    val lengthsSequence = wordsSequence.filter { println("filter: $it"); it.length > 3 }
//        .map { println("length: ${it.length}"); it.length }
//        .take(4)
//
//    println("Lengths of first 4 words longer than 3 chars")
//// 末端操作：以列表形式获取结果。
//    println(lengthsSequence.toList())


//    val words = "The quick brown fox jumps over the lazy dog".split(" ")
//    val lengthsList = words.filter { println("filter: $it"); it.length > 3 }
//        .map { println("length: ${it.length}"); it.length }
//        .take(4)
//
//    println("Lengths of first 4 words longer than 3 chars:")
//    println(lengthsList)

    val number= listOf("one","two","three","four")
//    number.filter {
//        it.length>3
//    }
//    println(number.filter {
//        it.length>3
//    })

    var a= mutableListOf<String>()
    number.filterTo(a){it.length>3}
    println("a -- $a")
    //
}

fun test5(){
    //集合转换 映射 合拢 关联 打平 字符串表示
    //映射  map mapIndexed
    //映射转换从另一个集合的元素上的函数结果创建一个集合
//    val numbers= setOf(1,2,3)
//    println(numbers.map { it*3 })
//    println(numbers.mapIndexed { index, i -> index*i })

//    val number= setOf(1,2,3)
//    println(number.mapNotNull { if(it==2) null else it*3 })
//    println(number.map { if(it==2) null else it*3 })

//    val numberMap= mapOf("key1" to 1,"key2" to 2,"key3" to 3,"key4" to 4)
//    println(numberMap.mapKeys { it.key.toUpperCase() })
//    println(numberMap.mapValues { it.value*it.value })

    //合拢 根据两个集合中具有相同位置的元素构建配对
//    val colors= listOf("red","brown","grey")
//    val animal= listOf("fox","bear","wolf")
//    println(colors zip animal)
//    val two= listOf("fox","bear")
//    println(colors zip two)
//    var three=colors zip animal
//    println(three.unzip())

    //关联
    //关联转换允许从集合元素和与其关联的某些值构建map
    val numbers= listOf("one","two","three","four")
    //associateWith 创建一个map,其中原始集合的元素是键，并通过给定的转换函数从中产生值，如果两个元素相等，则仅最后一个保留在map中
//    println(numbers.associateWith { it.length })
    //associateBy 使用集合元素作为值来构建map
//    println(numbers.associateBy { it.first().toUpperCase() })
    //associate() map键和值都是通过集合元素产生
//    val names= listOf("Alice adams","Brian Brown","Clara campbell")
//    println(names.associate { name -> parseFullName(name).let})


    //打平
    //在一个集合的集合上调用，返回嵌套集合中的所有元素的list
//    val number1= listOf(setOf(1,2,3), setOf(4,5,6), setOf(7,8,9))
//    println(number1.flatten())

    //字符串表示
    val number2= listOf("one","two","three","four")
    println(number2)
    println(number2.joinToString())
}

fun testFilter(){
    //过滤
    //filter
    //filterIndexed
    //filterNot
    //filterIsInstance
    //filterNotNull

    val number= listOf("one","two","three","fo")
    //
    val (match,rest)=number.partition { it.length>2 }
    println(match)
    println(rest)

}

fun plusOrMinus(){


}

//分组
fun groupBy(){
    //分组 groupBY

}
//取集合的一部分
//slice  返回具有给定索引的集合元素列表。索引即可以是作为区间传入的也可以是作为整数值的集合传入的。
//take   从头开始获取指定数量的元素 takeLast 从尾获取指定数量的元素
//drop   dropLast 删除元素
//Chunked 将集合分解为给定大小的块。
//Windowed 检索给定大小的集合元素中所有可能区间。windowed() 返回从每个集合元素开始的元素区间（窗口）。 所有窗口都作为单个 List 的元素返回。
fun sliceTest(){
    var number= listOf("one","two","three","two","five")

    println(number.slice(setOf(3,4,0)))//slice 传入参数

    println(number.take(3))//[one, two, three]

    println(number.drop(2))//[three, two, five]

    println(number.chunked(3))  //[[one, two, three], [two, five]]

    println(number.windowed(3)) //[[one, two, three], [two, three, two], [three, two, five]]
}

//获取单个元素
fun getSingleElement(){
    val numbers= linkedSetOf("one","two","three","four","five","six")
    //按位置
    println(numbers.elementAt(3))

    val numbers1= listOf("one","two","three","four","five","six")
    println(numbers1.first()+"   "+numbers1.last())


    //按条件取
    println(numbers1.first(){it.length>3})
    //find  firstOrNull
    //findLast lastOrNull
    println(" -- "+numbers1.find { it.length%2==0 })

    //随机取元素
    println(numbers1.random())

    //检测存在与否
    println(numbers1.contains("seven"))

    //检查集合中是否包含任何元素
    //isEmpty
    //isNotEmpty

    println(numbers1.isEmpty())
    println(numbers1.isNotEmpty())


}

fun paixu(){
    var numbers= listOf("one","two","three","four","five")
    //自然排序
    println(numbers.sorted())
    println(numbers.sortedDescending())

    //自定义
    //sortedBy
    //sortedByDescending


    //倒叙
    println(numbers.reversed())

    //随机顺序
    println(numbers.shuffled())
}



fun juhe(){
    //聚合 基于集合内容返回单个值的操作


}

//
fun write(){
//    add（）
//addAll()
//remove()
//removeAll()  移除参数集合中存在的所有元素。
//retainAll  它移除除参数集合中的元素之外的所有元素。
//clear   从列表中移除所有元素并将其置空。
}

fun listAbout(){
    val numbers= mutableListOf(1,2,3,4)
    //索引获取元素
    println(numbers.get(0))
    println(numbers.getOrNull(5))
    println(numbers.getOrElse(8,{it}))

    //取列表的一部分
    println("subList-->"+numbers.subList(0,2))


    //线性查找
    println(numbers.indexOf(3))
    println(numbers.lastIndexOf(3))

    //list添加
    numbers.add(5)
    numbers.add(5,6)
    println(numbers)

    //list 更新
    numbers[1]=100
    println(numbers)

    //list 删除
    numbers.removeAt(1)
    println(numbers)

    numbers.add(1,2)
    println("--"+numbers)

    //排序
    //sort()
    //sortDescending
    //sortBy
    println(numbers.sortBy { it })


//    union  //并集
//    intersect  //交集
//    subtract 差集
    var set1= setOf("one","two","three")
    println(set1)
    println(set1 union setOf("one"))


//    map
    var numberMap= mapOf("one" to 1,"two" to 2,"three" to 3)
    println(numberMap.get("one"))
    println(numberMap["one"])


    val filter=numberMap.filter { (key,value)-> key.endsWith("1")&&value>10 }
    println(filter)

    //plus minus
    numberMap+=Pair("Six",6)
    println(  numberMap+Pair("four",4))
    println(numberMap+ mapOf("five" to 5))


    numberMap-="two"
    println(numberMap)







}
