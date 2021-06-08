import 'dart:typed_data';

void main() {

  //dart int 无长度限制， 只有内存限制
  List<int> list =[];
  for (var i = 1; i < 100000; i++) {
    int a = 2147483647 * i;
    list.add(a);
  }
  print(list);


  //类似数组，固定length了；无法add；超过2147483647范围就变负的了
  Int32List data = Int32List(10);
  data[0] = 21474836470;
  print(data);
}
