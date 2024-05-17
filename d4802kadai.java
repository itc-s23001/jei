// s23001
// ポリフィズムの課題

//スーパークラスAnimalの定義
class Animal {
   public void makeSound() {
    System.out.println("動物の音");
}
   public void test(){
    System.out.println("テスト出力");
   }
}

//継承したサブクラスDogの定義
class Dog extends Animal {
    public void makeSound() {
      System.out.println("ワンワン");
    }
}

//継承したサブクラスCatの定義
class Cat extends Animal {
   public void makeSound() {
     System.out.println("ニャー");
   }
}

public class d4802kadai {
   public static void main(String[] args) {
     Animal a = new Dog(); //インスタンス化
     Animal b = new Cat();
     a.makeSound(); //どのような処理になるでしょう
     a.test(); //どのような処理になるでしょう
     b.makeSound();
     b.test();
   }
}
