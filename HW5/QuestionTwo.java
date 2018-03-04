/*
 * Harris Dizdarevic
 * CISC. 3150
 * Homework 5: Question 2
 * http://www.usna.edu/Users/cs/wcbrown/courses/S11IC211/classes/L12/HW/Homework.html
 *
 * This code is just to check my answers if they are correct or not
 */

public class QuestionTwo{
    public static void main(String[] args){
        //1a
        Dog d = new Dog();
        System.out.println(d.call(3));

        //1b
        Object c = new Cat();
        System.out.println(c);

        //1c
        Object v = new Pet();
  //      System.out.println(v.call());

        //1d
        Pet p = new Pet();
        System.out.println(p);

        //1e
        Pet q = new Dog();
        System.out.println(q.call());

        //1f
        Cat t = new Cat();
        System.out.println(t.toString("Come here, kitty"));

        //1g
        Cat u = new Cat();
  //      System.out.println(u.call(3));

        //1h
        Dog e = new Dog();
        System.out.println(e.feet());

        //1i
        Pet r = new Dog();
        System.out.println(r.call(3));
    }
}

class Pet{
    public String call() {
        return "!!!";
    }

    public String feet() {
        return "four";
    }
}

class Dog extends Pet{
    public String call() {
        return "woof!";
    }

    public String toString() {
        return "I'm a dog, pet me!";
    }

    public String call(int k) {
        String s = "Woof";
        for(int i = 1; i < k; ++i)
            s += ", woof";
        return s + "!";
    }
}

class Cat extends Pet {
    public String call() {
     return "meow!";
    }

    public String toString(){
        return "I'm a cat, go away!";
    }

    public String toString(String b) {
        return b + "? ... " +
               "Don't waste my time.";
    }
}
