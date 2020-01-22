public class Greetings {
    private String greeting;

    public Greetings() {}
    public Greetings(String greeting){
        this.greeting=greeting;
    }
    public void sayHello(){
        System.out.println(greeting);
    }
    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}
