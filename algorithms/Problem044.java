package algorithms;

import utility.Timer;

public class Problem044 {
    public static void main(String[] args) {
        Timer t = new Timer();
        t.start();
        /*
        System.out
                .println(isMatch(
                        "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb",
                        "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"));

        */
        System.out.println(isMatch("abbcccaaa", "abb*aa*"));
        t.end();
    }

    public static boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;
        int starIndex = -1;
        int iIndex = -1;
        int slength = s.length();
        int plength = p.length();

        while (i < slength) {
            if (j < plength && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                i++;
                j++;
            } else if (j < plength && p.charAt(j) == '*') {
                starIndex = j;
                iIndex = i;
                j++;
            } else if (starIndex != -1) {
                j = starIndex + 1;
                i = iIndex + 1;
                iIndex++;
            } else {
                return false;
            }
        }

        while (j < plength && p.charAt(j) == '*') {
            j++;
        }

        return j == plength;
    }

    public static boolean isMatchMine(String s, String p) {
        return isMatchRecurse(s, p, 0, 0, s.length(), p.length());
    }

    private static boolean isMatchRecurse(String s, String p, int sStart, int pStart, int slength, int plength) {
        if (sStart == slength && pStart == plength)
            return true;
        else if (sStart >= slength) {
            //if our string is done then there must only be '*'s remaining to match
            for (int i = pStart; i < plength; i++) {
                if (p.charAt(i) != '*')
                    return false;
            }
            return true;
        } else if (pStart >= plength)
            return false;

        char pchar = p.charAt(pStart);
        if (pchar == '*') {
            //consecutive asterisks don't mean anything so jump over them
            int pjump = 0;
            for (int i = pStart + 1; i < plength; i++) {
                if (p.charAt(i) == '*')
                    pjump++;
                else
                    break;
            }
            int next = pStart + 1 + pjump;
            char pnext = 'p';
            if (next < plength) {
                pnext = p.charAt(next);
            }

            for (int i = 0; i < (slength - sStart + 1); i++) {
                if (pnext == '?' || sStart + i == slength || (next < plength && pnext == s.charAt(sStart + i))) {
                    if (isMatchRecurse(s, p, sStart + i, pStart + 1 + pjump, slength, plength))
                        return true;
                }
            }
            return false;
        } else if (pchar == '?' || pchar == s.charAt(sStart)) {
            return isMatchRecurse(s, p, sStart + 1, pStart + 1, slength, plength);
        } else
            return false;
    }
}
