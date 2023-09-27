import static java.lang.System.*;
import java.util.*;
import java.io.*;
public class Task{
    public static void main(String[] args){
        try{
            Scanner sc = new Scanner(new File("L1.txt"));
            int total = Integer.parseInt(sc.nextLine());
            for(int count = 1; count <= total; count++){
                String input = sc.nextLine();
                if(isEmail(input)){
                    out.printf("Email, %d", count);
                }else if(isWeb(input)){
                    out.printf("Web, %d", count);
                }else{
                    out.printf("None, %d", count);
                }
                out.println();
            }
            sc.close();
        }catch(Exception e){
            err.println(e);
        }
    }
    static boolean isEmail(String input){
        int state = 0;
        int lexeme = 0;
        while(lexeme < input.length()){
            char c = input.charAt(lexeme);
            switch(state){
                case 0:
                    if(match(c, Lalphabet) || match(c, Ualphabet)){
                        state = 1; lexeme++;
                    }else{
                        state = 6; lexeme++;
                    }
                    break;
                case 1:
                    if(match(c, Lalphabet) || match(c, Ualphabet) || match(c, num) || c == '.'){
                        state = 1; lexeme++;
                    }else if(c == '@'){
                        state = 2; lexeme++;
                    }else{
                        state = 6; lexeme++;
                    }
                    break;
                case 2:
                    if(match(c, Lalphabet) || match(c, Ualphabet)){
                        state = 3; lexeme++;
                    }else{
                        state = 6; lexeme++;
                    }
                    break;
                case 3:
                    if(match(c, Lalphabet) || match(c, Ualphabet)){
                        state = 3; lexeme++;
                    }else if(c == '.'){
                        state = 4; lexeme++;
                    }else{
                        state = 6; lexeme++;
                    }
                    break;
                case 4:
                    if(match(c, Lalphabet) || match(c, Ualphabet)){
                        state = 5; lexeme++;
                    }else{
                        state = 6; lexeme++;
                    }
                    break;
                case 5:
                    if(match(c, Lalphabet) || match(c, Ualphabet)){
                        state = 5; lexeme++;
                    }else if(c == '.'){
                        state = 4; lexeme++;
                    }else{
                        state = 6; lexeme++;
                    }
                    break;
                case 6:
                    lexeme++; break;
            }
        }
        if(state == 5){
            return true;
        }else{
            return false;
        }
    }
    static boolean isWeb(String input){
        int state = 0;
        int lexeme = 0;
        while(lexeme < input.length()){
            char c = input.charAt(lexeme);
            switch(state){
                case 0:
                    if(c == 'w'){
                        state = 1; lexeme++;
                    }else{
                        state = 8; lexeme++;
                    }
                    break;
                case 1:
                    if(c == 'w'){
                        state = 2; lexeme++;
                    }else{
                        state = 8; lexeme++;
                    }
                    break;
                case 2:
                    if(c == 'w'){
                        state = 3; lexeme++;
                    }else{
                        state = 8; lexeme++;
                    }
                    break;
                case 3:
                    if(c == '.'){
                        state = 4; lexeme++;
                    }else{
                        state = 8; lexeme++;
                    }
                    break;
                case 4:
                    if(match(c, Lalphabet) || match(c, Ualphabet) || match(c, num)){
                        state = 5; lexeme++;
                    }else{
                        state = 8; lexeme++;
                    }
                    break;
                case 5:
                    if(match(c, Lalphabet) || match(c, Ualphabet) || match(c, num)){
                        state = 5; lexeme++;
                    }else if(c == '.'){
                        state = 6; lexeme++;
                    }else{
                        state = 8; lexeme++;
                    }
                    break;
                case 6:
                    if(match(c, Lalphabet) || match(c, Ualphabet)){
                        state = 7; lexeme++;
                    }else{
                        state = 8; lexeme++;
                    }
                    break;
                case 7:
                    if(match(c, Lalphabet) || match(c, Ualphabet)){
                        state = 7; lexeme++;
                    }else if(c == '.'){
                        state = 6; lexeme++;
                    }else{
                        state = 8; lexeme++;
                    }
                    break;
                case 8:
                    lexeme++;
                    break;
            }
        }
        if(state == 7){
            return true;
        }else{
            return false;
        }
    }
    static char[] Lalphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    static char[] Ualphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    static char[] num = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    
    static boolean match(char a, char type[]){
        for(char x: type){
            if(x == a){
                return true;
            }
        }
        return false;
    }
}
/*
Sample Input:
7
adf.als@g.bracu.ac.bd
aAAdf@yahoo.com
www.ok.com
www.1235fajnfks.io
wwwabd@1234.
dakjs123@gmail.com
www.abada.gov.ru

Sample Output:
Email, 1 
Email, 2 
Web, 3 
Web, 4 
None, 5 
Email, 6 
Web, 7 
*/