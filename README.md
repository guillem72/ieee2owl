# ieee2owl
Transform the IEEEtaxonomy from txt to rdf in java.

##Previous steps
This program needs the [IEEE taxonomy](http://www.ieee.org/documents/taxonomy_v101.pdf) 
in plain text. To did it, I have used [pdfbox](https://pdfbox.apache.org) and manually 
fixed some issues: 

- at the end of every page there was a tabular o other character and, 
- some lines have been joined. 
