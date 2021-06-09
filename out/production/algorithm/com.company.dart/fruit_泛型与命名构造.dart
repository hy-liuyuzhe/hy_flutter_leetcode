void main() {
  var oranges = <Orange>[];
  addApple(oranges);
  print(oranges);

  //命名构造的对象是不会调用默认构造方法
  var orange = Orange.empty();
  print(orange.color);
}
/**
 * 这被称作类型的协变，dart是非可靠的类型系统
 * dart 允许子类集合直接传递到父类集合的形参中
 */
addApple(List<Fruit> fruits) {
  fruits.add(Apple());
}

class Fruit {}

class Orange extends Fruit {
  String color="red";
  Orange.empty(){
    print("empty");
  }

  Orange(){
    print("Orange");
  }
}

class Apple extends Fruit {}
