package javaVersionFeatures.otherversions;

//JAVA 14
public class EnhanceSwitch {

    public static int oldSwitch(String number) {
        int result;
        switch (number) {
            case "ONE":
                result = 1;
                break;
            case "TWO":
                result = 2;
                break;
            case "THREE":
                result = 3;
                break;
            default:
                result = -1;
                break;
        }
        return result;
    }

    public static int newSwitch(String number) {
        int result = switch (number) {
            case "ONE" -> 1;
            case "TWO" -> 2;
            case "THREE" -> 3;
            default -> -1;
        };
        return result;
    }

    public static int newSwitchMultiLine(String number) {
        int result = switch (number) {
            case "ONE" -> 1;
            case "TWO" -> {
                System.out.println("case TWO-- "+number);
                yield 2;
            }
            case "THREE" -> 3;
            default -> -1;
        };
        return result;
    }

    //null in switch
    void m(){
        String s = null;
        switch (s) {
            case null -> System.out.println("null case");
            case "A" -> System.out.println("A case");
            default -> System.out.println("default case");
        }
    }

    public static String newSwitchMultiCase(int value){
        String result = switch (value) {
            case 1, 2, 3 -> "Small";
            case 4, 5, 6 -> "Medium";
            default -> "Large";
        };
       return result;
    }



    public static void main(String[] arg){
        System.out.println("oldSwitch --- " + oldSwitch("TWO"));
        System.out.println("newSwitch --- " + newSwitch("TWO"));
        System.out.println("newSwitchMultiLine --- " + newSwitchMultiLine("TWO"));
        System.out.println("newSwitchMultiCase --- " + newSwitchMultiCase(2));
    }
}

//Java 21
//case labels can now match against the type of an object, not just constant values
class SwitchPatternMatching{

    static void m(){
        Object obj = "Hello";
        switch (obj) {
            case String s -> System.out.println("It's a String: " + s.toUpperCase());
            case Integer i -> System.out.println("It's an Integer: " + (i * 2));
            // A dedicated case null label allows for explicit handling of null values within the switch
            case null -> System.out.println("It's null");
            default -> System.out.println("Unknown type");
        }
    }

    //The when keyword allows adding further conditions to a type pattern
    static void guardedPattern(){
        Object obj = 10;
        switch (obj) {
            case Integer i when i > 0 -> System.out.println("Positive Integer: " + i);
            case Integer i -> System.out.println("Non-positive Integer: " + i);
            default -> System.out.println("Not an Integer");
        }
    }

    static void recordPattern(){
        record Point(int x, int y) {}
        Object obj = new Point(1, 2);
        switch (obj) {
            case Point(int x, int y) when x == y -> System.out.println("Point on diagonal: " + x);
            case Point(int x, int y) -> System.out.println("Point at: (" + x + ", " + y + ")");
            default -> System.out.println("Not a Point");
        }
    }

    static void describe(Object obj) {
        switch (obj) {
            case Person(String name, int age) ->
                    System.out.println("Person named " + name + " aged " + age);
            case null ->
                    System.out.println("It's null!");
            default ->
                    System.out.println("Unknown type");
        }
    }
}
