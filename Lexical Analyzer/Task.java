import static java.lang.System.*;
import java.util.*;
import java.util.regex.*;
import java.io.*;
public class Task{
    public static void main(String[] args){
        try{
            Scanner sc = new Scanner(new File("L2.txt"));
            out.println("Methods:");
            Pattern pattern = Pattern.compile("(public|private|final|protected){0,1}( static){0,1} (int|String|boolean|void|double|float) (?!main)([a-z][a-zA-Z]*)\\([a-zA-Z ,\\(\\)\\[\\]]*\\)");
            while(sc.hasNextLine()){
                String input = sc.nextLine();
                if(pattern.matcher(input).matches()){
                    Scanner ac = new Scanner(input);
                    String temp = ac.next();
                    String returnType;
                    if(temp.equals("public") || temp.equals("private") || temp.equals("final") || temp.equals("protected")){
                        temp = ac.next();
                        if(temp.equals("static")){
                            returnType = ac.next();
                        }else{
                            returnType = temp;
                        }
                    }else if(temp.equals("static")){
                        returnType = ac.next();
                    }else{
                        returnType = temp;
                    }
                    temp = ac.nextLine();
                    out.printf("%s, Return Type: %s%n", temp.trim(), returnType.trim());
                    ac.close();
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
public class A {
int x, int y;
public int add(int a, int b)
{ return a+b;
}
public static int subtract(int a, int b)
{ return a-b;
}
public void add()
{ return x+y;
}
public static void main(String [] args)
{ System.out.println(subtract(10,5)); A a=new A(); a.add(20,10);
}
}
Sample Output:
Methods: 
add(int a, int b), Return Type: int 
subtract(int a, int b), Return Type: int 
add(), Return Type: void 
*/
//� Asad