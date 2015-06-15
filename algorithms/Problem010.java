package algorithms;

public class Problem010 {

    public static void main(String[] args) {
        //System.out.println(isMatch("aab", "a*b"));
    }

    public static boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0)
            return true;
        else if (p.length() == 0)
            return false;

        char pc = p.charAt(0);
        if (p.length() > 1) {
            char pnext = p.charAt(1);
            if (pnext == '*') {
                String psub = p.substring(2);
                if (isMatch(s, psub))
                    return true;
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == pc || pc == '.') {
                        if (isMatch(s.substring(i + 1), psub))
                            return true;
                    } else
                        break;
                }
                return false;
            } else {
                //non asterisk after pc
                if (s.length() >= 1) {
                    if (s.charAt(0) == pc || pc == '.')
                        return isMatch(s.substring(1), p.substring(1));
                    else
                        return false;
                } else
                    return false;
            }
        } else {
            //last character of p
            if (s.length() == 1) {
                return (s.charAt(0) == pc || pc == '.');
            }
            return false;
        }
    }
}
