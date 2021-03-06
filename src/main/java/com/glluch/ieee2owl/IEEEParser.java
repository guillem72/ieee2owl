package com.glluch.ieee2owl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang.StringUtils;

/**
 * Given the IEEE taxonomy in txt, return a list of terms.
 * @author Guillem LLuch Moll guillem72@gmail.com
 */
public class IEEEParser {

    private static final int DOTS_PER_LEVEL=4;
    private static ArrayList<Term> terms = new ArrayList<>();
    
    /**
     * Delete terms
     */
    public static void resetTerms(){
        terms = new ArrayList<>();
    }
    
    /**
     * From a list of raw lines, return an ArrayList of Terms.
     * @param lines raw lines from the text, one line could be, for example:
     * <em>"........information systems"</em>
     * @return a list of Terms. Note that if a terms apears in more than one brach, it will 
     * be returned as one term for each occurence.
     */
    public static ArrayList<Term> parse(List<String> lines) {
        if (!terms.isEmpty()) {
            return terms;
        }
        
       //HashMap <level, term> for each level, the last element seen
        HashMap<Integer,String> lasts=new  HashMap<>();
        lasts.put(-1, "IEEE");
        for (String line:lines){
            int level=level(line);
            String text=StringUtils.remove(line, '.').trim();
            Term t=new Term(text,level);
            lasts.put(level, text);
            t.setLine(line);
            t.setParent(lasts.get(level-1));
            terms.add(t);
            
        }
       
        return terms;
    }
    
    /**
     * Given a line, which represents a term, return their level.
     * @param line a raw line with their preciding dots.
     * @return an int represent the level in the hierachy.
     **/
    private static int level(String line){
      
        
       int dots=StringUtils.countMatches(line, ".");
        int level=dots/DOTS_PER_LEVEL;
        //System.out.println(line+" ------> "+level);
        return level;
    }
    
    /**
     * Offers a simple representacion of the terms found.
     *<strong> This method is only valid if parse was previously called.</strong>
     * @return an string showing a basic information of each term. It depends on 
     * the method toString2() in Terms. 
     * @see com.glluch.ieee2owl.Term
     */
    public static String toString2(){
        String res="[";
       Iterator it=terms.iterator();
          int i=0;
       while (it.hasNext()){
         if (i==20) {i=-1;}
           Term term=(Term) it.next();
           res+=term.toString2()+"\n";
         i++; 
       }
        return res+="]";
    }
}
