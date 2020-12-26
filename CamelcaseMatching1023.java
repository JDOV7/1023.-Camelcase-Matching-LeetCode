package leetcode;

import java.util.List;
import java.util.ArrayList;

public class CamelcaseMatching1023 {

    public void CamelcaseMatching1023() {
        String[] queries = {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
        String pattern = "FB";
        List<Boolean> lListStateText = new ArrayList();
        int iLowerPattern = counterLower(pattern);
        for (String query : queries) {
            if (iLowerPattern != counterLower(query)) {
                lListStateText.add(false);
                continue;
            }
            int iPositionLetterPattern = -1;
            StringBuffer sQuery = new StringBuffer(query);
            boolean bControl = true;
            for (int i = 0; i < pattern.length(); i++) {
                List<Integer> lListPositionsGoods = new ArrayList(searchPositionsGoods(query, iPositionLetterPattern, pattern.charAt(i)));
                if (lListPositionsGoods.size() != 0 && lListPositionsGoods.get(0) > iPositionLetterPattern) {
                    iPositionLetterPattern = lListPositionsGoods.get(0);
                    sQuery.replace(iPositionLetterPattern, iPositionLetterPattern + 1, "-");
                    query = sQuery.toString();
                } else {
                    bControl = false;
                    break;
                }
            }
            if (bControl) {
                lListStateText.add(bControl);
            } else {
                lListStateText.add(bControl);
            }
        }
        for (Boolean boolean1 : lListStateText) {
            System.out.println(boolean1);
        }
    }

    public int counterLower(String sValue) {
        int iReturnLowers = 0;
        for (char c : sValue.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                iReturnLowers++;
            }
        }
        return iReturnLowers;
    }

    public List<Integer> searchPositionsGoods(String sValue, int iPositionActually, char cLetter) {
        List<Integer> lListPositionsGoods = new ArrayList();
        for (int i = 0; i < sValue.length(); i++) {
            if (cLetter == sValue.charAt(i) && i > iPositionActually) {
                lListPositionsGoods.add(i);
            }
        }
        return lListPositionsGoods;
    }

}
