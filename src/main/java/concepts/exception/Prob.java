package concepts.exception;

public class Prob {

//if try or catch block contain System.exit() finally block will not be executed
    void whenFinallyBlockNotCalled(){
        try {
           System.exit(1);
        }finally {
            System.out.println("Finally block");
            return;
        }
    }


    public static void main(String[] args) {

    }
}
