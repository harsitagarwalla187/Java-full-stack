public class Arguments {
     public static void main(String[] args) {
          
          // System.out.println(args[0]);
          // System.out.println(args[1]);
          // System.out.println(args[2]);

          int l = args.length;
          int sum = 0;
          for(int i=0; i<l; i++) {
               sum += Integer.parseInt(args[i]);
          }

          System.out.println("Sum : " + sum);

     }
}