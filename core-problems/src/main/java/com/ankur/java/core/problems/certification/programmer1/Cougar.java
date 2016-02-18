package com.ankur.java.core.problems.certification.programmer1;

class Feline {
String type = "f ";
public Feline() {
System.out.print("feline ");
}
}
public class Cougar extends Feline {
public Cougar() {
System.out.print("cougar "); 
}
public static void main(String[] args) {
new Cougar().go();
}
void go() {
type = "c ";
System.out.print(this.type + super.type);
}
}