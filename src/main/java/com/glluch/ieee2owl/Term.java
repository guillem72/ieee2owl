package com.glluch.ieee2owl;

import org.apache.commons.lang.StringUtils;

/**
 *
 * @author Guillem LLuch Moll guillem72@gmail.com
 */
public class Term {
    private String text;
    private String line;
    private final String code;
    private int level;
    private String parentCode;
    private String parent;

    public Term(String text, int level) {
        this.setText(text);
        this.code = StringUtils.replaceChars(this.text, " ", "_");
        this.level = level;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent.trim().toLowerCase();
        this.parentCode=StringUtils.replaceChars(this.parent, " ", "_");
    }

    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text.trim().toLowerCase();
    }

    public String getCode() {
        return code;
    }

   public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getParentCode() {
        return parentCode;
    }

    public String toString2(){
    return "text: "+text+", level: "+level+", parent: "+parent;
    }
    
    
}
