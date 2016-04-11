package com.glluch.ieee2owl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

/**
 * Write an ontology 2.0 from a list of terms.
 * @author Guillem LLuch Moll guillem72@gmail.com
 */
public class Term2owl {
    
    private ArrayList<String> insertedNodes = new ArrayList<>();
    private String introOntologyFilename="resources/ieeeTaxoOWL-start.owl";
    private String targetOntologyFilename="resources/ieee_taxo_v2.owl";
    
    /**
     * Write an ontology 2.0 from a list of terms.
     * @param ts The list of Terms to be transformed and written as an ontology (in owl 2.0 format)
     * @throws IOException if introOntology not found.
     */
    public void write2owl(ArrayList<Term> ts) throws IOException{
    String ontoText=toOwl(ts);
    File targetOntology=new File(targetOntologyFilename);
    FileUtils.write(targetOntology, ontoText);
    insertedNodes = new ArrayList<>();//reset
    }
    
    private String toOwl(ArrayList<Term> ts) throws IOException{
         String res;
         File introOntology=new File(introOntologyFilename);
         res=FileUtils.readFileToString(introOntology);
        for (Term t:ts){
            res+=owlFragment(t)+System.lineSeparator();
        }
        return res+"</Ontology>";
    }

    private String owlFragment(Term t) {
        String res;
        String nodeId = t.getCode();
        if (insertedNodes.contains(nodeId)) {
            res = partialAssertion(t);
        } else {
            res = assertion(t);
            insertedNodes.add(nodeId);
        }
        return res;
    }

    private String partialAssertion(Term t) {
        String res = "";
        String nodeId = t.getCode();
        String parentId = t.getParentCode();
        int level = t.getLevel();
        res += objectProperty(nodeId, parentId) + System.lineSeparator();
        res += dataProperty(nodeId, level) + System.lineSeparator();
        //dataProperty(String nodeId, int level)
        return res;
    }

    private String assertion(Term t) {
        String res = "";
        String node = t.getText();
        String nodeId = t.getCode();
        String parentId = t.getParentCode();
        int level = t.getLevel();
        res += classAssertion(nodeId) + System.lineSeparator();
        res += annotation(nodeId, node) + System.lineSeparator();
        res += objectProperty(nodeId, parentId) + System.lineSeparator();
        res += dataProperty(nodeId, level) + System.lineSeparator();
        //dataProperty(String nodeId, int level)
        return res;
    }

    private String classAssertion(String nodeId) {
        String res = "<ClassAssertion>    <Class IRI=\"#Term\"/>    <NamedIndividual IRI=\"#"
                + nodeId + "\"/></ClassAssertion> ";
        return res;
    }

    private String annotation(String nodeId, String node) {
        String res = "<AnnotationAssertion>";
        res += "    <AnnotationProperty abbreviatedIRI=\"rdfs:label\"/>";
        res += "    <IRI>#" + nodeId + "</IRI>";
        res += "    <Literal xml:lang=\"en\" datatypeIRI=\"&rdf;PlainLiteral\">" + node
                + "</Literal>  </AnnotationAssertion>";

        return res;
    }

    private String objectProperty(String nodeId, String parentId) {
        if (StringUtils.isEmpty(parentId)) {
            return "";
        }
        String res = "<ObjectPropertyAssertion>    <ObjectProperty IRI=\"#wide\"/>";
        res += "    <NamedIndividual IRI=\"#" + nodeId + "\"/>";
        res += "    <NamedIndividual IRI=\"#" + parentId + "\"/>";
        res += "</ObjectPropertyAssertion> ";
        return res;
    }

    private String dataProperty(String nodeId, int level) {
        String res = " <DataPropertyAssertion>"
                + "        <DataProperty IRI=\"#level\"/>"
                + "        <NamedIndividual IRI=\"#" + nodeId + "\"/>"
                + "        <Literal datatypeIRI=\"&xsd;int\">" + level + "</Literal>"
                + "    </DataPropertyAssertion>";
        return res;
    }

}
