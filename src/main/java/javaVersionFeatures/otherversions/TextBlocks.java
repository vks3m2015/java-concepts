package javaVersionFeatures.otherversions;


//Java 13 (preview) and made standard in Java 15
public class TextBlocks {

    public static void main(String[] arg){
        String json = """
                {
                    "name": "Alice",
                    "age": 30,
                    "admin": true
                }
                """;

        String jsonOld = "{\n" +
                "                    \"name\": \"Alice\",\n" +
                "                    \"age\": 30,\n" +
                "                    \"admin\": true\n" +
                "                }";


        System.out.println("jsonOld ===  "+jsonOld);
        System.out.println("json ===  "+json);

    }
}
