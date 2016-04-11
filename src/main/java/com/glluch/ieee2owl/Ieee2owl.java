package com.glluch.ieee2owl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Guillem LLuch Moll guillem72@gmail.com
 */
public class Ieee2owl {
    public static void main(String[] args) throws IOException {
        
        File ieeeFile=new File("resources/IEEE_computers_acronyms_done_manual.txt");
        List<String> lines=FileUtils.readLines(ieeeFile);
        ArrayList<Term> terms=IEEEParser.parse(lines);
        Term2owl to=new Term2owl();
        //System.out.println(to.toOwl(terms));
        to.write2owl(terms);
        //System.out.println(IEEEParser.toString2());
       
     
    }
}
