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
