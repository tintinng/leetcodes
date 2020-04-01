package com.tintin.backtracking;

public class PatternMatch{
    public static void main(String[] args) {

    }
}

class Pattern {
    private boolean matched = false;
    private char[] pattern; // 正则表达式
    private int plen; // 正则表达式长度

    public Pattern(char[] pattern, int plen) {
        this.pattern = pattern;
        this.plen = plen;
    }

    public boolean match(char[] text, int tlen) { // 文本串及长度
        matched = false;
        rmatch(0, 0, text, tlen);
        return matched;
    }

    /**
     * 1、当前路径
     * 2、选择列表
     * 3、结束条件
     * @param ti：当前匹配的第ti个字符
     * @param pj：当前匹配的第pj个正则表达式字符
     * @param text：待匹配的字符串
     * @param tlen：待匹配的字符串长度
     */
    private void rmatch(int ti, int pj, char[] text, int tlen) {
        // 如果已经匹配了，就不要继续递归了
        if (matched) return;
        // 正则表达式到结尾了
        if (pj == plen) {
            // 文本串也到结尾了，则匹配成功
            if (ti == tlen) matched = true;
            return;
        }
        // *匹配任意个字符
        if (pattern[pj] == '*') {
            for (int k = 0; k <= tlen-ti; ++k) {
                // 选择 + 撤销选择
                rmatch(ti+k, pj+1, text, tlen);
            }
        }
        // ?匹配0个或者1个字符
        else if (pattern[pj] == '?') {
            rmatch(ti, pj+1, text, tlen);
            rmatch(ti+1, pj+1, text, tlen);
        }
        // 纯字符匹配才行
        else if (ti < tlen && pattern[pj] == text[ti]) {
            rmatch(ti+1, pj+1, text, tlen);
        }
    }
}
