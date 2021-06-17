
class Singleton {
  Singleton._();

  factory Singleton.getInstance() => _instance;

  static final _instance = Singleton._();

}