void main() {
  var oranges = <Fruit>[];
  addApple(oranges);
  print(oranges);
  Orange.empty();
}
/**
 * 这被称作类型的协变，dart是非可靠的类型系统
 */
addApple(List<Fruit> fruits) {
  fruits.add(Apple());
}

class Fruit {}

class Orange extends Fruit {
  String? color;
  Orange.empty(){
    print("empty");
  }

  Orange(){
    print("Orange");
  }
}

class Apple extends Fruit {}
