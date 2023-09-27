import static java.lang.System.*;
import java.util.*;
import java.util.regex.*;
import java.io.*;
public class Task1{
    public static void main(String[] args){
        try{
            Scanner sc = new Scanner(new File("L1.txt"));
            int number = Integer.parseInt(sc.nextLine());
            String[] expression = new String[number];
            Pattern[] pattern = new Pattern[number];
            for(int count = 0; count < number; count++){
                expression[count] = sc.nextLine();
                pattern[count] = Pattern.compile(expression[count]);
            }
            int total = Integer.parseInt(sc.nextLine());
            for(int i = 1; i <= total; i++){
                String input = sc.nextLine();
                for(int count = 0; count < number; count++){
                    Matcher m = pattern[count].matcher(input);
                    if(m.matches()){
                        out.printf("Yes, %d%n", count+1);
                        break;
                    }
                    if(count == number-1){
                        out.printf("No, 0%n");
                    }
                }
            }
            sc.close();
        }catch(Exception e){
            err.println(e);
            //e.printStackTrace();
        }
    }
}
/*
Sample Input:
3
[a-c]{3}cab+(da)*f
db*a[^def]{2}gh
def[k-p]*p+
5
defkmnpmpp
acbcabbf
pqrstdd
dbaabggh
dbbbbamkgh

Sample Output:
YES, 3
YES, 1
NO, 0
NO, 0
YES, 2
*/
//� Asad