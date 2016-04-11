package com.glluch.ieee2owl;

import org.apache.commons.lang.StringUtils;

/**
 * An structure that encapsulates all the information of a term in the IEEE taxonomy.
 * @author Guillem LLuch Moll guillem72@gmail.com
 */
public class Term {
    private String text;
    private String line;
    private final String code;
    private int level;
    private String parentCode;
    private String parent;

    /**
     * Constructor
     * @param text The text of the term
     * @param level The level in the IEEE taxonomy
     */
    public Term(String text, int level) {
        this.setText(text);
        this.code = StringUtils.replaceChars(this.text, " ", "_");
        this.level = level;
    }

    /**
     * getter
     * @return the raw line as its apear in the doc
     */
    public String getLine() {
        return line;
    }

    /**
     * setter
     * @param line  the raw line as its apear in the doc
     */
    public void setLine(String line) {
        this.line = line;
    }

    /**
     * getter
     * @return the parent text
     */
    public String getParent() {
        return parent;
    }

    /**
     * setter
     * @param parent the text of the parent
     */
    public void setParent(String parent) {
        this.parent = parent.trim().toLowerCase();
        this.parentCode=StringUtils.replaceChars(this.parent, " ", "_");
    }

    /**
     * getter
     * @return the text of the term
     */
    public String getText() {
        return text;
    }

    /**
     * setter
     * @param text that will be trimed and lowered.
     */
    public void setText(String text) {
        this.text = text.trim().toLowerCase();
    }

    /**
     * getter
     * @return code the text with underscore instead of spaces.
     */
    public String getCode() {
        return code;
    }

    /**
     * getter
     * @return the level where the terms was found.
     */
    public int getLevel() {
        return level;
    }

    /**
     * setter
     * @param level the level in the branch where the term was found.
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * getter
     * @return the IRI of the code of the parent node.
     */
    public String getParentCode() {
        return parentCode;
    }

    /**
     * A convenient representation of the term.
     * @return the text, the level and the parent of a term.
     */
    public String toString2(){
    return "text: "+text+", level: "+level+", parent: "+parent;
    }
    
    
}
