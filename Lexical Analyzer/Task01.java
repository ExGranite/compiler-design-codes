import static java.lang.System.*;
import java.util.*;
import java.io.*;
public class Task01{
    public static void main(String[] args){
        try{
            Set<String> keys = new HashSet<String>();
            Set<String> matOps = new HashSet<String>();
            Set<String> logicOps = new HashSet<String>();
            Set<String> identifiers = new HashSet<String>();
            Set<String> numbers = new HashSet<String>();
            Set<String> others = new HashSet<String>();
            Set array[] = {keys, identifiers, matOps, logicOps, numbers, others};
            String index[] = {"Keywords", "Identifiers", "Math Operators", "Logical Operators", "Numerical Values", "Others"};
            
            Scanner sc = new Scanner(new File("L1.txt"));
            
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                
                splitS = line.split("\\s+");
                splitW = line.split("\\W");
                splitO = line.split("\\w+");
                
                for(String x: splitS){
                    temp1 = x.split(";")[0].split(",");
                    s.add(temp1[0]);
                }
                for(String x: splitW){
                    if(!x.equals("")){
                        w.add(x);
                    }
                }
                for(String x: splitO){
                    o.add(x);
                }
            }
            ListIterator<String> itrS = s.listIterator();
            while(itrS.hasNext()){
                String temp = itrS.next();
                if(isNum(temp)){
                    numbers.add(temp);
                }
            }
            
            ListIterator<String> itrW = w.listIterator();
            while(itrW.hasNext()){
                String temp = itrW.next();
                if(match(temp, keywords)){
                    keys.add(temp);
                } else if(!isNum(temp)){
                    identifiers.add(temp);
                }
            }
            
            ListIterator<String> itrO = o.listIterator();
            while(itrO.hasNext()){
                String temp = itrO.next().trim();
                if(match(temp, mathOp)){
                    matOps.add(temp);
                } else if(match(temp, logicOp)){
                    logicOps.add(temp);
                } else if((!temp.equals("")) && (!temp.equals(" ")) && (!temp.equals("."))){
                    temp1 = temp.split("");
                    for(String x: temp1){
                        others.add(x);
                    }
                }
            }
            
            int count = 0;
            for(Set x: array){
                Iterator<String> i = x.iterator();
                if(count==index.length-1){
                    out.printf("%s:", index[count]);
                    while(i.hasNext()){
                        out.printf(" %s", i.next());
                    }
                    out.println();
                }else{
                    out.printf("%s: %s", index[count], i.next());
                    while(i.hasNext()){
                        out.printf(", %s", i.next());
                    }
                    out.println();
                }
                count++;
            }
            sc.close();
        }catch(Exception e){
            err.println(e);
        }
    }
    
    static String keywords[] = {"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const", "continue", "default", "do", "double", "else", "extends", "false", "final", "finally", "float", "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native", "new", "null", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient", "true", "try", "void", "volatile", "while"};
    static String mathOp[] = {"+", "-", "*", "/", "%", "++", "--", "="};
    static String logicOp[] = {"!=", "==", "<=", ">=", "<", ">"};
    static String splitS[], splitW[], splitO[], temp1[], temp2[];
    static ArrayList<String> s = new ArrayList<String>();
    static ArrayList<String> w = new ArrayList<String>();
    static ArrayList<String> o = new ArrayList<String>();
    
    static boolean isNum(String a){
        try{
            double d = Double.parseDouble(a);
        }catch(NumberFormatException n){
            return false;
        }
        return true;
    }
    
    static boolean match(String a, String type[]){
        for(String x: type){
            if(x.equals(a)){
                return true;
            }
        }
        return false;
    }
}