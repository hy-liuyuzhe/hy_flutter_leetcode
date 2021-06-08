void main() {
  print(isBool());
  f(isBool());
  //报错，isNoble不是bool类型
  //test(isNoble);
  // future();
  var r = zone(
      (){
        return "123";
      }
  );
  print(r);
}

void future() {

  //并发拿数据并且串行拿结果；等所有结果完事，但出现error就不会执行then方法，但wait里的then还是会执行
  var start = DateTime.now().microsecondsSinceEpoch;
  print(start);
  Future.wait([
    Future.delayed(Duration(seconds: 1)).then((value){
      throw "man error";
      print("1");return "hello";
    }),
    Future.delayed(Duration(seconds: 2)).then((value){
      print("2");
      return "man";
    })
  ]).then((value) => print("then.v $value")).catchError((e){
    print("error.e $e");

    print((DateTime.now().microsecondsSinceEpoch - start)/1000/1000);
  }).whenComplete(() => print("complete"));
  // Stream.fromFutures([])和futrue.wait 一样，只不过其中一个异步事件拿到结果就返回，可以获取多次
}

R zone<R>(R body()){
  return body();
}

void f(bool b) {
  print(b);
}

isBool() {
  bool b = true;
  return b != null;
}

//-----------
typedef bool CALLBACK();

//不指定返回类型，此时默认为dynamic，不是bool
isNoble() {
  int atomicNumber = 0;
  return atomicNumber != null;
}

void test(CALLBACK cb){
  print(cb());
}
