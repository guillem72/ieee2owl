# ieee2owl
Transform the IEEEtaxonomy from txt to rdf in java.

##Previous steps
This program needs the [IEEE taxonomy](http://www.ieee.org/documents/taxonomy_v101.pdf) 
in plain text. To did it, I have used [pdfbox](https://pdfbox.apache.org) and manually 
fixed some issues: 

- at the end of every page there was a tabular o other character and, 
- some lines have been joined. 

## Installation and setup
Once you have the IEEE taxonomy ready in plain text, save it in *resources* directory. I have used *IEEE_computers_done_manual.txt* as filename. If you want another name, go to *Ieee2owl.java*, in the main method and change the first line,

  <code>File ieeeFile=new File("resources/IEEE_computers_acronyms_done_manual.txt");</code>

for 
  
  <code>File ieeeFile=new File(THE NAME OF YOUR FILE);</code>
