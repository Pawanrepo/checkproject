public class exceptionp {

    public static void main(String[] args) {
        try{
            System.out.println(1);
           int i = 1;
           int j = i/0;
        }catch(Exception e){
        	System.out.println(2);
           e.printStackTrace();
          return;
        }
        System.out.println(3);
    }
}
